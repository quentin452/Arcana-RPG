

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import java.util.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;

public class EntityDungeonBeast extends EntityMob implements IBossDisplayData
{
    public EntityDungeonBeast(final World par1World) {
        super(par1World);
        this.setSize(2.0f, 1.5f);
        this.experienceValue = 20;
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(130.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
    }
    
    public int getTotalArmorValue() {
        return 20;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if ((this.ticksExisted + 300) % 400 == 0 && !this.worldObj.isRemote) {
            this.worldObj.playSoundAtEntity((Entity)this, "mob.wolf.howl", 3.0f, 0.9f);
            this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 80, 10));
            this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 3));
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 240, 2));
            this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 140, 3));
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus((IBossDisplayData)this, true);
                    this.func_145748_c_();
                }
            }
        }
    }
    
    protected String getLivingSound() {
        return "mob.wolf.growl";
    }
    
    protected String getHurtSound() {
        return "mob.wolf.bark";
    }
    
    protected String getDeathSound() {
        return "mob.wolf.bark";
    }
    
    protected float getSoundPitch() {
        return 0.8f;
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
        }
        return super.attackEntityAsMob(par1Entity);
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Dungeons.yellowKey, 1);
        }
        this.dropItem(Dungeons.metalCoin, 1);
    }
}
