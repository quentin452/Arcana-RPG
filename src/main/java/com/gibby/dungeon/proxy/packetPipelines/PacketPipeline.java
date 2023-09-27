

package com.gibby.dungeon.proxy.packetPipelines;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;

import java.util.*;

@ChannelHandler.Sharable
public class PacketPipeline extends MessageToMessageCodec<FMLProxyPacket, AbstractPacket>
{
    private EnumMap<Side, FMLEmbeddedChannel> channels;
    private final LinkedList<Class<? extends AbstractPacket>> packets;
    private boolean isPostInitialised;

    public PacketPipeline() {
        this.packets = new LinkedList<>();
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

    protected void encode(final ChannelHandlerContext ctx, final AbstractPacket msg, final List<Object> out) {
        final ByteBuf buffer = Unpooled.buffer();
        final Class<? extends AbstractPacket> clazz = msg.getClass();
        if (!this.packets.contains(msg.getClass())) {
            throw new NullPointerException("No Packet Registered for: " + msg.getClass().getCanonicalName());
        }
        final byte discriminator = (byte)this.packets.indexOf(clazz);
        buffer.writeByte(discriminator);
        msg.encodeInto(ctx, buffer);
        final FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
        out.add(proxyPacket);
    }

    protected void decode(final ChannelHandlerContext ctx, final FMLProxyPacket msg, final List<Object> out) throws Exception {
        final ByteBuf payload = msg.payload();
        final byte discriminator = payload.readByte();
        final Class<? extends AbstractPacket> clazz = this.packets.get(discriminator);
        if (clazz == null) {
            throw new NullPointerException("No packet registered for discriminator: " + discriminator);
        }
        final AbstractPacket pkt = clazz.newInstance();
        pkt.decodeInto(ctx, payload.slice());
        switch (FMLCommonHandler.instance().getEffectiveSide()) {
            case CLIENT: {
                final EntityPlayer player = this.getClientPlayer();
                pkt.handleClientSide(player);
                break;
            }
            case SERVER: {
                final INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
                final EntityPlayer player = ((NetHandlerPlayServer)netHandler).playerEntity;
                pkt.handleServerSide(player);
                break;
            }
        }
        out.add(pkt);
    }

    public void initialise() {
        this.channels = NetworkRegistry.INSTANCE.newChannel("TUT", this);
        this.registerPackets();
    }

    public void registerPackets() {
        this.registerPacket(OpenGuiPacket.class);
        this.registerPacket(SyncPlayerPropsPacket.class);
    }

    public void postInitialise() {
        if (this.isPostInitialised) {
            return;
        }
        this.isPostInitialised = true;
        Collections.sort(this.packets, (clazz1, clazz2) -> {
            int com = String.CASE_INSENSITIVE_ORDER.compare(clazz1.getCanonicalName(), clazz2.getCanonicalName());
            if (com == 0) {
                com = clazz1.getCanonicalName().compareTo(clazz2.getCanonicalName());
            }
            return com;
        });
    }

    @SideOnly(Side.CLIENT)
    private EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    public void sendToAll(final AbstractPacket message) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }

    public void sendTo(final AbstractPacket message, final EntityPlayerMP player) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }

    public void sendToAllAround(final AbstractPacket message, final NetworkRegistry.TargetPoint point) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }

    public void sendToDimension(final AbstractPacket message, final int dimensionId) {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimensionId);
        this.channels.get(Side.SERVER).writeAndFlush(message);
    }

    public void sendToServer(final AbstractPacket message) {
        this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        this.channels.get(Side.CLIENT).writeAndFlush(message);
    }
}
