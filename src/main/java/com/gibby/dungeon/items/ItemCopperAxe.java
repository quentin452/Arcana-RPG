

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemCopperAxe extends ItemAxe
{
    public ItemCopperAxe(final Item.ToolMaterial material) {
        super(material);
        this.setCreativeTab(Dungeons.Weapons);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
