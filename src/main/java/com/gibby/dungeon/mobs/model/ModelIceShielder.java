

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIceShielder extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer FrontShield1;
    ModelRenderer FrontShield2;
    ModelRenderer SideShield1;
    ModelRenderer SideShield2;
    ModelRenderer Tail3;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Bottom;
    ModelRenderer Top;

    public ModelIceShielder() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        this.Body.setRotationPoint(0.0f, 0.0f, 7.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.FrontShield1 = new ModelRenderer(this, 0, 42)).addBox(-4.0f, -17.0f, -1.0f, 8, 20, 2);
        this.FrontShield1.setRotationPoint(0.0f, -6.0f, -2.0f);
        this.FrontShield1.setTextureSize(64, 64);
        this.FrontShield1.mirror = true;
        this.setRotation(this.FrontShield1, -0.5235988f, 0.0f, 0.0f);
        (this.FrontShield2 = new ModelRenderer(this, 0, 42)).addBox(-4.0f, -2.0f, -1.0f, 8, 20, 2);
        this.FrontShield2.setRotationPoint(0.0f, 6.0f, -2.0f);
        this.FrontShield2.setTextureSize(64, 64);
        this.FrontShield2.mirror = true;
        this.setRotation(this.FrontShield2, 0.5235988f, 0.0f, 0.0f);
        (this.SideShield1 = new ModelRenderer(this, 0, 38)).addBox(-1.0f, -3.0f, -7.0f, 2, 6, 20);
        this.SideShield1.setRotationPoint(-9.0f, 0.0f, 2.0f);
        this.SideShield1.setTextureSize(64, 64);
        this.SideShield1.mirror = true;
        this.setRotation(this.SideShield1, 0.0f, -0.2617994f, 0.0f);
        (this.SideShield2 = new ModelRenderer(this, 0, 38)).addBox(0.0f, -3.0f, -7.0f, 2, 6, 20);
        this.SideShield2.setRotationPoint(8.0f, 0.0f, 2.0f);
        this.SideShield2.setTextureSize(64, 64);
        this.SideShield2.mirror = true;
        this.setRotation(this.SideShield2, 0.0f, 0.2617994f, 0.0f);
        (this.Tail3 = new ModelRenderer(this, 0, 50)).addBox(-4.0f, -4.0f, -1.0f, 8, 8, 2);
        this.Tail3.setRotationPoint(0.0f, 0.0f, 20.0f);
        this.Tail3.setTextureSize(64, 64);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer(this, 0, 50)).addBox(-6.0f, -6.0f, -1.0f, 12, 12, 2);
        this.Tail1.setRotationPoint(0.0f, 0.0f, 16.0f);
        this.Tail1.setTextureSize(64, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer(this, 0, 50)).addBox(-5.0f, -5.0f, -1.0f, 10, 10, 2);
        this.Tail2.setRotationPoint(0.0f, 0.0f, 18.0f);
        this.Tail2.setTextureSize(64, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Bottom = new ModelRenderer(this, 18, 17)).addBox(-6.0f, -1.0f, -6.0f, 12, 2, 12);
        this.Bottom.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.Bottom.setTextureSize(64, 64);
        this.Bottom.mirror = true;
        this.setRotation(this.Bottom, 0.0f, 0.0f, 0.0f);
        (this.Top = new ModelRenderer(this, 18, 17)).addBox(-6.0f, -1.0f, -6.0f, 12, 2, 12);
        this.Top.setRotationPoint(0.0f, -9.0f, 7.0f);
        this.Top.setTextureSize(64, 64);
        this.Top.mirror = true;
        this.setRotation(this.Top, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.FrontShield1.render(f5);
        this.FrontShield2.render(f5);
        this.SideShield1.render(f5);
        this.SideShield2.render(f5);
        this.Tail3.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Bottom.render(f5);
        this.Top.render(f5);
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
