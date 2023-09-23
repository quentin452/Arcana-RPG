

package com.gibby.dungeon;

import com.gibby.dungeon.items.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import com.gibby.dungeon.mobs.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemSapientWarWand extends ItemForceWand
{
    public ItemSapientWarWand() {
        this.tier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(300);
        this.setFull3D();
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemSapientWarWand.itemRand.nextGaussian(), ItemSapientWarWand.itemRand.nextGaussian(), ItemSapientWarWand.itemRand.nextGaussian());
                }
                par4.consumeMagic(3);
                if (!par3.worldObj.isRemote) {
                    for (int i = 0; i < 4; ++i) {
                        final EntityCrystalBeam entityCrystalBeam;
                        final EntityCrystalBeam ball = entityCrystalBeam = new EntityCrystalBeam(par3.worldObj, (EntityLivingBase)par3);
                        entityCrystalBeam.motionX += Dungeons.randGauss() / 10.0;
                        final EntityCrystalBeam entityCrystalBeam2 = ball;
                        entityCrystalBeam2.motionZ += Dungeons.randGauss() / 10.0;
                        ball.worldObj.spawnEntityInWorld((Entity)ball);
                        ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                    }
                }
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 4 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 7; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemSapientWarWand.itemRand.nextGaussian(), ItemSapientWarWand.itemRand.nextGaussian(), ItemSapientWarWand.itemRand.nextGaussian());
            }
            par4.consumeMagic(4);
            if (!par3.worldObj.isRemote) {
                final EntityHealEffect ball = new EntityHealEffect(par3.worldObj, (EntityLivingBase)par3);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                par3.heal(4.0f);
            }
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot four purple beams(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to heal 2 hearts(4 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
