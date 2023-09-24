

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemMagicWand extends ItemForceWand
{
    public ItemMagicWand() {
        this.tier = 2;
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemMagicWand.itemRand.nextGaussian(), ItemMagicWand.itemRand.nextGaussian(), ItemMagicWand.itemRand.nextGaussian());
                }
                for (int i = 0; i < 3; ++i) {
                    final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                    ball.setEntityAttributes(5.0f, 1.2f, 0.03f, DamageSource.magic);
                    ball.explodes(true, 1.0f, false, false);
                    ball.setParticle("portal", 0.0, 10);
                    ball.secondParticle = "witchMagic";
                    ball.Color = "darkblue";
                    ball.gravityVelocity = 0.05f;
                    ball.worldObj.spawnEntityInWorld((Entity)ball);
                    final EntityProjectileBall entityProjectileBall = ball;
                    entityProjectileBall.motionY += i / 3.5;
                }
                par4.consumeMagic(3);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 8 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemMagicWand.itemRand.nextGaussian(), ItemMagicWand.itemRand.nextGaussian(), ItemMagicWand.itemRand.nextGaussian());
            }
            for (int x = 0; x < 300; ++x) {
                final double random = ItemMagicWand.itemRand.nextGaussian() - ItemMagicWand.itemRand.nextGaussian();
                par3.worldObj.spawnParticle("portal", par3.posX + random, par3.posY + random, par3.posZ + random, ItemMagicWand.itemRand.nextGaussian(), ItemMagicWand.itemRand.nextGaussian(), ItemMagicWand.itemRand.nextGaussian());
                par3.worldObj.spawnParticle("crit", par3.posX, par3.posY - 1.0, par3.posZ, par2World.rand.nextGaussian(), 0.0, par2World.rand.nextGaussian());
            }
            par2World.playSoundAtEntity((Entity)par3, "note.hat", 4.0f, 1.0f);
            final List list = par3.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)par3, par3.boundingBox.expand(10.0, 10.0, 10.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final double d0 = ((EntityLivingBase) list.get(k2)).posX - par3.posX;
                        final double d2 = ((EntityLivingBase) list.get(k2)).posZ - par3.posZ;
                        ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.magic, 7.0f);
                        ((EntityLivingBase) list.get(k2)).motionY = 0.65;
                        ((EntityLivingBase) list.get(k2)).motionX = d0 / 10.0;
                        ((EntityLivingBase) list.get(k2)).motionZ = d2 / 10.0;
                    }
                }
            }
            par1ItemStack.damageItem(1, par3);
            par4.consumeMagic(8);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot three explosive magic projectiles(1 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click deal magical area damage(8 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
