

package com.gibby.dungeon.gen;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;

public class ChunkProviderSunset implements IChunkProvider
{
    private final Random hellRNG;
    private NoiseGeneratorOctaves netherNoiseGen1;
    private NoiseGeneratorOctaves netherNoiseGen2;
    private NoiseGeneratorOctaves netherNoiseGen3;
    public NoiseGeneratorOctaves netherNoiseGen6;
    public NoiseGeneratorOctaves netherNoiseGen7;
    private final World worldObj;
    private double[] noiseField;
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
        NoiseGenerator[] noiseGens = { this.netherNoiseGen1, this.netherNoiseGen2, this.netherNoiseGen3, this.netherNoiseGen6, this.netherNoiseGen7 };
        noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.hellRNG, noiseGens);
        this.netherNoiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.netherNoiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.netherNoiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.netherNoiseGen6 = (NoiseGeneratorOctaves)noiseGens[4];
    }

    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(final int par1, final int par2) {
        this.hellRNG.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[65536];
        final Chunk chunk = new Chunk(this.worldObj, ablock, par1, par2);
        final BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, par1 * 16, par2 * 16, 16, 16);
        final byte[] abyte = chunk.getBiomeArray();
        for (int k = 0; k < abyte.length; ++k) {
            abyte[k] = (byte)abiomegenbase[k].biomeID;
        }
        chunk.resetRelightChecks();
        return chunk;
    }

    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }

    public void populate(final IChunkProvider par1IChunkProvider, final int par2, final int par3) {
        BlockFalling.fallInstantly = true;
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.hellRNG, par2, par3, false));
        final int k = par2 * 16;
        final int l = par3 * 16;
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.worldObj, this.hellRNG, k, l));
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.hellRNG, par2, par3, false));
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
