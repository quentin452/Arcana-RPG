

package com.gibby.dungeon.items;

import com.gibby.dungeon.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.EntityProjectileBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemMetalWand extends ItemForceWand
{
    public ItemMetalWand() {
        this.setMaxStackSize(1);
        this.setMaxDamage(250);
        this.setFull3D();
        this.tier = 2;
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 2 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemMetalWand.itemRand.nextGaussian(), ItemMetalWand.itemRand.nextGaussian(), ItemMetalWand.itemRand.nextGaussian());
                }
                final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, par3);
                ball.setEntityAttributes(0.0f, 1.3f, 0.06f, DamageSource.generic);
                ball.setParticle("crit", 1.0, 5);
                ball.secondParticle = "blockcrack_" + Block.getIdFromBlock(Blocks.anvil) + "_0";
                ball.Color = "gray";
                ball.explodes(true, 1.4f, false, false);
                ball.worldObj.spawnEntityInWorld(ball);
                par4.consumeMagic(2);
                ball.worldObj.playSoundAtEntity(ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 8 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemMetalWand.itemRand.nextGaussian(), ItemMetalWand.itemRand.nextGaussian(), ItemMetalWand.itemRand.nextGaussian());
            }
            final EntityProjectileBall ball = new EntityProjectileBall(par2World, par3);
            ball.setEntityAttributes(0.0f, 0.3f, 0.0f, DamageSource.generic);
            ball.setParticle("crit", 1.0, 50);
            ball.Color = "gray";
            ball.explodes(true, 2.8f, false, false);
            ball.worldObj.spawnEntityInWorld(ball);
            par4.consumeMagic(8);
            ball.worldObj.playSoundAtEntity(ball, "note.hat", 4.0f, 1.0f);
            par1ItemStack.damageItem(1, par3);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot an explosive projectile(2 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to shoot a powerful explosive projectile(8 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
