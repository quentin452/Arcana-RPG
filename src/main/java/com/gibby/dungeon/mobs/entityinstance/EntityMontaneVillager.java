

package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityMontaneVillager extends EntityVillager
{
    private final String[] comments;

    public EntityMontaneVillager(final World par1World) {
        this(par1World, 0);
    }

    public EntityMontaneVillager(final World par1World, final int par2) {
        super(par1World);
        this.comments = new String[] { "Hi, who are you?", "You don't seem like the rest of 'em.", "Do you have some food?", "I think our houses are nice.", "You aren't one of the guards, are you.", "Do you like it here?", "Come into my house if you like.", "Our houses aren't in the greatest shape. No one gives us new wood.", "Are you going to attack the tower over there? That's impossible!", "I'm hungry.", "They won't let us be part of their empire.", "We feel kinda abandoned.", "It's a nice view from here.", "Sometimes I wish that there was land for everybody to roam around.", "Have you seen my sister? The guards took her away.", "The guards sure like to build.", "Wait. You're from another dimension?", "Before the guards came, we had the whole mountain for ourselves. They built most everything of course.", "Have I seen you before?", "You should go talk to the trader here.", "Yes, you've seen orcs and sapeints. They have more powerful guards in the tower.", "If you get onto the main island, could you grab us some wood?", "We are in no position to take on those guards.", "I've seen it. The tower. It's impossible to conquer. Turn back now.", "We have a small stockpile of weapons and supplies.", "It's nice here. I could live here. I just want some food.", "~Huff~ I feel so trapped here.", "Good night.", "Do you see the stars? I wish to go up there one day.", "Mining in the earth? That seems crazy! Nothing's valuable down there!", "There are many many bosses and dungeons in the main island.", "Sometimes, you can feel the breeze pick your feet up.", "The general has a magnificent sun axe. It's legendary.", "~yawn~ I'm sleepy.", "Haven't had a full inventory in years.", "One day, these guards will disappear forever." };
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
