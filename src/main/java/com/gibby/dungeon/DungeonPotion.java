

package com.gibby.dungeon;

import net.minecraft.potion.Potion;

public class DungeonPotion extends Potion
{
    public DungeonPotion(final int par1, final boolean par2, final int par3) {
        super(par1, par2, par3);
    }

    public Potion setIconIndex(final int par1, final int par2) {
        super.setIconIndex(par1, par2);
        return this;
    }
}
