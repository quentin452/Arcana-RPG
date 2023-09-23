

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemSunAxe extends ItemTripleSword
{
    public ItemSunAxe(final Item.ToolMaterial p_i45356_1_, final int MagicDamage, final int VoidDamage) {
        super(p_i45356_1_, MagicDamage, VoidDamage);
    }
    
    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par2EntityLivingBase.addVelocity((par2EntityLivingBase.posX - par3EntityLivingBase.posX) / 2.4, 0.4, (par2EntityLivingBase.posZ - par3EntityLivingBase.posZ) / 2.4);
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3EntityPlayer);
        if (par4.magicAmount() >= 3 || par3EntityPlayer.capabilities.isCreativeMode) {
            if (!par2World.isRemote) {
                for (int i = 0; i < 3; ++i) {
                    final EntitySunProjectile ball = new EntitySunProjectile(par2World, (EntityLivingBase)par3EntityPlayer);
                    par2World.spawnEntityInWorld((Entity)ball);
                }
            }
            par4.consumeMagic(3);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.AQUA + "Unleashes sun projectiles on right click");
        par3List.add(EnumChatFormatting.YELLOW + "Has high knockback.");
        par3List.add(EnumChatFormatting.DARK_BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magic Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
