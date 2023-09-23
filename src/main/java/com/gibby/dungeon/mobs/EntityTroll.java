

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;

public class EntityTroll extends EntityMob implements IBossDisplayData
{
    public EntityTroll(final World par1World) {
        super(par1World);
        this.setSize(1.8f, 2.4f);
        this.experienceValue = 20;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
    }
    
    public int getTotalArmorValue() {
        int i = 0;
        for (final ItemStack itemstack : this.getLastActiveItems()) {
            if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                final int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
                i += l;
            }
        }
        return i + 6;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.rand.nextInt(10) == 0) {
            final EntitySpit spit = new EntitySpit(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)spit);
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
        return "mob.zombie.say";
    }
    
    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }
    
    protected String getDeathSound() {
        return "mob.zombie.death";
    }
    
    protected float getSoundPitch() {
        return 0.6f;
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.shock.id, 100, 0));
        }
        return super.attackEntityAsMob(par1Entity);
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.trollAxe), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Items.emerald, 1);
        }
        if (r == 2) {
            this.entityDropItem(new ItemStack(Dungeons.rawTrollMeat), (float)this.rand.nextInt(4));
        }
        this.dropItem(Dungeons.metalCoin, 2);
    }
}
