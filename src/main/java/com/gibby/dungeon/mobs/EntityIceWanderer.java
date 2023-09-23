

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.util.*;

public class EntityIceWanderer extends EntityThrowable
{
    public EntityIceWanderer(final World par1World) {
        super(par1World);
    }
    
    public EntityIceWanderer(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityIceWanderer(final World par1World, final double par2, final double par4, final double par6) {
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
            final int dirChange = 50;
            this.addVelocity((this.motionX + Dungeons.randGauss() * dirChange) / velslowdown, (this.motionY + Dungeons.randGauss() * dirChange) / velslowdown, (this.motionZ + Dungeons.randGauss() * dirChange) / velslowdown);
        }
        if (this.worldObj.isRemote) {
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.0f, 0.0f, 1.0f);
            particle.setFadeColour(100);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getThrower(), this.boundingBox.expand(4.0, 4.0, 4.0));
        if (list != null) {
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
        if (this.ticksExisted > 160) {
            this.setDead();
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase && !(var1.entityHit instanceof EntityIceSpirit) && !(var1.entityHit instanceof EntityMidnightShade)) {
            ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.magic, 5.0f);
            this.setDead();
        }
    }
}
