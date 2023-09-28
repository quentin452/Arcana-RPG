package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.util.ResourceLocation;

import javax.swing.text.html.parser.Entity;

public class RenderMidnightChicken extends RenderChicken
{
    private static final ResourceLocation chickenTextures;

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderMidnightChicken.chickenTextures;
    }

    public RenderMidnightChicken(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    static {
        chickenTextures = new ResourceLocation("gibby_dungeons:textures/mobs/midnightchicken.png");
    }
}
