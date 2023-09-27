

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

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
