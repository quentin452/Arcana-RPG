

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderBigTheif extends RenderBiped
{
    private static final ResourceLocation thiefTextures;
    
    public RenderBigTheif(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderBigTheif.thiefTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.4f, 1.4f, 1.4f);
    }
    
    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/theif.png");
    }
}
