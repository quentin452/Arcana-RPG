package com.gibby.dungeon.gen;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.common.ChestGenHooks;

import java.util.Random;

public class WorldGenWarlordDungeon extends WorldGenDungeons
{

    public static void chest(final World world, final Random rand, final int x, final int y, final int z, final String chestcontent, final int amount) {
        world.setBlock(x, y, z, Blocks.chest, 0, 2);
        final TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y, z);
        if (tileentitychest != null) {
            WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(chestcontent, rand), tileentitychest, amount);
        }
    }
}
