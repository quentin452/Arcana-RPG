

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemTripleSword extends ItemSword
{
    protected int magicDamage;
    protected int voidDamage;
    protected int charge;
    
    public ItemTripleSword(final Item.ToolMaterial p_i45356_1_, final int MagicDamage, final int VoidDamage) {
        super(p_i45356_1_);
        this.magicDamage = MagicDamage;
        this.voidDamage = VoidDamage;
        this.setCreativeTab(Dungeons.Weapons);
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        return this.charge >= 0;
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        if (this.charge < 0) {
            par2EntityLivingBase.hurtResistantTime = 0;
            par2EntityLivingBase.attackEntityFrom(DamageSource.magic, (float)this.magicDamage);
            par2EntityLivingBase.hurtResistantTime = 0;
            par2EntityLivingBase.attackEntityFrom(DamageSource.outOfWorld, (float)this.voidDamage);
            par2EntityLivingBase.hurtResistantTime = 0;
            par1ItemStack.damageItem(1, par3EntityLivingBase);
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
        par3List.add(EnumChatFormatting.BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
