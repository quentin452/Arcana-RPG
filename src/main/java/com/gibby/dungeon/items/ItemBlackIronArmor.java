

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBlackIronArmor extends ItemTripleArmor
{
    public ItemBlackIronArmor(final ItemArmor.ArmorMaterial material, final int type, final int index, final int magicDefence, final int voidDefence) {
        super(material, type, index, magicDefence, voidDefence);
    }

    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == Dungeons.blackIronHelmet || stack.getItem() == Dungeons.blackIronChestplate || stack.getItem() == Dungeons.blackIronBoots) {
            return "gibby_dungeons:textures/armor/blackiron_layer_1.png";
        }
        if (stack.getItem() == Dungeons.blackIronLeggings) {
            return "gibby_dungeons:textures/armor/blackiron_layer_2.png";
        }
        return null;
    }

    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null && player.getCurrentArmor(0).getItem() == Dungeons.blackIronBoots && player.getCurrentArmor(1).getItem() == Dungeons.blackIronLeggings && player.getCurrentArmor(2).getItem() == Dungeons.blackIronChestplate && player.getCurrentArmor(3).getItem() == Dungeons.blackIronHelmet) {
            if (player.getHealth() / player.getMaxHealth() >= 0.5) {
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 1));
            }
            else {
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 1));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.RED + "Full Set: Fire Resistance. Adds Strength II above half health");
        par3List.add(EnumChatFormatting.RED + "and Resistance II below half health");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Adds " + this.magicdefence + " Magic Defence");
        par3List.add(EnumChatFormatting.DARK_BLUE + "Adds " + this.voiddefence + " Void Defence");
    }
}
