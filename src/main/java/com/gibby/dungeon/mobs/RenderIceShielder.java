

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;

public class RenderIceShielder extends RenderLiving
{
    private static final ResourceLocation iceShootingTextures;
    private static final ResourceLocation iceClosedTextures;
    
    public RenderIceShielder(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return this.getEntityTexture((EntityIceShielder)var1);
    }
    
    private ResourceLocation getEntityTexture(final EntityIceShielder var1) {
        if (var1.charge > 20) {
            return RenderIceShielder.iceShootingTextures;
        }
        return RenderIceShielder.iceClosedTextures;
    }
    
    static {
        iceShootingTextures = new ResourceLocation("gibby_dungeons:textures/mobs/iceshieldershooting.png");
        iceClosedTextures = new ResourceLocation("gibby_dungeons:textures/mobs/iceshielderclosed.png");
    }
}
