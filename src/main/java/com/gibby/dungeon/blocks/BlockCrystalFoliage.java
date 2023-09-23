

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.gibby.dungeon.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockCrystalFoliage extends Block
{
    public BlockCrystalFoliage() {
        super(Material.grass);
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockCrystalFoliage.soundTypeGrass);
        this.setHardness(0.1f);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        final byte b0 = 0;
        final float f = 0.7f;
        return AxisAlignedBB.getBoundingBox(p_149668_2_ + this.minX, p_149668_3_ + this.minY, p_149668_4_ + this.minZ, p_149668_2_ + this.maxX, (double)(p_149668_3_ + b0 * f), p_149668_4_ + this.maxZ);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    protected boolean canPlaceBlockOn(final Block p_149854_1_) {
        return p_149854_1_ == Dungeons.amethystStone || p_149854_1_ == Dungeons.amethystCrystalized;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 1;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }
}
