

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockSilverOre extends BlockOre
{
    public BlockSilverOre() {
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(8.0f);
        this.setResistance(16.0f);
        this.setCreativeTab(Dungeons.Blocks);
        OreDictionary.registerOre("Silver", new ItemStack(Dungeons.silverOre));
    }
}
