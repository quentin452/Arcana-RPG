package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenShadowAltar extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.midnightGrass || !world.isAirBlock(x, y, z) || !world.isAirBlock(x, y + 4, z) || !world.isAirBlock(x, y + 8, z) || !world.isAirBlock(x, y + 10, z)) {
            return false;
        }
        world.setBlock(x, y, z, Dungeons.shadowRune2);
        world.setBlock(x, y + 1, z, Dungeons.shadowRune2);
        world.setBlock(x, y + 2, z, Dungeons.shadowRune3);
        world.setBlock(x, y + 3, z, Dungeons.shadowRune3);
        world.setBlock(x, y + 4, z, Dungeons.shadowAltar);
        world.setBlock(x, y, z + 4, Dungeons.shadowRune2);
        world.setBlock(x, y + 1, z + 4, Dungeons.shadowRune2);
        world.setBlock(x, y + 2, z + 4, Dungeons.shadowRune3);
        world.setBlock(x, y, z - 4, Dungeons.shadowRune2);
        world.setBlock(x, y + 1, z - 4, Dungeons.shadowRune2);
        world.setBlock(x, y + 2, z - 4, Dungeons.shadowRune3);
        world.setBlock(x + 4, y, z, Dungeons.shadowRune2);
        world.setBlock(x + 4, y + 1, z, Dungeons.shadowRune2);
        world.setBlock(x + 4, y + 2, z, Dungeons.shadowRune3);
        world.setBlock(x - 4, y, z, Dungeons.shadowRune2);
        world.setBlock(x - 4, y + 1, z, Dungeons.shadowRune2);
        world.setBlock(x - 4, y + 2, z, Dungeons.shadowRune3);
        return true;
    }
}
