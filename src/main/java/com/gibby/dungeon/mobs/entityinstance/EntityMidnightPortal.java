package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMidnightPortal extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityMidnightPortal(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityMidnightPortal(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.08f;
    }

    public EntityMidnightPortal(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 17 && this.worldObj.isRemote) {
            for (int i = 0; i < 60; ++i) {
                final double particlePositionX = Math.cos((this.ticksExisted + i) % 360) * ((double) (this.ticksExisted + i) / 4 % 40) / 7.0;
                final double particlePositionZ = Math.sin((this.ticksExisted + i) % 360) * ((double) (this.ticksExisted + i) / 4 % 40) / 7.0;
                final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX + 0.5, this.freezeY + 10.5, this.posZ + particlePositionZ + 0.5, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.0f, 0.0f, 0.7f);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            if (!this.worldObj.isRemote) {
                this.worldObj.setEntityState(this, (byte)17);
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
                                    this.worldObj.setBlock(X + x, Y, Z + z, Dungeons.darkBlueGlow);
                                    this.worldObj.setBlock(X + x, Y - 1, Z + z, Dungeons.darkBlueGlow);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 1: {
                            for (int x = -3; x < 4; ++x) {
                                for (int z = -3; z < 4; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 1, Z + z, Dungeons.darkBlueGlow);
                                    this.worldObj.setBlock(X + x, Y + 2, Z + z, Dungeons.darkBlueGlow);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 2: {
                            for (int x = -2; x < 3; ++x) {
                                for (int z = -2; z < 3; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 3, Z + z, Dungeons.darkBlueGlow);
                                    this.worldObj.setBlock(X + x, Y + 4, Z + z, Dungeons.darkBlueGlow);
                                }
                            }
                            this.worldObj.setBlock(X - 2, Y + 5, Z - 2, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 2, Y + 5, Z - 2, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 2, Y + 5, Z + 2, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 2, Y + 5, Z + 2, Dungeons.darkBlueGlow);
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
                            this.worldObj.setBlock(X - 5, Y, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 5, Y, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y, Z - 5, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y, Z + 5, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 6, Y, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 6, Y, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y, Z - 6, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y, Z + 6, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 7, Y, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 7, Y, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y, Z - 7, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y, Z + 7, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 6, Y - 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 6, Y - 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y - 1, Z - 6, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y - 1, Z + 6, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 7, Y - 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 7, Y - 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y - 1, Z - 7, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y - 1, Z + 7, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 8, Y - 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 8, Y - 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y - 1, Z - 8, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y - 1, Z + 8, Dungeons.darkBlueGlow);
                            ++this.stage;
                            break;
                        }
                        case 5: {
                            this.worldObj.setBlock(X - 4, Y + 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 4, Y + 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 1, Z - 4, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 1, Z + 4, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 5, Y + 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 5, Y + 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 1, Z - 5, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 1, Z + 5, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 6, Y + 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 6, Y + 1, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 1, Z - 6, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 1, Z + 6, Dungeons.darkBlueGlow);
                            ++this.stage;
                            break;
                        }
                        case 6: {
                            this.worldObj.setBlock(X - 4, Y + 2, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 4, Y + 2, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 2, Z - 4, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 2, Z + 4, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 5, Y + 2, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 5, Y + 2, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 2, Z - 5, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 2, Z + 5, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 4, Y + 3, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 4, Y + 3, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 3, Z - 4, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 3, Z + 4, Dungeons.darkBlueGlow);
                            ++this.stage;
                            break;
                        }
                        case 7: {
                            this.worldObj.setBlock(X - 3, Y + 3, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 3, Y + 3, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 3, Z - 3, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 3, Z + 3, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X - 3, Y + 4, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X + 3, Y + 4, Z, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 4, Z - 3, Dungeons.darkBlueGlow);
                            this.worldObj.setBlock(X, Y + 4, Z + 3, Dungeons.darkBlueGlow);
                            ++this.stage;
                            break;
                        }
                        case 8: {
                            this.worldObj.setBlock(X + 1, Y + 4, Z + 1, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X - 1, Y + 4, Z - 1, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X - 1, Y + 4, Z + 1, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X + 1, Y + 4, Z - 1, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X + 1, Y + 4, Z, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X - 1, Y + 4, Z, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X, Y + 4, Z + 1, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X, Y + 4, Z - 1, Dungeons.midnightPortal);
                            this.worldObj.setBlock(X, Y + 4, Z, Dungeons.midnightPortal);
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity(this, "step.wood", 1.5f, 1.0f);
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
