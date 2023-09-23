

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderCrystalBadgerer extends RenderLiving
{
    private static final ResourceLocation badgerTextures;
    
    public RenderCrystalBadgerer(final ModelCrystalBadger model, final float par2) {
        super((ModelBase)model, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderCrystalBadgerer.badgerTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    static {
        badgerTextures = new ResourceLocation("gibby_dungeons:textures/mobs/crystalbadger.png");
    }
}
