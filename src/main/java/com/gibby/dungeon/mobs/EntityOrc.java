

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityOrc extends EntityMob
{
    public EntityOrc(final World par1World) {
        super(par1World);
        this.setSize(1.2f, 2.4f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.4);
    }

    public int getTotalArmorValue() {
        return 20;
    }

    protected String getLivingSound() {
        return "gibby_dungeons:orcTalk";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:orcHit";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:orcDeath";
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0) {
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 4.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 12.0f);
                }
            }
        }
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int i = Dungeons.randRange(0, 30);
        if (i == 0) {
            final int r = Dungeons.randRange(0, 5);
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
            if (r == 5) {
                this.dropItem(Dungeons.blackIronSword, 1);
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
