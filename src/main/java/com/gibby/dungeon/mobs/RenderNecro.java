

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNecro extends RenderBiped
{
    private static final ResourceLocation hermitTextures;

    public RenderNecro(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderNecro.hermitTextures;
    }

    static {
        hermitTextures = new ResourceLocation("gibby_dungeons:textures/mobs/necro.png");
    }
}
