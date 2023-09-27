

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityNetherPigman extends EntityPigZombie
{
    public EntityNetherPigman(final World par1World) {
        super(par1World);
        this.experienceValue = 10;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(9.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.netherSkullSword));
        this.setCurrentItemOrArmor(3, new ItemStack(Dungeons.netherSkullChestplate));
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.netherSkullLeggings));
        this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.netherSkullBoots));
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Items.skull, 1, 1), 1.0f);
        this.entityDropItem(new ItemStack(Dungeons.voidCoin), 2.0f);
    }
}
