

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWarlock extends EntityHermit
{
    public EntityWarlock(final World par1World) {
        super(par1World);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand == 0) {
            final EntityRedBall ball = new EntityRedBall(this.worldObj, (EntityLivingBase)this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
        if (rand == 1) {
            for (int i = 0; i < 5; ++i) {
                final EntityBloodBall ball2 = new EntityBloodBall(this.worldObj, (EntityLivingBase)this);
                final double d4 = par1.posX - this.posX;
                final double d5 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball2.posY;
                final double d6 = par1.posZ - this.posZ;
                final float f2 = MathHelper.sqrt_double(d4 * d4 + d6 * d6) * 0.2f;
                ball2.setThrowableHeading(d4, d5 + f2, d6, 1.6f, 12.0f);
                this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)ball2);
            }
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(8.0f);
            final EntityHealEffect ball3 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball3);
        }
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
            return true;
        }
        return true;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Dungeons.amazonite, 1);
        }
        if (this.rand.nextInt(7) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicGem), 1.0f);
        }
        if (this.rand.nextInt(10) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.warlockStaff), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.warlockStaff), 1.0f);
    }
}
