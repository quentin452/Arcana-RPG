

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCrystalToxic extends EntityThrowable
{
    public EntityCrystalToxic(final World par1World) {
        super(par1World);
    }

    public EntityCrystalToxic(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityCrystalToxic(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.03f;
    }

    protected float func_70182_d() {
        return 0.8f;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            final double motionX = Dungeons.randGauss() / 10.0;
            final double motionY = Dungeons.randGauss() / 10.0;
            final double motionZ = Dungeons.randGauss() / 10.0;
            final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
            particle.setRBGColorF(0.6f, 1.0f, 0.6f);
            particle.setFadeColour(13000);
            Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
        }
        if (this.ticksExisted > 100) {
            this.setDead();
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
            ((EntityLivingBase)var1.entityHit).attackEntityFrom(DamageSource.magic, 3.0f);
            ((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.poison.id, 130, 1));
        }
        this.setDead();
    }
}
