

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHannibal extends RenderLiving
{
    private static final ResourceLocation hannibalTextures;

    public RenderHannibal(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderHannibal.hannibalTextures;
    }

    static {
        hannibalTextures = new ResourceLocation("gibby_dungeons:textures/mobs/hannibal.png");
    }
}
