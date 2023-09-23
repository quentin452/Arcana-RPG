

package com.gibby.dungeon.mobs;

import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class EntityTreeVillager extends EntityMoundTrader
{
    private double X;
    private double Y;
    private double Z;
    private String[] quests;
    
    public EntityTreeVillager(final World par1World) {
        this(par1World, 0);
    }
    
    public EntityTreeVillager(final World par1World, final int par2) {
        super(par1World);
        this.quests = new String[] { "Hello, if you have time, could you find 3 magic gems for me? I'll give you a reward", "Hi, we need bones in order to keep our tree growing, if you come across 32 bones, I give you something good.", "Our village has always wanted to try cookies. Everyone would be grateful if you brought a dozen." };
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
                par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("George Tree: " + this.quests[questNum]));
                if (questNum == 0) {
                    this.setCurrentItemOrArmor(1, new ItemStack(Dungeons.magicGem));
                }
                if (questNum == 1) {
                    this.setCurrentItemOrArmor(1, new ItemStack(Items.bone));
                }
                if (questNum == 2) {
                    this.setCurrentItemOrArmor(1, new ItemStack(Items.cookie));
                }
            }
            else if (!this.worldObj.isRemote) {
                final Item questItem = (this.getEquipmentInSlot(1) == null) ? Items.apple : this.getEquipmentInSlot(1).getItem();
                System.out.println(questItem.toString());
                if (questItem == Dungeons.magicGem && par1EntityPlayer.inventory.hasItemStack(new ItemStack(Dungeons.magicGem, 3, 0))) {
                    for (int i = 0; i < 3; ++i) {
                        par1EntityPlayer.inventory.consumeInventoryItem(Dungeons.magicGem);
                    }
                    this.setCurrentItemOrArmor(1, (ItemStack)null);
                    final ItemStack getEquipmentInSlot = this.getEquipmentInSlot(2);
                    --getEquipmentInSlot.stackSize;
                    par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("George Tree: Here's your reward."));
                    par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Dungeons.elementalSword, 1, 0));
                }
                else if (questItem == Items.bone && par1EntityPlayer.inventory.hasItemStack(new ItemStack(Items.bone, 32, 0))) {
                    for (int i = 0; i < 32; ++i) {
                        par1EntityPlayer.inventory.consumeInventoryItem(Items.bone);
                    }
                    this.setCurrentItemOrArmor(1, (ItemStack)null);
                    final ItemStack getEquipmentInSlot2 = this.getEquipmentInSlot(2);
                    --getEquipmentInSlot2.stackSize;
                    par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("George Tree: Thanks so much!"));
                    par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Dungeons.metalCoin, 15, 0));
                }
                else if (questItem == Items.cookie && par1EntityPlayer.inventory.hasItemStack(new ItemStack(Items.cookie, 12, 0))) {
                    for (int i = 0; i < 12; ++i) {
                        par1EntityPlayer.inventory.consumeInventoryItem(Items.cookie);
                    }
                    this.setCurrentItemOrArmor(1, (ItemStack)null);
                    final ItemStack getEquipmentInSlot3 = this.getEquipmentInSlot(2);
                    --getEquipmentInSlot3.stackSize;
                    par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("George Tree: The whole village thanks you!"));
                    par1EntityPlayer.inventory.addItemStackToInventory(Dungeons.setRare(new ItemStack(Dungeons.lithiumChestplate)));
                }
                else {
                    par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("George Tree: Did you get the items?"));
                }
            }
            return true;
        }
        if (!this.worldObj.isRemote) {
            par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("George Tree: Thank you for your services, I have no more tasks for you."));
        }
        return super.interact(par1EntityPlayer);
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return false;
    }
}
