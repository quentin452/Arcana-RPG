

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRockTroll extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Tail;
    ModelRenderer Tail2;
    ModelRenderer Head;

    public ModelRockTroll() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("LeftArm.LeftArm", 0, 0);
        this.setTextureOffset("LeftArm.LeftClub", 39, 52);
        this.setTextureOffset("LeftArm.LowerLeftArm", 0, 45);
        this.setTextureOffset("RightArm.RightArm", 0, 0);
        this.setTextureOffset("RightArm.RightClub", 39, 52);
        this.setTextureOffset("RightArm.LowerRightArm", 0, 45);
        this.setTextureOffset("Head.Head", 55, 0);
        this.setTextureOffset("Head.Jaw", 90, 0);
        (this.Body = new ModelRenderer(this, 76, 20)).addBox(-8.0f, -10.0f, -5.0f, 16, 20, 10);
        this.Body.setRotationPoint(0.0f, 3.0f, 7.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.5576792f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer(this, 0, 0)).addBox(9.0f, -1.0f, -3.0f, 6, 14, 6);
        this.RightLeg.setRotationPoint(-6.0f, 11.0f, 9.0f);
        this.RightLeg.setTextureSize(128, 64);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -1.0f, -3.0f, 6, 14, 6);
        this.LeftLeg.setRotationPoint(-6.0f, 11.0f, 9.0f);
        this.LeftLeg.setTextureSize(128, 64);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer(this, "LeftArm")).setRotationPoint(-8.0f, -2.0f, 4.0f);
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox("LeftArm", -6.0f, -2.0f, -3.0f, 6, 20, 6);
        this.LeftArm.addBox("LeftClub", -6.0f, 14.0f, -19.0f, 6, 6, 6);
        this.LeftArm.addBox("LowerLeftArm", -5.0f, 15.0f, -13.0f, 4, 4, 15);
        (this.RightArm = new ModelRenderer(this, "RightArm")).setRotationPoint(8.0f, -2.0f, 4.0f);
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        this.RightArm.mirror = true;
        this.RightArm.addBox("RightArm", 0.0f, -2.0f, -3.0f, 6, 20, 6);
        this.RightArm.addBox("RightClub", 0.0f, 14.0f, -19.0f, 6, 6, 6);
        this.RightArm.addBox("LowerRightArm", 1.0f, 15.0f, -13.0f, 4, 4, 15);
        (this.Tail = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -3.0f, -1.0f, 2, 6, 2);
        this.Tail.setRotationPoint(0.0f, 12.0f, 21.0f);
        this.Tail.setTextureSize(128, 64);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 1.487144f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer(this, 0, 0)).addBox(-2.0f, -3.0f, -2.0f, 4, 6, 4);
        this.Tail2.setRotationPoint(0.0f, 11.0f, 16.0f);
        this.Tail2.setTextureSize(128, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 1.07818f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -3.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.Head.addBox("Jaw", -5.0f, -3.0f, -5.0f, 10, 3, 9);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.Tail.render(f5);
        this.Tail2.render(f5);
        this.Head.render(f5);
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
