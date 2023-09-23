

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityAmethystMonster extends EntityMob
{
    public EntityAmethystMonster(final World par1World) {
        super(par1World);
        this.setSize(2.3f, 2.3f);
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityLivingBase.class, 1.0, false));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHannibal.class, 0, true));
        this.experienceValue = 20;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }
    
    public int getTotalArmorValue() {
        return 18;
    }
    
    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0 && !this.worldObj.isRemote) {
                    list2.get(k2).addVelocity((list2.get(k2).posX - this.posX) / 4.0, 0.6, (list2.get(k2).posZ - this.posZ) / 4.0);
                    list2.get(k2).attackEntityFrom(DamageSource.magic, 6.0f);
                    list2.get(k2).hurtResistantTime = 0;
                    list2.get(k2).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 10.0f);
                }
            }
        }
    }
    
    protected String getLivingSound() {
        return "gibby_dungeons:crystalSay";
    }
    
    protected String getHurtSound() {
        return "gibby_dungeons:crystalHurt";
    }
    
    protected String getDeathSound() {
        return "gibby_dungeons:crystalDeath";
    }
    
    protected float getSoundPitch() {
        return 0.6f;
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isEntityInvulnerable() || par1DamageSource == DamageSource.magic) {
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
            return true;
        }
        return true;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(4);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidrockCrystal), (float)this.rand.nextInt(3));
        }
        if (r == 1) {
            this.entityDropItem(new ItemStack(Dungeons.amethyst), 1.0f);
        }
        if (this.rand.nextInt(30) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.amethystChestplate), 1.0f);
        }
        if (this.rand.nextInt(30) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.amethystRapier), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
