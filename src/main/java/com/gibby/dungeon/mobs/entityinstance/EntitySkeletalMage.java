

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class EntitySkeletalMage extends EntitySkeleton implements IBossDisplayData
{

    public EntitySkeletalMage(final World par1World) {
        super(par1World);
        EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 15.0f);
        EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2, false);
        this.tasks.addTask(4, aiArrowAttack);
        this.addPotionEffect(new PotionEffect(Dungeons.magicBoost.id, 10000, 0));
        this.experienceValue = 100;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(48.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2500000417232513);
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

    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand == 0) {
            final EntityExplosive ball = new EntityExplosive(this.worldObj, this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(ball);
        }
        if (rand == 1) {
            for (int i = 0; i < 15; ++i) {
                final EntityExplosive ball2 = new EntityExplosive(this.worldObj, this);
                final double d4 = par1.posX - this.posX;
                final double d5 = 1000.0;
                final double d6 = par1.posZ - this.posZ;
                final float f2 = MathHelper.sqrt_double(d4 * d4 + d6 * d6) * 0.2f;
                ball2.setThrowableHeading(d4, d5 + f2, d6, 1.6f, 12.0f);
                this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(ball2);
            }
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(8.0f);
            this.worldObj.spawnParticle("heart", this.posX, this.posY + 1.0, this.posZ, randD, randD, randD);
            this.worldObj.spawnParticle("happyVillager", this.posX, this.posY + 1.0, this.posZ, randD, randD, randD);
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
            if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld && this.rand.nextInt(2) == 0) {
                final EntitySkeleton entityzombie = new EntitySkeleton(this.worldObj);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld(entityzombie);
                if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg(null);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
            }
            return true;
        }
        if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld && this.rand.nextInt(2) == 0) {
            final EntitySkeleton entityzombie = new EntitySkeleton(this.worldObj);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(entityzombie);
            if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entityzombie.onSpawnWithEgg(null);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
        }
        return true;
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.forceWand));
    }

    public void setCombatTask() {
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.forceWand), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Items.bone, 3);
        }
        if (r == 2) {
            this.entityDropItem(new ItemStack(Dungeons.magicGem), 1.0f);
        }
        this.dropItem(Dungeons.magicCoin, 1);
    }
}
