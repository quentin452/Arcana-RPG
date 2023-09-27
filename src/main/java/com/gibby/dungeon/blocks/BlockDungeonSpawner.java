

package com.gibby.dungeon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDungeonSpawner extends Block implements ITileEntityProvider
{
    public BlockDungeonSpawner(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
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
