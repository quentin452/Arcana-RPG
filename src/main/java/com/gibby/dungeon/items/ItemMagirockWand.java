

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.mobs.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemMagirockWand extends ItemForceWand
{
    public ItemMagirockWand() {
        this.tier = 5;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 25 || par3.capabilities.isCreativeMode) {
            if (par2World.isRemote) {
                for (int i = 0; i < 60; ++i) {
                    final double particlePositionX = Math.cos(i * 6) * 1.6;
                    final double particlePositionY = Math.sin(i * 6) * 1.6;
                    final double particlePositionZ = Math.sin(i * 6) * 1.6;
                    EntityFireworkSparkFX particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 2.0, par3.posY - 1.0, par3.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.0f, 1.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 1.0, par3.posY - 1.0, par3.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.0f, 1.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFireworkSparkFX(par2World, par3.posX + particlePositionX * 0.5, par3.posY - 1.0, par3.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.0f, 1.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
            }
            if (!par3.worldObj.isRemote) {
                par3.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 700, 4));
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
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemMagirockWand.itemRand.nextGaussian(), ItemMagirockWand.itemRand.nextGaussian(), ItemMagirockWand.itemRand.nextGaussian());
                }
                if (!par3.worldObj.isRemote) {
                    final EntityMagirockBall ball = new EntityMagirockBall(par3.worldObj, (EntityLivingBase)par3);
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
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to gain a row of absorbsion hearts(25 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
