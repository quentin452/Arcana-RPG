

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import com.gibby.dungeon.*;
import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.relauncher.*;

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
