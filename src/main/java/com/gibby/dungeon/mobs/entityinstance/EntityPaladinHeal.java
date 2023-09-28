package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPaladinHeal extends EntityThrowable
{
    boolean impacted;
    int counter;
    int stage;
    double freezeX;
    double freezeY;
    double freezeZ;

    public EntityPaladinHeal(final World par1World) {
        super(par1World);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    public EntityPaladinHeal(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    protected float getGravityVelocity() {
        return 0.1f;
    }

    public EntityPaladinHeal(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.stage = 0;
        this.freezeX = 0.0;
        this.freezeY = 0.0;
        this.freezeZ = 0.0;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 17 && this.worldObj.isRemote) {
            for (int i = 0; i < 4; ++i) {
                final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(this.worldObj, this.posX + Dungeons.randGauss() / 2.0, this.posY + Dungeons.randGauss() / 2.0, this.posZ + Dungeons.randGauss() / 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(1.0f, 1.0f, 0.0f);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.impacted) {
            this.setPosition(this.freezeX, this.freezeY, this.freezeZ);
            if (!this.worldObj.isRemote) {
                this.worldObj.setEntityState(this, (byte)17);
            }
            this.worldObj.playSoundAtEntity(this, "note.harp", 2.0f, 1.1f);
            if (this.ticksExisted > 100) {
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
