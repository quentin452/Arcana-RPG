

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityEarthGolem extends EntityIronGolem
{
    public EntityEarthGolem(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0);
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 3.0f);
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.shock.id, 50, 0));
        }
        return true;
    }
    
    protected String getLivingSound() {
        return "step.gravel";
    }
    
    protected String getHurtSound() {
        return "step.sand";
    }
    
    protected String getDeathSound() {
        return "step.sand";
    }
    
    protected float getSoundPitch() {
        return 0.9f;
    }
    
    public void onUpdate() {
        super.onUpdate();
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final Item item = Item.getItemFromBlock(Blocks.dirt);
        if (item != null) {
            int j = this.rand.nextInt(3);
            if (par2 > 0) {
                j += this.rand.nextInt(par2 + 1);
            }
            for (int k = 0; k < j; ++k) {
                this.dropItem(item, 1);
            }
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        }
        if (this.rand.nextInt(50) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.sodbuster), 1.0f);
        }
    }
    
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && super.getCanSpawnHere() && this.posY < 55.0;
    }
}
