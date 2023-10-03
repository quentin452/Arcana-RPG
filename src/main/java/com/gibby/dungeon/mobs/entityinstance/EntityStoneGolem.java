

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.List;

public class EntityStoneGolem extends EntityMob
{
    private int attackTimer;

    public EntityStoneGolem(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.setSize(1.3f, 2.5f);
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    protected String getDeathSound() {
        return "mob.irongolem.death";
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 10.0, 20.0));
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.attackTimer < 1 && !this.worldObj.isRemote) {
                    this.attackTimer = 30;
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 2.0, 0.6, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 2.0);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage(this), (float)Dungeons.randRange(5, 7));
                }
            }
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (this.rand.nextInt(4) == 0) {
            this.worldObj.setEntityState(this, (byte)4);
            final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(7)));
            if (flag) {
                par1Entity.motionY += 0.3500000059604645;
            }
            this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
            return flag;
        }
        return true;
    }

    protected void dropRareDrop(final int par1) {
        this.dropItem(Dungeons.graniteSword, 1);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final Item item = Item.getItemFromBlock(Blocks.stone);
        if (item != null) {
            int j = this.rand.nextInt(3);
            if (par2 > 0) {
                j += this.rand.nextInt(par2 + 1);
            }
            for (int k = 0; k < j; ++k) {
                this.dropItem(item, 1);
                if (this.rand.nextInt(4) == 0) {
                    this.dropItem(Item.getItemFromBlock(Blocks.iron_ore), 1);
                }
            }
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        }
    }
}
