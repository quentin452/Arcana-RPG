

package com.gibby.dungeon;

import net.minecraftforge.event.entity.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.entity.monster.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import java.util.*;
import net.minecraftforge.event.entity.living.*;
import com.gibby.dungeon.items.*;

public class DungeonEventHandler
{
    private int totalMagicDefence;
    private int totalVoidDefence;
    private float boost;
    private boolean initialMagic;
    
    public DungeonEventHandler() {
        this.boost = 0.0f;
        this.initialMagic = true;
    }
    
    @SubscribeEvent
    public void onEntityConstructing(final EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && DungeonsExtendedPlayer.get((EntityPlayer)event.entity) == null) {
            DungeonsExtendedPlayer.register((EntityPlayer)event.entity);
        }
        if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties("ExtendedPlayer") == null) {
            event.entity.registerExtendedProperties("ExtendedPlayer", (IExtendedEntityProperties)new DungeonsExtendedPlayer((EntityPlayer)event.entity));
        }
    }
    
    @SubscribeEvent
    public void handleConstruction(final EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            ((EntityPlayer)event.entity).field_71079_bU = 21.0f;
        }
    }
    
    @SubscribeEvent
    public void onLivingDeath(final LivingDeathEvent event) {
        if (event.entityLiving instanceof EntityGiantZombie) {
            event.entityLiving.dropItem(Items.rotten_flesh, 10);
            event.entityLiving.dropItem(Items.emerald, 1);
        }
    }
    
    @SubscribeEvent
    public void onLivingUpdate(final LivingEvent.LivingUpdateEvent event) {
        final EntityLivingBase entity = event.entityLiving;
        if (entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)entity;
            if (player.dimension == Dungeons.sunsetDimensionId) {
                player.worldObj.setWorldTime(13500L);
            }
            if (player.dimension == Dungeons.crystalDimensionId) {
                player.worldObj.setWorldTime(15000L);
                if (!player.worldObj.isRemote && player.worldObj.rand.nextInt(10000) == 0) {
                    final EntityCrystalMeteor meteor = new EntityCrystalMeteor(player.worldObj, Dungeons.randGauss() * 10.0 + player.posX, player.posY + 50.0, Dungeons.randGauss() * 10.0 + player.posZ);
                    meteor.setVelocity(Dungeons.randGauss(), -0.3, Dungeons.randGauss());
                    player.worldObj.spawnEntityInWorld((Entity)meteor);
                }
            }
            else if (player.dimension == 0 && !player.worldObj.isRemote && player.posY <= 50.0 && player.worldObj.rand.nextInt(100000) == 0) {
                player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
                player.worldObj.playSoundAtEntity((Entity)player, "ambient.cave.cave", 0.8f, 1.0f);
            }
            final DungeonsExtendedPlayer par3 = DungeonsExtendedPlayer.get(player);
            if (player.ticksExisted % 80 == 0) {
                par3.addMagic(1);
            }
        }
        if (entity.getActivePotionEffect(Potion.damageBoost) != null && entity instanceof EntityLivingBase && entity.worldObj.rand.nextInt(8) == 0) {
            final double randx = entity.worldObj.rand.nextGaussian() / 2.0 - entity.worldObj.rand.nextGaussian() / 2.0;
            final double randy = entity.worldObj.rand.nextGaussian() / 2.0 - entity.worldObj.rand.nextGaussian() / 4.0;
            final double randz = entity.worldObj.rand.nextGaussian() / 2.0 - entity.worldObj.rand.nextGaussian() / 2.0;
            entity.worldObj.spawnParticle("reddust", entity.posX + randx, entity.posY + randy, entity.posZ + randz, 0.0, 0.0, 0.0);
        }
        if (entity.getActivePotionEffect(Potion.wither) != null && entity instanceof EntityLivingBase && entity.worldObj.rand.nextInt(8) == 0) {
            final double randx = entity.worldObj.rand.nextGaussian() / 2.0 - entity.worldObj.rand.nextGaussian() / 2.0;
            final double randy = entity.worldObj.rand.nextGaussian() / 2.0 - entity.worldObj.rand.nextGaussian() / 4.0;
            final double randz = entity.worldObj.rand.nextGaussian() / 2.0 - entity.worldObj.rand.nextGaussian() / 2.0;
            entity.worldObj.spawnParticle("mobspell", entity.posX + randx, entity.posY + randy, entity.posZ + randz, 0.0, 0.0, 0.0);
        }
        if (entity.getActivePotionEffect(Potion.regeneration) != null && entity instanceof EntityLivingBase && entity.worldObj.rand.nextInt(12) == 0) {
            final double randx = entity.worldObj.rand.nextGaussian() - entity.worldObj.rand.nextGaussian() / 2.0;
            final double randy = entity.worldObj.rand.nextGaussian() - entity.worldObj.rand.nextGaussian() / 2.0;
            final double randz = entity.worldObj.rand.nextGaussian() - entity.worldObj.rand.nextGaussian() / 2.0;
            entity.worldObj.spawnParticle("heart", entity.posX + randx, entity.posY + randy, entity.posZ + randz, 0.0, 0.0, 0.0);
        }
        if (entity.getActivePotionEffect(Potion.resistance) != null) {
            final double randx = entity.worldObj.rand.nextGaussian() - 0.5;
            final double randz2 = entity.worldObj.rand.nextGaussian() - 0.5;
            if (entity instanceof EntityPlayer) {
                entity.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
            else {
                entity.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", entity.posX + randx, entity.posY + 1.0, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
        }
        if (entity.getActivePotionEffect(Potion.fireResistance) != null && entity.worldObj.rand.nextInt(12) == 0) {
            final double randx = entity.worldObj.rand.nextGaussian() - 0.5;
            final double randz2 = entity.worldObj.rand.nextGaussian() - 0.5;
            if (entity instanceof EntityPlayer) {
                entity.worldObj.spawnParticle("flame", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
            else {
                entity.worldObj.spawnParticle("flame", entity.posX + randx, entity.posY + 1.0, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
        }
        if (entity.getActivePotionEffect(Potion.moveSpeed) != null && entity.worldObj.rand.nextInt(3) == 0) {
            final double randx = entity.worldObj.rand.nextGaussian() - 0.5;
            final double randz2 = entity.worldObj.rand.nextGaussian() - 0.5;
            if (entity instanceof EntityPlayer) {
                entity.worldObj.spawnParticle("cloud", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
            else {
                entity.worldObj.spawnParticle("cloud", entity.posX + randx, entity.posY + 1.0, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
        }
        if (entity.getActivePotionEffect(Potion.jump) != null) {
            final double randx = entity.worldObj.rand.nextGaussian() - 0.3;
            final double randz2 = entity.worldObj.rand.nextGaussian() - 0.3;
            if (entity instanceof EntityPlayer) {
                entity.worldObj.spawnParticle("happyVillager", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
            else {
                entity.worldObj.spawnParticle("happyVillager", entity.posX + randx, entity.posY + 1.0, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
        }
        if (entity.getActivePotionEffect(Dungeons.shock) != null && entity instanceof EntityLivingBase && entity.worldObj.rand.nextInt(5) == 0) {
            entity.attackEntityFrom(DamageSource.causeMobDamage(entity), 0.001f);
            entity.worldObj.playSoundAtEntity((Entity)entity, "random.classic_hurt", 1.0f, 1.3f);
            entity.hurtResistantTime = 5;
        }
        if (entity.getActivePotionEffect(Dungeons.growth) != null) {
            double randx = entity.worldObj.rand.nextGaussian() - 0.5;
            double randz2 = entity.worldObj.rand.nextGaussian() - 0.5;
            if (entity instanceof EntityPlayer) {
                entity.worldObj.spawnParticle("happyVillager", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
            else {
                entity.worldObj.spawnParticle("happyVillager", entity.posX + randx, entity.posY + 1.0, entity.posZ + randz2, 0.0, 0.0, 0.0);
            }
            if (entity.worldObj.rand.nextInt(1000) == 0 && !entity.worldObj.isRemote) {
                entity.heal((float)(5 + 2 * entity.getActivePotionEffect(Dungeons.growth).getAmplifier()));
                for (int i = 0; i < 5; ++i) {
                    randx = entity.worldObj.rand.nextGaussian() - 0.5;
                    randz2 = entity.worldObj.rand.nextGaussian() - 0.5;
                    if (entity instanceof EntityPlayer) {
                        entity.worldObj.spawnParticle("heart", entity.posX + randx, entity.posY - 1.6, entity.posZ + randz2, 0.0, 0.0, 0.0);
                    }
                    else {
                        entity.worldObj.spawnParticle("heart", entity.posX + randx, entity.posY + 1.0, entity.posZ + randz2, 0.0, 0.0, 0.0);
                    }
                }
            }
        }
        if (entity.getActivePotionEffect(Dungeons.inflame) != null) {
            for (int j = 0; j < 5; ++j) {
                final double randx2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 4.0;
                final double randz3 = (entity.worldObj.rand.nextGaussian() - 0.5) / 4.0;
                entity.worldObj.spawnParticle("flame", entity.posX + randx2, entity.posY - 1.52, entity.posZ + randz3, 0.0, 0.0, 0.0);
                entity.worldObj.spawnParticle("smoke", entity.posX + randx2, entity.posY - 1.52, entity.posZ + randz3, 0.0, 0.0, 0.0);
            }
            if (entity.worldObj.rand.nextInt(5) == 0) {
                final double randx = (entity.worldObj.rand.nextGaussian() - 0.5) / 4.0;
                final double randz2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 4.0;
                entity.worldObj.spawnParticle("lava", entity.posX + randx, entity.posY + 0.5, entity.posZ + randz2, 0.0, 0.0, 0.0);
                entity.worldObj.playSoundAtEntity((Entity)entity, "random.fizz", 0.5f, 1.0f);
                entity.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
                final List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)entity, entity.boundingBox.expand(10.0, 4.0, 10.0));
                if (list != null) {
                    for (int k2 = 0; k2 < list.size(); ++k2) {
                        if (list.get(k2) instanceof EntityLivingBase && !list.get(k2).isBurning()) {
                            list.get(k2).setFire(5);
                            list.get(k2).attackEntityFrom(DamageSource.causeMobDamage(entity), 0.01f);
                        }
                    }
                }
            }
        }
        if (entity.getActivePotionEffect(Dungeons.magicBoost) != null) {
            for (int j = 0; j < 5; ++j) {
                final double randx2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.0;
                final double randz3 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.0;
                if (entity instanceof EntityPlayer) {
                    entity.worldObj.spawnParticle("enchantmenttable", entity.posX + randx2, entity.posY - 1.52, entity.posZ + randz3, 0.0, 0.0, 0.0);
                    entity.worldObj.spawnParticle("portal", entity.posX + randx2, entity.posY - 1.52, entity.posZ + randz3, 0.0, 0.0, 0.0);
                }
                else {
                    entity.worldObj.spawnParticle("enchantmenttable", entity.posX + randx2, entity.posY, entity.posZ + randz3, 0.0, 0.0, 0.0);
                    entity.worldObj.spawnParticle("portal", entity.posX + randx2, entity.posY, entity.posZ + randz3, 0.0, 0.0, 0.0);
                }
            }
            if (entity instanceof EntityPlayer) {
                final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get((EntityPlayer)entity);
                par4.boostMagic(entity.getActivePotionEffect(Dungeons.magicBoost).getAmplifier() * 3);
            }
        }
        else if (entity instanceof EntityPlayer) {
            final DungeonsExtendedPlayer par4 = DungeonsExtendedPlayer.get((EntityPlayer)entity);
            par4.boostMagic(0);
        }
        if (entity.getActivePotionEffect(Dungeons.storm) != null) {
            if (entity.motionX == 0.0 && entity.motionZ == 0.0) {
                for (int j = 0; j < 20; ++j) {
                    final double randx2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 1.5;
                    final double randz3 = (entity.worldObj.rand.nextGaussian() - 0.5) / 1.5;
                    entity.worldObj.spawnParticle("cloud", entity.posX + randx2, entity.posY + 2.3, entity.posZ + randz3, 0.0, 0.0, 0.0);
                    entity.worldObj.spawnParticle("explode", entity.posX + randx2, entity.posY + 2.3, entity.posZ + randz3, 0.0, 0.0, 0.0);
                }
                for (int j = 0; j < 3; ++j) {
                    final double randx2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.5;
                    final double randz3 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.5;
                    entity.worldObj.spawnParticle("dripWater", entity.posX + randx2, entity.posY + 2.3, entity.posZ + randz3, 0.0, 0.0, 0.0);
                }
            }
            if (entity.worldObj.rand.nextInt(1000) == 0) {
                entity.worldObj.playSoundAtEntity((Entity)entity, "ambient.weather.thunder", 0.5f, 1.0f);
                entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 0));
                entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
                entity.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 0));
                entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 0));
            }
        }
        if (entity.getActivePotionEffect(Dungeons.antigravity) != null) {
            final double randx = (entity.worldObj.rand.nextGaussian() - 0.5) / 4.0;
            final double randz2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 4.0;
            entity.worldObj.spawnParticle("magicCrit", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            entity.worldObj.spawnParticle("crit", entity.posX + randx, entity.posY - 1.52, entity.posZ + randz2, 0.0, 0.0, 0.0);
            if (entity.motionY <= 3.0) {
                final EntityLivingBase entityLivingBase = entity;
                entityLivingBase.motionY += 0.2;
            }
            if (entity.isSneaking()) {
                entity.motionY = -0.6;
                if (Math.abs(entity.motionX) < 0.6) {
                    final EntityLivingBase entityLivingBase2 = entity;
                    entityLivingBase2.motionX *= 1.05;
                }
                if (Math.abs(entity.motionZ) < 0.6) {
                    final EntityLivingBase entityLivingBase3 = entity;
                    entityLivingBase3.motionZ *= 1.05;
                }
                entity.fallDistance = 0.0f;
            }
        }
        if (entity.getActivePotionEffect(Dungeons.shadowAura) != null) {
            for (int j = 0; j < 15; ++j) {
                final double randx2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.0;
                final double randz3 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.0;
                if (entity instanceof EntityPlayer && entity.worldObj.isRemote) {
                    final double timePassed = (entity.ticksExisted / 2 + j * 40) / 10;
                    final double particlePositionX = Math.cos(timePassed) * 2.0;
                    final double particlePositionY = Math.sin(timePassed) * 2.0;
                    final double particlePositionZ = Math.sin(timePassed) * 2.0;
                    final EntityFlameFX particle = new EntityFlameFX(entity.worldObj, entity.posX + particlePositionX, entity.posY - 1.52, entity.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                    particle.setRBGColorF(0.0f, 0.1f, 0.6f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
                else {
                    entity.worldObj.spawnParticle("mobSpellAmbient", entity.posX + randx2, entity.posY + 1.0, entity.posZ + randz3, 0.0, 0.0, 0.0);
                    entity.worldObj.spawnParticle("instantSpell", entity.posX + randx2, entity.posY + 1.0, entity.posZ + randz3, 0.0, 0.0, 0.0);
                    entity.worldObj.spawnParticle("largesmoke", entity.posX + randx2, entity.posY + 1.0, entity.posZ + randz3, 0.0, 0.0, 0.0);
                }
            }
            if (entity instanceof EntityLivingBase) {
                final List list2 = entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)entity, entity.boundingBox.expand(10.0, 4.0, 10.0));
                if (list2 != null) {
                    for (int k3 = 0; k3 < list2.size(); ++k3) {
                        if (list2.get(k3) instanceof EntityLivingBase && !list2.get(k3).isBurning()) {
                            list2.get(k3).addPotionEffect(new PotionEffect(Potion.wither.id, 60, 1));
                            list2.get(k3).attackEntityFrom(DamageSource.causeMobDamage(entity), 0.01f);
                        }
                    }
                }
            }
        }
        if (entity.getActivePotionEffect(Dungeons.crystalliumBlessing) != null) {
            entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 3));
            for (int j = 0; j < 15; ++j) {
                final double randx2 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.0;
                final double randz3 = (entity.worldObj.rand.nextGaussian() - 0.5) / 2.0;
                if (entity instanceof EntityPlayer && entity.worldObj.isRemote) {
                    final double timePassed = (entity.ticksExisted + j * 40) / 10;
                    final double particlePositionX = Math.cos(timePassed) * 2.0;
                    final double particlePositionY = Math.sin(timePassed) * 2.0;
                    final double particlePositionZ = Math.sin(timePassed) * 2.0;
                    EntityFlameFX particle = new EntityFlameFX(entity.worldObj, entity.posX + particlePositionX, entity.posY + particlePositionY, entity.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                    particle.setRBGColorF(0.1f, 0.0f, 1.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                    particle = new EntityFlameFX(entity.worldObj, entity.posX + particlePositionX, entity.posY - particlePositionY, entity.posZ + particlePositionZ, 0.0, 0.0, 0.0);
                    particle.setRBGColorF(0.1f, 0.0f, 1.0f);
                    Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
                }
            }
            if (entity instanceof EntityLivingBase) {
                final List list2 = entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)entity, entity.boundingBox.expand(10.0, 4.0, 10.0));
                if (list2 != null) {
                    for (int k3 = 0; k3 < list2.size(); ++k3) {
                        if (list2.get(k3) instanceof EntityLivingBase && !list2.get(k3).isBurning()) {
                            list2.get(k3).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
                        }
                    }
                }
            }
        }
        if (entity.getActivePotionEffect(Dungeons.imbalance) != null && entity.ticksExisted % 10 == 0 && entity.onGround) {
            final EntityLivingBase entityLivingBase4 = entity;
            entityLivingBase4.motionX += Dungeons.randRange(-1, 1) / 1.9999;
            final EntityLivingBase entityLivingBase5 = entity;
            entityLivingBase5.motionZ += Dungeons.randRange(-1, 1) / 1.9999;
        }
    }
    
    @SubscribeEvent
    public void onLivingHurtEvent(final LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            if (event.source == DamageSource.magic || event.source == DamageSource.causeIndirectMagicDamage(event.source.getEntity(), event.entity)) {
                this.MagicArmor((EntityPlayer)event.entityLiving);
                System.out.println(event.ammount);
                final double f = 1.0 + this.totalMagicDefence * 8 * 0.01;
                event.ammount /= (float)f;
                System.out.println(f);
                System.out.println(event.ammount);
            }
            if (event.source == DamageSource.outOfWorld) {
                this.voidArmor((EntityPlayer)event.entityLiving);
                System.out.println(event.ammount);
                final double f = 1.0 + this.totalVoidDefence * 8 * 0.01;
                event.ammount /= (float)f;
                System.out.println(f);
                System.out.println(event.ammount);
            }
        }
    }
    
    public void MagicArmor(final EntityPlayer player) {
        int bootDefence = 0;
        int leggingDefence = 0;
        int chestplateDefence = 0;
        int helmetDefence = 0;
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(0).getItem();
            bootDefence = armor.getMagicDefence();
        }
        if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(1).getItem();
            leggingDefence = armor.getMagicDefence();
        }
        if (player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(2).getItem();
            chestplateDefence = armor.getMagicDefence();
        }
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(3).getItem();
            helmetDefence = armor.getMagicDefence();
        }
        this.totalMagicDefence = bootDefence + leggingDefence + chestplateDefence + helmetDefence;
    }
    
    public void voidArmor(final EntityPlayer player) {
        int bootDefence = 0;
        int leggingDefence = 0;
        int chestplateDefence = 0;
        int helmetDefence = 0;
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(0).getItem();
            bootDefence = armor.getVoidDefence();
        }
        if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(1).getItem();
            leggingDefence = armor.getVoidDefence();
        }
        if (player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(2).getItem();
            chestplateDefence = armor.getVoidDefence();
        }
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() instanceof ItemTripleArmor) {
            final ItemTripleArmor armor = (ItemTripleArmor)player.getCurrentArmor(3).getItem();
            helmetDefence = armor.getVoidDefence();
        }
        this.totalVoidDefence = bootDefence + leggingDefence + chestplateDefence + helmetDefence;
    }
}
