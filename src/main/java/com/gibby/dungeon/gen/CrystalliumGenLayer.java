

package com.gibby.dungeon.gen;

import net.minecraft.world.*;
import net.minecraft.world.gen.layer.*;

public class CrystalliumGenLayer extends GenLayer
{
    public CrystalliumGenLayer(final long seed) {
        super(seed);
    }
    
    public static GenLayer[] makeTheWorld(final long seed, final WorldType type) {
        GenLayer biomes = new CrystalliumGenLayerBiomes(1L);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        final GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        return new GenLayer[] { biomes, genlayervoronoizoom };
    }
    
    public int[] getInts(final int p_75904_1_, final int p_75904_2_, final int p_75904_3_, final int p_75904_4_) {
        return null;
    }
}
