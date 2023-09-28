package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenFireflyTrees {
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.midnightGrass || world.getBlock(x, y, z) != Blocks.air) {
            return false;
        }
        for (int X = -25; X < 25; ++X) {
            for (int Y = -5; Y < 5; ++Y) {
                for (int Z = -25; Z < 25; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.midnightGrass && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(50) == 0) {
                        final int randInt = rand.nextInt(8);
                        if (randInt <= 2) {
                            new FireflyTreeSmall1().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                        if (randInt > 2 && randInt < 4) {
                            new FireflyTreeSmall2().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                        if (randInt > 4 && randInt < 7) {
                            new FireflyTreeMedium().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                        if (randInt > 6 && randInt < 8) {
                            new FireflyTreeLarge().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                    }
                }
            }
        }
        return true;
    }
}
