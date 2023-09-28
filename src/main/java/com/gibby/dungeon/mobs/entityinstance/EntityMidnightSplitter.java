package com.gibby.dungeon.mobs.entityinstance;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMidnightSplitter extends EntityThrowable
{
    public EntityMidnightSplitter(final World par1World) {
        super(par1World);
    }

    public EntityMidnightSplitter(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityMidnightSplitter(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    protected float func_70182_d() {
        return 0.4f;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 17 && this.worldObj.isRemote) {
            final double motionX = this.motionX / 10.0;
            final double motionY = this.motionX / 10.0;
            final double motionZ = this.motionZ / 10.0;
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.7f, 0.1f, 1.0f);
            particle.setFadeColour(0);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            this.worldObj.setEntityState(this, (byte)17);
        }
        if (this.ticksExisted % 15 == 0 && !this.worldObj.isRemote) {
            final EntityMidnightProjectile proj = new EntityMidnightProjectile(this.worldObj, this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(proj);
        }
        if (this.ticksExisted > 80) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit instanceof EntityLivingBase) {
            var1.entityHit.attackEntityFrom(DamageSource.outOfWorld, 18.0f);
            var1.entityHit.addVelocity((var1.entityHit.posX - this.posX) / 3.0, 0.5, (var1.entityHit.posZ - this.posZ) / 3.0);
            this.setDead();
        }
    }
}
