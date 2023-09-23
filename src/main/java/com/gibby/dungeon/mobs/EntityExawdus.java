

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityExawdus extends EntityMob implements IBossDisplayData
{
    boolean quakeAttack;
    int counter;
    
    public EntityExawdus(final World par1World) {
        super(par1World);
        this.quakeAttack = false;
        this.counter = 0;
        this.setSize(2.0f, 2.4f);
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(1000.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.7);
    }
    
    public int getTotalArmorValue() {
        return 20;
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
    
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < this.getMaxHealth() - this.getHealth() - 160.0f; ++i) {
            this.worldObj.spawnParticle("reddust", this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.0, 0.0);
        }
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus((IBossDisplayData)this, true);
                    this.func_145748_c_();
                }
            }
        }
        if (this.ticksExisted % 40 == 0 && !this.worldObj.isRemote) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(6.0, 6.0, 6.0));
            if (list3 != null) {
                for (int k3 = 0; k3 < list3.size(); ++k3) {
                    if (list3.get(k3) instanceof EntityPlayer && !list3.get(k3).capabilities.isCreativeMode) {
                        final double X = list3.get(k3).posX - this.posX;
                        final double Z = list3.get(k3).posZ - this.posZ;
                        this.addVelocity(X / 5.3, 0.5, Z / 5.3);
                    }
                }
            }
        }
        if (this.quakeAttack) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(15.0, 6.0, 15.0));
            if (list3 != null) {
                for (int k3 = 0; k3 < list3.size(); ++k3) {
                    if (list3.get(k3) instanceof EntityLivingBase) {
                        list3.get(k3).worldObj.playSoundAtEntity((Entity)list3.get(k3), "mob.bat.idle", 1.0f, 1.0f);
                        list3.get(k3).hurtResistantTime = 0;
                        list3.get(k3).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 0.01f);
                    }
                }
            }
            ++this.counter;
            this.heal(0.5f);
            if (this.counter > 6) {
                this.quakeAttack = false;
                this.counter = 0;
            }
        }
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0 && !this.worldObj.isRemote) {
                    this.quakeAttack = true;
                    list2.get(k2).addVelocity((list2.get(k2).posX - this.posX) / 2.0, 0.6, (list2.get(k2).posZ - this.posZ) / 2.0);
                    list2.get(k2).attackEntityFrom(DamageSource.magic, (this.getMaxHealth() - this.getHealth()) / 7.0f);
                }
            }
        }
    }
    
    protected void despawnEntity() {
    }
    
    protected boolean canDespawn() {
        return false;
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return super.attackEntityFrom(par1DamageSource, par2 / 2.0f);
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        return false;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.exawdusSmasher, 1);
        this.dropItem(Dungeons.magirockCrystal, 10);
        this.dropItem(Dungeons.voidrockCrystal, 10);
        this.dropItem(Dungeons.magicCoin, 10);
        this.dropItem(Dungeons.voidCoin, 10);
    }
}
