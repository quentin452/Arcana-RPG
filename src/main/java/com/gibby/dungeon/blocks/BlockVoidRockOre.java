

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockVoidRockOre extends BlockOre
{
    public BlockVoidRockOre() {
        this.setHarvestLevel("pickaxe", 5);
        this.setHardness(13.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.voidrockCrystal;
    }

    public int quantityDropped(final Random rand) {
        return rand.nextInt(3) + 1;
    }
}
