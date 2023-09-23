

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderBeholder extends RenderLiving
{
    private static final ResourceLocation beholderTextures;
    
    public RenderBeholder(final ModelBeholder modelBeholder, final float par2) {
        super((ModelBase)modelBeholder, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderBeholder.beholderTextures;
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(6.0f, 6.0f, 6.0f);
    }
    
    protected void rotateCorpse(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
        super.rotateCorpse(par1EntityLivingBase, par2, par3, par4);
        GL11.glRotatef(180.0f, 0.0f, -1.0f, 0.0f);
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glTranslatef(6.0f, -10.0f, 6.0f);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    static {
        beholderTextures = new ResourceLocation("gibby_dungeons:textures/mobs/beholder.png");
    }
}
