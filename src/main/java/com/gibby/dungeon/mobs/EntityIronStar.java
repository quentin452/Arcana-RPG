

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityIronStar extends EntityThrowable
{
    public EntityIronStar(final World par1World) {
        super(par1World);
        this.setDead();
    }
    
    public EntityIronStar(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityIronStar(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.causeThrownDamage((Entity)this.getThrower(), var1.entityHit), 7.0f);
        }
    }
}
