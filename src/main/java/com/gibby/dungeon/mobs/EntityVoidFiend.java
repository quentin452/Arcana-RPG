

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityVoidFiend extends EntityMob
{
    public EntityVoidFiend(final World par1World) {
        super(par1World);
        this.experienceValue = 20;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.01);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
    }
    
    protected String getLivingSound() {
        return "step.cloth";
    }
    
    protected String getHurtSound() {
        return "step.cloth";
    }
    
    protected String getDeathSound() {
        return "step.cloth";
    }
    
    protected float getSoundPitch() {
        return 0.6f;
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.nightVision.id, 100, 0));
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 0));
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.outOfWorld, 6.0f);
            this.hurtResistantTime = 0;
        }
        return super.attackEntityAsMob(par1Entity);
    }
    
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere() && this.posY < 16.0;
    }
    
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 100; ++i) {
            this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextGaussian() - this.rand.nextGaussian()) / 8.0, this.posY + this.rand.nextGaussian() / 5.0 + 0.5, this.posZ + (this.rand.nextGaussian() - this.rand.nextGaussian()) / 8.0, 0.0, 0.0, 0.0);
        }
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(20);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidFiendSword), 1.0f);
        }
        if (r >= 12) {
            this.dropItem(Dungeons.bedrock, 2);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidCoin), 1.0f);
        }
    }
}
