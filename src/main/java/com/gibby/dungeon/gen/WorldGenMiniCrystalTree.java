

package com.gibby.dungeon.gen;

import net.minecraft.world.gen.feature.*;
import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import com.gibby.dungeon.*;

public class WorldGenMiniCrystalTree extends WorldGenerator implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
    }
    
    public void setBlock(final World world, final int x, final int y, final int z, final Block block, final int metadata) {
        final Block b1 = world.getBlock(x, y, z);
        if (b1.isAir((IBlockAccess)world, x, y, z) || b1.isLeaves((IBlockAccess)world, x, y, z)) {
            world.setBlock(x, y, z, block, metadata, 2);
        }
    }
    
    public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
        this.setBlock(world, i + 1, j + 4, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 1, j + 8, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 3, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 4, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 4, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 4, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 5, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 7, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 8, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 8, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 8, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 2, j + 9, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 0, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 1, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 2, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 3, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 3, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 3, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 4, k + 1, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 4, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 4, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 4, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 4, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 5, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 5, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 6, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 7, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 7, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 7, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 8, k + 1, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 8, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 8, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 8, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 8, k + 5, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 9, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 9, k + 3, Dungeons.crystalWood, 0);
        this.setBlock(world, i + 3, j + 9, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 3, j + 10, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 3, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 4, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 4, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 4, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 5, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 7, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 8, k + 2, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 8, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 8, k + 4, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 4, j + 9, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 4, k + 3, Dungeons.crystalliumLeaves, 0);
        this.setBlock(world, i + 5, j + 8, k + 3, Dungeons.crystalliumLeaves, 0);
        return true;
    }
}
