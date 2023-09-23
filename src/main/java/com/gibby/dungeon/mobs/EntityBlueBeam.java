

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class EntityBlueBeam extends EntityThrowable
{
    public EntityBlueBeam(final World par1World) {
        super(par1World);
    }
    
    public EntityBlueBeam(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityBlueBeam(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    protected float getGravityVelocity() {
        return 0.0f;
    }
    
    protected float func_70182_d() {
        return 0.8f;
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote && this.worldObj.isRemote) {
            final double motionX = this.motionX / 10.0;
            final double motionY = this.motionY / 10.0;
            final double motionZ = this.motionZ / 10.0;
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(1.0f, 0.0f, 0.0f);
            particle.setFadeColour(200);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        if (this.ticksExisted > 50) {
            this.setDead();
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            if (!(this.getThrower() instanceof EntityPlayer) && var1.entityHit instanceof EntityPlayer) {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.outOfWorld, 6.0f);
            }
            else {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.outOfWorld, 20.0f);
            }
        }
    }
}
