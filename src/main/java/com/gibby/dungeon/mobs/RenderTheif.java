

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderTheif extends RenderBiped
{
    private static final ResourceLocation thiefTextures;
    
    public RenderTheif(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderTheif.thiefTextures;
    }
    
    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/theif.png");
    }
}
