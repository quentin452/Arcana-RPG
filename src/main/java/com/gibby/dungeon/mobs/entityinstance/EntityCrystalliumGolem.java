package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class EntityCrystalliumGolem extends EntityMob
{
    public EntityCrystalliumGolem(final World par1World) {
        super(par1World);
        this.setSize(2.0f, 2.4f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5);
    }

    public int getTotalArmorValue() {
        return 18;
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

    protected float getSoundPitch() {
        return 0.8f;
    }

    public void onUpdate() {
        super.onUpdate();
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.4, 1.4, 1.4));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0 && !this.worldObj.isRemote) {
                    EntityPlayer player = (EntityPlayer)list2.get(k2);
                    if (!player.capabilities.isCreativeMode) {
                        // Appliquer des dégâts uniquement si le joueur n'est pas en mode créatif
                        player.addVelocity((player.posX - this.posX) / 4.0, 0.7, (player.posZ - this.posZ) / 4.0);
                        player.attackEntityFrom(DamageSource.generic, 3.0f);
                        player.hurtResistantTime = 0;
                        player.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0f);
                    }
                }
            }
        }
    }

    protected void dropRareDrop(final int par1) {
        this.entityDropItem(new ItemStack(Dungeons.crystallium), 1.0f);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final int r = Dungeons.randRange(0, 10);
        if (r == 0) {
            this.dropItem(Item.getItemFromBlock(Dungeons.voidrockOre), 1);
        }
        if (r == 1) {
            this.dropItem(Dungeons.magirockCrystal, 1);
        }
        if (Dungeons.randRange(0, 15) == 0) {
            this.dropItem(Dungeons.magicCoin, 1);
        }
    }
}
