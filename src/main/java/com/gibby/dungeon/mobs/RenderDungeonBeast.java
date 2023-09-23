

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderDungeonBeast extends RenderLiving
{
    private static final ResourceLocation beastTextures;
    
    public RenderDungeonBeast(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderDungeonBeast.beastTextures;
    }
    
    static {
        beastTextures = new ResourceLocation("gibby_dungeons:textures/mobs/dungeonbeast.png");
    }
}
