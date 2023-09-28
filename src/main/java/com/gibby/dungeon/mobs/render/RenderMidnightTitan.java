package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.entityinstance.EntityMidnightTitan;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMidnightTitan extends RenderLiving
{
    private static final ResourceLocation titanTextures;
    private static final ResourceLocation titanfireTextures;

    public RenderMidnightTitan(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        if (var1 instanceof EntityMidnightTitan && ((EntityMidnightTitan)var1).getEquipmentInSlot(1) != null) {
            return RenderMidnightTitan.titanfireTextures;
        }
        return RenderMidnightTitan.titanTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.3f, 1.3f, 1.3f);
    }

    static {
        titanTextures = new ResourceLocation("gibby_dungeons:textures/mobs/midnighttitan.png");
        titanfireTextures = new ResourceLocation("gibby_dungeons:textures/mobs/midnighttitanfire.png");
    }
}
