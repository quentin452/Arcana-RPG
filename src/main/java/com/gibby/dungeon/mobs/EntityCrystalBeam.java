

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class EntityCrystalBeam extends EntityThrowable
{
    public EntityCrystalBeam(final World par1World) {
        super(par1World);
    }
    
    public EntityCrystalBeam(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityCrystalBeam(final World par1World, final double par2, final double par4, final double par6) {
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
        if (this.worldObj.isRemote) {
            final double motionX = this.motionX / 10.0;
            final double motionY = this.motionY / 10.0;
            final double motionZ = this.motionZ / 10.0;
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.7f, 0.0f, 1.0f);
            particle.setFadeColour(0);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            this.worldObj.spawnParticle("enchantmenttable", this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0);
        }
        if (this.ticksExisted > 50) {
            this.setDead();
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            if (!(this.getThrower() instanceof EntityPlayer) && var1.entityHit instanceof EntityPlayer) {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.magic, 6.0f);
                var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.0, (var1.entityHit.posZ - this.posZ) / 3.0);
                this.setDead();
            }
            else {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.magic, 20.0f);
                var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.0, (var1.entityHit.posZ - this.posZ) / 3.0);
                this.setDead();
            }
        }
        this.setDead();
    }
}
