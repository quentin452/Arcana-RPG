

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemStandardMagicArmor extends ItemArmor
{
    public final int magicdefence;

    public ItemStandardMagicArmor(final ItemArmor.ArmorMaterial material, final int type, final int index, final int magicDefence) {
        super(material, type, index);
        this.setCreativeTab(Dungeons.Weapons);
        this.setMaxStackSize(1);
        this.magicdefence = magicDefence;
    }

    public int getMagicDefence() {
        return this.magicdefence;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
