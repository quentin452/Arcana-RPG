

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityStoneGolem extends EntityIronGolem
{
    public EntityStoneGolem(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23);
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
