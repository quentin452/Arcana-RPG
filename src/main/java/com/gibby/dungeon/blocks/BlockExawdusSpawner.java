

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class BlockExawdusSpawner extends Block
{
    public BlockExawdusSpawner() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
    }
    
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote) {
            for (int i = 0; i < 50; ++i) {
                final EntityReddustFX particle = new EntityReddustFX(world, x + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Dungeons.randGauss(), 0.0f, 0.0f, 0.0f);
                Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
            }
        }
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Dungeons.magirockCharge && !world.isRemote) {
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            final EntityExawdusSpawner spawner = new EntityExawdusSpawner(world);
            spawner.posX = x;
            spawner.posY = y;
            spawner.posZ = z;
            world.spawnEntityInWorld((Entity)spawner);
            world.setBlockToAir(x, y, z);
        }
        return false;
    }
}
