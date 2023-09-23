

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

public class ItemQuakeWand extends ItemForceWand
{
    public ItemQuakeWand() {
        this.setMaxStackSize(this.tier = 1);
        this.setMaxDamage(300);
        this.setFull3D();
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 2 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemQuakeWand.itemRand.nextGaussian(), ItemQuakeWand.itemRand.nextGaussian(), ItemQuakeWand.itemRand.nextGaussian());
                }
                par4.consumeMagic(2);
                final EntityQuake ball = new EntityQuake(par3.worldObj, (EntityLivingBase)par3);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 14 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemQuakeWand.itemRand.nextGaussian(), ItemQuakeWand.itemRand.nextGaussian(), ItemQuakeWand.itemRand.nextGaussian());
            }
            par4.consumeMagic(14);
            par2World.playSoundAtEntity((Entity)par3, "mob.irongolem.hit", 1.0f, 1.0f);
            par3.addPotionEffect(new PotionEffect(Potion.resistance.id, 500, 0));
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a ground quake(2 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to apply resistance(14 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
