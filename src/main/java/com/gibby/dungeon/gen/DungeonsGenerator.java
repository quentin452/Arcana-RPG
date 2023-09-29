package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class DungeonsGenerator implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            this.generateSurface(random, chunkX * 16, chunkZ * 16, world);
        }
        if (world.provider.dimensionId == -1) {
            this.generateNether(random, chunkX * 16, chunkZ * 16, world);
        }
    }

    private void generateNether(Random random, int chunkX, int chunkZ, World world) {
        generateNetherOre(random, chunkX, chunkZ, world, Dungeons.lithiumOre, 6, 120, 3);
        generateNetherOre(random, chunkX, chunkZ, world, Dungeons.netherSteelOre, 4, 120, 1);
    }

    private void generateNetherOre(Random random, int chunkX, int chunkZ, World world, Block oreBlock, int veinSize, int maxHeight, int count) {
        for (int i = 0; i < count; ++i) {
            int coordX = chunkX + random.nextInt(16);
            int coordZ = chunkZ + random.nextInt(16);
            int coordY = random.nextInt(maxHeight);
            new WorldGenNetherMinable(oreBlock, veinSize).generate(world, random, coordX, coordY, coordZ);
        }
    }
        Random rand = new Random();
    private void generateSurface(Random random, int chunkX, int chunkZ, World world) {
        for (int i = 0; i < 18; ++i) {
            generateOre(random, chunkX, chunkZ, world, Dungeons.copperore, 8, 60);
        }
        for (int i = 0; i < 7; ++i) {
            generateOre(random, chunkX, chunkZ, world, Dungeons.amazoniteOre, 8, 60);
        }
        for (int i = 0; i < 2; ++i) {
            generateOre(random, chunkX, chunkZ, world, Dungeons.rubyOre, 8, 40);
        }
        for (int i = 0; i < 1; ++i) {
            generateOre(random, chunkX, chunkZ, world, Dungeons.silverOre, 8, 30);
        }
        for (int i = 0; i < 2; ++i) {
            generateOre(random, chunkX, chunkZ, world, Dungeons.bedrockOre, 5, 10);
        }
        for (int i = 0; i < 1; ++i) {
            generateOre(random, chunkX, chunkZ, world, Dungeons.amethystOre, 4, 40);
        }
   //     generateStructure(random, chunkX, chunkZ, world, new WorldGenRuneAltar(), 100, 60);
    }

    private void generateOre(Random random, int chunkX, int chunkZ, World world, Block oreBlock, int veinSize, int maxHeight) {
        int coordX = chunkX + random.nextInt(16);
        int coordZ = chunkZ + random.nextInt(16);
        int coordY = random.nextInt(maxHeight);
        new WorldGenMinable(oreBlock, veinSize).generate(world, random, coordX, coordY, coordZ);
    }
    private void generateStructure(Random random, int chunkX, int chunkZ, World world, WorldGenerator generator, int chance, int minHeight) {
        if (random.nextInt(chance) == 0) {
            int coordX = chunkX + random.nextInt(16);
            int coordZ = chunkZ + random.nextInt(16);
            int coordY = random.nextInt(10) + minHeight;
            generator.generate(world, random, coordX, coordY, coordZ);
        }
    }
}
