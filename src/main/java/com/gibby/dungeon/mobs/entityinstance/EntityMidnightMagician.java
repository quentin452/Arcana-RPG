package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMidnightMagician extends EntityHermit implements IBossDisplayData
{
    public EntityMidnightMagician(final World par1World) {
        super(par1World);
        this.setSize(1.0f, 2.34f);
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 3));
        this.experienceValue = 500;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 200;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0);
    }

    public int getTotalArmorValue() {
        return 20;
    }

    protected String getLivingSound() {
        return "gibby_dungeons:midnightMagician";
    }

    protected String getHurtSound() {
        return "fireworks.blast_far";
    }

    protected String getDeathSound() {
        return "fireworks.largeBlast_far";
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected float getSoundVolume() {
        return 2.0f;
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand == 0) {
            final EntityMidnightSizzler ball = new EntityMidnightSizzler(this.worldObj, this);
            final double d0 = par1.posX - this.posX;
            final double d2 = par1.posY + par1.getEyeHeight() - 10.100000023841858 - ball.posY;
            final double d3 = par1.posZ - this.posZ;
            final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
            ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
            this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(ball);
        }
        if (rand == 1) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(8.0f);
            final EntityHealEffect ball2 = new EntityHealEffect(this.worldObj, this);
            this.worldObj.spawnEntityInWorld(ball2);
        }
        if (rand == 1) {
            final EntityMidnightSplitter ball3 = new EntityMidnightSplitter(this.worldObj, this);
            this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(ball3);
        }
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (super.attackEntityFrom(par1DamageSource, par2)) {
            if (par1DamageSource.getEntity() != null && !(par1DamageSource.getEntity() instanceof EntityPlayer)) {
                par1DamageSource.getEntity().attackEntityFrom(DamageSource.outOfWorld, 20.0f);
            }
            return true;
        }
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.runeShard, 8);
        this.dropItem(Dungeons.darkSoul, 2);
        this.dropItem(Dungeons.midnightCoin, 3);
    }

    protected void dropRareDrop(final int par1) {
    }
}
