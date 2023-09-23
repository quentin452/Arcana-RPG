

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;

public class BlockDungeonSpawner extends Block implements ITileEntityProvider
{
    public BlockDungeonSpawner(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
    }
    
    public void onBlockDestroyedByPlayer(final World world, final int x, final int y, final int z, final int m) {
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityDungeonSpawner();
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
}
