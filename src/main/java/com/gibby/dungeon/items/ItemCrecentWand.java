

package com.gibby.dungeon.items;

import com.gibby.dungeon.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.EntityExplosionSnake;
import com.gibby.dungeon.mobs.EntityProjectileBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemCrecentWand extends ItemForceWand
{
    public ItemCrecentWand() {
        this.tier = 3;
        this.setMaxStackSize(1);
        this.setMaxDamage(300);
        this.setFull3D();
    }

    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 4 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemCrecentWand.itemRand.nextGaussian(), ItemCrecentWand.itemRand.nextGaussian(), ItemCrecentWand.itemRand.nextGaussian());
                }
                par4.consumeMagic(4);
                final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                ball.Color = "clear";
                ball.explodes(true, 4.0f, false, false);
                ball.setParticle("largeexplode", 0.0, 2);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
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
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemCrecentWand.itemRand.nextGaussian(), ItemCrecentWand.itemRand.nextGaussian(), ItemCrecentWand.itemRand.nextGaussian());
            }
            final EntityExplosionSnake ball = new EntityExplosionSnake(par2World, (EntityLivingBase)par3);
            ball.worldObj.spawnEntityInWorld((Entity)ball);
            par4.consumeMagic(7);
            ball.worldObj.playSoundAtEntity((Entity)ball, "note.hat", 4.0f, 1.0f);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a powerful explosive(4 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to summon a moving explosion(7 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
