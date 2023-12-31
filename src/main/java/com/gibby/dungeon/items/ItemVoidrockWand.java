

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityVoidrockBall;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemVoidrockWand extends ItemForceWand
{
    public ItemVoidrockWand() {
        this.tier = 5;
    }
    @SideOnly(Side.CLIENT)
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 25 || par3.capabilities.isCreativeMode) {
            if (par2World.isRemote) {
                for (int i = 0; i < 60; ++i) {
                    final double particlePositionX = Math.cos(i * 6) * 1.6;
                    final double particlePositionY = Math.sin(i * 6) * 1.6;
                    final double particlePositionZ = Math.sin(i * 6) * 1.6;
                    EntityFireworkSparkFX particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 2.0, par3.posY - 1.0, par3.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.0f, 1.0f, 0.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 1.0, par3.posY - 1.0, par3.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.0f, 1.0f, 0.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 0.5, par3.posY - 1.0, par3.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.0f, 1.0f, 0.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
            }
            if (!par3.worldObj.isRemote) {
                par3.addPotionEffect(new PotionEffect(Dungeons.growth.id, 700, 2));
                par3.addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));
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
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemVoidrockWand.itemRand.nextGaussian(), ItemVoidrockWand.itemRand.nextGaussian(), ItemVoidrockWand.itemRand.nextGaussian());
                }
                if (!par3.worldObj.isRemote) {
                    final EntityVoidrockBall ball = new EntityVoidrockBall(par3.worldObj, (EntityLivingBase)par3);
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
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a powerful magirock meteor(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to gain powerful regrowth(25 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
