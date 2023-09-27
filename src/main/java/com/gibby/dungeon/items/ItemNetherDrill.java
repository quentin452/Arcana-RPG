

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityNetherDrill;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemNetherDrill extends ItemForceWand
{
    public ItemNetherDrill() {
        this.tier = 4;
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 5 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemNetherDrill.itemRand.nextGaussian(), ItemNetherDrill.itemRand.nextGaussian(), ItemNetherDrill.itemRand.nextGaussian());
                }
                final EntityNetherDrill ball = new EntityNetherDrill(par3.worldObj, par3);
                par3.worldObj.spawnEntityInWorld(ball);
                par4.consumeMagic(5);
                par3.worldObj.playSoundAtEntity(par3, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, par3);
            }
        }
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a super drilling projectile. Also lights blocks on fire(5 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
