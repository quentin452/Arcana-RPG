package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityTreeGolem extends EntityMob implements IBossDisplayData
{
    private int attackTimer;
    private boolean pound;

    public EntityTreeGolem(final World par1World) {
        super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
        this.setSize(4.0f, 5.0f);
        this.renderDistanceWeight = 650.0;
        this.experienceValue = 500;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(70.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.245);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 200;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public int getTotalArmorValue() {
        return 22;
    }

    protected String getHurtSound() {
        return "gibby_dungeons:crystalHurt";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:crystalDeath";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.5, 1.5, 1.5));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.attackTimer < 1 && !this.worldObj.isRemote && !((EntityPlayer) list2.get(k2)).capabilities.isCreativeMode) {
                    this.attackTimer = 200;
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 2.0, 0.7, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 2.0);
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 12.0f);
                }
            }
        }
        if (this.pound && this.onGround) {
            list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(15.0, 4.0, 15.0));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityPlayer && ((EntityPlayer) list2.get(k2)).onGround && !((EntityPlayer) list2.get(k2)).capabilities.isCreativeMode) {
                        ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 12.0f);
                        final EntityLivingBase entityLivingBase = (EntityLivingBase) list2.get(k2);
                        entityLivingBase.motionY += 0.8;
                    }
                }
            }
            final EntityPoundEffect effect = new EntityPoundEffect(this.worldObj, this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(effect);
            this.pound = false;
        }
        if (!this.pound && this.ticksExisted % 140 == 5 && !this.worldObj.isRemote) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(15.0, 9.0, 15.0));
            if (list3 != null) {
                for (int k3 = 0; k3 < list3.size(); ++k3) {
                    if (list3.get(k3) instanceof EntityPlayer && !((EntityPlayer) list3.get(k3)).capabilities.isCreativeMode) {
                        this.motionY += 0.45;
                        this.fallDistance = -6.0f;
                        this.pound = true;
                    }
                }
            }
        }
        final int x = (int)this.posX;
        final int y = (int)this.posY;
        final int z = (int)this.posZ;
        for (int X = -2; X < 2; ++X) {
            for (int Y = -2; Y < 2; ++Y) {
                if (!this.worldObj.isAirBlock(x + X, y, z + Y)) {
                    this.worldObj.setBlockToAir(x + X, y, z + Y);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return false;
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.darkSoul, 2);
        this.dropItem(Dungeons.midnightCoin, 3);
        this.dropItem(Dungeons.incandescentDust, 64);
        this.dropItem(Item.getItemFromBlock(Dungeons.jadeLog), 32);
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (super.attackEntityFrom(par1DamageSource, par2)) {
            if (par1DamageSource.getEntity() != null && !(par1DamageSource.getEntity() instanceof EntityPlayer)) {
                par1DamageSource.getEntity().attackEntityFrom(DamageSource.outOfWorld, 20.0f);
            }
            return true;
        }
        return false;
    }
}
