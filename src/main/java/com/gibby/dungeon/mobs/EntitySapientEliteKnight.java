

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySapientEliteKnight extends EntityMob
{
    public EntitySapientEliteKnight(final World par1World) {
        super(par1World);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(13.0);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.blackIronSword));
        this.setCurrentItemOrArmor(4, new ItemStack(Dungeons.blackIronHelmet));
        this.setCurrentItemOrArmor(3, new ItemStack(Dungeons.blackIronChestplate));
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.blackIronLeggings));
        this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.blackIronBoots));
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.blaze.hit";
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

    protected void dropEquipment(final boolean par1, final int par2) {
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

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return super.attackEntityFrom(par1DamageSource, par2 / 2.0f);
    }
}
