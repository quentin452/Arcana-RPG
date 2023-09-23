

package com.gibby.dungeon.items;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;

public class ItemMagicPotion extends Item
{
    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        return false;
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return (par1ItemStack != null && par1ItemStack.getItem() == Dungeons.magicPotion2) ? 32 : 20;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final DungeonsExtendedPlayer player = DungeonsExtendedPlayer.get(par3EntityPlayer);
        if (player.magicAmount() < player.maxMagic()) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
    
    public ItemStack onEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final DungeonsExtendedPlayer player = DungeonsExtendedPlayer.get(par3EntityPlayer);
        if (par1ItemStack != null && par1ItemStack.getItem() == Dungeons.magicPotion2) {
            player.addMagic(16);
        }
        else {
            player.addMagic(8);
        }
        --par1ItemStack.stackSize;
        return par1ItemStack;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack par1ItemStack, final int pass) {
        return par1ItemStack != null && par1ItemStack.getItem() == Dungeons.magicPotion2;
    }
}
