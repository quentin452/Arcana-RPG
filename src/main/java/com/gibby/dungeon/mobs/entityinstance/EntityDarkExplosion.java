

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDarkExplosion extends EntityThrowable
{
    int generation;

    public EntityDarkExplosion(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.generation = 0;
    }

    public EntityDarkExplosion(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.generation = 0;
    }

    public EntityDarkExplosion(final World par1World) {
        super(par1World);
        this.generation = 0;
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 1000; ++i) {
                final float random = this.rand.nextFloat();
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + Dungeons.randRange(-30, 30), this.posY + Dungeons.randRange(-50, 30), this.posZ + Dungeons.randRange(-30, 30), random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
        this.setDead();
    }

    protected float getGravityVelocity() {
        return 0.04f;
    }

    protected float func_70182_d() {
        return 1.0f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 1000; ++i) {
                final float random = this.rand.nextFloat();
                final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + Dungeons.randRange(-30, 30), this.posY + Dungeons.randRange(-30, 30), this.posZ + Dungeons.randRange(-30, 30), random, random, random);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
        if (this.ticksExisted > 3) {
            this.setDead();
        }
    }

    public static class EntityRuneAltar extends EntityThrowable
    {
        boolean impacted;
        int counter;
        int stage;
        double freezeX;
        double freezeY;
        double freezeZ;

        public EntityRuneAltar(final World par1World) {
            super(par1World);
            this.stage = 0;
            this.freezeX = 0.0;
            this.freezeY = 0.0;
            this.freezeZ = 0.0;
        }

        public EntityRuneAltar(final World par1World, final EntityLivingBase par2EntityLivingBase) {
            super(par1World, par2EntityLivingBase);
            this.stage = 0;
            this.freezeX = 0.0;
            this.freezeY = 0.0;
            this.freezeZ = 0.0;
        }

        protected float getGravityVelocity() {
            return 0.1f;
        }

        public EntityRuneAltar(final World par1World, final double par2, final double par4, final double par6) {
            super(par1World, par2, par4, par6);
            this.stage = 0;
            this.freezeX = 0.0;
            this.freezeY = 0.0;
            this.freezeZ = 0.0;
        }

        @SideOnly(Side.CLIENT)
        public void handleHealthUpdate(final byte par1) {
            if (par1 == 17 && this.worldObj.isRemote) {
                double particlePositionX = Math.cos(this.ticksExisted % 360) * (5 - (double) this.ticksExisted / 40);
                double particlePositionZ = Math.sin(this.ticksExisted % 360) * (5 - (double) this.ticksExisted / 40);
                EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX + 0.5, this.freezeY + 0.5, this.posZ + particlePositionZ + 0.5, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.7f, 0.7f, 1.0f);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                particlePositionX = Math.cos(this.ticksExisted % 360) * this.ticksExisted / 40.0;
                particlePositionZ = Math.sin(this.ticksExisted % 360) * this.ticksExisted / 40.0;
                particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX + 0.5, this.freezeY + 0.5, this.posZ + particlePositionZ + 0.5, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.8f, 0.8f, 1.0f);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
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
                                final EntityItem rune = new EntityItem(this.worldObj, this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, new ItemStack(Dungeons.runeStone));
                                this.worldObj.spawnEntityInWorld(rune);
                                ++this.stage;
                                break;
                            }
                        }
                        this.worldObj.playSoundAtEntity(this, "random.orb", 1.5f, 1.0f);
                    }
                    if (this.stage == 5) {
                        this.worldObj.playSoundAtEntity(this, "random.fizz", 1.3f, 1.0f);
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
}
