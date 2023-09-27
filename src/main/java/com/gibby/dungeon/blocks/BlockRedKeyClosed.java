

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockRedKeyClosed extends Block
{
    public BlockRedKeyClosed() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Dungeons.redKey && !world.isRemote) {
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            world.setBlock(x, y, z, Dungeons.redKeyOpen);
            final TileEntityRedKeyOpen spawner = (TileEntityRedKeyOpen)world.getTileEntity(x, y, z);
            world.playSoundAtEntity(player, "note.hat", 1.5f, 1.0f);
        }
        return false;
    }
}
