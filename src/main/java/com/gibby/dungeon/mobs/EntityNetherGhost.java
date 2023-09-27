

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityNetherGhost extends EntityFlying
{
    private Entity targetedEntity;

    public EntityNetherGhost(final World par1World) {
        super(par1World);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("flame", this.posX, this.posY + 2.0, this.posZ, 0.0, 0.0, 0.0);
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.getHealth() <= 0.0f) {
            for (int i = 0; i < 15; ++i) {
                this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
            }
            this.setDead();
        }
        this.targetedEntity = (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 40.0);
        if (this.targetedEntity != null) {
            this.faceEntity(this.targetedEntity, 0.0f, 0.0f);
            final Vec3 look = this.targetedEntity.getLookVec();
            final double X = look.xCoord * 0.1;
            final double Y = look.yCoord * 0.1;
            final double Z = look.zCoord * 0.1;
            this.motionX -= X / 1.9;
            this.motionZ -= Z / 1.9;
            this.motionY -= Y / 1.9;
            if (this.getDistanceToEntity(this.targetedEntity) < 1.25) {
                this.targetedEntity.attackEntityFrom(DamageSource.magic, 1.0f);
                ((EntityLivingBase)this.targetedEntity).setFire(4);
                ((EntityLivingBase)this.targetedEntity).attackEntityFrom(DamageSource.magic, 6.0f);
                this.worldObj.playSoundAtEntity((Entity)this.targetedEntity, "fire.fire", 0.8f, 1.0f);
            }
        }
    }

    protected String getHurtSound() {
        return "fire.ignite";
    }

    protected String getDeathSound() {
        return "fire.ignite";
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(4);
        if (r == 1) {
            this.entityDropItem(new ItemStack(Items.blaze_powder), 1.0f);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidCoin), 1.0f);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.corruptedSoul), 1.0f);
        }
    }
}
