

package com.gibby.dungeon.gen;

import net.minecraft.world.*;
import com.gibby.dungeon.*;
import net.minecraftforge.common.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;

public class WorldProviderCrystalliumPlains extends WorldProvider
{
    public boolean isSurfaceWorld() {
        return true;
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public String getDimensionName() {
        return "Crystallium Plains";
    }
    
    public void registerWorldChunkManager() {
        this.isHellWorld = false;
        this.dimensionId = Dungeons.crystalliumPlainsDimensionId;
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(Dungeons.crystalliumPlainsBiome, (float)this.dimensionId);
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderCrystalliumPlains(this.worldObj, this.worldObj.getSeed(), true);
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
