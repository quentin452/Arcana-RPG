

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBeholderSpawner extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityBeholderSpawner(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityBeholderSpawner(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
        this.motionX += this.rand.nextGaussian() / 10.0;
        this.motionY += this.rand.nextGaussian() / 10.0;
        this.motionZ += this.rand.nextGaussian() / 10.0;
    }

    protected float getGravityVelocity() {
        return 0.06f;
    }

    public EntityBeholderSpawner(final World par1World, final double par2, final double par4, final double par6) {
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
            this.worldObj.spawnParticle("flame", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("lava", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
            }
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("largesmoke", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
            }
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("smoke", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
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
                            for (int x = -5; x < 6; ++x) {
                                for (int z = -5; z < 6; ++z) {
                                    this.worldObj.setBlock(X + x, Y, Z + z, Blocks.netherrack);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 1: {
                            for (int x = -5; x < 6; ++x) {
                                for (int z = -5; z < 6; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 11, Z + z, Blocks.netherrack);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 2: {
                            for (int x = -5; x < 6; ++x) {
                                for (int y = 0; y < 11; ++y) {
                                    this.worldObj.setBlock(X + x, Y + y, Z + 6, Blocks.netherrack);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 3: {
                            for (int x = -5; x < 6; ++x) {
                                for (int y = 0; y < 11; ++y) {
                                    this.worldObj.setBlock(X + x, Y + y, Z - 6, Blocks.netherrack);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 4: {
                            for (int z2 = -5; z2 < 6; ++z2) {
                                for (int y = 0; y < 11; ++y) {
                                    this.worldObj.setBlock(X + 6, Y + y, Z + z2, Blocks.netherrack);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 5: {
                            for (int z2 = -5; z2 < 6; ++z2) {
                                for (int y = 0; y < 11; ++y) {
                                    this.worldObj.setBlock(X - 6, Y + y, Z + z2, Blocks.netherrack);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 6: {
                            for (int z2 = -6; z2 < 7; ++z2) {
                                for (int x2 = -6; x2 < 7; ++x2) {
                                    for (int y2 = 0; y2 < 12; ++y2) {
                                        this.worldObj.setBlock(X + x2, Y + y2, Z + z2, Blocks.air);
                                    }
                                }
                            }
                            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 8.0f, true, true);
                            final EntityBeholder entityBeholder = new EntityBeholder(this.worldObj);
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
                if (this.stage == 7) {
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
