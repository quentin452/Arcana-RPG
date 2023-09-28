package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockJadePeaches  extends Block
{
    public BlockJadePeaches() {
        super(Material.leaves);
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockJadePeaches.soundTypeGrass);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.peach;
    }

    public boolean isOpaqueCube() {
        return false;
    }
}
