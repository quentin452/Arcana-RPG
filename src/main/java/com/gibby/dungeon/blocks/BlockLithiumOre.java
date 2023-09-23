

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import com.gibby.dungeon.*;

public class BlockLithiumOre extends BlockOre
{
    public BlockLithiumOre() {
        this.setHarvestLevel("pickaxe", 4);
        this.setHardness(10.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
    }
}
