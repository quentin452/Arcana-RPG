

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAmethystMonster extends RenderLiving
{
    private static final ResourceLocation amethystTextures;

    public RenderAmethystMonster(final ModelAmethystMonster modelAmethystMonster, final float par2) {
        super(modelAmethystMonster, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderAmethystMonster.amethystTextures;
    }

    static {
        amethystTextures = new ResourceLocation("gibby_dungeons:textures/mobs/amethystMonster.png");
    }
}
