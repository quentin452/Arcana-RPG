

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class EntityNecro extends EntityHermit
{
    public EntityNecro(final World par1World) {
        super(par1World);
        this.experienceValue = 20;
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(5);
        if (rand == 3) {
            final EntityZombie entityzombie = new EntityZombie(this.worldObj);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld((Entity)entityzombie);
            if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                entityzombie.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entityzombie.onSpawnWithEgg((IEntityLivingData)null);
            entityzombie.setPosition(this.posX, this.posY, this.posZ);
        }
        if (rand < 2) {
            final EntityBlackEnergy ball = new EntityBlackEnergy(this.worldObj, (EntityLivingBase)this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 1.25f);
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
        if (rand == 4) {
            this.heal(6.0f);
            this.playSound("note.harp", 1.0f, 1.0f);
            final EntityHealEffect ball2 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball2);
        }
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Items.bone, 1);
        }
        if (this.rand.nextInt(7) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicGem), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
