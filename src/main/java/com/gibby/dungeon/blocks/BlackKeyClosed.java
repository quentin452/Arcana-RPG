

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class BlackKeyClosed extends Block
{
    public BlackKeyClosed() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Dungeons.blackKey && !world.isRemote) {
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            world.setBlock(x, y, z, Dungeons.blackKeyOpen);
            world.playSoundAtEntity((Entity)player, "note.hat", 1.5f, 1.0f);
        }
        return false;
    }
}
