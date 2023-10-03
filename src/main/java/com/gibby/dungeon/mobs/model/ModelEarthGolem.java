

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEarthGolem extends ModelBase
{
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer leftLeg;
    ModelRenderer rightLeg;
    ModelRenderer Head;
    ModelRenderer leftArm;
    ModelRenderer rightArm;
    ModelRenderer Spine1;
    ModelRenderer Spine2;

    public ModelEarthGolem() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Head.Head", 26, 0);
        this.setTextureOffset("Head.Spine", 1, 19);
        this.setTextureOffset("leftArm.arm", 1, 19);
        this.setTextureOffset("leftArm.arm", 0, 0);
        this.setTextureOffset("leftArm.arm", 0, 0);
        this.setTextureOffset("rightArm.arm", 1, 19);
        this.setTextureOffset("rightArm.arm", 0, 0);
        this.setTextureOffset("rightArm.arm", 0, 0);
        (this.Body1 = new ModelRenderer(this, 0, 0)).addBox(-2.0f, 9.0f, 1.0f, 4, 8, 4);
        this.Body1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body1.setTextureSize(64, 32);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, 0.1858931f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, 0.0f, -2.0f, 6, 10, 4);
        this.Body2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body2.setTextureSize(64, 32);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.4833219f, 0.0f, 0.0f);
        (this.leftLeg = new ModelRenderer(this, 0, 0)).addBox(0.0f, -4.0f, -2.0f, 2, 13, 4);
        this.leftLeg.setRotationPoint(2.0f, 15.0f, 6.0f);
        this.leftLeg.setTextureSize(64, 32);
        this.leftLeg.mirror = true;
        this.setRotation(this.leftLeg, 0.0f, 0.0f, 0.0f);
        (this.rightLeg = new ModelRenderer(this, 0, 0)).addBox(-2.0f, -4.0f, -2.0f, 2, 13, 4);
        this.rightLeg.setRotationPoint(-2.0f, 15.0f, 6.0f);
        this.rightLeg.setTextureSize(64, 32);
        this.rightLeg.mirror = true;
        this.setRotation(this.rightLeg, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, 2.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -3.0f, -3.0f, -6.0f, 6, 6, 6);
        this.Head.addBox("Spine", -0.5f, -5.0f, -4.0f, 1, 2, 3);
        (this.leftArm = new ModelRenderer(this, "leftArm")).setRotationPoint(-3.0f, 2.0f, 0.0f);
        this.setRotation(this.leftArm, 0.0f, 0.0f, 0.0f);
        this.leftArm.mirror = true;
        this.leftArm.addBox("arm", -5.0f, 7.0f, -7.0f, 1, 4, 8);
        this.leftArm.addBox("arm", -6.0f, 0.0f, -1.0f, 3, 10, 3);
        this.leftArm.addBox("arm", -7.0f, -2.0f, 0.0f, 7, 3, 3);
        (this.rightArm = new ModelRenderer(this, "rightArm")).setRotationPoint(3.0f, 2.0f, 0.0f);
        this.setRotation(this.rightArm, 0.0f, 0.0f, 0.0f);
        this.rightArm.mirror = true;
        this.rightArm.addBox("arm", 4.0f, 7.0f, -7.0f, 1, 4, 8);
        this.rightArm.addBox("arm", 3.0f, 0.0f, -1.0f, 3, 10, 3);
        this.rightArm.addBox("arm", 0.0f, -2.0f, 0.0f, 7, 3, 3);
        (this.Spine1 = new ModelRenderer(this, 1, 19)).addBox(0.0f, 0.0f, 1.0f, 1, 4, 2);
        this.Spine1.setRotationPoint(-0.5f, 9.0f, 5.0f);
        this.Spine1.setTextureSize(64, 32);
        this.Spine1.mirror = true;
        this.setRotation(this.Spine1, 0.1858931f, 0.0f, 0.0f);
        (this.Spine2 = new ModelRenderer(this, 1, 19)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 2);
        this.Spine2.setRotationPoint(-0.5f, 2.0f, 3.0f);
        this.Spine2.setTextureSize(64, 32);
        this.Spine2.mirror = true;
        this.setRotation(this.Spine2, 0.5948578f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.leftLeg.render(f5);
        this.rightLeg.render(f5);
        this.Head.render(f5);
        this.leftArm.render(f5);
        this.rightArm.render(f5);
        this.Spine1.render(f5);
        this.Spine2.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.leftLeg.rotateAngleX = -1.5f * this.func_78172_a(par1, 13.0f) * par2;
        this.rightLeg.rotateAngleX = 1.5f * this.func_78172_a(par1, 13.0f) * par2;
        this.leftLeg.rotateAngleY = 0.0f;
        this.rightLeg.rotateAngleY = 0.0f;
        this.rightArm.rotateAngleX = MathHelper.cos(par1 * 0.3662f + 3.1415927f) * 2.0f * par2;
        this.leftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.rightArm.rotateAngleZ = 0.0f;
        this.leftArm.rotateAngleZ = 0.0f;
    }

    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
