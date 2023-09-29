package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockUnbreakableStoneSlab extends BlockSlab
{
    private IIcon field_150007_M;
    public BlockUnbreakableStoneSlab(boolean p_i45410_1_, Material p_i45410_2_) {
        super(p_i45410_1_, p_i45410_2_);
        setHardness(-1f);
        setResistance(2000f);
    }
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        int k = p_149691_2_ & 7;

        if (this.field_150004_a && (p_149691_2_ & 8) != 0)
        {
            p_149691_1_ = 1;
        }

        return k == 0 ? (p_149691_1_ != 1 && p_149691_1_ != 0 ? this.field_150007_M : this.blockIcon) : (k == 1 ? Blocks.sandstone.getBlockTextureFromSide(p_149691_1_) : (k == 2 ? Blocks.planks.getBlockTextureFromSide(p_149691_1_) : (k == 3 ? Blocks.cobblestone.getBlockTextureFromSide(p_149691_1_) : (k == 4 ? Blocks.brick_block.getBlockTextureFromSide(p_149691_1_) : (k == 5 ? Blocks.stonebrick.getIcon(p_149691_1_, 0) : (k == 6 ? Blocks.nether_brick.getBlockTextureFromSide(1) : (k == 7 ? Blocks.quartz_block.getBlockTextureFromSide(p_149691_1_) : this.blockIcon)))))));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(Dungeons.MODID + ":unbreakable_stone_slab_top");
        this.field_150007_M = p_149651_1_.registerIcon(Dungeons.MODID + ":unbreakable_stone_slab_side");
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Dungeons.blockUnbreableStone_slab);
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return null;
    }
}
