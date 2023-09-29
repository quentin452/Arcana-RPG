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

public class BlockJadeLeaves extends BlockLeaves
{
    public BlockJadeLeaves() {
        super();
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockJadeLeaves.soundTypeGrass);
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
            Dungeons.MODID + ":jadeLeaves");
    }

    @Override
    public String[] func_150125_e() {
        return new String[0];
    }

    private boolean areAtLeastTwoAdjacentBlocksLeaves(IBlockAccess world, int x, int y, int z, Block leafBlock) {
        int leafCount = 0;
        for (EnumFacing facing : EnumFacing.values()) {
            Block adjacentBlock = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
            if (adjacentBlock == leafBlock && adjacentBlock instanceof BlockJadeLeaves) {
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
        if (block == adjacentBlock && block instanceof BlockJadeLeaves) {
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

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
                           final Random par5Random) {
        int var7 = 30;
        int totaldist;
        if (!par1World.isRemote && par1World
            .checkChunksExist(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
            for (int var8 = -var7; var8 <= var7; ++var8) {
                for (int var9 = -var7; var9 <= 0; ++var9) {
                    for (int var10 = -var7; var10 <= var7; ++var10) {
                        totaldist = Math.abs(var8) + Math.abs(var9) + Math.abs(var10);
                        if (totaldist <= 5) {
                            Block bid = par1World.getBlock(par2 + var8, par3 + var9, par4 + var10);
                            if (bid != null && canSustainLeaves(par1World, par2 + var8, par3 + var9, par4 + var10)) {
                                bid = par1World.getBlock(par2, par3 - 1, par4);
                                return;
                            }
                        }
                    }
                }
            }
            this.removeLeaves(par1World, par2, par3, par4);
        }
    }

    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
    }
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y, z);
        return block == Dungeons.jadeLog;
    }
}
