

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrystox extends ModelBase
{
    ModelRenderer Leaf1;
    ModelRenderer Leaf2;
    ModelRenderer Leaf3;
    ModelRenderer Leaf4;
    ModelRenderer Stem;
    ModelRenderer Head;

    public ModelCrystox() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Head.Head", 15, 0);
        this.setTextureOffset("Head.Headleaf1", 0, 19);
        this.setTextureOffset("Head.Headleaf2", 0, 19);
        this.setTextureOffset("Head.Headleaf4", 0, 19);
        this.setTextureOffset("Head.Headleaf3", 0, 19);
        (this.Leaf1 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -8.0f, -1.0f, 6, 8, 1);
        this.Leaf1.setRotationPoint(0.0f, 24.0f, -3.0f);
        this.Leaf1.setTextureSize(64, 32);
        this.Leaf1.mirror = true;
        this.setRotation(this.Leaf1, 1.047198f, 0.0f);
        (this.Leaf2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, -8.0f, -3.0f, 1, 8, 6);
        this.Leaf2.setRotationPoint(3.0f, 24.0f, 0.0f);
        this.Leaf2.setTextureSize(64, 32);
        this.Leaf2.mirror = true;
        this.setRotation(this.Leaf2, 0.0f, 1.047198f);
        (this.Leaf3 = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -8.0f, -3.0f, 1, 8, 6);
        this.Leaf3.setRotationPoint(-3.0f, 24.0f, 0.0f);
        this.Leaf3.setTextureSize(64, 32);
        this.Leaf3.mirror = true;
        this.setRotation(this.Leaf3, 0.0f, -1.047198f);
        (this.Leaf4 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -8.0f, 0.0f, 6, 8, 1);
        this.Leaf4.setRotationPoint(0.0f, 24.0f, 3.0f);
        this.Leaf4.setTextureSize(64, 32);
        this.Leaf4.mirror = true;
        this.setRotation(this.Leaf4, -1.047198f, 0.0f);
        (this.Stem = new ModelRenderer(this, 0, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 16, 2);
        this.Stem.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Stem.setTextureSize(64, 32);
        this.Stem.mirror = true;
        this.setRotation(this.Stem, 0.0f, 0.0f);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, 8.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head", -3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.Head.addBox("Headleaf1", -2.0f, 0.0f, -4.0f, 4, 6, 1);
        this.Head.addBox("Headleaf2", -2.0f, -12.0f, -4.0f, 4, 6, 1);
        this.Head.addBox("Headleaf4", -8.0f, -5.0f, -4.0f, 5, 4, 1);
        this.Head.addBox("Headleaf3", 3.0f, -5.0f, -4.0f, 5, 4, 1);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Leaf1.render(f5);
        this.Leaf2.render(f5);
        this.Leaf3.render(f5);
        this.Leaf4.render(f5);
        this.Stem.render(f5);
        this.Head.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = (float) 0.0;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.rotateAngleY = f3 / 57.295776f;
        this.Head.rotateAngleX = f4 / 57.295776f;
    }
}
