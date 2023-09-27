

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.gen.WorldGenWarlordDungeon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBeholder extends EntityGhast implements IBossDisplayData
{
    private Entity targetedEntity;
    private int aggroCooldown;
    private boolean cycBomb;
    private int cycCount;
    private boolean spitFire;
    private int hiccupTime;

    public EntityBeholder(final World par1World) {
        super(par1World);
        this.cycBomb = false;
        this.cycCount = 0;
        this.spitFire = false;
        this.hiccupTime = 0;
        this.setSize(9.0f, 9.0f);
        this.experienceValue = 2000;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0);
    }

    public int getTotalArmorValue() {
        return 24;
    }

    protected float getSoundPitch() {
        return 0.9f;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        BossStatus.setBossStatus((IBossDisplayData)this, true);
        this.func_145748_c_();
        for (int i = 0; i < 20; ++i) {
            final int randX = this.rand.nextInt(10) - this.rand.nextInt(10);
            final int randY = this.rand.nextInt(10) - this.rand.nextInt(10);
            final int randZ = this.rand.nextInt(5);
            this.worldObj.spawnParticle("flame", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        }
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.getHealth() <= 0.0f) {
            for (int i = 0; i < 15; ++i) {
                this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
            }
            this.setDead();
        }
    }

    protected void updateEntityActionState() {
        if (this.rand.nextInt(400) == 0 && this.targetedEntity != null) {
            this.spitFire = true;
            this.hiccupTime = 0;
        }
        if (this.spitFire && this.ticksExisted % 15 == 0) {
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity((Entity)this) < 10000.0) {
                final double randY = -this.rand.nextFloat() / 15.0f;
                final double d5 = this.targetedEntity.posX - this.posX;
                final double d6 = this.targetedEntity.boundingBox.minY - (this.posY + this.height / 2.0f);
                final double d7 = this.targetedEntity.posZ - this.posZ;
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                final EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, (EntityLivingBase)this, d5, d6 + randY, d7);
                entitylargefireball.field_92057_e = 4;
                final double d8 = 4.0;
                final Vec3 vec3 = this.getLook(1.0f);
                entitylargefireball.posX = this.posX + vec3.xCoord * d8;
                entitylargefireball.posY = this.posY + this.height / 2.0f + 0.5;
                entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            ++this.hiccupTime;
            if (this.hiccupTime > 7) {
                this.spitFire = false;
            }
        }
        if (this.ticksExisted % 800 == 0 && this.targetedEntity != null) {
            this.cycBomb = true;
            this.cycCount = 0;
        }
        if (this.cycBomb) {
            this.motionY -= 0.05;
            if (this.ticksExisted % 60 == 0) {
                final EntityFireclops entitycyclops = new EntityFireclops(this.worldObj);
                entitycyclops.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld((Entity)entitycyclops);
                if (this.targetedEntity != null && this.targetedEntity instanceof EntityLivingBase) {
                    entitycyclops.setAttackTarget((EntityLivingBase)this.targetedEntity);
                }
                entitycyclops.onSpawnWithEgg((IEntityLivingData)null);
                entitycyclops.setPosition(this.posX, this.posY, this.posZ);
                entitycyclops.fallDistance = -20.0f;
                ++this.cycCount;
            }
            if (this.cycCount > 5) {
                this.cycBomb = false;
            }
        }
        if (this.ticksExisted % 60 == 0) {
            this.heal(2.0f);
        }
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        final double d9 = this.waypointX - this.posX;
        final double d10 = this.waypointY - this.posY;
        final double d11 = this.waypointZ - this.posZ;
        double d12 = d9 * d9 + d10 * d10 + d11 * d11;
        if (d12 < 1.0 || d12 > 3600.0) {
            this.waypointX = this.posX + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.posY + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d12 = MathHelper.sqrt_double(d12);
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d12)) {
                this.motionX += d9 / d12 * 0.1;
                this.motionY += d10 / d12 * 0.1;
                this.motionZ += d11 / d12 * 0.1;
            }
            else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 300.0);
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        final double d13 = 100.0;
        if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity((Entity)this) < d13 * d13) {
            final double d14 = this.targetedEntity.posX - this.posX;
            final double d15 = this.targetedEntity.boundingBox.minY + this.targetedEntity.height / 2.0f - (this.posY + this.height / 2.0f);
            final double d16 = this.targetedEntity.posZ - this.posZ;
            final float n = -(float)Math.atan2(d14, d16) * 180.0f / 3.1415927f;
            this.rotationYaw = n;
            this.renderYawOffset = n;
            if (this.canEntityBeSeen(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    final EntityNetherDriller driller = new EntityNetherDriller(this.worldObj, (EntityLivingBase)this);
                    final double d17 = 4.0;
                    final Vec3 vec4 = this.getLook(1.0f);
                    driller.posX = this.posX + vec4.xCoord * d17;
                    driller.posY = this.posY + 0.5;
                    driller.posZ = this.posZ + vec4.zCoord * d17;
                    this.worldObj.spawnEntityInWorld((Entity)driller);
                    driller.setThrowableHeading(d14, d15, d16, 10.0f, 10.0f);
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.motionX, this.motionZ) * 180.0f / 3.1415927f;
            this.rotationYaw = n2;
            this.renderYawOffset = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        if (!this.worldObj.isRemote) {
            final byte b1 = this.dataWatcher.getWatchableObjectByte(16);
            final byte b2 = (byte)((this.attackCounter > 10) ? 1 : 0);
            if (b1 != b2) {
                this.dataWatcher.updateObject(16, (Object)b2);
            }
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return !this.isEntityInvulnerable() && par1DamageSource != DamageSource.drown && super.attackEntityFrom(par1DamageSource, par2);
    }

    private boolean isCourseTraversable(final double par1, final double par3, final double par5, final double par7) {
        final double d4 = (this.waypointX - this.posX) / par7;
        final double d5 = (this.waypointY - this.posY) / par7;
        final double d6 = (this.waypointZ - this.posZ) / par7;
        final AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        for (int i = 1; i < par7; ++i) {
            axisalignedbb.offset(d4, d5, d6);
            if (!this.worldObj.getCollidingBoundingBoxes((Entity)this, axisalignedbb).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int chestX = (int)this.posX;
        int chestY = (int)this.posY;
        final int chestZ = (int)this.posZ;
        while (this.worldObj.getBlock(chestX, chestY - 1, chestZ) == Blocks.air && --chestY != 0) {}
        WorldGenWarlordDungeon.chest(this.worldObj, this.rand, chestX, chestY + 1, chestZ, "Beholder", 30);
        this.worldObj.setBlock(chestX, chestY, chestZ, Dungeons.netherSteelOre);
        for (int i = 0; i < this.rand.nextInt(20) + 20; ++i) {
            this.entityDropItem(new ItemStack(Dungeons.metalCoin, 1), (float)(20 - this.rand.nextInt(40)));
            this.entityDropItem(new ItemStack(Items.nether_wart, 1), (float)(20 - this.rand.nextInt(40)));
        }
        for (int i = 0; i < this.rand.nextInt(10) + 6; ++i) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin, 1), (float)(20 - this.rand.nextInt(40)));
            this.entityDropItem(new ItemStack(Dungeons.corruptedSoul, 1), (float)(20 - this.rand.nextInt(40)));
            this.entityDropItem(new ItemStack(Dungeons.netherSteelShards, 1), (float)(20 - this.rand.nextInt(20)));
        }
    }
}
