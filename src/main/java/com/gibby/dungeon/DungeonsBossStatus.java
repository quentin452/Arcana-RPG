

package com.gibby.dungeon;

import cpw.mods.fml.relauncher.*;

@SideOnly(Side.CLIENT)
public final class DungeonsBossStatus
{
    public static float healthScale;
    public static int statusBarTime;
    public static String bossName;
    private static final String __OBFID = "CL_00000941";
    
    public static void setBossStatus(final IDungeonsBossDisplayData par0IBossDisplayData, final boolean b) {
        DungeonsBossStatus.healthScale = par0IBossDisplayData.getHealth() / par0IBossDisplayData.getMaxHealth();
        DungeonsBossStatus.statusBarTime = 100;
        DungeonsBossStatus.bossName = par0IBossDisplayData.func_145748_c_().getFormattedText();
    }
}
