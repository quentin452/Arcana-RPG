

package com.gibby.dungeon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
