

package com.gibby.dungeon.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemEntityEnrager extends Item
{
    public ItemEntityEnrager() {
        this.setMaxStackSize(1);
        this.setFull3D();
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        final List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(16.0, 10.0, 16.0));
        if (list != null) {
            for (int k2 = 0; k2 < list.size(); ++k2) {
                if (list.get(k2) instanceof EntityLiving && !(list.get(k2) instanceof EntityPlayer)) {
                    ((EntityLiving)entity).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)list.get(k2)), 0.01f);
                    return true;
                }
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Makes entities mad at the others");
    }
}
