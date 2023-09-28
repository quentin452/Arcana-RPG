package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.entityinstance.EntityFirefly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFirefly extends RenderLiving
{
    private static final ResourceLocation fireflyTextures;
    private static final ResourceLocation fireflyArmorTextures;
    ModelBase voidModel;

    public RenderFirefly(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.voidModel = par1ModelBase;
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderFirefly.fireflyTextures;
    }

    protected int shouldRenderPass(final EntityFirefly remnant, final int par2, final float par3) {
        if (remnant.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        if (par2 == 1) {
            final float f1 = remnant.ticksExisted + par3;
            this.bindTexture(RenderFirefly.fireflyArmorTextures);
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            final float f2 = f1 * 0.01f;
            final float f3 = f1 * 0.01f;
            GL11.glTranslatef(f2, f3, 0.0f);
            this.setRenderPassModel(this.voidModel);
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
        return this.shouldRenderPass((EntityFirefly)par1EntityLivingBase, par2, par3);
    }

    protected void preRenderCallback(final EntityLivingBase par1, final float par2) {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
    }

    static {
        fireflyTextures = new ResourceLocation("gibby_dungeons:textures/mobs/firefly.png");
        fireflyArmorTextures = new ResourceLocation("gibby_dungeons:textures/mobs/voidlord.png");
    }
}
