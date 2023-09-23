

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityGoblin extends EntityMob
{
    public EntityGoblin(final World par1World) {
        super(par1World);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityVillager.class, 1.0, true));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityVillager.class, 0, false));
        this.setSize(0.3f, 1.0f);
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0);
    }
    
    protected String getLivingSound() {
        return "mob.zombie.say";
    }
    
    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }
    
    protected String getDeathSound() {
        return "mob.zombie.death";
    }
    
    protected float getSoundPitch() {
        return 1.6f;
    }
    
    protected void addRandomArmor() {
        this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
    }
    
    protected Item getDropItem() {
        return Items.gold_nugget;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final Item item = this.getDropItem();
        if (item != null) {
            int j = this.rand.nextInt(3);
            if (par2 > 0) {
                j += this.rand.nextInt(par2 + 1);
            }
            for (int k = 0; k < j; ++k) {
                this.dropItem(item, 1);
            }
        }
    }
    
    protected void dropRareDrop(final int par1) {
        this.dropItem(Items.emerald, 1);
    }
}
