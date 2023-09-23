

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntitySapientMage extends EntityHermit
{
    public EntitySapientMage(final World par1World) {
        super(par1World);
        this.setSize(1.2f, 2.4f);
        this.addRandomArmor();
    }
    
    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.sapientWarWand));
        this.setCurrentItemOrArmor(4, new ItemStack(Dungeons.blackIronHelmet));
        this.setCurrentItemOrArmor(3, new ItemStack(Dungeons.blackIronChestplate));
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.blackIronLeggings));
        this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.blackIronBoots));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0);
    }
    
    protected String getLivingSound() {
        return "mob.villager.idle";
    }
    
    protected String getHurtSound() {
        return "mob.blaze.hit";
    }
    
    protected String getDeathSound() {
        return "mob.villager.death";
    }
    
    protected float getSoundPitch() {
        return 0.6f;
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand <= 1) {
            for (int i = 0; i < 4; ++i) {
                final EntityCrystalBeam ball = new EntityCrystalBeam(this.worldObj, (EntityLivingBase)this);
                final double d0 = par1.posX - this.posX;
                final double d2 = par1.posY - ball.posY;
                final double d3 = par1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                this.worldObj.playSoundAtEntity((Entity)this, "random.orb", 1.0f, 1.0f);
                ball.setThrowableHeading(d0, d2 + f1, d3, 1.0f, 5.0f);
                this.worldObj.spawnEntityInWorld((Entity)ball);
            }
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(8.0f);
            final EntityHealEffect ball2 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball2);
        }
    }
    
    protected void dropEquipment(final boolean par1, final int par2) {
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int i = Dungeons.randRange(0, 30);
        if (i == 0) {
            final int r = Dungeons.randRange(0, 4);
            if (r == 0) {
                this.dropItem(Dungeons.blackIronScraps, 1);
            }
            if (r == 1) {
                this.dropItem(Dungeons.blackIronBoots, 1);
            }
            if (r == 2) {
                this.dropItem(Dungeons.blackIronLeggings, 1);
            }
            if (r == 3) {
                this.dropItem(Dungeons.blackIronChestplate, 1);
            }
            if (r == 4) {
                this.dropItem(Dungeons.blackIronHelmet, 1);
            }
        }
        if (Dungeons.randRange(0, 15) == 0) {
            this.dropItem(Dungeons.blackIronScraps, 1);
        }
    }
}
