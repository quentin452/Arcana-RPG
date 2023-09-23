

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemAmethystLance extends ItemStandardMagicSword
{
    public ItemAmethystLance(final Item.ToolMaterial p_i45356_1_, final int MagicDamage) {
        super(p_i45356_1_, MagicDamage);
    }
    
    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
        par3EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 0));
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magic Damage");
        par3List.add(EnumChatFormatting.DARK_BLUE + "Slows enemies and applies speed to you on hit");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
