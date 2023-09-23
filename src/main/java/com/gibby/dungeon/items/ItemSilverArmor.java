

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemSilverArmor extends ItemTripleArmor
{
    public ItemSilverArmor(final ItemArmor.ArmorMaterial material, final int type, final int index, final int magicDefence, final int voidDefence) {
        super(material, type, index, magicDefence, voidDefence);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == Dungeons.silverHelmet || stack.getItem() == Dungeons.silverChestplate || stack.getItem() == Dungeons.silverBoots) {
            return "gibby_dungeons:textures/armor/silver_layer_1.png";
        }
        if (stack.getItem() == Dungeons.rubyLeggings) {
            return "gibby_dungeons:textures/armor/silver_layer_2.png";
        }
        return null;
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null && player.getCurrentArmor(0).getItem() == Dungeons.silverBoots && player.getCurrentArmor(1).getItem() == Dungeons.silverLeggings && player.getCurrentArmor(2).getItem() == Dungeons.silverChestplate && player.getCurrentArmor(3).getItem() == Dungeons.silverHelmet) {
            player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 100, 5));
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 0));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.RED + "Full Set: Invisiblity and speed");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Adds " + this.magicdefence + " Magic Defence");
        par3List.add(EnumChatFormatting.DARK_BLUE + "Adds " + this.voiddefence + " Void Defence");
    }
}
