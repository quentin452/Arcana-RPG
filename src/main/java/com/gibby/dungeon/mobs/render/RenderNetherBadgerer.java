

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.model.ModelCrystalBadger;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderNetherBadgerer extends RenderLiving
{
    private static final ResourceLocation badgerTextures;

    public RenderNetherBadgerer(final ModelCrystalBadger model, final float par2) {
        super(model, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderNetherBadgerer.badgerTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }

    static {
        badgerTextures = new ResourceLocation("gibby_dungeons:textures/mobs/netherbadger.png");
    }
}
