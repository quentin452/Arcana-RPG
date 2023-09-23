

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

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
