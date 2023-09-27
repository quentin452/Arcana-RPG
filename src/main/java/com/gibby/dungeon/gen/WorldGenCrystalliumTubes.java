

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenCrystalliumTubes
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Blocks.water || world.getBlock(x, y, z) != Blocks.air) {
            return false;
        }
        for (int X = 0; X < 75; ++X) {
            for (int Y = -2; Y < 2; ++Y) {
                for (int Z = 0; Z < 75; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Blocks.water && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(15) == 0) {
                        final int randHeight = rand.nextInt(5);
                        final int randWidth = rand.nextInt(7) + 3;
                        final int randDirection = rand.nextInt(2);
                        if (randDirection == 0) {
                            for (int iY = -6; iY < randHeight; ++iY) {
                                world.setBlock(x + X - 1, y + Y + iY, z + Z, Dungeons.crystalWood);
                            }
                            for (int iX = 0; iX < randWidth; ++iX) {
                                world.setBlock(x + X + iX, y + Y + randHeight, z + Z, Dungeons.crystalWood);
                            }
                            for (int iY = -4; iY < randHeight; ++iY) {
                                world.setBlock(x + X + randWidth, y + Y + iY, z + Z, Dungeons.crystalWood);
                            }
                            if (rand.nextInt(4) == 0) {
                                new WorldGenSmallCrystalTree().generate(world, rand, x + X - 3 + randWidth / 2, y + Y + randHeight + 1, z + Z - 3);
                            }
                            else if (rand.nextInt(6) == 0) {
                                new WorldGenMediumCrystalTree().generate(world, rand, x + X - 7 + randWidth / 2, y + Y + randHeight + 1, z + Z - 8);
                            }
                        }
                        if (randDirection == 1) {
                            for (int iY = -6; iY < randHeight; ++iY) {
                                world.setBlock(x + X, y + Y + iY, z + Z - 1, Dungeons.crystalWood);
                            }
                            for (int iX = 0; iX < randWidth; ++iX) {
                                world.setBlock(x + X, y + Y + randHeight, z + iX + Z, Dungeons.crystalWood);
                            }
                            for (int iY = -4; iY < randHeight; ++iY) {
                                world.setBlock(x + X, y + Y + iY, z + Z + randWidth, Dungeons.crystalWood);
                            }
                            if (rand.nextInt(4) == 0) {
                                new WorldGenSmallCrystalTree().generate(world, rand, x + X - 3, y + Y + randHeight + 1, z + Z - 3 + randWidth / 2);
                            }
                            else if (rand.nextInt(6) == 0) {
                                new WorldGenMediumCrystalTree().generate(world, rand, x + X - 7, y + Y + randHeight + 1, z + Z + randWidth / 2 - 8);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
