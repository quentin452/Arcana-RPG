

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityQuarryMaster extends EntityMoundTrader
{
    private double X;
    private double Y;
    private double Z;
    private final String[] quests;

    public EntityQuarryMaster(final World par1World) {
        this(par1World, 0);
    }

    public EntityQuarryMaster(final World par1World, final int par2) {
        super(par1World);
        this.X = 0.0;
        this.quests = new String[] { "Sir, I'll pay you handsomely if you mine and smelt 64 iron ore from the caves below. Be careful!", "I need some troll meat to heal a worker in an accident. 10 cooked troll meat should do the trick.", "Those cave monsters stole my redstone! Could you find the redstone block and crush it back into redstone." };
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.metalCoin, 3, 0));
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.X == 0.0) {
            this.X = this.posX;
            this.Y = this.posY;
            this.Z = this.posZ;
        }
        if (this.X != this.posX) {
            this.posX = this.X;
        }
        if (this.Y != this.posY) {
            this.posY = this.Y;
        }
        if (this.Z != this.posZ) {
            this.posZ = this.Z;
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        final boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;
        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !par1EntityPlayer.isSneaking() && this.getEquipmentInSlot(2) != null && this.getEquipmentInSlot(2).stackSize > 0) {
            if (!this.worldObj.isRemote && this.getEquipmentInSlot(1) == null) {
                final int questNum = this.rand.nextInt(3);
                par1EntityPlayer.addChatMessage(new ChatComponentText("Quarry Master: " + this.quests[questNum]));
                if (questNum == 0) {
                    this.setCurrentItemOrArmor(1, new ItemStack(Items.iron_ingot));
                }
                if (questNum == 1) {
                    this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.cookedTrollMeat));
                }
                if (questNum == 2) {
                    this.setCurrentItemOrArmor(1, new ItemStack(Items.redstone));
                }
            }
            else if (!this.worldObj.isRemote) {
                final Item questItem = (this.getEquipmentInSlot(1) == null) ? Items.apple : this.getEquipmentInSlot(1).getItem();
                System.out.println(questItem.toString());
                if (questItem == Items.iron_ingot && par1EntityPlayer.inventory.hasItemStack(new ItemStack(Items.iron_ingot, 64, 0))) {
                    for (int i = 0; i < 64; ++i) {
                        par1EntityPlayer.inventory.consumeInventoryItem(Items.iron_ingot);
                    }
                    this.setCurrentItemOrArmor(1, null);
                    final ItemStack getEquipmentInSlot = this.getEquipmentInSlot(2);
                    --getEquipmentInSlot.stackSize;
                    par1EntityPlayer.addChatMessage(new ChatComponentText("Quarry Master: Here's your reward."));
                    par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Dungeons.metalCoin, 16, 0));
                }
                else if (questItem == Dungeons.cookedTrollMeat && par1EntityPlayer.inventory.hasItemStack(new ItemStack(Dungeons.cookedTrollMeat, 10, 0))) {
                    for (int i = 0; i < 10; ++i) {
                        par1EntityPlayer.inventory.consumeInventoryItem(Dungeons.cookedTrollMeat);
                    }
                    this.setCurrentItemOrArmor(1, null);
                    final ItemStack getEquipmentInSlot2 = this.getEquipmentInSlot(2);
                    --getEquipmentInSlot2.stackSize;
                    par1EntityPlayer.addChatMessage(new ChatComponentText("Quarry Master: You're a hero."));
                    par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Dungeons.amethystBoots, 1, 0));
                }
                else if (questItem == Items.redstone && par1EntityPlayer.inventory.hasItemStack(new ItemStack(Items.redstone, 9, 0))) {
                    for (int i = 0; i < 9; ++i) {
                        par1EntityPlayer.inventory.consumeInventoryItem(Items.redstone);
                    }
                    this.setCurrentItemOrArmor(1, null);
                    final ItemStack getEquipmentInSlot3 = this.getEquipmentInSlot(2);
                    --getEquipmentInSlot3.stackSize;
                    par1EntityPlayer.addChatMessage(new ChatComponentText("Quarry Master: Thank you."));
                    par1EntityPlayer.inventory.addItemStackToInventory(Dungeons.setRare(new ItemStack(Dungeons.heavyBedrockSword)));
                }
                else {
                    par1EntityPlayer.addChatMessage(new ChatComponentText("Quarry Master: Did you get the items?"));
                }
            }
            return true;
        }
        if (!this.worldObj.isRemote) {
            par1EntityPlayer.addChatMessage(new ChatComponentText("Quarry Master: Thank you for your services, I have no more tasks for you."));
        }
        return super.interact(par1EntityPlayer);
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return false;
    }
}
