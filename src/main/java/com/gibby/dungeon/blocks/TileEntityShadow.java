package com.gibby.dungeon.blocks;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.mobs.entityinstance.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityShadow extends TileEntity
{
    public static final String publicName = "tileEntityShadow";
    private int mobId;
    private int mobCount;
    private final String name;

    public TileEntityShadow() {
        this.mobCount = 1;
        this.name = "tileEntityShadow";
    }

    public String getName() {
        return this.name;
    }

    public void updateEntity() {
        EntityPlayer player = this.worldObj.getClosestPlayer(this.xCoord, this.yCoord, this.zCoord, 80.0);
        if (player != null && this.worldObj.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Dungeons.incandescentCharge) {
            for (int i = 0; i < 70; ++i) {
                final int rand2Y = this.worldObj.rand.nextInt(18);
                final float rand = Dungeons.randFloat();
                final double rand2X = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                final double rand2Z = this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian();
                this.worldObj.spawnParticle("reddust", this.xCoord + rand2X + -(rand2X + rand2Z / 2.0) + 0.6, this.yCoord + rand2Y - 2.5, this.zCoord + rand2Z + (float)(-(rand2Z + rand2X / 2.0)) + 0.5, -0.4, -0.4, -0.4);
            }
        }
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            player = this.worldObj.getClosestPlayer(this.xCoord, this.yCoord, this.zCoord, 20.0);
            if (player != null && !player.capabilities.isCreativeMode && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Dungeons.incandescentCharge) {
                player.inventory.consumeInventoryItem(Dungeons.incandescentCharge);
                switch (this.mobId) {
                    case 1: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityGoblin entity = new EntityGoblin(this.worldObj);
                            entity.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity);
                            entity.onSpawnWithEgg(null);
                            entity.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 14: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityAmethystMonster entity2 = new EntityAmethystMonster(this.worldObj);
                            entity2.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity2);
                            entity2.onSpawnWithEgg(null);
                            entity2.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 5: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityBandit entity3 = new EntityBandit(this.worldObj);
                            entity3.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity3);
                            entity3.onSpawnWithEgg(null);
                            entity3.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 6: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityBlackKnight entity4 = new EntityBlackKnight(this.worldObj);
                            entity4.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity4);
                            entity4.onSpawnWithEgg(null);
                            entity4.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 3: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityEarthGolem entity5 = new EntityEarthGolem(this.worldObj);
                            entity5.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity5);
                            entity5.onSpawnWithEgg(null);
                            entity5.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 16: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityLavaKnight entity6 = new EntityLavaKnight(this.worldObj);
                            entity6.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity6);
                            entity6.onSpawnWithEgg(null);
                            entity6.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 7: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityNecro entity7 = new EntityNecro(this.worldObj);
                            entity7.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity7);
                            entity7.onSpawnWithEgg(null);
                            entity7.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 13: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityNetherSoul entity8 = new EntityNetherSoul(this.worldObj);
                            entity8.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity8);
                            entity8.onSpawnWithEgg(null);
                            entity8.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 12: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientWarrior entity9 = new EntitySapientWarrior(this.worldObj);
                            entity9.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity9);
                            entity9.onSpawnWithEgg(null);
                            entity9.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 11: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySkeletonKnight entity10 = new EntitySkeletonKnight(this.worldObj);
                            entity10.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity10);
                            entity10.onSpawnWithEgg(null);
                            entity10.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 2: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySkeletonWarrior entity11 = new EntitySkeletonWarrior(this.worldObj);
                            entity11.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity11);
                            entity11.onSpawnWithEgg(null);
                            entity11.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 10: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySpirit entity12 = new EntitySpirit(this.worldObj);
                            entity12.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity12);
                            entity12.onSpawnWithEgg(null);
                            entity12.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 4: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityStoneGolem entity13 = new EntityStoneGolem(this.worldObj);
                            entity13.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity13);
                            entity13.onSpawnWithEgg(null);
                            entity13.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 8: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTroll entity14 = new EntityTroll(this.worldObj);
                            entity14.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity14);
                            entity14.onSpawnWithEgg(null);
                            entity14.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 15: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVampire entity15 = new EntityVampire(this.worldObj);
                            entity15.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity15);
                            entity15.onSpawnWithEgg(null);
                            entity15.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 9: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVoidFiend entity16 = new EntityVoidFiend(this.worldObj);
                            entity16.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity16);
                            entity16.onSpawnWithEgg(null);
                            entity16.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 17: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySkeleton entity17 = new EntitySkeleton(this.worldObj);
                            entity17.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity17);
                            entity17.onSpawnWithEgg(null);
                            entity17.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 18: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityZombie entity18 = new EntityZombie(this.worldObj);
                            entity18.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity18);
                            entity18.onSpawnWithEgg(null);
                            entity18.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 19: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityZombieWarlord entity19 = new EntityZombieWarlord(this.worldObj);
                            entity19.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity19);
                            entity19.onSpawnWithEgg(null);
                            entity19.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 20: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySpecter entity20 = new EntitySpecter(this.worldObj);
                            entity20.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity20);
                            entity20.onSpawnWithEgg(null);
                            entity20.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 21: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityBigStoneGolem entity21 = new EntityBigStoneGolem(this.worldObj);
                            entity21.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity21);
                            entity21.onSpawnWithEgg(null);
                            entity21.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 22: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVoidLord entity22 = new EntityVoidLord(this.worldObj);
                            entity22.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity22);
                            entity22.onSpawnWithEgg(null);
                            entity22.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 23: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDarkKnight entity23 = new EntityDarkKnight(this.worldObj);
                            entity23.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity23);
                            entity23.onSpawnWithEgg(null);
                            entity23.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 24: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDesertDragger entity24 = new EntityDesertDragger(this.worldObj);
                            entity24.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity24);
                            entity24.onSpawnWithEgg(null);
                            entity24.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 25: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTavernMaster entity25 = new EntityTavernMaster(this.worldObj);
                            entity25.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity25);
                            entity25.onSpawnWithEgg(null);
                            entity25.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 26: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTavernClient entity26 = new EntityTavernClient(this.worldObj);
                            entity26.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity26);
                            entity26.onSpawnWithEgg(null);
                            entity26.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 27: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityNetherWalker entity27 = new EntityNetherWalker(this.worldObj);
                            entity27.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity27);
                            entity27.onSpawnWithEgg(null);
                            entity27.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 28: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientEliteKnight entity28 = new EntitySapientEliteKnight(this.worldObj);
                            entity28.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity28);
                            entity28.onSpawnWithEgg(null);
                            entity28.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 29: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientGeneral entity29 = new EntitySapientGeneral(this.worldObj);
                            entity29.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity29);
                            entity29.onSpawnWithEgg(null);
                            entity29.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 30: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityYeti entity30 = new EntityYeti(this.worldObj);
                            entity30.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity30);
                            entity30.onSpawnWithEgg(null);
                            entity30.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 31: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityChainMummy entity31 = new EntityChainMummy(this.worldObj);
                            entity31.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity31);
                            entity31.onSpawnWithEgg(null);
                            entity31.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 32: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityEyeWarrior entity32 = new EntityEyeWarrior(this.worldObj);
                            entity32.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity32);
                            entity32.onSpawnWithEgg(null);
                            entity32.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 33: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySnowGiant entity33 = new EntitySnowGiant(this.worldObj);
                            entity33.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity33);
                            entity33.onSpawnWithEgg(null);
                            entity33.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 34: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDeathBringer entity34 = new EntityDeathBringer(this.worldObj);
                            entity34.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity34);
                            entity34.onSpawnWithEgg(null);
                            entity34.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 35: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDungeonBeast entity35 = new EntityDungeonBeast(this.worldObj);
                            entity35.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity35);
                            entity35.onSpawnWithEgg(null);
                            entity35.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 36: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityIceShielder entity36 = new EntityIceShielder(this.worldObj);
                            entity36.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity36);
                            entity36.onSpawnWithEgg(null);
                            entity36.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 37: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityOrc entity37 = new EntityOrc(this.worldObj);
                            entity37.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity37);
                            entity37.onSpawnWithEgg(null);
                            entity37.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 38: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityOrcMage entity38 = new EntityOrcMage(this.worldObj);
                            entity38.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity38);
                            entity38.onSpawnWithEgg(null);
                            entity38.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 39: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityOrcDefender entity39 = new EntityOrcDefender(this.worldObj);
                            entity39.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity39);
                            entity39.onSpawnWithEgg(null);
                            entity39.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 40: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityRockTroll entity40 = new EntityRockTroll(this.worldObj);
                            entity40.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity40);
                            entity40.onSpawnWithEgg(null);
                            entity40.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 41: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityEarthRupturer entity41 = new EntityEarthRupturer(this.worldObj);
                            entity41.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity41);
                            entity41.onSpawnWithEgg(null);
                            entity41.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 42: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientMage entity42 = new EntitySapientMage(this.worldObj);
                            entity42.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity42);
                            entity42.onSpawnWithEgg(null);
                            entity42.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 43: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityAnchorTrader entity43 = new EntityAnchorTrader(this.worldObj);
                            entity43.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity43);
                            entity43.onSpawnWithEgg(null);
                            entity43.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 44: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientMiner entity44 = new EntitySapientMiner(this.worldObj);
                            entity44.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity44);
                            entity44.onSpawnWithEgg(null);
                            entity44.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 45: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVillager entity45 = new EntityVillager(this.worldObj);
                            entity45.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity45);
                            entity45.onSpawnWithEgg(null);
                            entity45.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 46: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityPaladin entity46 = new EntityPaladin(this.worldObj);
                            entity46.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity46);
                            entity46.onSpawnWithEgg(null);
                            entity46.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 47: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTreeGolem entity47 = new EntityTreeGolem(this.worldObj);
                            entity47.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity47);
                            entity47.onSpawnWithEgg(null);
                            entity47.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 48: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityMidnightMagician entity48 = new EntityMidnightMagician(this.worldObj);
                            entity48.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity48);
                            entity48.onSpawnWithEgg(null);
                            entity48.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 49: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityMidnightShade entity49 = new EntityMidnightShade(this.worldObj);
                            entity49.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld(entity49);
                            entity49.onSpawnWithEgg(null);
                            entity49.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                }
                for (int x = -5; x < 5; ++x) {
                    for (int y = -2; y < 8; ++y) {
                        for (int z = -5; z < 5; ++z) {
                            this.worldObj.setBlockToAir(this.xCoord + x, this.yCoord + y, this.zCoord + z);
                        }
                    }
                }
                this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
                this.worldObj.setBlockToAir(this.xCoord, this.yCoord - 1, this.zCoord);
                this.worldObj.setBlockToAir(this.xCoord, this.yCoord - 2, this.zCoord);
            }
        }
    }

    public void setMobName(final int mobId) {
        this.mobId = mobId;
    }

    public void setMobCount(final int amount) {
        this.mobCount = amount;
    }

    public void writeToNBT(final NBTTagCompound compound) {
        super.writeToNBT(compound);
        final NBTTagCompound properties = new NBTTagCompound();
        properties.setInteger("MobId", this.mobId);
        properties.setInteger("Amount", this.mobCount);
        compound.setTag("tileEntityShadow", properties);
    }

    public void readFromNBT(final NBTTagCompound compound) {
        super.readFromNBT(compound);
        final NBTTagCompound properties = (NBTTagCompound)compound.getTag("tileEntityShadow");
        this.mobId = properties.getInteger("MobId");
        this.mobCount = properties.getInteger("Amount");
    }
}
