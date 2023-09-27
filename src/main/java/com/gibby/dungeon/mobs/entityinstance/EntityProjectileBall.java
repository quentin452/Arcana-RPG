

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityProjectileBall extends EntityThrowable
{
    public boolean lightsFire;
    public int lightFireTime;
    public float gravityVelocity;
    public String Color;
    DamageSource damageSource;
    float impactDamage;
    float entitySpeed;
    public String secondParticle;
    String particle;
    double amplification;
    int particleAmount;
    boolean explodes;
    float size;
    boolean fire;
    boolean griefs;
    boolean potion;
    int potionID;
    int potionduration;
    int potionseverity;
    boolean potion2;
    int potionID2;
    int potionduration2;
    int potionseverity2;

    public EntityProjectileBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.lightsFire = false;
        this.lightFireTime = 0;
        this.gravityVelocity = 0.03f;
        this.damageSource = DamageSource.generic;
        this.impactDamage = 0.0f;
        this.entitySpeed = 1.0f;
        this.explodes = false;
        this.size = 1.0f;
        this.fire = false;
        this.griefs = false;
        this.potion = false;
        this.potionID = 0;
        this.potionduration = 0;
        this.potionseverity = 0;
        this.potion2 = false;
        this.potionID2 = 0;
        this.potionduration2 = 0;
        this.potionseverity2 = 0;
        this.setDead();
    }

    public EntityProjectileBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.lightsFire = false;
        this.lightFireTime = 0;
        this.gravityVelocity = 0.03f;
        this.damageSource = DamageSource.generic;
        this.impactDamage = 0.0f;
        this.entitySpeed = 1.0f;
        this.explodes = false;
        this.size = 1.0f;
        this.fire = false;
        this.griefs = false;
        this.potion = false;
        this.potionID = 0;
        this.potionduration = 0;
        this.potionseverity = 0;
        this.potion2 = false;
        this.potionID2 = 0;
        this.potionduration2 = 0;
        this.potionseverity2 = 0;
    }

    public EntityProjectileBall(final World par1World) {
        super(par1World);
        this.lightsFire = false;
        this.lightFireTime = 0;
        this.gravityVelocity = 0.03f;
        this.damageSource = DamageSource.generic;
        this.impactDamage = 0.0f;
        this.entitySpeed = 1.0f;
        this.explodes = false;
        this.size = 1.0f;
        this.fire = false;
        this.griefs = false;
        this.potion = false;
        this.potionID = 0;
        this.potionduration = 0;
        this.potionseverity = 0;
        this.potion2 = false;
        this.potionID2 = 0;
        this.potionduration2 = 0;
        this.potionseverity2 = 0;
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.particle != null) {
            for (int i = 0; i < this.particleAmount; ++i) {
                final double f = (this.rand.nextDouble() - this.rand.nextDouble()) * this.amplification;
                this.worldObj.spawnParticle(this.particle, this.posX, this.posY, this.posZ, f, f, f);
            }
            if (this.secondParticle != null) {
                final double f2 = (this.rand.nextDouble() - this.rand.nextDouble()) * this.amplification;
                this.worldObj.spawnParticle(this.secondParticle, this.posX, this.posY, this.posZ, f2, f2, f2);
            }
        }
        if (this.ticksExisted > 100) {
            if (this.explodes) {
                this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, this.size, this.fire, this.griefs);
            }
            this.setDead();
        }
        this.extinguish();
    }

    protected float getGravityVelocity() {
        return this.gravityVelocity;
    }

    public void setEntityAttributes(final float damage, final float speed, final float gravityvelocity, final DamageSource damagesource) {
        this.impactDamage = damage;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed * 1.5f, 1.0f);
        this.gravityVelocity = gravityvelocity;
        this.damageSource = damagesource;
    }

    public void setParticle(final String particleString, final double f, final int particleamount) {
        this.particle = particleString;
        this.amplification = f;
        this.particleAmount = particleamount;
    }

    public void explodes(final boolean willExplode, final float explosionSize, final boolean fireDamage, final boolean griefing) {
        this.explodes = willExplode;
        this.size = explosionSize;
        this.fire = fireDamage;
        this.griefs = griefing;
    }

    public void addPotionEffect(final boolean willApplyPotion, final int potionId, final int duration, final int severity) {
        this.potion = willApplyPotion;
        this.potionID = potionId;
        this.potionduration = duration;
        this.potionseverity = severity;
    }

    public void addPotionEffect2(final boolean willApplyPotion, final int potionId, final int duration, final int severity) {
        this.potion2 = willApplyPotion;
        this.potionID2 = potionId;
        this.potionduration2 = duration;
        this.potionseverity2 = severity;
    }

    public void addFireDamage(final int fireLightTime) {
        this.lightsFire = true;
        this.lightFireTime = fireLightTime;
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            if (var1.entityHit instanceof EntityLivingBase) {
                final EntityLivingBase entity = (EntityLivingBase)var1.entityHit;
                if (this.lightsFire) {
                    entity.setFire(this.lightFireTime);
                }
                if (this.potion) {
                    entity.addPotionEffect(new PotionEffect(this.potionID, this.potionduration, this.potionseverity));
                }
                if (this.potion2) {
                    entity.addPotionEffect(new PotionEffect(this.potionID2, this.potionduration2, this.potionseverity2));
                }
                if (this.impactDamage > 0.0f) {
                    entity.attackEntityFrom(this.damageSource, this.impactDamage);
                }
                if (this.explodes) {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, this.size, this.fire, this.griefs);
                }
            }
            this.setDead();
        }
        if (!this.worldObj.isRemote) {
            if (this.explodes) {
                this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, this.size, this.fire, this.griefs);
            }
            this.setDead();
        }
        this.setDead();
    }
}
