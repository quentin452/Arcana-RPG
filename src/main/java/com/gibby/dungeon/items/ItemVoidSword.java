

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemVoidSword extends ItemStandardVoidSword
{
    public ItemVoidSword(final Item.ToolMaterial p_i45356_1_, final int VoidDamage) {
        super(p_i45356_1_, VoidDamage);
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer entity = (EntityPlayer)par3Entity;
            if (entity.getCurrentEquippedItem() == par1ItemStack) {
                entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1));
                entity.addPotionEffect(new PotionEffect(Potion.jump.id, 1, 1));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_BLUE + "Adds Speed II and Jump Boost II");
        par3List.add(EnumChatFormatting.DARK_BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
