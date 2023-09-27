

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityZombieWarlord extends EntityZombie implements IBossDisplayData
{
    boolean haspotion;
    int charge;

    public EntityZombieWarlord(final World par1World) {
        super(par1World);
        this.haspotion = true;
        this.charge = 0;
        this.setSize(4.5f, 4.0f);
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityLivingBase.class, 1.0, false));
        this.canDespawn();
        this.experienceValue = 150;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.26);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
    }

    protected String getHurtSound() {
        return "random.anvil_land";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        boolean playerAround = false;
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus((IBossDisplayData)this, true);
                    this.func_145748_c_();
                    playerAround = true;
                }
            }
            if (!playerAround) {
                this.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 100));
                this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 100));
            }
        }
        final int qcounter = 0;
        if (this.rand.nextInt(60) == 0) {
            this.heal(1.0f);
        }
        if (this.getHealth() < 14.0f && this.haspotion) {
            this.setCurrentItemOrArmor(0, new ItemStack((Item)Items.potionitem, 1, 0));
            ++this.charge;
            if (this.charge > 30) {
                final EntityPotion potion = new EntityPotion(this.worldObj, (EntityLivingBase)this, 32732);
                this.worldObj.spawnEntityInWorld((Entity)potion);
                potion.motionY = 0.0;
                potion.motionX = this.motionX * 0.8;
                potion.motionY = this.motionY * 0.8;
                this.heal(15.0f);
                this.haspotion = false;
                this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.rubySword));
            }
        }
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
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
            if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld && this.rand.nextInt(4) == 0) {
                final EntityZombie entityzombie = new EntityZombie(this.worldObj);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
                final EntitySkeletonWarrior entitySkeleton = new EntitySkeletonWarrior(this.worldObj);
                entitySkeleton.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)entitySkeleton);
                if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                    entitySkeleton.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entitySkeleton.onSpawnWithEgg((IEntityLivingData)null);
                entitySkeleton.setPosition(this.posX, this.posY, this.posZ);
                final EntityGoblin entityGoblin = new EntityGoblin(this.worldObj);
                entityGoblin.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)entityGoblin);
                if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                    entityGoblin.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityGoblin.onSpawnWithEgg((IEntityLivingData)null);
                entityGoblin.setPosition(this.posX, this.posY, this.posZ);
            }
            return true;
        }
        if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld) {
            final EntitySkeletonWarrior entityzombie2 = new EntitySkeletonWarrior(this.worldObj);
            entityzombie2.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld((Entity)entityzombie2);
            if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                entityzombie2.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entityzombie2.onSpawnWithEgg((IEntityLivingData)null);
            entityzombie2.setPosition(this.posX, this.posY, this.posZ);
        }
        return true;
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.rubySword));
        this.setCurrentItemOrArmor(1, new ItemStack((Item)Items.iron_boots));
        this.setCurrentItemOrArmor(2, new ItemStack((Item)Items.iron_leggings));
        this.setCurrentItemOrArmor(3, new ItemStack((Item)Items.iron_chestplate));
        this.setCurrentItemOrArmor(4, new ItemStack((Item)Items.iron_helmet));
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(Dungeons.setLegendary(new ItemStack(Dungeons.rubySword)), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Dungeons.ruby, 7);
        }
        if (r == 2) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.rubyPickaxe)), 1.0f);
        }
        this.dropItem(Dungeons.metalCoin, 6);
        this.dropItem(Dungeons.dungeonPiece1, 1);
    }
}
