

package com.gibby.dungeon.mobs;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class EntityMinerVillager extends EntityVillager
{
    private String[] comments;
    
    public EntityMinerVillager(final World par1World) {
        this(par1World, 0);
    }
    
    public EntityMinerVillager(final World par1World, final int par2) {
        super(par1World);
        this.comments = new String[] { "Waz up man!", "Been working here fo' days.", "Wonder when this quarry gonna run out o' metal.", "My face is dirty!", "I think I'm lost", "Where're you from?", "Need a new pickaxe, mine's about to break", "I heard there's trolls up on top of this place", "There be caves somewhere. They be dangerous!", "Dis, a visitor? Where yo' from?", "Ha! The tree villagers be lazy. Not us!", "I never get ta use the crane. 'Dey don't allow me ta.", "*yawn* Yarg, I'm tired.", "Haven't seen the light o' day for eight days!", "Dis place is spooky.", "I've mined fo' hundered iron or'. How much have ya mined?", "I need some foodies. My tum gettin empty!", "Yo a stranger!", "Havent't seen ya before. Come from de Tree Town?", "Be careful kid, there be dangers here.", "Wat. Some'un sto' my iron! Who sto' my iron!", "I be so tired! Ho! My shift is almost up! Woop!", "Hmm?", "Does dis mine go furder down?", "Oi! What do we gauss here? Oh, only dirt.", "I tink we lost all de minecarts", "Where am I? Where's de Quarry Master?", "Argh! Meh back be killing meh!", "Some day, I'ma gonna go to de overworld." };
        this.setCurrentItemOrArmor(2, new ItemStack(Dungeons.metalCoin, 3, 0));
    }
    
    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        final boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;
        if (!par1EntityPlayer.worldObj.isRemote && !flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !par1EntityPlayer.isSneaking() && this.getEquipmentInSlot(2) != null && this.getEquipmentInSlot(2).stackSize > 0) {
            final int i = par1EntityPlayer.worldObj.rand.nextInt(this.comments.length);
            par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("Miner: " + this.comments[i]));
        }
        return true;
    }
}
