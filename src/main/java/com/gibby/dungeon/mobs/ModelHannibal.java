

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHannibal extends ModelBase
{
    ModelRenderer Shoulderpad1;
    ModelRenderer Shoulderpad;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;

    public ModelHannibal() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Shoulderpad1 = new ModelRenderer(this, 0, 43)).addBox(0.0f, 0.0f, 0.0f, 7, 4, 8);
        this.Shoulderpad1.setRotationPoint(-14.0f, -15.0f, -4.0f);
        this.Shoulderpad1.setTextureSize(128, 128);
        this.Shoulderpad1.mirror = true;
        this.setRotation(this.Shoulderpad1, 0.0f, 0.0f, 0.2792527f);
        (this.Shoulderpad = new ModelRenderer(this, 0, 43)).addBox(0.0f, 0.0f, 0.0f, 7, 4, 8);
        this.Shoulderpad.setRotationPoint(7.0f, -13.0f, -4.0f);
        this.Shoulderpad.setTextureSize(128, 128);
        this.Shoulderpad.mirror = true;
        this.setRotation(this.Shoulderpad, 0.0f, 0.0f, -0.2792527f);
        (this.head = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 10, 10, 10);
        this.head.setRotationPoint(-1.0f, -15.0f, -1.0f);
        this.head.setTextureSize(128, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer(this, 64, 0)).addBox(-7.0f, 0.0f, -3.0f, 16, 20, 10);
        this.body.setRotationPoint(-1.0f, -13.0f, -2.0f);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer(this, 40, 16)).addBox(-3.0f, -2.0f, -2.0f, 6, 18, 6);
        this.rightarm.setRotationPoint(-11.0f, -10.0f, -1.0f);
        this.rightarm.setTextureSize(128, 128);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer(this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 6, 18, 6);
        this.leftarm.setRotationPoint(9.0f, -10.0f, -1.0f);
        this.leftarm.setTextureSize(128, 128);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer(this, 0, 20)).addBox(-2.0f, 0.0f, -2.0f, 6, 16, 6);
        this.rightleg.setRotationPoint(-5.0f, 7.0f, -1.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer(this, 0, 20)).addBox(-2.0f, 0.0f, -2.0f, 6, 16, 6);
        this.leftleg.setRotationPoint(3.0f, 7.0f, -1.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shoulderpad1.render(f5);
        this.Shoulderpad.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.rotateAngleY = f3 / 57.295776f;
        this.head.rotateAngleX = f4 / 57.295776f;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
    }
}
