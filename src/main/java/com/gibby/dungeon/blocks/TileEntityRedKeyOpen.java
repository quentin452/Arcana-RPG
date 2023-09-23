

package com.gibby.dungeon.blocks;

import net.minecraft.tileentity.*;
import com.gibby.dungeon.*;

public class TileEntityRedKeyOpen extends TileEntity
{
    public static final String publicName = "tileEntityRedKeyOpen";
    private String name;

    public TileEntityRedKeyOpen() {
        this.name = "tileEntityRedKeyOpen";
    }

    public String getName() {
        return this.name;
    }

    public void updateEntity() {
        super.updateEntity();
        final int x = this.xCoord;
        final int y = this.yCoord;
        final int z = this.zCoord;
        if (!this.worldObj.isRemote && this.worldObj.getBlock(x, y, z + 1) == Dungeons.blueKeyOpen && this.worldObj.getBlock(x, y, z - 1) == Dungeons.blackKeyOpen) {
            for (int Z = -1; Z < 2; ++Z) {
                for (int Y = -1; Y < 3; ++Y) {
                    this.worldObj.setBlockToAir(x, y + Y, z + Z);
                    this.worldObj.playSound((double)x, (double)y, (double)z, "mob.irongolem.hit", 1.0f, 1.0f, false);
                    for (int i = 0; i < 10; ++i) {
                        this.worldObj.spawnParticle("reddust", x + Dungeons.randGauss(), y + Y + Dungeons.randGauss(), z + Z + Dungeons.randGauss(), 0.0, 0.0, 0.0);
                    }
                }
            }
        }
    }
}
