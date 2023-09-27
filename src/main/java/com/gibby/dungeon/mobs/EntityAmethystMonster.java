

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityAmethystMonster extends EntityMob
{
    public EntityAmethystMonster(final World par1World) {
        super(par1World);
        this.setSize(2.3f, 2.3f);
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityHannibal.class, 0, true));
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
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0 && !this.worldObj.isRemote) {
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 4.0, 0.6, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 4.0);
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.magic, 6.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage(this), 10.0f);
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
