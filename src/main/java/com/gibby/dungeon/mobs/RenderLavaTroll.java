

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLavaTroll extends RenderLiving
{
    private static final ResourceLocation trollTextures;

    public RenderLavaTroll(final ModelMoltroll model, final float par2) {
        super(model, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderLavaTroll.trollTextures;
    }

    static {
        trollTextures = new ResourceLocation("gibby_dungeons:textures/mobs/moltroll.png");
    }
}
