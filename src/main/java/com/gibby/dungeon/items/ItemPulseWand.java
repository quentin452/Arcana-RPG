

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

public class ItemPulseWand extends ItemForceWand
{
    public ItemPulseWand() {
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 15; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemPulseWand.itemRand.nextGaussian(), ItemPulseWand.itemRand.nextGaussian(), ItemPulseWand.itemRand.nextGaussian());
                }
                final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                ball.setEntityAttributes(5.0f, 1.5f, 0.01f, DamageSource.magic);
                ball.setParticle("portal", 0.0, 40);
                ball.secondParticle = "witchMagic";
                ball.addPotionEffect(true, Potion.moveSlowdown.id, 40, 10);
                ball.Color = "purple";
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
            for (int i = 0; i < 15; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemPulseWand.itemRand.nextGaussian(), ItemPulseWand.itemRand.nextGaussian(), ItemPulseWand.itemRand.nextGaussian());
            }
            final EntityProjectileBall ball = new EntityProjectileBall(par2World, (EntityLivingBase)par3);
            ball.setEntityAttributes(12.0f, 2.0f, 0.01f, DamageSource.magic);
            ball.setParticle("crit", 0.0, 40);
            ball.secondParticle = "witchMagic";
            ball.addPotionEffect(true, Potion.moveSlowdown.id, 300, 10);
            ball.Color = "purple";
            ball.worldObj.spawnEntityInWorld((Entity)ball);
            par4.consumeMagic(10);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a freezing magic projectile(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to shoot a powerful magic projectile(10 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
