

package com.gibby.dungeon;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

import java.util.List;

public class EnchantmentDamage2 extends Enchantment
{
    private static final String[] protectionName;
    private static final int[] baseEnchantability;
    private static final int[] levelEnchantability;
    private static final int[] thresholdEnchantability;
    public final int damageType;

    public EnchantmentDamage2(final int par1, final int par2, final int par3) {
        super(par1, par2, EnumEnchantmentType.weapon);
        this.damageType = par3;
    }

    public int getMinEnchantability(final int par1) {
        return EnchantmentDamage2.baseEnchantability[this.damageType] + (par1 - 1) * EnchantmentDamage2.levelEnchantability[this.damageType];
    }

    public int getMaxEnchantability(final int par1) {
        return this.getMinEnchantability(par1) + EnchantmentDamage2.thresholdEnchantability[this.damageType];
    }

    public int getMaxLevel() {
        if (this.damageType == 0 || this.damageType == 1) {
            return 5;
        }
        if (this.damageType == 4 || this.damageType == 5 || this.damageType == 6 || this.damageType == 7) {
            return 3;
        }
        return 0;
    }

    public String getName() {
        return "enchantment.damage." + EnchantmentDamage2.protectionName[this.damageType];
    }

    public boolean canApply(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() instanceof ItemAxe || super.canApply(par1ItemStack);
    }

    public void func_151368_a(final EntityLivingBase p_151368_1_, final Entity p_151368_2_, final int p_151368_3_) {
        if (p_151368_2_ instanceof EntityLivingBase) {
            final EntityLivingBase entitylivingbase1 = (EntityLivingBase)p_151368_2_;
            if (this.damageType == 0) {
                final float j = p_151368_3_ * 0.5f;
                entitylivingbase1.hurtResistantTime = 0;
                entitylivingbase1.attackEntityFrom(DamageSource.magic, j);
            }
            else if (this.damageType == 1) {
                final float j = p_151368_3_ * 0.5f;
                entitylivingbase1.hurtResistantTime = 0;
                entitylivingbase1.attackEntityFrom(DamageSource.outOfWorld, j);
            }
            else if (this.damageType == 4) {
                final int i = (int)(p_151368_3_ * 40.0f);
                if (entitylivingbase1.worldObj.rand.nextInt(4) == 0) {
                    entitylivingbase1.playSound("dig.glass", 1.0f, 1.0f);
                    entitylivingbase1.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, i, 10));
                    entitylivingbase1.addPotionEffect(new PotionEffect(Potion.weakness.id, i, 10));
                }
            }
            else if (this.damageType == 5) {
                final int i = (int)(p_151368_3_ * 0.4f);
                final EntityLivingBase entityLivingBase = entitylivingbase1;
                entityLivingBase.motionY += i+0.46;
            }
            else if (this.damageType == 6) {
                final int i = (int)(p_151368_3_ * 2.0f);
                final List list = entitylivingbase1.worldObj.getEntitiesWithinAABBExcludingEntity(entitylivingbase1, entitylivingbase1.boundingBox.expand(6.0, 4.0, 6.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase && !(list.get(k2) instanceof EntityPlayer) && ((EntityLivingBase) list.get(k2)).onGround) {
                            ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.causeMobDamage(p_151368_1_), (float)i);
                        }
                    }
                }
            }
            else if (this.damageType == 7) {
                final int i = p_151368_3_;
                p_151368_1_.heal((float)(0.25 * i));
            }
        }
    }

    static {
        protectionName = new String[] { "magic", "void", "rare", "legendary", "frost", "wind", "quake", "lifesteal" };
        baseEnchantability = new int[] { 10, 10, 30, 30, 15, 15, 15, 10 };
        levelEnchantability = new int[] { 15, 15, 30, 30, 25, 25, 25, 20 };
        thresholdEnchantability = new int[] { 25, 25, 30, 30, 29, 29, 29, 27 };
    }
}
