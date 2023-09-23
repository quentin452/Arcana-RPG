

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityOrcMage extends EntityHermit
{
    public EntityOrcMage(final World par1World) {
        super(par1World);
        this.setSize(1.2f, 2.4f);
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0);
    }
    
    public int getTotalArmorValue() {
        return 14;
    }
    
    protected String getLivingSound() {
        return "Dungeons.MODID:orcTalk";
    }
    
    protected String getHurtSound() {
        return "gibby_dungeons:orcHit";
    }
    
    protected String getDeathSound() {
        return "gibby_dungeons:orcDeath";
    }
    
    protected float getSoundPitch() {
        return 0.8f;
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand == 0) {
            final EntityBlueBeam ball = new EntityBlueBeam(this.worldObj, (EntityLivingBase)this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY - 1.100000023841858 - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0 / 1.5, d2 + f1, d3 / 1.5, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 0.8333333f);
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
        if (rand == 1) {
            final EntityRedBouncer ball2 = new EntityRedBouncer(this.worldObj, (EntityLivingBase)this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball2.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball2.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)ball2);
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
        final int i = Dungeons.randRange(0, 30);
        if (i == 0) {
            final int r = Dungeons.randRange(0, 5);
            if (r == 0) {
                this.dropItem(Dungeons.blackIronScraps, 1);
            }
            if (r == 1) {
                this.dropItem(Dungeons.arcaneGem, 1);
            }
            if (r == 2) {
                this.dropItem(Dungeons.orcWarWand, 1);
            }
            if (r == 3) {
                this.dropItem(Dungeons.blackIronChestplate, 1);
            }
            if (r == 4) {
                this.dropItem(Dungeons.magicGem, 1);
            }
            if (r == 5) {
                this.dropItem(Dungeons.magicPotion, 1);
            }
        }
        if (Dungeons.randRange(0, 15) == 0) {
            this.dropItem(Dungeons.blackIronScraps, 1);
        }
    }
    
    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.voidCoin), 1.0f);
    }
}
