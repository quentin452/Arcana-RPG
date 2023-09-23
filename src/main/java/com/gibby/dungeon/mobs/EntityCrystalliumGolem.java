

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityCrystalliumGolem extends EntityMob
{
    public EntityCrystalliumGolem(final World par1World) {
        super(par1World);
        this.setSize(2.0f, 2.4f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5);
    }

    public int getTotalArmorValue() {
        return 18;
    }

    protected String getLivingSound() {
        return "gibby_dungeons:crystalSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:crystalHurt";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:crystalDeath";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.4, 1.4, 1.4));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0 && !this.worldObj.isRemote) {
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 4.0, 0.7, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 4.0);
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 3.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 8.0f);
                }
            }
        }
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.crystallium), 1.0f);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = Dungeons.randRange(0, 10);
        if (r == 0) {
            this.dropItem(Item.getItemFromBlock(Dungeons.voidrockOre), 1);
        }
        if (r == 1) {
            this.dropItem(Dungeons.magirockCrystal, 1);
        }
        if (Dungeons.randRange(0, 15) == 0) {
            this.dropItem(Dungeons.magicCoin, 1);
        }
    }
}
