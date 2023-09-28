package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChamonix extends ModelBase
{
    ModelRenderer Handle;
    ModelRenderer Hilt1;
    ModelRenderer Hilt2;
    ModelRenderer Hilt3;
    ModelRenderer Blade1;
    ModelRenderer Blade2;
    ModelRenderer Blade3;
    ModelRenderer Blade4;
    ModelRenderer Blade5;
    ModelRenderer Blade6;
    ModelRenderer Blade7;
    ModelRenderer Blade8;
    ModelRenderer Blade9;
    ModelRenderer Blade10;
    ModelRenderer Blade11;
    ModelRenderer Blade12;
    ModelRenderer Blade13;
    ModelRenderer Blade14;
    ModelRenderer Blade15;
    ModelRenderer Blade16;
    ModelRenderer Blade17;
    ModelRenderer Blade18;
    ModelRenderer Hilt4;

    public ModelChamonix() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Handle = new ModelRenderer(this, 19, 0)).addBox(0.0f, 0.0f, -9.0f, 2, 2, 16);
        this.Handle.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Handle.setTextureSize(64, 32);
        this.Handle.mirror = true;
        this.setRotation(this.Handle, 0.0f, 0.0f, 0.0f);
        (this.Hilt1 = new ModelRenderer(this, 17, 2)).addBox(-1.5f, 0.0f, -11.0f, 5, 2, 2);
        this.Hilt1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Hilt1.setTextureSize(64, 32);
        this.Hilt1.mirror = true;
        this.setRotation(this.Hilt1, 0.0f, 0.0f, 0.0f);
        (this.Hilt2 = new ModelRenderer(this, 0, 3)).addBox(2.0f, 0.0f, 6.0f, 1, 2, 4);
        this.Hilt2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Hilt2.setTextureSize(64, 32);
        this.Hilt2.mirror = true;
        this.setRotation(this.Hilt2, 0.0f, 0.0f, 0.0f);
        (this.Hilt3 = new ModelRenderer(this, 0, 0)).addBox(-1.0f, 0.0f, 6.0f, 1, 2, 4);
        this.Hilt3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Hilt3.setTextureSize(64, 32);
        this.Hilt3.mirror = true;
        this.setRotation(this.Hilt3, 0.0f, 0.0f, 0.0f);
        (this.Blade1 = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -2.0f, -13.0f, 4, 6, 3);
        this.Blade1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade1.setTextureSize(64, 32);
        this.Blade1.mirror = true;
        this.setRotation(this.Blade1, 0.0f, 0.0f, 0.0f);
        (this.Blade2 = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -1.0f, -10.0f, 4, 4, 3);
        this.Blade2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade2.setTextureSize(64, 32);
        this.Blade2.mirror = true;
        this.setRotation(this.Blade2, 0.0f, 0.0f, 0.0f);
        (this.Blade3 = new ModelRenderer(this, 0, 1)).addBox(0.0f, 2.0f, -16.0f, 3, 3, 3);
        this.Blade3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade3.setTextureSize(64, 32);
        this.Blade3.mirror = true;
        this.setRotation(this.Blade3, 0.0f, 0.0f, 0.0f);
        (this.Blade4 = new ModelRenderer(this, 2, 2)).addBox(-1.0f, -3.0f, -16.0f, 3, 3, 3);
        this.Blade4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade4.setTextureSize(64, 32);
        this.Blade4.mirror = true;
        this.setRotation(this.Blade4, 0.0f, 0.0f, 0.0f);
        (this.Blade5 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 3.0f, -19.0f, 3, 3, 3);
        this.Blade5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade5.setTextureSize(64, 32);
        this.Blade5.mirror = true;
        this.setRotation(this.Blade5, 0.0f, 0.0f, 0.0f);
        (this.Blade6 = new ModelRenderer(this, 0, 2)).addBox(-1.0f, -4.0f, -19.0f, 3, 3, 3);
        this.Blade6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade6.setTextureSize(64, 32);
        this.Blade6.mirror = true;
        this.setRotation(this.Blade6, 0.0f, 0.0f, 0.0f);
        (this.Blade7 = new ModelRenderer(this, 0, 2)).addBox(0.0f, 2.0f, -25.0f, 2, 3, 3);
        this.Blade7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade7.setTextureSize(64, 32);
        this.Blade7.mirror = true;
        this.setRotation(this.Blade7, 0.0f, 0.0f, 0.0f);
        (this.Blade8 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -4.0f, -22.0f, 2, 3, 3);
        this.Blade8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade8.setTextureSize(64, 32);
        this.Blade8.mirror = true;
        this.setRotation(this.Blade8, 0.0f, 0.0f, 0.0f);
        (this.Blade9 = new ModelRenderer(this, 0, 1)).addBox(0.0f, 3.0f, -22.0f, 2, 3, 3);
        this.Blade9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade9.setTextureSize(64, 32);
        this.Blade9.mirror = true;
        this.setRotation(this.Blade9, 0.0f, 0.0f, 0.0f);
        (this.Blade10 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -3.0f, -35.0f, 2, 3, 1);
        this.Blade10.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade10.setTextureSize(64, 32);
        this.Blade10.mirror = true;
        this.setRotation(this.Blade10, 0.0f, 0.0f, 0.0f);
        (this.Blade11 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -3.0f, -25.0f, 2, 3, 3);
        this.Blade11.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade11.setTextureSize(64, 32);
        this.Blade11.mirror = true;
        this.setRotation(this.Blade11, 0.0f, 0.0f, 0.0f);
        (this.Blade12 = new ModelRenderer(this, 0, 0)).addBox(1.0f, -2.0f, -28.0f, 1, 3, 3);
        this.Blade12.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade12.setTextureSize(64, 32);
        this.Blade12.mirror = true;
        this.setRotation(this.Blade12, 0.0f, 0.0f, 0.0f);
        (this.Blade13 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 1.0f, -28.0f, 1, 3, 3);
        this.Blade13.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade13.setTextureSize(64, 32);
        this.Blade13.mirror = true;
        this.setRotation(this.Blade13, 0.0f, 0.0f, 0.0f);
        (this.Blade14 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, -31.0f, 1, 3, 3);
        this.Blade14.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade14.setTextureSize(64, 32);
        this.Blade14.mirror = true;
        this.setRotation(this.Blade14, 0.0f, 0.0f, 0.0f);
        (this.Blade15 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -1.0f, -33.0f, 1, 3, 2);
        this.Blade15.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade15.setTextureSize(64, 32);
        this.Blade15.mirror = true;
        this.setRotation(this.Blade15, 0.0f, 0.0f, 0.0f);
        (this.Blade16 = new ModelRenderer(this, 0, 0)).addBox(1.0f, -1.0f, -33.0f, 1, 3, 2);
        this.Blade16.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade16.setTextureSize(64, 32);
        this.Blade16.mirror = true;
        this.setRotation(this.Blade16, 0.0f, 0.0f, 0.0f);
        (this.Blade17 = new ModelRenderer(this, 0, 0)).addBox(1.0f, -1.0f, -31.0f, 1, 3, 3);
        this.Blade17.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade17.setTextureSize(64, 32);
        this.Blade17.mirror = true;
        this.setRotation(this.Blade17, 0.0f, 0.0f, 0.0f);
        (this.Blade18 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -2.0f, -34.0f, 2, 3, 1);
        this.Blade18.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Blade18.setTextureSize(64, 32);
        this.Blade18.mirror = true;
        this.setRotation(this.Blade18, 0.0f, 0.0f, 0.0f);
        (this.Hilt4 = new ModelRenderer(this, 20, 0)).addBox(0.0f, -1.0f, 7.0f, 2, 4, 2);
        this.Hilt4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Hilt4.setTextureSize(64, 32);
        this.Hilt4.mirror = true;
        this.setRotation(this.Hilt4, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Handle.render(f5);
        this.Hilt1.render(f5);
        this.Hilt2.render(f5);
        this.Hilt3.render(f5);
        this.Blade1.render(f5);
        this.Blade2.render(f5);
        this.Blade3.render(f5);
        this.Blade4.render(f5);
        this.Blade5.render(f5);
        this.Blade6.render(f5);
        this.Blade7.render(f5);
        this.Blade8.render(f5);
        this.Blade9.render(f5);
        this.Blade10.render(f5);
        this.Blade11.render(f5);
        this.Blade12.render(f5);
        this.Blade13.render(f5);
        this.Blade14.render(f5);
        this.Blade15.render(f5);
        this.Blade16.render(f5);
        this.Blade17.render(f5);
        this.Blade18.render(f5);
        this.Hilt4.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
