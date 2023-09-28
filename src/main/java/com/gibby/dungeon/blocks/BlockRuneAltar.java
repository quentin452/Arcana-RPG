package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityDarkExplosion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockRuneAltar extends Block
{
    public BlockRuneAltar() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (!world.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Dungeons.runeShard && player.getCurrentEquippedItem().stackSize > 15) {
            final EntityDarkExplosion.EntityRuneAltar rune = new EntityDarkExplosion.EntityRuneAltar(world, x, y, z);
            world.spawnEntityInWorld(rune);
            for (int i = 0; i < 16; ++i) {
                player.inventory.consumeInventoryItem(Dungeons.runeShard);
            }
            world.setBlockToAir(x, y, z);
        }
        else if (!world.isRemote) {
            player.addChatMessage(new ChatComponentText("You need 16 Rune Shards in your hand to unlock"));
        }
        return false;
    }
}
