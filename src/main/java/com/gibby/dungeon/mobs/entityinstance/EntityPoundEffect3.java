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

public class EntityPoundEffect3 extends EntityThrowable
{
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityPoundEffect3(final World par1World) {
        super(par1World);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityPoundEffect3(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityPoundEffect3(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 17 && this.worldObj.isRemote) {
            for (int i = 0; i < 60; ++i) {
                final double particlePositionX = Math.cos(i * 6) * 2.0;
                final double particlePositionY = Math.sin(i * 6) * 2.0;
                final double particlePositionZ = Math.sin(i * 6) * 2.0;
                if (this.ticksExisted > 12) {
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX * 4.0, this.freezeY + 0.2, this.posZ + particlePositionZ * 4.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.1f, 0.1f, 1.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
                if (this.ticksExisted > 9) {
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX * 2.0, this.freezeY + 0.2, this.posZ + particlePositionZ * 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.1f, 0.1f, 1.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
                if (this.ticksExisted > 6) {
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX, this.freezeY + 0.2, this.posZ + particlePositionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.1f, 0.1f, 1.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
                if (this.ticksExisted > 3) {
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX / 2.0, this.freezeY + 0.2, this.posZ + particlePositionZ / 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.1f, 0.1f, 1.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
                final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + particlePositionX / 4.0, this.freezeY + 0.2, this.posZ + particlePositionZ / 4.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.1f, 0.1f, 1.0f);
                particle.setFadeColour(0);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            if (!this.worldObj.isRemote) {
                this.worldObj.setEntityState(this, (byte)17);
            }
            if (this.counter > 20 && this.worldObj != null) {
                this.setDead();
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
