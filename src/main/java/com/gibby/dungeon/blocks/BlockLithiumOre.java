

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;

public class BlockLithiumOre extends BlockOre
{
    public BlockLithiumOre() {
        this.setHarvestLevel("pickaxe", 4);
        this.setHardness(10.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
    }
}
