package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

import java.util.List;

public class ItemChamonixSword extends ItemStandardMagicSword
{
    public ItemChamonixSword(final Item.ToolMaterial p_i45356_1_, final int magic) {
        super(p_i45356_1_, magic);
        this.setCreativeTab(Dungeons.Weapons);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (count % 3 == 0 && count >= 960) {
            player.worldObj.playSoundAtEntity(player, "note.harp", 3.0f, (float)(0.6 + (1001 - count) / 20));
        }
    }

    public void onPlayerStoppedUsing(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        final int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
        final ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return;
        }
        if (event.charge > 40 && !par2World.isRemote) {
            par1ItemStack.damageItem(1, par3EntityPlayer);
            for (int i = 0; i < 10; ++i) {
                par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "note.harp", 3.0f, 1.2f);
            }
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 50, 1));
        }
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 1000;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer par6 = (EntityPlayer)par3Entity;
            if (par6.isBlocking() && par1ItemStack == par6.getCurrentEquippedItem() && !par2World.isRemote) {
                for (int i = 0; i < 4; ++i) {
                    final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(par2World, par6.posX + Dungeons.randGauss() / 2.0, par6.posY + Dungeons.randGauss() / 2.0, par6.posZ + Dungeons.randGauss() / 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                    particle.setRBGColorF(1.0f, 1.0f, 0.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect(particle);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_PURPLE + "+" + this.magicDamage + " Magical Damage");
        par3List.add(EnumChatFormatting.GOLD + "Right click to charge a healing move");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Dungeons.MODID + ":chamonix");
    }
}
