

package com.gibby.dungeon.gen;

import cpw.mods.fml.common.*;
import java.util.*;
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
            this.GenerateSurface(random, chunkX * 16, chunkZ * 16, world);
        }
        if (world.provider.dimensionId == -1) {
            this.GenerateNether(random, chunkX * 16, chunkZ * 16, world);
        }
    }

    private void GenerateNether(final Random random, final int chunkX, final int chunkZ, final World world) {
        for (int i = 0; i < 3; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(120);
            new WorldGenNetherMinable(Dungeons.lithiumOre, 6).generate(world, random, coordX, coordY, coordZ);
        }
        final int coordX2 = chunkX + random.nextInt(16);
        final int coordZ2 = chunkZ + random.nextInt(16);
        final int coordY2 = random.nextInt(120);
        new WorldGenNetherMinable(Dungeons.netherSteelOre, 4).generate(world, random, coordX2, coordY2, coordZ2);
        for (int i = 0; i < 7; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(50) + 40;
            new WorldGenNetherRuins().generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 7; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(50) + 40;
            new WorldGenTallNetherRuins().generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 7; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(50) + 40;
            new WorldGenNetherTower().generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 15; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(20) + 55;
            if (world.getBlock(coordX, coordY, coordZ) == Blocks.netherrack && world.getBlock(coordX + 25, coordY, coordZ + 22) == Blocks.netherrack && world.getBlock(coordX, coordY + 1, coordZ) == Blocks.air && world.getBlock(coordX + 25, coordY + 1, coordZ + 22) == Blocks.air && world.getBlock(coordX, coordY + 40, coordZ) == Blocks.air && world.getBlock(coordX + 25, coordY + 40, coordZ + 22) == Blocks.air) {
                new WorldGenVampireCastle().generate(world, random, coordX, coordY, coordZ);
            }
        }
    }

    private void GenerateSurface(final Random random, final int chunkX, final int chunkZ, final World world) {
        for (int i = 0; i < 18; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(60);
            new WorldGenMinable(Dungeons.copperore, 8).generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 7; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(60);
            new WorldGenMinable(Dungeons.amazoniteOre, 8).generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 2; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(40);
            new WorldGenMinable(Dungeons.rubyOre, 8).generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 1; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(30);
            new WorldGenMinable(Dungeons.silverOre, 8).generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 2; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(10);
            new WorldGenMinable(Dungeons.bedrockOre, 5).generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 1; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(40);
            new WorldGenMinable(Dungeons.amethystOre, 4).generate(world, random, coordX, coordY, coordZ);
        }
        if (random.nextInt(100) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new WorldGenWarlordDungeon().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(100) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new WorldGenBleachedDungeon().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(100) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new WorldGenStoneGolemDungeon().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(2) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new squareruins().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(15) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new treefortress().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(2) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new archruins().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(2) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(15) + 60;
            new SmallCastle().generate(world, random, coordX2, coordY2, coordZ2);
        }
        for (int i = 0; i < 1; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(15) + 55;
            new LargeCastle3().generate(world, random, coordX, coordY, coordZ);
        }
        for (int i = 0; i < 3; ++i) {
            final int coordX = chunkX + random.nextInt(16);
            final int coordZ = chunkZ + random.nextInt(16);
            final int coordY = random.nextInt(15) + 55;
            new WorldGenMoundVillage().generate(world, random, coordX, coordY, coordZ);
        }
        if (random.nextInt(130) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new WorldGenVoidDungeon().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(130) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(10) + 60;
            new WorldGenKnightDungeon().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(5) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(15) + 55;
            new WorldGenObelisk().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(2) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(15) + 55;
            new WorldGenJungleTemple().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(2) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(15) + 55;
            new WorldGenTavern().generate(world, random, coordX2, coordY2, coordZ2);
        }
        if (random.nextInt(4) == 0) {
            final int coordX2 = chunkX + random.nextInt(16);
            final int coordZ2 = chunkZ + random.nextInt(16);
            final int coordY2 = random.nextInt(15) + 55;
            new WorldGenDesertTemple2().generate(world, random, coordX2, coordY2, coordZ2);
        }
    }
}
