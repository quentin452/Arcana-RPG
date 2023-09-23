

package com.gibby.dungeon;

import net.minecraftforge.client.*;
import net.minecraft.client.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.client.event.*;
import cpw.mods.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.entity.*;
import com.gibby.dungeon.items.*;

public class DungeonGuiIngame extends GuiIngameForge
{
    ResourceLocation magic;
    ResourceLocation voidarmor;
    ResourceLocation magicdamage;
    ResourceLocation voiddamage;
    ResourceLocation sunspot;
    int magicDamage;
    int voidDamage;
    
    public DungeonGuiIngame(final Minecraft minecraft) {
        super(minecraft);
        this.magic = new ResourceLocation("gibby_dungeons:textures/armor/magic armor.png");
        this.voidarmor = new ResourceLocation("gibby_dungeons:textures/armor/void armor.png");
        this.magicdamage = new ResourceLocation("gibby_dungeons:magicdamage.png");
        this.voiddamage = new ResourceLocation("gibby_dungeons:voiddamage.png");
        this.sunspot = new ResourceLocation("gibby_dungeons:sunspot.png");
    }
    
    @SubscribeEvent
    public void onLivingHurtEvent(final LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            if (event.source == DamageSource.magic) {
                this.magicDamage = 100;
            }
            if (event.source == DamageSource.outOfWorld) {
                this.voidDamage = 100;
            }
        }
    }
    
    @SubscribeEvent(priority = EventPriority.LOW)
    public void onRenderBossBar(final RenderGameOverlayEvent event) {
        this.renderResistanceBossHealth();
        this.renderStrengthBossHealth();
    }
    
    @SubscribeEvent(priority = EventPriority.LOW)
    public void onRenderHelmet(final RenderGameOverlayEvent event) {
        GL11.glEnable(3042);
        final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int k = scaledresolution.getScaledWidth();
        final int l = scaledresolution.getScaledHeight();
        if (this.mc.gameSettings.thirdPersonView == 0) {
            if (this.magicDamage > 0) {
                --this.magicDamage;
                if (this.mc.playerController != null && this.mc.playerController.shouldDrawHUD()) {
                    this.renderDamage(k, l);
                }
            }
            if (this.voidDamage > 0) {
                --this.voidDamage;
                if (this.mc.playerController != null && this.mc.playerController.shouldDrawHUD()) {
                    this.renderDamage(k, l);
                }
            }
            if (this.mc.thePlayer.getActivePotionEffect(Dungeons.sunspot) != null && this.mc.playerController != null && this.mc.playerController.shouldDrawHUD()) {
                this.renderPotionEffect(k, l);
            }
        }
    }
    
    @SubscribeEvent(priority = EventPriority.LOW)
    public void onRenderArmorBar(final RenderGameOverlayEvent event) {
        final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int k = scaledresolution.getScaledWidth();
        final int l = scaledresolution.getScaledHeight();
        if (this.mc.playerController != null && this.mc.playerController.shouldDrawHUD()) {
            this.func_110327_c(k, l);
        }
    }
    
    protected void renderDamage(final int par1, final int par2) {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.1f);
        GL11.glDisable(3008);
        if (this.voidDamage < 1) {
            this.mc.getTextureManager().bindTexture(this.magicdamage);
        }
        else {
            this.mc.getTextureManager().bindTexture(this.voiddamage);
        }
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, (double)par2, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)par1, (double)par2, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)par1, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.1f);
    }
    
    protected void renderPotionEffect(final int par1, final int par2) {
        final int ticks = this.mc.thePlayer.ticksExisted;
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.1f + 0.1f * (ticks % 50));
        GL11.glDisable(3008);
        this.mc.getTextureManager().bindTexture(this.sunspot);
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, (double)par2, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)par1, (double)par2, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)par1, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.1f + 0.1f * (ticks % 50));
    }
    
    protected void func_110327_c(final int par1, final int par2) {
        if (this.mc.thePlayer != null) {
            final DungeonsExtendedPlayer par3 = DungeonsExtendedPlayer.get((EntityPlayer)this.mc.thePlayer);
            final IAttributeInstance iattributeinstance = this.mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth);
            final int k1 = par1 / 2 - 91;
            final int l1 = par1 / 2 + 91;
            final int i2 = par2 - 39;
            final float f = (float)iattributeinstance.getAttributeValue();
            final float f2 = this.mc.thePlayer.getAbsorptionAmount();
            final int j2 = MathHelper.ceiling_float_int((f + f2) / 2.0f / 10.0f);
            final int k2 = Math.max(10 - (j2 - 2), 3);
            final int l2 = i2 - (j2 - 1) * k2 - 10;
            final float f3 = f2;
            final int i3 = this.TotalMagicDefence(this.mc.thePlayer);
            final int i4 = this.totalVoidDefence(this.mc.thePlayer);
            final int i5 = par3.magicAmount();
            final int j3 = -1;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(3042);
            int i6 = 0;
            if (i3 > 0) {
                i6 = 10;
            }
            this.mc.renderEngine.bindTexture(this.magic);
            this.mc.mcProfiler.startSection("custommagicbar");
            final int i7 = 0;
            for (int k3 = 0; k3 < 15; ++k3) {
                if (i5 > 0) {
                    int i8 = i5;
                    if (i8 > 30) {
                        i8 = 30;
                    }
                    final int l3 = k1 + k3 * 8;
                    if (k3 * 2 + 1 < i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz, i7 + 52, 0, 9, 9);
                    }
                    if (k3 * 2 + 1 == i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz, i7 + 62, 0, 9, 9);
                    }
                    if (k3 * 2 + 1 > i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz, i7 + 151, 9, 9, 9);
                    }
                }
                if (i5 > 30) {
                    int i8 = i5 - 30;
                    if (i8 > 60) {
                        i8 = 60;
                    }
                    final int l3 = k1 + k3 * 8;
                    if (k3 * 2 + 1 < i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz + 10, i7 + 52, 0, 9, 9);
                    }
                    if (k3 * 2 + 1 == i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz + 10, i7 + 62, 0, 9, 9);
                    }
                    if (k3 * 2 + 1 > i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz + 10, i7 + 151, 9, 9, 9);
                    }
                }
                if (i5 > 60) {
                    final int i8 = i5 - 60;
                    final int l3 = k1 + k3 * 8;
                    if (k3 * 2 + 1 < i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz + 20, i7 + 52, 0, 9, 9);
                    }
                    if (k3 * 2 + 1 == i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz + 20, i7 + 62, 0, 9, 9);
                    }
                    if (k3 * 2 + 1 > i8) {
                        this.drawTexturedModalRect(l3 + Dungeons.magicBarXpoz, l2 + Dungeons.magicBarYpoz + 20, i7 + 151, 9, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.startSection("customarmor");
            for (int k3 = 0; k3 < 10; ++k3) {
                if (i3 > 0) {
                    final int l3 = k1 + k3 * 8;
                    if (k3 * 2 + 1 < i3) {
                        this.drawTexturedModalRect(l3, l2 - 10, 34, 9, 9, 9);
                    }
                    if (k3 * 2 + 1 == i3) {
                        this.drawTexturedModalRect(l3, l2 - 10, 25, 9, 9, 9);
                    }
                    if (k3 * 2 + 1 > i3) {
                        this.drawTexturedModalRect(l3, l2 - 10, 16, 9, 9, 9);
                    }
                }
            }
            this.mc.renderEngine.bindTexture(this.voidarmor);
            for (int k3 = 0; k3 < 10; ++k3) {
                if (i4 > 0) {
                    final int l3 = k1 + k3 * 8;
                    if (k3 * 2 + 1 < i4) {
                        this.drawTexturedModalRect(l3, l2 - 10 - i6, 34, 9, 9, 9);
                    }
                    if (k3 * 2 + 1 == i4) {
                        this.drawTexturedModalRect(l3, l2 - 10 - i6, 25, 9, 9, 9);
                    }
                    if (k3 * 2 + 1 > i4) {
                        this.drawTexturedModalRect(l3, l2 - 10 - i6, 16, 9, 9, 9);
                    }
                }
            }
            GL11.glDisable(3042);
            this.mc.renderEngine.bindTexture(DungeonGuiIngame.icons);
            this.mc.mcProfiler.endSection();
        }
    }
    
    protected void renderResistanceBossHealth() {
        if (DungeonsBossStatusResistance.bossName != null && DungeonsBossStatusResistance.statusBarTime > 0) {
            this.mc.getTextureManager().bindTexture(this.voidarmor);
            --DungeonsBossStatusResistance.statusBarTime;
            final FontRenderer fontrenderer = this.mc.fontRenderer;
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int i = scaledresolution.getScaledWidth();
            final short short1 = 182;
            final int j = i / 2 - short1 / 2;
            final int k = (int)(DungeonsBossStatusResistance.healthScale * (short1 + 1));
            final byte b0 = 36;
            this.drawTexturedModalRect(j, (int)b0, 0, 74, (int)short1, 5);
            this.drawTexturedModalRect(j, (int)b0, 0, 74, (int)short1, 5);
            if (k > 0) {
                this.drawTexturedModalRect(j, (int)b0, 0, 79, k, 5);
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(DungeonGuiIngame.icons);
        }
    }
    
    protected void renderStrengthBossHealth() {
        if (DungeonsBossStatus.bossName != null && DungeonsBossStatus.statusBarTime > 0) {
            this.mc.getTextureManager().bindTexture(this.magic);
            --DungeonsBossStatus.statusBarTime;
            final FontRenderer fontrenderer = this.mc.fontRenderer;
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int i = scaledresolution.getScaledWidth();
            final short short1 = 182;
            final int j = i / 2 - short1 / 2;
            final int k = (int)(DungeonsBossStatus.healthScale * (short1 + 1));
            final byte b0 = 24;
            this.drawTexturedModalRect(j, (int)b0, 0, 74, (int)short1, 5);
            this.drawTexturedModalRect(j, (int)b0, 0, 74, (int)short1, 5);
            if (k > 0) {
                this.drawTexturedModalRect(j, (int)b0, 0, 79, k, 5);
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(DungeonGuiIngame.icons);
        }
    }
    
    public int TotalMagicDefence(final EntityClientPlayerMP player) {
        int bootDefence = 0;
        int leggingDefence = 0;
        int chestplateDefence = 0;
        int helmetDefence = 0;
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(0).getItem();
            bootDefence = armor.getMagicDefence();
        }
        if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(1).getItem();
            leggingDefence = armor.getMagicDefence();
        }
        if (player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(2).getItem();
            chestplateDefence = armor.getMagicDefence();
        }
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(3).getItem();
            helmetDefence = armor.getMagicDefence();
        }
        return bootDefence + leggingDefence + chestplateDefence + helmetDefence;
    }
    
    public int totalVoidDefence(final EntityClientPlayerMP player) {
        int bootDefence = 0;
        int leggingDefence = 0;
        int chestplateDefence = 0;
        int helmetDefence = 0;
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(0).getItem();
            bootDefence = armor.getVoidDefence();
        }
        if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(1).getItem();
            leggingDefence = armor.getVoidDefence();
        }
        if (player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(2).getItem();
            chestplateDefence = armor.getVoidDefence();
        }
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(3).getItem();
            helmetDefence = armor.getVoidDefence();
        }
        return bootDefence + leggingDefence + chestplateDefence + helmetDefence;
    }
}
