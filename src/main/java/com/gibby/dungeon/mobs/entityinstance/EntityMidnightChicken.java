package com.gibby.dungeon.mobs.entityinstance;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMidnightChicken extends EntityChicken
{
    public EntityMidnightChicken(final World par1World) {
        super(par1World);
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 200;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox) && this.posY > 60.0;
    }

    protected boolean canDespawn() {
        return true;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    protected Item getDropItem() {
        return null;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Dungeons.midnightChickenRaw, 1);
    }
}
