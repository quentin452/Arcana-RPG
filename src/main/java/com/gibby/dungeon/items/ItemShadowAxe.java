package com.gibby.dungeon.items;

import com.gibby.dungeon.mobs.entityinstance.EntityPoundEffect3;
import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemShadowAxe extends ItemTripleSword
{
    public ItemShadowAxe(final Item.ToolMaterial p_i45356_1_, final int MagicDamage, final int VoidDamage) {
        super(p_i45356_1_, MagicDamage, VoidDamage);
    }

    @Override
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        par2EntityLivingBase.addVelocity((par2EntityLivingBase.posX - par3EntityLivingBase.posX) / 2.4, 0.4, (par2EntityLivingBase.posZ - par3EntityLivingBase.posZ) / 2.4);
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3EntityPlayer);
        if (par4.magicAmount() >= 12 || par3EntityPlayer.capabilities.isCreativeMode) {
            final List list = par3EntityPlayer.worldObj.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer, par3EntityPlayer.boundingBox.expand(10.0, 10.0, 10.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final double d0 = ((EntityLivingBase) list.get(k2)).posX - par3EntityPlayer.posX;
                        final double d2 = ((EntityLivingBase) list.get(k2)).posZ - par3EntityPlayer.posZ;
                        ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.causePlayerDamage(par3EntityPlayer), 20.0f);
                        ((EntityLivingBase) list.get(k2)).hurtResistantTime= 0;
                        ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 24.0f);
                        EntityLivingBase entity = (EntityLivingBase)list.get(k2);
                        if(entity != null) {
                            double motionX = d0 / 10.0;
                            double motionY = 0.65;
                            double motionZ = d2 / 10.0;
                            entity.motionX = motionX;
                            entity.motionY = motionY;
                            entity.motionZ = motionZ;
                        }
                    }
                }
            }
            if (!par2World.isRemote) {
                final EntityPoundEffect3 effect = new EntityPoundEffect3(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
                par2World.spawnEntityInWorld(effect);
            }
            par4.consumeMagic(12);
            par1ItemStack.damageItem(1, par3EntityPlayer);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_BLUE + "Deal area damage on right click(12 Magic)");
        par3List.add(EnumChatFormatting.DARK_BLUE + "Has high knockback.");
        par3List.add(EnumChatFormatting.DARK_BLUE + "+" + this.voidDamage + " Void Damage");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magic Damage");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
