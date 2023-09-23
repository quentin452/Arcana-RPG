

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderIceSpirit extends RenderLiving
{
    private static final ResourceLocation iceTextures;
    
    public RenderIceSpirit(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        GL11.glEnable(3042);
        return RenderIceSpirit.iceTextures;
    }
    
    static {
        iceTextures = new ResourceLocation("gibby_dungeons:textures/mobs/icespirit.png");
    }
}
