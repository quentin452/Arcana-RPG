

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

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
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.25, 20, 10.0f));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.setHealth(this.getMaxHealth());
        this.isImmuneToFire = true;
        this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20000, 5));
        this.experienceValue = 300;
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 1, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityLiving.class, 1, true));
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

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
        bossDisplay.setBossStatus(this, true);
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
                    final double d0 = ((EntityLivingBase) list.get(k2)).posX - this.posX;
                    final double d2 = ((EntityLivingBase) list.get(k2)).posZ - this.posZ;
                    if (((EntityLivingBase) list.get(k2)).onGround) {
                        ((EntityLivingBase) list.get(k2)).motionX = d0 / (20.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this));
                        ((EntityLivingBase) list.get(k2)).motionZ = d2 / (20.0f * ((EntityLivingBase) list.get(k2)).getDistanceToEntity((Entity)this));
                    }
                    ((EntityLivingBase) list.get(k2)).addPotionEffect(new PotionEffect(Dungeons.shock.id, 40, 0));
                    if (this.rand.nextInt(10) == 0) {
                        ((EntityLivingBase) list.get(k2)).addPotionEffect(new PotionEffect(Potion.blindness.id, 10, 0));
                    }
                }
            }
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 10.0, 10.0));
        if (list2 != null) {
            for (int k3 = 0; k3 < list2.size(); ++k3) {
                if ((!(list2.get(k3) instanceof EntityLivingBase) && list2.get(k3) instanceof EntityThrowable) || list2.get(k3) instanceof EntityArrow) {
                    ((Entity) list2.get(k3)).worldObj.newExplosion((Entity)this, ((Entity) list2.get(k3)).posX + 0.3, ((Entity) list2.get(k3)).posY - 0.3, ((Entity) list2.get(k3)).posZ, 1.0f, false, false);
                    ((Entity) list2.get(k3)).setDead();
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
