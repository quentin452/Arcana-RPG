

package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class BiomeCrystalliumPlains extends BiomeGenBase
{
    public BiomeCrystalliumPlains(final int par1) {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.setBiomeName("Crystallium Plains");
        this.topBlock = Dungeons.crystalliumGrass;
        this.fillerBlock = Dungeons.crystalliumDirt;
        this.rootHeight = -0.2f;
        this.heightVariation = 0.3f;
    }

    public void genCrystalliumBiomeTerrain(final Random p_150560_2_, final Block[] p_150560_3_, final byte[] p_150560_4_, final int p_150560_5_, final int p_150560_6_, final double p_150560_7_) {
        Block block = Dungeons.crystalliumGrass;
        byte b0 = (byte)(this.field_150604_aj & 0xFF);
        Block block2 = Dungeons.crystalliumDirt;
        int k = -1;
        final int l = (int)(p_150560_7_ / 3.0 + 3.0 + p_150560_2_.nextDouble() * 0.25);
        final int i1 = p_150560_5_ & 0xF;
        final int j1 = p_150560_6_ & 0xF;
        final int k2 = p_150560_3_.length / 256;
        for (int l2 = 255; l2 >= 0; --l2) {
            final int i2 = (j1 * 16 + i1) * k2 + l2;
            if (l2 <= p_150560_2_.nextInt(5)) {
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
                                block = Dungeons.crystalliumGrass;
                                b0 = (byte)(this.field_150604_aj & 0xFF);
                                block2 = Dungeons.crystalliumDirt;
                            }
                            if (l2 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (this.getFloatTemperature(p_150560_5_, l2, p_150560_6_) < 0.15f) {
                                    block = Blocks.ice;
                                    b0 = 0;
                                }
                                else {
                                    block = Blocks.water;
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
                                block2 = Dungeons.amethystCrystalized;
                                p_150560_3_[i2] = Dungeons.amethystCrystalized;
                            }
                            else {
                                p_150560_3_[i2] = block2;
                            }
                        }
                        else if (k > 0) {
                            --k;
                            p_150560_3_[i2] = block2;
                            if (k == 0 && block2 == Dungeons.amethystCrystalized) {
                                k = p_150560_2_.nextInt(4) + Math.max(0, l2 - 63);
                                block2 = Dungeons.amethystCrystalized;
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
