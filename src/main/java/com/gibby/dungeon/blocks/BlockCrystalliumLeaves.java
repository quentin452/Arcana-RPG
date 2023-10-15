

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BlockCrystalliumLeaves extends BlockLeaves
{
    public BlockCrystalliumLeaves() {
        super();
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockCrystalliumLeaves.soundTypeGrass);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Dungeons.MODID + ":crystalliumleaves");
    }

    @Override
    public String[] func_150125_e() {
        return new String[0];
    }

    private boolean areAtLeastTwoAdjacentBlocksLeaves(IBlockAccess world, int x, int y, int z, Block leafBlock) {
        int leafCount = 0;
        for (EnumFacing facing : EnumFacing.values()) {
            Block adjacentBlock = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
            if (adjacentBlock == leafBlock && adjacentBlock instanceof BlockCrystalliumLeaves) {
                leafCount++;
                if (leafCount >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        Block block = world.getBlock(x, y, z);
        Block adjacentBlock = world.getBlock(x + ForgeDirection.VALID_DIRECTIONS[side].offsetX, y + ForgeDirection.VALID_DIRECTIONS[side].offsetY, z + ForgeDirection.VALID_DIRECTIONS[side].offsetZ);
        if (block == adjacentBlock && block instanceof BlockCrystalliumLeaves) {
            if (areAtLeastTwoAdjacentBlocksLeaves(world, x, y, z, block)) {
                return false;
            }
            return true;
        }

        return super.shouldSideBeRendered(world, x, y, z, side);
    }
    @Override
    public int getRenderType() {
        return super.getRenderType();
    }
    public void updateTick(final World world, final int x, final int y, final int z, final Random random) {
        int radius = 30;

        if (!world.isRemote && world.checkChunksExist(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius)) {
            for (int offX = -radius; offX <= radius; ++offX) {
                for (int offY = -radius; offY <= radius; ++offY) {
                    for (int offZ = -radius; offZ <= radius; ++offZ) {
                        int totaldist = Math.max(Math.max(Math.abs(offX), Math.abs(offY)), Math.abs(offZ));
                        if (totaldist <= 5) {
                            Block adjacentBlock = world.getBlock(x + offX, y + offY, z + offZ);
                            if (adjacentBlock != null && canSustainLeaves(world, x + offX, y + offY, z + offZ)) {
                                return;
                            }
                        }
                    }
                }
            }
            this.removeLeaves(world, x, y, z);
        }
    }

    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
    }
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y, z);
        return block == Dungeons.crystalWood;
    }

}
