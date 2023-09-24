

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityDeathBringer extends EntityMob implements IBossDisplayData
{
    boolean throwback;
    boolean speedboost;

    public EntityDeathBringer(final World par1World) {
        super(par1World);
        this.setSize(1.5f, 3.0f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250.0);
    }

    public void onUpdate() {
        super.onUpdate();
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus((IBossDisplayData)this, true);
                    this.func_145748_c_();
                }
            }
        }
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(3.0, 3.0, 3.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if ((!(list2.get(k2) instanceof EntityLivingBase) && list2.get(k2) instanceof EntityThrowable && !(list2.get(k2) instanceof EntityRuneExplosion) && !(list2.get(k2) instanceof EntityThrowback)) || list2.get(k2) instanceof EntityArrow) {
                    ((Entity) list2.get(k2)).worldObj.newExplosion((Entity)this, ((Entity) list2.get(k2)).posX + 0.3, ((Entity) list2.get(k2)).posY - 0.3, ((Entity) list2.get(k2)).posZ, 1.0f, false, false);
                    ((Entity) list2.get(k2)).setDead();
                }
            }
        }
        if (this.ticksExisted % 50 == 0 && !this.worldObj.isRemote && this.getHealth() > 0.0f) {
            list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(12.0, 5.0, 12.0));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityPlayer) {
                        final EntityPlayer player = (EntityPlayer) list2.get(k2);
                        final EntityRuneExplosion explosion = new EntityRuneExplosion(this.worldObj, player.posX, player.posY, player.posZ);
                        this.worldObj.spawnEntityInWorld((Entity)explosion);
                    }
                }
            }
        }
        if (this.throwback && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            this.throwback = false;
            list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(12.0, 5.0, 12.0));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityPlayer) {
                        final EntityPlayer player = (EntityPlayer) list2.get(k2);
                        final EntityThrowback explosion2 = new EntityThrowback(this.worldObj, player.posX, player.posY, player.posZ);
                        this.worldObj.spawnEntityInWorld((Entity)explosion2);
                    }
                }
            }
        }
        if (this.speedboost && !this.worldObj.isRemote) {
            this.speedboost = false;
            this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 150, 15));
        }
    }

    public int getTotalArmorValue() {
        return 24;
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        return "portal.portal";
    }

    protected String getHurtSound() {
        return "mob.enderdragon.hit";
    }

    protected String getDeathSound() {
        return "portal.travel";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (Dungeons.randRange(0, 15) == 0) {
            this.throwback = true;
        }
        if (Dungeons.randRange(0, 15) == 0) {
            this.speedboost = true;
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.imbalance.id, 200, 0));
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.outOfWorld, 6.0f);
            ((EntityLivingBase)par1Entity).hurtResistantTime = 0;
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.entityDropItem(new ItemStack(Dungeons.deathBringerWand), 1.0f);
        this.entityDropItem(new ItemStack(Dungeons.voidCoin), 10.0f);
        this.dropItem(Dungeons.blackKey, 1);
    }
}
