package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockMidnightDirt extends Block
{
    public BlockMidnightDirt() {
        super(Material.grass);
        this.setHarvestLevel("shovel", 0);
        this.setStepSound(BlockMidnightDirt.soundTypeGrass);
        this.setHardness(1.5f);
        this.setResistance(3.0f);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(Dungeons.midnightDirt);
    }
}
