package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityMidnightSizzler extends EntityThrowable
{
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityMidnightSizzler(final World par1World) {
    super(par1World);
    this.impacted = false;
    this.counter = 0;
    this.freezeX = 0.0;
    this.freezeY = 0.0;
    this.freezeZ = 0.0;
}

    public EntityMidnightSizzler(final World par1World, final EntityLivingBase par2EntityLivingBase) {
    super(par1World, par2EntityLivingBase);
    this.impacted = false;
    this.counter = 0;
    this.freezeX = 0.0;
    this.freezeY = 0.0;
    this.freezeZ = 0.0;
}

    public EntityMidnightSizzler(final World par1World, final double par2, final double par4, final double par6) {
    super(par1World, par2, par4, par6);
    this.impacted = false;
    this.counter = 0;
    this.freezeX = 0.0;
    this.freezeY = 0.0;
    this.freezeZ = 0.0;
}

    protected float getGravityVelocity() {
    return 0.01f;
}

    protected float func_70182_d() {
    return 0.4f;
}

    public void onUpdate() {
    super.onUpdate();
    this.worldObj.spawnParticle("instantSpell", this.posX, this.posY, this.posZ, 0.0, 0.5, 0.0);
    if (this.impacted) {
        ++this.counter;
        this.posY = this.freezeY;
        this.worldObj.playSoundAtEntity(this, "random.fizz", 0.1f, 1.0f);
        for (int i = 0; i < 5; ++i) {
            final double particlePositionX = Dungeons.randGauss() / 2.0;
            final double particlePositionY = Dungeons.randGauss() / 2.0;
            final double particlePositionZ = Dungeons.randGauss() / 2.0;
            this.worldObj.spawnParticle("fireworksSpark", this.posX + particlePositionX, this.posY, this.posZ + particlePositionZ, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX + particlePositionX / 2.0, this.posY, this.posZ + particlePositionZ / 2.0, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX + particlePositionX / 4.0, this.posY, this.posZ + particlePositionZ / 4.0, 0.0, 0.0, 0.0);
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(3.4, 3.4, 3.4));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityLivingBase && !(list2.get(k2) instanceof EntityMidnightTitan) && !(list2.get(k2) instanceof EntityMidnightMagician)) {
                    ((EntityLivingBase) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, (float)(8.0 - this.getDistanceSqToEntity((Entity)list2.get(k2))));
                }
            }
        }
        if (this.counter > 200 && this.worldObj != null) {
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
