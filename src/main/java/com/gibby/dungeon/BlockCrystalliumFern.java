

package com.gibby.dungeon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockCrystalliumFern extends BlockDoublePlant
{
    private IIcon[] doublePlantIcons;

    public BlockCrystalliumFern() {
        this.doublePlantIcons = new IIcon[2];
        this.setHardness(0.3f);
    }

    protected boolean canPlaceBlockOn(final Block p_149854_1_) {
        return p_149854_1_ == Dungeons.crystalliumGrass;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return this.doublePlantIcons[0];
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_149888_a(final boolean p_149888_1_, final int p_149888_2_) {
        return p_149888_1_ ? this.doublePlantIcons[1] : this.doublePlantIcons[0];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister reg) {
        this.sunflowerIcons = new IIcon[2];
        this.doublePlantIcons[0] = reg.registerIcon(this.textureName + "_" + "bottom");
        this.doublePlantIcons[1] = reg.registerIcon(this.textureName + "_" + "top");
        this.sunflowerIcons[0] = reg.registerIcon(this.textureName + "_" + "bottom");
        this.sunflowerIcons[1] = reg.registerIcon(this.textureName + "_" + "top");
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final Item p_149666_1_, final CreativeTabs p_149666_2_, final List p_149666_3_) {
        p_149666_3_.add(new ItemStack(p_149666_1_));
    }
}
