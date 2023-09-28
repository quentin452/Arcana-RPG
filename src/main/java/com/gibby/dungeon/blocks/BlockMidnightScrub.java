package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMidnightScrub extends Block
{
    public BlockMidnightScrub() {
        super(Material.rock);
        this.setHardness(1.0f);
        this.setResistance(0.5f);
    }

    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (!world.isRemote) {
            world.setBlock(x, y, z, Dungeons.midnightScrubLight);
        }
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
}
