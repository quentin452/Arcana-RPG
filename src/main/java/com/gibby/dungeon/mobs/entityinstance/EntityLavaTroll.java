

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntityLavaTroll extends EntityMob implements IBossDisplayData
{
    boolean firewave;

    public EntityLavaTroll(final World par1World) {
        super(par1World);
        this.setSize(1.8f, 2.4f);
        this.experienceValue = 100;
        this.isImmuneToFire = true;
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
    }

    public int getTotalArmorValue() {
        return 15;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.firewave) {
            this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 3.0, 0.0, this.rand.nextGaussian() / 3.0);
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        final int randX = this.rand.nextInt(10) - this.rand.nextInt(10);
        final int randY = this.rand.nextInt(10) - this.rand.nextInt(10);
        final int randZ = this.rand.nextInt(5);
        this.worldObj.spawnParticle("flame", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        if (this.rand.nextInt(30) == 0 && this.entityToAttack != null) {
            for (int i = 0; i < 10; ++i) {
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                final EntityMiniFireBall fire = new EntityMiniFireBall(this.worldObj, (EntityLivingBase)this);
                this.worldObj.spawnEntityInWorld((Entity)fire);
            }
        }
        if (this.rand.nextInt(150) == 0 && this.entityToAttack != null) {
            this.firewave = true;
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 10.0, 10.0));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityLivingBase) {
                        ((EntityLivingBase) list2.get(k2)).setFire(10);
                        ((EntityLivingBase) list2.get(k2)).attackEntityFrom(DamageSource.magic, 5.0f);
                    }
                }
            }
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    bossDisplay.setBossStatus(this, true);
                    this.func_145748_c_();
                }
            }
        }
    }

    protected String getLivingSound() {
        return "mob.zombie.say";
    }

    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }

    protected String getDeathSound() {
        return "mob.zombie.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.shock.id, 100, 0));
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(4);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.netherSteelShards), (float)this.rand.nextInt(4));
        }
        if (r == 1) {
            this.dropItem(Dungeons.flameSword, 1);
        }
        if (r == 2) {
            this.entityDropItem(new ItemStack(Dungeons.corruptedSoul), 1.0f);
        }
        this.dropItem(Dungeons.voidCoin, 3);
    }
}
