

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;

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
                final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(5.0, 5.0, 5.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase) {
                            final double VelX = (list.get(k2).posX - this.posX) / 5.0;
                            final double VelY = (list.get(k2).posY - this.posY) / 5.0;
                            final double VelZ = (list.get(k2).posZ - this.posZ) / 5.0;
                            list.get(k2).motionX = -VelX;
                            list.get(k2).motionY = -VelY;
                            list.get(k2).motionZ = -VelZ;
                        }
                    }
                }
            }
            if (this.counter > this.power * 40.0f) {
                final int X = (int)this.freezeX;
                final int Y = (int)this.freezeY;
                final int Z = (int)this.freezeZ;
                for (int q = 0; q < 40; ++q) {
                    final Double randnumX = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final Double randnumY = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final Double randnumZ = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final Vec3 look = Vec3.createVectorHelper((double)randnumX, (double)randnumY, (double)randnumZ);
                    final double posX = this.posX + look.xCoord * 1.0;
                    final double posY = this.posY + look.yCoord * 1.0;
                    final double posZ = this.posZ + look.zCoord * 1.0;
                    double Xl = look.xCoord * 0.1;
                    double Yl = look.yCoord * 0.1;
                    double Zl = look.zCoord * 0.1;
                    for (int j = 0; j < 100; ++j) {
                        this.worldObj.spawnParticle("crit", posX + Xl * 1.1, posY + Yl * 1.1, posZ + Zl * 1.1, 0.0, 0.0, 0.0);
                        this.worldObj.spawnParticle("magicCrit", posX + (Xl *= 1.1), posY + (Yl *= 1.1), posZ + (Zl *= 1.1), 0.0, 0.0, 0.0);
                    }
                }
                final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(5.0, 5.0, 5.0));
                if (list2 != null) {
                    for (int k3 = 0; k3 < list2.size(); ++k3) {
                        if (list2.get(k3) instanceof EntityLivingBase) {
                            final double VelX2 = list2.get(k3).posX - this.posX;
                            final double VelY2 = list2.get(k3).posY - this.posY;
                            final double VelZ2 = list2.get(k3).posZ - this.posZ;
                            list2.get(k3).motionX = VelX2;
                            list2.get(k3).motionY = VelY2 + this.power;
                            list2.get(k3).motionZ = VelZ2;
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
