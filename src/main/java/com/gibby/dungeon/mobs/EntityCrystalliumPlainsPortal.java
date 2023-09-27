

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCrystalliumPlainsPortal extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityCrystalliumPlainsPortal(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityCrystalliumPlainsPortal(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.08f;
    }

    public EntityCrystalliumPlainsPortal(final World par1World, final double par2, final double par4, final double par6) {
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
                    final double particlePositionZ = Math.sin(i * 6) * 6.0;
                    EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX, this.posY + 6.0, this.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.5f, 0.0f, 0.5f);
                    particle.setFadeColour(0);
                    particle.setTwinkle(true);
                    Minecraft.getMinecraft().effectRenderer.addEffect(particle);
                    particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX, this.posY + 8.0, this.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.8f, 0.2f, 0.8f);
                    particle.setFadeColour(0);
                    particle.setTwinkle(true);
                    Minecraft.getMinecraft().effectRenderer.addEffect(particle);
                    particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX, this.posY + 10.0, this.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 0.5f, 1.0f);
                    particle.setFadeColour(0);
                    particle.setTwinkle(true);
                    Minecraft.getMinecraft().effectRenderer.addEffect(particle);
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
                            for (int x = -4; x < 5; ++x) {
                                for (int z = -4; z < 5; ++z) {
                                    this.worldObj.setBlock(X + x, Y, Z + z, Dungeons.purpleBrick);
                                    this.worldObj.setBlock(X + x, Y - 1, Z + z, Dungeons.purpleBrick);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 1: {
                            for (int x = -3; x < 4; ++x) {
                                for (int z = -3; z < 4; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 1, Z + z, Dungeons.purpleBrick);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 2: {
                            for (int x = -2; x < 3; ++x) {
                                for (int z = -2; z < 3; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 2, Z + z, Dungeons.purpleBrick);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 3: {
                            for (int x = -1; x < 2; ++x) {
                                for (int z = -1; z < 2; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 2, Z + z, Blocks.air);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 4: {
                            this.worldObj.setBlock(X, Y + 2, Z, Dungeons.purpleBrick);
                            this.worldObj.setBlock(X, Y + 3, Z, Dungeons.purpleBrick);
                            ++this.stage;
                            break;
                        }
                        case 5: {
                            this.worldObj.setBlock(X, Y + 4, Z, Dungeons.purpleBrick);
                            this.worldObj.setBlock(X, Y + 5, Z, Dungeons.purpleBrick);
                            ++this.stage;
                            break;
                        }
                        case 6: {
                            this.worldObj.setBlock(X + 1, Y + 2, Z, Dungeons.portalCrystalPlains);
                            this.worldObj.setBlock(X - 1, Y + 2, Z, Dungeons.portalCrystalPlains);
                            this.worldObj.setBlock(X, Y + 2, Z + 1, Dungeons.portalCrystalPlains);
                            this.worldObj.setBlock(X, Y + 2, Z - 1, Dungeons.portalCrystalPlains);
                            ++this.stage;
                            break;
                        }
                        case 7: {
                            this.worldObj.setBlock(X + 1, Y + 2, Z + 1, Dungeons.portalCrystalPlains);
                            this.worldObj.setBlock(X - 1, Y + 2, Z - 1, Dungeons.portalCrystalPlains);
                            this.worldObj.setBlock(X - 1, Y + 2, Z + 1, Dungeons.portalCrystalPlains);
                            this.worldObj.setBlock(X + 1, Y + 2, Z - 1, Dungeons.portalCrystalPlains);
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity(this, "step.wood", 1.5f, 1.0f);
                }
                if (this.stage == 8) {
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
