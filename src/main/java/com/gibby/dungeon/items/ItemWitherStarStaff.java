

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.DungeonsExtendedPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ItemWitherStarStaff extends ItemForceWand
{
    public ItemWitherStarStaff() {
        this.tier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(1000);
        this.setFull3D();
    }

    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer entity = (EntityPlayer)par3Entity;
            if (entity.getCurrentEquippedItem() == par1ItemStack) {
                final DungeonsExtendedPlayer player = DungeonsExtendedPlayer.get(entity);
                entity.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
                if (player.magicAmount() >= 1 || entity.capabilities.isCreativeMode) {
                    entity.addPotionEffect(new PotionEffect(Dungeons.shadowAura.id, 100, 0));
                    if (entity.ticksExisted % 60 == 0) {
                        player.consumeMagic(1);
                    }
                }
            }
        }
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 2 || par3.capabilities.isCreativeMode) {
                final Vec3 look = entityLiving.getLookVec();
                final EntityWitherSkull skull = new EntityWitherSkull(par3.worldObj, (EntityLivingBase)par3, 0.0, 0.0, 0.0);
                skull.setPosition(par3.posX + look.xCoord * 1.0, par3.posY + look.yCoord * 1.0 + 1.0, par3.posZ + look.zCoord * 1.0);
                skull.accelerationX = look.xCoord * 0.1;
                skull.accelerationY = look.yCoord * 0.1;
                skull.accelerationZ = look.zCoord * 0.1;
                if (par3.capabilities.isCreativeMode && !par3.worldObj.isRemote) {
                    par3.worldObj.playSoundAtEntity((Entity)par3, "mob.wither.shoot", 1.4f, ((ItemWitherStarStaff.itemRand.nextFloat() - ItemWitherStarStaff.itemRand.nextFloat()) * 0.2f + 0.5f) * 1.8f);
                    par3.worldObj.spawnEntityInWorld((Entity)skull);
                }
                if (!par3.capabilities.isCreativeMode && !par3.worldObj.isRemote) {
                    par3.worldObj.playSoundAtEntity((Entity)par3, "mob.wither.shoot", 1.4f, ((ItemWitherStarStaff.itemRand.nextFloat() - ItemWitherStarStaff.itemRand.nextFloat()) * 0.2f + 0.5f) * 1.8f);
                    par3.worldObj.spawnEntityInWorld((Entity)skull);
                }
                par4.consumeMagic(2);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 1 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemWitherStarStaff.itemRand.nextGaussian(), ItemWitherStarStaff.itemRand.nextGaussian(), ItemWitherStarStaff.itemRand.nextGaussian());
            }
            par3.motionY += 0.6;
            par3.motionX *= 1.1;
            par3.motionZ *= 1.1;
            par3.fallDistance = -1.0f;
            if (Dungeons.randRange(0, 1) == 0) {
                par4.consumeMagic(1);
            }
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot wither skulls(2 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click rapidly to fly(0.5 magic)");
        par3List.add(EnumChatFormatting.WHITE + "Holding the staff also takes magic and applies Shadow Aura");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
