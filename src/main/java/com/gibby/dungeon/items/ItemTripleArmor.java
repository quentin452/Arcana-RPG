

package com.gibby.dungeon.items;

import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemTripleArmor extends ItemArmor
{
    public final int magicdefence;
    public final int voiddefence;
    
    public ItemTripleArmor(final ItemArmor.ArmorMaterial material, final int type, final int index, final int magicDefence, final int voidDefence) {
        super(material, type, index);
        this.setCreativeTab(Dungeons.Armor);
        this.setMaxStackSize(1);
        this.magicdefence = magicDefence;
        this.voiddefence = voidDefence;
    }
    
    public int getMagicDefence() {
        return this.magicdefence;
    }
    
    public int getVoidDefence() {
        return this.voiddefence;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Adds " + this.magicdefence + " Magic Defence");
        par3List.add(EnumChatFormatting.DARK_BLUE + "Adds " + this.voiddefence + " Void Defence");
    }
}
