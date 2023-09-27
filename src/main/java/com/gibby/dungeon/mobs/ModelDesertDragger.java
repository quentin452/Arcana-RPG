

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDesertDragger extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer TailSeg3;
    ModelRenderer TailSeg1;
    ModelRenderer TailSeg2;
    ModelRenderer Shell;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Head;

    public ModelDesertDragger() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.Body = new ModelRenderer(this, 0, 47)).addBox(-3.0f, -1.0f, -7.0f, 6, 2, 12);
        this.Body.setRotationPoint(0.0f, 12.0f, 3.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, -0.4363323f, 0.0f, 0.0f);
        (this.TailSeg3 = new ModelRenderer(this, 0, 0)).addBox(-2.0f, -1.0f, -2.0f, 4, 2, 6);
        this.TailSeg3.setRotationPoint(0.0f, 22.0f, 15.0f);
        this.TailSeg3.setTextureSize(64, 64);
        this.TailSeg3.mirror = true;
        this.setRotation(this.TailSeg3, -0.1745329f, 0.0f, 0.0f);
        (this.TailSeg1 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -3.0f, -2.0f, 8, 6, 4);
        this.TailSeg1.setRotationPoint(0.0f, 20.0f, 9.0f);
        this.TailSeg1.setTextureSize(64, 64);
        this.TailSeg1.mirror = true;
        this.setRotation(this.TailSeg1, -0.3490659f, 0.0f, 0.0f);
        (this.TailSeg2 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -2.0f, -2.0f, 6, 4, 4);
        this.TailSeg2.setRotationPoint(0.0f, 21.0f, 12.0f);
        this.TailSeg2.setTextureSize(64, 64);
        this.TailSeg2.mirror = true;
        this.setRotation(this.TailSeg2, -0.2617994f, 0.0f, 0.0f);
        (this.Shell = new ModelRenderer(this, 0, 0)).addBox(-5.0f, -4.0f, -8.0f, 10, 8, 16);
        this.Shell.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Shell.setTextureSize(64, 64);
        this.Shell.mirror = true;
        this.setRotation(this.Shell, -0.4363323f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer(this, 36, 27)).addBox(-2.0f, -1.0f, -2.0f, 4, 14, 4);
        this.RightLeg.setRotationPoint(7.0f, 11.0f, -6.0f);
        this.RightLeg.setTextureSize(64, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer(this, 36, 27)).addBox(-2.0f, -1.0f, -2.0f, 4, 14, 4);
        this.LeftLeg.setRotationPoint(-7.0f, 11.0f, -6.0f);
        this.LeftLeg.setTextureSize(64, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer(this, 0, 29)).addBox(-4.0f, -7.0f, -6.0f, 8, 8, 8);
        this.Head.setRotationPoint(0.0f, 12.0f, -5.0f);
        this.Head.setTextureSize(64, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.TailSeg3.render(f5);
        this.TailSeg1.render(f5);
        this.TailSeg2.render(f5);
        this.Shell.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.Head.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.Head.rotateAngleY = f3 / 57.295776f;
        this.Head.rotateAngleX = f4 / 57.295776f;
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
