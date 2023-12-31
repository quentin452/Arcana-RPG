

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockOre;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAmethystStone extends BlockOre
{   @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote && random.nextInt(20) == 0) {
            final EntityFlameFX particle = new EntityFlameFX(world, x + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Dungeons.randGauss(), Dungeons.randFloat() * 0.1, Dungeons.randFloat() * 0.1, Dungeons.randFloat() * 0.1);
            particle.setRBGColorF(0.1f, 0.0f, 1.0f);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
        }
    }
}
