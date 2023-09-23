

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityNetherSoul extends EntityMob
{
    boolean tornado;
    boolean pound;
    int Y;
    int counter;

    public EntityNetherSoul(final World par1World) {
        super(par1World);
        this.tornado = false;
        this.pound = false;
        this.counter = 0;
        this.experienceValue = 20;
        this.isImmuneToFire = true;
        this.getNavigator().setAvoidsWater(true);
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityIronGolem.class, 0, false));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityAnimal.class, 0, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.80000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
    }

    public int getTotalArmorValue() {
        int i = super.getTotalArmorValue() + 16;
        if (i > 20) {
            i = 20;
        }
        return i;
    }

    public void onUpdate() {
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        if (this.pound) {
            if (this.onGround) {
                for (int x1 = 0; x1 < 6; ++x1) {
                    for (int z1 = 0; z1 < 6; ++z1) {
                        this.worldObj.setBlock(MathHelper.floor_double(this.posX) + x1 - 3, MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ) + z1 - 3, (Block)Blocks.fire);
                    }
                }
                final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(7.0, 7.0, 7.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase && !(list.get(k2) instanceof EntityNetherSoul)) {
                            ((EntityLivingBase) list.get(k2)).setFire(8);
                            ((EntityLivingBase) list.get(k2)).motionY = 0.9 + this.rand.nextInt(10) / 10;
                        }
                    }
                }
                this.pound = false;
            }
        }
        else if (this.rand.nextInt(100) == 0 && this.entityToAttack != null) {
            final double d0 = this.entityToAttack.posX - this.posX;
            final double d2 = this.entityToAttack.boundingBox.minY + this.entityToAttack.height / 2.0f - (this.posY + 2.0 + this.height / 2.0f);
            final double d3 = this.entityToAttack.posZ - this.posZ;
            final EntityFireball fireball = (EntityFireball)new EntityLargeFireball(this.worldObj, this.posX, this.posY + 3.0, this.posZ, d0, d2, d3);
            this.worldObj.spawnEntityInWorld((Entity)fireball);
        }
        final int x2 = MathHelper.floor_double(this.posX);
        final int y = MathHelper.floor_double(this.boundingBox.minY);
        final int z2 = MathHelper.floor_double(this.posZ);
        if (this.worldObj.getBlock(x2, y, z2) != Blocks.fire && !this.worldObj.isRemote) {
            this.worldObj.setBlock(x2, y, z2, (Block)Blocks.fire);
        }
        if (this.rand.nextInt(200) == 0 && this.entityToAttack != null) {
            this.tornado = true;
        }
        else if (this.rand.nextInt(200) == 1 && this.entityToAttack != null) {
            this.motionY = 1.6;
            this.worldObj.playSoundAtEntity((Entity)this, "mob.wither.shoot", 1.0f, 1.3f);
            this.fallDistance = -400.0f;
            this.pound = true;
        }
        super.onUpdate();
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean flag = super.attackEntityAsMob(par1Entity);
        if (flag) {
            par1Entity.setFire(4);
            par1Entity.hurtResistantTime = 0;
            par1Entity.attackEntityFrom(DamageSource.outOfWorld, 3.0f);
        }
        return flag;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(8);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.inflameStaff), 1.0f);
        }
        if (this.rand.nextInt(5) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.corruptedSoul), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.voidCoin), 1.0f);
        }
        this.dropItem(Items.nether_wart, 1);
    }
}
