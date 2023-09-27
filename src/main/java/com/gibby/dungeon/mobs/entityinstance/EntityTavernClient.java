

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityTavernClient extends EntityVillager
{
    private final String[] comments;

    public EntityTavernClient(final World par1World) {
        this(par1World, 0);
    }

    public EntityTavernClient(final World par1World, final int par2) {
        super(par1World);
        this.comments = new String[] { "Hello stranger!", "What's a ya doing here?", "Look at this young pup!", "Ha! Ha! You thought this land was uninhabited?", "Welcome!", "I come here every day for a drink.", "My favorite drink is ginger ale.", "I'm a feeling a bit tipsy.", "Oooh. I got a headache.", "Ah, good food.", "I could slaughter cows and cook the meat myself, but I'ma too lazy.", "`yawn`", "Best place to eat.", "I just had their killer troll meat. Tis good fo the gut!", "This place is always crowded.", "I'ma goin monster huntin!", "Where's my axe?", "Ho ho ho!", "Have I seen you before?", "Don't go into the woods at night. Bandits will be after ya.", "You seen any of those mound villager hooligans lately?", "I needs some new booties.", "I needs ta sharpen ma sword.", "I'm the best blacksmith around!", "I've a wrestled a troll to the ground once.", "Gud Night.", "I tried magic once. Ha! More than blew my eyebrows off.", "You been to the sunset tree? Tis crazy awesome!", "I was trapped in the nether once. Had to fight my way out.", "I can't wait to go mining again. Need some o dat bedrock ore.", "Ma mum told me not to wander near any ruins or temples.", "We all fear the Zombie Warlord and his hoard. Luckily, he's not in this dimension.", "Heard of the Mega Stone Golem? I saw its massive blue eye once." };
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.metalCoin, 3, 0));
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        final boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;
        if (!par1EntityPlayer.worldObj.isRemote && !flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !par1EntityPlayer.isSneaking() && this.getEquipmentInSlot(2) != null && this.getEquipmentInSlot(2).stackSize > 0) {
            final int i = par1EntityPlayer.worldObj.rand.nextInt(this.comments.length);
            par1EntityPlayer.addChatMessage(new ChatComponentText("Villager: " + this.comments[i]));
        }
        return true;
    }
}
