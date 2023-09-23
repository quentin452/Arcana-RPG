

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import com.gibby.dungeon.*;

public class BlockNetherSteelOre extends BlockOre
{
    public BlockNetherSteelOre() {
        this.setHarvestLevel("pickaxe", 6);
        this.setHardness(15.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
    }
}
