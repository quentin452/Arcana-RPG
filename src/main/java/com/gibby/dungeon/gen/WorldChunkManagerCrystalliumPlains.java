

package com.gibby.dungeon.gen;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// todo , this isn't used
public class WorldChunkManagerCrystalliumPlains extends WorldChunkManager
{
    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private final BiomeCache biomeCache;
    private final List<BiomeGenBase> biomesToSpawnIn;

    public WorldChunkManagerCrystalliumPlains() {
        this.biomeCache = new BiomeCache(this);
        (this.biomesToSpawnIn = new ArrayList<>()).addAll(WorldChunkManagerCrystalliumPlains.allowedBiomes);
    }

    public WorldChunkManagerCrystalliumPlains(final long seed, final WorldType worldType) {
        this();
        GenLayer[] agenlayer = CrystalliumGenLayer.makeTheWorld(seed);
        agenlayer = this.getModdedBiomeGenerators(worldType, seed, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerCrystalliumPlains(final World world) {
        this(world.getSeed(), world.getWorldInfo().getTerrainType());
    }

    public List<BiomeGenBase> getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenAt(final int x, final int z) {
        return this.biomeCache.getBiomeGenAt(x, z);
    }

    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(final float par1, final int par2) {
        return par1;
    }

    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        IntCache.resetIntCache();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }
        final int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);
        try {
            for (int i = 0; i < par4 * par5; ++i) {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.getBiome(aint[i]);
            }
            return par1ArrayOfBiomeGenBase;
        }
        catch (Throwable throwable) {
            final CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            final CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", par1ArrayOfBiomeGenBase.length);
            crashreportcategory.addCrashSection("x", par2);
            crashreportcategory.addCrashSection("z", par3);
            crashreportcategory.addCrashSection("w", par4);
            crashreportcategory.addCrashSection("h", par5);
            throw new ReportedException(crashreport);
        }
    }

    public BiomeGenBase[] loadBlockGeneratorData(final BiomeGenBase[] oldBiomeList, final int x, final int z, final int width, final int depth) {
        return this.getBiomeGenAt(oldBiomeList, x, z, width, depth, true);
    }

    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse, final int x, final int y, final int width, final int length, final boolean cacheFlag) {
        IntCache.resetIntCache();
        if (listToReuse == null || listToReuse.length < width * length) {
            listToReuse = new BiomeGenBase[width * length];
        }
        if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0x0 && (y & 0xF) == 0x0) {
            final BiomeGenBase[] abiomegenbase1 = this.biomeCache.getCachedBiomes(x, y);
            System.arraycopy(abiomegenbase1, 0, listToReuse, 0, width * length);
            return listToReuse;
        }
        final int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);
        for (int i = 0; i < width * length; ++i) {
            listToReuse[i] = BiomeGenBase.getBiome(aint[i]);
        }
        return listToReuse;
    }

    public boolean areBiomesViable(final int x, final int y, final int z, final List par4List) {
        IntCache.resetIntCache();
        final int l = x - z >> 2;
        final int i1 = y - z >> 2;
        final int j1 = x + z >> 2;
        final int k1 = y + z >> 2;
        final int l2 = j1 - l + 1;
        final int i2 = k1 - i1 + 1;
        final int[] aint = this.genBiomes.getInts(l, i1, l2, i2);
        try {
            for (int j2 = 0; j2 < l2 * i2; ++j2) {
                final BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[j2]);
                if (!par4List.contains(biomegenbase)) {
                    return false;
                }
            }
            return true;
        }
        catch (Throwable throwable) {
            final CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            final CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", x);
            crashreportcategory.addCrashSection("z", y);
            crashreportcategory.addCrashSection("radius", z);
            crashreportcategory.addCrashSection("allowed", par4List);
            throw new ReportedException(crashreport);
        }
    }

    public ChunkPosition findBiomePosition(final int x, final int y, final int z, final List par4List, final Random random) {
        IntCache.resetIntCache();
        final int l = x - z >> 2;
        final int i1 = y - z >> 2;
        final int j1 = x + z >> 2;
        final int k1 = y + z >> 2;
        final int l2 = j1 - l + 1;
        final int i2 = k1 - i1 + 1;
        final int[] aint = this.genBiomes.getInts(l, i1, l2, i2);
        ChunkPosition chunkposition = null;
        int j2 = 0;
        for (int k2 = 0; k2 < l2 * i2; ++k2) {
            final int l3 = l + k2 % l2 << 2;
            final int i3 = i1 + k2 / l2 << 2;
            final BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[k2]);
            if (par4List.contains(biomegenbase) && (chunkposition == null || random.nextInt(j2 + 1) == 0)) {
                chunkposition = new ChunkPosition(l3, 0, i3);
                ++j2;
            }
        }
        return chunkposition;
    }

    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
}
