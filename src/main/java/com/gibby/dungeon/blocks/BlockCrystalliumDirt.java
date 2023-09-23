

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import com.gibby.dungeon.*;

public class BlockCrystalliumDirt extends Block
{
    public BlockCrystalliumDirt() {
        super(Material.grass);
        this.setHarvestLevel("shovel", 0);
        this.setStepSound(BlockCrystalliumDirt.soundTypeGrass);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        if (this == Dungeons.crystalliumGrass) {
            return Item.getItemFromBlock(Dungeons.crystalliumDirt);
        }
        return Item.getItemFromBlock(Dungeons.crystalDirt);
    }
}
