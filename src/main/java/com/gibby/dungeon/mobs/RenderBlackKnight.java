

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBlackKnight extends RenderLiving
{
    private static final ResourceLocation knightTextures;

    public RenderBlackKnight(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderBlackKnight.knightTextures;
    }

    static {
        knightTextures = new ResourceLocation("gibby_dungeons:textures/mobs/knight.png");
    }
}
