package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTreeGolem extends RenderLiving
{
    private static final ResourceLocation golemTextures;

    public RenderTreeGolem(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderTreeGolem.golemTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
    }

    static {
        golemTextures = new ResourceLocation("gibby_dungeons:textures/mobs/treegolem.png");
    }
}
