

package com.gibby.dungeon.mobs.entityinstance;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityShimmerPearl extends EntityThrowable
{
    public EntityShimmerPearl(final World par1World) {
        super(par1World);
    }

    public EntityShimmerPearl(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    protected float func_70182_d() {
        return 10.0f;
    }

    @SideOnly(Side.CLIENT)
    public EntityShimmerPearl(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (this.getThrower() != null) {
            this.getThrower().mountEntity(this);
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0f);
        }
        for (int i = 0; i < 32; ++i) {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0, this.posZ, this.rand.nextGaussian(), 0.0, this.rand.nextGaussian());
        }
        if (this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ)) {
            this.setDead();
        }
    }
}
