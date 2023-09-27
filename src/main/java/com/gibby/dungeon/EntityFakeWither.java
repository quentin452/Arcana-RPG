

package com.gibby.dungeon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.World;

public class EntityFakeWither extends EntityWither
{
    public EntityFakeWither(final World par1World) {
        super(par1World);
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.getHealth() < this.getMaxHealth() || this.ticksExisted > 200) {
            if (this.worldObj.isRemote) {
                for (int i = 0; i < 200; ++i) {
                    final float random = this.rand.nextFloat();
                    final double motionX = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final double motionY = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final double motionZ = this.rand.nextGaussian() - this.rand.nextGaussian();
                    final EntityReddustFX particle = new EntityReddustFX(this.worldObj, this.posX + motionX, this.posY + motionY, this.posZ + motionZ, random, random, random);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
            }
            this.setDead();
        }
    }
}
