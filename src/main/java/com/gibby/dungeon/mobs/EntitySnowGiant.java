

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySnowGiant extends EntityMob
{
    public EntitySnowGiant(final World par1World) {
        super(par1World);
        this.setSize(1.5f, 3.0f);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
    }

    public int getTotalArmorValue() {
        return 19;
    }

    protected String getLivingSound() {
        return "step.snow";
    }

    protected String getHurtSound() {
        return "step.snow";
    }

    protected String getDeathSound() {
        return "step.snow";
    }

    protected float getSoundPitch() {
        return 0.9f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase && !this.worldObj.isRemote) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
            par1Entity.addVelocity((par1Entity.posX - this.posX) / 2.0, 0.6, (par1Entity.posZ - this.posZ) / 2.0);
            par1Entity.attackEntityFrom(DamageSource.magic, 4.0f);
            par1Entity.hurtResistantTime = 0;
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        this.entityDropItem(new ItemStack(Dungeons.frostySword), 1.0f);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.frostySword));
    }
}
