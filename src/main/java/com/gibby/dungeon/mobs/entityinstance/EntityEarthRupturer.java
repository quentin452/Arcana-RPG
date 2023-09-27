

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityEarthRupturer extends EntityMob
{
    public EntityEarthRupturer(final World par1World) {
        super(par1World);
        this.setSize(1.5f, 2.0f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
    }

    public int getTotalArmorValue() {
        return 22;
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(4.0, 2.0, 4.0));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 200 > 130) {
                    if (this.ticksExisted % 10 == 0) {
                        this.motionY += 0.2;
                    }
                    this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1, 10));
                    this.worldObj.playSoundAtEntity((Entity)this, "step.ladder", 1.0f, 0.7f);
                    for (int x = 0; x < 10; ++x) {
                        for (int z = 0; z < 10; ++z) {
                            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.dirt) + "_0", this.posX - 5.0 + x, this.posY + 0.5, this.posZ - 5.0 + z, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
                        }
                    }
                    if (((EntityPlayer) list2.get(k2)).onGround && ((EntityPlayer) list2.get(k2)).getDistanceToEntity((Entity)this) < 30.0) {
                        ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 8.0f);
                    }
                }
            }
        }
    }

    protected String getLivingSound() {
        return "gibby_dungeons:rupturerSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:rupturerHit";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:rupturerHit";
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected float getSoundVolume() {
        return 0.8f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        par1Entity.attackEntityFrom(DamageSource.magic, 3.0f);
        return true;
    }
}
