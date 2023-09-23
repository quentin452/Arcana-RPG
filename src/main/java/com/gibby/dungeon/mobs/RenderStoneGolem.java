

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderStoneGolem extends RenderLiving
{
    private static final ResourceLocation thiefTextures;
    
    public RenderStoneGolem(final ModelIronGolem modelIronGolem, final float par2) {
        super((ModelBase)modelIronGolem, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderStoneGolem.thiefTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(0.8f, 0.8f, 0.8f);
    }
    
    static {
        thiefTextures = new ResourceLocation("gibby_dungeons:textures/mobs/smallstonegolem.png");
    }
}
