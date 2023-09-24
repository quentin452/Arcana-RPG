

package com.gibby.dungeon.gen;

import cpw.mods.fml.common.*;
import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.gen.feature.*;

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
        generateNetherStructures(random, chunkX, chunkZ, world, new WorldGenNetherRuins(), 7, 40);
        generateNetherStructures(random, chunkX, chunkZ, world, new WorldGenTallNetherRuins(), 7, 40);
        generateNetherStructures(random, chunkX, chunkZ, world, new WorldGenNetherTower(), 7, 40);
        generateNetherVampireCastle(random, chunkX, chunkZ, world, 15, 55);
    }

    private void generateNetherOre(Random random, int chunkX, int chunkZ, World world, Block oreBlock, int veinSize, int maxHeight, int count) {
        for (int i = 0; i < count; ++i) {
            int coordX = chunkX + random.nextInt(16);
            int coordZ = chunkZ + random.nextInt(16);
            int coordY = random.nextInt(maxHeight);
            new WorldGenNetherMinable(oreBlock, veinSize).generate(world, random, coordX, coordY, coordZ);
        }
    }

    private void generateNetherStructures(Random random, int chunkX, int chunkZ, World world, WorldGenerator generator, int count, int minHeight) {
        for (int i = 0; i < count; ++i) {
            int coordX = chunkX + random.nextInt(16);
            int coordZ = chunkZ + random.nextInt(16);
            int coordY = random.nextInt(50) + minHeight;
            generator.generate(world, random, coordX, coordY, coordZ);
        }
    }

    private void generateNetherVampireCastle(Random random, int chunkX, int chunkZ, World world, int chance, int minHeight) {
        for (int i = 0; i < chance; ++i) {
            int coordX = chunkX + random.nextInt(16);
            int coordZ = chunkZ + random.nextInt(16);
            int coordY = random.nextInt(20) + 55;
            if (world.getBlock(coordX, coordY, coordZ) == Blocks.netherrack && world.getBlock(coordX + 25, coordY, coordZ + 22) == Blocks.netherrack && world.getBlock(coordX, coordY + 1, coordZ) == Blocks.air && world.getBlock(coordX + 25, coordY + 1, coordZ + 22) == Blocks.air && world.getBlock(coordX, coordY + 40, coordZ) == Blocks.air && world.getBlock(coordX + 25, coordY + 40, coordZ + 22) == Blocks.air) {
                new WorldGenVampireCastle().generate(world, random, coordX, coordY, coordZ);
            }
        }
    }
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

        generateStructure(random, chunkX, chunkZ, world, new WorldGenWarlordDungeon(), 100, 60);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenBleachedDungeon(), 100, 60);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenStoneGolemDungeon(), 100, 60);
        generateStructure(random, chunkX, chunkZ, world, new squareruins(), 2, 60);
        generateStructure(random, chunkX, chunkZ, world, new treefortress(), 15, 60);
        generateStructure(random, chunkX, chunkZ, world, new archruins(), 2, 60);
        generateStructure(random, chunkX, chunkZ, world, new SmallCastle(), 2, 60);
        generateStructure(random, chunkX, chunkZ, world, new LargeCastle3(), 1, 55);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenMoundVillage(), 3, 55);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenVoidDungeon(), 130, 60);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenKnightDungeon(), 130, 60);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenObelisk(), 5, 55);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenJungleTemple(), 2, 55);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenTavern(), 2, 55);
        generateStructure(random, chunkX, chunkZ, world, new WorldGenDesertTemple2(), 4, 55);
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
