package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCaveWraith extends RenderLiving
{
    private static final ResourceLocation wraithTextures;

    public RenderCaveWraith(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderCaveWraith.wraithTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.2f, 1.2f, 1.2f);
    }

    static {
        wraithTextures = new ResourceLocation("gibby_dungeons:textures/mobs/cavewraith.png");
    }
}
