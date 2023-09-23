

package com.gibby.dungeon;

import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.potion.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;

public class EntityIceShielder extends EntityFlying implements IRangedAttackMob
{
    private EntityAIArrowAttack aiArrowAttack;
    protected EntityPlayer targetedEntity;
    public int charge;
    
    public EntityIceShielder(final World par1World) {
        super(par1World);
        this.aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 60, 10.0f);
        this.experienceValue = 10;
        this.tasks.addTask(3, (EntityAIBase)this.aiArrowAttack);
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5);
    }
    
    public int getTotalArmorValue() {
        return 16;
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase var1, final float var2) {
        if (!this.worldObj.isRemote) {
            final EntityIceShieldBall ball = new EntityIceShieldBall(this.worldObj, (EntityLivingBase)this);
            final double d0 = var1.posX - this.posX;
            final double d2 = var1.posY - ball.posY;
            final double d3 = var1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            this.worldObj.playSoundAtEntity((Entity)this, "random.click", 1.0f, 1.0f);
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.0f, 12.0f);
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(14.0, 14.0, 14.0));
        if (list != null) {
            for (int k2 = 0; k2 < list.size(); ++k2) {
                if (list.get(k2) instanceof EntityPlayer && this.targetedEntity == null) {
                    this.targetedEntity = list.get(k2);
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
        return "random.fuse";
    }
    
    protected String getHurtSound() {
        return "dig.glass";
    }
    
    protected String getDeathSound() {
        return "dig.glass";
    }
    
    protected float getSoundPitch() {
        return 0.7f;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Dungeons.iceRod, 1);
        }
    }
}
