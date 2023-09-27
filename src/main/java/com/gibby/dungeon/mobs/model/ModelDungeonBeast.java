

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDungeonBeast extends ModelBase
{
    ModelRenderer Tail;
    ModelRenderer LeftSpike;
    ModelRenderer RightSpike;
    ModelRenderer Torso;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Head;

    public ModelDungeonBeast() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.setTextureOffset("RightLeg.RightLeg", 0, 0);
        this.setTextureOffset("RightLeg.Rightblade", 61, 0);
        this.setTextureOffset("LeftLeg.LeftLeg", 0, 0);
        this.setTextureOffset("LeftLeg.LegBlade", 61, 0);
        this.setTextureOffset("LeftArm.LeftShoulder", 36, 0);
        this.setTextureOffset("LeftArm.LeftArm", 0, 0);
        this.setTextureOffset("LeftArm.LeftShoulderBlade", 74, 0);
        this.setTextureOffset("RightArm.RightShoulder", 36, 0);
        this.setTextureOffset("RightArm.RightArm", 0, 0);
        this.setTextureOffset("RightArm.RightShoulderBlade", 74, 0);
        this.setTextureOffset("Head.LeftHeadSpike", 0, 60);
        this.setTextureOffset("Head.Lip", 0, 71);
        this.setTextureOffset("Head.Snout", 0, 50);
        this.setTextureOffset("Head.MainHead", 0, 80);
        this.setTextureOffset("Head.LeftTooth", 12, 61);
        this.setTextureOffset("Head.RightTooth", 12, 61);
        this.setTextureOffset("Head.RightHeadSpike", 0, 60);
        (this.Tail = new ModelRenderer(this, 87, 50)).addBox(-2.0f, -2.0f, -1.0f, 4, 4, 14);
        this.Tail.setRotationPoint(1.0f, 9.0f, 10.0f);
        this.Tail.setTextureSize(128, 128);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0f, 0.0f, 0.0f);
        (this.LeftSpike = new ModelRenderer(this, 94, 0)).addBox(-1.0f, -4.0f, -4.0f, 1, 7, 13);
        this.LeftSpike.setRotationPoint(-1.0f, 0.0f, 3.0f);
        this.LeftSpike.setTextureSize(128, 128);
        this.LeftSpike.mirror = true;
        this.setRotation(this.LeftSpike, -0.4014257f, 0.0f, 0.0f);
        (this.RightSpike = new ModelRenderer(this, 94, 0)).addBox(0.0f, -4.0f, -4.0f, 1, 7, 13);
        this.RightSpike.setRotationPoint(3.0f, 0.0f, 3.0f);
        this.RightSpike.setTextureSize(128, 128);
        this.RightSpike.mirror = true;
        this.setRotation(this.RightSpike, -0.4014257f, 0.0f, 0.0f);
        (this.Torso = new ModelRenderer(this, 61, 22)).addBox(-5.0f, -3.0f, -6.0f, 12, 8, 19);
        this.Torso.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.Torso.setTextureSize(128, 128);
        this.Torso.mirror = true;
        this.setRotation(this.Torso, -0.4014257f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer(this, "RightLeg")).setRotationPoint(7.0f, 9.0f, 9.0f);
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        this.RightLeg.mirror = true;
        this.RightLeg.addBox("RightLeg", -2.0f, -1.0f, -2.0f, 4, 16, 4);
        this.RightLeg.addBox("Rightblade", 0.0f, -8.0f, -1.0f, 1, 8, 2);
        (this.LeftLeg = new ModelRenderer(this, "LeftLeg")).setRotationPoint(-6.0f, 8.0f, 9.0f);
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        this.LeftLeg.mirror = true;
        this.LeftLeg.addBox("LeftLeg", -2.0f, -1.0f, -2.0f, 4, 16, 4);
        this.LeftLeg.addBox("LegBlade", 0.0f, -7.0f, -1.0f, 1, 9, 2);
        (this.LeftArm = new ModelRenderer(this, "LeftArm")).setRotationPoint(-7.0f, 4.0f, -3.0f);
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox("LeftShoulder", -2.0f, -2.0f, -2.0f, 4, 5, 5);
        this.LeftArm.addBox("LeftArm", -2.0f, 1.0f, -1.0f, 4, 19, 4);
        this.LeftArm.addBox("LeftShoulderBlade", -1.0f, -8.0f, -1.0f, 1, 9, 3);
        (this.RightArm = new ModelRenderer(this, "RightArm")).setRotationPoint(9.0f, 4.0f, -3.0f);
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        this.RightArm.mirror = true;
        this.RightArm.addBox("RightShoulder", -2.0f, -2.0f, -2.0f, 4, 5, 5);
        this.RightArm.addBox("RightArm", -2.0f, 1.0f, -1.0f, 4, 19, 4);
        this.RightArm.addBox("RightShoulderBlade", 0.0f, -8.0f, -1.0f, 1, 9, 3);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(1.0f, 3.0f, -9.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("LeftHeadSpike", -2.0f, -7.0f, -2.0f, 1, 4, 4);
        this.Head.addBox("Lip", -3.0f, 3.0f, -9.0f, 6, 1, 6);
        this.Head.addBox("Snout", -3.0f, -1.0f, -8.0f, 6, 2, 5);
        this.Head.addBox("MainHead", -4.0f, -3.0f, -3.0f, 8, 7, 8);
        this.Head.addBox("LeftTooth", -3.0f, 2.0f, -9.0f, 1, 1, 1);
        this.Head.addBox("RightTooth", 2.0f, 2.0f, -9.0f, 1, 1, 1);
        this.Head.addBox("RightHeadSpike", 1.0f, -7.0f, -2.0f, 1, 4, 4);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Tail.render(f5);
        this.LeftSpike.render(f5);
        this.RightSpike.render(f5);
        this.Torso.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
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
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
