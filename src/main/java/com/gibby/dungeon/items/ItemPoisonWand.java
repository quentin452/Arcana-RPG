

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityProjectileBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemPoisonWand extends ItemForceWand
{
    public ItemPoisonWand() {
        this.setMaxStackSize(1);
        this.setMaxDamage(300);
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemPoisonWand.itemRand.nextGaussian(), ItemPoisonWand.itemRand.nextGaussian(), ItemPoisonWand.itemRand.nextGaussian());
                }
                final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                ball.setEntityAttributes(1.0f, 1.2f, 0.06f, DamageSource.causeThrownDamage((Entity)par3, (Entity)ball));
                ball.addPotionEffect(true, Potion.poison.id, 140, 1);
                ball.setParticle("spell", 0.0, 4);
                ball.secondParticle = "happyVillager";
                ball.Color = "green";
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                par4.consumeMagic(3);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 10 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemPoisonWand.itemRand.nextGaussian(), ItemPoisonWand.itemRand.nextGaussian(), ItemPoisonWand.itemRand.nextGaussian());
            }
            final EntityProjectileBall ball = new EntityProjectileBall(par2World, (EntityLivingBase)par3);
            ball.setEntityAttributes(1.0f, 0.5f, 0.0f, DamageSource.causeThrownDamage((Entity)par3, (Entity)ball));
            ball.addPotionEffect(true, Potion.poison.id, 500, 1);
            ball.setParticle("spell", 0.0, 4);
            ball.secondParticle = "happyVillager";
            ball.Color = "green";
            ball.worldObj.spawnEntityInWorld((Entity)ball);
            par4.consumeMagic(10);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a poisoning projectile(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to shoot a very poisonous projectile(10 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
