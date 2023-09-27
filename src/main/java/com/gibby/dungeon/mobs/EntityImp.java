

package com.gibby.dungeon.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityImp extends EntityZombie
{
    public EntityImp(final World par1World) {
        super(par1World);
        this.setSize(0.6f, 2.0f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2500000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected String getLivingSound() {
        return "mob.spider.say";
    }

    protected String getHurtSound() {
        return "mob.spider.say";
    }

    protected String getDeathSound() {
        return "mob.spider.death";
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        par1Entity.attackEntityFrom(DamageSource.magic, 3.0f);
        return true;
    }

    public void onDeath(final DamageSource par1DamageSource) {
        final EntityProjectileBall ball = new EntityProjectileBall(this.worldObj, (EntityLivingBase)this);
        ball.Color = "orange";
        final EntityProjectileBall entityProjectileBall = ball;
        ++entityProjectileBall.posX;
        ball.addPotionEffect(true, Potion.confusion.id, 200, 0);
        ball.addPotionEffect2(true, Potion.wither.id, 200, 0);
        ball.setEntityAttributes(3.0f, 0.2f, 0.0f, DamageSource.causeThrownDamage((Entity)this, (Entity)ball));
        this.worldObj.spawnEntityInWorld((Entity)ball);
        super.onDeath(par1DamageSource);
    }
}
