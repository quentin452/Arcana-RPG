package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMidnightCow extends ModelBase
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer horn21;
    ModelRenderer horn22;
    ModelRenderer horn23;
    ModelRenderer horn24;
    ModelRenderer horn25;
    ModelRenderer horn26;
    ModelRenderer horn27;
    ModelRenderer horn28;
    ModelRenderer Head;

    public ModelMidnightCow() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("Head.head", 0, 34);
        this.setTextureOffset("Head.horn29", 22, 12);
        this.setTextureOffset("Head.horn210", 22, 12);
        (this.body = new ModelRenderer(this, 70, 4)).addBox(-6.0f, -10.0f, -7.0f, 12, 18, 10);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
        this.body.setTextureSize(128, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 1.570796f);
        (this.leg1 = new ModelRenderer(this, 0, 16)).addBox(-3.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg1.setRotationPoint(-3.0f, 12.0f, 7.0f);
        this.leg1.setTextureSize(128, 64);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0f);
        (this.leg2 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg2.setRotationPoint(3.0f, 12.0f, 7.0f);
        this.leg2.setTextureSize(128, 64);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0f);
        (this.leg3 = new ModelRenderer(this, 0, 16)).addBox(-3.0f, 0.0f, -3.0f, 4, 12, 4);
        this.leg3.setRotationPoint(-3.0f, 12.0f, -5.0f);
        this.leg3.setTextureSize(128, 64);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.0f);
        (this.leg4 = new ModelRenderer(this, 0, 16)).addBox(-1.0f, 0.0f, -3.0f, 4, 12, 4);
        this.leg4.setRotationPoint(3.0f, 12.0f, -5.0f);
        this.leg4.setTextureSize(128, 64);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.0f);
        (this.horn21 = new ModelRenderer(this, 22, 0)).addBox(4.5f, -1.5f, 13.0f, 1, 4, 3);
        this.horn21.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn21.setTextureSize(128, 64);
        this.horn21.mirror = true;
        this.setRotation(this.horn21, 0.0f);
        (this.horn22 = new ModelRenderer(this, 22, 0)).addBox(4.5f, -2.0f, 1.0f, 1, 4, 3);
        this.horn22.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn22.setTextureSize(128, 64);
        this.horn22.mirror = true;
        this.setRotation(this.horn22, 0.0f);
        (this.horn23 = new ModelRenderer(this, 22, 0)).addBox(4.5f, -3.0f, 5.0f, 1, 7, 3);
        this.horn23.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn23.setTextureSize(128, 64);
        this.horn23.mirror = true;
        this.setRotation(this.horn23, 0.0f);
        (this.horn24 = new ModelRenderer(this, 22, 0)).addBox(4.5f, -2.0f, 9.0f, 1, 4, 3);
        this.horn24.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn24.setTextureSize(128, 64);
        this.horn24.mirror = true;
        this.setRotation(this.horn24, 0.0f);
        (this.horn25 = new ModelRenderer(this, 22, 0)).addBox(-7.5f, -2.0f, 1.0f, 1, 4, 3);
        this.horn25.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn25.setTextureSize(128, 64);
        this.horn25.mirror = true;
        this.setRotation(this.horn25, 0.0f);
        (this.horn26 = new ModelRenderer(this, 22, 0)).addBox(-7.5f, -3.0f, 5.0f, 1, 7, 3);
        this.horn26.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn26.setTextureSize(128, 64);
        this.horn26.mirror = true;
        this.setRotation(this.horn26, 0.0f);
        (this.horn27 = new ModelRenderer(this, 22, 0)).addBox(-7.5f, -2.0f, 9.0f, 1, 4, 3);
        this.horn27.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn27.setTextureSize(128, 64);
        this.horn27.mirror = true;
        this.setRotation(this.horn27, 0.0f);
        (this.horn28 = new ModelRenderer(this, 22, 0)).addBox(-7.5f, -1.5f, 13.0f, 1, 4, 3);
        this.horn28.setRotationPoint(1.0f, 3.0f, -7.0f);
        this.horn28.setTextureSize(128, 64);
        this.horn28.mirror = true;
        this.setRotation(this.horn28, 0.0f);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, 4.0f, -8.0f);
        this.setRotation(this.Head, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("head", -4.0f, -4.0f, -6.0f, 8, 8, 6);
        this.Head.addBox("horn29", -4.5f, -5.0f, -4.0f, 1, 3, 3);
        this.Head.addBox("horn210", 3.5f, -5.0f, -4.0f, 1, 3, 3);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.horn21.render(f5);
        this.horn22.render(f5);
        this.horn23.render(f5);
        this.horn24.render(f5);
        this.horn25.render(f5);
        this.horn26.render(f5);
        this.horn27.render(f5);
        this.horn28.render(f5);
        this.Head.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x) {
        model.rotateAngleX = x;
        model.rotateAngleY = (float) 0.0;
        model.rotateAngleZ = (float) 0.0;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.body.rotateAngleX = 1.5707964f;
        this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
    }
}
