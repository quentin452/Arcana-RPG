

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import com.gibby.dungeon.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class BlockFrostSpikes extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150041_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150040_b;

    public BlockFrostSpikes() {
        super(Material.ice);
        this.setTickRandomly(true);
        this.setCreativeTab(Dungeons.Blocks);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        final byte b0 = 0;
        final float f = 0.7f;
        return AxisAlignedBB.getBoundingBox(p_149668_2_ + this.minX, p_149668_3_ + this.minY, p_149668_4_ + this.minZ, p_149668_2_ + this.maxX, (float)p_149668_3_ + 0.1, p_149668_4_ + this.maxZ);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }

    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (!world.isRemote) {
            entity.attackEntityFrom(DamageSource.magic, 8.0f);
            world.setBlockToAir(x, y, z);
        }
    }
}
