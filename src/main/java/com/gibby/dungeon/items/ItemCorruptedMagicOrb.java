

package com.gibby.dungeon.items;

import com.gibby.dungeon.mobs.EntityAmethystPortal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemCorruptedMagicOrb extends Item
{
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        if (!par2World.isRemote && par3.dimension == 0) {
            final EntityAmethystPortal portal = new EntityAmethystPortal(par2World, (EntityLivingBase)par3);
            par2World.spawnEntityInWorld((Entity)portal);
            --par1ItemStack.stackSize;
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Summons a portal to the Crystallium dimension");
    }
}
