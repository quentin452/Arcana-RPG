package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class FireflyTreeSmall1 extends WorldGenerator implements IWorldGenerator
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
        if (world.getBlock(i + 4, j - 1, k + 5) != Dungeons.midnightGrass) {
            return false;
        }
        for (int c = 2; c < 6; ++c) {
            if (!world.isAirBlock(i + 0, j + c, k + 8)) {
                return false;
            }
            if (!world.isAirBlock(i + 8, j + c, k + 0)) {
                return false;
            }
            if (!world.isAirBlock(i + 0, j + c, k + 0)) {
                return false;
            }
            if (!world.isAirBlock(i + 8, j + c, k + 8)) {
                return false;
            }
        }
        this.setBlock(world, i + 1, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 1, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 2, j + 5, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 2, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 2, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 2, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 2, j + 5, k + 7, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 2, j + 6, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 4, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 2, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 7, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 8, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 6, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 6, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 3, j + 6, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 0, k + 5, Dungeons.fireflyLog, 0);
        this.setBlock(world, i + 4, j + 1, k + 5, Dungeons.fireflyLog, 0);
        this.setBlock(world, i + 4, j + 2, k + 5, Dungeons.fireflyLog, 0);
        this.setBlock(world, i + 4, j + 3, k + 5, Dungeons.fireflyLog, 0);
        this.setBlock(world, i + 4, j + 4, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 4, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 4, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 4, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 1, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 2, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 7, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 8, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 9, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 6, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 6, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 6, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 6, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 6, k + 7, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 7, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 7, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 4, j + 7, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 4, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 4, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 4, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 1, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 2, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 7, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 5, k + 8, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 6, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 6, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 6, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 5, j + 6, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 4, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 2, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 7, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 6, j + 5, k + 8, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 7, j + 5, k + 3, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 7, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 7, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 7, j + 5, k + 6, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 8, j + 5, k + 4, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 8, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        this.setBlock(world, i + 9, j + 5, k + 5, Dungeons.fireflyLeaves, 0);
        return true;
    }
}
