

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGhostWither extends RenderLiving
{
    private static final ResourceLocation witherTextures;
    private static final ResourceLocation witherArmorTextures;
    ModelBase ghostModel;

    public RenderGhostWither(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.ghostModel = par1ModelBase;
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderGhostWither.witherTextures;
    }

    protected int shouldRenderPass(final EntityGhostWither wither, final int par2, final float par3) {
        GL11.glDepthMask(true);
        if (par2 == 1) {
            final float f1 = wither.ticksExisted + par3;
            this.bindTexture(RenderGhostWither.witherArmorTextures);
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            final float f2 = f1 * 0.01f;
            final float f3 = f1 * 0.01f;
            GL11.glTranslatef(f2, f3, 0.0f);
            this.setRenderPassModel(this.ghostModel);
            GL11.glScalef(1.5f, 1.5f, 1.5f);
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
        return this.shouldRenderPass((EntityGhostWither)par1EntityLivingBase, par2, par3);
    }

    static {
        witherTextures = new ResourceLocation("gibby_dungeons:textures/mobs/ghostwither.png");
        witherArmorTextures = new ResourceLocation("gibby_dungeons:textures/mobs/blackKnightArmor.png");
    }
}
