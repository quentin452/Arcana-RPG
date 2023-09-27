

package com.gibby.dungeon.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityGroundShade extends EntityThrowable
{
    boolean impacted;
    int counter;
    double freezeY;

    public EntityGroundShade(final World par1World) {
        super(par1World);
        this.freezeY = 0.0;
    }

    public EntityGroundShade(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.freezeY = 0.0;
    }

    public EntityGroundShade(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.freezeY = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        final int X = (int)this.posX;
        int Y = (int)this.freezeY;
        final int Z = (int)this.posZ;
        for (int i = 0; i < 100; ++i) {
            if (this.freezeY != 0.0) {
                final Block block = (this.worldObj.getBlock(X, Y, Z) != Blocks.air) ? this.worldObj.getBlock(X, Y, Z) : Blocks.dirt;
                final double particlePosX = this.posX + (this.rand.nextGaussian() - this.rand.nextGaussian());
                final double particlePosY = this.freezeY + (this.rand.nextGaussian() - this.rand.nextGaussian()) / 5.0;
                final double particlePosZ = this.posZ + (this.rand.nextGaussian() - this.rand.nextGaussian());
                this.worldObj.spawnParticle("fireworksSpark", particlePosX, particlePosY, particlePosZ, (double)this.rand.nextFloat(), (double)(this.rand.nextFloat() / 2.0f), (double)this.rand.nextFloat());
            }
        }
        if (this.impacted) {
            ++this.counter;
            this.posY = this.freezeY;
            if (this.worldObj.getBlock(X, Y, Z) == Blocks.air) {
                --this.freezeY;
                Y = (int)this.freezeY;
            }
            else if (this.worldObj.getBlock(X, Y + 1, Z) != Blocks.air) {
                ++this.freezeY;
                Y = (int)this.freezeY;
            }
            this.worldObj.playSoundAtEntity((Entity)this, "random.fizz", 0.7f, 0.7f);
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(5.0, 2.0, 5.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase && !(list.get(k2) instanceof EntityMidnightShade)) {
                        ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 4.0f);
                    }
                }
            }
            if (this.counter > 60) {
                this.setDead();
            }
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj != null && var1.entityHit == null) {
            this.impacted = true;
            if (this.freezeY == 0.0) {
                this.freezeY = this.posY;
            }
        }
    }
}
