

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSkeletalMage extends RenderSkeleton
{
    private static final ResourceLocation skeletonTextures;

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderSkeletalMage.skeletonTextures;
    }

    static {
        skeletonTextures = new ResourceLocation("gibby_dungeons:textures/mobs/skeletalMage.png");
    }
}
