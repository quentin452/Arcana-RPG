package com.gibby.dungeon.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockMidnightFence extends BlockFence
{
    public BlockMidnightFence(final String p_i45406_1_, final Material p_i45406_2_) {
        super(p_i45406_1_, p_i45406_2_);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon(this.textureName);
    }
}
