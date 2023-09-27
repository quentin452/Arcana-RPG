

package com.gibby.dungeon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockCrystalliumStairs extends BlockStairs
{
    protected BlockCrystalliumStairs(final Block p_i45428_1_, final int p_i45428_2_) {
        super(p_i45428_1_, p_i45428_2_);
        this.setHardness(10.0f);
        this.setResistance(15.0f);
        this.setHarvestLevel("pickaxe", 0);
    }
}
