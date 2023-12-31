

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntityIceSpirit extends EntityFlying implements IRangedAttackMob, IBossDisplayData
{
    protected EntityPlayer targetedEntity;
    public int charge;

    public EntityIceSpirit(final World par1World) {
        super(par1World);
        EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 10.0f);
        this.experienceValue = 10;
        this.tasks.addTask(3, aiArrowAttack);
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
    }

    public int getTotalArmorValue() {
        return 18;
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase var1, final float var2) {
        if (!this.worldObj.isRemote) {
            final int rand = Dungeons.randRange(0, 4);
            if (rand < 2) {
                final EntityIceShieldBall ball = new EntityIceShieldBall(this.worldObj, this);
                final double d0 = var1.posX - this.posX;
                final double d2 = var1.posY - ball.posY;
                final double d3 = var1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                this.worldObj.playSoundAtEntity(this, "random.orb", 1.0f, 1.0f);
                ball.setThrowableHeading(d0, d2 + f1, d3, 1.0f, 5.0f);
                this.worldObj.spawnEntityInWorld(ball);
            }
            if (rand == 2) {
                final EntityIceSpiker ball2 = new EntityIceSpiker(this.worldObj, this);
                final double d0 = var1.posX - this.posX;
                final double d2 = var1.posY - ball2.posY;
                final double d3 = var1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                this.worldObj.playSoundAtEntity(this, "random.orb", 1.0f, 1.0f);
                ball2.setThrowableHeading(d0 / 2.0, d2 + f1, d3 / 2.0, 1.0f, 12.0f);
                this.worldObj.spawnEntityInWorld(ball2);
            }
            if (rand > 2) {
                final EntityHealEffect ball3 = new EntityHealEffect(this.worldObj, this.posX, this.posY, this.posZ);
                this.heal(5.0f);
                this.worldObj.playSoundAtEntity(this, "random.harp", 4.0f, 1.0f);
                this.worldObj.spawnEntityInWorld(ball3);
            }
        }
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    bossDisplay.setBossStatus(this, true);
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
                this.worldObj.spawnEntityInWorld(ball);
            }
        }
        final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(14.0, 14.0, 14.0));
        if (list3 != null) {
            for (int k3 = 0; k3 < list3.size(); ++k3) {
                if (list3.get(k3) instanceof EntityPlayer && this.targetedEntity == null) {
                    this.targetedEntity = (EntityPlayer) list3.get(k3);
                }
            }
        }
        if (this.targetedEntity != null) {
            ++this.charge;
            if (this.charge > 50 && this.canEntityBeSeen(this.targetedEntity)) {
                this.attackEntityWithRangedAttack(this.targetedEntity, 0.0f);
                this.charge = 0;
            }
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 30.0);
            if (this.targetedEntity != null && this.targetedEntity.getDistanceToEntity(this) > 10.0f) {
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

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.dropItem(Dungeons.blueKey, 1);
        this.dropItem(Dungeons.icefireWand, 1);
        this.entityDropItem(new ItemStack(Dungeons.magicCoin), 10.0f);
    }
}
