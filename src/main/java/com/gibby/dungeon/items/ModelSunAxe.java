

package com.gibby.dungeon.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSunAxe extends ModelBase
{
    ModelRenderer rod;
    ModelRenderer rod2;
    ModelRenderer rod3;
    ModelRenderer rod4;
    ModelRenderer endGem;
    ModelRenderer endGemFrame;
    ModelRenderer axeHeadtop;
    ModelRenderer axeHeadbottom;
    ModelRenderer axeHeadside1;
    ModelRenderer axeHeadside2;
    ModelRenderer axeHeadside3and4;
    ModelRenderer axeHead;
    ModelRenderer axeHeadsideMini;
    ModelRenderer axeHeadTippyTippytop;
    ModelRenderer axeHeadTippytop;
    ModelRenderer LargeBlade;
    ModelRenderer LargeBladeHolder;
    ModelRenderer LargeBladeHolder2;
    ModelRenderer LargeBladeStrip;
    ModelRenderer LargeBladeStripCurve1;
    ModelRenderer LargeBladeStripCurve;
    ModelRenderer MediumBladeStrip;
    ModelRenderer MediumBladeStripCurve;
    ModelRenderer BladeStripCurveTip;
    ModelRenderer SmallBladeStrip;
    ModelRenderer TinyBladeStrip;
    ModelRenderer smallBladeStripCurve;
    ModelRenderer smallBladeStripCurve1;
    ModelRenderer MediumBladeStripCurve1;
    ModelRenderer BladeStripCurveTip1;
    ModelRenderer TinyBladeStrip1;
    ModelRenderer axeSpike;
    ModelRenderer axeSpike1;
    ModelRenderer axeSpike2;
    ModelRenderer axeSpike3;
    ModelRenderer axeSpike4;
    ModelRenderer axeSpike5;

    public ModelSunAxe() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.rod = new ModelRenderer(this, 0, 76)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 50);
        this.rod.setRotationPoint(-1.0f, 0.0f, -50.0f);
        this.rod.setTextureSize(256, 128);
        this.rod.mirror = true;
        this.setRotation(this.rod);
        (this.rod2 = new ModelRenderer(this, 0, 76)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 50);
        this.rod2.setRotationPoint(0.0f, 1.0f, -50.0f);
        this.rod2.setTextureSize(256, 128);
        this.rod2.mirror = true;
        this.setRotation(this.rod2);
        (this.rod3 = new ModelRenderer(this, 0, 76)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 50);
        this.rod3.setRotationPoint(-2.0f, 1.0f, -50.0f);
        this.rod3.setTextureSize(256, 128);
        this.rod3.mirror = true;
        this.setRotation(this.rod3);
        (this.rod4 = new ModelRenderer(this, 0, 76)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 50);
        this.rod4.setRotationPoint(-1.0f, 2.0f, -50.0f);
        this.rod4.setTextureSize(256, 128);
        this.rod4.mirror = true;
        this.setRotation(this.rod4);
        (this.endGem = new ModelRenderer(this, 0, 30)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        this.endGem.setRotationPoint(-2.5f, -0.5f, 0.0f);
        this.endGem.setTextureSize(256, 128);
        this.endGem.mirror = true;
        this.setRotation(this.endGem);
        (this.endGemFrame = new ModelRenderer(this, 0, 40)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 5);
        this.endGemFrame.setRotationPoint(-3.0f, -1.0f, -0.5f);
        this.endGemFrame.setTextureSize(256, 128);
        this.endGemFrame.mirror = true;
        this.setRotation(this.endGemFrame);
        (this.axeHeadtop = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 20);
        this.axeHeadtop.setRotationPoint(-4.0f, -1.5f, -52.0f);
        this.axeHeadtop.setTextureSize(256, 128);
        this.axeHeadtop.mirror = true;
        this.setRotation(this.axeHeadtop);
        (this.axeHeadbottom = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 20);
        this.axeHeadbottom.setRotationPoint(-4.0f, 4.5f, -52.0f);
        this.axeHeadbottom.setTextureSize(256, 128);
        this.axeHeadbottom.mirror = true;
        this.setRotation(this.axeHeadbottom);
        (this.axeHeadside1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 20);
        this.axeHeadside1.setRotationPoint(-5.0f, -0.5f, -52.0f);
        this.axeHeadside1.setTextureSize(256, 128);
        this.axeHeadside1.mirror = true;
        this.setRotation(this.axeHeadside1);
        (this.axeHeadside2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 20);
        this.axeHeadside2.setRotationPoint(3.0f, -0.5f, -52.0f);
        this.axeHeadside2.setTextureSize(256, 128);
        this.axeHeadside2.mirror = true;
        this.setRotation(this.axeHeadside2);
        (this.axeHeadside3and4 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 5, 22);
        this.axeHeadside3and4.setRotationPoint(-4.0f, -0.5f, -53.0f);
        this.axeHeadside3and4.setTextureSize(256, 128);
        this.axeHeadside3and4.mirror = true;
        this.setRotation(this.axeHeadside3and4);
        (this.axeHead = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 7, 14);
        this.axeHead.setRotationPoint(-5.0f, -1.5f, -49.0f);
        this.axeHead.setTextureSize(256, 128);
        this.axeHead.mirror = true;
        this.setRotation(this.axeHead);
        (this.axeHeadsideMini = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 4, 1);
        this.axeHeadsideMini.setRotationPoint(-3.0f, 0.0f, -31.0f);
        this.axeHeadsideMini.setTextureSize(256, 128);
        this.axeHeadsideMini.mirror = true;
        this.setRotation(this.axeHeadsideMini);
        (this.axeHeadTippyTippytop = new ModelRenderer(this, 0, 59)).addBox(0.0f, 0.0f, 0.0f, 7, 9, 7);
        this.axeHeadTippyTippytop.setRotationPoint(-4.0f, -2.5f, -45.5f);
        this.axeHeadTippyTippytop.setTextureSize(256, 128);
        this.axeHeadTippyTippytop.mirror = true;
        this.setRotation(this.axeHeadTippyTippytop);
        (this.axeHeadTippytop = new ModelRenderer(this, 0, 59)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.axeHeadTippytop.setRotationPoint(-4.5f, -2.0f, -46.0f);
        this.axeHeadTippytop.setTextureSize(256, 128);
        this.axeHeadTippytop.mirror = true;
        this.setRotation(this.axeHeadTippytop);
        (this.LargeBlade = new ModelRenderer(this, 222, 64)).addBox(0.0f, 0.0f, 0.0f, 8, 4, 8);
        this.LargeBlade.setRotationPoint(4.0f, 0.0f, -46.0f);
        this.LargeBlade.setTextureSize(256, 128);
        this.LargeBlade.mirror = true;
        this.setRotation(this.LargeBlade);
        (this.LargeBladeHolder = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 5, 3);
        this.LargeBladeHolder.setRotationPoint(4.0f, -0.5f, -49.0f);
        this.LargeBladeHolder.setTextureSize(256, 128);
        this.LargeBladeHolder.mirror = true;
        this.setRotation(this.LargeBladeHolder);
        (this.LargeBladeHolder2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 5, 3);
        this.LargeBladeHolder2.setRotationPoint(4.0f, -0.5f, -38.0f);
        this.LargeBladeHolder2.setTextureSize(256, 128);
        this.LargeBladeHolder2.mirror = true;
        this.setRotation(this.LargeBladeHolder2);
        (this.LargeBladeStrip = new ModelRenderer(this, 179, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 4, 34);
        this.LargeBladeStrip.setRotationPoint(12.0f, 0.0f, -59.0f);
        this.LargeBladeStrip.setTextureSize(256, 128);
        this.LargeBladeStrip.mirror = true;
        this.setRotation(this.LargeBladeStrip);
        (this.LargeBladeStripCurve1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 2);
        this.LargeBladeStripCurve1.setRotationPoint(6.0f, 0.0f, -59.0f);
        this.LargeBladeStripCurve1.setTextureSize(256, 128);
        this.LargeBladeStripCurve1.mirror = true;
        this.setRotation(this.LargeBladeStripCurve1);
        (this.LargeBladeStripCurve = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 2);
        this.LargeBladeStripCurve.setRotationPoint(6.0f, 0.0f, -27.0f);
        this.LargeBladeStripCurve.setTextureSize(256, 128);
        this.LargeBladeStripCurve.mirror = true;
        this.setRotation(this.LargeBladeStripCurve);
        (this.MediumBladeStrip = new ModelRenderer(this, 170, 8)).addBox(0.0f, 0.0f, 0.0f, 6, 3, 37);
        this.MediumBladeStrip.setRotationPoint(11.0f, 0.5f, -60.5f);
        this.MediumBladeStrip.setTextureSize(256, 128);
        this.MediumBladeStrip.mirror = true;
        this.setRotation(this.MediumBladeStrip);
        (this.MediumBladeStripCurve = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 4);
        this.MediumBladeStripCurve.setRotationPoint(6.0f, 0.5f, -60.5f);
        this.MediumBladeStripCurve.setTextureSize(256, 128);
        this.MediumBladeStripCurve.mirror = true;
        this.setRotation(this.MediumBladeStripCurve);
        (this.BladeStripCurveTip = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 1);
        this.BladeStripCurveTip.setRotationPoint(6.0f, 0.5f, -30.5f);
        this.BladeStripCurveTip.setTextureSize(256, 128);
        this.BladeStripCurveTip.mirror = true;
        this.setRotation(this.BladeStripCurveTip);
        (this.SmallBladeStrip = new ModelRenderer(this, 159, 4)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 36);
        this.SmallBladeStrip.setRotationPoint(17.0f, 1.0f, -60.0f);
        this.SmallBladeStrip.setTextureSize(256, 128);
        this.SmallBladeStrip.mirror = true;
        this.setRotation(this.SmallBladeStrip);
        (this.TinyBladeStrip = new ModelRenderer(this, 120, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 35);
        this.TinyBladeStrip.setRotationPoint(19.0f, 1.5f, -59.5f);
        this.TinyBladeStrip.setTextureSize(256, 128);
        this.TinyBladeStrip.mirror = true;
        this.setRotation(this.TinyBladeStrip);
        (this.smallBladeStripCurve = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 7);
        this.smallBladeStripCurve.setRotationPoint(4.0f, 0.5f, -60.5f);
        this.smallBladeStripCurve.setTextureSize(256, 128);
        this.smallBladeStripCurve.mirror = true;
        this.setRotation(this.smallBladeStripCurve);
        (this.smallBladeStripCurve1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 7);
        this.smallBladeStripCurve1.setRotationPoint(4.0f, 0.5f, -30.5f);
        this.smallBladeStripCurve1.setTextureSize(256, 128);
        this.smallBladeStripCurve1.mirror = true;
        this.setRotation(this.smallBladeStripCurve1);
        (this.MediumBladeStripCurve1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 4);
        this.MediumBladeStripCurve1.setRotationPoint(6.0f, 0.5f, -27.5f);
        this.MediumBladeStripCurve1.setTextureSize(256, 128);
        this.MediumBladeStripCurve1.mirror = true;
        this.setRotation(this.MediumBladeStripCurve1);
        (this.BladeStripCurveTip1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 1);
        this.BladeStripCurveTip1.setRotationPoint(6.0f, 0.5f, -54.5f);
        this.BladeStripCurveTip1.setTextureSize(256, 128);
        this.BladeStripCurveTip1.mirror = true;
        this.setRotation(this.BladeStripCurveTip1);
        (this.TinyBladeStrip1 = new ModelRenderer(this, 89, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 29);
        this.TinyBladeStrip1.setRotationPoint(21.0f, 1.5f, -56.5f);
        this.TinyBladeStrip1.setTextureSize(256, 128);
        this.TinyBladeStrip1.mirror = true;
        this.setRotation(this.TinyBladeStrip1);
        (this.axeSpike = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 7, 7);
        this.axeSpike.setRotationPoint(-9.0f, -1.5f, -45.5f);
        this.axeSpike.setTextureSize(256, 128);
        this.axeSpike.mirror = true;
        this.setRotation(this.axeSpike);
        (this.axeSpike1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 6);
        this.axeSpike1.setRotationPoint(-12.0f, -1.0f, -45.0f);
        this.axeSpike1.setTextureSize(256, 128);
        this.axeSpike1.mirror = true;
        this.setRotation(this.axeSpike1);
        (this.axeSpike2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.axeSpike2.setRotationPoint(-14.0f, 0.0f, -44.3f);
        this.axeSpike2.setTextureSize(256, 128);
        this.axeSpike2.mirror = true;
        this.setRotation(this.axeSpike2);
        (this.axeSpike3 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 4);
        this.axeSpike3.setRotationPoint(-16.0f, 0.5f, -43.5f);
        this.axeSpike3.setTextureSize(256, 128);
        this.axeSpike3.mirror = true;
        this.setRotation(this.axeSpike3);
        (this.axeSpike4 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 3);
        this.axeSpike4.setRotationPoint(-17.0f, 1.0f, -42.7f);
        this.axeSpike4.setTextureSize(256, 128);
        this.axeSpike4.mirror = true;
        this.setRotation(this.axeSpike4);
        (this.axeSpike5 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.axeSpike5.setRotationPoint(-18.0f, 1.5f, -42.0f);
        this.axeSpike5.setTextureSize(256, 128);
        this.axeSpike5.mirror = true;
        this.setRotation(this.axeSpike5);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.rod.render(f5);
        this.rod2.render(f5);
        this.rod3.render(f5);
        this.rod4.render(f5);
        this.endGem.render(f5);
        this.endGemFrame.render(f5);
        this.axeHeadtop.render(f5);
        this.axeHeadbottom.render(f5);
        this.axeHeadside1.render(f5);
        this.axeHeadside2.render(f5);
        this.axeHeadside3and4.render(f5);
        this.axeHead.render(f5);
        this.axeHeadsideMini.render(f5);
        this.axeHeadTippyTippytop.render(f5);
        this.axeHeadTippytop.render(f5);
        this.LargeBlade.render(f5);
        this.LargeBladeHolder.render(f5);
        this.LargeBladeHolder2.render(f5);
        this.LargeBladeStrip.render(f5);
        this.LargeBladeStripCurve1.render(f5);
        this.LargeBladeStripCurve.render(f5);
        this.MediumBladeStrip.render(f5);
        this.MediumBladeStripCurve.render(f5);
        this.BladeStripCurveTip.render(f5);
        this.SmallBladeStrip.render(f5);
        this.TinyBladeStrip.render(f5);
        this.smallBladeStripCurve.render(f5);
        this.smallBladeStripCurve1.render(f5);
        this.MediumBladeStripCurve1.render(f5);
        this.BladeStripCurveTip1.render(f5);
        this.TinyBladeStrip1.render(f5);
        this.axeSpike.render(f5);
        this.axeSpike1.render(f5);
        this.axeSpike2.render(f5);
        this.axeSpike3.render(f5);
        this.axeSpike4.render(f5);
        this.axeSpike5.render(f5);
    }

    private void setRotation(final ModelRenderer model) {
        model.rotateAngleX = (float) 0.0;
        model.rotateAngleY = (float) 0.0;
        model.rotateAngleZ = (float) 0.0;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
