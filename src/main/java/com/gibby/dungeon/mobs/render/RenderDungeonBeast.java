

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDungeonBeast extends RenderLiving
{
    private static final ResourceLocation beastTextures;

    public RenderDungeonBeast(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderDungeonBeast.beastTextures;
    }

    static {
        beastTextures = new ResourceLocation("gibby_dungeons:textures/mobs/dungeonbeast.png");
    }
}
