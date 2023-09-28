package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMidnightMagician extends RenderLiving
{
    private static final ResourceLocation magicianTextures;

    public RenderMidnightMagician(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderMidnightMagician.magicianTextures;
    }

    static {
        magicianTextures = new ResourceLocation("gibby_dungeons:textures/mobs/MidnightMagician.png");
    }
}
