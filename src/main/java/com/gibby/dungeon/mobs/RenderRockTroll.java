

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderRockTroll extends RenderLiving
{
    private static final ResourceLocation trollTextures;
    
    public RenderRockTroll(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderRockTroll.trollTextures;
    }
    
    static {
        trollTextures = new ResourceLocation("gibby_dungeons:textures/mobs/rocktroll.png");
    }
}
