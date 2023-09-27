

package com.gibby.dungeon.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class DungeonsBossStatus
{
    public static float healthScale;
    public static int statusBarTime;
    public static String bossName;

    public static void setBossStatus(final IDungeonsBossDisplayData par0IBossDisplayData) {
        DungeonsBossStatus.healthScale = par0IBossDisplayData.getHealth() / par0IBossDisplayData.getMaxHealth();
        DungeonsBossStatus.statusBarTime = 100;
        DungeonsBossStatus.bossName = par0IBossDisplayData.func_145748_c_().getFormattedText();
    }
}
