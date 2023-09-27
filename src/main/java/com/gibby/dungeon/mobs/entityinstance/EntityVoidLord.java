

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class EntityVoidLord extends EntityHermit implements IRangedAttackMob, IBossDisplayData
{
    private EntityAIArrowAttack aiArrowAttack;
    private boolean smokescreen;
    private int smokescreencounter;

    public EntityVoidLord(final World par1World) {
        super(par1World);
        this.aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 50, 25.0f);
        this.smokescreen = false;
        this.smokescreencounter = 0;
        this.experienceValue = 750;
        this.tasks.addTask(4, (EntityAIBase)this.aiArrowAttack);
        this.worldObj.playSoundAtEntity((Entity)this, "gibby_dungeons:voidMusic", 0.5f, 1.0f);
        this.setSize(1.4f, 3.0f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.4);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0);
    }

    protected String getLivingSound() {
        return "gibby_dungeons:voidSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:voidHit";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:voidDeath";
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.smokescreen) {
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 2.0, 10.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase && ((EntityLivingBase) list.get(k2)).onGround) {
                        ((EntityLivingBase) list.get(k2)).hurtResistantTime = 1;
                        ((EntityLivingBase) list.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 0.01f);
                        this.worldObj.playSoundAtEntity((Entity)list.get(k2), "portal.portal", 1.0f, 1.0f);
                    }
                }
            }
            ++this.smokescreencounter;
            if (this.smokescreencounter >= 50) {
                final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 2.0, 10.0));
                if (list2 != null) {
                    for (int k3 = 0; k3 < list2.size(); ++k3) {
                        if (list2.get(k3) instanceof EntityLivingBase && ((EntityLivingBase) list2.get(k3)).onGround) {
                            ((EntityLivingBase) list2.get(k3)).attackEntityFrom(DamageSource.outOfWorld, 6.0f);
                            ((EntityLivingBase) list2.get(k3)).addPotionEffect(new PotionEffect(Potion.nightVision.id, 100, 0));
                            ((EntityLivingBase) list2.get(k3)).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
                            this.worldObj.playSoundAtEntity((Entity)list2.get(k3), "portal.portal", 1.0f, 1.0f);
                        }
                    }
                }
                this.smokescreen = false;
                this.smokescreencounter = 0;
            }
        }
        if (this.getHealth() < 50.0f) {
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(40.0, 5.0, 40.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase) {
                        final double d0 = ((EntityLivingBase) list.get(k2)).posX - this.posX;
                        final double d2 = ((EntityLivingBase) list.get(k2)).posZ - this.posZ;
                        ((EntityLivingBase) list.get(k2)).motionX = d0 / (15.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this));
                        ((EntityLivingBase) list.get(k2)).motionZ = d2 / (15.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this));
                    }
                }
            }
        }
        boolean playerAround = false;
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k3 = 0; k3 < list2.size(); ++k3) {
                if (list2.get(k3) instanceof EntityPlayer) {
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
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        for (int z = 0; z < 100; ++z) {
            this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0);
        }
        final int rand = this.worldObj.rand.nextInt(4);
        if (rand == 0) {
            for (int i = 0; i < 3; ++i) {
                final EntityGreenBall ball = new EntityGreenBall(this.worldObj, (EntityLivingBase)this);
                final double d0 = par1.posX - this.posX;
                final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball.posY;
                final double d3 = par1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                ball.setThrowableHeading(d0, d2 + f1, d3, 1.0f, 6.0f);
                this.playSound("fireworks.blast", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)ball);
            }
        }
        if (rand == 1) {
            final EntityRedBall ball2 = new EntityRedBall(this.worldObj, (EntityLivingBase)this);
            final double d4 = par1.posX - this.posX;
            final double d5 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball2.posY;
            final double d6 = par1.posZ - this.posZ;
            final float f2 = MathHelper.sqrt_double(d4 * d4 + d6 * d6) * 0.2f;
            ball2.setThrowableHeading(d4, d5 + f2, d6, 1.6f, 12.0f);
            this.playSound("fireworks.blast", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)ball2);
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(10.0f);
            final EntityHealEffect ball3 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball3);
        }
        if (rand == 3) {
            this.smokescreen = true;
        }
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
            if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld && this.rand.nextInt(3) == 0) {
                final EntityVoidFiend entityzombie = new EntityVoidFiend(this.worldObj);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                entityzombie.setPosition(this.posX, this.posY, this.posZ);
            }
            return true;
        }
        if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld && this.rand.nextInt(3) == 0) {
            final EntityVoidFiend entityzombie = new EntityVoidFiend(this.worldObj);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld((Entity)entityzombie);
            if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entityzombie.onSpawnWithEgg((IEntityLivingData)null);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
        }
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(23, (Object)new Byte((byte)0));
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int getTotalArmorValue() {
        int i = 0;
        for (final ItemStack itemstack : this.getLastActiveItems()) {
            if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                final int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
                i += l;
            }
        }
        return i + 20;
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.voidSword)), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Dungeons.bedrock, this.rand.nextInt(10) + 5);
        }
        if (r == 2) {
            this.entityDropItem(Dungeons.setLegendary(new ItemStack(Dungeons.voidSword)), 1.0f);
        }
        this.dropItem(Dungeons.voidWand, 1);
        this.dropItem(Dungeons.metalCoin, 7);
        this.dropItem(Dungeons.magicCoin, 7);
        this.dropItem(Dungeons.dungeonPiece4, 1);
    }
}
