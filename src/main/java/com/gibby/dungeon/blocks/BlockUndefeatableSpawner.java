

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.mobs.EntityUndefeatable;
import com.gibby.dungeon.mobs.EntityUndefeatableRegen;
import com.gibby.dungeon.mobs.EntityUndefeatableResistance;
import com.gibby.dungeon.mobs.EntityUndefeatableStrength;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockUndefeatableSpawner extends Block
{
    public BlockUndefeatableSpawner() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(10000.0f);
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (!world.isRemote) {
            world.playSoundAtEntity(player, "mob.irongolem.hit", 1.0f, 1.0f);
            EntityUndefeatable entity = new EntityUndefeatableStrength(world);
            entity.setPosition((x - 9), y, z);
            world.spawnEntityInWorld(entity);
            entity.onSpawnWithEgg(null);
            entity.setPosition((x - 9), y, z);
            entity = new EntityUndefeatableResistance(world);
            entity.setPosition(x, y, (z + 9));
            world.spawnEntityInWorld(entity);
            entity.onSpawnWithEgg(null);
            entity.setPosition(x, y,(z + 9));
            entity = new EntityUndefeatableRegen(world);
            entity.setPosition(x, y, (z - 9));
            world.spawnEntityInWorld(entity);
            entity.onSpawnWithEgg(null);
            entity.setPosition(x,y, (z - 9));
            world.setBlockToAir(x, y, z);
        }
        return false;
    }
}
