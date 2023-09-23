

package com.gibby.dungeon.gen;

import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;

public class WorldProviderSunset extends WorldProvider
{
    public boolean isSurfaceWorld() {
        return true;
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public String getDimensionName() {
        return "Sunset Dimension";
    }
    
    public void registerWorldChunkManager() {
        this.isHellWorld = false;
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(Dungeons.sunset, 10.0f);
        this.dimensionId = Dungeons.sunsetDimensionId;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderSunset(this.worldObj, this.worldObj.getSeed());
    }
    
    public String getWelcomeMessage() {
        return "Entering the Sunset Dimension";
    }
    
    public String getDepartMessage() {
        return "Leaving the Sunset Dimension";
    }
    
    public boolean canDoRainSnowIce(final Chunk chunk) {
        return false;
    }
    
    public boolean canDoLightning(final Chunk chunk) {
        return false;
    }
}
