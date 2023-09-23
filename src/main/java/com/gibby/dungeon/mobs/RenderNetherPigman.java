

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;

public class RenderNetherPigman extends RenderZombie
{
    private static final ResourceLocation netherPigmanTextures;
    
    protected ResourceLocation getEntityTexture(final EntityZombie par1EntityZombie) {
        return RenderNetherPigman.netherPigmanTextures;
    }
    
    static {
        netherPigmanTextures = new ResourceLocation("gibby_dungeons:textures/mobs/netherpigman.png");
    }
}
