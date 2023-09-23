

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import com.gibby.dungeon.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntitySapientMiner extends EntityMob
{
    public EntitySapientMiner(final World par1World) {
        super(par1World);
        this.addRandomArmor();
        this.targetTasks.removeTask((EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 1, true));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
    }
    
    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_pickaxe));
        this.setCurrentItemOrArmor(3, new ItemStack(Dungeons.silverChestplate));
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.silverLeggings));
        this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.silverBoots));
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
    
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox) && this.posY <= 50.0;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.copper), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Item.getItemFromBlock(Blocks.cobblestone), 1);
        }
        if (r == 2) {
            this.entityDropItem(new ItemStack(Dungeons.ruby), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
