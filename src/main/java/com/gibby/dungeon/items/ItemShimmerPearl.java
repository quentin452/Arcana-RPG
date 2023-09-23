

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;

public class ItemShimmerPearl extends ItemEnderPearl
{
    public ItemShimmerPearl() {
        this.setCreativeTab(Dungeons.Materials);
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        --par1ItemStack.stackSize;
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (ItemShimmerPearl.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity)new EntityShimmerPearl(par2World, (EntityLivingBase)par3EntityPlayer));
        }
        return par1ItemStack;
    }
}
