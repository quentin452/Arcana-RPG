

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

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
