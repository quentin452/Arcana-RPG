package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenGlowingBrambles extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y + 1, z) != Dungeons.midnightStone || !world.isAirBlock(x, y, z) || !world.isAirBlock(x, y - 4, z) || !world.isAirBlock(x, y - 8, z)) {
            return false;
        }
        for (int i = -(rand.nextInt(6) + 2); i <= 0; ++i) {
            world.setBlock(x, y + i, z, Dungeons.glowingBrambles);
        }
        return true;
    }
}
