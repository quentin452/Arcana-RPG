

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelShimmerman extends ModelBase
{
    ModelRenderer leftpad;
    ModelRenderer rightpad;
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer PadSpike1;
    ModelRenderer PadSpike2;
    ModelRenderer backspike1;
    ModelRenderer backspike2;
    ModelRenderer backspike3;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Headwear;
    ModelRenderer Body;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer o;

    public ModelShimmerman() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.leftpad = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.leftpad.setRotationPoint(4.0f, -15.0f, -2.0f);
        this.leftpad.setTextureSize(64, 32);
        this.leftpad.mirror = true;
        this.setRotation(this.leftpad, 0.0f, 0.0f, 0.0f);
        (this.rightpad = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.rightpad.setRotationPoint(-7.0f, -15.0f, -2.0f);
        this.rightpad.setTextureSize(64, 32);
        this.rightpad.mirror = true;
        this.setRotation(this.rightpad, 0.0f, 0.0f, 0.0f);
        (this.spike1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.spike1.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike1.setTextureSize(64, 32);
        this.spike1.mirror = true;
        this.setRotation(this.spike1, -2.96706f, 0.7853982f, 0.2094395f);
        (this.spike2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.spike2.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike2.setTextureSize(64, 32);
        this.spike2.mirror = true;
        this.setRotation(this.spike2, 3.141593f, 0.7853982f, 0.0f);
        (this.spike3 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.spike3.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike3.setTextureSize(64, 32);
        this.spike3.mirror = true;
        this.setRotation(this.spike3, 2.96706f, 0.7853982f, -0.1745329f);
        (this.spike4 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.spike4.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike4.setTextureSize(64, 32);
        this.spike4.mirror = true;
        this.setRotation(this.spike4, 2.792527f, 0.7853982f, -0.3490659f);
        (this.PadSpike1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.PadSpike1.setRotationPoint(6.0f, -17.0f, -1.0f);
        this.PadSpike1.setTextureSize(64, 32);
        this.PadSpike1.mirror = true;
        this.setRotation(this.PadSpike1, 0.0f, 0.0f, 0.7853982f);
        (this.PadSpike2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.PadSpike2.setRotationPoint(-6.0f, -16.0f, -1.0f);
        this.PadSpike2.setTextureSize(64, 32);
        this.PadSpike2.mirror = true;
        this.setRotation(this.PadSpike2, 0.0f, 0.0f, -0.7853982f);
        (this.backspike1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 22, 2);
        this.backspike1.setRotationPoint(7.0f, -19.0f, 2.0f);
        this.backspike1.setTextureSize(64, 32);
        this.backspike1.mirror = true;
        this.setRotation(this.backspike1, 0.0f, 0.0f, 0.7853982f);
        (this.backspike2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.backspike2.setRotationPoint(10.0f, -21.0f, 3.0f);
        this.backspike2.setTextureSize(64, 32);
        this.backspike2.mirror = true;
        this.setRotation(this.backspike2, 0.0f, 0.0f, 0.7853982f);
        (this.backspike3 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.backspike3.setRotationPoint(8.0f, -20.0f, 2.0f);
        this.backspike3.setTextureSize(64, 32);
        this.backspike3.mirror = true;
        this.setRotation(this.backspike3, 0.0f, 0.0f, 0.7853982f);
        (this.Shape1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -10.0f, -22.0f, 2, 18, 2);
        this.Shape1.setRotationPoint(6.0f, -14.0f, -1.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 1.570796f, 3.141593f, 0.0f);
        (this.Shape2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -13.0f, 20.0f, 1, 4, 1);
        this.Shape2.setRotationPoint(5.5f, -13.5f, 0.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 1.570796f, 0.0f, 3.141593f);
        (this.Shape3 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -16.0f, 21.0f, 1, 5, 1);
        this.Shape3.setRotationPoint(6.0f, -14.0f, 0.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 1.570796f, 0.0f, 3.141593f);
        (this.Headwear = new ModelRenderer(this, 0, 16)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.Headwear.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.Headwear.setTextureSize(64, 32);
        this.Headwear.mirror = true;
        this.setRotation(this.Headwear, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer(this, 32, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.Body.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer(this, 56, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 24, 2);
        this.RightArm.setRotationPoint(-5.0f, -12.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer(this, 56, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 24, 2);
        this.LeftArm.setRotationPoint(5.0f, -12.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        this.LeftArm.mirror = false;
        (this.RightLeg = new ModelRenderer(this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2);
        this.RightLeg.setRotationPoint(-2.0f, -2.0f, 0.0f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer(this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2);
        this.LeftLeg.setRotationPoint(2.0f, -2.0f, 0.0f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        this.LeftLeg.mirror = false;
        (this.o = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.o.setRotationPoint(0.0f, -19.0f, 0.0f);
        this.o.setTextureSize(64, 32);
        this.o.mirror = true;
        this.setRotation(this.o, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.leftpad.render(f5);
        this.rightpad.render(f5);
        this.spike1.render(f5);
        this.spike2.render(f5);
        this.spike3.render(f5);
        this.spike4.render(f5);
        this.PadSpike1.render(f5);
        this.PadSpike2.render(f5);
        this.backspike1.render(f5);
        this.backspike2.render(f5);
        this.backspike3.render(f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Headwear.render(f5);
        this.Body.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.o.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.Headwear.rotateAngleY = f3 / 57.295776f;
        this.Headwear.rotateAngleX = f4 / 57.295776f;
        this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.RightArm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
        this.Shape1.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f + 90.0f;
        this.Shape2.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f + 90.0f;
        this.Shape3.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f + 90.0f;
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
