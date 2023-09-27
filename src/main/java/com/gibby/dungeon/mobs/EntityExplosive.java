

package com.gibby.dungeon.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExplosive extends EntityThrowable
{
    public EntityExplosive(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntityExplosive(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityExplosive(final World par1World) {
        super(par1World);
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 1.7f, false, false);
            this.setDead();
        }
    }
}
