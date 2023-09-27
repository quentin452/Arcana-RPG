

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.EntityShimmerPearl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
