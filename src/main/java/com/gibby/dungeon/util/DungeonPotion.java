

package com.gibby.dungeon.util;

import net.minecraft.potion.Potion;

public class DungeonPotion extends Potion
{
    public DungeonPotion(int id, boolean extended, int color) {
        super(id, extended, color);
    }
    public Potion setIconIndex(final int par1, final int par2) {
        super.setIconIndex(par1, par2);
        return this;
    }
}
