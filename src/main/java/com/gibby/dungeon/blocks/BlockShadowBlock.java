package com.gibby.dungeon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockShadowBlock extends Block implements ITileEntityProvider
{
    public BlockShadowBlock(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }

    public boolean hasTileEntity(final int metadata) {
        return true;
    }

    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityShadow();
    }

    public boolean isOpaqueCube() {
        return false;
    }
}
