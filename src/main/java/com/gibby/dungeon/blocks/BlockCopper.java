

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;

public class BlockCopper extends BlockOre
{
    public BlockCopper() {
        this.setCreativeTab(Dungeons.Blocks);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(4.0f);
        this.setResistance(10.0f);
    }
}
