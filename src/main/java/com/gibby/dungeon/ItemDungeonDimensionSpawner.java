

package com.gibby.dungeon;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemDungeonDimensionSpawner extends Item
{
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        if (!par2World.isRemote && par3.dimension == 0) {
            final EntityMontanePortal portal = new EntityMontanePortal(par2World, (EntityLivingBase)par3);
            par2World.spawnEntityInWorld((Entity)portal);
            --par1ItemStack.stackSize;
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GRAY + "Shoots a projectile, summoning a 12 by 12 by 6 portal to the Montane Dimension");
    }
}
