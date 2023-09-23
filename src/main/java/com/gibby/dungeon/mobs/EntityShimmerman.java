

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import com.gibby.dungeon.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityShimmerman extends EntityEnderman
{
    boolean isfake;
    int charge;
    
    public EntityShimmerman(final World par1World) {
        super(par1World);
        this.isfake = false;
        this.experienceValue = 30;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
    }
    
    public int getTotalArmorValue() {
        return 20;
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Dungeons.shock.id, 50, 0));
            ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.magic, 5.0f);
        }
        if (this.rand.nextInt(5) == 0 && !this.isfake) {
            final EntityShimmerman entity = new EntityShimmerman(this.worldObj);
            entity.setPosition(this.posX + this.rand.nextInt(8) - 4.0, this.posY + 2.0, this.posZ + this.rand.nextInt(8) - 4.0);
            this.worldObj.spawnEntityInWorld((Entity)entity);
            if (this.entityToAttack != null) {
                entity.setAttackTarget((EntityLivingBase)this.entityToAttack);
            }
            entity.onSpawnWithEgg((IEntityLivingData)null);
            entity.setPosition(this.posX + this.rand.nextInt(8) - 4.0, this.posY + 2.0, this.posZ + this.rand.nextInt(8) - 4.0);
            entity.isfake = true;
        }
        return super.attackEntityAsMob(par1Entity);
    }
    
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.worldObj.spawnParticle("enchantmenttable", this.posX, this.posY + this.rand.nextGaussian(), this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
        if (this.isfake) {
            ++this.charge;
            if (this.charge > 120) {
                this.setDead();
            }
        }
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(3);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.amethyst), 1.0f);
        }
        if (this.rand.nextInt(20) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.amethystLance), 1.0f);
        }
        this.dropItem(Dungeons.shimmerPearl, this.rand.nextInt(4) + 1);
        if (this.rand.nextInt(10) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }
}
