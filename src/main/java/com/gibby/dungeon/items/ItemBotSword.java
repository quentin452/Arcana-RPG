

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemBotSword extends Item
{
    public ItemBotSword() {
        this.setMaxDamage(30);
        this.setMaxStackSize(1);
        this.setCreativeTab(Dungeons.Weapons);
        this.bFull3D = true;
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par2EntityLivingBase.attackEntityFrom(DamageSource.causeMobDamage(par2EntityLivingBase), (float)(30 - this.getDamage(par1ItemStack)));
        par1ItemStack.setItemDamage(29);
        return false;
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (this.isDamaged(par1ItemStack) && par3Entity.ticksExisted % 20 == 0 && par3Entity instanceof EntityLivingBase) {
            par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_BLUE + "Does up to 30 damage, but needs recharge");
        par3List.add(EnumChatFormatting.GRAY + "Will currently do " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " damage");
    }
}
