package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMidnightScrubLight  extends Block
{
    public BlockMidnightScrubLight() {
        super(Material.grass);
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockMidnightScrubLight.soundTypeGrass);
        this.setHardness(0.1f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    protected boolean canPlaceBlockOn(final Block p_149854_1_) {
        return p_149854_1_ == Dungeons.midnightGrass;
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

    @SideOnly(Side.CLIENT)
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        if (!world.isRemote) {
            world.setBlock(x, y, z, Dungeons.midnightScrub);
        }
    }

    public void onBlockAdded(final World p_149726_1_, final int p_149726_2_, final int p_149726_3_, final int p_149726_4_) {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_) == this) {
            p_149726_1_.scheduleBlockUpdate(p_149726_2_, p_149726_3_, p_149726_4_, (Block)this, this.tickRate(p_149726_1_) + Dungeons.randRange(0, 25));
        }
    }

    public int tickRate(final World p_149738_1_) {
        return 70;
    }
}
