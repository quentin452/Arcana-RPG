package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.List;

public class EntityCaveWraith extends EntityMob
{
    private boolean pound;
    int counter;

    public EntityCaveWraith(final World par1World) {
        super(par1World);
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
        this.setSize(1.4f, 1.4f);
        this.experienceValue = 10;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
    }

    public int getTotalArmorValue() {
        return 22;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 200;
    }

    protected String getHurtSound() {
        return "gibby_dungeons:wraith";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:wraith";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    protected float getSoundVolume() {
        return 0.5f;
    }

    public void onUpdate() {
        super.onUpdate();
        --this.counter;
        if (this.pound && this.onGround && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            this.worldObj.playSoundAtEntity(this, "mob.slime.attack", 1.0f, 1.0f);
            final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(5.5, 1.0, 5.5));
            if (list2 != null) {
                for (int k2 = 0; k2 < list2.size(); ++k2) {
                    if (list2.get(k2) instanceof EntityPlayer && !((EntityPlayer) list2.get(k2)).capabilities.isCreativeMode) {
                        ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 8.0f);
                        final EntityLivingBase entityLivingBase = (EntityLivingBase) list2.get(k2);
                        entityLivingBase.motionY += 0.3;
                    }
                }
            }
            final EntityRuneEffect effect = new EntityRuneEffect(this.worldObj, this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(effect);
            this.pound = false;
        }
        if (!this.pound && this.counter < 0 && !this.worldObj.isRemote) {
            final List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(5.0, 5.0, 5.0));
            if (list3 != null) {
                for (int k2 = 0; k2 < list3.size(); ++k2) {
                    if (list3.get(k2) instanceof EntityPlayer && !((EntityPlayer) list3.get(k2)).capabilities.isCreativeMode) {
                        this.motionY = 0.41;
                        this.motionZ *= 1.2;
                        this.motionX *= 1.2;
                        this.fallDistance = -3.0f;
                        this.pound = true;
                        this.counter = 80;
                    }
                }
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.incandescentDust, 2);
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox) && this.posY < 60.0;
    }
}
