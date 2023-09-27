

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class CrystalliumGenLayerBiomes extends GenLayer
{
    protected BiomeGenBase[] allowedBiomes;

    public CrystalliumGenLayerBiomes(final long seed) {
        super(seed);
        this.allowedBiomes = new BiomeGenBase[] { Dungeons.crystalliumPlainsBiome };
    }

    public CrystalliumGenLayerBiomes(final long seed, final GenLayer genlayer) {
        super(seed);
        this.allowedBiomes = new BiomeGenBase[] { Dungeons.crystalliumPlainsBiome };
        this.parent = genlayer;
    }

    public int[] getInts(final int x, final int z, final int width, final int depth) {
        final int[] dest = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
            }
        }
        return dest;
    }
}
