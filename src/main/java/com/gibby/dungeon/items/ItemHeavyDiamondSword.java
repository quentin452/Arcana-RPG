

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import org.lwjgl.opengl.GL11;

public class ItemHeavyDiamondSword extends ItemSword
{
    public ItemHeavyDiamondSword(final Item.ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setFull3D();
        this.setCreativeTab(Dungeons.Weapons);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(this.getIconString());
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
}
