

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderNetherBadgerer extends RenderLiving
{
    private static final ResourceLocation badgerTextures;
    
    public RenderNetherBadgerer(final ModelCrystalBadger model, final float par2) {
        super((ModelBase)model, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderNetherBadgerer.badgerTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
    
    static {
        badgerTextures = new ResourceLocation("gibby_dungeons:textures/mobs/netherbadger.png");
    }
}
