

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import com.gibby.dungeon.*;
import net.minecraft.world.*;

public class EntityDesertDragger extends EntityMob implements IBossDisplayData
{
    public EntityDesertDragger(final World par1World) {
        super(par1World);
        this.setSize(1.4f, 1.8f);
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
    }
    
    public int getTotalArmorValue() {
        return 5;
    }
    
    protected String getLivingSound() {
        return "gibby_dungeons:draggerIdle";
    }
    
    protected String getHurtSound() {
        return "gibby_dungeons:draggerHit";
    }
    
    protected String getDeathSound() {
        return "gibby_dungeons:draggerDeath";
    }
    
    protected float getSoundPitch() {
        return 0.6f;
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 400, 3));
        }
        return super.attackEntityAsMob(par1Entity);
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        this.entityDropItem(new ItemStack((Block)Blocks.sand), 2.0f);
        if (Dungeons.randRange(0, 20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        }
    }
    
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
}
