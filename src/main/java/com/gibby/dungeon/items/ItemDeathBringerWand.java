

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityRuneExplosion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemDeathBringerWand extends ItemForceWand
{
    public ItemDeathBringerWand() {
        this.tier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(300);
        this.setFull3D();
    }

    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 2 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemDeathBringerWand.itemRand.nextGaussian(), ItemDeathBringerWand.itemRand.nextGaussian(), ItemDeathBringerWand.itemRand.nextGaussian());
                }
                par4.consumeMagic(2);
                if (!par3.worldObj.isRemote) {
                    final EntityRuneExplosion ball = new EntityRuneExplosion(par3.worldObj, par3);
                    ball.worldObj.spawnEntityInWorld(ball);
                    ball.worldObj.playSoundAtEntity(ball, "note.harp", 4.0f, 1.0f);
                }
                stack.damageItem(1, par3);
            }
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 20 || par3.capabilities.isCreativeMode) {
            par4.consumeMagic(20);
            if (!par3.worldObj.isRemote) {
                for (int i = 0; i < 10; ++i) {
                    par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemDeathBringerWand.itemRand.nextGaussian(), ItemDeathBringerWand.itemRand.nextGaussian(), ItemDeathBringerWand.itemRand.nextGaussian());
                    par2World.playSoundAtEntity(par3, "mob.enderdragon.growl", 1.0f, 0.8f);
                }
                par3.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 160, 3));
                par3.addPotionEffect(new PotionEffect(Potion.blindness.id, 20, 0));
                par3.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 160, 1));
            }
            par1ItemStack.damageItem(1, par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot and summon a rune explosion(2 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to apply Strength IV, Speed II and brief Blindness(20 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
