package com.gibby.dungeon.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemTitanicTome extends Item
{
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "In Inventory: Makes magic regenerate 40% faster");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Dropped by the midnight Titan");
        par3List.add(EnumChatFormatting.GRAY + "Effects do not stack with other magic regen tomes.");
    }
}

