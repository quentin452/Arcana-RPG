

package com.gibby.dungeon.gen;

import net.minecraft.world.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;

public class WorldGenCrystalTrees
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.crystalliumGrass || world.getBlock(x, y, z) != Blocks.air) {
            return false;
        }
        for (int X = 0; X < 50; ++X) {
            for (int Y = -10; Y < 10; ++Y) {
                for (int Z = 0; Z < 50; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.crystalliumGrass && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(20) == 0) {
                        final int randInt = rand.nextInt(6);
                        if (randInt <= 1) {
                            new WorldGenSmallCrystalTree().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                        if (randInt > 1 && randInt <= 4) {
                            new WorldGenMediumCrystalTree().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                        if (randInt > 4) {
                            new WorldGenLargeCrystalTree().generate(world, rand, x + X, y + Y - 1, z + Z);
                        }
                    }
                }
            }
        }
        return true;
    }
}
