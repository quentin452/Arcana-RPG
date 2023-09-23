

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.*;
import java.util.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;

public class BlockBadgererSpawner extends Block
{
    public BlockBadgererSpawner() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
    }
    
    public void onBlockDestroyedByPlayer(final World world, final int x, final int y, final int z, final int m) {
        if (!world.isRemote) {
            final EntityCrystalBadgerer badgerer = new EntityCrystalBadgerer(world);
            badgerer.setPosition((double)x, (double)y, (double)z);
            world.spawnEntityInWorld((Entity)badgerer);
            badgerer.onSpawnWithEgg((IEntityLivingData)null);
            badgerer.setPosition((double)x, (double)y, (double)z);
        }
    }
    
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        for (int i = 0; i < 100; ++i) {
            world.spawnParticle("portal", x + Dungeons.randGauss(), y + Dungeons.randGauss(), z + Dungeons.randGauss(), Dungeons.randGauss(), Dungeons.randGauss(), Dungeons.randGauss());
        }
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return null;
    }
}
