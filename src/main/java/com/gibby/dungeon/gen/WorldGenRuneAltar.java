package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenRuneAltar extends WorldGenerator implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
    }

    public void setBlock(final World world, final int x, final int y, final int z, final Block block, final int metadata) {
        final Block b1 = world.getBlock(x, y, z);
        if (b1.isAir((IBlockAccess)world, x, y, z) || b1.isLeaves((IBlockAccess)world, x, y, z)) {
            world.setBlock(x, y, z, block, metadata, 2);
        }
    }

    public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
        if (world.getBlock(i + 8, j - 1, k + 8) != Dungeons.midnightGrass) {
            return false;
        }
        for (int c = 0; c < 8; ++c) {
            if (!world.isAirBlock(i + 0, j + c, k + 14)) {
                return false;
            }
            if (!world.isAirBlock(i + 14, j + c, k + 0)) {
                return false;
            }
            if (!world.isAirBlock(i + 0, j + c, k + 0)) {
                return false;
            }
            if (!world.isAirBlock(i + 14, j + c, k + 14)) {
                return false;
            }
        }
        this.setBlock(world, i + 1, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 1, j + 1, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 1, j + 2, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 1, j + 3, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 2, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 2, j + 4, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 3, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 3, j + 5, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 1, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 1, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 2, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 2, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 3, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 3, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 4, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 4, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 5, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 5, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 4, j + 5, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 4, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 4, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 5, j + 6, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 1, k + 6, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 6, j + 1, k + 7, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 6, j + 1, k + 8, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 6, j + 5, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 5, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 6, j + 7, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 1, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 2, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 3, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 11, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 12, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 0, k + 13, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 1, k + 1, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 1, k + 6, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 7, j + 1, k + 7, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 7, j + 1, k + 8, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 7, j + 1, k + 13, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 2, k + 1, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 2, k + 7, Dungeons.runeAltar, 0);
        this.setBlock(world, i + 7, j + 2, k + 13, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 3, k + 1, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 3, k + 13, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 4, k + 2, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 4, k + 12, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 5, k + 3, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 5, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 5, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 5, k + 11, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 6, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 6, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 7, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 7, j + 7, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 1, k + 6, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 8, j + 1, k + 7, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 8, j + 1, k + 8, Dungeons.midnightCracks, 0);
        this.setBlock(world, i + 8, j + 5, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 5, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 8, j + 7, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 4, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 4, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 9, j + 6, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 0, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 1, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 1, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 2, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 2, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 3, k + 4, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 3, k + 10, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 4, k + 5, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 4, k + 9, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 5, k + 6, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 5, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 10, j + 5, k + 8, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 11, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 11, j + 5, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 12, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 12, j + 4, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 13, j + 0, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 13, j + 1, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 13, j + 2, k + 7, Dungeons.altarBricks, 0);
        this.setBlock(world, i + 13, j + 3, k + 7, Dungeons.altarBricks, 0);
        world.setBlockMetadataWithNotify(i + 0, j + 0, k + 7, 8, 2);
        world.setBlockMetadataWithNotify(i + 0, j + 1, k + 7, 8, 2);
        world.setBlockMetadataWithNotify(i + 0, j + 2, k + 7, 8, 2);
        world.setBlockMetadataWithNotify(i + 0, j + 3, k + 7, 8, 2);
        world.setBlockMetadataWithNotify(i + 1, j + 3, k + 8, 4, 2);
        world.setBlockMetadataWithNotify(i + 3, j + 4, k + 6, 1, 2);
        world.setBlockMetadataWithNotify(i + 3, j + 5, k + 6, 1, 2);
        world.setBlockMetadataWithNotify(i + 5, j + 4, k + 3, 1, 2);
        world.setBlockMetadataWithNotify(i + 5, j + 5, k + 8, 2, 2);
        world.setBlockMetadataWithNotify(i + 6, j + 4, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 6, j + 5, k + 9, 1, 2);
        world.setBlockMetadataWithNotify(i + 6, j + 6, k + 6, 8, 2);
        world.setBlockMetadataWithNotify(i + 6, j + 7, k + 6, 8, 2);
        world.setBlockMetadataWithNotify(i + 7, j + 7, k + 5, 1, 2);
        world.setBlockMetadataWithNotify(i + 8, j + 7, k + 8, 6, 2);
        world.setBlockMetadataWithNotify(i + 9, j + 1, k + 4, 8, 2);
        world.setBlockMetadataWithNotify(i + 9, j + 2, k + 4, 8, 2);
        world.setBlockMetadataWithNotify(i + 9, j + 3, k + 4, 8, 2);
        world.setBlockMetadataWithNotify(i + 9, j + 7, k + 7, 2, 2);
        world.setBlockMetadataWithNotify(i + 10, j + 1, k + 3, 1, 2);
        world.setBlockMetadataWithNotify(i + 10, j + 2, k + 3, 1, 2);
        world.setBlockMetadataWithNotify(i + 10, j + 2, k + 11, 4, 2);
        world.setBlockMetadataWithNotify(i + 10, j + 3, k + 3, 1, 2);
        world.setBlockMetadataWithNotify(i + 10, j + 3, k + 11, 4, 2);
        world.setBlockMetadataWithNotify(i + 10, j + 4, k + 6, 4, 2);
        world.setBlockMetadataWithNotify(i + 11, j + 3, k + 10, 2, 2);
        world.setBlockMetadataWithNotify(i + 11, j + 4, k + 5, 2, 2);
        return true;
    }
}
