

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityEyeWarrior extends EntityMob
{
    public EntityEyeWarrior(final World par1World) {
        super(par1World);
        this.setSize(1.1f, 2.2f);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    public int getTotalArmorValue() {
        return 20;
    }

    protected String getLivingSound() {
        return "mob.slime.small";
    }

    protected String getHurtSound() {
        return "mob.slime.small";
    }

    protected String getDeathSound() {
        return "mob.slime.attack";
    }

    protected float getSoundPitch() {
        return 1.1f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).hurtResistantTime = 0;
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 140, 0));
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.imbalance.id, 240, 0));
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        this.entityDropItem(new ItemStack(Dungeons.dungeonEyeSword), 1.0f);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.dungeonEyeSword));
    }
}
