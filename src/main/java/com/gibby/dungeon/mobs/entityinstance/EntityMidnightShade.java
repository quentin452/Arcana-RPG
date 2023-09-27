

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.List;

public class EntityMidnightShade extends EntityFlying implements IRangedAttackMob, IBossDisplayData
{
    private EntityAIArrowAttack aiArrowAttack;
    protected EntityPlayer targetedEntity;
    public int charge;

    public EntityMidnightShade(final World par1World) {
        super(par1World);
        this.aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 60, 10.0f);
        this.experienceValue = 10;
        this.tasks.addTask(3, (EntityAIBase)this.aiArrowAttack);
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0);
    }

    public int getTotalArmorValue() {
        return 22;
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase var1, final float var2) {
        if (!this.worldObj.isRemote) {
            final int rand = Dungeons.randRange(0, 4);
            if (rand < 2) {
                final EntityBlackEnergy ball = new EntityBlackEnergy(this.worldObj, (EntityLivingBase)this);
                final double d0 = var1.posX - this.posX;
                final double d2 = var1.posY - ball.posY;
                final double d3 = var1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                this.worldObj.playSoundAtEntity((Entity)this, "mob.wither.spawn", 1.0f, 1.0f);
                ball.setThrowableHeading(d0, d2 + f1, d3, 1.0f, 5.0f);
                this.worldObj.spawnEntityInWorld((Entity)ball);
            }
            if (rand == 2) {
                final EntityGroundShade ball2 = new EntityGroundShade(this.worldObj, (EntityLivingBase)this);
                final double d0 = var1.posX - this.posX;
                final double d2 = var1.posY - ball2.posY;
                final double d3 = var1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0f, 1.0f);
                ball2.setThrowableHeading(d0 / 2.0, d2 + f1, d3 / 2.0, 1.0f, 12.0f);
                this.worldObj.spawnEntityInWorld((Entity)ball2);
            }
            if (rand > 2) {
                final EntityHealEffect ball3 = new EntityHealEffect(this.worldObj, this.posX, this.posY, this.posZ);
                this.heal(5.0f);
                this.worldObj.playSoundAtEntity((Entity)this, "random.harp", 4.0f, 1.0f);
                this.worldObj.spawnEntityInWorld((Entity)ball3);
            }
        }
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
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (!this.worldObj.isRemote && this.ticksExisted % 160 == 0) {
            for (int i = 0; i < 5; ++i) {
                final EntityIceWanderer ball = new EntityIceWanderer(this.worldObj, this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)ball);
            }
        }
        final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(14.0, 14.0, 14.0));
        if (list3 != null) {
            for (int k3 = 0; k3 < list3.size(); ++k3) {
                if (list3.get(k3) instanceof EntityPlayer && this.targetedEntity == null) {
                    this.targetedEntity = (EntityPlayer) list3.get(k3);
                }
            }
        }
        if (this.targetedEntity != null) {
            ++this.charge;
            if (this.charge > 50 && this.canEntityBeSeen((Entity)this.targetedEntity)) {
                this.attackEntityWithRangedAttack((EntityLivingBase)this.targetedEntity, 0.0f);
                this.charge = 0;
            }
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 30.0);
            if (this.targetedEntity != null && this.targetedEntity.getDistanceToEntity((Entity)this) > 10.0f) {
                final double d0 = this.targetedEntity.posX - this.posX;
                final double d2 = this.targetedEntity.boundingBox.minY + this.targetedEntity.height / 2.0f - (this.posY + this.height / 2.0f);
                final double d3 = this.targetedEntity.posZ - this.posZ;
                this.motionX = d0 / 30.0;
                this.motionY = d2 / 30.0 + 0.1;
                this.motionZ = d3 / 30.0;
            }
        }
    }

    protected String getLivingSound() {
        return "gibby_dungeons:midnightSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:voidHit";
    }

    protected String getDeathSound() {
        return "minecraft.none";
    }

    protected float getSoundPitch() {
        return 0.7f;
    }

    protected float getSoundVolume() {
        return 0.7f;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Dungeons.corruptedSoul, 2);
        }
        else {
            this.dropItem(Dungeons.corruptedBow, 1);
        }
    }
}
