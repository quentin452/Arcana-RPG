package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMontane extends WorldProvider
{

    public boolean canRespawnHere() {
        return false;
    }

    public String getDimensionName() {
        return "Sunset Dimension";
    }

    public void registerWorldChunkManager() {
        this.isHellWorld = false;
        this.worldChunkMgr = new WorldChunkManagerHell(Dungeons.sunset, 10.0f);
        this.dimensionId = Dungeons.montaneDungeonDimensionId;
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderSunset(this.worldObj, this.worldObj.getSeed());
    }

    public String getWelcomeMessage() {
        return "Entering the Montane Dimension";
    }

    public String getDepartMessage() {
        return "Leaving the Montane Dimension";
    }

    public boolean canDoRainSnowIce(final Chunk chunk) {
        return false;
    }

    public boolean canDoLightning(final Chunk chunk) {
        return false;
    }
}
