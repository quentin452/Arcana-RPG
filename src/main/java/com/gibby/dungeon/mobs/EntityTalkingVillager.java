

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EntityTalkingVillager extends EntityVillager
{
    private final String[] comments;

    public EntityTalkingVillager(final World par1World) {
        this(par1World, 0);
    }

    public EntityTalkingVillager(final World par1World, final int par2) {
        super(par1World);
        this.comments = new String[] { "Hello stranger!", "You've come from another dimension?", "Here, there's always pleasant weather.", "Welcome to our wonderful village!", "Please, take anything you need.", "Where're you from?", "I hope our melon patch is doing all right.", "The quarry up there is filled with hardscrabble miners. Ugh!", "Be careful if you want to go on the path to the tree. It's dangerous!", "No, our sun never goes down. Your's moves? Odd.", "I never know what happens if you jump off. I'm too chicken to try.", "This glowstone? It's from the quarry up there.", "The stone floors in the Village are all from the quarry.", "Oh, those beastly trolls up to no good again. Can you hear their growl?", "I wish there was a safer way to link the Village and the Great Tree", "Fantastic isn't it? I love the view from my home!", "I heard there is strange project going on at the top of the tree.", "I've heard of another dimension that's purple. So George Tree says.", "Have I seen you before?", "I've read a fabulous book about a game called Minecraft! It sounds like a wonderful game!", "Say, have you heard of land that doesn't float? It seems impossible!", "Does the robe make me look fat?", "I wish I had a bigger house. Maybe a mansion would do.", "I've had a couple of zombie kills. Combat is not down my lane.", "I just wish the quarry would mine some more glowstone. We need more light.", "I just learned a new word: Inimitable! It is so unique!", "I just wish I could make a staff that would summon food. Then, no need to ccok!", "I'm getting tired of wood. I wish the quarry would crank out more stone.", "The overworld? I've been there once. The nether? Well I might say I nether heard of it!", "Underneath the tree, there are monsters and trolls.", "Have you heard of the Specter? I hear it's a magical ghost.", "We all fear the Zombie Warlord and his hoard. Luckily, he's not in this dimension.", "One of our engineers created a magnificent stone golem. Too bad it malfunctoned. We put it in a dungeon in the overworld.", "I have only heard legends about the Void Lord.", "Have you seen the Black Knight? He's a towering menace with impenratable armor.", "Oh gibbilywobbit! My buns are burning!" };
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
