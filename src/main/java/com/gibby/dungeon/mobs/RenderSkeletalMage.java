

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

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
