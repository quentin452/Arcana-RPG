

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFriendlyZombie extends RenderBiped
{
    private static final ResourceLocation zombieTextures;

    public RenderFriendlyZombie(final ModelZombie par1ModelBiped, final float par2) {
        super((ModelBiped)par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return RenderFriendlyZombie.zombieTextures;
    }

    static {
        zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
    }
}
