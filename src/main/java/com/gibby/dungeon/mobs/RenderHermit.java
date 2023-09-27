

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHermit extends RenderBiped
{
    private static final ResourceLocation hermitTextures;

    public RenderHermit(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderHermit.hermitTextures;
    }

    static {
        hermitTextures = new ResourceLocation("gibby_dungeons:textures/mobs/hermit.png");
    }
}
