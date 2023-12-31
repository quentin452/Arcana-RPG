

package com.gibby.dungeon.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class DungeonsBossStatusResistance
{
    public static float healthScale;
    public static int statusBarTime;
    public static String bossName;
    public static int type;

    public static void setBossStatus(final IDungeonsBossDisplayDataResistance par0IBossDisplayData, final boolean b) {
        DungeonsBossStatusResistance.healthScale = par0IBossDisplayData.getHealth() / par0IBossDisplayData.getMaxHealth();
        DungeonsBossStatusResistance.statusBarTime = 100;
        DungeonsBossStatusResistance.bossName = par0IBossDisplayData.func_145748_c_().getFormattedText();
    }
}
