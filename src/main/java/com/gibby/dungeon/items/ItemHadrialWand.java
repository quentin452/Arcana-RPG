

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import com.gibby.dungeon.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemHadrialWand extends ItemForceWand
{
    public ItemHadrialWand() {
        this.tier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(100000);
        this.setFull3D();
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 4 || par3.capabilities.isCreativeMode) {
                final EntityProjectileBall ball = new EntityProjectileBall(entityLiving.worldObj, entityLiving);
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemHadrialWand.itemRand.nextGaussian(), ItemHadrialWand.itemRand.nextGaussian(), ItemHadrialWand.itemRand.nextGaussian());
                }
                final Random random = new Random();
                final Vec3 look = par3.getLookVec();
                final double posX = par3.posX + look.xCoord * 1.0;
                final double posY = par3.posY + look.yCoord * 1.0;
                final double posZ = par3.posZ + look.zCoord * 1.0;
                double X = look.xCoord * 0.1;
                double Y = look.yCoord * 0.1;
                double Z = look.zCoord * 0.1;
                for (int j = 0; j < 100; ++j) {
                    for (int z = 0; z < 10; ++z) {
                        par3.worldObj.spawnParticle("lava", posX + X * 1.1, posY + Y * 1.1, posZ + Z * 1.1, random.nextInt(10) / 10 - 0.2, random.nextInt(10) / 10 - 0.2, random.nextInt(10) / 10 - 0.2);
                    }
                    par3.worldObj.spawnParticle("lava", posX + (X *= 1.1), posY + (Y *= 1.1), posZ + (Z *= 1.1), random.nextInt(10) / 10 - 0.2, random.nextInt(10) / 10 - 0.2, random.nextInt(10) / 10 - 0.2);
                }
                par3.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)par3.posX, (int)par3.posY, (int)par3.posZ, 0);
                ball.Color = "red";
                ball.setEntityAttributes(13.0f, 100.0f, 0.0f, DamageSource.outOfWorld);
                ball.addFireDamage(10);
                par3.worldObj.spawnEntityInWorld((Entity)ball);
                par4.consumeMagic(4);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 15 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemHadrialWand.itemRand.nextGaussian(), ItemHadrialWand.itemRand.nextGaussian(), ItemHadrialWand.itemRand.nextGaussian());
            }
            for (int x = 0; x < 10; ++x) {
                final double randomX = ItemHadrialWand.itemRand.nextFloat() - ItemHadrialWand.itemRand.nextFloat();
                final double randomZ = ItemHadrialWand.itemRand.nextFloat() - ItemHadrialWand.itemRand.nextFloat();
                par3.worldObj.spawnParticle("lava", par3.posX + randomX, par3.posY - 1.0, par3.posZ + randomZ, 0.0, 0.0, 0.0);
            }
            for (int x = 0; x < 1000; ++x) {
                final double randomX = ItemHadrialWand.itemRand.nextFloat() - ItemHadrialWand.itemRand.nextFloat();
                final double randomZ = ItemHadrialWand.itemRand.nextFloat() - ItemHadrialWand.itemRand.nextFloat();
                par3.worldObj.spawnParticle("flame", par3.posX, par3.posY - 1.0, par3.posZ, randomX, 0.0, randomZ);
                par3.worldObj.spawnParticle("smoke", par3.posX, par3.posY - 1.0, par3.posZ, randomX, 0.0, randomZ);
            }
            par3.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)par3.posX, (int)par3.posY, (int)par3.posZ, 0);
            final List list = par3.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)par3, par3.boundingBox.expand(10.0, 10.0, 10.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        par3.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 300, 2));
                        par3.addPotionEffect(new PotionEffect(Potion.regeneration.id, 60, 1));
                        par3.addPotionEffect(new PotionEffect(Dungeons.shadowAura.id, 500, 1));
                        ((EntityLivingBase) list.get(k2)).setFire(15);
                        ((EntityLivingBase) list.get(k2)).addPotionEffect(new PotionEffect(Potion.wither.id, 1200, 0));
                    }
                }
            }
            par4.consumeMagic(15);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a beam of fire at enemies(4 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to light fire and wither enemies in the area.(15 magic)");
        par3List.add(EnumChatFormatting.WHITE + "If an enemy is affected by the area attack, you will gain Shadow Aura");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
