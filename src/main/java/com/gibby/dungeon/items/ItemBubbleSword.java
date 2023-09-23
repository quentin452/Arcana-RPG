

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemBubbleSword extends ItemStandardVoidSword
{
    public ItemBubbleSword(final Item.ToolMaterial p_i45356_1_, final int VoidDamage) {
        super(p_i45356_1_, VoidDamage);
    }
    
    @Override
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer entity = (EntityPlayer)par3Entity;
            if (entity.getCurrentEquippedItem() == par1ItemStack) {
                entity.addPotionEffect(new PotionEffect(Dungeons.storm.id, 1, 0));
            }
        }
    }
    
    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        par2EntityLivingBase.motionY += 0.7;
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.AQUA + "Flings Enemies Up");
        par3List.add(EnumChatFormatting.DARK_BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
