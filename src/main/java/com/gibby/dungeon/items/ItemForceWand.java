

package com.gibby.dungeon.items;

import com.gibby.dungeon.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.EntityProjectileBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemForceWand extends Item
{
    protected int tier;

    public ItemForceWand() {
        this.setMaxStackSize(this.tier = 1);
        this.setMaxDamage(250);
        this.setFull3D();
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par3 = DungeonsExtendedPlayer.get((EntityPlayer)entityLiving);
            if (par3.magicAmount() >= 1 || player.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    player.worldObj.spawnParticle("enchantmenttable", player.posX, player.posY, player.posZ, ItemForceWand.itemRand.nextGaussian(), ItemForceWand.itemRand.nextGaussian(), ItemForceWand.itemRand.nextGaussian());
                }
                final EntityProjectileBall ball = new EntityProjectileBall(player.worldObj, (EntityLivingBase)player);
                ball.setEntityAttributes(0.0f, 1.2f, 0.06f, DamageSource.generic);
                ball.setParticle("magicCrit", 0.5, 10);
                ball.secondParticle = "crit";
                ball.Color = "blue";
                ball.explodes(true, 1.05f, false, true);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                par3.consumeMagic(1);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)player);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 8 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemForceWand.itemRand.nextGaussian(), ItemForceWand.itemRand.nextGaussian(), ItemForceWand.itemRand.nextGaussian());
            }
            for (int x = 0; x < 100; ++x) {
                par3.worldObj.spawnParticle("magicCrit", par3.posX, par3.posY - 1.0, par3.posZ, par2World.rand.nextGaussian(), 0.0, par2World.rand.nextGaussian());
            }
            par2World.playSoundAtEntity((Entity)par3, "note.hat", 4.0f, 1.0f);
            final List list = par3.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)par3, par3.boundingBox.expand(10.0, 4.0, 10.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final double d0 = ((EntityLivingBase) list.get(k2)).posX - par3.posX;
                        final double d2 = ((EntityLivingBase) list.get(k2)).posZ - par3.posZ;
                        ((EntityLivingBase) list.get(k2)).motionY = 0.65;
                        ((EntityLivingBase) list.get(k2)).motionX = d0 / 2.0;
                        ((EntityLivingBase) list.get(k2)).motionZ = d2 / 2.0;
                    }
                }
            }
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
            par4.consumeMagic(8);
        }
        return par1ItemStack;
    }

    public int getItemEnchantability() {
        return 2;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot an explosive projectile(1 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to send enemies away(8 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
