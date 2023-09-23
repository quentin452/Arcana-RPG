

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemBloodWand extends ItemForceWand
{
    public ItemBloodWand() {
        this.tier = 2;
        this.setMaxStackSize(1);
        this.setMaxDamage(300);
        this.setFull3D();
    }
    
    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemBloodWand.itemRand.nextGaussian(), ItemBloodWand.itemRand.nextGaussian(), ItemBloodWand.itemRand.nextGaussian());
                }
                final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                ball.setEntityAttributes(4.0f, 1.2f, 0.06f, DamageSource.outOfWorld);
                par3.heal(1.0f);
                ball.setParticle("reddust", 0.0, 10);
                ball.secondParticle = "instantSpell";
                ball.Color = "orange";
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
        if (par4.magicAmount() >= 8 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemBloodWand.itemRand.nextGaussian(), ItemBloodWand.itemRand.nextGaussian(), ItemBloodWand.itemRand.nextGaussian());
            }
            final EntityProjectileBall ball = new EntityProjectileBall(par2World, (EntityLivingBase)par3);
            ball.setEntityAttributes(0.0f, 0.5f, 0.0f, DamageSource.generic);
            ball.addPotionEffect(true, Potion.wither.id, 200, 1);
            par3.addPotionEffect(new PotionEffect(Potion.regeneration.id, 240, 0));
            ball.setParticle("reddust", 0.0, 5);
            ball.secondParticle = "instantSpell";
            ball.Color = "gray";
            ball.worldObj.spawnEntityInWorld((Entity)ball);
            par4.consumeMagic(8);
            ball.worldObj.playSoundAtEntity((Entity)ball, "note.hat", 4.0f, 1.0f);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a void projectile and heal yourself(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to shoot a withering projectile and gain regeneration(8 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
