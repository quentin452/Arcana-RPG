

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.EntityEnchantEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockChargedMagiTable extends BlockEndPortalFrame
{
    @SideOnly(Side.CLIENT)
    private IIcon iconEndPortalFrameTop;

    public BlockChargedMagiTable() {
        this.setHardness(10.0f);
        this.setResistance(15.0f);
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(Dungeons.magitableCharged);
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (world.isRemote) {
            for (int i = 0; i < 50; ++i) {
                final EntityReddustFX particle = new EntityReddustFX(world, x + 0.5 + Dungeons.randGauss() / 20.0, y + 1, z + 0.5 + Dungeons.randGauss() / 20.0, 0.0f, 0.0f, 1.0f);
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.iconEndPortalFrameTop : ((p_149691_1_ == 0) ? Blocks.end_stone.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.iconEndPortalFrameTop = p_149651_1_.registerIcon(this.getTextureName() + "_top");
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.inventory.getCurrentItem() != null && (player.inventory.getCurrentItem().getItem() instanceof ItemArmor || player.inventory.getCurrentItem().getItem() instanceof ItemSword || player.inventory.getCurrentItem().getItem() instanceof ItemPickaxe) && player.inventory.getCurrentItem().getItemDamage() == 0 && !world.isRemote) {
            world.playSoundAtEntity(player, "portal.portal", 1.0f, 1.0f);
            final int r = world.rand.nextInt(10);
            EntityItem item;
            if (r == 0) {
                item = new EntityItem(world, x + 0.5, y + 1.5, z + 0.5, Dungeons.setLegendary(new ItemStack(player.inventory.getCurrentItem().getItem())));
            }
            else {
                item = new EntityItem(world, x + 0.5, y + 1.5, z + 0.5, Dungeons.setRare(new ItemStack(player.inventory.getCurrentItem().getItem())));
            }
            final EntityEnchantEffect effect = new EntityEnchantEffect(world, x + 0.5, y + 0.5, z + 0.5);
            effect.item = item;
            world.spawnEntityInWorld(effect);
            final ItemStack getCurrentItem = player.inventory.getCurrentItem();
            --getCurrentItem.stackSize;
            world.setBlock(x, y, z, Dungeons.magitable);
        }
        return true;
    }
}
