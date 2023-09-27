

package com.gibby.dungeon.proxy.packetPipelines;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public abstract class AbstractPacket
{
    public abstract void encodeInto(final ChannelHandlerContext p0, final ByteBuf p1);

    public abstract void decodeInto(final ChannelHandlerContext p0, final ByteBuf p1);

    public abstract void handleClientSide(final EntityPlayer p0);

    public abstract void handleServerSide(final EntityPlayer p0);
}
