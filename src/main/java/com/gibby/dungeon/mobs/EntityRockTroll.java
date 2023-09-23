

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityRockTroll extends EntityMob
{
    public EntityRockTroll(final World par1World) {
        super(par1World);
        this.setSize(2.0f, 2.4f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5);
    }

    public int getTotalArmorValue() {
        return 18;
    }

    protected String getLivingSound() {
        return "mob.zombie.say";
    }

    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }

    protected String getDeathSound() {
        return "mob.zombie.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0 && !this.worldObj.isRemote) {
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 2.0, 0.6, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 2.0);
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 4.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 10.0f);
                }
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 3.0f);
    }
}
