

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

public class EntityNetherBadgerer extends EntityIronGolem implements IBossDisplayData
{
    public EntityNetherBadgerer(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.setSize(2.1f, 4.35f);
        this.experienceValue = 100;
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(90.0);
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.rand.nextInt(5) == 0) {
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        }
        final int randX = this.rand.nextInt(10) - this.rand.nextInt(10);
        final int randY = this.rand.nextInt(10) - this.rand.nextInt(10);
        final int randZ = this.rand.nextInt(5);
        this.worldObj.spawnParticle("flame", this.posX + randX, this.posY + randY, this.posZ + randZ, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
        for (int i = 0; i < 40; ++i) {
            final double rand2X = this.rand.nextGaussian() - this.rand.nextGaussian();
            final double rand2Z = this.rand.nextGaussian() - this.rand.nextGaussian();
            this.worldObj.spawnParticle("lava", this.posX + rand2X, this.posY + randY, this.posZ + rand2Z, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0, this.rand.nextGaussian() / 10.0);
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
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(20 + this.rand.nextInt(15)));
        if (flag) {
            par1Entity.motionY += 0.3500000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = this.rand.nextInt(4);
        if (r == 0) {
            this.entityDropItem(new ItemStack(Dungeons.netherSteelShards), 2.0f);
        }
        if (r == 1) {
            this.entityDropItem(new ItemStack(Dungeons.castIron), 3.0f);
        }
        this.entityDropItem(new ItemStack(Dungeons.voidCoin), 2.0f);
        if (this.rand.nextInt(5) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.fireClub), 1.0f);
        }
        if (this.rand.nextInt(2) == 0) {
            this.entityDropItem(new ItemStack(Dungeons.corruptedSoul), 2.0f);
        }
    }
}
