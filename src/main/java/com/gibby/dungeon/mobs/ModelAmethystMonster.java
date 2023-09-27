

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAmethystMonster extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body2;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer leftarm2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm3;
    ModelRenderer rightarm3;

    public ModelAmethystMonster() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.head = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -7.0f, -21.0f, 6, 6, 16);
        this.head.setRotationPoint(-3.0f, -2.0f, -5.0f);
        this.head.setTextureSize(128, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.7853982f);
        (this.body = new ModelRenderer(this, 16, 24)).addBox(-6.0f, 0.0f, -8.0f, 12, 9, 8);
        this.body.setRotationPoint(0.0f, -5.0f, -1.0f);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.6981317f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer(this, 40, 80)).addBox(-2.0f, 4.0f, 17.0f, 1, 16, 2);
        this.rightarm.setRotationPoint(-7.0f, 1.0f, -1.0f);
        this.rightarm.setTextureSize(128, 128);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, -1.570796f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer(this, 40, 80)).addBox(1.0f, 4.0f, 17.0f, 1, 16, 2);
        this.leftarm.setRotationPoint(7.0f, 1.0f, -1.0f);
        this.leftarm.setTextureSize(128, 128);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, -1.570796f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer(this, 0, 27)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.rightleg.setRotationPoint(-3.0f, 12.0f, 6.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer(this, 0, 27)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leftleg.setRotationPoint(3.0f, 12.0f, 6.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer(this, 60, 23)).addBox(-7.0f, 0.0f, -7.0f, 14, 13, 9);
        this.body2.setRotationPoint(0.0f, 2.0f, 3.0f);
        this.body2.setTextureSize(128, 128);
        this.body2.mirror = true;
        this.setRotation(this.body, 0.5235988f, 0.0f, 0.0f);
        (this.head2 = new ModelRenderer(this, 50, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.head2.setRotationPoint(0.0f, -1.0f, -6.0f);
        this.head2.setTextureSize(128, 128);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0f, 0.0f, 0.0f);
        (this.head3 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -7.0f, -21.0f, 6, 6, 17);
        this.head3.setRotationPoint(0.0f, -1.0f, -6.0f);
        this.head3.setTextureSize(128, 128);
        this.head3.mirror = true;
        this.setRotation(this.head3, 0.0f, 0.0f, 0.5f);
        (this.leftarm2 = new ModelRenderer(this, 40, 45)).addBox(-1.0f, -2.0f, -2.0f, 4, 8, 4);
        this.leftarm2.setRotationPoint(7.0f, 1.0f, -1.0f);
        this.leftarm2.setTextureSize(128, 128);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm, 0.5235988f, 0.0f, 0.0f);
        (this.rightarm2 = new ModelRenderer(this, 40, 45)).addBox(-3.0f, -2.0f, -2.0f, 4, 8, 4);
        this.rightarm2.setRotationPoint(-7.0f, 1.0f, -1.0f);
        this.rightarm2.setTextureSize(128, 128);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm, 0.5235988f, 0.0f, 0.0f);
        (this.leftarm3 = new ModelRenderer(this, 40, 60)).addBox(1.0f, 2.0f, 3.0f, 1, 16, 3);
        this.leftarm3.setRotationPoint(7.0f, 1.0f, -1.0f);
        this.leftarm3.setTextureSize(128, 128);
        this.leftarm3.mirror = true;
        this.setRotation(this.leftarm, 50.0f, 0.0f, 0.0f);
        (this.rightarm3 = new ModelRenderer(this, 40, 60)).addBox(-2.0f, 2.0f, 3.0f, 1, 16, 3);
        this.rightarm3.setRotationPoint(-7.0f, 1.0f, -1.0f);
        this.rightarm3.setTextureSize(128, 128);
        this.rightarm3.mirror = true;
        this.setRotation(this.rightarm, 50.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.body2.render(f5);
        this.head2.render(f5);
        this.head3.render(f5);
        this.leftarm2.render(f5);
        this.rightarm2.render(f5);
        this.leftarm3.render(f5);
        this.rightarm3.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f - 90.0f;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f - 90.0f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
        this.rightarm.rotateAngleY = 0.0f;
        this.leftarm.rotateAngleY = 0.0f;
        this.rightarm2.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftarm2.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightarm2.rotateAngleZ = 0.0f;
        this.leftarm2.rotateAngleZ = 0.0f;
        this.rightarm2.rotateAngleY = 0.0f;
        this.leftarm2.rotateAngleY = 0.0f;
        this.rightarm3.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f + 30.5f;
        this.leftarm3.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f + 30.5f;
        this.rightarm3.rotateAngleZ = 0.0f;
        this.leftarm3.rotateAngleZ = 0.0f;
        this.rightarm3.rotateAngleY = 0.0f;
        this.leftarm3.rotateAngleY = 0.0f;
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
