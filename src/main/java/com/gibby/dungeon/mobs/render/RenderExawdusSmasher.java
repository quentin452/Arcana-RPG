

package com.gibby.dungeon.mobs.render;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.items.ModelExawdusSmasher;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderExawdusSmasher implements IItemRenderer
{
    private static final ResourceLocation swordTextures;
    ModelExawdusSmasher swordmodel;

    public RenderExawdusSmasher() {
        this.swordmodel = new ModelExawdusSmasher();
    }

    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderExawdusSmasher.swordTextures);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, 0.6f, 0.4f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderExawdusSmasher.swordTextures);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, 0.6f, 0.4f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                final float scale = 1.5f;
                GL11.glScalef(scale, scale, scale);
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderExawdusSmasher.swordTextures);
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
                final float scale = 0.7f;
                GL11.glScalef(scale, scale, scale);
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderExawdusSmasher.swordTextures);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.2f, -0.5f, 0.0f);
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
        swordTextures = new ResourceLocation(Dungeons.MODID + ":textures/items/exawdusSmasher.png");
    }
}
