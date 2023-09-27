

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockRubyOre extends BlockOre
{
    public BlockRubyOre() {
        this.setCreativeTab(Dungeons.Blocks);
        this.setHardness(8.0f);
        this.setResistance(16.0f);
        this.setHarvestLevel("pickaxe", 3);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.ruby;
    }
}
