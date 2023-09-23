

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;

public class EntityRupture extends EntityThrowable
{
    public int damage;
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityRupture(final World par1World) {
        super(par1World);
        this.damage = 4;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityRupture(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.damage = 4;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
        this.motionX += this.rand.nextGaussian() / 10.0;
        this.motionY += this.rand.nextGaussian() / 10.0;
        this.motionZ += this.rand.nextGaussian() / 10.0;
    }

    protected float getGravityVelocity() {
        return -0.0f;
    }

    public EntityRupture(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.damage = 4;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            if (this.counter > 30) {
                final int X = (int)this.freezeX;
                final int Y = (int)this.freezeY;
                final int Z = (int)this.freezeZ;
                this.worldObj.playSoundAtEntity((Entity)this, "step.ladder", 1.0f, 0.7f);
                final int currentBlock = Block.getIdFromBlock(this.worldObj.getBlock(X, Y - 1, Z));
                if (currentBlock == 0) {
                    this.setDead();
                }
                for (int i = 3; i < this.damage; ++i) {
                    this.worldObj.spawnParticle("blockcrack_" + currentBlock + "_0", this.freezeX, this.freezeY, this.freezeZ, this.rand.nextGaussian(), 1.0, this.rand.nextGaussian());
                    final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(3.0, 1.0, 3.0));
                    if (list != null) {
                        for (int k2 = 0; k2 < list.size(); ++k2) {
                            if (list.get(k2) instanceof EntityLivingBase && ((EntityLivingBase) list.get(k2)).onGround) {
                                ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.causeMobDamage(this.getThrower()), (float)this.damage);
                            }
                        }
                    }
                }
            }
            if (this.counter > 80) {
                this.setDead();
            }
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj != null && var1.entityHit == null) {
            this.impacted = true;
            if (this.freezeX == 0.0) {
                this.freezeX = this.posX;
                this.freezeY = this.posY;
                this.freezeZ = this.posZ;
            }
        }
    }
}
