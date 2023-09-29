package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockUnbreakableStoneBrick extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150007_M;
    public BlockUnbreakableStoneBrick()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setHardness(-1f);
        setResistance(2000f);
    }


    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Dungeons.blockUnbreableStonebrick);
    }
}
