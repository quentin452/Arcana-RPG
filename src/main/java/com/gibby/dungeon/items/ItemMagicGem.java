

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;

public class ItemMagicGem extends Item
{
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer && ((EntityPlayer)par3Entity).getCurrentEquippedItem() != null && ((EntityPlayer)par3Entity).getCurrentEquippedItem().getItem() == this) {
            ((EntityPlayer)par3Entity).addPotionEffect(new PotionEffect(Dungeons.magicBoost.id, 100, 0));
        }
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        return par1ItemStack;
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }
}
