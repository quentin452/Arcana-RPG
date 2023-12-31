

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySapientWarrior extends EntityMob
{
    public EntitySapientWarrior(final World par1World) {
        super(par1World);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.silverSword));
        this.setCurrentItemOrArmor(4, new ItemStack(Dungeons.silverHelmet));
        this.setCurrentItemOrArmor(3, new ItemStack(Dungeons.silverChestplate));
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.silverLeggings));
        this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.silverBoots));
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
}
