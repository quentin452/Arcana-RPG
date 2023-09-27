

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderZombieWarlord extends RenderZombie
{
    private static final ResourceLocation zombieTextures;

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderZombieWarlord.zombieTextures;
    }

    protected void preRenderCallback(final EntityLivingBase par1, final float par2) {
        GL11.glScalef(1.8f, 1.3f, 1.8f);
    }

    static {
        zombieTextures = new ResourceLocation("gibby_dungeons:textures/mobs/warlord.png");
    }
}
