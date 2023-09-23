

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityStoneGolem extends EntityIronGolem
{
    public EntityStoneGolem(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
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
            this.worldObj.setEntityState((Entity)this, (byte)4);
            final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(7 + this.rand.nextInt(7)));
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
