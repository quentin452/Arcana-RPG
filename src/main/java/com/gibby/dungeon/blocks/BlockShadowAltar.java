package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityTitanSpawner;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class BlockShadowAltar extends Block
{
    public BlockShadowAltar() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(10.0f);
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Dungeons.shadowOrb && !world.isRemote) {
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            final EntityTitanSpawner spawner = new EntityTitanSpawner(world);
            spawner.posX = x;
            spawner.posY = y;
            spawner.posZ = z;
            world.spawnEntityInWorld(spawner);
            for (int X = -5; X < 5; ++X) {
                for (int Y = -4; Y < 8; ++Y) {
                    for (int Z = -5; Z < 5; ++Z) {
                        world.setBlockToAir(x + X, y + Y, z + Z);
                    }
                }
            }
            player.addChatMessage(new ChatComponentText("My true power has been released!"));
        }
        return false;
    }
}
