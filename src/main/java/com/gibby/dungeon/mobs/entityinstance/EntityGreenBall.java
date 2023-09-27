

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGreenBall extends EntityThrowable
{
    int generation;

    public EntityGreenBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.generation = 0;
    }

    public EntityGreenBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.generation = 0;
    }

    public EntityGreenBall(final World par1World) {
        super(par1World);
        this.generation = 0;
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 1.3f, false, false);
            if (this.generation <= 3) {
                final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                final EntityGreenBall ball = new EntityGreenBall(this.worldObj, this.posX, this.posY + 1.0, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)ball);
                ball.motionX = this.motionX;
                ball.motionY = 0.5;
                ball.motionZ = this.motionZ;
                ball.generation = this.generation + 1;
            }
        }
        this.setDead();
    }

    protected float getGravityVelocity() {
        return 0.08f;
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("happyVillager", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
}
