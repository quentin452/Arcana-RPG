

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockBedrockOre extends BlockOre
{
    public BlockBedrockOre() {
        this.setHarvestLevel("pickaxe", 4);
        this.setHardness(10.0f);
        this.setResistance(30.0f);
        this.setCreativeTab(Dungeons.Blocks);
        OreDictionary.registerOre("Bedrock", new ItemStack(Dungeons.bedrockOre));
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Dungeons.bedrock;
    }
}
