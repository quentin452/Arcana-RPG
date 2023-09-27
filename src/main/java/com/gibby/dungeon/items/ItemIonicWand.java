

package com.gibby.dungeon.items;

import com.gibby.dungeon.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.EntityProjectileBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemIonicWand extends ItemForceWand
{
    public ItemIonicWand() {
        this.tier = 3;
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
        this.setFull3D();
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                final EntityProjectileBall ball = new EntityProjectileBall(entityLiving.worldObj, entityLiving);
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemIonicWand.itemRand.nextGaussian(), ItemIonicWand.itemRand.nextGaussian(), ItemIonicWand.itemRand.nextGaussian());
                }
                final Random random = new Random();
                final Vec3 look = par3.getLookVec();
                final double posX = par3.posX + look.xCoord;
                final double posY = par3.posY + look.yCoord;
                final double posZ = par3.posZ + look.zCoord;
                double X = look.xCoord * 0.1;
                double Y = look.yCoord * 0.1;
                double Z = look.zCoord * 0.1;
                for (int j = 0; j < 100; ++j) {
                    for (int z = 0; z < 10; ++z) {
                        par3.worldObj.spawnParticle("mobSpellAmbient", posX + X * 1.1, posY + Y * 1.1, posZ + Z * 1.1, (double) random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2);
                        par3.worldObj.spawnParticle("reddust", posX + X * 1.1, posY + Y * 1.1, posZ + Z * 1.1, (double) random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2);
                    }
                    par3.worldObj.spawnParticle("mobSpellAmbient", posX + (X *= 1.1), posY + (Y *= 1.1), posZ + (Z *= 1.1), (double)random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2);
                    par3.worldObj.spawnParticle("magicCrit", posX + (X *= 1.1), posY + (Y *= 1.1), posZ + (Z *= 1.1), (double)random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2, (double)random.nextInt(10) / 10 - 0.2);
                }
                par3.worldObj.playSoundAtEntity(par3, "fireworks.twinkle_far", 1.0f, 1.2f);
                ball.Color = "blue";
                ball.setEntityAttributes(10.0f, 100.0f, 0.0f, DamageSource.magic);
                par3.worldObj.spawnEntityInWorld(ball);
                par4.consumeMagic(3);
                stack.damageItem(1, par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 9 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemIonicWand.itemRand.nextGaussian(), ItemIonicWand.itemRand.nextGaussian(), ItemIonicWand.itemRand.nextGaussian());
            }
            for (int x = 0; x < 10; ++x) {
                final double randomX = ItemIonicWand.itemRand.nextFloat() - ItemIonicWand.itemRand.nextFloat();
                final double randomZ = ItemIonicWand.itemRand.nextFloat() - ItemIonicWand.itemRand.nextFloat();
                par3.worldObj.spawnParticle("mobSpellAmbient", par3.posX + randomX, par3.posY - 1.0, par3.posZ + randomZ, 0.0, 0.0, 0.0);
            }
            for (int x = 0; x < 1000; ++x) {
                final double randomX = ItemIonicWand.itemRand.nextFloat() - ItemIonicWand.itemRand.nextFloat();
                final double randomZ = ItemIonicWand.itemRand.nextFloat() - ItemIonicWand.itemRand.nextFloat();
                par3.worldObj.spawnParticle("magicCrit", par3.posX, par3.posY - 1.0, par3.posZ, randomX, 0.0, randomZ);
                par3.worldObj.spawnParticle("magicCrit", par3.posX, par3.posY - 1.0, par3.posZ, randomX, 0.0, randomZ);
            }
            final List list = par3.worldObj.getEntitiesWithinAABBExcludingEntity(par3, par3.boundingBox.expand(20.0, 20.0, 20.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final double posX = ((EntityLivingBase) list.get(k2)).posX;
                        final double posY = ((EntityLivingBase) list.get(k2)).posY;
                        final double posZ = ((EntityLivingBase) list.get(k2)).posZ;
                        ((EntityLivingBase) list.get(k2)).worldObj.newExplosion(par3, posX, posY, posZ, 1.6f, false, false);
                    }
                }
            }
            par4.consumeMagic(9);
            par1ItemStack.damageItem(1, par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a magical beam(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to explode enemies under their feet in an area(9 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
