

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySodbuster extends EntityThrowable {
    int charge;

    public EntitySodbuster(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntitySodbuster(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntitySodbuster(World par1World) {
        super(par1World);
        this.setDead();
    }

    @Override
    public boolean isEntityAlive() {
        return false;
    }

    protected float getGravityVelocity() {
        return 0.08f;
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        ++this.charge;
        if (this.charge > 100) {
            this.setDead();
        }
    }

    protected void onImpact(MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.3f, false, true);
        }
    }
}
