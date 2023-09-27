

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

public class ItemAmethystArmor extends ItemTripleArmor
{
    public ItemAmethystArmor(final ItemArmor.ArmorMaterial material, final int type, final int index, final int magicDefence, final int voidDefence) {
        super(material, type, index, magicDefence, voidDefence);
    }

    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == Dungeons.amethystHelmet || stack.getItem() == Dungeons.amethystChestplate || stack.getItem() == Dungeons.amethystBoots) {
            return "gibby_dungeons:textures/armor/amethyst_layer1.png";
        }
        if (stack.getItem() == Dungeons.amethystLeggings) {
            return "gibby_dungeons:textures/armor/amethyst_layer2.png";
        }
        return null;
    }

    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null && player.getCurrentArmor(0).getItem() == Dungeons.amethystBoots && player.getCurrentArmor(1).getItem() == Dungeons.amethystLeggings && player.getCurrentArmor(2).getItem() == Dungeons.amethystChestplate && player.getCurrentArmor(3).getItem() == Dungeons.amethystHelmet) {
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 1));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.RED + "Full Set: Fire Resistance and Resistance II");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.DARK_PURPLE + "Adds " + this.magicdefence + " Magic Defence");
        par3List.add(EnumChatFormatting.DARK_BLUE + "Adds " + this.voiddefence + " Void Defence");
    }
}
