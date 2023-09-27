

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityAntigravity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemAntiGravityTome extends ItemForceWand
{
    private final int maxTier;

    public ItemAntiGravityTome() {
        this.maxTier = 4;
        this.setMaxStackSize(1);
        this.setMaxDamage(this.maxTier);
        this.setFull3D();
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
        this.setDamage(par1ItemStack, this.maxTier - 1);
    }

    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        final int tier = this.maxTier - this.getDamage(par1ItemStack);
        if (par3.isSneaking()) {
            if (par3.experienceLevel >= 11 * tier && tier <= this.maxTier) {
                par3.experienceLevel -= 11 * tier;
                par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
                this.tier = this.maxTier - this.getDamage(par1ItemStack);
            }
        }
        else if (par4.magicAmount() >= 5 || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemAntiGravityTome.itemRand.nextGaussian(), ItemAntiGravityTome.itemRand.nextGaussian(), ItemAntiGravityTome.itemRand.nextGaussian());
            }
            final EntityAntigravity ball = new EntityAntigravity(par2World, par3);
            ball.worldObj.spawnEntityInWorld(ball);
            ball.power = (float)(1 + tier / 3);
            par4.consumeMagic(5);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack par1ItemStack, final int par1) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        final int tier = this.maxTier - this.getDamage(par1ItemStack);
        par3List.add(EnumChatFormatting.GOLD + "Right Click to shoot a projectile that traps and flings enemies(5 magic)");
        if (tier != this.maxTier) {
            par3List.add(EnumChatFormatting.GRAY + "If you have " + 11 * tier + " levels shift-right-clicking will upgrade this tome");
        }
        par3List.add(EnumChatFormatting.GRAY + "Tier " + tier + " out of " + this.maxTier);
    }
}
