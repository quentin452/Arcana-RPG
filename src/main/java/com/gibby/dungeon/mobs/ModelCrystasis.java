

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrystasis extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer Tail5;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Leftarm;
    ModelRenderer Rightarm;
    ModelRenderer Head;

    public ModelCrystasis() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Leftarm.Leftarm", 0, 0);
        this.setTextureOffset("Leftarm.Crystals1", 0, 0);
        this.setTextureOffset("Leftarm.Crystals2", 0, 0);
        this.setTextureOffset("Leftarm.Finger1", 0, 0);
        this.setTextureOffset("Leftarm.Finger2", 0, 0);
        this.setTextureOffset("Leftarm.Wandhandle", 32, 0);
        this.setTextureOffset("Leftarm.Wandgem", 25, 25);
        this.setTextureOffset("Leftarm.Wandstud1", 25, 19);
        this.setTextureOffset("Leftarm.Wandstud2", 25, 19);
        this.setTextureOffset("Leftarm.Wandstud3", 25, 19);
        this.setTextureOffset("Leftarm.Wandstud4", 25, 19);
        this.setTextureOffset("Rightarm.Rightarm", 0, 0);
        this.setTextureOffset("Rightarm.Crystals3", 0, 0);
        this.setTextureOffset("Rightarm.Crystals4", 0, 0);
        this.setTextureOffset("Rightarm.Finger3", 0, 0);
        this.setTextureOffset("Rightarm.Finger4", 0, 0);
        this.setTextureOffset("Head.Head", 0, 19);
        this.setTextureOffset("Head.Crystalspike1", 4, 0);
        this.setTextureOffset("Head.Crystalspike2", 4, 0);
        this.setTextureOffset("Head.Crystalspike3", 4, 0);
        this.setTextureOffset("Head.Crystalspike4", 4, 0);
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -5.0f, -4.0f, 8, 10, 8);
        this.Body.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer(this, 0, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.Tail5.setRotationPoint(0.0f, 21.0f, 0.0f);
        this.Tail5.setTextureSize(64, 32);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, 0.0f, -4.0f, 8, 1, 8);
        this.Tail1.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.Tail1.setTextureSize(64, 32);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, 0.0f, -3.0f, 6, 1, 6);
        this.Tail2.setRotationPoint(0.0f, 15.0f, 0.0f);
        this.Tail2.setTextureSize(64, 32);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer(this, 0, 0)).addBox(-2.0f, 0.0f, -2.0f, 4, 1, 4);
        this.Tail3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.Tail3.setTextureSize(64, 32);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer(this, 0, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.Tail4.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.Tail4.setTextureSize(64, 32);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.0f, 0.0f, 0.0f);
        (this.Leftarm = new ModelRenderer(this, "Leftarm")).setRotationPoint(-4.0f, 4.0f, 0.0f);
        this.setRotation(this.Leftarm, 0.0f, 0.0f, 0.0f);
        this.Leftarm.mirror = true;
        this.Leftarm.addBox("Leftarm", -3.0f, -3.0f, -2.0f, 2, 9, 4);
        this.Leftarm.addBox("Crystals1", -2.0f, -4.0f, -1.0f, 1, 1, 1);
        this.Leftarm.addBox("Crystals2", -2.0f, -5.0f, 1.0f, 1, 2, 1);
        this.Leftarm.addBox("Finger1", -3.0f, 6.0f, 1.0f, 1, 2, 1);
        this.Leftarm.addBox("Finger2", -3.0f, 6.0f, -2.0f, 1, 2, 1);
        this.Leftarm.addBox("Wandhandle", -2.0f, 6.0f, -13.0f, 1, 1, 15);
        this.Leftarm.addBox("Wandgem", -3.0f, 5.0f, -16.0f, 3, 3, 3);
        this.Leftarm.addBox("Wandstud1", -2.0f, 4.0f, -18.0f, 1, 1, 4);
        this.Leftarm.addBox("Wandstud2", -4.0f, 6.0f, -18.0f, 1, 1, 4);
        this.Leftarm.addBox("Wandstud3", -2.0f, 8.0f, -18.0f, 1, 1, 4);
        this.Leftarm.addBox("Wandstud4", 0.0f, 6.0f, -18.0f, 1, 1, 4);
        (this.Rightarm = new ModelRenderer(this, "Rightarm")).setRotationPoint(4.0f, 4.0f, 0.0f);
        this.setRotation(this.Rightarm, 0.0f, 0.0f, 0.0f);
        this.Rightarm.mirror = true;
        this.Rightarm.addBox("Rightarm", 1.0f, -3.0f, -2.0f, 2, 9, 4);
        this.Rightarm.addBox("Crystals3", 1.0f, -4.0f, -1.0f, 1, 1, 1);
        this.Rightarm.addBox("Crystals4", 1.0f, -5.0f, 1.0f, 1, 2, 1);
        this.Rightarm.addBox("Finger3", 2.0f, 6.0f, 1.0f, 1, 2, 1);
        this.Rightarm.addBox("Finger4", 2.0f, 6.0f, -2.0f, 1, 2, 1);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, 1.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.addBox("Crystalspike1", 3.0f, -7.0f, 1.0f, 1, 3, 1);
        this.Head.addBox("Crystalspike2", -4.0f, -7.0f, 1.0f, 1, 3, 1);
        this.Head.addBox("Crystalspike3", -4.0f, -7.0f, -2.0f, 1, 3, 1);
        this.Head.addBox("Crystalspike4", 3.0f, -7.0f, -2.0f, 1, 3, 1);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Tail5.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.Tail4.render(f5);
        this.Leftarm.render(f5);
        this.Rightarm.render(f5);
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
        this.Rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.Leftarm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.Rightarm.rotateAngleZ = 0.0f;
        this.Leftarm.rotateAngleZ = 0.0f;
    }
}
