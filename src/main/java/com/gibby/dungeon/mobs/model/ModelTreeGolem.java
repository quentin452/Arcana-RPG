package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTreeGolem extends ModelBase
{
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Body5;
    ModelRenderer rightArm;
    ModelRenderer leftArm;
    ModelRenderer Head;
    ModelRenderer Body6;
    ModelRenderer Body7;
    ModelRenderer Body8;
    ModelRenderer Body9;
    ModelRenderer Body10;
    ModelRenderer Body11;
    ModelRenderer Body12;

    public ModelTreeGolem() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("rightArm.rightArm1", 40, 32);
        this.setTextureOffset("rightArm.rightArm2", 0, 0);
        this.setTextureOffset("rightArm.rightArm3", 0, 0);
        this.setTextureOffset("rightArm.rightArm4", 0, 0);
        this.setTextureOffset("rightArm.rightArm5", 0, 0);
        this.setTextureOffset("rightArm.rightArm6", 40, 32);
        this.setTextureOffset("rightArm.rightArm7", 0, 32);
        this.setTextureOffset("rightArm.rightArm8", 40, 32);
        this.setTextureOffset("rightArm.rightArm9", 0, 32);
        this.setTextureOffset("rightArm.rightArm10", 40, 32);
        this.setTextureOffset("leftArm.leftArm1", 0, 32);
        this.setTextureOffset("leftArm.leftArm2", 0, 0);
        this.setTextureOffset("leftArm.leftArm3", 0, 0);
        this.setTextureOffset("leftArm.leftArm4", 0, 0);
        this.setTextureOffset("leftArm.leftArm5", 40, 32);
        this.setTextureOffset("leftArm.leftArm6", 40, 32);
        this.setTextureOffset("leftArm.leftArm7", 0, 32);
        this.setTextureOffset("leftArm.leftArm8", 40, 32);
        this.setTextureOffset("leftArm.leftArm9", 0, 32);
        this.setTextureOffset("leftArm.leftArm10", 0, 0);
        this.setTextureOffset("Head.Head", 60, 46);
        this.setTextureOffset("Head.Jaw", 60, 4);
        this.setTextureOffset("Head.Jaw1", 60, 4);
        (this.Body1 = new ModelRenderer(this, 100, 33)).addBox(-7.0f, -12.0f, -6.0f, 12, 12, 1);
        this.Body1.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body1.setTextureSize(128, 64);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, 1.21636f);
        (this.Body2 = new ModelRenderer(this, 60, 33)).addBox(-5.0f, 0.0f, -4.0f, 8, 12, 1);
        this.Body2.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.Body2.setTextureSize(128, 64);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.8203047f);
        (this.rightLeg = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -2.0f, -2.0f, 4, 17, 4);
        this.rightLeg.setRotationPoint(-6.0f, 9.0f, 5.0f);
        this.rightLeg.setTextureSize(128, 64);
        this.rightLeg.mirror = true;
        this.setRotation(this.rightLeg, 0.0f);
        (this.leftLeg = new ModelRenderer(this, 0, 0)).addBox(0.0f, -2.0f, -2.0f, 4, 17, 4);
        this.leftLeg.setRotationPoint(4.0f, 9.0f, 5.0f);
        this.leftLeg.setTextureSize(128, 64);
        this.leftLeg.mirror = true;
        this.setRotation(this.leftLeg, 0.0f);
        (this.Body3 = new ModelRenderer(this, 60, 1)).addBox(-9.0f, -14.0f, -5.0f, 16, 16, 10);
        this.Body3.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body3.setTextureSize(128, 64);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 1.21636f);
        (this.Body4 = new ModelRenderer(this, 60, 33)).addBox(-7.0f, -12.0f, 5.0f, 10, 10, 2);
        this.Body4.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body4.setTextureSize(128, 64);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 1.21636f);
        (this.Body5 = new ModelRenderer(this, 60, 1)).addBox(1.0f, 10.0f, -2.0f, 1, 6, 4);
        this.Body5.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body5.setTextureSize(128, 64);
        this.Body5.mirror = true;
        this.setRotation(this.Body5, 0.8203047f);
        (this.rightArm = new ModelRenderer(this, "rightArm")).setRotationPoint(7.0f, 1.0f, -7.0f);
        this.setRotation(this.rightArm, 0.0f);
        this.rightArm.mirror = true;
        this.rightArm.addBox("rightArm1", 5.0f, -4.0f, -3.0f, 2, 17, 4);
        this.rightArm.addBox("rightArm2", 0.5f, 3.0f, -3.5f, 5, 8, 5);
        this.rightArm.addBox("rightArm3", 0.0f, -3.0f, -4.0f, 6, 6, 6);
        this.rightArm.addBox("rightArm4", 0.0f, 11.0f, -4.0f, 6, 6, 6);
        this.rightArm.addBox("rightArm5", -1.0f, 17.0f, -5.0f, 8, 6, 8);
        this.rightArm.addBox("rightArm6", -1.0f, 8.0f, -3.0f, 2, 4, 4);
        this.rightArm.addBox("rightArm7", 6.0f, 13.0f, -3.0f, 2, 10, 4);
        this.rightArm.addBox("rightArm8", 1.0f, 12.0f, -6.0f, 4, 11, 2);
        this.rightArm.addBox("rightArm9", -2.0f, 12.0f, -3.0f, 2, 11, 4);
        this.rightArm.addBox("rightArm10", 1.0f, 15.0f, 2.0f, 4, 8, 2);
        (this.leftArm = new ModelRenderer(this, "leftArm")).setRotationPoint(-9.0f, 1.0f, -7.0f);
        this.setRotation(this.leftArm, 0.0f);
        this.leftArm.mirror = true;
        this.leftArm.addBox("leftArm1", -8.0f, 11.0f, -3.0f, 2, 12, 4);
        this.leftArm.addBox("leftArm2", -5.5f, 3.0f, -3.5f, 5, 8, 5);
        this.leftArm.addBox("leftArm3", -6.0f, 11.0f, -4.0f, 6, 6, 6);
        this.leftArm.addBox("leftArm4", -7.0f, 17.0f, -5.0f, 8, 6, 8);
        this.leftArm.addBox("leftArm5", -5.0f, 14.0f, 2.0f, 4, 9, 2);
        this.leftArm.addBox("leftArm6", -7.0f, -4.0f, -3.0f, 2, 15, 4);
        this.leftArm.addBox("leftArm7", -1.0f, 6.0f, -3.0f, 2, 5, 4);
        this.leftArm.addBox("leftArm8", 0.0f, 11.0f, -3.0f, 2, 12, 4);
        this.leftArm.addBox("leftArm9", -5.0f, 14.0f, -6.0f, 4, 9, 2);
        this.leftArm.addBox("leftArm10", -6.0f, -3.0f, -4.0f, 6, 6, 6);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(-1.0f, -3.0f, -13.0f);
        this.setRotation(this.Head, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -4.0f, -4.0f, -6.0f, 8, 10, 8);
        this.Head.addBox("Jaw", -4.5f, -3.0f, -7.0f, 9, 2, 10);
        this.Head.addBox("Jaw1", -4.5f, 5.0f, -7.0f, 9, 2, 10);
        (this.Body6 = new ModelRenderer(this, 60, 33)).addBox(-5.0f, 0.0f, 2.0f, 8, 12, 1);
        this.Body6.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.Body6.setTextureSize(128, 64);
        this.Body6.mirror = true;
        this.setRotation(this.Body6, 0.8203047f);
        (this.Body7 = new ModelRenderer(this, 100, 33)).addBox(-6.0f, -11.0f, 5.0f, 12, 12, 1);
        this.Body7.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body7.setTextureSize(128, 64);
        this.Body7.mirror = true;
        this.setRotation(this.Body7, 1.21636f);
        (this.Body8 = new ModelRenderer(this, 60, 1)).addBox(-6.0f, 0.0f, -3.0f, 10, 12, 6);
        this.Body8.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body8.setTextureSize(128, 64);
        this.Body8.mirror = true;
        this.setRotation(this.Body8, 0.8203047f);
        (this.Body9 = new ModelRenderer(this, 60, 1)).addBox(-3.0f, 11.0f, -1.0f, 4, 4, 2);
        this.Body9.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body9.setTextureSize(128, 64);
        this.Body9.mirror = true;
        this.setRotation(this.Body9, 0.8203047f);
        (this.Body10 = new ModelRenderer(this, 60, 1)).addBox(-3.0f, 8.5f, 1.0f, 4, 7, 1);
        this.Body10.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body10.setTextureSize(128, 64);
        this.Body10.mirror = true;
        this.setRotation(this.Body10, 0.8203047f);
        (this.Body11 = new ModelRenderer(this, 60, 1)).addBox(-4.0f, 9.0f, -2.0f, 1, 6, 4);
        this.Body11.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body11.setTextureSize(128, 64);
        this.Body11.mirror = true;
        this.setRotation(this.Body11, 0.8203047f);
        (this.Body12 = new ModelRenderer(this, 60, 1)).addBox(-3.0f, 8.5f, -2.0f, 4, 7, 1);
        this.Body12.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Body12.setTextureSize(128, 64);
        this.Body12.mirror = true;
        this.setRotation(this.Body12, 0.8203047f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.rightLeg.render(f5);
        this.leftLeg.render(f5);
        this.Body3.render(f5);
        this.Body4.render(f5);
        this.Body5.render(f5);
        this.rightArm.render(f5);
        this.leftArm.render(f5);
        this.Head.render(f5);
        this.Body6.render(f5);
        this.Body7.render(f5);
        this.Body8.render(f5);
        this.Body9.render(f5);
        this.Body10.render(f5);
        this.Body11.render(f5);
        this.Body12.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x) {
        model.rotateAngleX = x;
        model.rotateAngleY = (float) 0.0;
        model.rotateAngleZ = (float) 0.0;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.leftLeg.rotateAngleX = -1.5f * this.func_78172_a(par1) * par2;
        this.rightLeg.rotateAngleX = 1.5f * this.func_78172_a(par1) * par2;
        this.leftLeg.rotateAngleY = 0.0f;
        this.rightLeg.rotateAngleY = 0.0f;
        this.rightArm.rotateAngleX = MathHelper.cos(par1 * 0.3662f + 3.1415927f) * 2.0f * par2;
        this.leftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.rightArm.rotateAngleZ = 0.0f;
        this.leftArm.rotateAngleZ = 0.0f;
    }

    private float func_78172_a(final float par1) {
        return (Math.abs(par1 % (float) 13.0 - (float) 13.0 * 0.5f) - (float) 13.0 * 0.25f) / ((float) 13.0 * 0.25f);
    }
}
