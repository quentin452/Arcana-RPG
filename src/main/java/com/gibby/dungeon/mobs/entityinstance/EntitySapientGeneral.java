

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySapientGeneral extends EntityMob
{
    public EntitySapientGeneral(final World par1World) {
        super(par1World);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.getHealth() <= 0.0f && !this.worldObj.isRemote) {
            final EntitySapientDeath ball = new EntitySapientDeath(this.worldObj, this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(ball);
            this.setDead();
        }
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.sunAxe));
        this.setCurrentItemOrArmor(4, new ItemStack(Dungeons.blindLightHelmet));
        this.setCurrentItemOrArmor(3, new ItemStack(Dungeons.blindLightChestplate));
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.blindLightLeggings));
        this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.blindLightBoots));
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

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.sunspot.id, 100, 0));
        }
        return super.attackEntityAsMob(par1Entity);
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return super.attackEntityFrom(par1DamageSource, par2 / 5.0f);
    }

    protected void dropEquipment(final boolean par1, final int par2) {
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = Dungeons.randRange(0, 4);
        if (r == 1) {
            this.dropItem(Dungeons.blindLightBoots, 1);
        }
        if (r == 2) {
            this.dropItem(Dungeons.blindLightLeggings, 1);
        }
        if (r == 3) {
            this.dropItem(Dungeons.blindLightChestplate, 1);
        }
        if (r == 4) {
            this.dropItem(Dungeons.blindLightHelmet, 1);
        }
        this.dropItem(Dungeons.sunAxe, 1);
    }
}
