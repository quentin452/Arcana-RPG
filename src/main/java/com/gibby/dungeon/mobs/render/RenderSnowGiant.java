

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSnowGiant extends RenderBiped
{
    private static final ResourceLocation giantTextures;

    public RenderSnowGiant(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderSnowGiant.giantTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }

    static {
        giantTextures = new ResourceLocation("gibby_dungeons:textures/mobs/snowgiant.png");
    }
}
