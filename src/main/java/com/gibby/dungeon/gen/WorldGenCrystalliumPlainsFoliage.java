

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenCrystalliumPlainsFoliage
{
    private final Block[] foliageBlocks;

    public WorldGenCrystalliumPlainsFoliage() {
        this.foliageBlocks = new Block[] { Dungeons.crystalWeed, Dungeons.crystalStem, Dungeons.yellowTippedGrass, Dungeons.crystalliumFern };
    }

    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 1, z) != Dungeons.crystalliumGrass || world.getBlock(x, y, z) != Blocks.air) {
            return false;
        }
        final Block foliageBlock = this.foliageBlocks[rand.nextInt(this.foliageBlocks.length)];
        for (int X = 0; X < 20; ++X) {
            for (int Y = -3; Y < 3; ++Y) {
                for (int Z = 0; Z < 20; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.crystalliumGrass && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(5) == 0) {
                        if (foliageBlock != Dungeons.crystalliumFern) {
                            world.setBlock(x + X, y + Y, z + Z, foliageBlock);
                        }
                        else {
                            ((BlockDoublePlant)Dungeons.crystalliumFern).func_149889_c(world, x + X, y + Y, z + Z, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
