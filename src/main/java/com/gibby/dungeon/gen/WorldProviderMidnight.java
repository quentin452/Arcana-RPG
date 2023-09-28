package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderMidnight extends WorldProvider
{
    public boolean isSurfaceWorld() {
        return true;
    }

    public boolean canRespawnHere() {
        return false;
    }

    public String getDimensionName() {
        return "Midnight";
    }

    public void registerWorldChunkManager() {
        this.isHellWorld = false;
        this.dimensionId = Dungeons.midnightDimensionId;
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(Dungeons.midnightBiome, (float)this.dimensionId);
    }

    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderMidnight(this.worldObj, this.worldObj.getSeed(), true);
    }

    public static WorldProvider getProviderForDimension(final int id) {
        return DimensionManager.createProviderFor(Dungeons.midnightDimensionId);
    }

    public String getWelcomeMessage() {
        return "Entering the Crystallium Dimension";
    }

    public String getDepartMessage() {
        return "Leaving the Crystallium Dimension";
    }

    public boolean canDoLightning(final Chunk chunk) {
        return false;
    }

    public boolean canDoRainSnowIce(final Chunk chunk) {
        return false;
    }
}
