

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;

public class EntityBlizzardBall extends EntityThrowable
{
    public EntityBlizzardBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityBlizzardBall(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityBlizzardBall(final World par1World) {
        super(par1World);
    }
    
    protected float getGravityVelocity() {
        return 0.01f;
    }
    
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 10; ++i) {
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.snow) + "_0", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.ice) + "_0", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, var1.entityHit), 4.0f);
            if (var1.entityHit instanceof EntityLivingBase) {
                ((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
                ((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
            }
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}
