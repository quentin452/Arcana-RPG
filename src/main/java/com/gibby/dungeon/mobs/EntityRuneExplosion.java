

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;

public class EntityRuneExplosion extends EntityThrowable
{
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityRuneExplosion(final World par1World) {
        super(par1World);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityRuneExplosion(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityRuneExplosion(final World par1World, final double par2, final double par4, final double par6) {
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
            this.worldObj.spawnParticle("instantSpell", this.posX, this.posY, this.posZ, 0.0, 0.5, 0.0);
            for (int i = 0; i < 60; ++i) {
                final double particlePositionX = Math.cos(i * 6) * 1.6;
                final double particlePositionY = Math.sin(i * 6) * 1.6;
                final double particlePositionZ = Math.sin(i * 6) * 1.6;
                this.worldObj.spawnParticle("fireworksSpark", this.posX + particlePositionX, this.posY, this.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("fireworksSpark", this.posX + particlePositionX / 2.0, this.posY, this.posZ + particlePositionZ / 2.0, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("fireworksSpark", this.posX + particlePositionX / 4.0, this.posY, this.posZ + particlePositionZ / 4.0, 0.0, 0.0, 0.0);
            }
            if (this.counter > 40 && this.worldObj != null) {
                this.worldObj.playSoundAtEntity((Entity)this, "fire.fire", 1.0f, 1.0f);
                for (int i = 0; i < 300; ++i) {
                    this.worldObj.spawnParticle("witchMagic", this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.5, 0.0);
                }
                final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(5.0, 5.0, 5.0));
                if (list2 != null) {
                    for (int k2 = 0; k2 < list2.size(); ++k2) {
                        if (list2.get(k2) instanceof EntityLivingBase && !(list2.get(k2) instanceof EntityDeathBringer)) {
                            ((EntityLivingBase) list2.get(k2)).attackEntityFrom(DamageSource.magic, (float)(16.0 - this.getDistanceSqToEntity((Entity)list2.get(k2))));
                            if (Dungeons.randRange(0, 4) == 0) {
                                ((EntityLivingBase) list2.get(k2)).addPotionEffect(new PotionEffect(Dungeons.shock.id, 100, 0));
                            }
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
