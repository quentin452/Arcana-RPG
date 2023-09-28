package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenMidnightTrees {
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.midnightGrass || world.getBlock(x, y, z) != Blocks.air) {
            return false;
        }
        for (int X = 0; X < 50; ++X) {
            for (int Y = -5; Y < 5; ++Y) {
                for (int Z = 0; Z < 50; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.midnightGrass && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(50) == 0) {
                        final int randInt = rand.nextInt(4);
                        if (randInt <= 2) {
                            new MidnightWillowSmall().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                        if (randInt == 3) {
                            new MidnightWillowLarge().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                    }
                }
            }
        }
        return true;
    }
}
