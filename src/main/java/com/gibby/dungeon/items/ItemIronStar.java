

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;

public class ItemIronStar extends Item
{
    public ItemIronStar() {
        this.setCreativeTab(Dungeons.Weapons);
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final EntityIronStar star = new EntityIronStar(par2World, (EntityLivingBase)par3EntityPlayer);
        par2World.spawnEntityInWorld((Entity)star);
        --par1ItemStack.stackSize;
        return par1ItemStack;
    }
}
