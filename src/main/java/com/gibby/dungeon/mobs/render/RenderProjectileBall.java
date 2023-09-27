

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityProjectileBall;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import org.lwjgl.opengl.GL11;

public class RenderProjectileBall extends RenderSnowball
{
    String color;
    Item item;

    public RenderProjectileBall(final Item par1Item) {
        super(par1Item);
        this.color = "";
    }

    public void doRender(final EntityProjectileBall par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.item = Items.fire_charge;
        this.color = par1Entity.Color;
        if (this.color == "green") {
            this.item = Dungeons.cgreen;
        }
        if (this.color == "yellow") {
            this.item = Dungeons.cyellow;
        }
        if (this.color == "blue") {
            this.item = Dungeons.cblue;
        }
        if (this.color == "purple") {
            this.item = Dungeons.cpurple;
        }
        if (this.color == "darkblue") {
            this.item = Dungeons.cdarkblue;
        }
        if (this.color == "gray") {
            this.item = Dungeons.cgray;
        }
        if (this.color == "orange") {
            this.item = Items.fire_charge;
        }
        if (this.color == "clear") {
            this.item = Dungeons.invisible;
        }
        if (par1Entity.isDead) {
            this.item = Dungeons.invisible;
        }
        final IIcon iicon = this.item.getIconFromDamage(0);
        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)par2, (float)par4, (float)par6);
            GL11.glEnable(32826);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            this.bindEntityTexture((Entity)par1Entity);
            final Tessellator tessellator = Tessellator.instance;
            this.func_77026_a(tessellator, iicon);
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }

    private void func_77026_a(final Tessellator par1Tessellator, final IIcon par2Icon) {
        final float f = par2Icon.getMinU();
        final float f2 = par2Icon.getMaxU();
        final float f3 = par2Icon.getMinV();
        final float f4 = par2Icon.getMaxV();
        final float f5 = 1.0f;
        final float f6 = 0.5f;
        final float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0f, 1.0f, 0.0f);
        par1Tessellator.addVertexWithUV((double)(0.0f - f6), (double)(0.0f - f7), 0.0, (double)f, (double)f4);
        par1Tessellator.addVertexWithUV((double)(f5 - f6), (double)(0.0f - f7), 0.0, (double)f2, (double)f4);
        par1Tessellator.addVertexWithUV((double)(f5 - f6), (double)(f5 - f7), 0.0, (double)f2, (double)f3);
        par1Tessellator.addVertexWithUV((double)(0.0f - f6), (double)(f5 - f7), 0.0, (double)f, (double)f3);
        par1Tessellator.draw();
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.doRender((EntityProjectileBall)par1Entity, par2, par4, par6, par8, par9);
    }
}
