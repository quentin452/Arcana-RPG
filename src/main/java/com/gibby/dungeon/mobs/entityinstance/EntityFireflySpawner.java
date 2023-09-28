package com.gibby.dungeon.mobs.entityinstance;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFireflySpawner extends EntityBat
{
    public EntityFireflySpawner(final World par1World) {
        super(par1World);
        this.setSize(0.1f, 0.1f);
        this.renderDistanceWeight = 30.0;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return this.ticksExisted % 40 * 6;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0);
    }

    protected float getSoundVolume() {
        return 0.0f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 13; ++i) {
                final EntityFirefly firefly = new EntityFirefly(this.worldObj);
                firefly.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld(firefly);
                firefly.onSpawnWithEgg((IEntityLivingData)null);
                firefly.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        this.setDead();
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return false;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
}
