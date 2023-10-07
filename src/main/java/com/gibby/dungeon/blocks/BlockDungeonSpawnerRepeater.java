

package com.gibby.dungeon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDungeonSpawnerRepeater extends Block implements ITileEntityProvider
{
    public BlockDungeonSpawnerRepeater(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setHardness(14.0f);
        this.setResistance(14.0f);
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
