

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

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
