

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

public class ItemShimmerWand extends ItemForceWand
{
    public ItemShimmerWand() {
        this.tier = 3;
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemShimmerWand.itemRand.nextGaussian(), ItemShimmerWand.itemRand.nextGaussian(), ItemShimmerWand.itemRand.nextGaussian());
                }
                final Vec3 look = entityLiving.getLookVec();
                final double X = look.xCoord;
                final double Z = look.zCoord;
                for (int j = 1; j < 4; ++j) {
                    final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                    ball.setEntityAttributes(10.0f, 1.2f, -0.03f, DamageSource.magic);
                    ball.explodes(true, 1.5f, false, false);
                    ball.setParticle("portal", 0.5, 20);
                    ball.secondParticle = "enchantmenttable";
                    ball.Color = "yellow";
                    ball.worldObj.spawnEntityInWorld((Entity)ball);
                    ball.motionX = X * j;
                    ball.motionZ = Z * j;
                }
                par4.consumeMagic(3);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 8 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemShimmerWand.itemRand.nextGaussian(), ItemShimmerWand.itemRand.nextGaussian(), ItemShimmerWand.itemRand.nextGaussian());
            }
            for (int i = 1; i < 5; ++i) {
                final Vec3 look = par3.getLookVec();
                final double X = look.xCoord;
                final double Z = look.zCoord;
                final EntityProjectileBall ball = new EntityProjectileBall(par2World, (EntityLivingBase)par3);
                ball.setEntityAttributes(18.0f, 1.2f, -0.03f, DamageSource.magic);
                ball.explodes(true, 2.0f, false, false);
                ball.setParticle("crit", 0.5, 20);
                ball.secondParticle = "enchantmenttable";
                ball.Color = "yellow";
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                ball.motionX = X * i / 4.0;
                ball.motionZ = Z * i / 4.0;
            }
            par4.consumeMagic(8);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot 3 magical projectiles(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to shoot powerful magical projectiles(8 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
