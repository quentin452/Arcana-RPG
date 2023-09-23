

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityWitherSkeletonMinion extends EntityIronGolem
{
    public EntityWitherSkeletonMinion(final World par1World) {
        super(par1World);
        this.setSize(0.6f, 1.4f);
        this.onUpdate();
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 5.0f);
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted > 600) {
            this.setDead();
        }
        this.worldObj.spawnParticle("largeSmoke", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
    }
}
