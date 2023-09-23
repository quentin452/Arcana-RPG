

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderCrystox extends RenderLiving
{
    private static final ResourceLocation crystoxOpenTextures;
    private static final ResourceLocation crystoxClosedTextures;
    
    public RenderCrystox(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return this.getEntityTexture((EntityCrystox)var1);
    }
    
    private ResourceLocation getEntityTexture(final EntityCrystox var1) {
        if (var1.shooting) {
            return RenderCrystox.crystoxClosedTextures;
        }
        return RenderCrystox.crystoxOpenTextures;
    }
    
    static {
        crystoxOpenTextures = new ResourceLocation("gibby_dungeons:textures/mobs/crystoxOpen.png");
        crystoxClosedTextures = new ResourceLocation("gibby_dungeons:textures/mobs/crystoxClosed.png");
    }
}
