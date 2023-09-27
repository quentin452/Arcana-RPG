

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGolem extends RenderLiving
{
    private static final ResourceLocation golemTextures;
    private static final ResourceLocation golemOpenTextures;

    public RenderGolem(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        if (((EntityBigStoneGolem)var1).hurtResistantTime == 0) {
            return RenderGolem.golemOpenTextures;
        }
        return RenderGolem.golemTextures;
    }

    static {
        golemTextures = new ResourceLocation("gibby_dungeons:textures/mobs/StoneGolem.png");
        golemOpenTextures = new ResourceLocation("gibby_dungeons:textures/mobs/StoneGolemOpen.png");
    }
}
