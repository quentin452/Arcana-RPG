

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.mobs.entityinstance.EntityBlizzard;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBlizzard extends RenderLiving
{
    private static final ResourceLocation blazeTextures;
    private int field_77068_a;

    public RenderBlizzard() {
        super(new ModelBlaze(), 0.5f);
        this.field_77068_a = ((ModelBlaze)this.mainModel).func_78104_a();
    }

    public void doRender(final EntityBlizzard par1EntityBlizzard, final double par2, final double par4, final double par6, final float par8, final float par9) {
        final int i = ((ModelBlaze)this.mainModel).func_78104_a();
        if (i != this.field_77068_a) {
            this.field_77068_a = i;
            this.mainModel = new ModelBlaze();
        }
        super.doRender((EntityLiving)par1EntityBlizzard, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final EntityBlizzard par1EntitySandstorm) {
        return RenderBlizzard.blazeTextures;
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityBlizzard)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLivingBase par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityBlizzard)par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntityBlizzard)par1Entity);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityBlizzard)par1Entity, par2, par4, par6, par8, par9);
    }

    static {
        blazeTextures = new ResourceLocation("gibby_dungeons:textures/mobs/blizzard.png");
    }
}
