

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderCrystalliumPlains extends WorldProvider
{

    public boolean canRespawnHere() {
        return false;
    }

    public String getDimensionName() {
        return "Crystallium Plains";
    }

    public void registerWorldChunkManager() {
        this.isHellWorld = false;
        this.dimensionId = Dungeons.crystalliumPlainsDimensionId;
        this.worldChunkMgr = new WorldChunkManagerHell(Dungeons.crystalliumPlainsBiome, (float)this.dimensionId);
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderCrystalliumPlains(this.worldObj, this.worldObj.getSeed(), true);
    }

    public static WorldProvider getProviderForDimension(final int id) {
        return DimensionManager.createProviderFor(Dungeons.crystalliumPlainsDimensionId);
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
