

package com.gibby.dungeon.gen;

import net.minecraft.world.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;

public class WorldGenCaveMushrooms
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.amethystStone || world.getBlock(x, y, z) != Blocks.air) {
            return false;
        }
        for (int X = 0; X < 20; ++X) {
            for (int Y = -3; Y < 3; ++Y) {
                for (int Z = 0; Z < 20; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.amethystStone && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(5) == 0) {
                        world.setBlock(x + X, y + Y, z + Z, Dungeons.caveMushrooms);
                    }
                }
            }
        }
        return true;
    }
}
