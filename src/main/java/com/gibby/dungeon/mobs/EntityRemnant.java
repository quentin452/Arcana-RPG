

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.projectile.*;
import java.util.*;
import net.minecraft.item.*;

public class EntityRemnant extends EntityMob implements IRangedAttackMob, IBossDisplayData
{
    int charge;
    double Xs;
    double Ys;
    double Zs;
    static int entitystate;
    boolean quake;
    int counterq;
    int X;
    int Y;
    int Z;
    int dX;
    int dZ;
    int rZ;
    int rX;
    
    public EntityRemnant(final World par1World) {
        super(par1World);
        this.charge = 0;
        this.Xs = 0.0;
        this.quake = false;
        this.counterq = 0;
        this.X = MathHelper.floor_double(this.posX);
        this.Y = MathHelper.floor_double(this.boundingBox.minY);
        this.Z = MathHelper.floor_double(this.posZ);
        this.dX = this.rand.nextInt(2) - 1;
        this.dZ = this.rand.nextInt(2) - 1;
        this.rZ = this.Z;
        this.rX = this.X;
        this.tasks.addTask(1, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.25, 20, 10.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.setHealth(this.getMaxHealth());
        this.isImmuneToFire = true;
        this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20000, 5));
        this.experienceValue = 300;
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 1, true));
        this.targetTasks.addTask(4, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityLiving.class, 1, true));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10000.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(60.0);
    }
    
    public boolean canBePushed() {
        return false;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        final int qcounter = 0;
        BossStatus.setBossStatus((IBossDisplayData)this, true);
        this.func_145748_c_();
        this.worldObj.setWorldTime(14000L);
        this.motionX = 0.0;
        this.motionZ = 0.0;
        this.motionY = 0.0;
        if (this.Xs == 0.0) {
            this.Xs = this.posX;
            this.Ys = this.posY;
            this.Zs = this.posZ;
        }
        this.posX = this.Xs;
        this.posY = this.Ys;
        this.posZ = this.Zs;
        for (int i = 0; i < this.rand.nextInt(500); ++i) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + this.rand.nextGaussian(), this.posZ, this.rand.nextGaussian() * this.rand.nextGaussian(), 0.0, this.rand.nextGaussian() * this.rand.nextGaussian());
        }
        final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(40.0, 40.0, 40.0));
        if (list != null) {
            for (int k2 = 0; k2 < list.size(); ++k2) {
                if (list.get(k2) instanceof EntityLivingBase && !(list.get(k2) instanceof EntityVillager)) {
                    this.worldObj.setWorldTime(14000L);
                    final double d0 = list.get(k2).posX - this.posX;
                    final double d2 = list.get(k2).posZ - this.posZ;
                    if (list.get(k2).onGround) {
                        list.get(k2).motionX = d0 / (20.0f * list.get(k2).getDistanceToEntity((Entity)this));
                        list.get(k2).motionZ = d2 / (20.0f * list.get(k2).getDistanceToEntity((Entity)this));
                    }
                    list.get(k2).addPotionEffect(new PotionEffect(Dungeons.shock.id, 40, 0));
                    if (this.rand.nextInt(10) == 0) {
                        list.get(k2).addPotionEffect(new PotionEffect(Potion.blindness.id, 10, 0));
                    }
                }
            }
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 10.0, 10.0));
        if (list2 != null) {
            for (int k3 = 0; k3 < list2.size(); ++k3) {
                if ((!(list2.get(k3) instanceof EntityLivingBase) && list2.get(k3) instanceof EntityThrowable) || list2.get(k3) instanceof EntityArrow) {
                    list2.get(k3).worldObj.newExplosion((Entity)this, list2.get(k3).posX + 0.3, list2.get(k3).posY - 0.3, list2.get(k3).posZ, 1.0f, false, false);
                    list2.get(k3).setDead();
                }
            }
        }
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.amethystSword)), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Dungeons.amethyst, 5);
        }
        if (r == 2) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.amethystPickaxe)), 1.0f);
        }
        this.dropItem(Dungeons.cursedWand, 1);
        this.dropItem(Dungeons.magicCoin, 6);
    }
    
    protected void despawnEntity() {
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase var1, final float var2) {
    }
    
    static {
        EntityRemnant.entitystate = 0;
    }
}
