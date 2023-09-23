

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityCursedStone extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;
    
    public EntityCursedStone(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }
    
    public EntityCursedStone(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }
    
    protected float getGravityVelocity() {
        return 0.06f;
    }
    
    public EntityCursedStone(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            final int randX = this.rand.nextInt(10) - this.rand.nextInt(10);
            final int randY = this.rand.nextInt(10) - this.rand.nextInt(10);
            final int randZ = this.rand.nextInt(5);
            this.worldObj.spawnParticle("magicCrit", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("crit", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
            }
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            if (this.counter > 40) {
                final int X = (int)this.freezeX;
                final int Y = (int)this.freezeY;
                final int Z = (int)this.freezeZ;
                if (!this.worldObj.isRemote && this.ticksExisted % 40 == 0) {
                    switch (this.stage) {
                        case 0: {
                            ++this.stage;
                            break;
                        }
                        case 1: {
                            ++this.stage;
                            break;
                        }
                        case 2: {
                            ++this.stage;
                            break;
                        }
                        case 3: {
                            ++this.stage;
                            break;
                        }
                        case 4: {
                            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 5.0f, false, true);
                            final EntityRemnant entityBeholder = new EntityRemnant(this.worldObj);
                            entityBeholder.setPosition(this.posX, this.posY, this.posZ);
                            this.worldObj.spawnEntityInWorld((Entity)entityBeholder);
                            entityBeholder.onSpawnWithEgg((IEntityLivingData)null);
                            entityBeholder.setPosition(this.posX, this.posY, this.posZ);
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity((Entity)this, "step.wood", 1.5f, 1.0f);
                }
                if (this.stage == 5) {
                    this.setDead();
                }
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
