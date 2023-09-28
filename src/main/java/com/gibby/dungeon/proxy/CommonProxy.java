package com.gibby.dungeon.proxy;

import com.gibby.dungeon.blocks.TileEntityDungeonSpawner;
import com.gibby.dungeon.blocks.TileEntityDungeonSpawnerRepeater;
import com.gibby.dungeon.blocks.TileEntityRedKeyOpen;
import com.gibby.dungeon.blocks.TileEntityShadow;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void registerItemRenderers() {
    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityDungeonSpawner.class, "tileEntityDungeonSpawner");
        GameRegistry.registerTileEntity(TileEntityDungeonSpawnerRepeater.class, "tileEntityDungeonSpawnerRepeater");
        GameRegistry.registerTileEntity(TileEntityRedKeyOpen.class, "tileEntityRedKeyOpen");
        GameRegistry.registerTileEntity(TileEntityShadow.class, "tileEntityShadow");
    }

    public void registerRenderInformation() {
    }
}
