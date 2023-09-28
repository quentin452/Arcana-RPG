package com.gibby.dungeon.proxy;

import com.gibby.dungeon.blocks.TileEntityDungeonSpawner;
import com.gibby.dungeon.blocks.TileEntityDungeonSpawnerRepeater;
import com.gibby.dungeon.blocks.TileEntityRedKeyOpen;
import com.gibby.dungeon.blocks.TileEntityShadow;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;

public class CommonProxy
{
    private static HashMap<String, NBTTagCompound> extendedEntityData;
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
    public static NBTTagCompound getEntityData(final String name) {
        return CommonProxy.extendedEntityData.remove(name);
    }

    static {
        CommonProxy.extendedEntityData = new HashMap<>();
    }
}
