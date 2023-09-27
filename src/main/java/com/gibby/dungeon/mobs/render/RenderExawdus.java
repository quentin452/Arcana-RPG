

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderExawdus extends RenderLiving
{
    private static final ResourceLocation exawdus0Textures;
    private static final ResourceLocation exawdus1Textures;
    private static final ResourceLocation exawdus2Textures;
    private static final ResourceLocation exawdus3Textures;
    private static final ResourceLocation exawdus4Textures;

    public RenderExawdus(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity var1) {
        if (var1 instanceof EntityLivingBase) {
            if (((EntityLivingBase)var1).getHealth() > 160.0f) {
                return RenderExawdus.exawdus0Textures;
            }
            if (((EntityLivingBase)var1).getHealth() <= 160.0f && ((EntityLivingBase)var1).getHealth() > 120.0f) {
                return RenderExawdus.exawdus1Textures;
            }
            if (((EntityLivingBase)var1).getHealth() <= 120.0f && ((EntityLivingBase)var1).getHealth() > 80.0f) {
                return RenderExawdus.exawdus2Textures;
            }
            if (((EntityLivingBase)var1).getHealth() <= 80.0f && ((EntityLivingBase)var1).getHealth() > 40.0f) {
                return RenderExawdus.exawdus3Textures;
            }
            if (((EntityLivingBase)var1).getHealth() <= 40.0f && ((EntityLivingBase)var1).getHealth() > 0.0f) {
                return RenderExawdus.exawdus4Textures;
            }
        }
        return RenderExawdus.exawdus0Textures;
    }

    static {
        exawdus0Textures = new ResourceLocation("gibby_dungeons:textures/mobs/exawdus0.png");
        exawdus1Textures = new ResourceLocation("gibby_dungeons:textures/mobs/exawdus1.png");
        exawdus2Textures = new ResourceLocation("gibby_dungeons:textures/mobs/exawdus2.png");
        exawdus3Textures = new ResourceLocation("gibby_dungeons:textures/mobs/exawdus3.png");
        exawdus4Textures = new ResourceLocation("gibby_dungeons:textures/mobs/exawdus4.png");
    }
}
