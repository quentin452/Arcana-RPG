

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

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
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus(this, true);
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
                this.worldObj.spawnEntityInWorld(entityzombie);
                if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg(null);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
            }
            return true;
        }
        if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld) {
            final EntityBandit entityzombie = new EntityBandit(this.worldObj);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(entityzombie);
            if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entityzombie.onSpawnWithEgg(null);
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
