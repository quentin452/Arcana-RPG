

package com.gibby.dungeon;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

public class EnchantmentProtection2 extends Enchantment
{
    private static final String[] protectionName;
    private static final int[] baseEnchantability;
    private static final int[] levelEnchantability;
    private static final int[] thresholdEnchantability;
    public final int protectionType;

    public EnchantmentProtection2(final int par1, final int par2, final int par3) {
        super(par1, par2, EnumEnchantmentType.armor);
        this.protectionType = par3;
    }

    public int getMinEnchantability(final int par1) {
        return EnchantmentProtection2.baseEnchantability[this.protectionType] + (par1 - 1) * EnchantmentProtection2.levelEnchantability[this.protectionType];
    }

    public int getMaxEnchantability(final int par1) {
        return this.getMinEnchantability(par1) + EnchantmentProtection2.thresholdEnchantability[this.protectionType];
    }

    public int getMaxLevel() {
        return 5;
    }

    public int calcModifierDamage(final int par1, final DamageSource par2DamageSource) {
        if (par2DamageSource.canHarmInCreative()) {
            return 0;
        }
        final float f = (6 + par1 * par1) / 3.0f;
        return (this.protectionType == 0 && par2DamageSource.isMagicDamage()) ? MathHelper.floor_float(f * 1.25f) : ((this.protectionType == 1 && par2DamageSource == DamageSource.outOfWorld) ? MathHelper.floor_float(f * 1.25f) : 0);
    }

    public String getName() {
        return "enchantment.protect." + EnchantmentProtection2.protectionName[this.protectionType];
    }

    static {
        protectionName = new String[] { "magic", "void" };
        baseEnchantability = new int[] { 1, 10, 5, 5, 3 };
        levelEnchantability = new int[] { 11, 8, 6, 8, 6 };
        thresholdEnchantability = new int[] { 20, 12, 10, 12, 15 };
    }
}
