

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityMidnightPortal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMidnightPortalSpawner extends Block
{
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote) {
            for (int i = 0; i < 10; ++i) {
                final EntityFireworkSparkFX particle = new EntityFireworkSparkFX(world, x + 0.5 + Dungeons.randGauss() / 2.0, y + 0.5 + Dungeons.randGauss(), z + 0.5 + Dungeons.randGauss() / 2.0, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer);
                particle.setRBGColorF(0.0f, 0.0f, 1.0f);
                particle.setFadeColour(0);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.dimension != 0) {
            player.addChatMessage(new ChatComponentText("Only works in Overworld"));
        }
        else if (!world.isRemote) {
            final EntityMidnightPortal portal = new EntityMidnightPortal(world, x, y, z);
            world.spawnEntityInWorld(portal);
            world.setBlockToAir(x, y, z);
        }
        return false;
    }

    public BlockMidnightPortalSpawner() {
        super(Material.rock);
        this.setHardness(10000.0f);
        this.setResistance(100000.0f);
    }
}
