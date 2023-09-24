

package com.gibby.dungeon.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import com.gibby.dungeon.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.common.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;

public class WorldGenBleachedDungeon extends WorldGenDungeons
{
    public boolean generate(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.getBlock(x, y - 3, z) == Blocks.dirt && world.getBlock(x, y, z) == Blocks.air) {
            for (int X = 0; X < 10; ++X) {
                for (int Z = 0; Z < 10; ++Z) {
                    for (int Y = 0; Y < y + 5; ++Y) {
                        world.setBlockToAir(x + X, y - Y + 10, z + Z);
                    }
                }
            }
            int baseY = 0;
            do {
                for (int X2 = 0; X2 < 10; ++X2) {
                    for (int Z2 = 0; Z2 < 10; ++Z2) {
                        world.setBlock(x + X2, y + baseY + 5, z + Z2, Dungeons.bleachedStone);
                    }
                }
                for (int X2 = 0; X2 < 10; ++X2) {
                    for (int Z2 = 0; Z2 < 10; ++Z2) {
                        world.setBlock(x + X2, y + baseY, z + Z2, Dungeons.bleachedStone);
                    }
                }
                for (int X2 = -1; X2 < 11; ++X2) {
                    int counter = 0;
                    if (counter % 5 == 0) {
                        world.setBlock(x + X2, y + 11, z - 1, Dungeons.bleachedStone);
                    }
                    ++counter;
                    for (int Y2 = 0; Y2 < 11; ++Y2) {
                        world.setBlock(x + X2, y + Y2 + baseY, z - 1, Dungeons.bleachedStone);
                    }
                }
                for (int Y3 = 0; Y3 < 11; ++Y3) {
                    for (int Z2 = -1; Z2 < 11; ++Z2) {
                        world.setBlock(x - 1, y + Y3 + baseY, z + Z2, Dungeons.bleachedStone);
                        int counter2 = 0;
                        if (counter2 % 5 == 0) {
                            world.setBlock(x - 1, y + 11, z + Z2, Dungeons.bleachedStone);
                        }
                        ++counter2;
                    }
                }
                for (int X2 = 0; X2 < 10; ++X2) {
                    for (int Z2 = 0; Z2 < 10; ++Z2) {
                        world.setBlock(x + X2, y + 10 + baseY, z + Z2, Dungeons.bleachedStone);
                    }
                }
                for (int X2 = -1; X2 < 11; ++X2) {
                    int counter = 0;
                    if (counter % 5 == 0) {
                        world.setBlock(x + X2, y + 11, z + 10, Dungeons.bleachedStone);
                    }
                    ++counter;
                    for (int Y2 = 0; Y2 < 11; ++Y2) {
                        world.setBlock(x + X2, y + Y2 + baseY, z + 10, Dungeons.bleachedStone);
                    }
                }
                for (int Y3 = 0; Y3 < 11; ++Y3) {
                    for (int Z2 = -1; Z2 < 11; ++Z2) {
                        world.setBlock(x + 10, y + Y3 + baseY, z + Z2, Dungeons.bleachedStone);
                        int counter2 = 0;
                        if (counter2 % 5 == 0) {
                            world.setBlock(x + 10, y + 11, z + Z2, Dungeons.bleachedStone);
                        }
                        ++counter2;
                    }
                }
                if (baseY != 0) {
                    stairs(world, x, y + baseY + 11, z, Blocks.stone_brick_stairs, Dungeons.bleachedStone, 6, 1);
                }
                stairs(world, x + 8, y + baseY + 6, z, Blocks.stone_brick_stairs, Dungeons.bleachedStone, 6, 1);
                chest(world, rand, x, y + baseY + 6, z + 1, "dungeonChest", rand.nextInt(10) + 1);
                Dungeons.spawnerRepeater(world, x + 6, y + baseY + 6, z + 6, 10, 2, 350);
                Dungeons.spawnerRepeater(world, x + 6, y + baseY + 1, z + 6, 17, 2, 350);
                baseY -= 10;
            } while (world.getBlock(x, y + baseY, z) == Blocks.air && baseY > -70);
            for (int X2 = 0; X2 < 4; ++X2) {
                for (int Y = 0; Y < 4; ++Y) {
                    world.setBlockToAir(x + X2, y + Y + 1, z + 10);
                }
            }
            for (int X2 = 0; X2 < 31; ++X2) {
                for (int Z2 = 0; Z2 < 31; ++Z2) {
                    for (int Y2 = 0; Y2 < 20; ++Y2) {
                        world.setBlockToAir(x + X2, y + Y2 + baseY + 10, z + Z2 + 10);
                    }
                }
            }
            for (int X2 = 0; X2 < 30; ++X2) {
                for (int Z2 = 0; Z2 < 30; ++Z2) {
                    world.setBlock(x + X2, y + baseY + 10, z + Z2 + 11, Dungeons.bleachedStone);
                }
            }
            for (int X2 = 0; X2 < 30; ++X2) {
                for (int Y = 0; Y < 20; ++Y) {
                    world.setBlock(x + X2, y + Y + baseY + 10, z - 1 + 11, Dungeons.bleachedStone);
                }
            }
            for (int Y3 = 0; Y3 < 20; ++Y3) {
                for (int Z2 = 0; Z2 < 30; ++Z2) {
                    world.setBlock(x + 30, y + Y3 + baseY + 10, z + Z2 + 11, Dungeons.bleachedStone);
                }
            }
            for (int X2 = 0; X2 < 30; ++X2) {
                for (int Z2 = 0; Z2 < 30; ++Z2) {
                    world.setBlock(x + X2, y + 20 + baseY + 10, z + Z2 + 11, Dungeons.bleachedStone);
                }
            }
            for (int X2 = 0; X2 < 30; ++X2) {
                for (int Y = 0; Y < 20; ++Y) {
                    world.setBlock(x + X2, y + Y + baseY + 10, z + 30 + 11, Dungeons.bleachedStone);
                }
            }
            for (int Y3 = 0; Y3 < 20; ++Y3) {
                for (int Z2 = 0; Z2 < 30; ++Z2) {
                    world.setBlock(x - 1, y + Y3 + baseY + 10, z + Z2 + 11, Dungeons.bleachedStone);
                }
            }
            for (int X2 = 0; X2 < 4; ++X2) {
                for (int Y = 0; Y < 4; ++Y) {
                    world.setBlockToAir(x + X2, y + Y + baseY + 11, z + 10);
                }
            }
            Dungeons.spawner(world, x + 25, y + baseY + 13, z + 25, 20, 1);
            for (int X2 = 0; X2 < 3; ++X2) {
                for (int Z2 = 0; Z2 < 3; ++Z2) {
                    world.setBlock(x + 24 + X2, y + baseY + 11, z + 24 + Z2, Blocks.glowstone);
                }
            }
            WorldGenWarlordDungeon.chest(world, rand, x + 25, y + baseY + 12, z + 25, "VoidDungeon", 10);
            return true;
        }
        return false;
    }
    
    public static void stairs(final World world, final int x, final int y, final int z, final Block stairs, final Block stairbottoms, final int duration, final int width) {
        for (int Z = 2; Z <= duration; ++Z) {
            for (int X = 0; X <= width; ++X) {
                world.setBlockToAir(x + X, y - 1, z + Z - 2);
            }
        }
        for (int Z = 2; Z <= duration; ++Z) {
            for (int X = 0; X <= width; ++X) {
                for (int Y = -1; Y >= -duration; --Y) {
                    if (Y - 1 == Z * -1) {
                        world.setBlock(x + X, y + Y - 1, z + Z - 2, stairbottoms);
                    }
                }
            }
        }
        for (int Z = 2; Z <= duration; ++Z) {
            for (int X = 0; X <= width; ++X) {
                for (int Y = -1; Y >= -duration; --Y) {
                    if (Y - 1 == Z * -1) {
                        world.setBlock(x + X, y + Y, z + Z - 2, stairs, 3, 2);
                    }
                }
            }
        }
    }
    
    public static void chest(final World world, final Random rand, final int x, final int y, final int z, final String chestcontent, final int amount) {
        world.setBlock(x, y, z, Blocks.chest, 0, 2);
        final TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y, z);
        if (tileentitychest != null) {
            WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(chestcontent, rand), (IInventory)tileentitychest, amount);
        }
    }
}
