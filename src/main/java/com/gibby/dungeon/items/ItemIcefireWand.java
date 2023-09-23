

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemIcefireWand extends ItemForceWand
{
    public ItemIcefireWand() {
        this.tier = 4;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        return par1ItemStack;
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemIcefireWand.itemRand.nextGaussian(), ItemIcefireWand.itemRand.nextGaussian(), ItemIcefireWand.itemRand.nextGaussian());
                }
                if (!par3.worldObj.isRemote) {
                    final EntityIcefire ball = new EntityIcefire(par3.worldObj, (EntityLivingBase)par3);
                    par3.worldObj.spawnEntityInWorld((Entity)ball);
                }
                par4.consumeMagic(3);
                par3.worldObj.playSoundAtEntity((Entity)par3, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a blue projectile(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "The blue projectile deals 3X damage to those resistant to fire.");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
