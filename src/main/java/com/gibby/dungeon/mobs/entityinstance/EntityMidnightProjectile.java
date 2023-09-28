package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMidnightProjectile extends EntityThrowable
{
    public EntityMidnightProjectile(final World par1World) {
        super(par1World);
    }

    public EntityMidnightProjectile(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityMidnightProjectile(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    protected float func_70182_d() {
        return 0.8f;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 17 && this.worldObj.isRemote) {
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss() / 10.0, this.posY + Dungeons.randGauss() / 10.0, this.posZ + Dungeons.randGauss() / 10.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.0f, 0.0f, 1.0f);
            particle.setFadeColour(0);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            final int velslowdown = 10000;
            final int dirChange = 90;
            this.addVelocity((this.motionX + Dungeons.randGauss() * dirChange) / velslowdown, (this.motionY + Dungeons.randGauss() * dirChange / 2.0) / velslowdown, (this.motionZ + Dungeons.randGauss() * dirChange) / velslowdown);
        }
        if (!this.worldObj.isRemote) {
            this.worldObj.setEntityState(this, (byte)17);
        }
        if (this.ticksExisted > 160 + this.rand.nextInt(40)) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase && !(var1.entityHit instanceof EntityThrowable) && !(var1.entityHit instanceof EntityMidnightTitan)) {
            var1.entityHit.attackEntityFrom(DamageSource.outOfWorld, 20.0f);
        }
        this.setDead();
    }
}
