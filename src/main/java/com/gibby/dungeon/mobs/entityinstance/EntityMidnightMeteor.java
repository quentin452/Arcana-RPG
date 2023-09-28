package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityMidnightMeteor  extends EntityThrowable
{
    boolean impacted;

    public EntityMidnightMeteor(final World par1World) {
        super(par1World);
        this.impacted = false;
    }

    public EntityMidnightMeteor(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.impacted = false;
    }

    public EntityMidnightMeteor(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.impacted = false;
    }

    protected float func_70182_d() {
        return 0.0f;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 17 && this.worldObj.isRemote) {
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss() / 10.0, this.posY + Dungeons.randGauss() / 10.0, this.posZ + Dungeons.randGauss() / 10.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.0f, 0.0f, 1.0f);
            particle.setFadeColour(0);
            Minecraft.getMinecraft().effectRenderer.addEffect(particle);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.playSoundAtEntity(this, "random.explode", 0.2f, 1.0f);
        if (this.impacted) {
            for (int i = 0; i < 300; ++i) {
                this.worldObj.spawnParticle("witchMagic", this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.5, 0.0);
            }
            this.worldObj.playSoundAtEntity(this, "fireworks.blast", 1.3f, 0.8f);
            this.setDead();
        }
        if (!this.worldObj.isRemote) {
            this.worldObj.setEntityState(this, (byte)17);
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        this.impacted = true;
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(5.0, 5.0, 5.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if (list2.get(k2) instanceof EntityLivingBase && !(list2.get(k2) instanceof EntityMidnightTitan)) {
                    ((EntityLivingBase) list2.get(k2)).attackEntityFrom(DamageSource.outOfWorld, (float)(14.0 - this.getDistanceSqToEntity((Entity)list2.get(k2))));
                }
            }
        }
    }
}
