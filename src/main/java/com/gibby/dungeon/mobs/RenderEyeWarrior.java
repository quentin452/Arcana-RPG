

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEyeWarrior extends RenderBiped
{
    private static final ResourceLocation eyeTextures;
    private static final ResourceLocation eyeHurtTextures;

    public RenderEyeWarrior(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        if (((EntityEyeWarrior)var1).hurtResistantTime == 0) {
            return RenderEyeWarrior.eyeTextures;
        }
        return RenderEyeWarrior.eyeHurtTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntitySkeleton, final float par2) {
        GL11.glScalef(1.1f, 1.1f, 1.1f);
    }

    static {
        eyeTextures = new ResourceLocation("gibby_dungeons:textures/mobs/eyewarrior.png");
        eyeHurtTextures = new ResourceLocation("gibby_dungeons:textures/mobs/eyewarrior_closed.png");
    }
}
