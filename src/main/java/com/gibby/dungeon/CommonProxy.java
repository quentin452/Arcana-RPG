package com.gibby.dungeon;

import cpw.mods.fml.common.registry.*;
import com.gibby.dungeon.blocks.*;

public class CommonProxy
{
    public void registerItemRenderers() {
    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityDungeonSpawner.class, "tileEntityDungeonSpawner");
        GameRegistry.registerTileEntity(TileEntityDungeonSpawnerRepeater.class, "tileEntityDungeonSpawnerRepeater");
        GameRegistry.registerTileEntity(TileEntityRedKeyOpen.class, "tileEntityRedKeyOpen");
    }

    public void registerRenderInformation() {
    }
}
