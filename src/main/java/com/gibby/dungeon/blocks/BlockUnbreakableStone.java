package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockUnbreakableStone extends Block
{
    public BlockUnbreakableStone()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setHardness(-1f);
        setResistance(2000f);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Dungeons.blockUnbreableStone);
    }
}
