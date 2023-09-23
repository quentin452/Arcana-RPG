

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderStoneBot extends RenderLiving
{
    private static final ResourceLocation thiefTextures;
    
    public RenderStoneBot(final ModelIronGolem modelIronGolem, final float par2) {
        super((ModelBase)modelIronGolem, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderStoneBot.thiefTextures;
    }
    
    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/stonebot.png");
    }
}
