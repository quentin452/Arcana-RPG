

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityStoneBot extends EntityIronGolem
{
    public EntityStoneBot(final World par1World) {
        super(par1World);
        this.setHealth(30.0f);
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(7 + Dungeons.randRange(0, 2)));
        if (flag) {
            par1Entity.motionY += 0.4000000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }
    
    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        if (itemstack != null && (itemstack.getItem() == Items.iron_ingot || itemstack.getItem() == Dungeons.copper) && this.getHealth() < 30.0f) {
            this.heal(10.0f);
            final ItemStack itemStack = itemstack;
            --itemStack.stackSize;
        }
        return super.interact(par1EntityPlayer);
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        this.entityDropItem(new ItemStack(Blocks.cobblestone), 1.0f);
    }
}
