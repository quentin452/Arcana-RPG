

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import com.gibby.dungeon.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class EntityTyphoon extends EntityMob
{
    private float heightOffset;
    private int heightOffsetUpdateTime;
    private int field_70846_g;
    private static final String __OBFID = "CL_00001682";
    
    public EntityTyphoon(final World par1World) {
        super(par1World);
        this.heightOffset = 0.5f;
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)new Byte((byte)0));
    }
    
    protected String getLivingSound() {
        return "mob.blaze.breathe";
    }
    
    protected String getHurtSound() {
        return "mob.blaze.hit";
    }
    
    protected String getDeathSound() {
        return "mob.blaze.death";
    }
    
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    public float getBrightness(final float par1) {
        return 1.0f;
    }
    
    protected void fall(final float par1) {
    }
    
    protected Item getDropItem() {
        return Dungeons.waterRod;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        if (par1) {
            for (int j = this.rand.nextInt(2 + par2), k = 0; k < j; ++k) {
                this.dropItem(Dungeons.waterRod, 1);
            }
        }
    }
    
    public boolean func_70845_n() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    public void func_70844_e(final boolean par1) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (par1) {
            b0 |= 0x1;
        }
        else {
            b0 &= 0xFFFFFFFE;
        }
        this.dataWatcher.updateObject(16, (Object)b0);
    }
    
    protected boolean isValidLightLevel() {
        return true;
    }
    
    protected void attackEntity(final Entity par1Entity, final float par2) {
        if (this.attackTime <= 0 && par2 < 2.0f && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
        else if (par2 < 30.0f) {
            final double d0 = par1Entity.posX - this.posX;
            final double d2 = par1Entity.boundingBox.minY + par1Entity.height / 2.0f - (this.posY + this.height / 2.0f);
            final double d3 = par1Entity.posZ - this.posZ;
            if (this.attackTime == 0) {
                ++this.field_70846_g;
                if (this.field_70846_g == 1) {
                    this.attackTime = 60;
                    this.func_70844_e(true);
                }
                else if (this.field_70846_g <= 4) {
                    this.attackTime = 6;
                }
                else {
                    this.attackTime = 100;
                    this.field_70846_g = 0;
                    this.func_70844_e(false);
                }
                if (this.field_70846_g > 1) {
                    final float f1 = MathHelper.sqrt_float(par2) * 0.5f;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    for (int i = 0; i < 3; ++i) {
                        final EntityWaterBall entitysmallfireball = new EntityWaterBall(this.worldObj, (EntityLivingBase)this);
                        entitysmallfireball.posY = this.posY + this.height / 2.0f + 0.5;
                        this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                    }
                }
            }
            this.rotationYaw = (float)(Math.atan2(d3, d0) * 180.0 / 3.141592653589793) - 90.0f;
            this.hasAttacked = true;
        }
    }
    
    protected float getSoundPitch() {
        return 0.5f;
    }
    
    public boolean isBurning() {
        return false;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote) {
            if (this.isWet()) {
                this.heal(0.1f);
            }
            if (this.func_70845_n()) {
                for (int i = 0; i < 20; ++i) {
                    this.worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 2.0, this.rand.nextGaussian() * 2.0, this.rand.nextGaussian() * 2.0);
                }
            }
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
            }
            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + this.getEntityToAttack().getEyeHeight() > this.posY + this.getEyeHeight() + this.heightOffset) {
                this.motionY += (0.30000001192092896 - this.motionY) * 0.30000001192092896;
            }
        }
        if (this.rand.nextInt(24) == 0) {
            this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "liquid.water", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        for (int i = 0; i < 5; ++i) {
            this.worldObj.spawnParticle("dripWater", this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, this.rand.nextGaussian() * 2.0, this.rand.nextGaussian() * 2.0, this.rand.nextGaussian() * 2.0);
            this.worldObj.spawnParticle("bubble", this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, this.rand.nextGaussian() * 2.0, this.rand.nextGaussian() * 2.0, this.rand.nextGaussian() * 2.0);
        }
    }
}
