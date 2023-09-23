

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemCastIronSword extends ItemCopperSword
{
    public ItemCastIronSword(final Item.ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setCreativeTab(Dungeons.Weapons);
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer entity = (EntityPlayer)par3Entity;
            if (entity.getCurrentEquippedItem() == par1ItemStack) {
                entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1, 0));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GRAY + "A very heavy sword");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
