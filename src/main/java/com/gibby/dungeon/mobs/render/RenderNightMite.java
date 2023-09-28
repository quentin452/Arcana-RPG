package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNightMite extends RenderLiving
{
    private static final ResourceLocation miteTextures;

    public RenderNightMite(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderNightMite.miteTextures;
    }

    static {
        miteTextures = new ResourceLocation("gibby_dungeons:textures/mobs/nightghost.png");
    }
}
