

package com.gibby.dungeon.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.MathHelper;

public class ModelCrystalBadger extends ModelBase
{
    ModelRenderer body;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer Headwear;

    public ModelCrystalBadger() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("rightarm.rightarm", 80, 35);
        this.setTextureOffset("rightarm.rightfist", 80, 35);
        this.setTextureOffset("leftarm.leftarm", 80, 35);
        this.setTextureOffset("leftarm.leftfist", 80, 35);
        this.setTextureOffset("Headwear.horn1", 0, 0);
        this.setTextureOffset("Headwear.horn3", 0, 0);
        this.setTextureOffset("Headwear.head", 65, 0);
        this.setTextureOffset("Headwear.horn4", 0, 0);
        this.setTextureOffset("Headwear.horn2", 0, 0);
        (this.body = new ModelRenderer(this, 73, 30)).addBox(-7.0f, -1.0f, -5.0f, 14, 22, 10);
        this.body.setRotationPoint(0.0f, -10.0f, 0.0f);
        this.body.setTextureSize(128, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer(this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 13, 4);
        this.rightleg.setRotationPoint(-3.0f, 11.0f, 0.0f);
        this.rightleg.setTextureSize(128, 64);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer(this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 13, 4);
        this.leftleg.setRotationPoint(3.0f, 11.0f, 0.0f);
        this.leftleg.setTextureSize(128, 64);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer(this, "rightarm")).setRotationPoint(-9.0f, -6.0f, -1.0f);
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        this.rightarm.mirror = true;
        this.rightarm.addBox("rightarm", -3.0f, -2.0f, -2.0f, 5, 20, 6);
        this.rightarm.addBox("rightfist", -4.0f, 18.0f, -3.0f, 6, 5, 8);
        (this.leftarm = new ModelRenderer(this, "leftarm")).setRotationPoint(8.0f, -6.0f, -1.0f);
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        this.leftarm.mirror = true;
        this.leftarm.addBox("leftarm", -1.0f, -2.0f, -2.0f, 5, 20, 6);
        this.leftarm.addBox("leftfist", -1.0f, 18.0f, -3.0f, 6, 5, 8);
        (this.Headwear = new ModelRenderer(this, "Headwear")).setRotationPoint(0.0f, -12.0f, 0.0f);
        this.setRotation(this.Headwear, 0.0f, 0.0f, 0.0f);
        this.Headwear.mirror = true;
        this.Headwear.addBox("horn1", 4.0f, -3.0f, -1.0f, 6, 2, 2);
        this.Headwear.addBox("horn3", 4.0f, -7.0f, -1.0f, 9, 2, 2);
        this.Headwear.addBox("head", -5.0f, -8.0f, -5.0f, 10, 10, 10);
        this.Headwear.addBox("horn4", -14.0f, -7.0f, -1.0f, 10, 2, 2);
        this.Headwear.addBox("horn2", -10.0f, -3.0f, -1.0f, 6, 2, 2);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.Headwear.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.leftleg.rotateAngleX = -1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.rightleg.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.leftleg.rotateAngleY = 0.0f;
        this.rightleg.rotateAngleY = 0.0f;
        this.Headwear.rotateAngleY = f3 / 57.295776f;
        this.Headwear.rotateAngleX = f4 / 57.295776f;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void setLivingAnimations(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
        final EntityIronGolem entityirongolem = (EntityIronGolem)par1EntityLivingBase;
        final int i = entityirongolem.getAttackTimer();
        if (i > 0) {
            this.rightarm.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(i - par4, 10.0f);
            this.leftarm.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(i - par4, 10.0f);
        }
        else {
            final int j = entityirongolem.getHoldRoseTick();
            if (j > 0) {
                this.rightarm.rotateAngleX = -0.8f + 0.025f * this.func_78172_a((float)j, 70.0f);
                this.leftarm.rotateAngleX = 0.0f;
            }
            else {
                this.rightarm.rotateAngleX = (-0.2f + 1.5f * this.func_78172_a(par2, 13.0f)) * par3;
                this.leftarm.rotateAngleX = (-0.2f - 1.5f * this.func_78172_a(par2, 13.0f)) * par3;
            }
        }
    }

    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
