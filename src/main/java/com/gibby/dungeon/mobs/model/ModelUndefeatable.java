

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelUndefeatable extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer BodyPlate1;
    ModelRenderer BodyPlate2;
    ModelRenderer BodyPlate3;
    ModelRenderer BodyPlate4;
    ModelRenderer BodyPlate5;
    ModelRenderer BodyPlate6;
    ModelRenderer RightArm;
    ModelRenderer Head;
    ModelRenderer LeftArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;

    public ModelUndefeatable() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("RightArm.LowerRightArm", 0, 30);
        this.setTextureOffset("RightArm.RightBeam1", 37, 0);
        this.setTextureOffset("RightArm.RightBeam2", 37, 0);
        this.setTextureOffset("RightArm.RightBeam3", 37, 0);
        this.setTextureOffset("RightArm.RightBeam4", 37, 0);
        this.setTextureOffset("RightArm.RightArm", 0, 30);
        this.setTextureOffset("Head.Head", 0, 48);
        this.setTextureOffset("Head.HeadBulb", 20, 24);
        this.setTextureOffset("Head.SideSpike", 42, 0);
        this.setTextureOffset("Head.SideSpike", 42, 0);
        this.setTextureOffset("LeftArm.LowerLeftArm", 0, 30);
        this.setTextureOffset("LeftArm.LeftBeam1", 37, 0);
        this.setTextureOffset("LeftArm.LeftBeam2", 37, 0);
        this.setTextureOffset("LeftArm.LeftBeam3", 37, 0);
        this.setTextureOffset("LeftArm.LeftBeam4", 37, 0);
        this.setTextureOffset("LeftArm.LeftArm", 0, 30);
        this.setTextureOffset("RightLeg.RightLeg", 0, 30);
        this.setTextureOffset("RightLeg.RightToe1", 42, 0);
        this.setTextureOffset("RightLeg.RightToe2", 42, 0);
        this.setTextureOffset("LeftLeg.LeftLeg", 0, 30);
        this.setTextureOffset("LeftLeg.LeftToe1", 42, 0);
        this.setTextureOffset("LeftLeg.LeftToe2", 42, 0);
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-5.0f, -8.0f, -4.0f, 10, 16, 8);
        this.Body.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.BodyPlate1 = new ModelRenderer(this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.BodyPlate1.setRotationPoint(-1.0f, -3.0f, 4.0f);
        this.BodyPlate1.setTextureSize(64, 64);
        this.BodyPlate1.mirror = true;
        this.setRotation(this.BodyPlate1, 0.0f, 0.0f, 0.0f);
        (this.BodyPlate2 = new ModelRenderer(this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.BodyPlate2.setRotationPoint(-4.0f, -3.0f, 4.0f);
        this.BodyPlate2.setTextureSize(64, 64);
        this.BodyPlate2.mirror = true;
        this.setRotation(this.BodyPlate2, 0.0f, 0.0f, 0.0f);
        (this.BodyPlate3 = new ModelRenderer(this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.BodyPlate3.setRotationPoint(2.0f, -3.0f, 4.0f);
        this.BodyPlate3.setTextureSize(64, 64);
        this.BodyPlate3.mirror = true;
        this.setRotation(this.BodyPlate3, 0.0f, 0.0f, 0.0f);
        (this.BodyPlate4 = new ModelRenderer(this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.BodyPlate4.setRotationPoint(-4.0f, -3.0f, -5.0f);
        this.BodyPlate4.setTextureSize(64, 64);
        this.BodyPlate4.mirror = true;
        this.setRotation(this.BodyPlate4, 0.0f, 0.0f, 0.0f);
        (this.BodyPlate5 = new ModelRenderer(this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.BodyPlate5.setRotationPoint(-1.0f, -3.0f, -5.0f);
        this.BodyPlate5.setTextureSize(64, 64);
        this.BodyPlate5.mirror = true;
        this.setRotation(this.BodyPlate5, 0.0f, 0.0f, 0.0f);
        (this.BodyPlate6 = new ModelRenderer(this, 42, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.BodyPlate6.setRotationPoint(2.0f, -3.0f, -5.0f);
        this.BodyPlate6.setTextureSize(64, 64);
        this.BodyPlate6.mirror = true;
        this.setRotation(this.BodyPlate6, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer(this, "RightArm")).setRotationPoint(5.0f, -2.0f, 0.0f);
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        this.RightArm.mirror = true;
        this.RightArm.addBox("LowerRightArm", 0.0f, 8.0f, -2.0f, 4, 6, 4);
        this.RightArm.addBox("RightBeam1", 0.0f, -6.0f, 2.0f, 1, 22, 1);
        this.RightArm.addBox("RightBeam2", 0.0f, -6.0f, -3.0f, 1, 22, 1);
        this.RightArm.addBox("RightBeam3", 3.0f, -6.0f, -3.0f, 1, 22, 1);
        this.RightArm.addBox("RightBeam4", 3.0f, -6.0f, 2.0f, 1, 22, 1);
        this.RightArm.addBox("RightArm", 0.0f, -2.0f, -2.0f, 4, 6, 4);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -5.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.Head.addBox("HeadBulb", -1.0f, -10.0f, -3.0f, 2, 2, 6);
        this.Head.addBox("SideSpike", -5.0f, -12.0f, -1.0f, 1, 8, 3);
        this.Head.addBox("SideSpike", 4.0f, -12.0f, -1.0f, 1, 8, 3);
        (this.LeftArm = new ModelRenderer(this, "LeftArm")).setRotationPoint(-5.0f, -2.0f, 0.0f);
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox("LowerLeftArm", -4.0f, 8.0f, -2.0f, 4, 6, 4);
        this.LeftArm.addBox("LeftBeam1", -4.0f, -6.0f, 2.0f, 1, 22, 1);
        this.LeftArm.addBox("LeftBeam2", -4.0f, -6.0f, -3.0f, 1, 22, 1);
        this.LeftArm.addBox("LeftBeam3", -1.0f, -6.0f, -3.0f, 1, 22, 1);
        this.LeftArm.addBox("LeftBeam4", -1.0f, -6.0f, 2.0f, 1, 22, 1);
        this.LeftArm.addBox("LeftArm", -4.0f, -2.0f, -2.0f, 4, 6, 4);
        (this.RightLeg = new ModelRenderer(this, "RightLeg")).setRotationPoint(3.0f, 11.0f, 0.0f);
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        this.RightLeg.mirror = true;
        this.RightLeg.addBox("RightLeg", -2.0f, 0.0f, -2.0f, 4, 13, 4);
        this.RightLeg.addBox("RightToe1", 1.0f, 11.0f, -5.0f, 1, 2, 3);
        this.RightLeg.addBox("RightToe2", -2.0f, 11.0f, -5.0f, 1, 2, 3);
        (this.LeftLeg = new ModelRenderer(this, "LeftLeg")).setRotationPoint(-3.0f, 11.0f, 0.0f);
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        this.LeftLeg.mirror = true;
        this.LeftLeg.addBox("LeftLeg", -2.0f, 0.0f, -2.0f, 4, 13, 4);
        this.LeftLeg.addBox("LeftToe1", 1.0f, 11.0f, -5.0f, 1, 2, 3);
        this.LeftLeg.addBox("LeftToe2", -2.0f, 11.0f, -5.0f, 1, 2, 3);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.BodyPlate1.render(f5);
        this.BodyPlate2.render(f5);
        this.BodyPlate3.render(f5);
        this.BodyPlate4.render(f5);
        this.BodyPlate5.render(f5);
        this.BodyPlate6.render(f5);
        this.RightArm.render(f5);
        this.Head.render(f5);
        this.LeftArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.rotateAngleY = f3 / 57.295776f;
        this.Head.rotateAngleX = f4 / 57.295776f;
        this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.RightArm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
    }
}
