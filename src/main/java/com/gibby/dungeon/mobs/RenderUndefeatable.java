

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderUndefeatable extends RenderLiving
{
    private static final ResourceLocation strengthTextures;
    private static final ResourceLocation regenTextures;
    private static final ResourceLocation resistanceTextures;
    int type;

    public RenderUndefeatable(final ModelBase par1ModelBase, final float par2, final int type) {
        super(par1ModelBase, par2);
        this.type = type;
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        return this.getEntityTexture((EntityUndefeatable)var1);
    }

    protected ResourceLocation getEntityTexture(final EntityUndefeatable var1) {
        if (this.type == 1) {
            return RenderUndefeatable.strengthTextures;
        }
        if (this.type == 2) {
            return RenderUndefeatable.regenTextures;
        }
        if (this.type == 3) {
            return RenderUndefeatable.resistanceTextures;
        }
        return null;
    }

    static {
        strengthTextures = new ResourceLocation("gibby_dungeons:textures/mobs/undefeatablestrength.png");
        regenTextures = new ResourceLocation("gibby_dungeons:textures/mobs/undefeatableregen.png");
        resistanceTextures = new ResourceLocation("gibby_dungeons:textures/mobs/undefeatableresistance.png");
    }
}
