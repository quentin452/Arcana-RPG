

package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.util.DungeonsExtendedPlayer;
import com.gibby.dungeon.mobs.entityinstance.EntityStoneBot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBotAmulet extends ItemForceWand
{
    public ItemBotAmulet() {
        this.tier = 2;
    }

    @Override
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if ((par4.magicAmount() >= 15 && par3.inventory.hasItemStack(new ItemStack(Dungeons.copper, 3, 0))) || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemBotAmulet.itemRand.nextGaussian(), ItemBotAmulet.itemRand.nextGaussian(), ItemBotAmulet.itemRand.nextGaussian());
            }
            for (int x = 0; x < 100; ++x) {
                par3.worldObj.spawnParticle("magicCrit", par3.posX, par3.posY - 1.0, par3.posZ, par2World.rand.nextGaussian(), 0.0, par2World.rand.nextGaussian());
            }
            if (!par2World.isRemote) {
                final EntityStoneBot entity = new EntityStoneBot(par2World);
                entity.setPosition(par3.posX, par3.posY + 1.0, par3.posZ);
                par2World.spawnEntityInWorld((Entity)entity);
                entity.onSpawnWithEgg((IEntityLivingData)null);
                entity.setPosition(par3.posX, par3.posY + 1.0, par3.posZ);
            }
            for (int i = 0; i < 3; ++i) {
                par3.inventory.consumeInventoryItem(Dungeons.copper);
            }
            par4.consumeMagic(15);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GOLD + "Right Click to Summon");
        par3List.add(EnumChatFormatting.GOLD + "Summons a bot. Requires 15 magic and 3 copper ingots.");
        par3List.add(EnumChatFormatting.GOLD + "Can be healed with copper or iron ingots.");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
