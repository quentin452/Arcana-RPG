

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityBlueBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemCursedWand extends ItemForceWand
{
    public ItemCursedWand() {
        this.tier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
        this.setFull3D();
    }

    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemCursedWand.itemRand.nextGaussian(), ItemCursedWand.itemRand.nextGaussian(), ItemCursedWand.itemRand.nextGaussian());
                }
                final EntityBlueBall ball = new EntityBlueBall(par3.worldObj, (EntityLivingBase)par3);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                par4.consumeMagic(3);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 7 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemCursedWand.itemRand.nextGaussian(), ItemCursedWand.itemRand.nextGaussian(), ItemCursedWand.itemRand.nextGaussian());
            }
            for (int x = 0; x < 300; ++x) {
                final double random = ItemCursedWand.itemRand.nextGaussian() - ItemCursedWand.itemRand.nextGaussian();
                par3.worldObj.spawnParticle("magicCrit", par3.posX + random, par3.posY + random, par3.posZ + random, ItemCursedWand.itemRand.nextGaussian(), ItemCursedWand.itemRand.nextGaussian(), ItemCursedWand.itemRand.nextGaussian());
                par3.worldObj.spawnParticle("crit", par3.posX, par3.posY - 1.0, par3.posZ, par2World.rand.nextGaussian(), 0.0, par2World.rand.nextGaussian());
            }
            par2World.playSoundAtEntity((Entity)par3, "note.hat", 4.0f, 1.0f);
            final List list = par3.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)par3, par3.boundingBox.expand(10.0, 10.0, 10.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        ((EntityLivingBase) list.get(k2)).addPotionEffect(new PotionEffect(Dungeons.shock.id, 140, 0));
                    }
                }
            }
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
            par4.consumeMagic(7);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a homing explosive projectile(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to apply Magical Shock to enemies in an area(10 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
