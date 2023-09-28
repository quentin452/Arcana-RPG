package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityPaladin extends EntityMob implements IBossDisplayData
{
    public boolean isInvincible;
    private int attackTimer;
    private boolean heal;
    private final String publicName = "Paladin";

    public EntityPaladin(final World par1World) {
        super(par1World);
        this.isInvincible = false;
        this.heal = true;
        this.setSize(1.7f, 2.4f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.7);
    }

    public int getTotalArmorValue() {
        return 16;
    }

    protected String getLivingSound() {
        return "minecraft.none";
    }

    protected String getHurtSound() {
        return "random.anvil_land";
    }

    protected String getDeathSound() {
        return "random.anvil_land";
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.getHealth() < 20.0f && this.heal && !this.worldObj.isRemote) {
            this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 240, 3));
            final EntityPaladinHeal heal = new EntityPaladinHeal(this.worldObj, this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(heal);
            this.heal = false;
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.attackTimer < 1 && !this.worldObj.isRemote) {
                    this.attackTimer = 30;
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 2.0, 0.6, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 2.0);
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.magic, (float) Dungeons.randRange(6, 8));
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage(this), (float)Dungeons.randRange(3, 5));
                }
            }
        }
        this.isInvincible = this.attackTimer < 1;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isInvincible) {
            this.worldObj.playSoundAtEntity(this, "mob.blaze.hit", 1.2f, 1.4f);
            return false;
        }
        if (par1DamageSource.getEntity() != null && !(par1DamageSource.getEntity() instanceof EntityPlayer)) {
            par1DamageSource.getEntity().attackEntityFrom(DamageSource.cactus, 10.0f);
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return false;
    }

    public void writeToNBT(final NBTTagCompound compound) {
        super.writeToNBT(compound);
        final NBTTagCompound properties = new NBTTagCompound();
        properties.setBoolean("Heal", this.heal);
        compound.setTag("Paladin", properties);
    }

    public void readFromNBT(final NBTTagCompound compound) {
        super.readFromNBT(compound);
        final NBTTagCompound properties = (NBTTagCompound)compound.getTag("Paladin");
        this.heal = properties.getBoolean("Heal");
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.chamonix, 1);
        this.dropItem(Items.iron_ingot, 6);
        this.dropItem(Items.gold_ingot, 4);
    }
}
