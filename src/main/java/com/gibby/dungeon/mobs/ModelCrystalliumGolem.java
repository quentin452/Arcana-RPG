

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrystalliumGolem extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer Pelvis;
    ModelRenderer Leftleg;
    ModelRenderer Rightleg;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Head;

    public ModelCrystalliumGolem() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("LeftArm.LeftShoulder", 0, 0);
        this.setTextureOffset("LeftArm.LeftArm", 70, 0);
        this.setTextureOffset("LeftArm.LeftHand", 45, 30);
        this.setTextureOffset("LeftArm.LeftThumb", 75, 35);
        this.setTextureOffset("LeftArm.LeftPalm", 75, 35);
        this.setTextureOffset("RightArm.RightShoulder", 0, 0);
        this.setTextureOffset("RightArm.RightArm", 70, 0);
        this.setTextureOffset("RightArm.RightHand", 45, 30);
        this.setTextureOffset("RightArm.RightThumb", 75, 35);
        this.setTextureOffset("RightArm.RightPalm", 75, 35);
        this.setTextureOffset("Head.Head", 0, 44);
        this.setTextureOffset("Head.Jaw", 0, 30);
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-10.0f, -7.0f, -7.0f, 20, 14, 14);
        this.Body.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.7853982f, 0.0f, 0.0f);
        (this.Pelvis = new ModelRenderer(this, 0, 0)).addBox(-4.0f, 0.0f, -4.0f, 8, 14, 8);
        this.Pelvis.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.Pelvis.setTextureSize(128, 64);
        this.Pelvis.mirror = true;
        this.setRotation(this.Pelvis, 0.0f, 0.0f, 0.0f);
        (this.Leftleg = new ModelRenderer(this, 70, 0)).addBox(-4.0f, -2.0f, -2.0f, 4, 12, 4);
        this.Leftleg.setRotationPoint(-4.0f, 14.0f, 0.0f);
        this.Leftleg.setTextureSize(128, 64);
        this.Leftleg.mirror = true;
        this.setRotation(this.Leftleg, 0.0f, 0.0f, 0.0f);
        (this.Rightleg = new ModelRenderer(this, 70, 0)).addBox(0.0f, -2.0f, -2.0f, 4, 12, 4);
        this.Rightleg.setRotationPoint(4.0f, 14.0f, 0.0f);
        this.Rightleg.setTextureSize(128, 64);
        this.Rightleg.mirror = true;
        this.setRotation(this.Rightleg, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer(this, "LeftArm")).setRotationPoint(-10.0f, -6.0f, 0.0f);
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox("LeftShoulder", -8.0f, -3.0f, -5.0f, 8, 8, 8);
        this.LeftArm.addBox("LeftArm", -7.0f, 5.0f, -4.0f, 6, 8, 6);
        this.LeftArm.addBox("LeftHand", -9.0f, 13.0f, -6.0f, 4, 11, 10);
        this.LeftArm.addBox("LeftThumb", -3.0f, 13.0f, -5.0f, 3, 8, 8);
        this.LeftArm.addBox("LeftPalm", -5.0f, 13.0f, -5.0f, 2, 3, 8);
        (this.RightArm = new ModelRenderer(this, "RightArm")).setRotationPoint(10.0f, -6.0f, 0.0f);
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        this.RightArm.mirror = true;
        this.RightArm.addBox("RightShoulder", 0.0f, -3.0f, -5.0f, 8, 8, 8);
        this.RightArm.addBox("RightArm", 1.0f, 5.0f, -4.0f, 6, 8, 6);
        this.RightArm.addBox("RightHand", 5.0f, 13.0f, -6.0f, 4, 11, 10);
        this.RightArm.addBox("RightThumb", 0.0f, 13.0f, -5.0f, 3, 8, 8);
        this.RightArm.addBox("RightPalm", 3.0f, 13.0f, -5.0f, 2, 3, 8);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -6.0f, -8.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -5.0f, -9.0f, -5.0f, 10, 10, 10);
        this.Head.addBox("Jaw", -6.0f, -1.0f, -6.0f, 12, 3, 10);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Pelvis.render(f5);
        this.Leftleg.render(f5);
        this.Rightleg.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
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
        this.Rightleg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.Leftleg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.Rightleg.rotateAngleY = 0.0f;
        this.Leftleg.rotateAngleY = 0.0f;
    }
}
