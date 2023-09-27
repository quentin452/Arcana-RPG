

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

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
