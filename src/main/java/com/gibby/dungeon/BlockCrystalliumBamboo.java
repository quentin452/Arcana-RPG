

package com.gibby.dungeon;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.*;

public class BlockCrystalliumBamboo extends BlockReed
{
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Items.stick;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(final World p_149694_1_, final int p_149694_2_, final int p_149694_3_, final int p_149694_4_) {
        return null;
    }
    
    public boolean canPlaceBlockAt(final World p_149742_1_, final int p_149742_2_, final int p_149742_3_, final int p_149742_4_) {
        final Block block = p_149742_1_.getBlock(p_149742_2_, p_149742_3_ - 1, p_149742_4_);
        return block == Dungeons.crystalGrass || block == Dungeons.crystalBamboo;
    }
}
