

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWitherSpawner extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityWitherSpawner(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityWitherSpawner(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.1f;
    }

    public EntityWitherSpawner(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            for (int i = 0; i < 40; ++i) {
                for (int r = 0; r < 15; ++r) {
                    final double timePassed = (this.ticksExisted / 2 + i * 40) / 10;
                    final double particlePositionX = Math.cos(timePassed) * 2.0;
                    final double particlePositionY = Math.sin(timePassed) * 2.0;
                    final double particlePositionZ = Math.sin(timePassed) * 2.0;
                    this.worldObj.spawnParticle("witchMagic", this.posX + particlePositionX, this.posY + r, this.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                }
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
                            this.worldObj.newExplosion((Entity)this, this.posX, this.posY + 8.0, this.posZ, 8.0f, false, true);
                            final EntityGhostWither wither = new EntityGhostWither(this.worldObj);
                            wither.setPosition(this.posX, this.posY + 8.0, this.posZ);
                            this.worldObj.spawnEntityInWorld((Entity)wither);
                            wither.onSpawnWithEgg((IEntityLivingData)null);
                            wither.setPosition(this.posX, this.posY + 8.0, this.posZ);
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity((Entity)this, "step.wood", 1.5f, 1.0f);
                }
                if (this.stage == 5) {
                    this.worldObj.playSoundAtEntity((Entity)this, "portal.travel", 1.3f, 1.0f);
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
