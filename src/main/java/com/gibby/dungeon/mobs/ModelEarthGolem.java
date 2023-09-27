

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEarthGolem extends ModelBase
{
    ModelRenderer body;
    ModelRenderer leftarm;
    ModelRenderer rightarm;
    ModelRenderer head;

    public ModelEarthGolem() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.body = new ModelRenderer(this, 0, 0)).addBox(-4.0f, 0.0f, -3.0f, 8, 24, 6);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer(this, 0, 50)).addBox(-15.0f, -2.0f, -2.0f, 15, 4, 4);
        this.leftarm.setRotationPoint(-4.0f, 3.0f, 0.0f);
        this.leftarm.setTextureSize(64, 64);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer(this, 0, 50)).addBox(0.0f, -2.0f, -2.0f, 15, 4, 4);
        this.rightarm.setRotationPoint(4.0f, 3.0f, 0.0f);
        this.rightarm.setTextureSize(64, 64);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer(this, 0, 32)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.head.setRotationPoint(-4.0f, -8.0f, -4.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.leftarm.render(f5);
        this.rightarm.render(f5);
        this.head.render(f5);
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
