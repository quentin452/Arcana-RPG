

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.List;

public class EntityGhostWither extends EntityWither implements IRangedAttackMob, IBossDisplayData
{
    public boolean specialAttack;
    private boolean angelShock;
    private boolean darkWave;
    private boolean surround;
    private boolean witherSkeletons;
    private int counter;
    private double particlePositionX;
    private double particlePositionY;
    private double particlePositionZ;
    private static final IEntitySelector attackEntitySelector;

    public EntityGhostWither(final World par1World) {
        super(par1World);
        this.setHealth(this.getMaxHealth());
        this.setSize(2.8f, 5.0f);
        this.isImmuneToFire = true;
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 40, 20.0f));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityLiving.class, 0, false, false, EntityGhostWither.attackEntitySelector));
        this.experienceValue = 2000;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250.0);
    }

    public int getTotalArmorValue() {
        return 23;
    }

    public void onUpdate() {
        super.onUpdate();
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(60.0, 60.0, 60.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    BossStatus.setBossStatus((IBossDisplayData)this, true);
                    this.func_145748_c_();
                }
            }
        }
        if (this.getHealth() < 50.0f && this.rand.nextInt(10) == 0 && !this.worldObj.isRemote) {
            this.heal(2.0f);
            this.motionY += 0.8;
        }
        if (this.entityToAttack != null && this.getDistanceSqToEntity(this.entityToAttack) >= 2.6) {
            this.posX += (this.posX - this.entityToAttack.posX) * 0.1;
            this.posY += (this.posY - this.entityToAttack.posY) * 0.1;
            this.posZ += (this.posZ - this.entityToAttack.posZ) * 0.1;
        }
        for (int i = 0; i < 2; ++i) {
            final double timePassed = this.ticksExisted / 2;
            this.particlePositionX = Math.cos(timePassed) * 2.0;
            this.particlePositionY = Math.sin(timePassed) * 2.0;
            this.particlePositionZ = Math.sin(timePassed) * 2.0;
            final EntityFlameFX particle = new EntityFlameFX(this.worldObj, this.posX + this.particlePositionX, this.posY + this.particlePositionY + 1.0, this.posZ + this.particlePositionZ, 0.0, 0.0, 0.0);
            particle.setRBGColorF(0.0f, 0.1f, 0.6f);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        for (int i = 0; i < 2; ++i) {
            final double timePassed = this.ticksExisted / 2;
            this.particlePositionX = Math.cos(timePassed) * 2.0;
            this.particlePositionY = Math.sin(timePassed) * 2.0;
            this.particlePositionZ = Math.sin(timePassed) * 2.0;
            final EntityFlameFX particle = new EntityFlameFX(this.worldObj, this.posX + this.particlePositionX, this.posY + this.particlePositionY + 1.0, this.posZ - this.particlePositionZ, 0.0, 0.0, 0.0);
            particle.setRBGColorF(0.0f, 0.1f, 0.6f);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        if (this.getHealth() > 0.0f) {
            if (this.angelShock && this.entityToAttack != null) {
                this.motionY = 0.5;
                ++this.counter;
                if (this.counter >= 40) {
                    for (int i = 0; i < 2; ++i) {
                        this.worldObj.playSoundAtEntity((Entity)this, "ambient.weather.thunder", 10000.0f, 1.0f);
                        this.worldObj.spawnEntityInWorld((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ));
                    }
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 12.0f, false, false);
                    list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
                    if (list2 != null) {
                        for (int k2 = 0; k2 < list2.size(); ++k2) {
                            if (list2.get(k2) instanceof EntityLivingBase) {
                                final double X = ((EntityLivingBase) list2.get(k2)).posX - this.posX;
                                final double Z = ((EntityLivingBase) list2.get(k2)).posZ - this.posZ;
                                ((EntityLivingBase) list2.get(k2)).addVelocity(X / 10.0, 0.0, Z / 10.0);
                                ((EntityLivingBase) list2.get(k2)).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 8.0f);
                                ((EntityLivingBase) list2.get(k2)).addPotionEffect(new PotionEffect(Dungeons.shock.id, 40, 0));
                            }
                        }
                    }
                    final EntityDarkExplosion entityDarkExplosion;
                    final EntityDarkExplosion wave = entityDarkExplosion = new EntityDarkExplosion(this.worldObj, (EntityLivingBase)this);
                    entityDarkExplosion.posY -= 15.0;
                    this.playSound("step.cloth", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                    this.worldObj.spawnEntityInWorld((Entity)wave);
                    this.angelShock = false;
                    this.counter = 0;
                }
            }
            else if (this.surround) {
                this.motionY = 0.7;
                ++this.counter;
                if (this.counter >= 40) {
                    for (int i = 0; i < 5; ++i) {
                        final double motionX = Dungeons.randGauss() * 4.0;
                        final double motionY = Dungeons.randGauss() * 4.0;
                        final double motionZ = Dungeons.randGauss() * 4.0;
                        this.worldObj.playSoundAtEntity((Entity)this, "ambient.weather.thunder", 15000.0f, 1.0f);
                        final EntityFakeWither wither = new EntityFakeWither(this.worldObj);
                        wither.setPosition(this.posX + motionX, this.posY + motionY, this.posZ + motionZ);
                        this.worldObj.spawnEntityInWorld((Entity)wither);
                        if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                            wither.setAttackTarget((EntityLivingBase)this.entityToAttack);
                        }
                        wither.onSpawnWithEgg((IEntityLivingData)null);
                        wither.setPosition(this.posX + motionX, this.posY + motionY, this.posZ + motionZ);
                    }
                    this.surround = false;
                    this.counter = 0;
                }
            }
            else if (this.witherSkeletons) {
                if (this.counter <= 30) {
                    this.motionY = -0.6;
                }
                ++this.counter;
                if (this.counter >= 40) {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 5.0f, false, false);
                    this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 100, 0));
                    for (int i = 0; i < 5; ++i) {
                        final double motionX = Dungeons.randGauss() * 4.0;
                        final double motionY = Dungeons.randGauss() * 4.0;
                        final double motionZ = Dungeons.randGauss() * 4.0;
                        this.worldObj.playSoundAtEntity((Entity)this, "mob.wither.spawn", 1.2f, 0.8f);
                        final EntitySkeleton skeleton = new EntitySkeleton(this.worldObj);
                        skeleton.setPosition(this.posX + motionX, this.posY + motionY, this.posZ + motionZ);
                        this.worldObj.spawnEntityInWorld((Entity)skeleton);
                        skeleton.setSkeletonType(1);
                        skeleton.fallDistance = -5.0f;
                        if (this.entityToAttack != null && this.entityToAttack instanceof EntityLivingBase) {
                            skeleton.setAttackTarget((EntityLivingBase)this.entityToAttack);
                        }
                        skeleton.onSpawnWithEgg((IEntityLivingData)null);
                        skeleton.setPosition(this.posX + motionX, this.posY + motionY, this.posZ + motionZ);
                    }
                    this.motionY = 1.0;
                    this.witherSkeletons = false;
                    this.counter = 0;
                }
            }
            else if (this.darkWave && this.entityToAttack != null) {
                this.motionY = 0.5;
                ++this.counter;
                if (this.counter >= 40) {
                    for (int i = 0; i < 20; ++i) {
                        final EntityDarkWave entityDarkWave;
                        final EntityDarkWave wave2 = entityDarkWave = new EntityDarkWave(this.worldObj, (EntityLivingBase)this);
                        entityDarkWave.posY -= 8.0;
                        final double d0 = this.entityToAttack.posX + this.rand.nextInt(10) - 5.0 - this.posX;
                        final double d2 = this.entityToAttack.posY + this.entityToAttack.getEyeHeight() - 1.100000023841858 - wave2.posY - this.rand.nextGaussian();
                        final double d3 = this.entityToAttack.posZ + this.rand.nextInt(10) - 5.0 - this.posZ;
                        final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                        wave2.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
                        this.playSound("step.cloth", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                        this.worldObj.spawnEntityInWorld((Entity)wave2);
                    }
                    if (this.counter > 45) {
                        this.darkWave = false;
                        this.counter = 0;
                    }
                }
            }
        }
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase var1, final float var2) {
        super.attackEntityWithRangedAttack(var1, var2);
        final int randAttack = this.rand.nextInt(8);
        this.entityToAttack = (Entity)var1;
        if (randAttack <= 3 && !this.darkWave && !this.surround && !this.witherSkeletons) {
            this.angelShock = true;
        }
        if (randAttack > 5 && !this.angelShock && !this.surround && !this.witherSkeletons) {
            this.darkWave = true;
        }
        if (randAttack == 4 && randAttack <= 18 && !this.angelShock && !this.surround && !this.darkWave) {
            this.witherSkeletons = true;
        }
        if (randAttack == 5 && !this.angelShock && !this.witherSkeletons && !this.darkWave) {
            this.surround = true;
        }
        if (this.angelShock || this.darkWave || this.surround || this.witherSkeletons) {
            this.specialAttack = true;
        }
        final int X = (int)this.posX;
        final int Y = (int)this.posY;
        final int Z = (int)this.posZ;
        for (int x = -10; x < 10; ++x) {
            for (int y = -10; y < 10; ++y) {
                for (int z = -10; z < 10; ++z) {
                    if ((Math.abs(x) < 10 && Math.abs(z) < 7) || Math.abs(x) < 7 || Math.abs(z) < 7 || (Math.abs(x) < 7 && Math.abs(z) < 10)) {
                        if (this.worldObj.getBlock(x + X, y + Y, z + Z) instanceof BlockLog) {
                            this.worldObj.setBlock(x + X, y + Y, z + Z, Blocks.coal_block);
                        }
                        else if (this.worldObj.getBlock(x + X, y + Y, z + Z) == Blocks.grass || this.worldObj.getBlock(x + X, y + Y - 1, z + Z) == Blocks.farmland) {
                            this.worldObj.setBlock(x + X, y + Y, z + Z, Blocks.dirt);
                        }
                        else if (this.worldObj.getBlock(x + X, y + Y, z + Z) instanceof BlockBush) {
                            if (this.worldObj.getBlock(x + X, y + Y - 1, z + Z) == Blocks.dirt) {
                                this.worldObj.setBlock(x + X, y + Y, z + Z, Blocks.deadbush);
                            }
                            else {
                                this.worldObj.setBlock(x + X, y + Y, z + Z, Blocks.air);
                            }
                        }
                        else if (this.worldObj.getBlock(x + X, y + Y, z + Z) instanceof BlockLeaves) {
                            this.worldObj.setBlock(x + X, y + Y, z + Z, Blocks.air);
                        }
                    }
                }
            }
        }
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Items.nether_star, 1);
        this.dropItem(Dungeons.valesis, 1);
        this.dropItem(Dungeons.magicCoin, 20);
        this.dropItem(Dungeons.voidCoin, 10);
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return !this.isEntityInvulnerable() && par1DamageSource != DamageSource.setExplosionSource(new Explosion(this.worldObj, (Entity)this, this.posX, this.posY, this.posZ, 20.0f)) && super.attackEntityFrom(par1DamageSource, par2);
    }

    static {
        attackEntitySelector = (IEntitySelector)new IEntitySelector() {

            public boolean isEntityApplicable(final Entity par1Entity) {
                return par1Entity instanceof EntityLivingBase && ((EntityLivingBase)par1Entity).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
            }
        };
    }
}
