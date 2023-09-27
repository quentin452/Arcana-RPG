package com.gibby.dungeon.items;

import com.gibby.dungeon.mobs.entityinstance.EntityCrystalliumPlainsPortal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

import java.util.List;

public class ItemMagicalOrb extends Item {
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3) {
        if (!par2World.isRemote && par3.dimension == 0 && !(par3 instanceof FakePlayer)) {
            spawnCrystalliumPlainsPortal(par2World, par3);
            par1ItemStack.stackSize--;
        }
        return par1ItemStack;
    }

    private void spawnCrystalliumPlainsPortal(World world, EntityPlayer player) {
        EntityCrystalliumPlainsPortal portal = new EntityCrystalliumPlainsPortal(world, player);
        world.spawnEntityInWorld(portal);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Summons a portal to the Crystallium Plains dimension");
    }
}
