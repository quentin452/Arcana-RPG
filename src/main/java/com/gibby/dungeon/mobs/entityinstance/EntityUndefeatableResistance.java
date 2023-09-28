package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.ClientBossDisplay;
import com.gibby.dungeon.mobs.IBossDisplay;
import com.gibby.dungeon.mobs.ServerBossDisplay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;

public class EntityUndefeatableResistance extends EntityUndefeatable implements IBossDisplayData
{
    public static final String publicName = "undefeatableTag";
    float distancedivider;

    public EntityUndefeatableResistance(final World par1World) {
        super(par1World);
        this.distancedivider = 2.5f;
        if(par1World instanceof WorldServer) {
            bossDisplay = new ServerBossDisplay();
        } else {
            bossDisplay = new ClientBossDisplay();
        }
    }
    private final IBossDisplay bossDisplay;

    public void onUpdate() {
        super.onUpdate();
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 10.0, 20.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer) {
                    bossDisplay.setBossStatus(this, true);
                    this.func_145748_c_();
                }
            }
        }
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.3, 1.3, 1.3));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityPlayer && this.ticksExisted % 10 == 0) {
                    ((EntityPlayer) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, 3.0f);
                    ((EntityPlayer) list2.get(k2)).hurtResistantTime = 0;
                    this.attackEntityAsMob((Entity)list2.get(k2));
                }
            }
        }
        list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(3.0, 3.0, 3.0));
        if (list2 != null && this.getHealth() > 0.0f) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityUndefeatable && this.ticksExisted % 20 == 0) {
                    final EntityLivingBase entity = (EntityLivingBase) list2.get(k2);
                    entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 4));
                    double X = entity.posX - this.posX;
                    double Y = entity.posY - this.posY;
                    double Z = entity.posZ - this.posZ;
                    if (this.worldObj.isRemote) {
                        for (int i = 0; i < 20; ++i) {
                            final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + X / 10.0, this.posY + Y / 10.0 + 0.2, this.posZ + Z / 10.0, 0.0f, 0.0f, 0.0f);
                            X += (entity.posX - this.posX) / this.distancedivider;
                            Y += (entity.posY - this.posY) / this.distancedivider;
                            Z += (entity.posZ - this.posZ) / this.distancedivider;
                            particle.setRBGColorF(0.6f, 0.2f, 0.0f);
                            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
                        }
                    }
                }
            }
        }
    }

    protected void despawnEntity() {
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.entityDropItem(new ItemStack(Dungeons.metalCoin), 10.0f);
    }
}
