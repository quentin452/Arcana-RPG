

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

public class WorldGenStoneGolemDungeon extends WorldGenDungeons
{

    public static void chest(final World world, final Random rand, final int x, final int y, final int z, final String chestcontent, final int amount) {
        world.setBlock(x, y, z, Blocks.chest, 0, 2);
        final TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y, z);
        if (tileentitychest != null) {
            WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(chestcontent, rand), (IInventory)tileentitychest, amount);
        }
    }
}
