package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityFirefly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFireflyStone extends Block
{
    public BlockFireflyStone() {
        super(Material.rock);
        this.setCreativeTab(Dungeons.Blocks);
        this.setHardness(0.3f);
    }

    public void onBlockDestroyedByPlayer(final World world, final int x, final int y, final int z, final int meta) {
        if (!world.isRemote) {
            for (int i = 0; i < 10; ++i) {
                final EntityFirefly firefly = new EntityFirefly(world);
                firefly.setPosition(x, y, z);
                world.spawnEntityInWorld(firefly);
                firefly.onSpawnWithEgg(null);
                firefly.setPosition(x, y,z);
            }
        }
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }
}
