

package com.gibby.dungeon.gen;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class CrystalliumGenLayer extends GenLayer
{
    public CrystalliumGenLayer(final long seed) {
        super(seed);
    }

    public static GenLayer[] makeTheWorld(final long seed) {
        GenLayer biomes = new CrystalliumGenLayerBiomes(1L);
        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);
        final GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        return new GenLayer[] { biomes, genlayervoronoizoom };
    }

    public int[] getInts(final int p_75904_1_, final int p_75904_2_, final int p_75904_3_, final int p_75904_4_) {
        return null;
    }
}
