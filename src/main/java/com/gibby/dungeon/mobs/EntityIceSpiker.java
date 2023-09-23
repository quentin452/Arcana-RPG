

package com.gibby.dungeon.mobs;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import com.gibby.dungeon.*;
import net.minecraft.block.*;

public class EntityIceSpiker extends EntityThrowable
{
    public EntityIceSpiker(final World par1World) {
        super(par1World);
        this.setDead();
    }
    
    public EntityIceSpiker(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityIceSpiker(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    protected float getGravityVelocity() {
        return 0.05f;
    }
    
    protected void onImpact(final MovingObjectPosition var1) {
        if (var1.entityHit == null && !this.worldObj.isRemote) {
            this.worldObj.playSoundAtEntity((Entity)this, "dig.class", 1.0f, 1.3f);
            for (int x = -2; x < 3; ++x) {
                for (int z = -2; z < 3; ++z) {
                    if (this.rand.nextInt(6) == 0) {
                        if (this.worldObj.getBlock((int)this.posX + x, (int)this.posY - 1, (int)this.posZ + z) != Blocks.air) {
                            this.worldObj.setBlock((int)this.posX + x, (int)this.posY, (int)this.posZ + z, Dungeons.frostSpikes);
                        }
                        for (int i = 0; i < 10; ++i) {
                            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.snow) + "_0", this.posX + x, this.posY, this.posZ + z, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
                            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.ice) + "_0", this.posX + x, this.posY, this.posZ + z, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
                        }
                    }
                }
                this.setDead();
            }
        }
    }
}
