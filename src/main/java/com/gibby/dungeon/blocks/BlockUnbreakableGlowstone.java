package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockUnbreakableGlowstone extends BlockGlowstone
{
    public BlockUnbreakableGlowstone()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setHardness(-1f);
        setResistance(2000f);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Dungeons.blockUnbreableGlowstone);
    }
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(x, y, z, x+1, y+1, z+1).contract(0.25F, 0.25F, 0.25F);
    }


}
