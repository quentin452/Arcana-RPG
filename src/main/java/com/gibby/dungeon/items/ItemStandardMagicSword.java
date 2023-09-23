

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemStandardMagicSword extends ItemSword
{
    protected int magicDamage;
    protected int charge;
    
    public ItemStandardMagicSword(final Item.ToolMaterial p_i45356_1_, final int MagicDamage) {
        super(p_i45356_1_);
        this.magicDamage = MagicDamage;
        this.setCreativeTab(Dungeons.Weapons);
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        return this.charge >= 0;
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        if (this.charge < 0) {
            par2EntityLivingBase.hurtResistantTime = 0;
            par2EntityLivingBase.attackEntityFrom(DamageSource.magic, (float)this.magicDamage);
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.hurtResistantTime = 0;
            this.charge = 20;
        }
        return this.charge < 0;
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        --this.charge;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magical Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
