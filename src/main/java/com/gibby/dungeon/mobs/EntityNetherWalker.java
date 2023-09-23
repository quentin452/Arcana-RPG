

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityNetherWalker extends EntityMob
{
    public EntityNetherWalker(final World par1World) {
        super(par1World);
        this.setSize(2.3f, 2.3f);
        this.isImmuneToFire = true;
        this.tasks.addTask(4, new EntityAIAttackOnCollide((EntityCreature)this, EntityLivingBase.class, 1.0, false));
        this.experienceValue = 20;
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    public int getTotalArmorValue() {
        return 16;
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                Entity entity = (Entity) list2.get(k2);
                if (entity == this.entityToAttack) {
                    entity.setFire(4);
                }
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.magic, 7.0f);
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected String getLivingSound() {
        return "gibby_dungeons:nethergolemSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:nethergolemHit";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:nethergolemDeath";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(4);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.netherSteelShards), 1.0f);
        }
        if (r == 1) {
            this.entityDropItem(new ItemStack(Dungeons.castIron), 1.0f);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.flameSword), 1.0f);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.corruptedSoul), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidCoin), 1.0f);
        }
    }
}
