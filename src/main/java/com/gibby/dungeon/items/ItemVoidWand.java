

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityVoidBomb;
import com.gibby.dungeon.mobs.entityinstance.EntityVoidDisk;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemVoidWand extends ItemForceWand
{
    public ItemVoidWand() {
        this.tier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
        this.setFull3D();
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 2 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemVoidWand.itemRand.nextGaussian(), ItemVoidWand.itemRand.nextGaussian(), ItemVoidWand.itemRand.nextGaussian());
                }
                final EntityVoidBomb ball = new EntityVoidBomb(par3.worldObj, (EntityLivingBase)par3);
                par4.consumeMagic(2);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 7 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemVoidWand.itemRand.nextGaussian(), ItemVoidWand.itemRand.nextGaussian(), ItemVoidWand.itemRand.nextGaussian());
            }
            final EntityVoidDisk ball = new EntityVoidDisk(par2World, (EntityLivingBase)par3);
            ball.worldObj.spawnEntityInWorld((Entity)ball);
            par4.consumeMagic(7);
            ball.worldObj.playSoundAtEntity((Entity)ball, "note.hat", 4.0f, 1.0f);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a projectile that spawns bouncing bombs(2 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click make a field of bouncing bombs(7 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
