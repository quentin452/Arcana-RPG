package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenMidnightFoliage {
    private final Block[] foliageBlocks;

    public WorldGenMidnightFoliage() {
        this.foliageBlocks = new Block[] { Dungeons.midnightBush, Dungeons.midnightScrub, Dungeons.midnightShortgrass, Dungeons.midnightStem, Dungeons.midnightTallgrass, Dungeons.bloodThorns, Dungeons.blindlightLeaf, Dungeons.eruikPlant, Dungeons.darkOrchid, Dungeons.flimFlower, Dungeons.midnightBramble };
    }

    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y, z) != Dungeons.midnightGrass || world.getBlock(x, y + 1, z) != Blocks.air) {
            return false;
        }
        Block foliageBlock = this.foliageBlocks[rand.nextInt(this.foliageBlocks.length)];
        if (rand.nextInt(3) == 0) {
            foliageBlock = Dungeons.midnightBush;
        }
        else if (rand.nextInt(3) == 0) {
            foliageBlock = Dungeons.midnightShortgrass;
        }
        else if (rand.nextInt(2) == 0) {
            foliageBlock = Dungeons.midnightScrub;
        }
        else if (rand.nextInt(3) == 0) {
            foliageBlock = Dungeons.midnightTallgrass;
        }
        if (!world.isRemote) {
            for (int X = 0; X < 20; ++X) {
                for (int Y = -3; Y < 3; ++Y) {
                    for (int Z = 0; Z < 20; ++Z) {
                        if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.midnightGrass && world.isAirBlock(x + X, y + Y, z + Z) && rand.nextInt(10) == 0) {
                            if (foliageBlock != Dungeons.eruikPlant && foliageBlock != Dungeons.midnightTallgrass) {
                                world.setBlock(x + X, y + Y, z + Z, foliageBlock);
                            }
                            else {
                                ((BlockDoublePlant)foliageBlock).func_149889_c(world, x + X, y + Y, z + Z, 0, 2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
