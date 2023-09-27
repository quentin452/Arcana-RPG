

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityStoneBot extends EntityIronGolem
{
    public EntityStoneBot(final World par1World) {
        super(par1World);
        this.setHealth(30.0f);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        this.worldObj.setEntityState(this, (byte)4);
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + Dungeons.randRange(0, 2)));
        if (flag) {
            par1Entity.motionY += 0.4000000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        if (itemstack != null && (itemstack.getItem() == Items.iron_ingot || itemstack.getItem() == Dungeons.copper) && this.getHealth() < 30.0f) {
            this.heal(10.0f);
            --itemstack.stackSize;
        }
        return super.interact(par1EntityPlayer);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.entityDropItem(new ItemStack(Blocks.cobblestone), 1.0f);
    }
}
