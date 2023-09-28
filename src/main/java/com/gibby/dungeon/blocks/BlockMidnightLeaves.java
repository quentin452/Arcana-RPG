package com.gibby.dungeon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockMidnightLeaves extends Block
{
    public BlockMidnightLeaves() {
        super(Material.leaves);
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockMidnightLeaves.soundTypeGrass);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }
}
