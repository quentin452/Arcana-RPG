

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

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
