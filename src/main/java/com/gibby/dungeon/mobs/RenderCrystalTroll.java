

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCrystalTroll extends RenderLiving
{
    private static final ResourceLocation trollTextures;

    public RenderCrystalTroll(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderCrystalTroll.trollTextures;
    }

    static {
        trollTextures = new ResourceLocation("gibby_dungeons:textures/mobs/crystaltroll.png");
    }
}
