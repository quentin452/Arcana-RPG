

package packetPipelines;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import cpw.mods.fml.common.network.*;

public class SyncPlayerPropsPacket extends AbstractPacket
{
    private NBTTagCompound data;
    
    public SyncPlayerPropsPacket() {
    }
    
    public SyncPlayerPropsPacket(final EntityPlayer player) {
        this.data = new NBTTagCompound();
        DungeonsExtendedPlayer.get(player).saveNBTData(this.data);
    }
    
    public void encodeInto(final ChannelHandlerContext ctx, final ByteBuf buffer) {
        ByteBufUtils.writeTag(buffer, this.data);
    }
    
    public void decodeInto(final ChannelHandlerContext ctx, final ByteBuf buffer) {
        this.data = ByteBufUtils.readTag(buffer);
    }
    
    public void handleClientSide(final EntityPlayer player) {
        DungeonsExtendedPlayer.get(player).loadNBTData(this.data);
    }
    
    public void handleServerSide(final EntityPlayer player) {
    }
}
