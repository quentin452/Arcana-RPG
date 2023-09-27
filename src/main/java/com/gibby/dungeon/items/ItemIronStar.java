

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.EntityIronStar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIronStar extends Item
{
    public ItemIronStar() {
        this.setCreativeTab(Dungeons.Weapons);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final EntityIronStar star = new EntityIronStar(par2World, par3EntityPlayer);
        par2World.spawnEntityInWorld(star);
        --par1ItemStack.stackSize;
        return par1ItemStack;
    }
}
