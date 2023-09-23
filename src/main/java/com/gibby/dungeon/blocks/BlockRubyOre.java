

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import com.gibby.dungeon.*;
import java.util.*;
import net.minecraft.item.*;

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
