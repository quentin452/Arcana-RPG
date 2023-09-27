

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAle extends Item
{

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 32;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    public ItemStack onEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        --par1ItemStack.stackSize;
        if (par1ItemStack != null) {
            if (par1ItemStack.getItem() == Dungeons.whiskey) {
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Dungeons.imbalance.id, 200, 0));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1000, 1));
            }
            if (par1ItemStack.getItem() == Dungeons.gingerAle) {
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1000, 0));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 1000, 1));
            }
            if (par1ItemStack.getItem() == Dungeons.rootBeer) {
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1000, 3));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 1000, 0));
            }
        }
        return par1ItemStack;
    }

    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
}
