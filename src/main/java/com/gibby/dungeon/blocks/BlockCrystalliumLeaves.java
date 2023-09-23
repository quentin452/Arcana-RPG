

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockCrystalliumLeaves extends Block
{
    public BlockCrystalliumLeaves() {
        super(Material.leaves);
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockCrystalliumLeaves.soundTypeGrass);
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
