package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockUnbreakableStoneStairs extends BlockStairs
{    public final Block field_150149_b;
    private final int field_150151_M;
    public BlockUnbreakableStoneStairs(Block p_i45428_1_, int p_i45428_2_) {
        super(p_i45428_1_, p_i45428_2_);
        this.field_150149_b = p_i45428_1_;
        this.field_150151_M = p_i45428_2_;
        setHardness(-1f);
        setResistance(2000f);
    }


    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Dungeons.blockUnbreableStone_brick_stairs);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.field_150149_b.getIcon(p_149691_1_, this.field_150151_M);
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {}
}
