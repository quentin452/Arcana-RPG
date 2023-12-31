

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySapientDeath extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntitySapientDeath(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntitySapientDeath(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.01f;
    }

    public EntitySapientDeath(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            if (this.worldObj.isRemote) {
                for (int i = 0; i < 10; ++i) {
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss() / 2.0, this.posY + Dungeons.randGauss(), this.posZ + Dungeons.randGauss() / 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(0.0f, 0.0f, 1.0f);
                    particle.setFadeColour(0);
                    Minecraft.getMinecraft().effectRenderer.addEffect(particle);
                }
            }
            ++this.counter;
            this.posX = this.freezeX;
            this.posY = this.freezeY;
            this.posZ = this.freezeZ;
            if (this.counter > 40) {
                if (!this.worldObj.isRemote && this.ticksExisted % 180 == 0) {
                    this.worldObj.playSoundAtEntity(this, "random.fizz", 0.7f, 1.0f);
                }
                if (!this.worldObj.isRemote && this.ticksExisted % 200 == 0) {
                    final EntityMidnightShade entity = new EntityMidnightShade(this.worldObj);
                    entity.setPosition(this.posX, this.posY, this.posZ);
                    this.worldObj.spawnEntityInWorld(entity);
                    entity.onSpawnWithEgg(null);
                    entity.setPosition(this.posX, this.posY, this.posZ);
                    this.setDead();
                }
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
