

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.model.ModelEarthGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderStoneGolem extends RenderLiving
{
    private static final ResourceLocation thiefTextures;

    public RenderStoneGolem(final ModelEarthGolem ModelGolem, final float par2) {
        super(ModelGolem, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderStoneGolem.thiefTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }

    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/smallstonegolem.png");
    }
}
