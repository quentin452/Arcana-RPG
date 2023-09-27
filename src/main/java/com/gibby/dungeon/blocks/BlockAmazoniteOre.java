

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockAmazoniteOre extends BlockOre
{
    public BlockAmazoniteOre() {
        this.setCreativeTab(Dungeons.Blocks);
        this.setHardness(6.0f);
        this.setResistance(10.0f);
        this.setHarvestLevel("pickaxe", 2);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.amazonite;
    }
}
