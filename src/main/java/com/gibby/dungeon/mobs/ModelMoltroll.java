

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelMoltroll extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body;
    ModelRenderer body3;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    
    public ModelMoltroll() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.head = new ModelRenderer((ModelBase)this, 0, 50)).addBox(-5.0f, -8.0f, -5.0f, 10, 10, 10);
        this.head.setRotationPoint(0.0f, -11.0f, -20.0f);
        this.head.setTextureSize(128, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase)this, 0, 80)).addBox(-7.0f, -5.0f, -12.0f, 16, 6, 14);
        this.body2.setRotationPoint(-1.0f, -8.0f, -8.0f);
        this.body2.setTextureSize(128, 128);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.0f, 0.0f, 0.0f);
        (this.rightarm2 = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-3.0f, -2.0f, -2.0f, 4, 35, 4);
        this.rightarm2.setRotationPoint(-8.0f, -9.0f, -12.0f);
        this.rightarm2.setTextureSize(128, 128);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm2, 0.0f, 0.0f, 0.0f);
        (this.leftarm2 = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 4, 35, 4);
        this.leftarm2.setRotationPoint(8.0f, -9.0f, -12.0f);
        this.leftarm2.setTextureSize(128, 128);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm2, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.rightleg.setRotationPoint(-3.0f, 12.0f, 10.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leftleg.setRotationPoint(3.0f, 12.0f, 10.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 70, 30)).addBox(-6.0f, 0.0f, -2.0f, 12, 16, 6);
        this.body.setRotationPoint(0.0f, 0.0f, 3.0f);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.5235988f, 0.0f, 0.0f);
        (this.body3 = new ModelRenderer((ModelBase)this, 70, 0)).addBox(-7.0f, -15.0f, -2.0f, 14, 17, 6);
        this.body3.setRotationPoint(0.0f, 0.0f, 3.0f);
        this.body3.setTextureSize(128, 128);
        this.body3.mirror = true;
        this.setRotation(this.body3, 0.9424778f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-3.0f, -2.0f, -2.0f, 4, 29, 4);
        this.rightarm.setRotationPoint(-8.0f, -3.0f, 0.0f);
        this.rightarm.setTextureSize(128, 128);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 4, 29, 4);
        this.leftarm.setRotationPoint(8.0f, -3.0f, 0.0f);
        this.leftarm.setTextureSize(128, 128);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body2.render(f5);
        this.rightarm2.render(f5);
        this.leftarm2.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.body.render(f5);
        this.body3.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
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
        this.rightleg.rotateAngleY = 0.0f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.head.rotateAngleX = f4 / 57.295776f;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
        this.rightarm2.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftarm2.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightarm2.rotateAngleZ = 0.0f;
        this.leftarm2.rotateAngleZ = 0.0f;
    }
    
    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
