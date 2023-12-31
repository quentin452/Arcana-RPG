

package com.gibby.dungeon.mobs.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderDiamondSword extends ItemRenderer implements IItemRenderer
{
    public RenderDiamondSword(final Minecraft par1Minecraft) {
        super(par1Minecraft);
    }

    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                GL11.glEnable(32826);
                super.renderItem((EntityLivingBase)data[1], item, 1, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                GL11.glScalef(2.5f, 2.5f, 2.5f);
                GL11.glDisable(32826);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED: {
                GL11.glPushMatrix();
                GL11.glEnable(32826);
                super.renderItem((EntityLivingBase)data[1], item, 1, IItemRenderer.ItemRenderType.EQUIPPED);
                GL11.glScalef(2.5f, 2.5f, 2.5f);
                GL11.glDisable(32826);
                GL11.glPopMatrix();
                break;
            }
        }
    }
}
