

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderImp extends RenderBiped
{
    private static final ResourceLocation impTextures;

    public RenderImp(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderImp.impTextures;
    }

    static {
        impTextures = new ResourceLocation("gibby_dungeons:textures/mobs/imp.png");
    }
}
