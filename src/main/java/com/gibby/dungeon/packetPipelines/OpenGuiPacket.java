

package com.gibby.dungeon.packetPipelines;

import com.gibby.dungeon.Dungeons;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class OpenGuiPacket extends AbstractPacket
{
    private int id;

    public OpenGuiPacket() {
    }

    public OpenGuiPacket(final int id) {
        this.id = id;
    }

    public void encodeInto(final ChannelHandlerContext ctx, final ByteBuf buffer) {
        buffer.writeInt(this.id);
    }

    public void decodeInto(final ChannelHandlerContext ctx, final ByteBuf buffer) {
        this.id = buffer.readInt();
    }

    public void handleClientSide(final EntityPlayer player) {
    }

    public void handleServerSide(final EntityPlayer player) {
        player.openGui(Dungeons.instance, this.id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
    }
}
