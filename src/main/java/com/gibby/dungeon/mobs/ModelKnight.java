

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelKnight extends ModelBase
{
    ModelRenderer lowerbody;
    ModelRenderer shoulderpad;
    ModelRenderer shoulderpad2;
    ModelRenderer Shield;
    ModelRenderer Shield2;
    ModelRenderer Sword4;
    ModelRenderer Sword1;
    ModelRenderer Sword2;
    ModelRenderer Sword3;
    ModelRenderer horn;
    ModelRenderer righthorn;
    ModelRenderer lefthorn;
    ModelRenderer tophorn;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    
    public ModelKnight() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.lowerbody = new ModelRenderer((ModelBase)this, 32, 5)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 4);
        this.lowerbody.setRotationPoint(-4.0f, 9.0f, -2.0f);
        this.lowerbody.setTextureSize(128, 128);
        this.lowerbody.mirror = true;
        this.setRotation(this.lowerbody, 0.0f, 0.0f, 0.0f);
        (this.shoulderpad = new ModelRenderer((ModelBase)this, 0, 91)).addBox(0.0f, 0.0f, 0.0f, 6, 9, 6);
        this.shoulderpad.setRotationPoint(8.0f, -7.0f, -3.0f);
        this.shoulderpad.setTextureSize(128, 128);
        this.shoulderpad.mirror = true;
        this.setRotation(this.shoulderpad, 0.0f, 0.0f, 0.7853982f);
        (this.shoulderpad2 = new ModelRenderer((ModelBase)this, 0, 91)).addBox(0.0f, 0.0f, 0.0f, 6, 9, 6);
        this.shoulderpad2.setRotationPoint(-13.0f, -3.0f, -3.0f);
        this.shoulderpad2.setTextureSize(128, 128);
        this.shoulderpad2.mirror = true;
        this.setRotation(this.shoulderpad2, 0.0f, 0.0f, -0.7853982f);
        (this.Shield = new ModelRenderer((ModelBase)this, 0, 55)).addBox(-5.0f, -2.0f, -12.0f, 12, 18, 2);
        this.Shield.setRotationPoint(7.0f, 0.0f, 0.0f);
        this.Shield.setTextureSize(128, 128);
        this.Shield.mirror = true;
        this.setRotation(this.Shield, 0.0f, 0.0f, 0.0f);
        (this.Shield2 = new ModelRenderer((ModelBase)this, 0, 76)).addBox(-4.0f, 0.0f, -13.0f, 8, 12, 1);
        this.Shield2.setRotationPoint(8.0f, 0.0f, 0.0f);
        this.Shield2.setTextureSize(128, 128);
        this.Shield2.mirror = true;
        this.setRotation(this.Shield2, 0.0f, 0.0f, 0.0f);
        (this.Sword4 = new ModelRenderer((ModelBase)this, 92, 0)).addBox(-1.0f, 10.0f, -31.0f, 1, 2, 15);
        this.Sword4.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.Sword4.setTextureSize(128, 128);
        this.Sword4.mirror = true;
        this.setRotation(this.Sword4, 0.0f, 0.0f, 0.0f);
        (this.Sword1 = new ModelRenderer((ModelBase)this, 57, 0)).addBox(-2.0f, 10.0f, -14.0f, 2, 2, 15);
        this.Sword1.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.Sword1.setTextureSize(128, 128);
        this.Sword1.mirror = true;
        this.setRotation(this.Sword1, 0.0f, 0.0f, 0.0f);
        (this.Sword2 = new ModelRenderer((ModelBase)this, 92, 0)).addBox(-1.0f, 9.0f, -21.0f, 1, 4, 15);
        this.Sword2.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.Sword2.setTextureSize(128, 128);
        this.Sword2.mirror = true;
        this.setRotation(this.Sword2, 0.0f, 0.0f, 0.0f);
        (this.Sword3 = new ModelRenderer((ModelBase)this, 91, 0)).addBox(-1.0f, 9.0f, -26.0f, 1, 3, 15);
        this.Sword3.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.Sword3.setTextureSize(128, 128);
        this.Sword3.mirror = true;
        this.setRotation(this.Sword3, 0.0f, 0.0f, 0.0f);
        (this.horn = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-6.0f, -6.0f, -2.0f, 14, 1, 2);
        this.horn.setRotationPoint(-1.0f, -2.0f, -1.0f);
        this.horn.setTextureSize(128, 128);
        this.horn.mirror = true;
        this.setRotation(this.horn, 0.0f, 0.0f, 0.0f);
        (this.righthorn = new ModelRenderer((ModelBase)this, 0, 0)).addBox(9.0f, 2.0f, -2.0f, 5, 1, 2);
        this.righthorn.setRotationPoint(-1.0f, -2.0f, -1.0f);
        this.righthorn.setTextureSize(128, 128);
        this.righthorn.mirror = true;
        this.setRotation(this.righthorn, 0.0f, 0.0f, -0.8551081f);
        (this.lefthorn = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-13.0f, 0.0f, -2.0f, 5, 1, 2);
        this.lefthorn.setRotationPoint(-1.0f, -2.0f, -1.0f);
        this.lefthorn.setTextureSize(128, 128);
        this.lefthorn.mirror = true;
        this.setRotation(this.lefthorn, 0.0f, 0.0f, 0.7853982f);
        (this.tophorn = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, -10.0f, -2.0f, 2, 2, 6);
        this.tophorn.setRotationPoint(-1.0f, -2.0f, -1.0f);
        this.tophorn.setTextureSize(128, 128);
        this.tophorn.mirror = true;
        this.setRotation(this.tophorn, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 34)).addBox(-4.0f, -8.0f, -4.0f, 10, 10, 10);
        this.head.setRotationPoint(-1.0f, -2.0f, -1.0f);
        this.head.setTextureSize(128, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 42, 35)).addBox(-7.0f, 0.0f, -3.0f, 14, 12, 6);
        this.body.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-3.0f, -2.0f, -2.0f, 4, 14, 4);
        this.rightarm.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.rightarm.setTextureSize(128, 128);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 4, 14, 4);
        this.leftarm.setRotationPoint(8.0f, 0.0f, 0.0f);
        this.leftarm.setTextureSize(128, 128);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, -1.33843f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.rightleg.setRotationPoint(-4.0f, 12.0f, 0.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leftleg.setRotationPoint(4.0f, 12.0f, 0.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.lowerbody.render(f5);
        this.shoulderpad.render(f5);
        this.shoulderpad2.render(f5);
        this.Shield.render(f5);
        this.Shield2.render(f5);
        this.Sword4.render(f5);
        this.Sword1.render(f5);
        this.Sword2.render(f5);
        this.Sword3.render(f5);
        this.horn.render(f5);
        this.righthorn.render(f5);
        this.lefthorn.render(f5);
        this.tophorn.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.leftleg.rotateAngleX = -1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.rightleg.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.leftleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.Sword1.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.Sword1.rotateAngleZ = 0.0f;
        this.Sword2.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.Sword2.rotateAngleZ = 0.0f;
        this.Sword3.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.Sword3.rotateAngleZ = 0.0f;
        this.Sword4.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.Sword4.rotateAngleZ = 0.0f;
    }
    
    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
