

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderFireclops extends RenderLiving
{
    private static final ResourceLocation fireTextures;
    
    public RenderFireclops(final ModelBiped par1ModelBase, final float par2) {
        super((ModelBase)par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderFireclops.fireTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.4f, 1.4f, 1.4f);
    }
    
    static {
        fireTextures = new ResourceLocation("gibby_dungeons:textures/mobs/fireclops.png");
    }
}
