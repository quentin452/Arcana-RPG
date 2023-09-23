

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class treefortress extends WorldGenerator
{
    public boolean generate(final World world, final Random rand, final int xCoord, final int yCoord, final int zCoord) {
        if (world.getBlock(xCoord, yCoord, zCoord) != Blocks.grass || world.getBlock(xCoord, yCoord + 1, zCoord) != Blocks.air) {
            return false;
        }

        for (int x = -1; x <= 6; x++) {
            for (int y = 0; y <= 10; y++) {
                for (int z = -1; z <= 8; z++) {
                    Block block = (x == 0 && y == 0 && z == 0) ? Blocks.log : Blocks.leaves;
                    int meta = (x == 0 && y == 0 && z == 0) ? 0 : 12;

                    if (x == -1 || x == 6 || y == 0 || y == 10 || z == -1 || z == 8) {
                        if (block == Blocks.leaves) {
                            world.setBlock(xCoord + x, yCoord + y, zCoord + z, block, meta, 0);
                        }
                    } else {
                        world.setBlock(xCoord + x, yCoord + y, zCoord + z, block, meta, 0);
                        Dungeons.spawner(world, xCoord + 6, yCoord + 9, zCoord + 4, 12, 2);
                        WorldGenWarlordDungeon.chest(world, rand, xCoord + 6, yCoord + 9, zCoord + 5, "dungeonChest", rand.nextInt(5) + 1);
                        placeLadder(world, xCoord + 3, yCoord, zCoord + 4);
                    }
                }
            }
        }
        return true;
    }

    private void placeLadder(World world, int x, int y, int z) {
        for (int i = 0; i < 8; i++) {
            world.setBlock(x, y + i, z, Blocks.ladder, 4, 0);
        }
    }
}
