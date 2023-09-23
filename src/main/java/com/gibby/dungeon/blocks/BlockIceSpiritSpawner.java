

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.gibby.dungeon.*;
import net.minecraft.entity.*;

public class BlockIceSpiritSpawner extends Block
{
    public BlockIceSpiritSpawner() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(10000.0f);
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (!world.isRemote) {
            world.playSoundAtEntity((Entity)player, "dig.glass", 1.0f, 1.0f);
            final EntityIceSpirit entity = new EntityIceSpirit(world);
            entity.setPosition((double)x, (double)y, (double)z);
            world.spawnEntityInWorld((Entity)entity);
            entity.onSpawnWithEgg((IEntityLivingData)null);
            entity.setPosition((double)x, (double)y, (double)z);
            world.setBlockToAir(x, y, z);
        }
        return false;
    }
}
