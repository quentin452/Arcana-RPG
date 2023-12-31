

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderStoneBot extends RenderLiving
{
    private static final ResourceLocation thiefTextures;

    public RenderStoneBot(final ModelIronGolem modelIronGolem, final float par2) {
        super(modelIronGolem, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderStoneBot.thiefTextures;
    }

    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/stonebot.png");
    }
}
