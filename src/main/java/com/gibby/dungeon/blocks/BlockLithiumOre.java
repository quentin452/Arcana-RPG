

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockLithiumOre extends BlockOre
{
    public BlockLithiumOre() {
        this.setHarvestLevel("pickaxe", 4);
        this.setHardness(10.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
        OreDictionary.registerOre("Lithium", new ItemStack(Dungeons.lithiumOre));
    }
}
