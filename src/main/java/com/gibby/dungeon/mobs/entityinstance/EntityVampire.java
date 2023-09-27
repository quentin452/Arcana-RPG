

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityVampire extends EntityMob
{
    public EntityVampire(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.experienceValue = 20;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    public int getTotalArmorValue() {
        return 8;
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
        return 1.0f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean flag = super.attackEntityAsMob(par1Entity);
        if (flag && par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
            par1Entity.hurtResistantTime = 0;
            par1Entity.attackEntityFrom(DamageSource.magic, 4.0f);
        }
        return flag;
    }

    public void onUpdate() {
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        if (this.rand.nextInt(160) == 0 && this.entityToAttack != null) {
            this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 50));
        }
        super.onUpdate();
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(6);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.silver), (float)this.rand.nextInt(3));
        }
        if (r == 1) {
            this.dropItem(Items.redstone, 2);
        }
        if (this.rand.nextInt(15) == 0) {
            this.dropItem(Dungeons.corruptedSoul, 1);
        }
        if (this.rand.nextInt(25) == 0) {
            this.dropItem(Dungeons.vampiricSword, 1);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidCoin), 1.0f);
        }
    }
}
