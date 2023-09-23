

package com.gibby.dungeon.gen;

import net.minecraft.world.biome.*;
import com.gibby.dungeon.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;

public class BiomeCrystal extends BiomeGenBase
{
    public BiomeCrystal(final int par1) {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.setBiomeName("Crystallium Spikes");
        this.topBlock = Dungeons.amethystCrystalized;
        this.fillerBlock = Dungeons.amethystCrystalized;
        this.rootHeight = 0.0f;
        this.heightVariation = 0.7f;
    }
    
    public void genCrystalliumBiomeTerrain(final World p_150560_1_, final Random p_150560_2_, final Block[] p_150560_3_, final byte[] p_150560_4_, final int p_150560_5_, final int p_150560_6_, final double p_150560_7_) {
        final boolean flag = true;
        Block block = Dungeons.crystalGrass;
        byte b0 = (byte)(this.field_150604_aj & 0xFF);
        Block block2 = Dungeons.crystalDirt;
        int k = -1;
        final int l = (int)(p_150560_7_ / 3.0 + 3.0 + p_150560_2_.nextDouble() * 0.25);
        final int i1 = p_150560_5_ & 0xF;
        final int j1 = p_150560_6_ & 0xF;
        final int k2 = p_150560_3_.length / 256;
        for (int l2 = 255; l2 >= 0; --l2) {
            final int i2 = (j1 * 16 + i1) * k2 + l2;
            if (l2 <= 0 + p_150560_2_.nextInt(5)) {
                p_150560_3_[i2] = Blocks.bedrock;
            }
            else {
                final Block block3 = p_150560_3_[i2];
                if (block3 != null && block3.getMaterial() != Material.air) {
                    if (block3 == Dungeons.amethystStone) {
                        if (k == -1) {
                            if (l <= 0) {
                                block = null;
                                b0 = 0;
                                block2 = Dungeons.amethystStone;
                            }
                            else if (l2 >= 59 && l2 <= 64) {
                                block = Dungeons.crystalGrass;
                                b0 = (byte)(this.field_150604_aj & 0xFF);
                                block2 = Dungeons.crystalDirt;
                            }
                            if (l2 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (this.getFloatTemperature(p_150560_5_, l2, p_150560_6_) < 0.15f) {
                                    block = Blocks.ice;
                                    b0 = 0;
                                }
                                else {
                                    block = Blocks.lava;
                                    b0 = 0;
                                }
                            }
                            k = l;
                            if (l2 >= 62) {
                                p_150560_3_[i2] = block;
                                p_150560_4_[i2] = b0;
                            }
                            else if (l2 < 56 - l) {
                                block = null;
                                block2 = Dungeons.amethystStone;
                                p_150560_3_[i2] = Dungeons.amethystStone;
                            }
                            else {
                                p_150560_3_[i2] = block2;
                            }
                        }
                        else if (k > 0) {
                            --k;
                            p_150560_3_[i2] = block2;
                            if (k == 0 && block2 == Dungeons.amethystStone) {
                                k = p_150560_2_.nextInt(4) + Math.max(0, l2 - 63);
                                block2 = Dungeons.amethystStone;
                            }
                        }
                    }
                }
                else {
                    k = -1;
                }
            }
        }
    }
}
