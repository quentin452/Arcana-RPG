

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockDungeonSpawnerRepeater extends Block implements ITileEntityProvider
{
    public BlockDungeonSpawnerRepeater(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setHardness(14.0f);
        this.setResistance(14.0f);
    }
    
    public void onBlockDestroyedByPlayer(final World world, final int x, final int y, final int z, final int m) {
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityDungeonSpawnerRepeater();
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
}
