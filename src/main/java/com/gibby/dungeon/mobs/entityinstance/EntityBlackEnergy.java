

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlackEnergy extends EntityThrowable
{
    public EntityBlackEnergy(final World par1World) {
        super(par1World);
    }

    public EntityBlackEnergy(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityBlackEnergy(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    protected float func_70182_d() {
        return 0.7f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 20; ++i) {
                final float random = (float)this.rand.nextGaussian();
                final double motionX = this.motionX / 10.0;
                final double motionY = this.motionY / 10.0;
                final double motionZ = this.motionZ / 10.0;
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
        if (this.ticksExisted > 100) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit instanceof EntityLivingBase) {
            if (this.getThrower() instanceof EntityMidnightShade) {
                var1.entityHit.attackEntityFrom(DamageSource.outOfWorld, 6.0f);
                var1.entityHit.addVelocity(var1.entityHit.posX - this.posX, 0.4, var1.entityHit.posZ - this.posZ);
            }
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 6.0f);
        }
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 1; ++i) {
                final float random = (float)this.rand.nextGaussian();
                final double randX = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double randY = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double randZ = this.rand.nextGaussian() - this.rand.nextGaussian();
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + randX, this.posY + randY, this.posZ + randZ, random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }
}
