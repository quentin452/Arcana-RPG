

package com.gibby.dungeon.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;

public class ModelGolem extends ModelBase
{
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;

    public ModelGolem() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.head2 = new ModelRenderer(this, 0, 0)).addBox(-3.0f, -4.0f, -5.0f, 6, 10, 10);
        this.head2.setRotationPoint(11.0f, -9.0f, 0.0f);
        this.head2.setTextureSize(128, 128);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.7853982f, 0.0f, 0.0f);
        (this.head3 = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -5.0f, 7, 10, 10);
        this.head3.setRotationPoint(-11.0f, -9.0f, 0.0f);
        this.head3.setTextureSize(128, 128);
        this.head3.mirror = true;
        this.setRotation(this.head3, 0.7853982f, 0.0f, 0.0f);
        (this.head = new ModelRenderer(this, -1, 64)).addBox(-8.0f, -7.0f, -8.0f, 16, 16, 16);
        this.head.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.head.setTextureSize(128, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.7853982f, 0.0f, 0.0f);
        (this.body = new ModelRenderer(this, 16, 11)).addBox(-5.0f, -4.0f, -1.0f, 10, 12, 4);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer(this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 6, 25, 8);
        this.rightarm.setRotationPoint(-18.0f, -8.0f, -2.0f);
        this.rightarm.setTextureSize(128, 128);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer(this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 6, 25, 8);
        this.leftarm.setRotationPoint(13.0f, -8.0f, -2.0f);
        this.leftarm.setTextureSize(128, 128);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer(this, 0, 32)).addBox(-3.0f, 0.0f, -1.0f, 6, 16, 4);
        this.rightleg.setRotationPoint(-4.0f, 8.0f, 0.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer(this, 0, 32)).addBox(-3.0f, 0.0f, -1.0f, 6, 16, 4);
        this.leftleg.setRotationPoint(4.0f, 8.0f, 0.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head2.render(f5);
        this.head3.render(f5);
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
