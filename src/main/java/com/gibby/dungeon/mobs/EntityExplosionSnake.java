

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityExplosionSnake extends EntityThrowable
{
    public int damage;
    boolean impacted;
    int counter;
    double freezeY;
    
    public EntityExplosionSnake(final World par1World) {
        super(par1World);
        this.damage = 4;
        this.freezeY = 0.0;
    }
    
    public EntityExplosionSnake(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.damage = 4;
        this.freezeY = 0.0;
    }
    
    protected float getGravityVelocity() {
        return 0.03f;
    }
    
    public EntityExplosionSnake(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.damage = 4;
        this.freezeY = 0.0;
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            ++this.counter;
            this.posY = this.freezeY;
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 3.3f, false, false);
            if (this.counter > 60) {
                this.setDead();
            }
        }
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj != null && var1.entityHit == null) {
            this.impacted = true;
            if (this.freezeY == 0.0) {
                this.freezeY = this.posY;
            }
        }
    }
}
