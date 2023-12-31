

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.entityinstance.EntityIceShielder;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

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
