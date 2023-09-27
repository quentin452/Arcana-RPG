

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityOrcDefender extends EntityMob
{
    public EntityOrcDefender(final World par1World) {
        super(par1World);
        this.setSize(1.2f, 2.4f);
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 2));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.6);
    }

    public int getTotalArmorValue() {
        return 21;
    }

    protected String getLivingSound() {
        return "gibby_dungeons:orcTalk";
    }

    protected String getHurtSound() {
        return "mob.blaze.hit";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:orcDeath";
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.4, 1.4, 1.4));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0) {
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 3.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 11.0f);
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
