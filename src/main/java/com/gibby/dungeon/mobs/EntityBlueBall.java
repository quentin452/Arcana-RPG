

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityBlueBall extends EntityThrowable
{
    private Entity targetedEntity;

    public EntityBlueBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntityBlueBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityBlueBall(final World par1World) {
        super(par1World);
        this.setDead();
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.3f, false, false);
        }
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        if (this.targetedEntity == null && this.getThrower() != null) {
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getThrower(), this.boundingBox.expand(10.0, 10.0, 10.0));
            if (list != null) {
                float smallestDistance = 10.0f;
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase && ((EntityLivingBase) list.get(k2)).onGround) {
                        final float distance = ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this);
                        if (distance < smallestDistance) {
                            smallestDistance = distance;
                            this.targetedEntity = (Entity)list.get(k2);
                        }
                    }
                }
            }
            if (this.targetedEntity != null) {
                final double d0 = this.targetedEntity.posX - this.posX;
                final double d2 = this.targetedEntity.boundingBox.minY + this.targetedEntity.height / 2.0f - (this.posY + this.height / 2.0f);
                final double d3 = this.targetedEntity.posZ - this.posZ;
                this.motionX = d0 / 10.0;
                this.motionY = d2 / 30.0;
                this.motionZ = d3 / 10.0;
            }
        }
    }
}
