

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEarthRupturer extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer BackNode;
    ModelRenderer RightBackLeg;
    ModelRenderer LeftBackLeg;
    ModelRenderer LeftFrontLeg;
    ModelRenderer FrontNode;
    ModelRenderer RightFrontLeg;
    ModelRenderer Head;

    public ModelEarthRupturer() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("RightLeg.RightLeg1", 0, 0);
        this.setTextureOffset("RightLeg.RightLeg2", 48, 0);
        this.setTextureOffset("LeftLeg.LeftLeg1", 0, 0);
        this.setTextureOffset("LeftLeg.LeftLeg2", 48, 0);
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer(this, "RightLeg")).setRotationPoint(4.0f, 0.0f, 0.0f);
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        this.RightLeg.mirror = true;
        this.RightLeg.addBox("RightLeg1", 0.0f, -2.0f, -2.0f, 6, 4, 4);
        this.RightLeg.addBox("RightLeg2", 6.0f, -6.0f, -2.0f, 4, 30, 4);
        (this.LeftLeg = new ModelRenderer(this, "LeftLeg")).setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        this.LeftLeg.mirror = true;
        this.LeftLeg.addBox("LeftLeg1", -6.0f, -2.0f, -2.0f, 6, 4, 4);
        this.LeftLeg.addBox("LeftLeg2", -10.0f, -6.0f, -2.0f, 4, 30, 4);
        (this.BackNode = new ModelRenderer(this, 0, 0)).addBox(-2.0f, -2.0f, 0.0f, 4, 4, 10);
        this.BackNode.setRotationPoint(0.0f, 0.0f, 4.0f);
        this.BackNode.setTextureSize(64, 64);
        this.BackNode.mirror = true;
        this.setRotation(this.BackNode, 0.0f, 0.0f, 0.0f);
        (this.RightBackLeg = new ModelRenderer(this, 48, 0)).addBox(0.0f, -6.0f, -2.0f, 4, 30, 4);
        this.RightBackLeg.setRotationPoint(2.0f, 0.0f, 12.0f);
        this.RightBackLeg.setTextureSize(64, 64);
        this.RightBackLeg.mirror = true;
        this.setRotation(this.RightBackLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftBackLeg = new ModelRenderer(this, 48, 0)).addBox(-4.0f, -6.0f, -2.0f, 4, 30, 4);
        this.LeftBackLeg.setRotationPoint(-2.0f, 0.0f, 12.0f);
        this.LeftBackLeg.setTextureSize(64, 64);
        this.LeftBackLeg.mirror = true;
        this.setRotation(this.LeftBackLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftFrontLeg = new ModelRenderer(this, 48, 0)).addBox(-4.0f, -6.0f, -2.0f, 4, 30, 4);
        this.LeftFrontLeg.setRotationPoint(-2.0f, 0.0f, -12.0f);
        this.LeftFrontLeg.setTextureSize(64, 64);
        this.LeftFrontLeg.mirror = true;
        this.setRotation(this.LeftFrontLeg, 0.0f, 0.0f, 0.0f);
        (this.FrontNode = new ModelRenderer(this, 0, 0)).addBox(-2.0f, -2.0f, -10.0f, 4, 4, 10);
        this.FrontNode.setRotationPoint(0.0f, 0.0f, -4.0f);
        this.FrontNode.setTextureSize(64, 64);
        this.FrontNode.mirror = true;
        this.setRotation(this.FrontNode, 0.0f, 0.0f, 0.0f);
        (this.RightFrontLeg = new ModelRenderer(this, 48, 0)).addBox(0.0f, -6.0f, -2.0f, 4, 30, 4);
        this.RightFrontLeg.setRotationPoint(2.0f, 0.0f, -12.0f);
        this.RightFrontLeg.setTextureSize(64, 64);
        this.RightFrontLeg.mirror = true;
        this.setRotation(this.RightFrontLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer(this, 0, 17)).addBox(-3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.Head.setTextureSize(64, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.BackNode.render(f5);
        this.RightBackLeg.render(f5);
        this.LeftBackLeg.render(f5);
        this.LeftFrontLeg.render(f5);
        this.FrontNode.render(f5);
        this.RightFrontLeg.render(f5);
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
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
        this.LeftFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.RightFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.LeftFrontLeg.rotateAngleY = 0.0f;
        this.RightFrontLeg.rotateAngleY = 0.0f;
        this.RightBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.LeftBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightBackLeg.rotateAngleY = 0.0f;
        this.LeftBackLeg.rotateAngleY = 0.0f;
    }
}
