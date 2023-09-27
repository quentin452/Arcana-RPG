package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityUndefeatable extends EntityMob
{
    public static final String publicName = "undefeatableTag";
    float distancedivider;

    public EntityUndefeatable(final World par1World) {
        super(par1World);
        this.distancedivider = 2.5f;
        this.setSize(1.1f, 2.4f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(130.0);
    }

    public int getTotalArmorValue() {
        return 20;
    }

    protected String getLivingSound() {
        return "gibby_dungeons:undefeatableSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:undefeatableHit";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:undefeatableHit";
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0) {
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 3.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    this.attackEntityAsMob((Entity)list2.get(k2));
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

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 3.0f);
    }
}
