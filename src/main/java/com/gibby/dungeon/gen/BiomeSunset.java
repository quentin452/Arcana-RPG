

package com.gibby.dungeon.gen;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSunset extends BiomeGenBase
{
    public BiomeSunset(final int par1) {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
    }
}
