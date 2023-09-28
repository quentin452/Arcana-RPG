

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenUpwardSpike extends WorldGenerator
{
    private int structureSize;

    public WorldGenUpwardSpike(final int size) {
        this.structureSize = size;
    }

    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y, z) != Blocks.air && world.getBlock(x + this.structureSize, y, z + this.structureSize) != Blocks.air && world.getBlock(x, y + 10, z) == Blocks.air && world.getBlock(x + this.structureSize, y + 10, z + this.structureSize) == Blocks.air && world.getBlock(x, y + this.structureSize * 2, z) == Blocks.air && world.getBlock(x + this.structureSize, y + this.structureSize * 2, z + this.structureSize) == Blocks.air) {
            for (int YLength = this.structureSize, Y = 0; Y <= YLength * 5; ++Y) {
                for (int X = 0; X <= this.structureSize; ++X) {
                    for (int Z = 0; Z <= this.structureSize; ++Z) {
                        world.setBlock(x + X - this.structureSize / 2, y + Y, z + Z - this.structureSize / 2, Dungeons.amethystCracks);
                    }
                }
                if (Y % 5 == 0) {
                    --this.structureSize;
                }
            }
            return true;
        }
        return false;
    }
}
