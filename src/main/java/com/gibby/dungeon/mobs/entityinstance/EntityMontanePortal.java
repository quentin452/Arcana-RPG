

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMontanePortal extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityMontanePortal(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityMontanePortal(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.08f;
    }

    public EntityMontanePortal(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            if (this.worldObj.isRemote) {
                for (int i = 0; i < 60; ++i) {
                    final double particlePositionX = Math.cos(i * 6) * 6.0;
                    final double particlePositionY = Math.sin(this.ticksExisted / 2 + i * 6) * 4.0;
                    final double particlePositionZ = Math.sin(i * 6) * 6.0;
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX, this.posY + particlePositionY + 8.0, this.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 1.0f, 1.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
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
                            for (int x = -5; x < 6; ++x) {
                                for (int z = -5; z < 6; ++z) {
                                    this.worldObj.setBlock(X + x, Y, Z + z, Dungeons.stoneDoor);
                                    this.worldObj.setBlock(X + x, Y - 1, Z + z, Dungeons.stoneDoor);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 1: {
                            for (int x = -3; x < 4; ++x) {
                                for (int z = -3; z < 4; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 1, Z + z, Dungeons.stoneDoor);
                                    this.worldObj.setBlock(X + x, Y + 2, Z + z, Dungeons.stoneDoor);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 2: {
                            for (int x = -2; x < 3; ++x) {
                                for (int z = -2; z < 3; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 3, Z + z, Dungeons.stoneDoor);
                                    this.worldObj.setBlock(X + x, Y + 4, Z + z, Dungeons.stoneDoor);
                                }
                            }
                            this.worldObj.setBlock(X - 2, Y + 5, Z - 2, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 2, Y + 5, Z - 2, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 2, Y + 5, Z + 2, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 2, Y + 5, Z + 2, Dungeons.stoneDoor);
                            ++this.stage;
                            break;
                        }
                        case 3: {
                            for (int x = -1; x < 2; ++x) {
                                for (int z = -1; z < 2; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 4, Z + z, Blocks.air);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 4: {
                            this.worldObj.setBlock(X - 5, Y, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 5, Y, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y, Z - 5, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y, Z + 5, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 6, Y, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 6, Y, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y, Z - 6, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y, Z + 6, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 7, Y, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 7, Y, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y, Z - 7, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y, Z + 7, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 6, Y - 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 6, Y - 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y - 1, Z - 6, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y - 1, Z + 6, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 7, Y - 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 7, Y - 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y - 1, Z - 7, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y - 1, Z + 7, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 8, Y - 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 8, Y - 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y - 1, Z - 8, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y - 1, Z + 8, Dungeons.stoneDoor);
                            ++this.stage;
                            break;
                        }
                        case 5: {
                            this.worldObj.setBlock(X - 4, Y + 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 4, Y + 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 1, Z - 4, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 1, Z + 4, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 5, Y + 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 5, Y + 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 1, Z - 5, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 1, Z + 5, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 6, Y + 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 6, Y + 1, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 1, Z - 6, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 1, Z + 6, Dungeons.stoneDoor);
                            ++this.stage;
                            break;
                        }
                        case 6: {
                            this.worldObj.setBlock(X - 4, Y + 2, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 4, Y + 2, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 2, Z - 4, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 2, Z + 4, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 5, Y + 2, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 5, Y + 2, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 2, Z - 5, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 2, Z + 5, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 4, Y + 3, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 4, Y + 3, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 3, Z - 4, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 3, Z + 4, Dungeons.stoneDoor);
                            ++this.stage;
                            break;
                        }
                        case 7: {
                            this.worldObj.setBlock(X - 3, Y + 3, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 3, Y + 3, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 3, Z - 3, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 3, Z + 3, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X - 3, Y + 4, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X + 3, Y + 4, Z, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 4, Z - 3, Dungeons.stoneDoor);
                            this.worldObj.setBlock(X, Y + 4, Z + 3, Dungeons.stoneDoor);
                            ++this.stage;
                            break;
                        }
                        case 8: {
                            this.worldObj.setBlock(X + 1, Y + 4, Z + 1, Dungeons.portalMontane);
                            this.worldObj.setBlock(X - 1, Y + 4, Z - 1, Dungeons.portalMontane);
                            this.worldObj.setBlock(X - 1, Y + 4, Z + 1, Dungeons.portalMontane);
                            this.worldObj.setBlock(X + 1, Y + 4, Z - 1, Dungeons.portalMontane);
                            this.worldObj.setBlock(X + 1, Y + 4, Z, Dungeons.portalMontane);
                            this.worldObj.setBlock(X - 1, Y + 4, Z, Dungeons.portalMontane);
                            this.worldObj.setBlock(X, Y + 4, Z + 1, Dungeons.portalMontane);
                            this.worldObj.setBlock(X, Y + 4, Z - 1, Dungeons.portalMontane);
                            this.worldObj.setBlock(X, Y + 4, Z, Dungeons.portalMontane);
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity((Entity)this, "step.wood", 1.5f, 1.0f);
                }
                if (this.stage >= 9) {
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
