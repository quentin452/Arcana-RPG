

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityHealEffect extends EntityThrowable
{
    public EntityHealEffect(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityHealEffect(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityHealEffect(final World par1World) {
        super(par1World);
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        this.setDead();
    }
    
    protected float func_70182_d() {
        return 0.0f;
    }
    
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 10; ++i) {
            final float randx = this.rand.nextFloat() - this.rand.nextFloat();
            final float randy = this.rand.nextFloat() - this.rand.nextFloat();
            final float randz = this.rand.nextFloat() - this.rand.nextFloat();
            this.worldObj.spawnParticle("heart", this.posX + randx, this.posY + randy, this.posZ + randz, (double)randx, (double)randy, (double)randz);
            this.worldObj.spawnParticle("happyVillager", this.posX + randy, this.posY + randx, this.posZ + randz, (double)randx, (double)randz, (double)randy);
        }
        this.setDead();
    }
}
