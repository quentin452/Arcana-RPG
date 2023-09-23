

package com.gibby.dungeon.gen;

import net.minecraft.block.*;
import com.gibby.dungeon.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;

public class WorldGenCrystalFoliage
{
    private Block[] foliageBlocks;
    
    public WorldGenCrystalFoliage() {
        this.foliageBlocks = new Block[] { Dungeons.crystalWeed, Dungeons.crystalStem, Dungeons.yellowTippedGrass, Dungeons.ghostRose, Dungeons.crystalStem, Dungeons.purpleEye, Dungeons.shimmerFlower, Dungeons.crystalLeaf };
    }
    
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y, z) != Dungeons.crystalGrass || world.getBlock(x, y + 1, z) != Blocks.air) {
            return false;
        }
        final Block foliageBlock = this.foliageBlocks[rand.nextInt(this.foliageBlocks.length)];
        for (int X = 0; X < 20; ++X) {
            for (int Y = -3; Y < 3; ++Y) {
                for (int Z = 0; Z < 20; ++Z) {
                    if (world.getBlock(x + X, y + Y - 1, z + Z) == Dungeons.crystalGrass && world.getBlock(x + X, y + Y, z + Z) == Blocks.air && rand.nextInt(5) == 0) {
                        world.setBlock(x + X, y + Y, z + Z, foliageBlock);
                    }
                }
            }
        }
        return true;
    }
}
