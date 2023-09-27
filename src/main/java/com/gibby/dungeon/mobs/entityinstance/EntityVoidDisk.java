

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityVoidDisk extends EntityThrowable
{
    private boolean impact;
    private double freezeX;
    private double freezeY;
    private double freezeZ;

    public EntityVoidDisk(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityVoidDisk(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityVoidDisk(final World par1World) {
        super(par1World);
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
        this.setDead();
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote && !this.impact) {
            this.impact = true;
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 1.0f, false, false);
            if (this.freezeX == 0.0) {
                this.freezeX = this.posX;
            }
            if (this.freezeY == 0.0) {
                this.freezeY = this.posY;
            }
            if (this.freezeZ == 0.0) {
                this.freezeZ = this.posZ;
            }
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impact) {
            for (int i = 0; i < 100; ++i) {
                this.worldObj.spawnParticle("happyVillager", this.posX, this.posY, this.posZ, Dungeons.randGauss(), 0.0, Dungeons.randGauss());
                final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getThrower(), this.boundingBox.expand(5.0, 5.0, 5.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase) {
                            ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)list.get(k2)), 5.0f);
                        }
                    }
                }
            }
        }
        final double randX = (this.rand.nextGaussian() - this.rand.nextGaussian()) * 2.0;
        final double randZ = (this.rand.nextGaussian() - this.rand.nextGaussian()) * 2.0;
        if (!this.worldObj.isRemote) {
            final EntityGreenBall ball = new EntityGreenBall(this.worldObj, this.freezeX + randX, this.freezeY, this.freezeZ + randZ);
            ball.motionX = randX / 100.0;
            ball.motionZ = randZ / 100.0;
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
        if (this.ticksExisted > 200) {
            this.setDead();
        }
    }
}
