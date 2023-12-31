

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFusionBall extends EntityThrowable
{
    public EntityFusionBall(final World par1World) {
        super(par1World);
    }

    public EntityFusionBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityFusionBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    protected float func_70182_d() {
        return 1.0f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            double motionX = this.motionX / 10.0;
            double motionY = Math.cos(this.ticksExisted);
            double motionZ = this.motionZ / 10.0;
            EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.0f, 0.5f, 0.0f);
            particle.setFadeColour(10000);
            particle.setTwinkle(true);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            this.worldObj.spawnParticle("enchantmenttable", this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0);
            motionX = this.motionX / 10.0;
            motionY = Math.sin(this.ticksExisted);
            motionZ = this.motionZ / 10.0;
            particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(1.0f, 0.0f, 1.0f);
            particle.setFadeColour(10000);
            particle.setTwinkle(true);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            this.worldObj.spawnParticle("enchantmenttable", this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0);
        }
        if (this.ticksExisted > 100) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            if (!(this.getThrower() instanceof EntityPlayer) && var1.entityHit instanceof EntityPlayer) {
                var1.entityHit.attackEntityFrom(DamageSource.magic, 6.0f);
                var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.5, (var1.entityHit.posZ - this.posZ) / 3.0);
                this.setDead();
            }
            else {
                var1.entityHit.attackEntityFrom(DamageSource.outOfWorld, 15.0f);
                var1.entityHit.hurtResistantTime = 0;
                var1.entityHit.attackEntityFrom(DamageSource.magic, 20.0f);
                var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.5, (var1.entityHit.posZ - this.posZ) / 3.0);
                this.setDead();
            }
        }
    }
}
