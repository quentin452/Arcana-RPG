

package com.gibby.dungeon.items;

import com.google.common.collect.Multimap;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import java.util.List;

public class ItemNetherHoe extends ItemHoe
{
    public ItemNetherHoe(final Item.ToolMaterial p_i45343_1_) {
        super(p_i45343_1_);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        final UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        }
        if (event.getResult() == Event.Result.ALLOW) {
            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
        final Block block = par3World.getBlock(par4, par5, par6);
        if (par7 == 0 || !par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) || (block != Blocks.grass && block != Blocks.dirt && block != Blocks.netherrack)) {
            return false;
        }
        final Block block2 = Blocks.farmland;
        par3World.playSoundEffect((par4 + 0.5f),(par5 + 0.5f), (par6 + 0.5f), block2.stepSound.getStepResourcePath(), (block2.stepSound.getVolume() + 1.0f) / 2.0f, block2.stepSound.getPitch() * 0.8f);
        if (par3World.isRemote) {
            return true;
        }
        for (int x = 0; x <= 4; ++x) {
            for (int y = 0; y <= 4; ++y) {
                for (int z = 0; z <= 4; ++z) {
                    if ((par3World.getBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2) == Blocks.grass || par3World.getBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2) == Blocks.dirt) && (par3World.getBlock(par4 + x - 2, par5 + y - 1, par6 + z - 2) == Blocks.air || par3World.getBlock(par4 + x - 2, par5 + y - 1, par6 + z - 2) == Blocks.tallgrass)) {
                        par3World.setBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2, Blocks.farmland);
                        par3World.spawnParticle("flame", par4 + x - 2, (par5 + y - 1), (par6 + z - 2), 0.0, 0.0, 0.0);
                        par3World.spawnParticle("largesmoke", (par4 + x - 2), (par5 + y - 1), (par6 + z - 2), 0.0, 0.0, 0.0);
                        par3World.spawnParticle("lava", (par4 + x - 2), (par5 + y - 1), (par6 + z - 2), 0.0, 0.0, 0.0);
                    }
                    else if (par3World.getBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2) == Blocks.tallgrass) {
                        par3World.setBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2, Blocks.air);
                    }
                    else if (par3World.getBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2) == Blocks.netherrack && (par3World.getBlock(par4 + x - 2, par5 + y - 1, par6 + z - 2) == Blocks.air || par3World.getBlock(par4 + x - 2, par5 + y - 1, par6 + z - 2) == Blocks.fire)) {
                        par3World.setBlock(par4 + x - 2, par5 + y - 2, par6 + z - 2, Blocks.soul_sand);
                        par3World.spawnParticle("flame", (par4 + x - 2), (par5 + y - 1), (par6 + z - 2), 0.0, 0.0, 0.0);
                        par3World.spawnParticle("largesmoke", (par4 + x - 2), (par5 + y - 1), (par6 + z - 2), 0.0, 0.0, 0.0);
                        par3World.spawnParticle("lava", (par4 + x - 2), (par5 + y - 1), (par6 + z - 2), 0.0, 0.0, 0.0);
                    }
                }
            }
        }
        par1ItemStack.damageItem(1, par2EntityPlayer);
        return true;
    }

    public Multimap getItemAttributeModifiers() {
        final Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(ItemNetherHoe.field_111210_e, "Weapon modifier", 4.0, 0));
        return multimap;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.DARK_RED + "Hoes dirt like a boss");
        par3List.add(EnumChatFormatting.DARK_RED + "Hoes netherrack even better");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
    }
}
