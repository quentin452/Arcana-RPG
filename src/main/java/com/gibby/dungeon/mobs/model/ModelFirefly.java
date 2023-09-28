package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFirefly extends ModelBase
{
    ModelRenderer Body;

    public ModelFirefly() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(32, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
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
