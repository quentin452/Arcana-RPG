

package com.gibby.dungeon;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class BlockMagiTable extends BlockEndPortalFrame
{
    @SideOnly(Side.CLIENT)
    private IIcon iconEndPortalFrameTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconEndPortalFrameEye;
    private static final String __OBFID = "CL_00000237";
    
    public BlockMagiTable() {
        this.setHardness(10.0f);
        this.setResistance(15.0f);
    }
    
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(Dungeons.magitable);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.iconEndPortalFrameTop : ((p_149691_1_ == 0) ? Blocks.end_stone.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.iconEndPortalFrameTop = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this.iconEndPortalFrameEye = p_149651_1_.registerIcon(this.getTextureName() + "_eye");
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Dungeons.magirockCharge && !world.isRemote) {
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            world.setBlock(x, y, z, Dungeons.magitableCharged);
        }
        return true;
    }
}
