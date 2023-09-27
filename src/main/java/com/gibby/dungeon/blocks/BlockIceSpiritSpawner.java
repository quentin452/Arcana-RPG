

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.mobs.entityinstance.EntityIceSpirit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockIceSpiritSpawner extends Block
{
    public BlockIceSpiritSpawner() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(10000.0f);
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (!world.isRemote) {
            world.playSoundAtEntity(player, "dig.glass", 1.0f, 1.0f);
            final EntityIceSpirit entity = new EntityIceSpirit(world);
            entity.setPosition(x, y, z);
            world.spawnEntityInWorld(entity);
            entity.onSpawnWithEgg(null);
            entity.setPosition(x, y, z);
            world.setBlockToAir(x, y, z);
        }
        return false;
    }
}
