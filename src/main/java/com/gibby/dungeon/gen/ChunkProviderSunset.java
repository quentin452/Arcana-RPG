

package com.gibby.dungeon.gen;

import net.minecraft.world.gen.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.block.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;

public class ChunkProviderSunset implements IChunkProvider
{
    private Random hellRNG;
    private NoiseGeneratorOctaves netherNoiseGen1;
    private NoiseGeneratorOctaves netherNoiseGen2;
    private NoiseGeneratorOctaves netherNoiseGen3;
    public NoiseGeneratorOctaves netherNoiseGen6;
    public NoiseGeneratorOctaves netherNoiseGen7;
    private World worldObj;
    private double[] noiseField;
    private double[] noiseField2;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;
    
    public ChunkProviderSunset(final World par1World, final long par2) {
        this.worldObj = par1World;
        this.hellRNG = new Random(par2);
        this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
        this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
        this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        NoiseGenerator[] noiseGens = { (NoiseGenerator)this.netherNoiseGen1, (NoiseGenerator)this.netherNoiseGen2, (NoiseGenerator)this.netherNoiseGen3, (NoiseGenerator)this.netherNoiseGen6, (NoiseGenerator)this.netherNoiseGen7 };
        noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.hellRNG, noiseGens);
        this.netherNoiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.netherNoiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.netherNoiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.netherNoiseGen6 = (NoiseGeneratorOctaves)noiseGens[4];
    }
    
    public void func_147419_a(final int p_147419_1_, final int p_147419_2_, final Block[] p_147419_3_) {
        final byte b0 = 4;
        final byte b2 = 32;
        final int k = b0 + 1;
        final byte b3 = 17;
        final int l = b0 + 1;
        this.noiseField = this.initializeNoiseField(this.noiseField, p_147419_1_ * b0, 15, p_147419_2_ * b0, k, b3, l);
        final Random rand = new Random();
        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k2 = 0; k2 < 16; ++k2) {
                    final double d0 = 0.125;
                    double d2 = this.noiseField[((i1 + 0) * l + j1 + 0) * b3 + k2 + 0];
                    double d3 = this.noiseField[((i1 + 0) * l + j1 + 1) * b3 + k2 + 0];
                    double d4 = this.noiseField[((i1 + 1) * l + j1 + 0) * b3 + k2 + 0];
                    double d5 = this.noiseField[((i1 + 1) * l + j1 + 1) * b3 + k2 + 0];
                    final double d6 = (this.noiseField[((i1 + 0) * l + j1 + 0) * b3 + k2 + 1] - d2) * d0;
                    final double d7 = (this.noiseField[((i1 + 0) * l + j1 + 1) * b3 + k2 + 1] - d3) * d0;
                    final double d8 = (this.noiseField[((i1 + 1) * l + j1 + 0) * b3 + k2 + 1] - d4) * d0;
                    final double d9 = (this.noiseField[((i1 + 1) * l + j1 + 1) * b3 + k2 + 1] - d5) * d0;
                    for (int l2 = 0; l2 < 8; ++l2) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i2 = 0; i2 < 4; ++i2) {
                            int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k2 * 8 + l2;
                            final short short1 = 128;
                            final double d15 = 0.25;
                            double d16 = d11;
                            final double d17 = (d12 - d11) * d15;
                            for (int k3 = 0; k3 < 4; ++k3) {
                                Block block;
                                if (rand.nextInt(3) == 0) {
                                    block = Blocks.air;
                                }
                                else {
                                    block = Blocks.air;
                                }
                                if (k2 * 8 + l2 < b2) {
                                    block = null;
                                }
                                if (d16 > 0.1) {
                                    block = null;
                                }
                                p_147419_3_[j2] = block;
                                j2 += short1;
                                d16 += d17;
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
    
    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }
    
    public Chunk provideChunk(final int par1, final int par2) {
        this.hellRNG.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[65536];
        this.func_147419_a(par1, par2, ablock);
        final Chunk chunk = new Chunk(this.worldObj, ablock, par1, par2);
        final BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[])null, par1 * 16, par2 * 16, 16, 16);
        final byte[] abyte = chunk.getBiomeArray();
        for (int k = 0; k < abyte.length; ++k) {
            abyte[k] = (byte)abiomegenbase[k].biomeID;
        }
        chunk.resetRelightChecks();
        return chunk;
    }
    
    private double[] initializeNoiseField(double[] par1ArrayOfDouble, final int par2, final int par3, final int par4, final int par5, final int par6, final int par7) {
        final ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField((IChunkProvider)this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return event.noisefield;
        }
        if (par1ArrayOfDouble == null) {
            par1ArrayOfDouble = new double[par5 * par6 * par7];
        }
        final double d0 = 684.412;
        final double d2 = 2053.236;
        this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, par2, par3, par4, par5, 1, par7, 1.0, 0.0, 1.0);
        this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, par2, par3, par4, par5, 1, par7, 100.0, 0.0, 100.0);
        this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, par2, par3, par4, par5, par6, par7, d0 / 80.0, d2 / 60.0, d0 / 80.0);
        this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, par2, par3, par4, par5, par6, par7, d0, d2, d0);
        this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, par2, par3, par4, par5, par6, par7, d0, d2, d0);
        int k1 = 0;
        int l1 = 0;
        final double[] adouble1 = new double[par6];
        for (int i2 = 0; i2 < par6; ++i2) {
            adouble1[i2] = Math.cos(i2 * 3.141592653589793 * 6.0 / par6) * 2.0;
            double d3 = i2;
            if (i2 > par6 / 2) {
                d3 = par6 - 1 - i2;
            }
            if (d3 < 4.0) {
                d3 = 4.0 - d3;
                final double[] array = adouble1;
                final int n = i2;
                array[n] -= d3 * d3 * d3 * 10.0;
            }
        }
        for (int i2 = 0; i2 < par5; ++i2) {
            for (int k2 = 0; k2 < par7; ++k2) {
                double d4 = (this.noiseData4[l1] + 256.0) / 512.0;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                final double d5 = 0.0;
                double d6 = this.noiseData5[l1] / 8000.0;
                if (d6 < 0.0) {
                    d6 = -d6;
                }
                d6 = d6 * 3.0 - 3.0;
                if (d6 < 0.0) {
                    d6 /= 2.0;
                    if (d6 < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                    d4 = 0.0;
                }
                else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 6.0;
                }
                d4 += 0.5;
                d6 = d6 * par6 / 16.0;
                ++l1;
                for (int j2 = 0; j2 < par6; ++j2) {
                    double d7 = 0.0;
                    final double d8 = adouble1[j2];
                    final double d9 = this.noiseData2[k1] / 512.0;
                    final double d10 = this.noiseData3[k1] / 512.0;
                    final double d11 = (this.noiseData1[k1] / 10.0 + 1.0) / 2.0;
                    if (d11 < 0.0) {
                        d7 = d9;
                    }
                    else if (d11 > 1.0) {
                        d7 = d10;
                    }
                    else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= d8;
                    if (j2 > par6 - 4) {
                        final double d12 = (j2 - (par6 - 4)) / 3.0f;
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    if (j2 < d5) {
                        double d12 = (d5 - j2) / 4.0;
                        if (d12 < 0.0) {
                            d12 = 0.0;
                        }
                        if (d12 > 1.0) {
                            d12 = 1.0;
                        }
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    par1ArrayOfDouble[k1] = d7;
                    ++k1;
                }
            }
        }
        return par1ArrayOfDouble;
    }
    
    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }
    
    public void populate(final IChunkProvider par1IChunkProvider, final int par2, final int par3) {
        BlockFalling.fallInstantly = true;
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.hellRNG, par2, par3, false));
        final int k = par2 * 16;
        final int l = par3 * 16;
        MinecraftForge.EVENT_BUS.post((Event)new DecorateBiomeEvent.Post(this.worldObj, this.hellRNG, k, l));
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.hellRNG, par2, par3, false));
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
        return "IceRandomLevelSource";
    }
    
    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3, final int par4) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        return biomegenbase.getSpawnableList(par1EnumCreatureType);
    }
    
    public ChunkPosition func_147416_a(final World p_147416_1_, final String p_147416_2_, final int p_147416_3_, final int p_147416_4_, final int p_147416_5_) {
        return null;
    }
    
    public void recreateStructures(final int par1, final int par2) {
    }
    
    public int getLoadedChunkCount() {
        return 0;
    }
}
