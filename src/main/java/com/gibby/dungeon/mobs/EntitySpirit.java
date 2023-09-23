

package com.gibby.dungeon.mobs;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import com.gibby.dungeon.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

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
