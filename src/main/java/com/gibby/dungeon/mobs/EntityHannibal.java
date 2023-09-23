

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityHannibal extends EntityMob
{
    boolean quake;

    public EntityHannibal(final World par1World) {
        super(par1World);
        this.quake = false;
        this.setSize(1.3f, 2.5f);
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityBlackKnight.class, 0, true));
        this.experienceValue = 20;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
    }

    public int getTotalArmorValue() {
        return 20;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.quake && this.onGround) {
            final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(10.0, 2.0, 10.0));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityLivingBase && ((EntityLivingBase) list2.get(k2)).onGround) {
                        ((EntityLivingBase) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 4.0f);
                        final EntityLivingBase entityLivingBase = (EntityLivingBase) list2.get(k2);
                        ++entityLivingBase.motionY;
                    }
                }
            }
            for (int x = 0; x < 10; ++x) {
                for (int z = 0; z < 10; ++z) {
                    this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.dirt) + "_0", this.posX - 5.0 + x, this.posY + 0.5, this.posZ - 5.0 + z, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
                }
            }
            this.quake = false;
        }
        if (!this.quake) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(3.0, 9.0, 3.0));
            if (list3 != null) {
                for (int k2 = 0; k2 < list3.size(); ++k2) {
                    if (list3.get(k2) == this.entityToAttack) {
                        this.motionY += 0.8;
                        this.fallDistance = -6.0f;
                        this.quake = true;
                    }
                }
            }
        }
    }

    protected String getLivingSound() {
        return "mob.enderdragon.growl";
    }

    protected String getHurtSound() {
        return "mob.enderdragon.growlmob";
    }

    protected String getDeathSound() {
        return "mob.enderdragon.hit";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(10);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidrockCrystal), 1.0f);
        }
        if (r == 1) {
            this.entityDropItem(new ItemStack(Dungeons.torturedChainSword), 1.0f);
        }
        if (r == 2) {
            this.entityDropItem(new ItemStack(Dungeons.crystallium), 1.0f);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.amethystRapier), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
