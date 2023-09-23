

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderVampire extends RenderBiped
{
    private static final ResourceLocation vampireTextures;
    
    public RenderVampire(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderVampire.vampireTextures;
    }
    
    static {
        vampireTextures = new ResourceLocation("gibby_dungeons:textures/mobs/vampire.png");
    }
}
