

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockMagiRockOre extends BlockOre
{
    public BlockMagiRockOre() {
        this.setHarvestLevel("pickaxe", 5);
        this.setHardness(13.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
        this.setLightLevel(0.5f);
        OreDictionary.registerOre("MagiRock", new ItemStack(Dungeons.magirockOre));
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.magirockCrystal;
    }

    public int quantityDropped(final Random rand) {
        return rand.nextInt(3) + 1;
    }
}
