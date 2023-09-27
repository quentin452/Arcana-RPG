

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIcefire extends EntityThrowable
{
    public EntityIcefire(final World par1World) {
        super(par1World);
    }

    public EntityIcefire(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityIcefire(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.01f;
    }

    protected float func_70182_d() {
        return 0.9f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            final double motionX = this.motionX / 10.0;
            final double motionY = this.motionY / 10.0;
            final double motionZ = this.motionZ / 10.0;
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.0f, 0.0f, 1.0f);
            particle.setFadeColour(50);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
        }
        if (this.ticksExisted > 100) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit instanceof EntityLivingBase) {
            if (var1.entityHit.isImmuneToFire()) {
                var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this.getThrower(), this), 30.0f);
            }
            else {
                var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this.getThrower(), this), 10.0f);
            }
        }
        this.worldObj.playSoundAtEntity(this, "dig.glass", 1.0f, 1.0f);
        this.setDead();
    }
}
