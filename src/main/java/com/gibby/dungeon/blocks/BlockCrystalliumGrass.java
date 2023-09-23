

package com.gibby.dungeon.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import com.gibby.dungeon.*;
import net.minecraft.client.renderer.texture.*;

public class BlockCrystalliumGrass extends Block
{
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;
    
    public BlockCrystalliumGrass() {
        super(Material.grass);
        this.icons = new IIcon[6];
        this.setHarvestLevel("shovel", 0);
        this.setStepSound(BlockCrystalliumGrass.soundTypeGrass);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        if (this == Dungeons.crystalliumGrass) {
            return Item.getItemFromBlock(Dungeons.crystalliumDirt);
        }
        return Item.getItemFromBlock(Dungeons.crystalDirt);
    }
    
    public void registerBlockIcons(final IIconRegister reg) {
        this.icons[0] = reg.registerIcon(this.textureName + "_" + "bottom");
        this.icons[1] = reg.registerIcon(this.textureName + "_" + "top");
        for (int i = 2; i <= 5; ++i) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + "side");
        }
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return this.icons[side];
    }
}
