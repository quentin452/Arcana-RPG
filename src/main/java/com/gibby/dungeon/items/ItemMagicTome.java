

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemMagicTome extends ItemForceWand
{
    private final int maxTier;

    public ItemMagicTome() {
        this.maxTier = 25;
        this.setMaxStackSize(1);
        this.setMaxDamage(this.maxTier);
        this.setFull3D();
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
        this.setDamage(par1ItemStack, this.maxTier - 1);
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final int tier = this.maxTier - this.getDamage(par1ItemStack);
        if (par3.isSneaking() && par3.experienceLevel >= 2 * tier + 13 && tier <= this.maxTier) {
            par3.experienceLevel -= 2 * tier + 13;
            par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
            this.tier = this.maxTier - this.getDamage(par1ItemStack);
        }
        return par1ItemStack;
    }

    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)par3Entity;
            if (player.inventory.hasItemStack(par1ItemStack)) {
                this.tier = this.maxTier - this.getDamage(par1ItemStack);
                player.addPotionEffect(new PotionEffect(Dungeons.magicBoost.id, 100, this.tier - 1));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack par1ItemStack, final int par1) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        final int tier = this.maxTier - this.getDamage(par1ItemStack);
        par3List.add(EnumChatFormatting.GOLD + "If in inventory, will boost your max magic");
        if (tier != this.maxTier) {
            par3List.add(EnumChatFormatting.GRAY + "If you have " + (2 * tier + 13) + " levels, shift-right-clicking will upgrade this tome");
        }
        par3List.add(EnumChatFormatting.GRAY + "Tier " + tier + " out of " + this.maxTier);
    }
}
