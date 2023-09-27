

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemMagicGem extends Item
{
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer && ((EntityPlayer)par3Entity).getCurrentEquippedItem() != null && ((EntityPlayer)par3Entity).getCurrentEquippedItem().getItem() == this) {
            ((EntityPlayer)par3Entity).addPotionEffect(new PotionEffect(Dungeons.magicBoost.id, 100, 0));
        }
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
    }

}
