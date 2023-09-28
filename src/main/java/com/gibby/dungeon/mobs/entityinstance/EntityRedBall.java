

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRedBall extends EntityThrowable
{
    int generation;

    public EntityRedBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.generation = 0;
    }

    public EntityRedBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.generation = 0;
    }

    public EntityRedBall(final World par1World) {
        super(par1World);
        this.generation = 0;
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.outOfWorld, 3.0f);
        }
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 3; ++i) {
                if (this.generation <= 3) {
                    final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                    final EntityRedBall ball = new EntityRedBall(this.worldObj, this.posX, this.posY + 1.0, this.posZ);
                    this.worldObj.spawnEntityInWorld(ball);
                    ball.setThrowableHeading(randD * 1.3, 10.0, randD * 1.3, 0.3f, 12.0f);
                    ball.generation = this.generation + 1;
                }
            }
        }
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
}
