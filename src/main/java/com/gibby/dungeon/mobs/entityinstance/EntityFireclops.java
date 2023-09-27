

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFireclops extends EntityMob
{
    public EntityFireclops(final World par1World) {
        super(par1World);
        this.setSize(1.4f, 3.0f);
        this.experienceValue = 10;
        this.isImmuneToFire = true;
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
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

    public int getTotalArmorValue() {
        return 16;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            for (int i = 0; i < 30; ++i) {
                ((EntityLivingBase)par1Entity).hurtResistantTime = 0;
                ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 0.01f);
            }
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(10);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.mace), 1.0f);
        }
        if (r == 1) {
            this.dropItem(Dungeons.metalCoin, 1);
        }
        if (r >= 15) {
            this.entityDropItem(new ItemStack(Items.leather), 5.0f);
        }
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.fireClub));
    }
}
