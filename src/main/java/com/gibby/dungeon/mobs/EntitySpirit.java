

package com.gibby.dungeon.mobs;

import com.gibby.dungeon.Dungeons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySpirit extends EntityMob
{
    public EntitySpirit(final World par1World) {
        super(par1World);
        this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 10000, 0));
        this.addRandomArmor();
    }

    protected void dropRareDrop(final int par1) {
        this.dropItem(Dungeons.magicGem, 1);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0);
    }

    protected String getLivingSound() {
        return "ambient.cave.cave";
    }

    protected String getHurtSound() {
        return "ambient.cave.cave";
    }

    protected String getDeathSound() {
        return "ambient.cave.cave";
    }

    protected float getSoundVolume() {
        return 1.2f;
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Items.wooden_hoe));
        this.setCurrentItemOrArmor(4, new ItemStack((this.rand.nextFloat() < 0.1f) ? Blocks.lit_pumpkin : Blocks.pumpkin));
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        par1Entity.attackEntityFrom(DamageSource.magic, 4.0f);
        if (par1Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
        }
        return true;
    }
}
