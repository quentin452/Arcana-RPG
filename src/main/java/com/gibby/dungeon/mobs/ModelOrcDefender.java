

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOrcDefender extends ModelBase
{
    ModelRenderer belly;
    ModelRenderer belly2;
    ModelRenderer body;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer leftArm;
    ModelRenderer Head;
    ModelRenderer rightArm;

    public ModelOrcDefender() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("leftArm.leftArm", 54, 18);
        this.setTextureOffset("leftArm.Sword1", 40, 46);
        this.setTextureOffset("leftArm.Shield1", 83, 40);
        this.setTextureOffset("leftArm.Shield2", 83, 40);
        this.setTextureOffset("leftArm.Shape1", 0, 0);
        this.setTextureOffset("leftArm.Shape2", 0, 0);
        this.setTextureOffset("Head.head", 80, 0);
        this.setTextureOffset("Head.Jaw", 22, 0);
        this.setTextureOffset("Head.Helmet", 80, 20);
        this.setTextureOffset("rightArm.rightarm", 54, 18);
        this.setTextureOffset("rightArm.Sword3", 0, 44);
        this.setTextureOffset("rightArm.Sword1", 0, 44);
        this.setTextureOffset("rightArm.Sword2", 0, 44);
        this.setTextureOffset("rightArm.Sword4", 0, 44);
        this.setTextureOffset("rightArm.Sword5", 0, 44);
        this.setTextureOffset("rightArm.Sword6", 0, 44);
        (this.belly = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -1.0f, 8, 8, 1);
        this.belly.setRotationPoint(0.0f, 2.0f, -4.0f);
        this.belly.setTextureSize(128, 64);
        this.belly.mirror = true;
        this.setRotation(this.belly, 0.0f, 0.0f, 0.0f);
        (this.belly2 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -3.0f, 0.0f, 8, 6, 1);
        this.belly2.setRotationPoint(0.0f, 3.0f, -6.0f);
        this.belly2.setTextureSize(128, 64);
        this.belly2.mirror = true;
        this.setRotation(this.belly2, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer(this, 32, 40)).addBox(-5.0f, 0.0f, -3.0f, 10, 16, 8);
        this.body.setRotationPoint(0.0f, -8.0f, -1.0f);
        this.body.setTextureSize(128, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer(this, 0, 16)).addBox(-3.0f, 0.0f, -3.0f, 6, 16, 6);
        this.rightleg.setRotationPoint(-3.0f, 8.0f, 0.0f);
        this.rightleg.setTextureSize(128, 64);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer(this, 0, 16)).addBox(-3.0f, 0.0f, -3.0f, 6, 16, 6);
        this.leftleg.setRotationPoint(3.0f, 8.0f, 0.0f);
        this.leftleg.setTextureSize(128, 64);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.leftArm = new ModelRenderer(this, "leftArm")).setRotationPoint(6.0f, -5.0f, 0.0f);
        this.setRotation(this.leftArm, 0.0f, 0.0f, 0.0f);
        this.leftArm.mirror = true;
        this.leftArm.addBox("leftArm", -1.0f, -2.0f, -2.0f, 6, 14, 6);
        this.leftArm.addBox("Sword1", 1.0f, 9.0f, -8.0f, 2, 2, 6);
        this.leftArm.addBox("Shield1", -5.0f, -1.0f, -11.0f, 14, 20, 1);
        this.leftArm.addBox("Shield2", -6.0f, -2.0f, -10.0f, 16, 22, 2);
        this.leftArm.addBox("Shape1", 0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leftArm.addBox("Shape2", 0.0f, 0.0f, 0.0f, 1, 1, 1);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -10.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("head", -5.0f, -8.0f, -5.0f, 10, 10, 10);
        this.Head.addBox("Jaw", -6.0f, -1.0f, -6.0f, 12, 4, 11);
        this.Head.addBox("Helmet", -6.0f, -9.0f, -6.0f, 12, 8, 12);
        (this.rightArm = new ModelRenderer(this, "rightArm")).setRotationPoint(-6.0f, -4.0f, 0.0f);
        this.setRotation(this.rightArm, 0.0f, 0.0f, 0.0f);
        this.rightArm.mirror = true;
        this.rightArm.addBox("rightarm", -5.0f, -3.0f, -2.0f, 6, 14, 6);
        this.rightArm.addBox("Sword3", -3.0f, 7.0f, -33.0f, 1, 2, 2);
        this.rightArm.addBox("Sword1", -3.0f, 9.0f, -10.0f, 1, 2, 8);
        this.rightArm.addBox("Sword2", -3.0f, 8.0f, -24.0f, 1, 3, 14);
        this.rightArm.addBox("Sword4", -3.0f, 5.0f, -36.0f, 1, 1, 9);
        this.rightArm.addBox("Sword5", -3.0f, 7.0f, -31.0f, 1, 3, 14);
        this.rightArm.addBox("Sword6", -3.0f, 6.0f, -35.0f, 1, 1, 14);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.belly.render(f5);
        this.belly2.render(f5);
        this.body.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.leftArm.render(f5);
        this.Head.render(f5);
        this.rightArm.render(f5);
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
        this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightArm.rotateAngleZ = 0.0f;
        this.leftArm.rotateAngleZ = 0.0f;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
    }
}
