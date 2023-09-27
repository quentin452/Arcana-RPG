

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityVoidrim;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemVoidrimWand extends ItemForceWand
{
    public ItemVoidrimWand() {
        this.tier = 5;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 25 || par3.capabilities.isCreativeMode) {
            if (par2World.isRemote) {
                for (int i = 0; i < 60; ++i) {
                    final double particlePositionX = Math.cos(i * 6) * 1.6;
                    final double particlePositionZ = Math.sin(i * 6) * 1.6;
                    EntityFireworkSparkFX particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 2.0, par3.posY - 1.0, par3.posZ + particlePositionZ * 2.0, particlePositionX / 20.0, 0.0, particlePositionZ / 20.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.0f, 0.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 1.0, par3.posY - 1.0, par3.posZ + particlePositionZ * 1.0, particlePositionX / 20.0, 0.0, particlePositionZ / 20.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.0f, 0.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 0.5, par3.posY - 1.0, par3.posZ + particlePositionZ * 0.5, particlePositionX / 20.0, 0.0, particlePositionZ / 20.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.0f, 0.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
            }
            final List list = par3.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)par3, par3.boundingBox.expand(13.0, 13.0, 13.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final double d0 = ((EntityLivingBase) list.get(k2)).posX - par3.posX;
                        final double d2 = ((EntityLivingBase) list.get(k2)).posZ - par3.posZ;
                        ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 30.0f);
                        ((EntityLivingBase) list.get(k2)).motionY = 0.65;
                        ((EntityLivingBase) list.get(k2)).motionX = d0 / 10.0;
                        ((EntityLivingBase) list.get(k2)).motionZ = d2 / 10.0;
                        ((EntityLivingBase) list.get(k2)).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 4));
                    }
                }
            }
            par4.consumeMagic(25);
            par3.worldObj.playSoundAtEntity((Entity)par3, "note.harp", 4.0f, 1.0f);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemVoidrimWand.itemRand.nextGaussian(), ItemVoidrimWand.itemRand.nextGaussian(), ItemVoidrimWand.itemRand.nextGaussian());
                }
                if (!par3.worldObj.isRemote) {
                    final EntityVoidrim ball = new EntityVoidrim(par3.worldObj, (EntityLivingBase)par3);
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
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a slowing void projectile(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to deal slowing area damage(25 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
