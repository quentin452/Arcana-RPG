

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;

public class EntityCrystasis extends EntityHermit
{
    public EntityCrystasis(final World par1World) {
        super(par1World);
        this.setSize(0.9f, 1.8f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }
    
    public int getTotalArmorValue() {
        return 18;
    }
    
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
    
    @Override
    protected String getLivingSound() {
        return "gibby_dungeons:crystasisSay";
    }
    
    @Override
    protected String getHurtSound() {
        return "gibby_dungeons:crystasisHit";
    }
    
    @Override
    protected String getDeathSound() {
        return "gibby_dungeons:crystasisDeath";
    }
    
    @Override
    protected float getSoundPitch() {
        return 0.8f;
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand <= 1) {
            final EntityMagirockBall ball = new EntityMagirockBall(this.worldObj, (EntityLivingBase)this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            this.worldObj.playSoundAtEntity((Entity)this, "random.orb", 1.0f, 1.0f);
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.0f, 5.0f);
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(10.0f);
            final EntityHealEffect ball2 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball2);
        }
    }
    
    protected void dropEquipment(final boolean par1, final int par2) {
    }
    
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = Dungeons.randRange(0, 5);
        if (r == 0) {
            this.dropItem(Dungeons.magirockWand, 1);
        }
        if (r == 1) {
            this.dropItem(Dungeons.magirockCrystal, 1);
        }
        if (Dungeons.randRange(0, 15) == 0) {
            this.dropItem(Dungeons.magicCoin, 1);
        }
    }
}
