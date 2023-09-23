

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityBanditBoss extends EntityMob implements IBossDisplayData
{
    public EntityBanditBoss(final World par1World) {
        super(par1World);
        this.experienceValue = 60;
        this.addRandomArmor();
        this.setSize(1.4f, 3.0f);
    }
    
    protected String getLivingSound() {
        return "mob.villager.idle";
    }
    
    protected String getHurtSound() {
        return "mob.villager.hit";
    }
    
    protected String getDeathSound() {
        return "mob.villager.death";
    }
    
    protected float getSoundPitch() {
        return 0.45f;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
    }
    
    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus((IBossDisplayData)this, true);
                    this.func_145748_c_();
                }
            }
        }
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!super.attackEntityFrom(par1DamageSource, par2)) {
            return false;
        }
        final Entity entity = par1DamageSource.getEntity();
        if (this.riddenByEntity != entity && this.ridingEntity != entity) {
            if (entity != this) {
                this.entityToAttack = entity;
            }
            if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld) {
                final EntityBandit entityzombie = new EntityBandit(this.worldObj);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
            }
            return true;
        }
        if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld) {
            final EntityBandit entityzombie = new EntityBandit(this.worldObj);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld((Entity)entityzombie);
            if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entityzombie.onSpawnWithEgg((IEntityLivingData)null);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
        }
        return true;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(5);
        if (r < 4) {
            this.entityDropItem(new ItemStack(Dungeons.whittler), 1.0f);
        }
        this.dropItem(Items.gold_nugget, this.rand.nextInt(6));
        if (r == 4) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.whittler)), 1.0f);
        }
        this.dropItem(Dungeons.metalCoin, 2);
    }
    
    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.whittler));
    }
}
