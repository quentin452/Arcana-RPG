

package com.gibby.dungeon.mobs;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderTyphoon extends RenderLiving
{
    private static final ResourceLocation blazeTextures;
    private int field_77068_a;
    private static final String __OBFID = "CL_00000980";
    
    public RenderTyphoon() {
        super((ModelBase)new ModelBlaze(), 0.5f);
        this.field_77068_a = ((ModelBlaze)this.mainModel).func_78104_a();
    }
    
    public void doRender(final EntityTyphoon par1EntityTyphoon, final double par2, final double par4, final double par6, final float par8, final float par9) {
        final int i = ((ModelBlaze)this.mainModel).func_78104_a();
        if (i != this.field_77068_a) {
            this.field_77068_a = i;
            this.mainModel = (ModelBase)new ModelBlaze();
        }
        super.doRender((EntityLiving)par1EntityTyphoon, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTyphoon par1EntityTyphoon) {
        return RenderTyphoon.blazeTextures;
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityTyphoon)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void doRender(final EntityLivingBase par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityTyphoon)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntityTyphoon)par1Entity);
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityTyphoon)par1Entity, par2, par4, par6, par8, par9);
    }
    
    static {
        blazeTextures = new ResourceLocation("gibby_dungeons:textures/mobs/typhoon.png");
    }
}
