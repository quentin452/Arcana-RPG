package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.gen.TeleporterMidnight;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMidnightPortal extends Block
{
    public BlockMidnightPortal() {
        super(Material.circuits);
        this.setLightLevel(6.0f);
        this.setHardness(10000.0f);
        this.setResistance(10000.0f);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public void onEntityCollidedWithBlock(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null && par5Entity instanceof EntityPlayerMP) {
            final EntityPlayerMP player = (EntityPlayerMP)par5Entity;
            final MinecraftServer mServer = MinecraftServer.getServer();
            if (player.timeUntilPortal > 0) {
                player.timeUntilPortal = 3;
            }
            else if (player.dimension == 0) {
                player.timeUntilPortal = 3;
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Dungeons.midnightDimensionId, new TeleporterMidnight(mServer.worldServerForDimension(Dungeons.midnightDimensionId)));
            }
            else if (player.dimension == Dungeons.midnightDimensionId) {
                player.timeUntilPortal = 3;
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterMidnight(mServer.worldServerForDimension(0)));
                player.fallDistance = -20.0f;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        if (p_149734_5_.nextInt(50) == 0) {
            p_149734_1_.playSound(p_149734_2_ + 0.5, p_149734_3_ + 0.5, p_149734_4_ + 0.5, "mob.wither.idle", 0.1f, 0.3f, false);
        }
        for (int l = 0; l < 4; ++l) {
            double d0 = p_149734_2_ + p_149734_5_.nextFloat();
            final double d2 = p_149734_3_ + p_149734_5_.nextFloat();
            double d3 = p_149734_4_ + p_149734_5_.nextFloat();
            double d4;
            double d5;
            double d6;
            final int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d4 = (p_149734_5_.nextFloat() - 0.5) * 0.5;
            d5 = (p_149734_5_.nextFloat() - 0.5) * 0.5;
            d6 = (p_149734_5_.nextFloat() - 0.5) * 0.5;
            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this) {
                d0 = p_149734_2_ + 0.5 + 0.25 * i1;
                d4 = p_149734_5_.nextFloat() * 2.0f * i1;
            }
            else {
                d3 = p_149734_4_ + 0.5 + 0.25 * i1;
                d6 = p_149734_5_.nextFloat() * 2.0f * i1;
            }
            p_149734_1_.spawnParticle("fireworksspark", d0, d2, d3, d4, d5, d6);
        }
        for (int j = 0; j < 10; ++j) {
            p_149734_1_.spawnParticle("fireworksspark", p_149734_2_ + p_149734_5_.nextGaussian(), p_149734_3_ + p_149734_5_.nextGaussian(), p_149734_4_ + p_149734_5_.nextGaussian(), p_149734_5_.nextGaussian(), p_149734_5_.nextGaussian(), p_149734_5_.nextGaussian());
        }
    }

    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, final Block par5) {
        byte b0 = 0;
        byte b2 = 1;
        if (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this) {
            b0 = 1;
            b2 = 0;
        }
        int i1;
        for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1) {}
        if (par1World.getBlock(par2, i1 - 1, par4) != Dungeons.darkBlueGlow) {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else {
            int j1;
            for (j1 = 1; j1 < 4 && par1World.getBlock(par2, i1 + j1, par4) == this; ++j1) {}
            if (j1 == 3 && par1World.getBlock(par2, i1 + j1, par4) == Dungeons.darkBlueGlow) {
                final boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this;
                final boolean flag2 = par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this;
                if (flag && flag2) {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else if ((par1World.getBlock(par2 + b0, par3, par4 + b2) != Dungeons.darkBlueGlow || par1World.getBlock(par2 - b0, par3, par4 - b2) != this) && (par1World.getBlock(par2 - b0, par3, par4 - b2) != Dungeons.darkBlueGlow || par1World.getBlock(par2 + b0, par3, par4 + b2) != this)) {
                    par1World.setBlockToAir(par2, par3, par4);
                }
            }
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        return null;
    }

    public int quantityDropped(final Random p_149745_1_) {
        return 0;
    }

    public static int func_149999_b(final int p_149999_0_) {
        return p_149999_0_ & 0x3;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(final World p_149694_1_, final int p_149694_2_, final int p_149694_3_, final int p_149694_4_) {
        return Item.getItemById(0);
    }
}
