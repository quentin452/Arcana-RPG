

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

public class RenderRemnant extends RenderLiving
{
    private static final ResourceLocation remnantTextures;
    private static final ResourceLocation remnantArmorTextures;
    ModelBase remnantModel;
    
    public RenderRemnant(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.remnantModel = par1ModelBase;
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderRemnant.remnantTextures;
    }
    
    protected int shouldRenderPass(final EntityRemnant remnant, final int par2, final float par3) {
        if (remnant.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        if (par2 == 1) {
            final float f1 = remnant.ticksExisted + par3;
            this.bindTexture(RenderRemnant.remnantArmorTextures);
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            final float f2 = f1 * 0.01f;
            final float f3 = f1 * 0.01f;
            GL11.glTranslatef(f2, f3, 0.0f);
            this.setRenderPassModel(this.remnantModel);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            final float f4 = 0.5f;
            GL11.glColor4f(f4, f4, f4, 1.0f);
            GL11.glDisable(2896);
            GL11.glBlendFunc(1, 1);
            return 1;
        }
        if (par2 == 2) {
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
        }
        return -1;
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityRemnant)par1EntityLivingBase, par2, par3);
    }
    
    static {
        remnantTextures = new ResourceLocation("gibby_dungeons:textures/mobs/remnant.png");
        remnantArmorTextures = new ResourceLocation("gibby_dungeons:textures/mobs/remnantarmor.png");
    }
}
