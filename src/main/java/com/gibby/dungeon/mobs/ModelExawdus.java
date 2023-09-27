

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelExawdus extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer Leftarm;
    ModelRenderer Rightleg;
    ModelRenderer Leftleg;
    ModelRenderer Rightarm;
    ModelRenderer Head;
    ModelRenderer Belly;
    ModelRenderer Back;

    public ModelExawdus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("Leftarm.Leftarm", 0, 0);
        this.setTextureOffset("Leftarm.Leftforearm", 0, 0);
        this.setTextureOffset("Leftarm.Leftshoulderspike1", 74, 0);
        this.setTextureOffset("Leftarm.Leftshoulderspike2", 93, 0);
        this.setTextureOffset("Leftarm.LeftSlicinghand1", 84, 34);
        this.setTextureOffset("Leftarm.Leftforearmoutside", 90, 11);
        this.setTextureOffset("Leftarm.Leftarmoutside", 90, 11);
        this.setTextureOffset("Leftarm.Leftshoulderspike3", 104, 0);
        this.setTextureOffset("Leftarm.LeftSlicinghand2", 105, 33);
        this.setTextureOffset("Rightleg.Rightleg", 62, 15);
        this.setTextureOffset("Rightleg.Rightfoot", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside1", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside2", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside3", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside4", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside5", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside6", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside7", 0, 0);
        this.setTextureOffset("Rightleg.RightFootside8", 0, 0);
        this.setTextureOffset("Leftleg.Leftleg", 62, 15);
        this.setTextureOffset("Leftleg.Leftfoot", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside1", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside2", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside3", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside4", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside5", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside6", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside7", 0, 0);
        this.setTextureOffset("Leftleg.LeftFootside8", 0, 0);
        this.setTextureOffset("Rightarm.Rightarm", 0, 0);
        this.setTextureOffset("Rightarm.Rightforearm", 0, 0);
        this.setTextureOffset("Rightarm.Rightshoulderspike1", 74, 0);
        this.setTextureOffset("Rightarm.Rightshoulderspike2", 93, 0);
        this.setTextureOffset("Rightarm.RightSlicinghand1", 84, 34);
        this.setTextureOffset("Rightarm.Rightforearmoutside", 90, 11);
        this.setTextureOffset("Rightarm.Rightarmoutside", 90, 11);
        this.setTextureOffset("Rightarm.Rightshoulderspike3", 104, 0);
        this.setTextureOffset("Rightarm.RightSlicinghand2", 105, 33);
        this.setTextureOffset("Head.Head1", 0, 31);
        this.setTextureOffset("Head.Jaw", 80, 18);
        this.setTextureOffset("Head.Rightheadspike1", 62, 0);
        this.setTextureOffset("Head.Rightheadspike2", 62, 0);
        this.setTextureOffset("Head.Rightheadspike3", 62, 0);
        this.setTextureOffset("Head.Leftheadspike2", 62, 0);
        this.setTextureOffset("Head.Leftheadspike3", 62, 0);
        this.setTextureOffset("Head.Leftheadspike1", 62, 0);
        (this.Body = new ModelRenderer(this, 0, 0)).addBox(-9.0f, -9.0f, -6.0f, 18, 18, 12);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Leftarm = new ModelRenderer(this, "Leftarm")).setRotationPoint(9.0f, -5.0f, 0.0f);
        this.setRotation(this.Leftarm, 0.0f, 0.0f, 0.0f);
        this.Leftarm.mirror = true;
        this.Leftarm.addBox("Leftarm", 0.0f, -6.0f, -4.0f, 4, 20, 8);
        this.Leftarm.addBox("Leftforearm", 0.0f, 10.0f, -19.0f, 4, 7, 20);
        this.Leftarm.addBox("Leftshoulderspike1", 0.0f, -10.0f, -3.0f, 3, 4, 6);
        this.Leftarm.addBox("Leftshoulderspike2", 0.0f, -14.0f, -2.0f, 2, 4, 3);
        this.Leftarm.addBox("LeftSlicinghand1", 1.0f, 11.0f, -37.0f, 1, 4, 9);
        this.Leftarm.addBox("Leftforearmoutside", 4.0f, 12.0f, -18.0f, 1, 3, 18);
        this.Leftarm.addBox("Leftarmoutside", 4.0f, -3.0f, -2.0f, 1, 14, 4);
        this.Leftarm.addBox("Leftshoulderspike3", 0.0f, -18.0f, -1.0f, 1, 4, 1);
        this.Leftarm.addBox("LeftSlicinghand2", 1.0f, 10.0f, -28.0f, 2, 6, 9);
        (this.Rightleg = new ModelRenderer(this, "Rightleg")).setRotationPoint(-5.0f, 9.0f, 0.0f);
        this.setRotation(this.Rightleg, 0.0f, 0.0f, 0.0f);
        this.Rightleg.mirror = true;
        this.Rightleg.addBox("Rightleg", -2.0f, 0.0f, -2.0f, 4, 11, 4);
        this.Rightleg.addBox("Rightfoot", -3.0f, 11.0f, -3.0f, 6, 4, 6);
        this.Rightleg.addBox("RightFootside1", 2.0f, 10.0f, -3.0f, 1, 1, 6);
        this.Rightleg.addBox("RightFootside2", 2.0f, 9.0f, -2.0f, 1, 1, 4);
        this.Rightleg.addBox("RightFootside3", 2.0f, 7.0f, 1.0f, 1, 2, 1);
        this.Rightleg.addBox("RightFootside4", 2.0f, 7.0f, -2.0f, 1, 2, 1);
        this.Rightleg.addBox("RightFootside5", -3.0f, 7.0f, 1.0f, 1, 2, 1);
        this.Rightleg.addBox("RightFootside6", -3.0f, 7.0f, -2.0f, 1, 2, 1);
        this.Rightleg.addBox("RightFootside7", -3.0f, 9.0f, -2.0f, 1, 1, 4);
        this.Rightleg.addBox("RightFootside8", -3.0f, 10.0f, -3.0f, 1, 1, 6);
        (this.Leftleg = new ModelRenderer(this, "Leftleg")).setRotationPoint(5.0f, 9.0f, 0.0f);
        this.setRotation(this.Leftleg, 0.0f, 0.0f, 0.0f);
        this.Leftleg.mirror = true;
        this.Leftleg.addBox("Leftleg", -2.0f, 0.0f, -2.0f, 4, 11, 4);
        this.Leftleg.addBox("Leftfoot", -3.0f, 11.0f, -3.0f, 6, 4, 6);
        this.Leftleg.addBox("LeftFootside1", 2.0f, 10.0f, -3.0f, 1, 1, 6);
        this.Leftleg.addBox("LeftFootside2", 2.0f, 9.0f, -2.0f, 1, 1, 4);
        this.Leftleg.addBox("LeftFootside3", 2.0f, 7.0f, 1.0f, 1, 2, 1);
        this.Leftleg.addBox("LeftFootside4", 2.0f, 7.0f, -2.0f, 1, 2, 1);
        this.Leftleg.addBox("LeftFootside5", -3.0f, 7.0f, 1.0f, 1, 2, 1);
        this.Leftleg.addBox("LeftFootside6", -3.0f, 7.0f, -2.0f, 1, 2, 1);
        this.Leftleg.addBox("LeftFootside7", -3.0f, 9.0f, -2.0f, 1, 1, 4);
        this.Leftleg.addBox("LeftFootside8", -3.0f, 10.0f, -3.0f, 1, 1, 6);
        (this.Rightarm = new ModelRenderer(this, "Rightarm")).setRotationPoint(-9.0f, -5.0f, 0.0f);
        this.setRotation(this.Rightarm, 0.0f, 0.0f, 0.0f);
        this.Rightarm.mirror = true;
        this.Rightarm.addBox("Rightarm", -4.0f, -6.0f, -4.0f, 4, 20, 8);
        this.Rightarm.addBox("Rightforearm", -4.0f, 10.0f, -19.0f, 4, 7, 20);
        this.Rightarm.addBox("Rightshoulderspike1", -3.0f, -10.0f, -3.0f, 3, 4, 6);
        this.Rightarm.addBox("Rightshoulderspike2", -2.0f, -14.0f, -2.0f, 2, 4, 3);
        this.Rightarm.addBox("RightSlicinghand1", -2.0f, 11.0f, -37.0f, 1, 4, 9);
        this.Rightarm.addBox("Rightforearmoutside", -5.0f, 12.0f, -18.0f, 1, 3, 18);
        this.Rightarm.addBox("Rightarmoutside", -5.0f, -3.0f, -2.0f, 1, 14, 4);
        this.Rightarm.addBox("Rightshoulderspike3", -1.0f, -18.0f, -1.0f, 1, 4, 1);
        this.Rightarm.addBox("RightSlicinghand2", -3.0f, 10.0f, -28.0f, 2, 6, 9);
        (this.Head = new ModelRenderer(this, "Head")).setRotationPoint(0.0f, -9.0f, 0.0f);
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        this.Head.mirror = true;
        this.Head.addBox("Head1", -5.0f, -10.0f, -5.0f, 10, 10, 10);
        this.Head.addBox("Jaw", -6.0f, -2.0f, -6.0f, 12, 2, 12);
        this.Head.addBox("Rightheadspike1", 5.0f, -16.0f, 0.0f, 1, 2, 1);
        this.Head.addBox("Rightheadspike2", 5.0f, -12.0f, -2.0f, 1, 10, 4);
        this.Head.addBox("Rightheadspike3", 5.0f, -14.0f, -1.0f, 1, 2, 2);
        this.Head.addBox("Leftheadspike2", -6.0f, -12.0f, -2.0f, 1, 10, 4);
        this.Head.addBox("Leftheadspike3", -6.0f, -14.0f, -1.0f, 1, 2, 2);
        this.Head.addBox("Leftheadspike1", -6.0f, -16.0f, 0.0f, 1, 2, 1);
        (this.Belly = new ModelRenderer(this, 41, 31)).addBox(-7.0f, -7.0f, 12.0f, 14, 14, 1);
        this.Belly.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.Belly.setTextureSize(128, 64);
        this.Belly.mirror = true;
        this.setRotation(this.Belly, 0.0f, 0.0f, 0.0f);
        (this.Back = new ModelRenderer(this, 41, 31)).addBox(-7.0f, -7.0f, -1.0f, 14, 14, 1);
        this.Back.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.Back.setTextureSize(128, 64);
        this.Back.mirror = true;
        this.setRotation(this.Back, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Leftarm.render(f5);
        this.Rightleg.render(f5);
        this.Leftleg.render(f5);
        this.Rightarm.render(f5);
        this.Head.render(f5);
        this.Belly.render(f5);
        this.Back.render(f5);
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
        this.Rightleg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.Leftleg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.Rightleg.rotateAngleY = 0.0f;
        this.Leftleg.rotateAngleY = 0.0f;
    }
}
