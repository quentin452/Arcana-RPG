

package packetPipelines;

import io.netty.handler.codec.*;
import cpw.mods.fml.common.network.internal.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import cpw.mods.fml.common.*;
import net.minecraft.network.*;
import java.util.*;
import net.minecraft.client.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.network.*;
import net.minecraft.entity.player.*;

@ChannelHandler.Sharable
public class PacketPipeline extends MessageToMessageCodec<FMLProxyPacket, AbstractPacket>
{
    private EnumMap<Side, FMLEmbeddedChannel> channels;
    private LinkedList<Class<? extends AbstractPacket>> packets;
    private boolean isPostInitialised;
    
    public PacketPipeline() {
        this.packets = new LinkedList<Class<? extends AbstractPacket>>();
        this.isPostInitialised = false;
    }
    
    public boolean registerPacket(final Class<? extends AbstractPacket> clazz) {
        if (this.packets.size() > 256) {
            return false;
        }
        if (this.packets.contains(clazz)) {
            return false;
        }
        if (this.isPostInitialised) {
            return false;
        }
        this.packets.add(clazz);
        return true;
    }
    
    protected void encode(final ChannelHandlerContext ctx, final AbstractPacket msg, final List<Object> out) throws Exception {
        final ByteBuf buffer = Unpooled.buffer();
        final Class<? extends AbstractPacket> clazz = msg.getClass();
        if (!this.packets.contains(msg.getClass())) {
            throw new NullPointerException("No Packet Registered for: " + msg.getClass().getCanonicalName());
        }
        final byte discriminator = (byte)this.packets.indexOf(clazz);
        buffer.writeByte((int)discriminator);
        msg.encodeInto(ctx, buffer);
        final FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
        out.add(proxyPacket);
    }
    
    protected void decode(final ChannelHandlerContext ctx, final FMLProxyPacket msg, final List<Object> out) throws Exception {
        final ByteBuf payload = msg.payload();
        final byte discriminator = payload.readByte();
        final Class<? extends AbstractPacket> clazz = this.packets.get(discriminator);
        if (clazz == null) {
            throw new NullPointerException("No packet registered for discriminator: " + discriminator);
        }
        final AbstractPacket pkt = (AbstractPacket)clazz.newInstance();
        pkt.decodeInto(ctx, payload.slice());
        switch (FMLCommonHandler.instance().getEffectiveSide()) {
            case CLIENT: {
                final EntityPlayer player = this.getClientPlayer();
                pkt.handleClientSide(player);
                break;
            }
            case SERVER: {
                final INetHandler netHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
                final EntityPlayer player = (EntityPlayer)((NetHandlerPlayServer)netHandler).playerEntity;
                pkt.handleServerSide(player);
                break;
            }
        }
        out.add(pkt);
    }
    
    public void initialise() {
        this.channels = (EnumMap<Side, FMLEmbeddedChannel>)NetworkRegistry.INSTANCE.newChannel("TUT", new ChannelHandler[] { (ChannelHandler)this });
        this.registerPackets();
    }
    
    public void registerPackets() {
        this.registerPacket((Class<? extends AbstractPacket>)OpenGuiPacket.class);
        this.registerPacket(SyncPlayerPropsPacket.class);
    }
    
    public void postInitialise() {
        if (this.isPostInitialised) {
            return;
        }
        this.isPostInitialised = true;
        Collections.sort(this.packets, new Comparator<Class<? extends AbstractPacket>>() {
            @Override
            public int compare(final Class<? extends AbstractPacket> clazz1, final Class<? extends AbstractPacket> clazz2) {
                int com = String.CASE_INSENSITIVE_ORDER.compare(clazz1.getCanonicalName(), clazz2.getCanonicalName());
                if (com == 0) {
                    com = clazz1.getCanonicalName().compareTo(clazz2.getCanonicalName());
                }
                return com;
            }
        });
    }
    
    @SideOnly(Side.CLIENT)
    private EntityPlayer getClientPlayer() {
        return (EntityPlayer)Minecraft.getMinecraft().thePlayer;
    }
    
    public void sendToAll(final AbstractPacket message) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((Object)FMLOutboundHandler.OutboundTarget.ALL);
        this.channels.get(Side.SERVER).writeAndFlush((Object)message);
    }
    
    public void sendTo(final AbstractPacket message, final EntityPlayerMP player) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((Object)FMLOutboundHandler.OutboundTarget.PLAYER);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set((Object)player);
        this.channels.get(Side.SERVER).writeAndFlush((Object)message);
    }
    
    public void sendToAllAround(final AbstractPacket message, final NetworkRegistry.TargetPoint point) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((Object)FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set((Object)point);
        this.channels.get(Side.SERVER).writeAndFlush((Object)message);
    }
    
    public void sendToDimension(final AbstractPacket message, final int dimensionId) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((Object)FMLOutboundHandler.OutboundTarget.DIMENSION);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set((Object)dimensionId);
        this.channels.get(Side.SERVER).writeAndFlush((Object)message);
    }
    
    public void sendToServer(final AbstractPacket message) {
        this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((Object)FMLOutboundHandler.OutboundTarget.TOSERVER);
        this.channels.get(Side.CLIENT).writeAndFlush((Object)message);
    }
}
