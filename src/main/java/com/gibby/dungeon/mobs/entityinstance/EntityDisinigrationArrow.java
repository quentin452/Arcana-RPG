

package com.gibby.dungeon.mobs.entityinstance;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

import java.util.List;

public class EntityDisinigrationArrow extends EntityArrow
{
    public EntityDisinigrationArrow(final World par1World) {
        super(par1World);
    }

    public EntityDisinigrationArrow(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntityDisinigrationArrow(final World par1World, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase, final float par4, final float par5) {
        super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
    }

    public EntityDisinigrationArrow(final World par1World, final EntityLivingBase par2EntityLivingBase, final float par3) {
        super(par1World, par2EntityLivingBase, par3);
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, 0.0, 0.1, 0.0);
        this.worldObj.spawnParticle("portal", this.posX, this.posY + 0.1, this.posZ, 0.0, 0.1, 0.0);
        final List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2.0, 2.0, 2.0));
        if (list2 != null) {
            for (int k2 = 0; k2 < list2.size(); ++k2) {
                if ((!(list2.get(k2) instanceof EntityLivingBase) && list2.get(k2) instanceof EntityThrowable) || (list2.get(k2) instanceof EntityArrow && !(list2.get(k2) instanceof EntityDisinigrationArrow))) {
                    ((Entity) list2.get(k2)).worldObj.newExplosion(this, ((Entity) list2.get(k2)).posX, ((Entity) list2.get(k2)).posY, ((Entity) list2.get(k2)).posZ, 1.0f, false, false);
                    ((Entity) list2.get(k2)).setDead();
                }
            }
        }
    }
}
