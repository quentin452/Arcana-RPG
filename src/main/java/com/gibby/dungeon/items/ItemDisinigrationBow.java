

package com.gibby.dungeon.items;

import cpw.mods.fml.relauncher.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.enchantment.*;
import net.minecraft.init.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.util.*;

public class ItemDisinigrationBow extends ItemBow
{
    public static final String[] bowPullIconNameArray;
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public ItemDisinigrationBow() {
        this.maxStackSize = 1;
        this.bFull3D = true;
        this.setMaxDamage(750);
        this.setCreativeTab(Dungeons.Weapons);
    }

    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        final int k = useRemaining;
        if (k > 71995) {
            return this.getItemIconForUseDuration(0);
        }
        if (k > 71985) {
            return this.getItemIconForUseDuration(1);
        }
        if (k > 71975) {
            return this.getItemIconForUseDuration(2);
        }
        if (k > 0) {
            return this.getItemIconForUseDuration(3);
        }
        return this.getItemIconForUseDuration(0);
    }

    public void onPlayerStoppedUsing(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
        final ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        final boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
        if (flag || par3EntityPlayer.inventory.hasItem(Items.arrow)) {
            float f = j / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            final EntityDisinigrationArrow entityarrow = new EntityDisinigrationArrow(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0f);
            entityarrow.setDamage(entityarrow.getDamage() + 1.6);
            if (f == 1.0f) {
                entityarrow.setIsCritical(true);
            }
            final int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
            if (k > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + k * 0.8 + 0.5);
            }
            final int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
            if (l > 0) {
                entityarrow.setKnockbackStrength(l + 1);
            }
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
                entityarrow.setFire(160);
            }
            par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
            par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 1.0f, 1.0f / (ItemDisinigrationBow.itemRand.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (flag) {
                entityarrow.canBePickedUp = 2;
            }
            else {
                par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
            }
            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld((Entity)entityarrow);
            }
        }
    }

    public ItemStack onEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 72000;
    }

    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Items.arrow)) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(this.getIconString() + "_0");
        this.iconArray = new IIcon[ItemDisinigrationBow.bowPullIconNameArray.length];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon(this.getIconString() + ItemDisinigrationBow.bowPullIconNameArray[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(final int par1) {
        return this.iconArray[par1];
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.WHITE + "Arrows disinigrate projectiles near them.");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }

    static {
        bowPullIconNameArray = new String[] { "_0", "_1", "_2", "_3" };
    }
}
