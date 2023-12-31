package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMidnightMagician extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer ShoulderPads;
    ModelRenderer ShoulderPad1;
    ModelRenderer ShoulderPad2;
    ModelRenderer ShoulderSpike1;
    ModelRenderer ShoulderSpike2;
    ModelRenderer ShoulderSpike3;
    ModelRenderer ShoulderSpike4;
    ModelRenderer ShoulderSpike5;
    ModelRenderer ShoulderSpike6;
    ModelRenderer ShoulderSpike7;
    ModelRenderer ShoulderSpike8;
    ModelRenderer Cape1;
    ModelRenderer Cape2;
    ModelRenderer Cape3;
    ModelRenderer Cape4;
    ModelRenderer Cape5;
    ModelRenderer Cape6;
    ModelRenderer Cape7;
    ModelRenderer Cape8;
    ModelRenderer Cape9;
    ModelRenderer Cape10;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    ModelRenderer Spike4;
    ModelRenderer Spike5;
    ModelRenderer Spike6;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Head;

    public ModelMidnightMagician() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("LeftArm.Arm1", 25, 24);
        this.setTextureOffset("LeftArm.Hand1", 36, 30);
        this.setTextureOffset("LeftArm.Spike6", 0, 43);
        this.setTextureOffset("LeftArm.Hand2", 0, 0);
        this.setTextureOffset("LeftArm.Hand3", 36, 30);
        this.setTextureOffset("LeftArm.Spike7", 0, 50);
        this.setTextureOffset("LeftArm.Spike8", 0, 50);
        this.setTextureOffset("LeftArm.Spike9", 0, 43);
        this.setTextureOffset("LeftArm.Staff1", 50, 29);
        this.setTextureOffset("LeftArm.Hand4", 36, 30);
        this.setTextureOffset("LeftArm.Hand5", 0, 9);
        this.setTextureOffset("LeftArm.Hand6", 0, 9);
        this.setTextureOffset("LeftArm.Hand7", 0, 9);
        this.setTextureOffset("LeftArm.Hand8", 0, 0);
        this.setTextureOffset("RightArm.Arm2", 25, 24);
        this.setTextureOffset("RightArm.Hand9", 36, 30);
        this.setTextureOffset("RightArm.Spike10", 0, 43);
        this.setTextureOffset("RightArm.Hand10", 36, 30);
        this.setTextureOffset("RightArm.Hand11", 36, 30);
        this.setTextureOffset("RightArm.Spike11", 0, 50);
        this.setTextureOffset("RightArm.Spike12", 0, 50);
        this.setTextureOffset("RightArm.Spike13", 0, 43);
        this.setTextureOffset("Head.Head1", 0, 35);
        this.setTextureOffset("Head.Head2", 0, 35);
        this.setTextureOffset("Head.Head3", 0, 24);
        this.setTextureOffset("Head.Head4", 0, 35);
        this.setTextureOffset("Head.Head5", 0, 35);
        this.setTextureOffset("Head.Head6", 0, 35);
        (this.Body = new ModelRenderer(this, 94, 0)).addBox(-4.0f, 0.0f, -4.0f, 8, 15, 8);
        this.Body.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f);
        (this.ShoulderPads = new ModelRenderer(this, 40, 7)).addBox(-9.0f, 0.0f, -3.0f, 18, 1, 6);
        this.ShoulderPads.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.ShoulderPads.setTextureSize(128, 64);
        this.ShoulderPads.mirror = true;
        this.setRotation(this.ShoulderPads, 0.0f, 0.0f);
        (this.ShoulderPad1 = new ModelRenderer(this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.ShoulderPad1.setRotationPoint(4.0f, -8.0f, -2.0f);
        this.ShoulderPad1.setTextureSize(128, 64);
        this.ShoulderPad1.mirror = true;
        this.setRotation(this.ShoulderPad1, 0.0f, 0.0f);
        (this.ShoulderPad2 = new ModelRenderer(this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.ShoulderPad2.setRotationPoint(-8.0f, -8.0f, -2.0f);
        this.ShoulderPad2.setTextureSize(128, 64);
        this.ShoulderPad2.mirror = true;
        this.setRotation(this.ShoulderPad2, 0.0f, 0.0f);
        (this.ShoulderSpike1 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -3.0f, 0.0f, 1, 4, 1);
        this.ShoulderSpike1.setRotationPoint(-5.0f, -9.0f, 2.0f);
        this.ShoulderSpike1.setTextureSize(128, 64);
        this.ShoulderSpike1.mirror = true;
        this.setRotation(this.ShoulderSpike1, 0.0f, -0.5235988f);
        (this.ShoulderSpike2 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -5.0f, 4.0f, 1, 5, 1);
        this.ShoulderSpike2.setRotationPoint(8.0f, -9.0f, -3.0f);
        this.ShoulderSpike2.setTextureSize(128, 64);
        this.ShoulderSpike2.mirror = true;
        this.setRotation(this.ShoulderSpike2, 0.0f, 0.4833219f);
        (this.ShoulderSpike3 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -4.0f, 0.0f, 1, 5, 1);
        this.ShoulderSpike3.setRotationPoint(-9.0f, -9.0f, 1.0f);
        this.ShoulderSpike3.setTextureSize(128, 64);
        this.ShoulderSpike3.mirror = true;
        this.setRotation(this.ShoulderSpike3, 0.0f, -0.4833219f);
        (this.ShoulderSpike4 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -3.0f, 0.0f, 1, 4, 1);
        this.ShoulderSpike4.setRotationPoint(4.0f, -9.0f, 2.0f);
        this.ShoulderSpike4.setTextureSize(128, 64);
        this.ShoulderSpike4.mirror = true;
        this.setRotation(this.ShoulderSpike4, 0.0f, 0.5061455f);
        (this.ShoulderSpike5 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -5.0f, 1.0f, 1, 5, 1);
        this.ShoulderSpike5.setRotationPoint(8.0f, -9.0f, -3.0f);
        this.ShoulderSpike5.setTextureSize(128, 64);
        this.ShoulderSpike5.mirror = true;
        this.setRotation(this.ShoulderSpike5, 0.0f, 0.6108652f);
        (this.ShoulderSpike6 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -4.0f, 0.0f, 1, 5, 1);
        this.ShoulderSpike6.setRotationPoint(-9.0f, -9.0f, -2.0f);
        this.ShoulderSpike6.setTextureSize(128, 64);
        this.ShoulderSpike6.mirror = true;
        this.setRotation(this.ShoulderSpike6, 0.0f, -0.6108652f);
        (this.ShoulderSpike7 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -3.0f, 0.0f, 1, 4, 1);
        this.ShoulderSpike7.setRotationPoint(4.0f, -9.0f, -2.9f);
        this.ShoulderSpike7.setTextureSize(128, 64);
        this.ShoulderSpike7.mirror = true;
        this.setRotation(this.ShoulderSpike7, 0.0f, 0.6108652f);
        (this.ShoulderSpike8 = new ModelRenderer(this, 0, 43)).addBox(0.0f, -2.0f, 0.0f, 1, 4, 1);
        this.ShoulderSpike8.setRotationPoint(-5.0f, -9.0f, -2.9f);
        this.ShoulderSpike8.setTextureSize(128, 64);
        this.ShoulderSpike8.mirror = true;
        this.setRotation(this.ShoulderSpike8, 0.0f, -0.6108652f);
        (this.Cape1 = new ModelRenderer(this, 0, 54)).addBox(-3.0f, 19.0f, -6.0f, 1, 2, 1);
        this.Cape1.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape1.setTextureSize(128, 64);
        this.Cape1.mirror = true;
        this.setRotation(this.Cape1, 0.3717861f, 0.0f);
        (this.Cape2 = new ModelRenderer(this, 5, 50)).addBox(-8.0f, 11.0f, -2.0f, 16, 2, 1);
        this.Cape2.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape2.setTextureSize(128, 64);
        this.Cape2.mirror = true;
        this.setRotation(this.Cape2, 0.3717861f, 0.0f);
        (this.Cape3 = new ModelRenderer(this, 0, 54)).addBox(6.0f, 15.0f, -4.0f, 1, 1, 1);
        this.Cape3.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape3.setTextureSize(128, 64);
        this.Cape3.mirror = true;
        this.setRotation(this.Cape3, 0.3717861f, 0.0f);
        (this.Cape4 = new ModelRenderer(this, 0, 59)).addBox(-5.0f, 15.0f, -4.0f, 8, 2, 1);
        this.Cape4.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape4.setTextureSize(128, 64);
        this.Cape4.mirror = true;
        this.setRotation(this.Cape4, 0.3717861f, 0.0f);
        (this.Cape5 = new ModelRenderer(this, 0, 54)).addBox(1.0f, 17.0f, -5.0f, 1, 1, 1);
        this.Cape5.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape5.setTextureSize(128, 64);
        this.Cape5.mirror = true;
        this.setRotation(this.Cape5, 0.3717861f, 0.0f);
        (this.Cape6 = new ModelRenderer(this, 0, 59)).addBox(-4.0f, 17.0f, -5.0f, 3, 2, 1);
        this.Cape6.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape6.setTextureSize(128, 64);
        this.Cape6.mirror = true;
        this.setRotation(this.Cape6, 0.3717861f, 0.0f);
        (this.Cape7 = new ModelRenderer(this, 5, 50)).addBox(-6.0f, 13.0f, -3.0f, 10, 2, 1);
        this.Cape7.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape7.setTextureSize(128, 64);
        this.Cape7.mirror = true;
        this.setRotation(this.Cape7, 0.3717861f, 0.0f);
        (this.Cape8 = new ModelRenderer(this, 0, 59)).addBox(5.0f, 13.0f, -3.0f, 3, 2, 1);
        this.Cape8.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape8.setTextureSize(128, 64);
        this.Cape8.mirror = true;
        this.setRotation(this.Cape8, 0.3717861f, 0.0f);
        (this.Cape9 = new ModelRenderer(this, 42, 16)).addBox(-8.0f, -1.0f, 0.0f, 16, 10, 1);
        this.Cape9.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape9.setTextureSize(128, 64);
        this.Cape9.mirror = true;
        this.setRotation(this.Cape9, 0.3717861f, 0.0f);
        (this.Cape10 = new ModelRenderer(this, 5, 50)).addBox(-8.0f, 9.0f, -1.0f, 16, 2, 1);
        this.Cape10.setRotationPoint(0.0f, -8.0f, 3.0f);
        this.Cape10.setTextureSize(128, 64);
        this.Cape10.mirror = true;
        this.setRotation(this.Cape10, 0.3717861f, 0.0f);
        (this.Spike1 = new ModelRenderer(this, 5, 43)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.Spike1.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Spike1.setTextureSize(128, 64);
        this.Spike1.mirror = true;
        this.setRotation(this.Spike1, 0.0f, 0.0f);
        (this.Spike2 = new ModelRenderer(this, 0, 50)).addBox(1.0f, 3.0f, 0.0f, 1, 1, 1);
        this.Spike2.setRotationPoint(2.0f, 7.0f, 0.0f);
        this.Spike2.setTextureSize(128, 64);
        this.Spike2.mirror = true;
        this.setRotation(this.Spike2, 0.0f, 0.0f);
        (this.Spike3 = new ModelRenderer(this, 5, 43)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike3.setRotationPoint(2.0f, 7.0f, 0.0f);
        this.Spike3.setTextureSize(128, 64);
        this.Spike3.mirror = true;
        this.setRotation(this.Spike3, 0.0f, 0.0f);
        (this.Spike4 = new ModelRenderer(this, 5, 43)).addBox(-5.0f, 0.0f, 1.0f, 1, 5, 1);
        this.Spike4.setRotationPoint(2.0f, 7.0f, 0.0f);
        this.Spike4.setTextureSize(128, 64);
        this.Spike4.mirror = true;
        this.setRotation(this.Spike4, 0.0f, 0.0f);
        (this.Spike5 = new ModelRenderer(this, 0, 50)).addBox(-6.0f, 4.0f, 1.0f, 1, 1, 1);
        this.Spike5.setRotationPoint(2.0f, 7.0f, 0.0f);
        this.Spike5.setTextureSize(128, 64);
        this.Spike5.mirror = true;
        this.setRotation(this.Spike5, 0.0f, 0.0f);
        (this.Spike6 = new ModelRenderer(this, 0, 50)).addBox(-2.0f, 4.0f, -2.0f, 1, 1, 1);
        this.Spike6.setRotationPoint(2.0f, 7.0f, 0.0f);
        this.Spike6.setTextureSize(128, 64);
        this.Spike6.mirror = true;
        this.setRotation(this.Spike6, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer(this, "LeftArm")).setRotationPoint(-4.0f, -7.0f, 0.0f);
        this.setRotation(this.LeftArm, 0.0f, 0.0f);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox("Arm1", -3.0f, -1.5f, -1.0f, 2, 12, 2);
        this.LeftArm.addBox("Hand1", -3.0f, 12.0f, -2.0f, 1, 1, 2);
        this.LeftArm.addBox("Spike6", -5.0f, 6.0f, 0.0f, 1, 3, 1);
        this.LeftArm.addBox("Hand2", -3.0f, 10.0f, -20.0f, 1, 3, 1);
        this.LeftArm.addBox("Hand3", -2.0f, 10.0f, -2.0f, 1, 2, 2);
        this.LeftArm.addBox("Spike7", -4.0f, 6.0f, 0.0f, 1, 1, 1);
        this.LeftArm.addBox("Spike8", -4.0f, 3.0f, -1.0f, 1, 1, 1);
        this.LeftArm.addBox("Spike9", -5.0f, 1.0f, -1.0f, 1, 3, 1);
        this.LeftArm.addBox("Staff1", -3.0f, 11.0f, -16.0f, 1, 1, 18);
        this.LeftArm.addBox("Hand4", -4.0f, 10.0f, -2.0f, 1, 3, 2);
        this.LeftArm.addBox("Hand5", -5.0f, 10.0f, -22.0f, 3, 3, 1);
        this.LeftArm.addBox("Hand6", -4.0f, 10.0f, -18.0f, 3, 3, 2);
        this.LeftArm.addBox("Hand7", -5.0f, 10.0f, -21.0f, 1, 3, 4);
        this.LeftArm.addBox("Hand8", -2.0f, 10.0f, -22.0f, 1, 3, 3);
        (this.RightArm = new ModelRenderer(this, "RightArm")).setRotationPoint(4.0f, -7.0f, 0.0f);
        this.setRotation(this.RightArm, 0.0f, 0.0f);
        this.RightArm.mirror = true;
        this.RightArm.addBox("Arm2", 1.0f, -1.5f, -1.0f, 2, 12, 2);
        this.RightArm.addBox("Hand9", 2.0f, 12.0f, -2.0f, 1, 1, 2);
        this.RightArm.addBox("Spike10", 4.0f, 6.0f, 0.0f, 1, 3, 1);
        this.RightArm.addBox("Hand10", 3.0f, 10.0f, -2.0f, 1, 3, 2);
        this.RightArm.addBox("Hand11", 1.0f, 10.0f, -2.0f, 1, 2, 2);
        this.RightArm.addBox("Spike11", 3.0f, 6.0f, 0.0f, 1, 1, 1);
        this.RightArm.addBox("Spike12", 3.0f, 3.0f, -1.0f, 1, 1, 1);
        this.RightArm.addBox("Spike13", 4.0f, 1.0f, -1.0f, 1, 3, 1);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -9.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head1", -0.5f, -14.0f, -0.5f, 1, 2, 1);
        this.Head.addBox("Head2", -1.0f, -12.0f, -1.0f, 2, 2, 2);
        this.Head.addBox("Head3", -3.0f, -4.0f, -3.0f, 6, 4, 6);
        this.Head.addBox("Head4", -2.5f, -6.0f, -2.5f, 5, 2, 5);
        this.Head.addBox("Head5", -1.5f, -10.0f, -1.5f, 3, 2, 3);
        this.Head.addBox("Head6", -2.0f, -8.0f, -2.0f, 4, 2, 4);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.ShoulderPads.render(f5);
        this.ShoulderPad1.render(f5);
        this.ShoulderPad2.render(f5);
        this.ShoulderSpike1.render(f5);
        this.ShoulderSpike2.render(f5);
        this.ShoulderSpike3.render(f5);
        this.ShoulderSpike4.render(f5);
        this.ShoulderSpike5.render(f5);
        this.ShoulderSpike6.render(f5);
        this.ShoulderSpike7.render(f5);
        this.ShoulderSpike8.render(f5);
        this.Cape1.render(f5);
        this.Cape2.render(f5);
        this.Cape3.render(f5);
        this.Cape4.render(f5);
        this.Cape5.render(f5);
        this.Cape6.render(f5);
        this.Cape7.render(f5);
        this.Cape8.render(f5);
        this.Cape9.render(f5);
        this.Cape10.render(f5);
        this.Spike1.render(f5);
        this.Spike2.render(f5);
        this.Spike3.render(f5);
        this.Spike4.render(f5);
        this.Spike5.render(f5);
        this.Spike6.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.Head.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = (float) 0.0;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Head.rotateAngleY = par4 / 57.295776f;
        this.Head.rotateAngleX = par5 / 57.295776f;
        this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.3662f + 3.1415927f) * 2.0f * par2;
        this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.RightArm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
    }

    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
