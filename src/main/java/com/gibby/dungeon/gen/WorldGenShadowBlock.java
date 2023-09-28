package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.blocks.TileEntityShadow;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenShadowBlock  extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.midnightGrass || !world.isAirBlock(x, y, z) || !world.isAirBlock(x, y + 4, z) || !world.isAirBlock(x, y + 8, z) || !world.isAirBlock(x, y + 10, z)) {
            return false;
        }
        world.setBlock(x, y, z, Dungeons.shadowRune2);
        world.setBlock(x, y + 1, z, Dungeons.shadowRune3);
        world.setBlock(x, y + 2, z, Dungeons.shadowBlock);
        final TileEntityShadow spawner = (TileEntityShadow)world.getTileEntity(x, y + 2, z);
        if (spawner != null) {
            if (rand.nextInt(2) == 0) {
                spawner.setMobName(49);
            }
            else if (rand.nextInt(2) == 0) {
                spawner.setMobName(48);
            }
            else {
                spawner.setMobName(47);
            }
            spawner.setMobCount(1);
        }
        return true;
    }
}
