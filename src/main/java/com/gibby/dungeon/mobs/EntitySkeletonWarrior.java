

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntitySkeletonWarrior extends EntitySkeleton
{
    public EntitySkeletonWarrior(final World par1World) {
        super(par1World);
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityLivingBase.class, 1.2, false));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
    }
    
    protected Item getDropItem() {
        return Items.leather;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.getSkeletonType() == 1) {
            for (int j = this.rand.nextInt(3 + par2) - 1, k = 0; k < j; ++k) {
                this.dropItem(Items.coal, 1);
            }
        }
        else {
            for (int j = this.rand.nextInt(3 + par2), k = 0; k < j; ++k) {
                this.dropItem(Items.leather, 1);
            }
        }
        for (int j = this.rand.nextInt(3 + par2), k = 0; k < j; ++k) {
            this.dropItem(Items.bone, 1);
        }
        if (this.rand.nextInt(25) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        }
        if (this.rand.nextInt(40) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.harpBow), 1.0f);
        }
    }
    
    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
        this.setCurrentItemOrArmor(3, new ItemStack((Item)Items.leather_helmet));
        this.setCurrentItemOrArmor(4, new ItemStack((Item)Items.leather_chestplate));
    }
}
