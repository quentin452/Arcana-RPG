

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityIceMage extends EntityHermit
{
    public boolean iceWind;
    public int counter;

    public EntityIceMage(final World par1World) {
        super(par1World);
        this.iceWind = false;
        this.counter = 0;
        this.experienceValue = 20;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.iceWind && this.entityToAttack != null) {
            final EntityColdWind ball = new EntityColdWind(this.worldObj, (EntityLivingBase)this);
            final double d0 = this.entityToAttack.posX - this.posX;
            final double d2 = this.entityToAttack.posY + this.entityToAttack.getEyeHeight() - 1.100000023841858 - ball.posY;
            final double d3 = this.entityToAttack.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.worldObj.spawnEntityInWorld((Entity)ball);
            ++this.counter;
            if (this.counter > 40) {
                this.counter = 0;
                this.iceWind = false;
            }
        }
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand == 0 && !this.iceWind) {
            this.iceWind = true;
        }
        if (rand == 1) {
            for (int i = 0; i < 3; ++i) {
                final EntityBlizzardBall ball = new EntityBlizzardBall(this.worldObj, (EntityLivingBase)this);
                final double d0 = par1.posX - this.posX;
                final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball.posY;
                final double d3 = par1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
                this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)ball);
            }
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(5.0f);
            final EntityHealEffect ball2 = new EntityHealEffect(this.worldObj, (EntityLivingBase)this);
            this.worldObj.spawnEntityInWorld((Entity)ball2);
        }
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.iceRod));
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Dungeons.iceRod, 1);
        }
        if (this.rand.nextInt(7) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicGem), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
