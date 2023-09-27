

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnchantEffect extends EntityThrowable
{
    boolean impacted;
    int counter;
    public EntityItem item;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityEnchantEffect(final World par1World) {
        super(par1World);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityEnchantEffect(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityEnchantEffect(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.impacted = false;
        this.counter = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            this.worldObj.spawnParticle("instantSpell", this.posX, this.posY, this.posZ, 0.0, 0.5, 0.0);
            for (int i = 0; i < 60; ++i) {
                final double particlePositionX = Math.cos(i * 6) * 1.6;
                final double particlePositionY = Math.sin(i * 6) * 1.6;
                final double particlePositionZ = Math.sin(i * 6) * 1.6;
                this.worldObj.spawnParticle("enchantmenttable", this.posX + particlePositionX, this.posY, this.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("enchantmenttable", this.posX + particlePositionX / 2.0, this.posY, this.posZ + particlePositionZ / 2.0, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("enchantmenttable", this.posX + particlePositionX / 4.0, this.posY, this.posZ + particlePositionZ / 4.0, 0.0, 0.0, 0.0);
            }
            if (this.counter > 40 && this.worldObj != null) {
                for (int i = 0; i < 300; ++i) {
                    this.worldObj.spawnParticle("witchMagic", this.posX + Dungeons.randGauss(), this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss(), 0.0, 0.5, 0.0);
                }
                if (this.item != null) {
                    this.worldObj.spawnEntityInWorld((Entity)this.item);
                }
                this.setDead();
            }
        }
    }

    protected void onImpact(final MovingObjectPosition var1) {
        if (this.worldObj != null && var1.entityHit == null) {
            this.impacted = true;
            if (this.freezeX == 0.0) {
                this.freezeX = this.posX;
                this.freezeY = this.posY;
                this.freezeZ = this.posZ;
            }
        }
    }
}
