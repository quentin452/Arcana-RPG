

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityNetherDriller extends EntityThrowable
{
    int expFactor;
    
    public EntityNetherDriller(final World par1World) {
        super(par1World);
    }
    
    public EntityNetherDriller(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.motionX += this.rand.nextGaussian() / 10.0;
        this.motionY += this.rand.nextGaussian() / 10.0;
        this.motionZ += this.rand.nextGaussian() / 10.0;
        this.expFactor = this.rand.nextInt(3);
    }
    
    protected float getGravityVelocity() {
        return -0.0f;
    }
    
    public EntityNetherDriller(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.motionX < 1.0 && this.motionY < 1.0 && this.motionZ < 1.0) {
            this.motionX *= 1.1;
            this.motionY *= 1.1;
            this.motionZ *= 1.1;
        }
        for (int i = 0; i < 30; ++i) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
            this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
            this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
            this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
        }
        if (this.ticksExisted > 120) {
            this.setDead();
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj != null && !this.worldObj.isRemote) {
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 4.6f + this.expFactor, true, false);
        }
    }
}
