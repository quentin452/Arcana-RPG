

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDarkWave extends EntityThrowable
{
    int generation;

    public EntityDarkWave(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.generation = 0;
    }

    public EntityDarkWave(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.generation = 0;
    }

    public EntityDarkWave(final World par1World) {
        super(par1World);
        this.generation = 0;
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
                var1.entityHit.attackEntityFrom(DamageSource.outOfWorld, 3.0f);
                ((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));
            }
            if (this.generation <= 1) {
                final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                final EntityDarkWave ball = new EntityDarkWave(this.worldObj, this.posX, this.posY + 1.0, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)ball);
                ball.motionX = this.motionX;
                ball.motionY = 0.7;
                ball.motionZ = this.motionZ;
                ball.generation = this.generation + 1;
            }
            this.setDead();
        }
    }

    protected float getGravityVelocity() {
        return 0.04f;
    }

    protected float func_70182_d() {
        return 1.0f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 10; ++i) {
                final float random = this.rand.nextFloat();
                final double motionX = this.motionX / 10.0;
                final double motionY = this.motionY / 10.0;
                final double motionZ = this.motionZ / 10.0;
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
    }
}
