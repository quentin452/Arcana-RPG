

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySandBall extends EntityThrowable
{
    public EntitySandBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntitySandBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntitySandBall(final World par1World) {
        super(par1World);
    }

    protected float getGravityVelocity() {
        return 0.01f;
    }

    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 10; ++i) {
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
        }
        for (int i = 0; i < 10; ++i) {
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.sand) + "_0", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit instanceof EntityLivingBase) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 3.0f);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}
