

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityChainMummy extends EntityMob
{
    public EntityChainMummy(final World par1World) {
        super(par1World);
        this.setSize(1.1f, 2.2f);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    public int getTotalArmorValue() {
        return 21;
    }

    protected String getLivingSound() {
        return "minecraft.none";
    }

    protected String getHurtSound() {
        return "random.anvil_land";
    }

    protected String getDeathSound() {
        return "random.anvil_break";
    }

    protected float getSoundPitch() {
        return 1.6f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.outOfWorld, 4.0f);
            ((EntityLivingBase)par1Entity).hurtResistantTime = 0;
            this.heal(3.0f);
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        this.entityDropItem(new ItemStack(Dungeons.torturedChainSword), 1.0f);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.torturedChainSword));
    }
}
