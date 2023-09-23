package com.gibby.dungeon;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

final class Dungeons$6 extends CreativeTabs {
    Dungeons$6(int x0, String x1) {
        super(x0, x1);
    }

    @SideOnly(Side.CLIENT)
    public Item func_78016_d() {
        return Dungeons.dungeonDimensionSpawner;
    }
}
