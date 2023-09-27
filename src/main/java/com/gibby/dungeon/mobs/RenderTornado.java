

package com.gibby.dungeon.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTornado extends RenderLiving
{
    private static final ResourceLocation blazeTextures;
    private int field_77068_a;

    public RenderTornado() {
        super(new ModelBlaze(), 0.5f);
        this.field_77068_a = ((ModelBlaze)this.mainModel).func_78104_a();
    }

    public void doRender(final EntityTornado par1EntitySandstorm, final double par2, final double par4, final double par6, final float par8, final float par9) {
        final int i = ((ModelBlaze)this.mainModel).func_78104_a();
        if (i != this.field_77068_a) {
            this.field_77068_a = i;
            this.mainModel = new ModelBlaze();
        }
        super.doRender((EntityLiving)par1EntitySandstorm, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final EntityTornado par1EntitySandstorm) {
        return RenderTornado.blazeTextures;
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityTornado)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLivingBase par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityTornado)par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntityTornado)par1Entity);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityTornado)par1Entity, par2, par4, par6, par8, par9);
    }

    static {
        blazeTextures = new ResourceLocation("gibby_dungeons:textures/mobs/tornado.png");
    }
}
