

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemCopperArmor extends ItemArmor
{
    public ItemCopperArmor(final ItemArmor.ArmorMaterial material, final int type, final int index) {
        super(material, type, index);
        this.setCreativeTab(Dungeons.Armor);
        this.setMaxStackSize(1);
    }

    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == Dungeons.copperhelmet || stack.getItem() == Dungeons.copperchestplate || stack.getItem() == Dungeons.copperboots) {
            return "gibby_dungeons:textures/armor/copper_layer_1.png";
        }
        if (stack.getItem() == Dungeons.copperleggings) {
            return "gibby_dungeons:textures/armor/copper_layer_2.png";
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GOLD + "High Enchantablility");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
