

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderCrystal extends WorldProvider
{

    protected void generateLightBrightnessTable() {
        final float f = 0.1f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.lightBrightnessTable[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }

    public boolean canRespawnHere() {
        return false;
    }

    public String getDimensionName() {
        return "Crystalium Dimension";
    }

    public void registerWorldChunkManager() {
        this.isHellWorld = false;
        this.hasNoSky = true;
        this.dimensionId = Dungeons.crystalDimensionId;
        this.worldChunkMgr = new WorldChunkManagerHell(Dungeons.crystal, 0.0f);
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderCrystal(this.worldObj, this.worldObj.getSeed(), true);
    }

    public String getWelcomeMessage() {
        return "Entering the Crystalium Dimension";
    }

    public String getDepartMessage() {
        return "Leaving the Crystalium Dimension";
    }

    public boolean canDoLightning(final Chunk chunk) {
        return false;
    }

    public boolean canDoRainSnowIce(final Chunk chunk) {
        return false;
    }
}
