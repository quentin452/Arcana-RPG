

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnergy extends EntityThrowable
{
    public int tier;

    public EntityEnergy(final World par1World) {
        super(par1World);
        this.setDead();
    }

    public EntityEnergy(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityEnergy(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 5 * this.tier; ++i) {
                final float colorRand1 = (float)this.rand.nextGaussian();
                final float colorRand2 = (float)this.rand.nextGaussian();
                final float colorRand3 = (float)this.rand.nextGaussian();
                final double motionX = this.motionX / 10.0;
                final double motionY = this.motionY / 10.0;
                final double motionZ = this.motionZ / 10.0;
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, colorRand1, colorRand2, colorRand3);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
        if (this.ticksExisted > 200) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit instanceof EntityLivingBase) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 1.0f);
            var1.entityHit.hurtResistantTime = 0;
            var1.entityHit.attackEntityFrom(DamageSource.magic, (float)(5 + this.tier * 3));
        }
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 1; ++i) {
                final float colorRand1 = (float)this.rand.nextGaussian();
                final float colorRand2 = (float)this.rand.nextGaussian();
                final float colorRand3 = (float)this.rand.nextGaussian();
                final double randX = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double randY = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double randZ = this.rand.nextGaussian() - this.rand.nextGaussian();
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + randX, this.posY + randY, this.posZ + randZ, colorRand1, colorRand2, colorRand3);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }
}
