

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class BlockYellowLock extends Block
{
    public BlockYellowLock() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (!world.isRemote && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Dungeons.yellowKey) {
            world.playSoundAtEntity((Entity)player, "mob.irongolem.hit", 1.5f, 1.0f);
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            for (int X = -1; X < 2; ++X) {
                for (int Z = -1; Z < 2; ++Z) {
                    world.setBlockToAir(x + X, y, z + Z);
                    for (int i = 0; i < 10; ++i) {
                        world.spawnParticle("reddust", x + Z + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Z + Dungeons.randGauss(), 0.0, 0.0, 0.0);
                    }
                }
            }
        }
        return false;
    }
}
