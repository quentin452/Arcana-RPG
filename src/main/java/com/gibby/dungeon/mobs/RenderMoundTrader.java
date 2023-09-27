

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

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
