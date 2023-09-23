

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.passive.*;

public class RenderTreeVillager extends RenderVillager
{
    private static final ResourceLocation villagerTextures;
    
    protected ResourceLocation getEntityTexture(final EntityVillager par1EntityVillager) {
        return RenderTreeVillager.villagerTextures;
    }
    
    static {
        villagerTextures = new ResourceLocation("gibby_dungeons:textures/mobs/treevillager.png");
    }
}
