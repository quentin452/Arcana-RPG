

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;

public class BlockAmethystStone extends BlockOre
{
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote && random.nextInt(20) == 0) {
            final EntityFlameFX particle = new EntityFlameFX(world, x + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Dungeons.randGauss(), Dungeons.randFloat() * 0.1, Dungeons.randFloat() * 0.1, Dungeons.randFloat() * 0.1);
            particle.setRBGColorF(0.1f, 0.0f, 1.0f);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
    }
}
