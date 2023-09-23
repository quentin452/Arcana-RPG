

package com.gibby.dungeon.gen;

import net.minecraft.world.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;

public class WorldGenCrystalBamboo
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y, z) != Dungeons.crystalGrass || world.getBlock(x, y + 1, z) != Blocks.air) {
            return false;
        }
        for (int X = 0; X < 20; ++X) {
            for (int Y = -3; Y < 3; ++Y) {
                for (int Z = 0; Z < 20; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.crystalGrass && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(5) == 0) {
                        final int r = rand.nextInt(4);
                        if (r <= 1) {
                            for (int i = 0; i < 3 + rand.nextInt(3); ++i) {
                                world.setBlock(x + X, y + Y + i, z + Z, Dungeons.crystalBamboo);
                            }
                        }
                        if (r == 3) {
                            for (int i = 0; i < 7 + rand.nextInt(4); ++i) {
                                world.setBlock(x + X, y + Y + i, z + Z, Dungeons.crystalBamboo);
                            }
                        }
                        if (r == 3) {
                            for (int i = 0; i < 12; ++i) {
                                world.setBlock(x + X, y + Y + i, z + Z, Dungeons.crystalBamboo);
                            }
                            world.setBlock(x + X, y + Y + 12, z + Z, Dungeons.crystalLeaves);
                            world.setBlock(x + X, y + Y + 13, z + Z, Dungeons.crystalLeaves);
                            world.setBlock(x + X, y + Y + 12, z + Z + 1, Dungeons.crystalLeaves);
                            world.setBlock(x + X, y + Y + 12, z + Z - 1, Dungeons.crystalLeaves);
                            world.setBlock(x + X + 1, y + Y + 12, z + Z, Dungeons.crystalLeaves);
                            world.setBlock(x + X - 1, y + Y + 12, z + Z, Dungeons.crystalLeaves);
                        }
                    }
                }
            }
        }
        return true;
    }
}
