

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemSunsetOrb extends Item
{
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        if (!par2World.isRemote && par3.dimension == 0) {
            final EntitySunsetPortal portal = new EntitySunsetPortal(par2World, (EntityLivingBase)par3);
            par2World.spawnEntityInWorld((Entity)portal);
            --par1ItemStack.stackSize;
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Summons a portal to the Sunset dimension");
    }
}
