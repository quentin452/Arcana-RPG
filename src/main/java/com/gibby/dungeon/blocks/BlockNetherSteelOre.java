

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockNetherSteelOre extends BlockOre
{
    public BlockNetherSteelOre() {
        this.setHarvestLevel("pickaxe", 6);
        this.setHardness(15.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
        OreDictionary.registerOre("NetherSteel", new ItemStack(Dungeons.netherSteelOre));
    }
}
