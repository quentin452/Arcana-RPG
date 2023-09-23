

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.entity.boss.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityBigStoneGolem extends EntityIronGolem implements IBossDisplayData
{
    boolean quakeattack;
    int length;
    boolean pound;
    
    public EntityBigStoneGolem(final World par1World) {
        super(par1World);
        this.quakeattack = false;
        this.length = 0;
        this.pound = false;
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.isImmuneToFire = true;
        this.experienceValue = 150;
    }
    
    protected float getSoundVolume() {
        return 1.5f;
    }
    
    public int getTotalArmorValue() {
        return 10;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(161.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.setSize(1.8f, 3.5f);
    }
    
    public void onUpdate() {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        boolean playerAround = false;
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
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
        if (this.pound && this.onGround) {
            list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 2.0, 10.0));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityLivingBase && list2.get(k2).onGround) {
                        list2.get(k2).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 4.0f);
                        final EntityLivingBase entityLivingBase = list2.get(k2);
                        entityLivingBase.motionY += 0.8;
                    }
                }
            }
            for (int x = 0; x < 10; ++x) {
                for (int z = 0; z < 10; ++z) {
                    this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.dirt) + "_0", this.posX - 5.0 + x, this.posY + 0.5, this.posZ - 5.0 + z, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
                }
            }
            this.pound = false;
        }
        if (!this.pound && this.rand.nextInt(80) == 0 && !this.worldObj.isRemote) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(5.0, 9.0, 5.0));
            if (list3 != null) {
                for (int k3 = 0; k3 < list3.size(); ++k3) {
                    if (list3.get(k3) instanceof EntityLivingBase) {
                        System.out.println("Found entity");
                        this.motionY += 0.8;
                        this.fallDistance = -6.0f;
                        this.pound = true;
                    }
                }
            }
        }
        super.onUpdate();
        if (this.quakeattack) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(15.0, 6.0, 15.0));
            if (list3 != null) {
                for (int k3 = 0; k3 < list3.size(); ++k3) {
                    if (list3.get(k3) instanceof EntityLivingBase) {
                        list3.get(k3).hurtResistantTime = 0;
                        list3.get(k3).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 0.01f);
                    }
                }
            }
            ++this.length;
            this.heal(0.5f);
            if (this.length > 20) {
                this.quakeattack = false;
                this.length = 0;
            }
        }
    }
    
    protected void despawnEntity() {
    }
    
    protected boolean canDespawn() {
        return false;
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(6 + this.rand.nextInt(5)));
        if (this.rand.nextInt(5) == 0) {
            this.quakeattack = true;
        }
        if (flag) {
            par1Entity.motionY += 0.3000000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.bedrockSword), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Items.diamond, 3);
        }
        if (r == 2) {
            this.dropItem(Dungeons.botSword, 1);
        }
        this.dropItem(Dungeons.metalCoin, 14);
        this.dropItem(Dungeons.dungeonPiece2, 1);
    }
}
