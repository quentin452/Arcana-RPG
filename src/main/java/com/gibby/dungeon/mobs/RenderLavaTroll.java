

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderLavaTroll extends RenderLiving
{
    private static final ResourceLocation trollTextures;
    
    public RenderLavaTroll(final ModelMoltroll model, final float par2) {
        super((ModelBase)model, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderLavaTroll.trollTextures;
    }
    
    static {
        trollTextures = new ResourceLocation("gibby_dungeons:textures/mobs/moltroll.png");
    }
}
