

package com.gibby.dungeon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMidnightPortalSpawner extends Block
{
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote) {
            for (int i = 0; i < 10; ++i) {
                final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(world, x + 0.5 + Dungeons.randGauss() / 2.0, y + 0.5 + Dungeons.randGauss(), z + 0.5 + Dungeons.randGauss() / 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.0f, 0.0f, 1.0f);
                particle.setFadeColour(0);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    protected BlockMidnightPortalSpawner() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }
}
