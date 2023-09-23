

package com.gibby.dungeon.items;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelOrcWarWand extends ModelBase
{
    ModelRenderer leftArm;
    
    public ModelOrcWarWand() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("leftArm.Gem", 0, 56);
        this.setTextureOffset("leftArm.Wand2", 70, 38);
        this.setTextureOffset("leftArm.Wand3", 0, 44);
        this.setTextureOffset("leftArm.Wand4", 0, 44);
        this.setTextureOffset("leftArm.Wand5", 0, 44);
        (this.leftArm = new ModelRenderer((ModelBase)this, "leftArm")).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.setRotation(this.leftArm, 0.0f, 0.0f, 0.0f);
        this.leftArm.mirror = true;
        this.leftArm.addBox("Gem", 0.0f, 0.0f, -22.0f, 2, 2, 2);
        this.leftArm.addBox("Wand2", 0.0f, 0.0f, -18.0f, 2, 2, 24);
        this.leftArm.addBox("Wand3", -1.0f, -1.0f, -4.0f, 4, 4, 2);
        this.leftArm.addBox("Wand4", -1.0f, -1.0f, -12.0f, 4, 4, 2);
        this.leftArm.addBox("Wand5", -1.0f, -1.0f, -20.0f, 4, 4, 2);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.leftArm.render(f5);
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
