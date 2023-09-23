

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderYeti extends RenderBiped
{
    private static final ResourceLocation yetiTextures;
    
    public RenderYeti(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderYeti.yetiTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.1f, 1.1f, 1.1f);
    }
    
    static {
        yetiTextures = new ResourceLocation("gibby_dungeons:textures/mobs/yeti.png");
    }
}
