

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntityDarkKnight extends EntityMob implements IBossDisplayData
{
    private boolean quakeattack;
    private int length;
    private int attackTimer;

    public EntityDarkKnight(final World par1World) {
        super(par1World);
        this.quakeattack = false;
        this.length = 0;
        this.attackTimer = 0;
        this.experienceValue = 750;
        this.setSize(3.0f, 4.6f);
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityLivingBase.class, 6.0, false));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHannibal.class, 0, true));
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(360.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    protected String getLivingSound() {
        return "mob.wither.idle";
    }

    protected String getHurtSound() {
        return "mob.blaze.hit";
    }

    protected String getDeathSound() {
        return "mob.blaze.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        ++this.attackTimer;
        if (this.getHealth() < 150.0f) {
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 5.0, 20.0));
            if (list != null) {
                for (int k2 = 0; k2 < list.size(); ++k2) {
                    if (list.get(k2) instanceof EntityLivingBase && ((EntityLivingBase) list.get(k2)).onGround) {
                        final double d0 = ((EntityLivingBase) list.get(k2)).posX - this.posX;
                        final double d2 = ((EntityLivingBase) list.get(k2)).posZ - this.posZ;
                        ((EntityLivingBase) list.get(k2)).motionX = -d0 / (11.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this));
                        ((EntityLivingBase) list.get(k2)).motionZ = -d2 / (11.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this));
                    }
                }
            }
        }
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.2, 1.2, 1.2));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityLivingBase && this.attackTimer >= 30) {
                    this.attackEntityAsMob((Entity)list2.get(k2));
                    this.attackTimer = 0;
                }
            }
        }
        boolean playerAround = false;
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k3 = 0; k3 < list2.size(); ++k3) {
                if (list2.get(k3) instanceof EntityPlayer) {
                    bossDisplay.setBossStatus(this, true);
                    this.func_145748_c_();
                    playerAround = true;
                }
            }
            if (!playerAround) {
                this.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 100));
                this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 100));
            }
        }
        if (this.quakeattack) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 3.0, 10.0));
            if (list3 != null) {
                for (int k4 = 0; k4 < list3.size(); ++k4) {
                    if (list3.get(k4) instanceof EntityLivingBase) {
                        ((EntityLivingBase) list3.get(k4)).hurtResistantTime = 0;
                        ((EntityLivingBase) list3.get(k4)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 0.01f);
                    }
                }
            }
            ++this.length;
            if (this.length > 10) {
                this.quakeattack = false;
                this.length = 0;
                this.heal(20.0f);
            }
        }
    }

    public int getTotalArmorValue() {
        int i = 0;
        for (final ItemStack itemstack : this.getLastActiveItems()) {
            if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                final int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
                i += l;
            }
        }
        return i + 22;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.outOfWorld, 8.0f);
            for (int i = 0; i < 30; ++i) {
                ((EntityLivingBase)par1Entity).hurtResistantTime = 0;
                ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 0.01f);
            }
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
        }
        if (this.rand.nextInt(2) == 0) {
            this.quakeattack = true;
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(2);
        if (r == 0) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.lythe)), 1.0f);
        }
        if (r == 1) {
            this.entityDropItem(Dungeons.setLegendary(new ItemStack(Dungeons.lythe)), 1.0f);
        }
        this.dropItem(Dungeons.magicCoin, 7);
        this.dropItem(Dungeons.metalCoin, 7);
        this.dropItem(Dungeons.dungeonPiece5, 1);
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
            if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld) {
                if (this.rand.nextInt(6) == 0 && !this.worldObj.isRemote) {
                    final EntityBlackKnight entityzombie = new EntityBlackKnight(this.worldObj);
                    entityzombie.setPosition(this.posX + 1.0 + this.rand.nextInt(10), this.posY + 3.0, this.posZ + 1.0 + this.rand.nextInt(10));
                    this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                    if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                        entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                    }
                    entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                    entityzombie.setPosition(this.posX + 1.0 + this.rand.nextInt(10), this.posY + 3.0, this.posZ + 1.0 + this.rand.nextInt(10));
                }
                if (this.rand.nextInt(6) == 0 && !this.worldObj.isRemote) {
                    final EntityBlackKnight entityzombie = new EntityBlackKnight(this.worldObj);
                    entityzombie.setPosition(this.posX - 1.0 - this.rand.nextInt(10), this.posY + 3.0, this.posZ - 1.0 - this.rand.nextInt(10));
                    this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                    if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                        entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                    }
                    entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                    entityzombie.setPosition(this.posX - 1.0 - this.rand.nextInt(10), this.posY + 3.0, this.posZ - 1.0 - this.rand.nextInt(10));
                }
            }
            return true;
        }
        if (par1DamageSource != DamageSource.magic && par1DamageSource != DamageSource.onFire && par1DamageSource != DamageSource.outOfWorld) {
            if (this.rand.nextInt(6) == 0 && !this.worldObj.isRemote) {
                final EntityBlackKnight entityzombie = new EntityBlackKnight(this.worldObj);
                entityzombie.setPosition(this.posX + 1.0 + this.rand.nextInt(10), this.posY + 3.0, this.posZ + 1.0 + this.rand.nextInt(10));
                this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                entityzombie.setPosition(this.posX + 1.0 + this.rand.nextInt(10), this.posY + 3.0, this.posZ + 1.0 + this.rand.nextInt(10));
            }
            if (this.rand.nextInt(6) == 0 && !this.worldObj.isRemote) {
                final EntityBlackKnight entityzombie = new EntityBlackKnight(this.worldObj);
                entityzombie.setPosition(this.posX - 1.0 - this.rand.nextInt(10), this.posY + 3.0, this.posZ - 1.0 - this.rand.nextInt(10));
                this.worldObj.spawnEntityInWorld((Entity)entityzombie);
                if (this.entityToAttack != null && entity instanceof EntityLivingBase) {
                    entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
                }
                entityzombie.onSpawnWithEgg((IEntityLivingData)null);
                entityzombie.setPosition(this.posX - 1.0 - this.rand.nextInt(10), this.posY + 3.0, this.posZ - 1.0 - this.rand.nextInt(10));
            }
        }
        return true;
    }
}
