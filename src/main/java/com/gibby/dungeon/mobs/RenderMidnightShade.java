

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderMidnightShade extends RenderLiving
{
    private static final ResourceLocation shadeTextures;
    
    public RenderMidnightShade(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderMidnightShade.shadeTextures;
    }
    
    static {
        shadeTextures = new ResourceLocation("gibby_dungeons:textures/mobs/midnightshade.png");
    }
}
