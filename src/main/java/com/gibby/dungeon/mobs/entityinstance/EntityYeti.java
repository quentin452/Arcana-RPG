

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityYeti extends EntityMob
{
    public EntityYeti(final World par1World) {
        super(par1World);
        this.setSize(1.1f, 2.2f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(18.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
    }

    public int getTotalArmorValue() {
        return 19;
    }

    protected String getLivingSound() {
        return "mob.cow.say";
    }

    protected String getHurtSound() {
        return "mob.cow.hurt";
    }

    protected String getDeathSound() {
        return "mob.cow.hurt";
    }

    protected float getSoundPitch() {
        return 0.7f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 300, 2));
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 3.0f);
    }
}
