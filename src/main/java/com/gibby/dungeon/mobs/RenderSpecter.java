

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderSpecter extends RenderLiving
{
    private static final ResourceLocation specterTextures;
    
    public RenderSpecter(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderSpecter.specterTextures;
    }
    
    protected void rotateCorpse(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
        super.rotateCorpse(par1EntityLivingBase, par2, par3, par4);
        GL11.glRotatef(90.0f, 0.0f, -1.0f, 0.0f);
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    static {
        specterTextures = new ResourceLocation("gibby_dungeons:textures/mobs/Specter.png");
    }
}
