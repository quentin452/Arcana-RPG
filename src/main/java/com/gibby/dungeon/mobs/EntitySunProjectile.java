

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import com.gibby.dungeon.*;
import net.minecraft.util.*;

public class EntitySunProjectile extends EntityThrowable
{
    public EntitySunProjectile(final World par1World) {
        super(par1World);
    }
    
    public EntitySunProjectile(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntitySunProjectile(final World par1World, final double par2, final double par4, final double par6) {
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
        if (!this.worldObj.isRemote) {
            final int velslowdown = 10000;
            final int dirChange = 90;
            this.addVelocity((this.motionX + Dungeons.randGauss() * dirChange) / velslowdown, (this.motionY + Dungeons.randGauss() * dirChange) / velslowdown, (this.motionZ + Dungeons.randGauss() * dirChange) / velslowdown);
        }
        if (this.worldObj.isRemote) {
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(1.0f, 1.0f, 0.0f);
            particle.setFadeColour(250);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        if (this.ticksExisted > 160) {
            this.setDead();
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase && !(var1.entityHit instanceof EntityIceSpirit)) {
            ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.outOfWorld, 10.0f);
        }
        this.setDead();
    }
}
