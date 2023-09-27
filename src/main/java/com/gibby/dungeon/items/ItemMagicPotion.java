

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.DungeonsExtendedPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicPotion extends Item
{

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
        assert par1ItemStack != null;
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
