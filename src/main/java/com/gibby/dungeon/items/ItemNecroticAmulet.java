

package com.gibby.dungeon.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemNecroticAmulet extends ItemForceWand
{
    public ItemNecroticAmulet() {
        this.tier = 1;
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3) {
        final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get(par3);
        if ((par4.magicAmount() >= 7 && par3.inventory.hasItemStack(new ItemStack(Items.rotten_flesh, 3, 0))) || par3.capabilities.isCreativeMode) {
            for (int i = 0; i < 10; ++i) {
                par2World.spawnParticle("enchantmenttable", par3.posX, par3.posY, par3.posZ, ItemNecroticAmulet.itemRand.nextGaussian(), ItemNecroticAmulet.itemRand.nextGaussian(), ItemNecroticAmulet.itemRand.nextGaussian());
            }
            for (int x = 0; x < 100; ++x) {
                par3.worldObj.spawnParticle("magicCrit", par3.posX, par3.posY - 1.0, par3.posZ, par2World.rand.nextGaussian(), 0.0, par2World.rand.nextGaussian());
            }
            if (!par2World.isRemote) {
                final EntityFriendlyZombie entity = new EntityFriendlyZombie(par2World);
                entity.setTamed(true);
                entity.setPosition(par3.posX, par3.posY + 1.0, par3.posZ);
                entity.func_152115_b(par3.getUniqueID().toString());
                par2World.spawnEntityInWorld((Entity)entity);
                entity.onSpawnWithEgg((IEntityLivingData)null);
                entity.setPosition(par3.posX, par3.posY + 1.0, par3.posZ);
            }
            for (int i = 0; i < 3; ++i) {
                par3.inventory.consumeInventoryItem(Items.rotten_flesh);
            }
            par4.consumeMagic(7);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(EnumChatFormatting.GOLD + "Right Click to Summon");
        par3List.add(EnumChatFormatting.GOLD + "Summons a friendly Zombie. Requires 7 magic and 3 rotten flesh.");
        par3List.add(EnumChatFormatting.GRAY + "Has " + (this.getMaxDamage() - this.getDamage(par1ItemStack)) + " uses left");
        par3List.add(EnumChatFormatting.GRAY + "Tier " + this.tier);
    }
}
