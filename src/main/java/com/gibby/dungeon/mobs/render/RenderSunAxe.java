

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.items.ModelSunAxe;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSunAxe implements IItemRenderer
{
    private static final ResourceLocation swordTextures;
    ModelSunAxe swordmodel;

    public RenderSunAxe() {
        this.swordmodel = new ModelSunAxe();
    }

    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED: {
                final float scale = 0.9f;
                GL11.glScalef(scale, scale, scale);
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSunAxe.swordTextures);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.8f, -0.5f, 0.3f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                final float scale = 0.9f;
                GL11.glScalef(scale, scale, scale);
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSunAxe.swordTextures);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, 0.6f, 0.6f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                final float scale = 1.5f;
                GL11.glScalef(scale, scale, scale);
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSunAxe.swordTextures);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.2f, 1.0f, 0.0f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case INVENTORY: {
                GL11.glPushMatrix();
                final float scale = 0.6f;
                GL11.glScalef(scale, scale, scale);
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSunAxe.swordTextures);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, -0.6f, 0.0f);
                this.swordmodel.render((Entity)null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
        }
    }

    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        switch (type) {
            case INVENTORY: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    static {
        swordTextures = new ResourceLocation("gibby_dungeons:textures/items/sunaxe.png");
    }
}
