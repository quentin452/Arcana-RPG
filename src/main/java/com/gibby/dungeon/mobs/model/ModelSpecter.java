

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpecter extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Head;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape25;
    ModelRenderer Shape26;
    ModelRenderer Shape27;
    ModelRenderer Shape28;
    ModelRenderer Shape29;
    ModelRenderer Shape30;

    public ModelSpecter() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 7, 7);
        this.Shape1.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 7, 8);
        this.Shape2.setRotationPoint(1.0f, 8.0f, -0.5f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.2056184f);
        (this.Shape3 = new ModelRenderer(this, 0, 0)).addBox(3.0f, 0.0f, 0.0f, 6, 7, 9);
        this.Shape3.setRotationPoint(1.0f, 1.0f, -1.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.4810499f);
        (this.Shape4 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 1, 15);
        this.Shape4.setRotationPoint(4.0f, 2.0f, -4.0f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.4810499f);
        (this.Head = new ModelRenderer(this, 0, 21)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 5);
        this.Head.setRotationPoint(7.0f, -1.0f, 1.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.183621f);
        (this.Arm1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 3);
        this.Arm1.setRotationPoint(4.0f, 3.0f, -4.0f);
        this.Arm1.setTextureSize(64, 32);
        this.Arm1.mirror = true;
        this.setRotation(this.Arm1, 0.0f, 0.0f, 0.3490659f);
        (this.Arm2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 3);
        this.Arm2.setRotationPoint(4.0f, 3.0f, 8.0f);
        this.Arm2.setTextureSize(64, 32);
        this.Arm2.mirror = true;
        this.setRotation(this.Arm2, 0.0f, 0.0f, 0.3490659f);
        (this.Shape8 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Shape8.setRotationPoint(0.0f, 2.0f, 3.0f);
        this.Shape8.setTextureSize(64, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.2974289f);
        (this.Shape9 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape9.setRotationPoint(-3.0f, 2.0f, 3.0f);
        this.Shape9.setTextureSize(64, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.1858931f);
        (this.Shape10 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, 0.0f, 0.0f, 3, 1, 0);
        this.Shape10.setRotationPoint(-3.0f, 2.0f, 3.5f);
        this.Shape10.setTextureSize(64, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.059176f);
        (this.Shape11 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Shape11.setRotationPoint(-1.0f, 6.0f, 3.0f);
        this.Shape11.setTextureSize(64, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.1115358f);
        (this.Shape12 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Shape12.setRotationPoint(-3.0f, 6.0f, 3.0f);
        this.Shape12.setTextureSize(64, 32);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.1115358f);
        (this.Shape13 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 0);
        this.Shape13.setRotationPoint(-5.0f, 6.0f, 3.5f);
        this.Shape13.setTextureSize(64, 32);
        this.Shape13.mirror = true;
        this.setRotation(this.Shape13, 0.0f, 0.0f, 0.0242694f);
        (this.Shape14 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Shape14.setRotationPoint(-2.0f, 10.0f, 3.0f);
        this.Shape14.setTextureSize(64, 32);
        this.Shape14.mirror = true;
        this.setRotation(this.Shape14, 0.0f, 0.0f, -0.0280905f);
        (this.Shape15 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 0);
        this.Shape15.setRotationPoint(-4.0f, 10.25f, 3.5f);
        this.Shape15.setTextureSize(64, 32);
        this.Shape15.mirror = true;
        this.setRotation(this.Shape15, 0.0f, 0.0f, -0.1328103f);
        (this.Shape16 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Shape16.setRotationPoint(3.0f, -4.0f, 3.0f);
        this.Shape16.setTextureSize(64, 32);
        this.Shape16.mirror = true;
        this.setRotation(this.Shape16, 0.0f, 0.0f, -0.4014257f);
        (this.Shape17 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Shape17.setRotationPoint(4.0f, -3.5f, 1.0f);
        this.Shape17.setTextureSize(64, 32);
        this.Shape17.mirror = true;
        this.setRotation(this.Shape17, 0.1745329f, 0.0f, -0.3490659f);
        (this.Shape18 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Shape18.setRotationPoint(4.0f, -3.5f, 5.0f);
        this.Shape18.setTextureSize(64, 32);
        this.Shape18.mirror = true;
        this.setRotation(this.Shape18, -0.1745329f, 0.0f, -0.3490659f);
        (this.Shape19 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Shape19.setRotationPoint(5.0f, -2.0f, -0.5f);
        this.Shape19.setTextureSize(64, 32);
        this.Shape19.mirror = true;
        this.setRotation(this.Shape19, 0.2617994f, 0.0f, -0.1745329f);
        (this.Shape20 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Shape20.setRotationPoint(6.0f, 0.0f, -1.5f);
        this.Shape20.setTextureSize(64, 32);
        this.Shape20.mirror = true;
        this.setRotation(this.Shape20, 0.3839724f, 0.0f, -0.122173f);
        (this.Shape21 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Shape21.setRotationPoint(5.0f, -2.0f, 6.5f);
        this.Shape21.setTextureSize(64, 32);
        this.Shape21.mirror = true;
        this.setRotation(this.Shape21, -0.2617994f, 0.0f, -0.1745329f);
        (this.Shape22 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Shape22.setRotationPoint(6.0f, 0.0f, 7.5f);
        this.Shape22.setTextureSize(64, 32);
        this.Shape22.mirror = true;
        this.setRotation(this.Shape22, -0.3839724f, 0.0f, -0.122173f);
        (this.Shape23 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape23.setRotationPoint(0.0f, 4.5f, 0.5f);
        this.Shape23.setTextureSize(64, 32);
        this.Shape23.mirror = true;
        this.setRotation(this.Shape23, 0.0f, 0.0f, -0.4248689f);
        (this.Shape24 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape24.setRotationPoint(0.0f, 5.5f, 5.0f);
        this.Shape24.setTextureSize(64, 32);
        this.Shape24.mirror = true;
        this.setRotation(this.Shape24, 0.0f, 0.0f, -0.4248689f);
        (this.Shape25 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape25.setRotationPoint(-1.0f, 7.0f, 1.5f);
        this.Shape25.setTextureSize(64, 32);
        this.Shape25.mirror = true;
        this.setRotation(this.Shape25, 0.0f, 0.0f, -0.3876903f);
        (this.Shape26 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape26.setRotationPoint(-1.5f, 12.0f, 1.0f);
        this.Shape26.setTextureSize(64, 32);
        this.Shape26.mirror = true;
        this.setRotation(this.Shape26, 0.0f, 0.0f, -0.5121354f);
        (this.Shape27 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape27.setRotationPoint(-1.0f, 11.0f, 5.0f);
        this.Shape27.setTextureSize(64, 32);
        this.Shape27.mirror = true;
        this.setRotation(this.Shape27, 0.0f, 0.0f, -0.5121354f);
        (this.Shape28 = new ModelRenderer(this, 0, 21)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.Shape28.setRotationPoint(8.0f, -1.466667f, 2.533333f);
        this.Shape28.setTextureSize(64, 32);
        this.Shape28.mirror = true;
        this.setRotation(this.Shape28, 0.0f, 0.0f, 0.183621f);
        (this.Shape29 = new ModelRenderer(this, 0, 21)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Shape29.setRotationPoint(8.0f, -3.0f, 3.0f);
        this.Shape29.setTextureSize(64, 32);
        this.Shape29.mirror = true;
        this.setRotation(this.Shape29, 0.0f, 0.0f, 0.8156574f);
        (this.Shape30 = new ModelRenderer(this, 0, 21)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 0);
        this.Shape30.setRotationPoint(6.0f, -5.0f, 3.5f);
        this.Shape30.setTextureSize(64, 32);
        this.Shape30.mirror = true;
        this.setRotation(this.Shape30, 0.0f, 0.0f, 0.8111134f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Head.render(f5);
        this.Arm1.render(f5);
        this.Arm2.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Shape11.render(f5);
        this.Shape12.render(f5);
        this.Shape13.render(f5);
        this.Shape14.render(f5);
        this.Shape15.render(f5);
        this.Shape16.render(f5);
        this.Shape17.render(f5);
        this.Shape18.render(f5);
        this.Shape19.render(f5);
        this.Shape20.render(f5);
        this.Shape21.render(f5);
        this.Shape22.render(f5);
        this.Shape23.render(f5);
        this.Shape24.render(f5);
        this.Shape25.render(f5);
        this.Shape26.render(f5);
        this.Shape27.render(f5);
        this.Shape28.render(f5);
        this.Shape29.render(f5);
        this.Shape30.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
