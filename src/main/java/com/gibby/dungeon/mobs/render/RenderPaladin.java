package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.entityinstance.EntityPaladin;
import com.gibby.dungeon.mobs.model.ModelPaladin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPaladin extends RenderLiving
{
    private static final ResourceLocation paladin_textures;
    private static final ResourceLocation paladin_armor_textures;
    private final ModelPaladin model;

    public RenderPaladin(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = new ModelPaladin();
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderPaladin.paladin_textures;
    }

    protected int shouldRenderPass(final EntityPaladin knight, final int par2, final float par3) {
        if (knight.isInvincible) {
            GL11.glDepthMask(!knight.isInvisible());
            if (par2 == 1) {
             final float f1 = knight.ticksExisted + par3;
                GL11.glDepthMask(false);
                this.bindTexture(RenderPaladin.paladin_armor_textures);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                final float f2 = f1 * 0.01f;
                final float f3 = f1 * 0.01f;
                GL11.glTranslatef(f2, f3, 0.0f);
                this.setRenderPassModel(this.model);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                final float f4 = 0.5f;
                GL11.glColor4f(f4, f4, f4, 1.0f);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                return 1;
            }
            if (par2 == 2) {
                GL11.glDepthMask(true);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }
        return -1;
    }

    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityPaladin)par1EntityLivingBase, par2, par3);
    }

    static {
        paladin_textures = new ResourceLocation("gibby_dungeons:textures/mobs/paladin.png");
        paladin_armor_textures = new ResourceLocation("gibby_dungeons:textures/mobs/paladin_armor.png");
    }
}
