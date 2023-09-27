

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.model.ModelCrystalBadger;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCrystalBadgerer extends RenderLiving
{
    private static final ResourceLocation badgerTextures;

    public RenderCrystalBadgerer(final ModelCrystalBadger model, final float par2) {
        super(model, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderCrystalBadgerer.badgerTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }

    static {
        badgerTextures = new ResourceLocation("gibby_dungeons:textures/mobs/crystalbadger.png");
    }
}
