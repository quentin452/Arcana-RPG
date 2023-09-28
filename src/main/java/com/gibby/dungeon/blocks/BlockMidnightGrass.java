package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockMidnightGrass extends Block
{
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public BlockMidnightGrass() {
        super(Material.grass);
        this.setHarvestLevel("shovel", 0);
        this.setStepSound(BlockMidnightGrass.soundTypeGrass);
        this.setHardness(1.5f);
        this.setResistance(3.0f);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(Dungeons.midnightDirt);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister reg) {
        (this.icons = new IIcon[6])[0] = reg.registerIcon(this.textureName + "_" + "bottom");
        this.icons[1] = reg.registerIcon(this.textureName + "_" + "top");
        for (int i = 2; i <= 5; ++i) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + "side");
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[side];
    }
}
