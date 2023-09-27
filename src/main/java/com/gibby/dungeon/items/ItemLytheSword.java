

package com.gibby.dungeon.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemLytheSword extends ItemStandardVoidSword
{
    public ItemLytheSword(final Item.ToolMaterial p_i45356_1_, final int VoidDamage) {
        super(p_i45356_1_, VoidDamage);
    }

    @Override
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer entity = (EntityPlayer)par3Entity;
            if (entity.getCurrentEquippedItem() == par1ItemStack) {
                entity.addPotionEffect(new PotionEffect(Potion.invisibility.id, 100, 0));
                final List list = par2World.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(15.0, 4.0, 15.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase && ((EntityLivingBase) list.get(k2)).onGround) {
                            final double d0 = ((EntityLivingBase) list.get(k2)).posX - entity.posX;
                            final double d2 = ((EntityLivingBase) list.get(k2)).posZ - entity.posZ;
                            ((EntityLivingBase) list.get(k2)).motionX = -d0 / (25.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity(entity));
                            ((EntityLivingBase) list.get(k2)).motionZ = -d2 / (25.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity(entity));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        par3EntityLivingBase.heal(0.5f);
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_BLUE + "Drains enemies on hit and pulls entities in");
        par3List.add(EnumChatFormatting.DARK_BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
