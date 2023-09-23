

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.passive.*;

public class RenderMoundTrader extends RenderVillager
{
    private static final ResourceLocation villagerTextures;
    
    protected ResourceLocation getEntityTexture(final EntityVillager par1EntityVillager) {
        return RenderMoundTrader.villagerTextures;
    }
    
    static {
        villagerTextures = new ResourceLocation("gibby_dungeons:textures/mobs/mage.png");
    }
}
