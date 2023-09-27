

package com.gibby.dungeon.items;

import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import java.util.List;

public class ItemExawdusSmasher extends ItemTripleSword
{
    float multiplier;

    public ItemExawdusSmasher(final Item.ToolMaterial p_i45356_1_, final int MagicDamage, final int VoidDamage) {
        super(p_i45356_1_, MagicDamage, VoidDamage);
        this.multiplier = 1.0f;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    public void onPlayerStoppedUsing(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        final int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
        final ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        if (event.charge > 30 && this.multiplier == 1.0f && !par2World.isRemote) {
            final DungeonsExtendedPlayer par5 = DungeonsExtendedPlayer.get(par3EntityPlayer);
            if (par5.magicAmount() >= 4 || par3EntityPlayer.capabilities.isCreativeMode) {
                par5.consumeMagic(4);
                this.multiplier = 1.4f;
                par2World.playSoundAtEntity((Entity)par3EntityPlayer, "mob.enderdragon.growl", 2.0f, 1.0f);
                par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
            }
        }
    }

    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        if (this.charge < 0) {
            par2EntityLivingBase.addVelocity((par2EntityLivingBase.posX - par3EntityLivingBase.posX) / 2.4, 0.4, (par2EntityLivingBase.posZ - par3EntityLivingBase.posZ) / 2.4);
            par2EntityLivingBase.hurtResistantTime = 0;
            par2EntityLivingBase.attackEntityFrom(DamageSource.magic, this.magicDamage * this.multiplier);
            par2EntityLivingBase.hurtResistantTime = 0;
            par2EntityLivingBase.attackEntityFrom(DamageSource.outOfWorld, this.voidDamage * this.multiplier);
            par2EntityLivingBase.hurtResistantTime = 0;
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            this.charge = 20;
            this.multiplier = 1.0f;
        }
        return this.charge < 0;
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 1000;
    }

    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.AQUA + "Right click to power up attack (4 Magic).");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Has high knockback.");
        par3List.add(EnumChatFormatting.DARK_BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magic Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
