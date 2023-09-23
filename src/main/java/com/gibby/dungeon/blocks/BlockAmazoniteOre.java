

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import com.gibby.dungeon.*;
import java.util.*;
import net.minecraft.item.*;

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
