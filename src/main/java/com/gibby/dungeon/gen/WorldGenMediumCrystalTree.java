

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMediumCrystalTree extends WorldGenerator implements IWorldGenerator
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
        if (world.getBlock(i + 7, j - 1, k + 8) != Dungeons.crystalliumGrass && world.getBlock(i + 7, j - 1, k + 8) != Dungeons.crystalWood) {
            return false;
        }
        for (int c = 0; c < 15; ++c) {
            if (!world.isAirBlock(i + 7, j + i, k + 8)) {
                return false;
            }
            if (!world.isAirBlock(i + 4, j + i, k + 4)) {
                return false;
            }
            if (!world.isAirBlock(i + 4, j + i, k + 12)) {
                return false;
            }
            if (!world.isAirBlock(i + 12, j + i, k + 4)) {
                return false;
            }
            if (!world.isAirBlock(i + 12, j + i, k + 12)) {
                return false;
            }
        }
        this.setBlock(world, i + 1, j + 13, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 1, j + 13, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 12, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 12, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 13, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 13, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 13, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 2, j + 13, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 13, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 14, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 14, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 12, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 13, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 13, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 11, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 11, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 4, j + 11, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 10, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 10, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 5, j + 10, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 11, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 11, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 11, k + 8, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 11, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 11, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 12, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 12, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 16, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 16, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 4, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 6, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 9, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 6, j + 10, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 6, j + 11, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 11, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 11, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 11, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 13, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 13, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 15, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 15, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 16, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 16, k + 6, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 6, j + 16, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 16, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 16, k + 10, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 6, j + 16, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 17, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 6, j + 17, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 1, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 2, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 3, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 3, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 4, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 4, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 4, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 5, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 5, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 5, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 6, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 6, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 6, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 7, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 7, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 8, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 9, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 10, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 10, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 11, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 11, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 11, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 11, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 11, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 11, k + 12, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 12, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 12, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 12, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 12, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 13, k + 1, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 13, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 13, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 13, k + 13, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 13, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 13, k + 15, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 14, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 14, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 16, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 16, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 16, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 7, j + 16, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 17, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 7, j + 17, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 8, j, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 1, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 1, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 1, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 2, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 2, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 2, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 3, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 3, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 3, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 4, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 4, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 4, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 5, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 5, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 5, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 6, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 6, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 6, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 7, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 7, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 7, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 8, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 8, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 8, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 9, k + 6, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 9, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 9, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 9, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 9, k + 10, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 10, k + 5, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 10, k + 6, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 10, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 10, k + 10, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 10, k + 11, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 11, k + 4, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 11, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 8, j + 11, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 11, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 8, j + 11, k + 12, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 12, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 12, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 12, k + 13, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 13, k + 2, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 13, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 13, k + 14, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 14, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 15, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 16, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 8, j + 17, k + 8, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 8, j + 18, k + 8, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 1, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 2, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 2, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 3, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 3, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 3, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 4, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 4, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 4, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 5, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 5, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 5, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 6, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 6, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 7, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 8, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 9, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 10, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 10, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 11, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 11, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 11, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 11, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 11, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 11, k + 12, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 12, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 12, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 12, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 12, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 13, k + 1, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 13, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 13, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 13, k + 13, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 13, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 13, k + 15, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 14, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 14, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 16, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 16, k + 7, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 16, k + 9, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 9, j + 16, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 17, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 9, j + 17, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 3, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 5, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 9, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 10, j + 10, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 10, j + 11, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 11, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 11, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 11, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 13, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 13, k + 14, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 15, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 15, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 16, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 16, k + 6, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 10, j + 16, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 16, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 16, k + 10, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 10, j + 16, k + 11, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 17, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 10, j + 17, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 10, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 10, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 11, j + 10, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 11, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 11, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 11, k + 8, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 11, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 11, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 12, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 12, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 16, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 11, j + 16, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 12, j + 11, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 12, j + 11, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 12, j + 11, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 13, j + 12, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 13, j + 13, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 13, j + 13, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 12, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 12, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 13, k + 6, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 13, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 13, k + 8, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 14, j + 13, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 13, k + 10, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 14, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 14, j + 14, k + 9, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 15, j + 13, k + 7, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 15, j + 13, k + 9, Dungeons.crystalliumLeaves, 0);
        return true;
    }
}
