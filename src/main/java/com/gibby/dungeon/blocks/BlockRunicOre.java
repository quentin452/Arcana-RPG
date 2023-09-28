package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockRunicOre extends BlockOre
{
    public BlockRunicOre() {
        this.setHarvestLevel("pickaxe", 7);
        this.setCreativeTab(Dungeons.Blocks);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.runeShard;
    }

    public int quantityDropped(final Random rand) {
        return 1;
    }
}
