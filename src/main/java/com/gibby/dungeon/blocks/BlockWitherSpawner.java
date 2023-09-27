

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.EntityWitherSpawner;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class BlockWitherSpawner extends Block
{
    public BlockWitherSpawner() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
    }

    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote) {
            for (int i = 0; i < 50; ++i) {
                final double rand = Dungeons.randGauss();
                final EntityReddustFX particle = new EntityReddustFX(world, x + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Dungeons.randGauss(), (float)rand, (float)rand, (float)rand);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Items.nether_star && !world.isRemote) {
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            final EntityWitherSpawner spawner = new EntityWitherSpawner(world);
            spawner.posX = x;
            spawner.posY = y;
            spawner.posZ = z;
            world.spawnEntityInWorld(spawner);
            world.setBlockToAir(x, y, z);
        }
        return false;
    }
}
