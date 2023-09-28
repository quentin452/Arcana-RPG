

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;

public class ChunkProviderCrystal implements IChunkProvider
{
    private final Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorPerlin noisePerl;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private final World worldObj;
    private final boolean mapFeaturesEnabled;
    private final WorldType worldType;
    private final double[] noiseArray;
    private final float[] parabolicField;
    private double[] stoneNoise;
    private MapGenBase caveGenerator;
    private MapGenScatteredFeature scatteredFeatureGenerator;
    private MapGenBase ravineGenerator;
    private BiomeGenBase[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    int[][] field_73219_j;

    public ChunkProviderCrystal(final World world, final long seed, final boolean mapFeaturesEnabled) {
        this.stoneNoise = new double[256];
        this.caveGenerator = new MapGenAmethystCaves();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = new MapGenRavine();
        this.field_73219_j = new int[32][32];
        this.caveGenerator = TerrainGen.getModdedMapGen(this.caveGenerator, InitMapGenEvent.EventType.CAVE);
        this.scatteredFeatureGenerator = (MapGenScatteredFeature)TerrainGen.getModdedMapGen(this.scatteredFeatureGenerator, InitMapGenEvent.EventType.SCATTERED_FEATURE);
        this.ravineGenerator = TerrainGen.getModdedMapGen(this.ravineGenerator, InitMapGenEvent.EventType.RAVINE);
        this.worldObj = world;
        this.mapFeaturesEnabled = mapFeaturesEnabled;
        this.worldType = world.getWorldInfo().getTerrainType();
        this.rand = new Random(seed);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseArray = new double[825];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                final float f = 10.0f / MathHelper.sqrt_float(j * j + k * k + 0.2f);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }
        NoiseGenerator[] noiseGens = { this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noisePerl, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise };
        noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
        this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
    }

    public void func_147424_a(final int par1, final int par2, final Block[] blocks) {
        final byte b0 = 63;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, par1 * 16, par2 * 16, 16, 16);
        this.func_147423_a(par1 * 4, 0, par2 * 4);
        for (int k = 0; k < 4; ++k) {
            final int l = k * 5;
            final int i1 = (k + 1) * 5;
            for (int j1 = 0; j1 < 4; ++j1) {
                final int k2 = (l + j1) * 33;
                final int l2 = (l + j1 + 1) * 33;
                final int i2 = (i1 + j1) * 33;
                final int j2 = (i1 + j1 + 1) * 33;
                for (int k3 = 0; k3 < 32; ++k3) {
                    final double d0 = 0.125;
                    double d2 = this.noiseArray[k2 + k3];
                    double d3 = this.noiseArray[l2 + k3];
                    double d4 = this.noiseArray[i2 + k3];
                    double d5 = this.noiseArray[j2 + k3];
                    final double d6 = (this.noiseArray[k2 + k3 + 1] - d2) * d0;
                    final double d7 = (this.noiseArray[l2 + k3 + 1] - d3) * d0;
                    final double d8 = (this.noiseArray[i2 + k3 + 1] - d4) * d0;
                    final double d9 = (this.noiseArray[j2 + k3 + 1] - d5) * d0;
                    for (int l3 = 0; l3 < 8; ++l3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | j1 * 4 << 8 | k3 * 8 + l3;
                            final short short1 = 256;
                            j3 -= short1;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d17 += d16) > 0.0) {
                                    blocks[j3 += short1] = Dungeons.amethystStone;
                                }
                                else if (k3 * 8 + l3 < b0) {
                                    blocks[j3 += short1] = Blocks.lava;
                                }
                                else {
                                    blocks[j3 += short1] = null;
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(final int p_147422_1_, final int p_147422_2_, final Block[] p_147422_3_, final byte[] p_147422_4_, final BiomeGenBase[] p_147422_5_) {
        final ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_147422_1_, p_147422_2_, p_147422_3_, p_147422_5_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        final double d0 = 0.03125;
        this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, p_147422_1_ * 16, p_147422_2_ * 16, 16, 16, d0 * 2.0, d0 * 2.0, 1.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                final BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
                if (biomegenbase instanceof BiomeCrystal) {
                    ((BiomeCrystal)biomegenbase).genCrystalliumBiomeTerrain(this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
                }
            }
        }
    }

    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(final int par1, final int par2) {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[65536];
        final byte[] abyte = new byte[65536];
        this.func_147424_a(par1, par2, ablock);
        this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, par1 * 16, par2 * 16, 16, 16));
        this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        if (this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        }
        final Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        final byte[] abyte2 = chunk.getBiomeArray();
        for (int k = 0; k < abyte2.length; ++k) {
            abyte2[k] = (byte)this.biomesForGeneration[k].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    private void func_147423_a(final int p_147423_1_, final int p_147423_2_, final int p_147423_3_) {
        this.noise5 = this.noiseGen6.generateNoiseOctaves(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0, 200.0, 0.5);
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        int l = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < 5; ++j1) {
            for (int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                final byte b0 = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
                for (int l2 = -b0; l2 <= b0; ++l2) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[j1 + l2 + 2 + (k1 + i2 + 2) * 10];
                        float f4 = biomegenbase2.rootHeight;
                        float f5 = biomegenbase2.heightVariation;
                        if (this.worldType == WorldType.AMPLIFIED && f4 > 0.0f) {
                            f4 = 1.0f + f4 * 2.0f;
                            f5 = 1.0f + f5 * 4.0f;
                        }
                        float f6 = this.parabolicField[l2 + 2 + (i2 + 2) * 5] / (f4 + 2.0f);
                        if (biomegenbase2.rootHeight > biomegenbase.rootHeight) {
                            f6 /= 2.0f;
                        }
                        f += f5 * f6;
                        f2 += f4 * f6;
                        f3 += f6;
                    }
                }
                f /= f3;
                f2 /= f3;
                f = f * 0.9f + 0.1f;
                f2 = (f2 * 4.0f - 1.0f) / 8.0f;
                double d12 = this.noise5[i1] / 8000.0;
                if (d12 < 0.0) {
                    d12 = -d12 * 0.3;
                }
                d12 = d12 * 3.0 - 2.0;
                if (d12 < 0.0) {
                    d12 /= 2.0;
                    if (d12 < -1.0) {
                        d12 = -1.0;
                    }
                    d12 /= 1.4;
                    d12 /= 2.0;
                }
                else {
                    if (d12 > 1.0) {
                        d12 = 1.0;
                    }
                    d12 /= 8.0;
                }
                ++i1;
                double d13 = f2;
                final double d14 = f;
                d13 += d12 * 0.2;
                d13 = d13 * 8.5 / 8.0;
                final double d15 = 8.5 + d13 * 4.0;
                for (int j2 = 0; j2 < 33; ++j2) {
                    double d16 = (j2 - d15) * 12.0 * 128.0 / 256.0 / d14;
                    if (d16 < 0.0) {
                        d16 *= 4.0;
                    }
                    final double d17 = this.noise1[l] / 512.0;
                    final double d18 = this.noise2[l] / 512.0;
                    final double d19 = (this.noise3[l] / 10.0 + 1.0) / 2.0;
                    double d20 = MathHelper.denormalizeClamp(d17, d18, d19) - d16;
                    if (j2 > 29) {
                        final double d21 = (j2 - 29) / 3.0f;
                        d20 = d20 * (1.0 - d21) + -10.0 * d21;
                    }
                    this.noiseArray[l] = d20;
                    ++l;
                }
            }
        }
    }

    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }

    public void populate(final IChunkProvider par1IChunkProvider, final int par2, final int par3) {
        BlockFalling.fallInstantly = true;
        final int k = par2 * 16;
        final int l = par3 * 16;
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
        final boolean flag = false;
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
        if (this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
        }
        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
            final int k2 = k + this.rand.nextInt(16) + 8;
            final int l2 = this.rand.nextInt(256);
            final int i2 = l + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.lava).generate(this.worldObj, this.rand, k2, l2, i2);
        }
        int k2;
        int l2;
        int i2;
        boolean doGen;
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 20L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(60) + 60;
            new WorldGenCrystalFoliage().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 12L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(60);
            new WorldGenCaveMushrooms().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 5L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(60);
            new WorldGenDownwardSpike(Dungeons.amethystCracks, this.rand.nextInt(5)).generate(this.worldObj, this.rand, k2, i2, l2);
        }
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 5L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(60) + 60;
            new WorldGenCrystalBamboo().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 100L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(80);
            new WorldGenCrystalMinable(Dungeons.amethystCrystalized, 10).generate(this.worldObj, this.rand, k2, i2, l2);
        }
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 4L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(80);
            new WorldGenCrystalMinable(Dungeons.voidrockOre, 8).generate(this.worldObj, this.rand, k2, i2, l2);
        }
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM), i1 = 0L; doGen && i1 < 1L; ++i1) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(60);
            new WorldGenCrystalMinable(Dungeons.crystalOre, 8).generate(this.worldObj, this.rand, k2, i2, l2);
        }
        doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM);
        if (this.rand.nextInt(80) == 0) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(5) + 60;
            new WorldGenAmethystRuins().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM);
        if (this.rand.nextInt(60) == 0) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(5) + 60;
            new WorldGenGhostWitherTower().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM);
        if (this.rand.nextInt(1000) == 0) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(20) + 120;
            new WorldGenCrystalliumVillage().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM);
        if (this.rand.nextInt(60) == 0) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(5) + 60;
            new WorldGenCrystalHouse().generate(this.worldObj, this.rand, k2, i2, l2);
        }
        doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, false, PopulateChunkEvent.Populate.EventType.CUSTOM);
        if (this.rand.nextInt(2) == 0) {
            k2 = k + this.rand.nextInt(16);
            l2 = l + this.rand.nextInt(16);
            i2 = this.rand.nextInt(50) + 60;
            new WorldGenUpwardSpike(this.rand.nextInt(12) + 3).generate(this.worldObj, this.rand, k2, i2, l2);
        }
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
        BlockFalling.fallInstantly = false;
    }

    public boolean saveChunks(final boolean par1, final IProgressUpdate par2IProgressUpdate) {
        return true;
    }

    public void saveExtraData() {
    }

    public boolean unloadQueuedChunks() {
        return false;
    }

    public boolean canSave() {
        return true;
    }

    public String makeString() {
        return "RandomLevelSource";
    }

    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3, final int par4) {
        return Dungeons.crystal.getSpawnableList(par1EnumCreatureType);
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(final int par1, final int par2) {
        if (this.mapFeaturesEnabled) {}
    }

    public ChunkPosition func_147416_a(final World world, final String arg1, final int arg2, final int arg3, final int arg4) {
        return null;
    }
}
