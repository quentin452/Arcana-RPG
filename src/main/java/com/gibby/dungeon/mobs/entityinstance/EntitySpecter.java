

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntitySpecter extends EntityZombie implements IBossDisplayData
{
    int charge;

    public EntitySpecter(final World par1World) {
        super(par1World);
        this.charge = 100;
        this.experienceValue = 150;
        this.isImmuneToFire = true;
        this.getSoundVolume();
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0, false));
        this.canDespawn();
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
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
    }

    protected String getLivingSound() {
        return "ambient.cave.cave";
    }

    protected String getHurtSound() {
        return "ambient.cave.cave";
    }

    protected String getDeathSound() {
        return "ambient.cave.cave";
    }

    protected float getSoundVolume() {
        return 2.0f;
    }

    public void onUpdate() {
        super.onUpdate();
        boolean playerAround = false;
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
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
        this.worldObj.spawnParticle("smoke", this.posX + this.rand.nextGaussian() / 2.0, this.posY + 1.0 + this.rand.nextGaussian() / 2.0, this.posZ + this.rand.nextGaussian() / 2.0, 0.0, 0.0, 0.0);
        this.worldObj.spawnParticle("flame", this.posX + this.rand.nextGaussian() / 2.0, this.posY + 1.0 + this.rand.nextGaussian() / 2.0, this.posZ + this.rand.nextGaussian() / 2.0, 0.0, 0.0, 0.0);
        if (this.entityToAttack != null && this.getHealth() >= 0.0f) {
            ++this.charge;
            if (this.charge > 125) {
                this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 100, 0));
                this.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 100));
                if (this.charge == 126) {
                    for (int i = 0; i < 20; ++i) {
                        final EntitySmallFireball ball = new EntitySmallFireball(this.worldObj, this, 0.0, 0.0, 0.0);
                        this.worldObj.spawnEntityInWorld(ball);
                    }
                }
            }
            if (this.charge > 240) {
                this.charge = 0;
                if (this.charge == 226) {
                    this.playSound("ambient.cave.cave", 1.0f, 1.0f);
                }
                this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 2));
            }
        }
        if (!this.worldObj.isRemote) {
            this.updateLeashedState();
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        par1Entity.attackEntityFrom(DamageSource.magic, 5.0f);
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 0));
        }
        return true;
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(6);
        if (r == 0) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.silverSword)), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Dungeons.silver, 7);
        }
        if (r == 2) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.silverChestplate)), 1.0f);
        }
        if (r == 3) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.silverHelmet)), 1.0f);
        }
        if (r == 3) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.silverLeggings)), 1.0f);
        }
        if (r == 5) {
            this.entityDropItem(Dungeons.setRare(new ItemStack(Dungeons.silverBoots)), 1.0f);
        }
        this.dropItem(Dungeons.magicGem, 1);
        this.dropItem(Dungeons.magicCoin, 7);
        this.dropItem(Dungeons.dungeonPiece3, 1);
    }
}
