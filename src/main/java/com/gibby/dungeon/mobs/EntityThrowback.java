

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityThrowback extends EntityThrowable
{
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityThrowback(final World par1World) {
        super(par1World);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityThrowback(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityThrowback(final World par1World, final double par2, final double par4, final double par6) {
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
                final double particlePositionX = Math.cos(i * 6) * 3.0;
                final double particlePositionZ = Math.sin(i * 6) * 3.0;
                this.worldObj.spawnParticle("witchMagic", this.posX + particlePositionX, this.posY, this.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("witchMagic", this.posX + particlePositionX / 2.0, this.posY, this.posZ + particlePositionZ / 2.0, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("witchMagic", this.posX + particlePositionX / 4.0, this.posY, this.posZ + particlePositionZ / 4.0, 0.0, 0.0, 0.0);
            }
            if (this.counter > 70 && this.worldObj != null) {
                this.worldObj.playSoundAtEntity(this, "mob.blaze.breathe", 1.0f, 1.4f);
                for (int i = 0; i < 1000; ++i) {
                    this.worldObj.spawnParticle("witchMagic", this.posX + Dungeons.randGauss() * 2.0, this.posY + Dungeons.randGauss() * 2.0, this.posZ + Dungeons.randGauss() * 2.0, 0.0, 0.5, 0.0);
                }
                final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(15.0, 15.0, 15.0));
                if (list2 != null) {
                    for (int k2 = 0; k2 < list2.size(); ++k2) {
                        if (list2.get(k2) instanceof EntityLivingBase && !(list2.get(k2) instanceof EntityDeathBringer)) {
                            final EntityLivingBase entity = (EntityLivingBase) list2.get(k2);
                            entity.attackEntityFrom(DamageSource.outOfWorld, (float)(17.0 - this.getDistanceSqToEntity(entity)));
                            entity.addPotionEffect(new PotionEffect(Dungeons.imbalance.id, 200, 0));
                            entity.motionX += entity.posX - this.posX;
                            entity.motionX += entity.posZ - this.posZ;
                        }
                    }
                }
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
