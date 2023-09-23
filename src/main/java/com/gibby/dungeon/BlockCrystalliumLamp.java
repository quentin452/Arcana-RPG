

package com.gibby.dungeon;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockCrystalliumLamp extends BlockGlowstone
{
    public BlockCrystalliumLamp() {
        super(Material.glass);
        this.setHardness(6.0f);
        this.setResistance(9.0f);
        this.setLightLevel(10.0f);
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(Dungeons.crystalliumLamp);
    }
}
