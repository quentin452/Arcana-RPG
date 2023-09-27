

package com.gibby.dungeon.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityColdWind extends EntityThrowable
{
    public EntityColdWind(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntityColdWind(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityColdWind(final World par1World) {
        super(par1World);
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.getThrower()), 1.0f);
        }
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        final float randx = (float)(this.rand.nextGaussian() - this.rand.nextGaussian());
        final float randy = (float)(this.rand.nextGaussian() - this.rand.nextGaussian());
        final float randz = (float)(this.rand.nextGaussian() - this.rand.nextGaussian());
        this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.ice) + "_0", this.posX, this.posY, this.posZ, (double)randx, (double)randy, (double)randz);
        this.worldObj.spawnParticle("cloud", this.posX, this.posY, this.posZ, (double)randy, (double)randx, (double)randz);
    }
}
