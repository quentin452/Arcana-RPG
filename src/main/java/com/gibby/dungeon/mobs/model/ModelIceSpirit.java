

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelIceSpirit extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer Tail3;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer BellyArmor;
    ModelRenderer BellyArmor2;
    ModelRenderer RightWing;
    ModelRenderer LeftWing;
    ModelRenderer Head;

    public ModelIceSpirit() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("RightWing.RightWing1", 0, 25);
        this.setTextureOffset("RightWing.RightWing2", 0, 25);
        this.setTextureOffset("RightWing.RightWing3", 0, 25);
        this.setTextureOffset("RightWing.RightWing4", 0, 25);
        this.setTextureOffset("RightWing.LeftWing5", 0, 25);
        this.setTextureOffset("RightWing.LeftWing6", 0, 25);
        this.setTextureOffset("RightWing.LeftWing7", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing1", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing2", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing3", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing4", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing5", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing6", 0, 25);
        this.setTextureOffset("LeftWing.LeftWing7", 0, 25);
        this.setTextureOffset("Head.Head", 33, 0);
        this.setTextureOffset("Head.SideSpike1", 59, 0);
        this.setTextureOffset("Head.SideSpike2", 59, 0);
        this.setTextureOffset("Head.Spike3", 59, 0);
        this.setTextureOffset("Head.Spike1", 59, 0);
        this.setTextureOffset("Head.Spike2", 59, 0);
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -7.0f, -4.0f, 8, 14, 8);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer(this, 59, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.Tail3.setRotationPoint(0.0f, 9.0f, 0.0f);
        this.Tail3.setTextureSize(128, 64);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer(this, 59, 0)).addBox(-3.0f, 0.0f, -3.0f, 6, 1, 6);
        this.Tail1.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Tail1.setTextureSize(128, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer(this, 59, 0)).addBox(-2.0f, 0.0f, -2.0f, 4, 1, 4);
        this.Tail2.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Tail2.setTextureSize(128, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.BellyArmor = new ModelRenderer(this, 59, 0)).addBox(-3.0f, -5.0f, 6.0f, 6, 10, 1);
        this.BellyArmor.setRotationPoint(0.0f, 0.0f, -2.0f);
        this.BellyArmor.setTextureSize(128, 64);
        this.BellyArmor.mirror = true;
        this.setRotation(this.BellyArmor, 0.0f, 0.0f, 0.0f);
        (this.BellyArmor2 = new ModelRenderer(this, 59, 0)).addBox(-3.0f, -5.0f, -3.0f, 6, 10, 1);
        this.BellyArmor2.setRotationPoint(0.0f, 0.0f, -2.0f);
        this.BellyArmor2.setTextureSize(128, 64);
        this.BellyArmor2.mirror = true;
        this.setRotation(this.BellyArmor2, 0.0f, 0.0f, 0.0f);
        (this.RightWing = new ModelRenderer(this, "RightWing")).setRotationPoint(4.0f, -2.0f, 0.0f);
        this.setRotation(this.RightWing, 0.0f, 0.0f, 0.0f);
        this.RightWing.mirror = true;
        this.RightWing.addBox("RightWing1", 4.0f, -6.0f, 0.0f, 4, 11, 2);
        this.RightWing.addBox("RightWing2", 0.0f, -4.0f, -1.0f, 2, 11, 2);
        this.RightWing.addBox("RightWing3", 14.0f, -2.0f, -3.0f, 2, 5, 2);
        this.RightWing.addBox("RightWing4", 2.0f, -5.0f, 0.0f, 2, 11, 2);
        this.RightWing.addBox("LeftWing5", 8.0f, -5.0f, 0.0f, 2, 10, 2);
        this.RightWing.addBox("LeftWing6", 10.0f, -4.0f, -1.0f, 2, 9, 2);
        this.RightWing.addBox("LeftWing7", 12.0f, -3.0f, -2.0f, 2, 7, 2);
        (this.LeftWing = new ModelRenderer(this, "LeftWing")).setRotationPoint(-4.0f, -2.0f, 0.0f);
        this.setRotation(this.LeftWing, 0.0f, 0.0f, 0.0f);
        this.LeftWing.mirror = true;
        this.LeftWing.addBox("LeftWing1", -8.0f, -6.0f, 0.0f, 4, 11, 2);
        this.LeftWing.addBox("LeftWing2", -2.0f, -4.0f, -1.0f, 2, 11, 2);
        this.LeftWing.addBox("LeftWing3", -16.0f, -2.0f, -3.0f, 2, 5, 2);
        this.LeftWing.addBox("LeftWing4", -4.0f, -5.0f, 0.0f, 2, 11, 2);
        this.LeftWing.addBox("LeftWing5", -10.0f, -5.0f, 0.0f, 2, 10, 2);
        this.LeftWing.addBox("LeftWing6", -12.0f, -4.0f, -1.0f, 2, 9, 2);
        this.LeftWing.addBox("LeftWing7", -14.0f, -3.0f, -2.0f, 2, 7, 2);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -7.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.addBox("SideSpike1", -4.0f, -8.0f, -1.0f, 1, 5, 2);
        this.Head.addBox("SideSpike2", 3.0f, -8.0f, -1.0f, 1, 5, 2);
        this.Head.addBox("Spike3", 0.0f, -8.0f, 2.0f, 1, 2, 1);
        this.Head.addBox("Spike1", 0.0f, -8.0f, -2.0f, 1, 2, 1);
        this.Head.addBox("Spike2", -1.0f, -8.0f, 0.0f, 1, 2, 1);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Tail3.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.BellyArmor.render(f5);
        this.BellyArmor2.render(f5);
        this.RightWing.render(f5);
        this.LeftWing.render(f5);
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
        this.RightWing.rotateAngleY = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.LeftWing.rotateAngleY = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.RightWing.rotateAngleZ = 0.0f;
        this.LeftWing.rotateAngleZ = 0.0f;
    }
}
