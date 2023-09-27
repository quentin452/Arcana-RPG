package com.gibby.dungeon.proxy;

import com.gibby.dungeon.blocks.TileEntityDungeonSpawner;
import com.gibby.dungeon.blocks.TileEntityDungeonSpawnerRepeater;
import com.gibby.dungeon.blocks.TileEntityRedKeyOpen;
import cpw.mods.fml.common.registry.GameRegistry;

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
