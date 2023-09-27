

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDarkExplosion extends EntityThrowable
{
    int generation;

    public EntityDarkExplosion(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.generation = 0;
    }

    public EntityDarkExplosion(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.generation = 0;
    }

    public EntityDarkExplosion(final World par1World) {
        super(par1World);
        this.generation = 0;
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 1000; ++i) {
                final float random = this.rand.nextFloat();
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + Dungeons.randRange(-30, 30), this.posY + Dungeons.randRange(-50, 30), this.posZ + Dungeons.randRange(-30, 30), random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
        this.setDead();
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
            for (int i = 0; i < 1000; ++i) {
                final float random = this.rand.nextFloat();
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + Dungeons.randRange(-30, 30), this.posY + Dungeons.randRange(-30, 30), this.posZ + Dungeons.randRange(-30, 30), random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
        if (this.ticksExisted > 3) {
            this.setDead();
        }
    }
}
