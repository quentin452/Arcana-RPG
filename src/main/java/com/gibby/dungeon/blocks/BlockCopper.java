

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import com.gibby.dungeon.*;

public class BlockCopper extends BlockOre
{
    public BlockCopper() {
        this.setCreativeTab(Dungeons.Blocks);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(4.0f);
        this.setResistance(10.0f);
    }
}
