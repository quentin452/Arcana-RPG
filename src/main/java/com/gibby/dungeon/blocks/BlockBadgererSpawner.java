

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityCrystalBadgerer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBadgererSpawner extends Block
{
    public BlockBadgererSpawner() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
    }

    public void onBlockDestroyedByPlayer(final World world, final int x, final int y, final int z, final int m) {
        if (!world.isRemote) {
            final EntityCrystalBadgerer badgerer = new EntityCrystalBadgerer(world);
            badgerer.setPosition(x, y, z);
            world.spawnEntityInWorld(badgerer);
            badgerer.onSpawnWithEgg(null);
            badgerer.setPosition(x, y, z);
        }
    }

    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        for (int i = 0; i < 1; ++i) {
            world.spawnParticle("portal", x + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Dungeons.randGauss(), Dungeons.randGauss(), Dungeons.randGauss(), Dungeons.randGauss());
        }
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }
}
