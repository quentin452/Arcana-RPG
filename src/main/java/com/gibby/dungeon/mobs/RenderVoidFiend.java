

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderVoidFiend extends RenderLiving
{
    private static final ResourceLocation thiefTextures;

    public RenderVoidFiend() {
        super(new ModelVillager(0.0f), 0.5f);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderVoidFiend.thiefTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.1f, 1.1f, 1.1f);
    }

    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/voidfiend.png");
    }
}
