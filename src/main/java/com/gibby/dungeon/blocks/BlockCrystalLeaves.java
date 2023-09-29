

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BlockCrystalLeaves extends BlockLeaves
{
    public BlockCrystalLeaves() {
        super();
        this.setHarvestLevel("shears", 0);
        this.setStepSound(BlockCrystalLeaves.soundTypeGrass);
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
            Dungeons.MODID + ":crystalleaves");
    }

    @Override
    public String[] func_150125_e() {
        return new String[0];
    }

    private boolean areAtLeastTwoAdjacentBlocksLeaves(IBlockAccess world, int x, int y, int z, Block leafBlock) {
        int leafCount = 0;
        for (EnumFacing facing : EnumFacing.values()) {
            Block adjacentBlock = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
            if (adjacentBlock == leafBlock && adjacentBlock instanceof BlockCrystalLeaves) {
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
        if (block == adjacentBlock && block instanceof BlockCrystalLeaves) {
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

    Random rand = new Random();
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if(rand.nextInt(30) == 0) {
            dropBlockAsItem(world, x, y, z, new ItemStack(Items.stick));
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote && random.nextInt(5) == 0) {
            int light = world.getBlock(x, y, z).getLightValue(world, x, y, z);
            if(light >= 9) {
                return;
            }
            int metadata = world.getBlockMetadata(x, y, z);
            if(metadata  > 0) {
                world.setBlockMetadataWithNotify(x, y, z, metadata -1, 2);
            } else {
                removeLeaves(world, x, y, z);
            }
        }
        super.updateTick(world, x, y, z, random);
    }

    protected void removeLeaves(World world, int x, int y, int z) {
        world.setBlockToAir(x, y, z);
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

}
