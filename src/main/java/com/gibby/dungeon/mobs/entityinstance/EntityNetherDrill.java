

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityNetherDrill extends EntityThrowable
{
    public EntityNetherDrill(final World par1World) {
        super(par1World);
        this.setDead();
    }

    public EntityNetherDrill(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    protected float getGravityVelocity() {
        return 0.02f;
    }

    public EntityNetherDrill(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 30; ++i) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
            this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
            this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
            this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0, this.rand.nextGaussian() / 40.0);
        }
        if (this.ticksExisted > 40) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 4.0f, true, true);
        }
    }
}
