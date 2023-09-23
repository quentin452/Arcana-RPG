

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import com.gibby.dungeon.mobs.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemWarlockWand extends ItemForceWand
{
    public ItemWarlockWand() {
        this.tier = 3;
        this.setMaxStackSize(1);
        this.setMaxDamage(300);
        this.setFull3D();
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 1 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemWarlockWand.itemRand.nextGaussian(), ItemWarlockWand.itemRand.nextGaussian(), ItemWarlockWand.itemRand.nextGaussian());
                }
                par4.consumeMagic(1);
                final EntityGreenBall ball = new EntityGreenBall(par3.worldObj, (EntityLivingBase)par3);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 4 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemWarlockWand.itemRand.nextGaussian(), ItemWarlockWand.itemRand.nextGaussian(), ItemWarlockWand.itemRand.nextGaussian());
            }
            final EntityRedBall ball = new EntityRedBall(par2World, (EntityLivingBase)par3);
            ball.worldObj.spawnEntityInWorld((Entity)ball);
            par4.consumeMagic(4);
            ball.worldObj.playSoundAtEntity((Entity)ball, "note.hat", 4.0f, 1.0f);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a bouncing bomb(1 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to shoot bouncing void projectiles(4 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
