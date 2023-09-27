

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMagirockBall extends EntityThrowable
{
    public EntityMagirockBall(final World par1World) {
        super(par1World);
    }

    public EntityMagirockBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityMagirockBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    protected float func_70182_d() {
        return 0.9f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            final double motionX = this.motionX / 10.0;
            final double motionY = Math.cos(this.ticksExisted);
            final double motionZ = this.motionZ / 10.0;
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(1.0f, 0.0f, 1.0f);
            particle.setFadeColour(10000);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            this.worldObj.spawnParticle("enchantmenttable", this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0);
        }
        if (this.ticksExisted > 80) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            if (!(this.getThrower() instanceof EntityPlayer) && var1.entityHit instanceof EntityPlayer) {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.magic, 6.0f);
                var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.5, (var1.entityHit.posZ - this.posZ) / 3.0);
                this.setDead();
            }
            else {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.magic, 25.0f);
                var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.5, (var1.entityHit.posZ - this.posZ) / 3.0);
                this.setDead();
            }
        }
    }
}
