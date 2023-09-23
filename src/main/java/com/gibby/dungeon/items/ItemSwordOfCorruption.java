

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemSwordOfCorruption extends ItemTripleSword
{
    public ItemSwordOfCorruption(final Item.ToolMaterial p_i45356_1_, final int MagicDamage, final int VoidDamage) {
        super(p_i45356_1_, MagicDamage, VoidDamage);
    }
    
    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magical Damage");
        par3List.add(EnumChatFormatting.BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.GRAY + "Applies wither on hit");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
