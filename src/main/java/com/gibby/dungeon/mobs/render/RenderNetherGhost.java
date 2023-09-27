

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNetherGhost extends RenderLiving
{
    private static final ResourceLocation ghostTextures;

    public RenderNetherGhost(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderNetherGhost.ghostTextures;
    }

    static {
        ghostTextures = new ResourceLocation("gibby_dungeons:textures/mobs/netherghost.png");
    }
}
