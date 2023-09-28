

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntityCrystalBadgerer extends EntityIronGolem implements IBossDisplayData
{
    public EntityCrystalBadgerer(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.setSize(3.2f, 6.7f);
        this.experienceValue = 200;
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(160.0);
    }

    protected String getLivingSound() {
        return "gibby_dungeons:crystalSay";
    }

    protected String getHurtSound() {
        return "gibby_dungeons:crystalHurt";
    }

    protected String getDeathSound() {
        return "gibby_dungeons:crystalDeath";
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        final int randX = this.rand.nextInt(10) - this.rand.nextInt(10);
        final int randY = this.rand.nextInt(10) - this.rand.nextInt(10);
        final int randZ = this.rand.nextInt(5);
        this.worldObj.spawnParticle("mobSpellAmbient", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        for (int i = 0; i < 40; ++i) {
            final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
            final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
            final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
            this.worldObj.spawnParticle("instantSpell", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
        }
        for (int i = 0; i < 40; ++i) {
            final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
            final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
            final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
            this.worldObj.spawnParticle("witchMagic", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
        }
        for (int i = 0; i < 40; ++i) {
            final int rand2Y = this.rand.nextInt(10) - this.rand.nextInt(10);
            final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
            final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
            this.worldObj.spawnParticle("townaura", this.posX + rand2X, this.posY + rand2Y, this.posZ + rand2Z, -(rand2X + rand2Z / 2.0), 0.5, -(rand2Z + rand2X / 2.0));
        }
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    bossDisplay.setBossStatus(this, true);
                    this.func_145748_c_();
                }
            }
        }
    }

    public int getTotalArmorValue() {
        int i = 0;
        for (final ItemStack itemstack : this.getLastActiveItems()) {
            if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                final int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
                i += l;
            }
        }
        return i + 20;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(30 + this.rand.nextInt(20)));
        if (flag) {
            par1Entity.motionY += 0.3500000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(4);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.crystallium), 2.0f);
        }
        if (r == 1) {
            this.entityDropItem(new ItemStack(Dungeons.amethyst), 3.0f);
        }
        if (r == 3) {
            this.entityDropItem(new ItemStack(Dungeons.voidrockCrystal), 3.0f);
        }
        if (r == 4) {
            this.entityDropItem(new ItemStack(Dungeons.magirockCrystal), 3.0f);
        }
        this.entityDropItem(new ItemStack(Dungeons.magicCoin), 2.0f);
        if (this.rand.nextInt(5) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.crystalliumChestplate), 1.0f);
        }
        if (this.rand.nextInt(2) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.crystallium), 2.0f);
        }
    }
}
