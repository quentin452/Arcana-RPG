package com.gibby.dungeon.mobs.entityinstance;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTitanSpawner extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityTitanSpawner(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityTitanSpawner(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.1f;
    }

    public EntityTitanSpawner(final World par1World, final double par2, final double par4, final double par6) {
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
                final double particlePositionX = Math.cos(i * 6) * 4.0;
                final double particlePositionY = Math.sin(this.ticksExisted / 15 + i) * 2.0;
                final double particlePositionZ = Math.sin(i * 6) * 4.0;
                EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX, this.posY + particlePositionY + 8.0, this.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.0f, 0.0f, 1.0f);
                particle.setFadeColour(0);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionZ * 1.5, this.posY + particlePositionY + 8.0, this.posZ + particlePositionX * 1.5, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.0f, 0.0f, 1.0f);
                particle.setFadeColour(0);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
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
                            final EntityMidnightTitan entity = new EntityMidnightTitan(this.worldObj);
                            entity.setPosition(this.posX, this.posY + 0.5, this.posZ);
                            this.worldObj.spawnEntityInWorld(entity);
                            entity.onSpawnWithEgg(null);
                            entity.setPosition(this.posX, this.posY + 0.5, this.posZ);
                            ++this.stage;
                            break;
                        }
                    }
                    this.worldObj.playSoundAtEntity(this, "step.wood", 1.5f, 1.0f);
                }
                if (this.stage == 5) {
                    this.worldObj.playSoundAtEntity(this, "portal.travel", 1.3f, 1.0f);
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
