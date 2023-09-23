

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityWaterBall extends EntityThrowable
{
    public EntityWaterBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityWaterBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityWaterBall(final World par1World) {
        super(par1World);
    }
    
    protected float getGravityVelocity() {
        return 0.01f;
    }
    
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 10; ++i) {
            this.worldObj.spawnParticle("bubble", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
        }
        for (int i = 0; i < 10; ++i) {
            this.worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, var1.entityHit), 10.0f);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}
