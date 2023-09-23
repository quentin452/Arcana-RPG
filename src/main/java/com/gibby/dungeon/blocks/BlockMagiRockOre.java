

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import com.gibby.dungeon.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockMagiRockOre extends BlockOre
{
    public BlockMagiRockOre() {
        this.setHarvestLevel("pickaxe", 5);
        this.setHardness(13.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
        this.setLightLevel(0.5f);
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.magirockCrystal;
    }
    
    public int quantityDropped(final Random rand) {
        return rand.nextInt(3) + 1;
    }
}
