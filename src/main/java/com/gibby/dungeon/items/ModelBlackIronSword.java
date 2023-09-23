

package com.gibby.dungeon.items;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelBlackIronSword extends ModelBase
{
    ModelRenderer Sword;
    
    public ModelBlackIronSword() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("Sword.Sword3", 0, 44);
        this.setTextureOffset("Sword.Sword1", 0, 44);
        this.setTextureOffset("Sword.Sword2", 0, 44);
        this.setTextureOffset("Sword.Sword4", 0, 44);
        this.setTextureOffset("Sword.Sword5", 0, 44);
        this.setTextureOffset("Sword.Sword6", 0, 44);
        (this.Sword = new ModelRenderer((ModelBase)this, "Sword")).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.setRotation(this.Sword, 0.0f, 0.0f, 0.0f);
        this.Sword.mirror = true;
        this.Sword.addBox("Sword3", 0.0f, -2.0f, -23.0f, 1, 2, 2);
        this.Sword.addBox("Sword1", 0.0f, 0.0f, 0.0f, 1, 2, 8);
        this.Sword.addBox("Sword2", 0.0f, -1.0f, -14.0f, 1, 3, 14);
        this.Sword.addBox("Sword4", 0.0f, -4.0f, -26.0f, 1, 1, 9);
        this.Sword.addBox("Sword5", 0.0f, -2.0f, -21.0f, 1, 3, 14);
        this.Sword.addBox("Sword6", 0.0f, -3.0f, -25.0f, 1, 1, 14);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Sword.render(f5);
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
