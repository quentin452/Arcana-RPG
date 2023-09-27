

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderIceSpirit extends RenderLiving
{
    private static final ResourceLocation iceTextures;

    public RenderIceSpirit(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        GL11.glEnable(3042);
        return RenderIceSpirit.iceTextures;
    }

    static {
        iceTextures = new ResourceLocation("gibby_dungeons:textures/mobs/icespirit.png");
    }
}
