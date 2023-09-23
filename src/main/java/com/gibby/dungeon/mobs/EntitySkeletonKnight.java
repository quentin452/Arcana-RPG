

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import net.minecraft.init.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntitySkeletonKnight extends EntitySkeletonWarrior
{
    public EntitySkeletonKnight(final World par1World) {
        super(par1World);
        this.experienceValue = 10;
    }
    
    @Override
    protected Item getDropItem() {
        return Items.iron_ingot;
    }
    
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.getSkeletonType() == 1) {
            for (int j = this.rand.nextInt(3 + par2) - 1, k = 0; k < j; ++k) {
                this.dropItem(Items.coal, 1);
            }
        }
        else {
            for (int j = this.rand.nextInt(3 + par2), k = 0; k < j; ++k) {
                this.dropItem(Items.iron_ingot, 1);
            }
        }
        for (int j = this.rand.nextInt(3 + par2), k = 0; k < j; ++k) {
            this.dropItem(Items.bone, 1);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
        }
    }
    
    @Override
    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.rubySword));
        this.setCurrentItemOrArmor(4, new ItemStack(Dungeons.rubyHelmet));
        this.setCurrentItemOrArmor(3, new ItemStack((Item)Items.iron_chestplate));
        this.setCurrentItemOrArmor(2, new ItemStack((Item)Items.iron_leggings));
        this.setCurrentItemOrArmor(1, new ItemStack((Item)Items.iron_boots));
    }
}
