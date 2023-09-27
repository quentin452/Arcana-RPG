

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCyclops extends RenderLiving
{
    private static final ResourceLocation thiefTextures;

    public RenderCyclops(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderCyclops.thiefTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.4f, 1.4f, 1.4f);
    }

    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/cyclops.png");
    }
}
