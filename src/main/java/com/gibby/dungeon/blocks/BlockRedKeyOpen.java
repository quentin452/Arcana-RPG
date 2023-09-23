

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;

public class BlockRedKeyOpen extends Block implements ITileEntityProvider
{
    public BlockRedKeyOpen() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(10000.0f);
        this.setTickRandomly(true);
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityRedKeyOpen();
    }
}
