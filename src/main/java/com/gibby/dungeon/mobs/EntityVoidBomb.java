

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityVoidBomb extends EntityThrowable
{
    public EntityVoidBomb(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityVoidBomb(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityVoidBomb(final World par1World) {
        super(par1World);
        this.setDead();
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 10; ++i) {
                final double randX = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                final double randZ = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                final EntityGreenBall ball = new EntityGreenBall(this.worldObj, this.posX, this.posY + 1.0, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)ball);
                ball.motionX = randX * (this.worldObj.rand.nextGaussian() / 5.0);
                ball.motionY = 0.3;
                ball.motionZ = randZ * (this.worldObj.rand.nextGaussian() / 5.0);
            }
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 1.0f, false, false);
            this.setDead();
        }
    }
    
    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
}
