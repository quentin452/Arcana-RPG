

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;

public class EntityRedBouncer extends EntityThrowable
{
    public static int color;
    
    public EntityRedBouncer(final World par1World) {
        super(par1World);
    }
    
    public EntityRedBouncer(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityRedBouncer(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    protected float getGravityVelocity() {
        return 0.0f;
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted > 100) {
            this.setDead();
        }
        if (this.worldObj.isRemote) {
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(1.0f, 0.0f, 0.0f);
            particle.setFadeColour(0);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        if (!(this.getThrower() instanceof EntityPlayer)) {
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getThrower(), this.boundingBox.expand(30.0, 30.0, 30.0));
            if (list != null) {
                final float smallestDistance = 10.0f;
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityPlayer) {
                        final EntityPlayer player = list.get(k2);
                        final double d0 = player.posX - this.posX;
                        final double d2 = player.boundingBox.minY + player.height / 2.0f - (this.posY + this.height / 2.0f);
                        final double d3 = player.posZ - this.posZ;
                        this.motionX = d0 / 15.0;
                        this.motionY = d2 / 15.0;
                        this.motionZ = d3 / 15.0;
                    }
                }
            }
        }
        else {
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getThrower(), this.boundingBox.expand(10.0, 10.0, 10.0));
            if (list != null) {
                final float smallestDistance = 10.0f;
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final EntityLivingBase player2 = list.get(k2);
                        final double d0 = player2.posX - this.posX;
                        final double d2 = player2.boundingBox.minY + player2.height / 2.0f - (this.posY + this.height / 2.0f);
                        final double d3 = player2.posZ - this.posZ;
                        this.motionX = d0 / 10.0;
                        this.motionY = d2 / 10.0;
                        this.motionZ = d3 / 10.0;
                    }
                }
            }
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            if (this.getThrower() instanceof EntityPlayer) {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.outOfWorld, 10.0f);
                this.setDead();
            }
            else if (var1.entityHit instanceof EntityPlayer) {
                ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.outOfWorld, 6.0f);
                this.setDead();
            }
        }
    }
    
    static {
        EntityRedBouncer.color = 0;
    }
}
