

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityAmethystPortal extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityAmethystPortal(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityAmethystPortal(final World par1World, final EntityLivingBase par2EntityLivingBase) {
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

    public EntityAmethystPortal(final World par1World, final double par2, final double par4, final double par6) {
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
            this.worldObj.spawnParticle("mobSpellAmbient", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("instantSpell", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
            }
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("witchMagic", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
            }
            for (int i = 0; i < 40; ++i) {
                final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
                final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
                final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
                this.worldObj.spawnParticle("townaura", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
            }
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            if (this.counter > 40) {
                final int X = (int)this.freezeX;
                final int Y = (int)this.freezeY;
                final int Z = (int)this.freezeZ;
                for (int j = 0; j < 40; ++j) {
                    final int rand2Y2 = this.rand.nextInt(10) - this.rand.nextInt(10);
                    final double rand2X2 = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final double rand2Z2 = this.rand.nextGaussian() - this.rand.nextGaussian();
                    this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.glowstone) + "_0", this.posX + rand2X2, this.posY + rand2Y2, this.posZ + rand2Z2, -(rand2X2 + rand2Z2 / 2.0), 0.5, -(rand2Z2 + rand2X2 / 2.0));
                }
                if (!this.worldObj.isRemote && this.ticksExisted % 40 == 0) {
                    switch (this.stage) {
                        case 0: {
                            for (int x = -4; x < 5; ++x) {
                                for (int z = -4; z < 5; ++z) {
                                    this.worldObj.setBlock(X + x, Y, Z + z, Dungeons.amethystCracks);
                                    this.worldObj.setBlock(X + x, Y - 1, Z + z, Dungeons.amethystCracks);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 1: {
                            for (int x = -3; x < 4; ++x) {
                                for (int z = -3; z < 4; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 1, Z + z, Dungeons.amethystStone);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 2: {
                            for (int x = -2; x < 3; ++x) {
                                for (int z = -2; z < 3; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 2, Z + z, Dungeons.amethystCracks);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 3: {
                            for (int x = -1; x < 2; ++x) {
                                for (int z = -1; z < 2; ++z) {
                                    this.worldObj.setBlock(X + x, Y + 2, Z + z, Dungeons.amethystStone);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                        case 4: {
                            this.worldObj.setBlock(X, Y + 2, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 5: {
                            this.worldObj.setBlock(X + 2, Y + 3, Z, Dungeons.amethystStone);
                            this.worldObj.setBlock(X - 2, Y + 3, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 6: {
                            this.worldObj.setBlock(X + 2, Y + 4, Z, Dungeons.amethystStone);
                            this.worldObj.setBlock(X - 2, Y + 4, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 7: {
                            this.worldObj.setBlock(X + 2, Y + 5, Z, Dungeons.amethystStone);
                            this.worldObj.setBlock(X - 2, Y + 5, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 8: {
                            this.worldObj.setBlock(X + 2, Y + 6, Z, Dungeons.amethystStone);
                            this.worldObj.setBlock(X - 2, Y + 6, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 9: {
                            this.worldObj.setBlock(X + 2, Y + 7, Z, Dungeons.amethystStone);
                            this.worldObj.setBlock(X - 2, Y + 7, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 10: {
                            this.worldObj.setBlock(X + 1, Y + 7, Z, Dungeons.amethystStone);
                            this.worldObj.setBlock(X - 1, Y + 7, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 11: {
                            this.worldObj.setBlock(X, Y + 7, Z, Dungeons.amethystStone);
                            ++this.stage;
                            break;
                        }
                        case 12: {
                            for (int x = -1; x < 2; ++x) {
                                for (int y = 3; y < 7; ++y) {
                                    this.worldObj.setBlock(X + x, Y + y, Z, Dungeons.portalAmethyst);
                                }
                            }
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity(this, "step.wood", 1.5f, 1.0f);
                }
                if (this.stage == 13) {
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
