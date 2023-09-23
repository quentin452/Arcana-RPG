

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.util.*;

public class ItemChaoticWand extends ItemForceWand
{
    public ItemChaoticWand() {
        this.tier = 3;
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
        this.setFull3D();
    }
    
    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer par3 = (EntityPlayer)entityLiving;
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
            if (par4.magicAmount() >= 3 || par3.capabilities.isCreativeMode) {
                for (int i = 0; i < 10; ++i) {
                    par3.worldObj.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemChaoticWand.itemRand.nextGaussian(), ItemChaoticWand.itemRand.nextGaussian(), ItemChaoticWand.itemRand.nextGaussian());
                }
                final EntityProjectileBall ball = new EntityProjectileBall(par3.worldObj, (EntityLivingBase)par3);
                ball.setEntityAttributes(10.0f, 2.0f, 0.03f, DamageSource.causeThrownDamage((Entity)ball, (Entity)entityLiving));
                ball.addPotionEffect(true, Potion.wither.id, 100, 1);
                ball.secondParticle = "angryVillager";
                final EntityProjectileBall entityProjectileBall = ball;
                final StringBuilder append = new StringBuilder().append("blockcrack_");
                final Block obsidian = Blocks.obsidian;
                entityProjectileBall.setParticle(append.append(Block.getIdFromBlock(Blocks.obsidian)).append("_0").toString(), 1.0, 4);
                ball.worldObj.spawnEntityInWorld((Entity)ball);
                par4.consumeMagic(3);
                ball.worldObj.playSoundAtEntity((Entity)ball, "note.harp", 4.0f, 1.0f);
                stack.damageItem(1, (EntityLivingBase)par3);
            }
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if (!par2World.isRemote && (par4.magicAmount() >= 20 || par3.capabilities.isCreativeMode)) {
            for (int i = 0; i < 10; ++i) {
                final EntityWitherSkeletonMinion minion = new EntityWitherSkeletonMinion(par2World);
                minion.setPosition(par3.posX, par3.posY, par3.posZ);
                par2World.spawnEntityInWorld((Entity)minion);
                minion.onSpawnWithEgg((IEntityLivingData)null);
                minion.setPosition(par3.posX, par3.posY, par3.posZ);
            }
            par4.consumeMagic(20);
            par1ItemStack.damageItem(1, (EntityLivingBase)par3);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Left Click to shoot a withering projectile(3 magic)");
        par3List.add(EnumChatFormatting.LIGHT_PURPLE + "Right Click to summon in 10 Chaos Golem Minions(20 magic)");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
