

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class EntityAntigravity extends EntityThrowable
{
    public float power;
    boolean impacted;
    int counter;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityAntigravity(final World par1World) {
        super(par1World);
        this.power = 1.0f;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
        this.setDead();
    }

    public EntityAntigravity(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.power = 1.0f;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityAntigravity(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.power = 1.0f;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 10; ++i) {
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        }
        if (this.impacted) {
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            if (this.counter <= this.power * 40.0f) {
                final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(5.0, 5.0, 5.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase) {
                            final double VelX = (((EntityLivingBase) list.get(k2)).posX - this.posX) / 5.0;
                            final double VelY = (((EntityLivingBase) list.get(k2)).posY - this.posY) / 5.0;
                            final double VelZ = (((EntityLivingBase) list.get(k2)).posZ - this.posZ) / 5.0;
                            ((EntityLivingBase) list.get(k2)).motionX = -VelX;
                            ((EntityLivingBase) list.get(k2)).motionY = -VelY;
                            ((EntityLivingBase) list.get(k2)).motionZ = -VelZ;
                        }
                    }
                }
            }
            if (this.counter > this.power * 40.0f) {
                for (int q = 0; q < 40; ++q) {
                    final double randnumX = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final double randnumY = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final double randnumZ = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final Vec3 look = Vec3.createVectorHelper(randnumX, randnumY, randnumZ);
                    final double posX = this.posX + look.xCoord;
                    final double posY = this.posY + look.yCoord;
                    final double posZ = this.posZ + look.zCoord;
                    double Xl = look.xCoord * 0.1;
                    double Yl = look.yCoord * 0.1;
                    double Zl = look.zCoord * 0.1;
                    for (int j = 0; j < 100; ++j) {
                        this.worldObj.spawnParticle("crit", posX + Xl * 1.1, posY + Yl * 1.1, posZ + Zl * 1.1, 0.0, 0.0, 0.0);
                        this.worldObj.spawnParticle("magicCrit", posX + (Xl *= 1.1), posY + (Yl *= 1.1), posZ + (Zl *= 1.1), 0.0, 0.0, 0.0);
                    }
                }
                final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(5.0, 5.0, 5.0));
                if (list2 != null) {
                    for (int k3 = 0; k3 < list2.size(); ++k3) {
                        if (list2.get(k3) instanceof EntityLivingBase) {
                            final double VelX2 = ((EntityLivingBase) list2.get(k3)).posX - this.posX;
                            final double VelY2 = ((EntityLivingBase) list2.get(k3)).posY - this.posY;
                            final double VelZ2 = ((EntityLivingBase) list2.get(k3)).posZ - this.posZ;
                            ((EntityLivingBase) list2.get(k3)).motionX = VelX2;
                            ((EntityLivingBase) list2.get(k3)).motionY = VelY2 + this.power;
                            ((EntityLivingBase) list2.get(k3)).motionZ = VelZ2;
                        }
                    }
                }
                this.setDead();
            }
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj != null) {
            this.impacted = true;
            if (this.freezeX == 0.0) {
                this.freezeX = this.posX;
                this.freezeY = this.posY;
                this.freezeZ = this.posZ;
            }
        }
    }
}
