

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNetherSoul extends RenderBiped
{
    private static final ResourceLocation soulTextures;

    public RenderNetherSoul(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderNetherSoul.soulTextures;
    }

    static {
        soulTextures = new ResourceLocation("gibby_dungeons:textures/mobs/nethersoul.png");
    }
}
