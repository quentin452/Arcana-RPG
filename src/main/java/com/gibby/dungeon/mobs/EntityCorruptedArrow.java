

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;

public class EntityCorruptedArrow extends EntityArrow
{
    public EntityCorruptedArrow(final World par1World) {
        super(par1World);
    }
    
    public EntityCorruptedArrow(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityCorruptedArrow(final World par1World, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase, final float par4, final float par5) {
        super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
    }
    
    public EntityCorruptedArrow(final World par1World, final EntityLivingBase par2EntityLivingBase, final float par3) {
        super(par1World, par2EntityLivingBase, par3);
    }
    
    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0.0, 0.1, 0.0);
        final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
        final double d0 = 0.0;
        for (int i = 0; i < list.size(); ++i) {
            final Entity entity1 = list.get(i);
            if (entity1.canBeCollidedWith() && entity1 != this.shootingEntity && entity1.isBurning()) {
                this.setDamage(this.getDamage() * 2.0);
                if (this.getDamage() > 25.0) {
                    this.setDamage(25.0);
                }
            }
        }
    }
}
