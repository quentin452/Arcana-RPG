package com.gibby.dungeon.items;

import com.gibby.dungeon.mobs.entityinstance.EntityPoundEffect;
import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemRuneSpeedStaff extends ItemForceWand
{
    public ItemRuneSpeedStaff() {
        this.tier = 5;
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (par4.magicAmount() >= 25 || par3.capabilities.isCreativeMode) {
            par3.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 690, 3));
            par3.addPotionEffect(new PotionEffect(Potion.jump.id, 690, 1));
            final EntityPoundEffect effect = new EntityPoundEffect(par2World, par3.posX, par3.posY, par3.posZ);
            par2World.spawnEntityInWorld(effect);
            par4.consumeMagic(25);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to gain Speed IV and Jump(25 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
