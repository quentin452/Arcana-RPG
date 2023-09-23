

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EntityEarthMage extends EntityHermit
{
    public EntityEarthMage(final World par1World) {
        super(par1World);
        this.experienceValue = 20;
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand <= 1) {
            final EntityQuake ball = new EntityQuake(this.worldObj, (EntityLivingBase)this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY + par1.getEyeHeight() - 10.100000023841858 - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)ball);
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(5.0f);
            final EntityHealEffect ball2 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball2);
        }
    }
    
    @Override
    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.quakeWand));
    }
    
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.rand.nextInt(2) == 0) {
            this.entityDropItem(new ItemStack(Blocks.dirt, 1), 1.0f);
        }
        if (this.rand.nextInt(30) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.quakeWand), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
