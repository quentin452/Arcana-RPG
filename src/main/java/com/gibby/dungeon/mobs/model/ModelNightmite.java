package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNightmite extends ModelBase
{
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Horn1;
    ModelRenderer Horn2;
    ModelRenderer Horn3;
    ModelRenderer Horn4;
    ModelRenderer Horn5;
    ModelRenderer Horn6;
    ModelRenderer Body4;

    public ModelNightmite() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body1 = new ModelRenderer(this, 0, 16)).addBox(-4.0f, 0.0f, -4.0f, 8, 8, 8);
        this.Body1.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.Body1.setTextureSize(64, 32);
        this.Body1.mirror = true;
        this.setRotation(this.Body1);
        (this.Body2 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, 9.0f, -3.0f, 6, 1, 6);
        this.Body2.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Body2.setTextureSize(64, 32);
        this.Body2.mirror = true;
        this.setRotation(this.Body2);
        (this.Body3 = new ModelRenderer(this, 27, 0)).addBox(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.Body3.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Body3.setTextureSize(64, 32);
        this.Body3.mirror = true;
        this.setRotation(this.Body3);
        (this.Horn1 = new ModelRenderer(this, 0, 0)).addBox(-9.0f, -2.0f, -2.0f, 1, 4, 4);
        this.Horn1.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.Horn1.setTextureSize(64, 32);
        this.Horn1.mirror = true;
        this.setRotation(this.Horn1);
        (this.Horn2 = new ModelRenderer(this, 37, 0)).addBox(-10.0f, 0.0f, -1.0f, 1, 2, 2);
        this.Horn2.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.Horn2.setTextureSize(64, 32);
        this.Horn2.mirror = true;
        this.setRotation(this.Horn2);
        (this.Horn3 = new ModelRenderer(this, 27, 0)).addBox(-11.0f, -3.0f, -1.0f, 1, 4, 2);
        this.Horn3.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.Horn3.setTextureSize(64, 32);
        this.Horn3.mirror = true;
        this.setRotation(this.Horn3);
        (this.Horn4 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -2.0f, -2.0f, 1, 4, 4);
        this.Horn4.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.Horn4.setTextureSize(64, 32);
        this.Horn4.mirror = true;
        this.setRotation(this.Horn4);
        (this.Horn5 = new ModelRenderer(this, 37, 0)).addBox(1.0f, 0.0f, -1.0f, 1, 2, 2);
        this.Horn5.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.Horn5.setTextureSize(64, 32);
        this.Horn5.mirror = true;
        this.setRotation(this.Horn5);
        (this.Horn6 = new ModelRenderer(this, 27, 0)).addBox(2.0f, -3.0f, -1.0f, 1, 4, 2);
        this.Horn6.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.Horn6.setTextureSize(64, 32);
        this.Horn6.mirror = true;
        this.setRotation(this.Horn6);
        (this.Body4 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, 0.0f, -3.0f, 6, 1, 6);
        this.Body4.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Body4.setTextureSize(64, 32);
        this.Body4.mirror = true;
        this.setRotation(this.Body4);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.Body3.render(f5);
        this.Horn1.render(f5);
        this.Horn2.render(f5);
        this.Horn3.render(f5);
        this.Horn4.render(f5);
        this.Horn5.render(f5);
        this.Horn6.render(f5);
        this.Body4.render(f5);
    }

    private void setRotation(final ModelRenderer model) {
        model.rotateAngleX = (float) 0.0;
        model.rotateAngleY = (float) 0.0;
        model.rotateAngleZ = (float) 0.0;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
