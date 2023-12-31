

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySpit extends EntityThrowable
{
    public EntitySpit(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntitySpit(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntitySpit(final World par1World) {
        super(par1World);
    }

    protected float getGravityVelocity() {
        return 0.08f;
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit instanceof EntityLivingBase) {
            var1.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.getThrower()), 2.0f);
        }
        this.setDead();
    }
}
