

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMiniFireBall extends EntityThrowable
{
    public EntityMiniFireBall(final World par1World) {
        super(par1World);
    }

    public EntityMiniFireBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.motionX += this.rand.nextGaussian() / 5.0;
        this.motionY += this.rand.nextGaussian() / 5.0;
        this.motionZ += this.rand.nextGaussian() / 5.0;
    }

    protected float getGravityVelocity() {
        return -0.0f;
    }

    public EntityMiniFireBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted > 100) {
            this.setDead();
        }
        if (this.rand.nextInt(10) == 0) {
            this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextDouble() / 40.0, this.rand.nextDouble() / 40.0, this.rand.nextDouble() / 40.0);
        }
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextDouble() / 40.0, this.rand.nextDouble() / 40.0, this.rand.nextDouble() / 40.0);
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextDouble() / 40.0, this.rand.nextDouble() / 40.0, this.rand.nextDouble() / 40.0);
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            if (var1.entityHit instanceof EntityLivingBase) {
                var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 5.0f);
                var1.entityHit.setFire(5);
            }
            if (this.worldObj != null) {
                this.setDead();
            }
        }
    }
}
