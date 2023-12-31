

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityHermit extends EntityMob implements IRangedAttackMob
{
    private final EntityAIArrowAttack aiArrowAttack;

    public EntityHermit(final World par1World) {
        super(par1World);
        this.aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 20.0f);
        EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2, false);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.addPotionEffect(new PotionEffect(Dungeons.magicBoost.id, 10000, 0));
        if (par1World != null && !par1World.isRemote) {
            this.setCombatTask();
        }
        this.addRandomArmor();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, (byte) 0);
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    protected float getSoundPitch() {
        return 0.6f;
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.ridingEntity instanceof EntityCreature) {
            final EntityCreature entitycreature = (EntityCreature)this.ridingEntity;
            this.renderYawOffset = entitycreature.renderYawOffset;
        }
    }

    protected Item getDropItem() {
        return Items.stick;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        if (this.rand.nextInt(2) == 0) {
            this.dropItem(Items.leather_chestplate, 1);
        }
        if (this.rand.nextInt(7) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicGem), 1.0f);
        }
        if (this.rand.nextInt(15) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.magicCoin), 1.0f);
        }
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.bloodWand), 1.0f);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Dungeons.bloodWand));
    }

    public void setCombatTask() {
        this.tasks.addTask(4, this.aiArrowAttack);
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase par1, final float par2) {
        final int rand = this.worldObj.rand.nextInt(3);
        if (rand == 0) {
            for (int i = 0; i < 5; ++i) {
                final EntitySpit ball = new EntitySpit(this.worldObj, this);
                final double d0 = par1.posX - this.posX;
                final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball.posY;
                final double d3 = par1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                ball.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
                this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(ball);
            }
        }
        if (rand == 1) {
            for (int i = 0; i < 3; ++i) {
                final EntityExplosive ball2 = new EntityExplosive(this.worldObj, this);
                final double d0 = par1.posX - this.posX;
                final double d2 = par1.posY + par1.getEyeHeight() - 1.100000023841858 - ball2.posY;
                final double d3 = par1.posZ - this.posZ;
                final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
                ball2.setThrowableHeading(d0, d2 + f1, d3, 1.6f, 12.0f);
                this.playSound("random.orb", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(ball2);
            }
        }
        if (rand == 2) {
            final double randD = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
            this.heal(5.0f);
            final EntityHealEffect ball3 = new EntityHealEffect(this.worldObj, this);
            this.worldObj.spawnEntityInWorld(ball3);
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isEntityInvulnerable() || par1DamageSource == DamageSource.magic) {
            return false;
        }
        if (!super.attackEntityFrom(par1DamageSource, par2)) {
            return false;
        }
        final Entity entity = par1DamageSource.getEntity();
        if (this.riddenByEntity != entity && this.ridingEntity != entity) {
            if (entity != this) {
                this.entityToAttack = entity;
            }
            return true;
        }
        return true;
    }

    public void setCurrentItemOrArmor(final int par1, final ItemStack par2ItemStack) {
        super.setCurrentItemOrArmor(par1, par2ItemStack);
        if (!this.worldObj.isRemote && par1 == 0) {
            this.setCombatTask();
        }
    }

    public double getYOffset() {
        return super.getYOffset() - 0.5;
    }
}
