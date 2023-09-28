package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntityMidnightTitan extends EntityMob implements IBossDisplayData
{
    int counter;
    int projCounter;
    int showerCounter;
    int chargeCounter;
    boolean attack;

    public EntityMidnightTitan(final World par1World) {
        super(par1World);
        this.counter = 0;
        this.projCounter = 700;
        this.showerCounter = 200;
        this.chargeCounter = 400;
        this.attack = false;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.setSize(4.0f, 4.4f);
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, 10000, 1));
        this.renderDistanceWeight = 500.0;
        this.experienceValue = 1000;
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 200;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(60.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(750.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public int getTotalArmorValue() {
        return 23;
    }

    protected String getLivingSound() {
        return "gibby_dungeons:midnightTitan";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:crystalHurt";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:midnightTitanDeath";
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 19 && !this.worldObj.isRemote) {
            bossDisplay.setBossStatus(this, true);
            this.func_145748_c_();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        --this.counter;
        --this.showerCounter;
        --this.projCounter;
        --this.chargeCounter;
        this.worldObj.spawnParticle("depthsuspend", this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.0, 0.0);
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(3.0, 1.5, 3.0));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && !((EntityPlayer) list2.get(k2)).capabilities.isCreativeMode && this.counter < 0 && !this.worldObj.isRemote) {
                    ((EntityPlayer) list2.get(k2)).addVelocity((((EntityPlayer) list2.get(k2)).posX - this.posX) / 2.0, 0.9, (((EntityPlayer) list2.get(k2)).posZ - this.posZ) / 2.0);
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 26.0f);
                    if (this.getEquipmentInSlot(1) != null) {
                        ((EntityPlayer) list2.get(k2)).addPotionEffect(new PotionEffect(Dungeons.sunspot.id, 60, 0));
                    }
                    this.counter = 100;
                }
            }
        }
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(15.8, 2.0, 15.8));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && !((EntityPlayer) list2.get(k2)).capabilities.isCreativeMode && this.projCounter < 100 && !this.worldObj.isRemote) {
                    if (this.getEquipmentInSlot(1) != null) {
                        for (int i = 0; i < 50; ++i) {
                            final EntityRagedProjectile proj = new EntityRagedProjectile(this.worldObj, this.posX + this.rand.nextGaussian() * 1.5, this.posY + 4.0 + this.rand.nextGaussian() * 2.0, this.posZ + this.rand.nextGaussian() * 1.5);
                            this.worldObj.spawnEntityInWorld(proj);
                            proj.addVelocity(proj.motionX * 3.0, proj.motionY * 3.0, proj.motionZ * 3.0);
                        }
                        for (int i = 0; i < 20; ++i) {
                            final EntityRagedSizzler proj2 = new EntityRagedSizzler(this.worldObj, ((EntityPlayer) list2.get(k2)).posX + Dungeons.randGauss() * 8.0, ((EntityPlayer) list2.get(k2)).posY + 7.0 + Dungeons.randGauss(), ((EntityPlayer) list2.get(k2)).posZ + Dungeons.randGauss() * 8.0);
                            proj2.addVelocity(Dungeons.randGauss() / 4.0, 0.0, Dungeons.randGauss() / 4.0);
                            this.worldObj.spawnEntityInWorld(proj2);
                        }
                    }
                    if (this.getEquipmentInSlot(1) == null) {
                        for (int i = 0; i < 50; ++i) {
                            final EntityMidnightProjectile proj3 = new EntityMidnightProjectile(this.worldObj, this.posX + this.rand.nextGaussian() * 1.5, this.posY + 4.0 + this.rand.nextGaussian() * 2.0, this.posZ + this.rand.nextGaussian() * 1.5);
                            this.worldObj.spawnEntityInWorld(proj3);
                            proj3.addVelocity(proj3.motionX * 3.0, proj3.motionY * 3.0, proj3.motionZ * 3.0);
                        }
                        for (int i = 0; i < 20; ++i) {
                            final EntityMidnightSizzler proj4 = new EntityMidnightSizzler(this.worldObj, ((EntityPlayer) list2.get(k2)).posX + Dungeons.randGauss() * 8.0, ((EntityPlayer) list2.get(k2)).posY + 7.0 + Dungeons.randGauss(), ((EntityPlayer) list2.get(k2)).posZ + Dungeons.randGauss() * 8.0);
                            proj4.addVelocity(Dungeons.randGauss() / 4.0, 0.0, Dungeons.randGauss() / 4.0);
                            this.worldObj.spawnEntityInWorld(proj4);
                        }
                    }
                    this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 80, 5));
                    this.projCounter = 650;
                    this.heal(15.0f);
                }
            }
        }
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(12.8, 1.5, 12.8));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && !((EntityPlayer) list2.get(k2)).capabilities.isCreativeMode && this.showerCounter < 300 && !this.worldObj.isRemote) {
                    for (int i = 0; i < 20; ++i) {
                        final EntityMidnightMeteor proj5 = new EntityMidnightMeteor(this.worldObj, this);
                        proj5.setPosition(((EntityPlayer) list2.get(k2)).posX + Dungeons.randGauss() * 4.0, ((EntityPlayer) list2.get(k2)).posY + 35.0 + Dungeons.randGauss() * 6.0, ((EntityPlayer) list2.get(k2)).posZ + Dungeons.randGauss() * 4.0);
                        this.worldObj.spawnEntityInWorld(proj5);
                    }
                    this.showerCounter = 800;
                }
            }
        }
        List list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(7.0, 4.0, 7.0));
        if (list3 != null) {
            for (int k3 = 0; k3 < list3.size(); ++k3) {
                if (list3.get(k3) instanceof EntityPlayer && !((EntityPlayer) list3.get(k3)).capabilities.isCreativeMode && this.chargeCounter < 300 && !this.worldObj.isRemote) {
                    final double X = ((EntityPlayer) list3.get(k3)).posX - this.posX;
                    final double Z = ((EntityPlayer) list3.get(k3)).posZ - this.posZ;
                    this.addVelocity(X / 5.3, 0.5, Z / 5.3);
                    this.chargeCounter = 900;
                }
            }
        }
        final int x = (int)this.posX;
        final int y = (int)this.posY;
        final int z = (int)this.posZ;
        for (int X2 = -2; X2 < 2; ++X2) {
            for (int Y = -2; Y < 2; ++Y) {
                if (!this.worldObj.isAirBlock(x + X2, y, z + Y)) {
                    this.worldObj.setBlockToAir(x + X2, y, z + Y);
                }
            }
        }
        if (this.getHealth() < 150.0f && this.getEquipmentInSlot(1) == null) {
            this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.sandRod));
            if (!this.worldObj.isRemote) {
                this.heal(50.0f);
                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10000, 1));
                final EntityPowerupEffect effect = new EntityPowerupEffect(this.worldObj, this.posX, this.posY, this.posZ);
                this.worldObj.spawnEntityInWorld(effect);
                list3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 10.0, 20.0));
                if (list3 != null) {
                    for (int k4 = 0; k4 < list3.size(); ++k4) {
                        if (list3.get(k4) instanceof EntityPlayer && !((EntityPlayer) list3.get(k4)).capabilities.isCreativeMode && !this.worldObj.isRemote) {
                            ((EntityPlayer) list3.get(k4)).addPotionEffect(new PotionEffect(Dungeons.shock.id, 100, 0));
                            ((EntityPlayer) list3.get(k4)).addPotionEffect(new PotionEffect(Dungeons.sunspot.id, 100, 0));
                            ((EntityPlayer) list3.get(k4)).addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 0));
                            ((EntityPlayer) list3.get(k4)).addChatMessage(new ChatComponentText("I WILL DEFEAT YOU!"));
                        }
                    }
                }
            }
        }
        if (this.getHealth() <= 0.0f && !this.worldObj.isRemote) {
            final EntityPowerupEffect effect = new EntityPowerupEffect(this.worldObj, this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(effect);
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
                par1DamageSource.getEntity().attackEntityFrom(DamageSource.outOfWorld, 60.0f);
            }
            return true;
        }
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.runeShard, 16);
        this.dropItem(Dungeons.darkSoul, 3);
        this.dropItem(Dungeons.midnightCoin, 5);
        this.dropItem(Dungeons.titanicTome, 1);
    }
}
