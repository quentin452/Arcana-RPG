

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderVoidFiend extends RenderLiving
{
    private static final ResourceLocation thiefTextures;
    
    public RenderVoidFiend() {
        super((ModelBase)new ModelVillager(0.0f), 0.5f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderVoidFiend.thiefTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.1f, 1.1f, 1.1f);
    }
    
    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/voidfiend.png");
    }
}
