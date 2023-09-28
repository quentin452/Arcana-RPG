package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPowerupEffect extends EntityThrowable
{
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityPowerupEffect(final World par1World) {
        super(par1World);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityPowerupEffect(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityPowerupEffect(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            for (int i = 0; i < 60; ++i) {
                final double particlePositionX = Dungeons.randGauss() * 6.0;
                final double particlePositionY = this.rand.nextGaussian() * 6.0;
                final double particlePositionZ = Dungeons.randGauss() * 6.0;
                this.worldObj.spawnParticle("reddust", this.posX + particlePositionX, this.freezeY + particlePositionY - 1.0, this.posZ + particlePositionZ, 0.0, 0.4, 0.0);
                this.worldObj.spawnParticle("instantSpell", this.posX + particlePositionX, this.freezeY + particlePositionY - 1.0, this.posZ + particlePositionZ, 0.0, 0.4, 0.0);
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
