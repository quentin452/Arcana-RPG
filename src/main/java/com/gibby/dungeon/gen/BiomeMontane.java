

package com.gibby.dungeon.gen;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeMontane extends BiomeGenBase
{
    public BiomeMontane(final int par1) {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.setBiomeName("Montane Biome");
    }
}
