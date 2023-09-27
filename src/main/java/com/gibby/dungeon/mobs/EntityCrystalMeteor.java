

package com.gibby.dungeon.mobs;

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

public class EntityCrystalMeteor extends EntityThrowable
{
    public EntityCrystalMeteor(final World par1World) {
        super(par1World);
    }

    public EntityCrystalMeteor(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityCrystalMeteor(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.03f;
    }

    protected float func_70182_d() {
        return 0.9f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 10; ++i) {
                final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX - this.motionX * i, this.posY - this.motionY * i, this.posZ - this.motionZ * i, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.5f, 0.0f, 0.5f);
                particle.setFadeColour(10000);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 60; ++i) {
                EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.5f, 0.0f, 0.5f);
                particle.setFadeColour(0);
                particle.setTwinkle(true);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.3f, 0.0f, 0.3f);
                particle.setFadeColour(0);
                particle.setTwinkle(true);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.7f, 0.0f, 0.7f);
                particle.setFadeColour(0);
                particle.setTwinkle(true);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY - 2.0, this.posZ, 14.0f, false, true);
            final int X = (int)this.posX;
            final int Y = (int)this.posY;
            final int Z = (int)this.posZ;
            for (int x = -20; x < 20; ++x) {
                for (int y = -10; y < 10; ++y) {
                    for (int z = -20; z < 20; ++z) {
                        if (this.worldObj.getBlock(X + x, Y + y, z + Z) == Dungeons.amethystStone && this.worldObj.getBlock(X + x, Y + y + 1, z + Z) == Blocks.air) {
                            this.worldObj.setBlock(X + x, Y + y, z + Z, Dungeons.amethystCracks);
                            if (this.rand.nextInt(10) == 0) {
                                this.worldObj.setBlock(X + x, Y + y, z + Z, Dungeons.crystalOre);
                            }
                        }
                    }
                }
            }
        }
        this.setDead();
    }
}
