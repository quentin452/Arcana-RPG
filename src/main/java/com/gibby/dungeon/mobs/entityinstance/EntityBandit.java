

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBandit extends EntityMob
{
    public EntityBandit(final World par1World) {
        super(par1World);
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
    }

    protected void dropRareDrop(final int par1) {
        this.dropItem(Dungeons.whittler, 1);
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 1.0f);
    }
}
