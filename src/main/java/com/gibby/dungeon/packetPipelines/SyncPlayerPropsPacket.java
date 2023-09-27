

package com.gibby.dungeon.packetPipelines;

import com.gibby.dungeon.DungeonsExtendedPlayer;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

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
