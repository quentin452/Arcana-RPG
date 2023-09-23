

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelVoidLord extends ModelBase
{
    ModelRenderer leftpad;
    ModelRenderer rightpad;
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer Backspike1;
    ModelRenderer PadSpike2;
    ModelRenderer backspike1;
    ModelRenderer backspike2;
    ModelRenderer backspike3;
    ModelRenderer rod1;
    ModelRenderer rod2;
    ModelRenderer rod3;
    ModelRenderer PadSpike1;
    ModelRenderer BackSpike2;
    ModelRenderer BackSpike3;
    ModelRenderer BackSpike4;
    ModelRenderer Head;
    ModelRenderer Headwear;
    ModelRenderer Body;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    
    public ModelVoidLord() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.leftpad = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.leftpad.setRotationPoint(4.0f, -15.0f, -2.0f);
        this.leftpad.setTextureSize(64, 32);
        this.leftpad.mirror = true;
        this.setRotation(this.leftpad, 0.0f, 0.0f, 0.0f);
        (this.rightpad = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.rightpad.setRotationPoint(-7.0f, -15.0f, -2.0f);
        this.rightpad.setTextureSize(64, 32);
        this.rightpad.mirror = true;
        this.setRotation(this.rightpad, 0.0f, 0.0f, 0.0f);
        (this.spike1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.spike1.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike1.setTextureSize(64, 32);
        this.spike1.mirror = true;
        this.setRotation(this.spike1, -2.96706f, 0.7853982f, 0.2094395f);
        (this.spike2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.spike2.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike2.setTextureSize(64, 32);
        this.spike2.mirror = true;
        this.setRotation(this.spike2, 3.141593f, 0.7853982f, 0.0f);
        (this.spike3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.spike3.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike3.setTextureSize(64, 32);
        this.spike3.mirror = true;
        this.setRotation(this.spike3, 2.96706f, 0.7853982f, -0.1745329f);
        (this.spike4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.spike4.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.spike4.setTextureSize(64, 32);
        this.spike4.mirror = true;
        this.setRotation(this.spike4, 2.792527f, 0.7853982f, -0.3490659f);
        (this.Backspike1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -12.0f, 3.0f, 1, 19, 2);
        this.Backspike1.setRotationPoint(2.0f, -17.0f, 6.0f);
        this.Backspike1.setTextureSize(64, 32);
        this.Backspike1.mirror = true;
        this.setRotation(this.Backspike1, 0.0f, -1.570796f, 0.7853982f);
        (this.PadSpike2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.PadSpike2.setRotationPoint(-6.0f, -16.0f, -1.0f);
        this.PadSpike2.setTextureSize(64, 32);
        this.PadSpike2.mirror = true;
        this.setRotation(this.PadSpike2, 0.0f, 0.0f, -0.7853982f);
        (this.backspike1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 22, 2);
        this.backspike1.setRotationPoint(7.0f, -19.0f, 2.0f);
        this.backspike1.setTextureSize(64, 32);
        this.backspike1.mirror = true;
        this.setRotation(this.backspike1, 0.0f, 0.0f, 0.7853982f);
        (this.backspike2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.backspike2.setRotationPoint(10.0f, -21.0f, 3.0f);
        this.backspike2.setTextureSize(64, 32);
        this.backspike2.mirror = true;
        this.setRotation(this.backspike2, 0.0f, 0.0f, 0.7853982f);
        (this.backspike3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.backspike3.setRotationPoint(8.0f, -20.0f, 2.0f);
        this.backspike3.setTextureSize(64, 32);
        this.backspike3.mirror = true;
        this.setRotation(this.backspike3, 0.0f, 0.0f, 0.7853982f);
        (this.rod1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, 19.0f, -19.0f, 2, 2, 23);
        this.rod1.setRotationPoint(5.0f, -12.0f, 0.0f);
        this.rod1.setTextureSize(64, 32);
        this.rod1.mirror = true;
        this.setRotation(this.rod1, 0.0f, 0.0f, 0.0f);
        (this.rod2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -23.0f, 19.0f, 1, 4, 1);
        this.rod2.setRotationPoint(5.0f, -12.0f, 0.0f);
        this.rod2.setTextureSize(64, 32);
        this.rod2.mirror = true;
        this.setRotation(this.rod2, 1.570796f, 0.0f, 3.141593f);
        (this.rod3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -24.0f, 21.0f, 1, 5, 1);
        this.rod3.setRotationPoint(5.0f, -13.0f, 0.0f);
        this.rod3.setTextureSize(64, 32);
        this.rod3.mirror = true;
        this.setRotation(this.rod3, 1.570796f, 0.0f, 3.141593f);
        (this.PadSpike1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.PadSpike1.setRotationPoint(6.0f, -17.0f, -1.0f);
        this.PadSpike1.setTextureSize(64, 32);
        this.PadSpike1.mirror = true;
        this.setRotation(this.PadSpike1, 0.0f, 0.0f, 45.0f);
        (this.BackSpike2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -12.0f, -1.0f, 1, 18, 2);
        this.BackSpike2.setRotationPoint(-5.0f, -17.0f, 5.0f);
        this.BackSpike2.setTextureSize(64, 32);
        this.BackSpike2.mirror = true;
        this.setRotation(this.BackSpike2, 0.0f, -90.0f, 45.0f);
        (this.BackSpike3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -12.0f, 3.0f, 1, 18, 2);
        this.BackSpike3.setRotationPoint(6.0f, -17.0f, 6.0f);
        this.BackSpike3.setTextureSize(64, 32);
        this.BackSpike3.mirror = true;
        this.setRotation(this.BackSpike3, 0.0f, -90.0f, 45.0f);
        (this.BackSpike4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -12.0f, 0.0f, 1, 17, 2);
        this.BackSpike4.setRotationPoint(6.0f, -17.0f, 4.0f);
        this.BackSpike4.setTextureSize(64, 32);
        this.BackSpike4.mirror = true;
        this.setRotation(this.BackSpike4, 0.0f, -135.0f, 45.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.Head.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Headwear = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.Headwear.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.Headwear.setTextureSize(64, 32);
        this.Headwear.mirror = true;
        this.setRotation(this.Headwear, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase)this, 32, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.Body.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 56, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 24, 2);
        this.RightArm.setRotationPoint(-5.0f, -12.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 56, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 24, 2);
        this.LeftArm.setRotationPoint(5.0f, -12.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.RightLeg = new ModelRenderer((ModelBase)this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2);
        this.RightLeg.setRotationPoint(-2.0f, -2.0f, 0.0f);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0f, 0.0f, 0.0f);
        (this.LeftLeg = new ModelRenderer((ModelBase)this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2);
        this.LeftLeg.setRotationPoint(2.0f, -2.0f, 0.0f);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        this.LeftLeg.mirror = false;
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
        this.Backspike1.render(f5);
        this.PadSpike2.render(f5);
        this.backspike1.render(f5);
        this.backspike2.render(f5);
        this.backspike3.render(f5);
        this.rod1.render(f5);
        this.PadSpike1.render(f5);
        this.BackSpike2.render(f5);
        this.BackSpike3.render(f5);
        this.BackSpike4.render(f5);
        this.Head.render(f5);
        this.Headwear.render(f5);
        this.Body.render(f5);
        this.RightArm.render(f5);
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
        this.LeftLeg.rotateAngleX = -1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.RightLeg.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.LeftLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
        this.Head.rotateAngleY = f3 / 57.295776f;
        this.Head.rotateAngleX = f4 / 57.295776f;
        this.Headwear.rotateAngleY = this.Head.rotateAngleY;
        this.Headwear.rotateAngleX = this.Head.rotateAngleX;
        this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.RightArm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
        this.rod1.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.rod1.rotateAngleZ = 0.0f;
        this.rod2.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f + 180.0f;
        this.rod2.rotateAngleZ = 0.0f;
        this.rod3.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f + 180.0f;
        this.rod3.rotateAngleZ = 0.0f;
    }
    
    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
