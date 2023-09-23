

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderIceMage extends RenderBiped
{
    private static final ResourceLocation hermitTextures;
    
    public RenderIceMage(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderIceMage.hermitTextures;
    }
    
    static {
        hermitTextures = new ResourceLocation("gibby_dungeons:textures/mobs/icemage.png");
    }
}
