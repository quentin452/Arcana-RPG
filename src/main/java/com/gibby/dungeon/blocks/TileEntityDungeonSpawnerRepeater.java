

package com.gibby.dungeon.blocks;

import com.gibby.dungeon.mobs.entityinstance.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDungeonSpawnerRepeater extends TileEntity
{
    public static final String publicName = "tileEntityDungeonSpawnerRepeater";
    private int mobId;
    private int mobCount;
    private int cooldown;
    private int count;
    private String name;

    public TileEntityDungeonSpawnerRepeater() {
        this.name = "tileEntityDungeonSpawnerRepeater";
    }

    public String getName() {
        return this.name;
    }

    public void updateEntity() {
        super.updateEntity();
        this.worldObj.spawnParticle("flame", this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5, 0.0, 0.0, 0.0);
        if (!this.worldObj.isRemote) {
            final EntityPlayer player = this.worldObj.getClosestPlayer(this.xCoord,this.yCoord,this.zCoord, 10.0);
            if (player != null) {
                ++this.count;
                if (this.count > this.cooldown) {
                    this.count = 0;
                    int yPos;
                    for (yPos = this.yCoord; !this.worldObj.isAirBlock(this.xCoord, yPos, this.zCoord); ++yPos) {}
                    switch (this.mobId) {
                        case 1: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityGoblin entity = new EntityGoblin(this.worldObj);
                                entity.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity);
                                entity.onSpawnWithEgg(null);
                                entity.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 14: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityAmethystMonster entity2 = new EntityAmethystMonster(this.worldObj);
                                entity2.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity2);
                                entity2.onSpawnWithEgg(null);
                                entity2.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 5: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityBandit entity3 = new EntityBandit(this.worldObj);
                                entity3.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity3);
                                entity3.onSpawnWithEgg(null);
                                entity3.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 6: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityBlackKnight entity4 = new EntityBlackKnight(this.worldObj);
                                entity4.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity4);
                                entity4.onSpawnWithEgg(null);
                                entity4.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 3: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityEarthGolem entity5 = new EntityEarthGolem(this.worldObj);
                                entity5.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity5);
                                entity5.onSpawnWithEgg(null);
                                entity5.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 16: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityLavaKnight entity6 = new EntityLavaKnight(this.worldObj);
                                entity6.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity6);
                                entity6.onSpawnWithEgg(null);
                                entity6.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 7: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityNecro entity7 = new EntityNecro(this.worldObj);
                                entity7.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity7);
                                entity7.onSpawnWithEgg(null);
                                entity7.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 13: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityNetherSoul entity8 = new EntityNetherSoul(this.worldObj);
                                entity8.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity8);
                                entity8.onSpawnWithEgg(null);
                                entity8.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 12: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySapientWarrior entity9 = new EntitySapientWarrior(this.worldObj);
                                entity9.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity9);
                                entity9.onSpawnWithEgg(null);
                                entity9.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 11: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySkeletonKnight entity10 = new EntitySkeletonKnight(this.worldObj);
                                entity10.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity10);
                                entity10.onSpawnWithEgg(null);
                                entity10.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 2: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySkeletonWarrior entity11 = new EntitySkeletonWarrior(this.worldObj);
                                entity11.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity11);
                                entity11.onSpawnWithEgg(null);
                                entity11.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 10: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySpirit entity12 = new EntitySpirit(this.worldObj);
                                entity12.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity12);
                                entity12.onSpawnWithEgg(null);
                                entity12.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 4: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityStoneGolem entity13 = new EntityStoneGolem(this.worldObj);
                                entity13.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity13);
                                entity13.onSpawnWithEgg(null);
                                entity13.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 8: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityTroll entity14 = new EntityTroll(this.worldObj);
                                entity14.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity14);
                                entity14.onSpawnWithEgg(null);
                                entity14.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 15: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityVampire entity15 = new EntityVampire(this.worldObj);
                                entity15.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity15);
                                entity15.onSpawnWithEgg(null);
                                entity15.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 9: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityVoidFiend entity16 = new EntityVoidFiend(this.worldObj);
                                entity16.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity16);
                                entity16.onSpawnWithEgg(null);
                                entity16.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 17: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySkeleton entity17 = new EntitySkeleton(this.worldObj);
                                entity17.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity17);
                                entity17.onSpawnWithEgg(null);
                                entity17.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 18: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityZombie entity18 = new EntityZombie(this.worldObj);
                                entity18.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity18);
                                entity18.onSpawnWithEgg(null);
                                entity18.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 19: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityZombieWarlord entity19 = new EntityZombieWarlord(this.worldObj);
                                entity19.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity19);
                                entity19.onSpawnWithEgg(null);
                                entity19.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 20: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySpecter entity20 = new EntitySpecter(this.worldObj);
                                entity20.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity20);
                                entity20.onSpawnWithEgg(null);
                                entity20.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 21: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityBigStoneGolem entity21 = new EntityBigStoneGolem(this.worldObj);
                                entity21.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity21);
                                entity21.onSpawnWithEgg(null);
                                entity21.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 22: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityVoidLord entity22 = new EntityVoidLord(this.worldObj);
                                entity22.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity22);
                                entity22.onSpawnWithEgg(null);
                                entity22.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 24: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityDesertDragger entity23 = new EntityDesertDragger(this.worldObj);
                                entity23.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity23);
                                entity23.onSpawnWithEgg(null);
                                entity23.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 25: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityTavernMaster entity24 = new EntityTavernMaster(this.worldObj);
                                entity24.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity24);
                                entity24.onSpawnWithEgg(null);
                                entity24.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 26: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityTavernClient entity25 = new EntityTavernClient(this.worldObj);
                                entity25.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity25);
                                entity25.onSpawnWithEgg(null);
                                entity25.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 27: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityNetherWalker entity26 = new EntityNetherWalker(this.worldObj);
                                entity26.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity26);
                                entity26.onSpawnWithEgg(null);
                                entity26.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 28: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySapientEliteKnight entity27 = new EntitySapientEliteKnight(this.worldObj);
                                entity27.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity27);
                                entity27.onSpawnWithEgg(null);
                                entity27.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 29: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySapientGeneral entity28 = new EntitySapientGeneral(this.worldObj);
                                entity28.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity28);
                                entity28.onSpawnWithEgg(null);
                                entity28.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 30: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityYeti entity29 = new EntityYeti(this.worldObj);
                                entity29.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity29);
                                entity29.onSpawnWithEgg(null);
                                entity29.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 31: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityChainMummy entity30 = new EntityChainMummy(this.worldObj);
                                entity30.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity30);
                                entity30.onSpawnWithEgg(null);
                                entity30.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 32: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityEyeWarrior entity31 = new EntityEyeWarrior(this.worldObj);
                                entity31.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity31);
                                entity31.onSpawnWithEgg(null);
                                entity31.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 33: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySnowGiant entity32 = new EntitySnowGiant(this.worldObj);
                                entity32.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity32);
                                entity32.onSpawnWithEgg(null);
                                entity32.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 34: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityDeathBringer entity33 = new EntityDeathBringer(this.worldObj);
                                entity33.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity33);
                                entity33.onSpawnWithEgg(null);
                                entity33.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 35: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityDungeonBeast entity34 = new EntityDungeonBeast(this.worldObj);
                                entity34.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity34);
                                entity34.onSpawnWithEgg(null);
                                entity34.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 36: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityIceShielder entity35 = new EntityIceShielder(this.worldObj);
                                entity35.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity35);
                                entity35.onSpawnWithEgg(null);
                                entity35.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 37: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityOrc entity36 = new EntityOrc(this.worldObj);
                                entity36.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity36);
                                entity36.onSpawnWithEgg(null);
                                entity36.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 38: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityOrcMage entity37 = new EntityOrcMage(this.worldObj);
                                entity37.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity37);
                                entity37.onSpawnWithEgg(null);
                                entity37.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 39: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityOrcDefender entity38 = new EntityOrcDefender(this.worldObj);
                                entity38.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity38);
                                entity38.onSpawnWithEgg(null);
                                entity38.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 40: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityRockTroll entity39 = new EntityRockTroll(this.worldObj);
                                entity39.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity39);
                                entity39.onSpawnWithEgg(null);
                                entity39.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 41: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityEarthRupturer entity40 = new EntityEarthRupturer(this.worldObj);
                                entity40.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity40);
                                entity40.onSpawnWithEgg(null);
                                entity40.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 42: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntitySapientMage entity41 = new EntitySapientMage(this.worldObj);
                                entity41.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity41);
                                entity41.onSpawnWithEgg(null);
                                entity41.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                        case 43: {
                            for (int i = 0; i < this.mobCount; ++i) {
                                final EntityAnchorTrader entity42 = new EntityAnchorTrader(this.worldObj);
                                entity42.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                                this.worldObj.spawnEntityInWorld(entity42);
                                entity42.onSpawnWithEgg(null);
                                entity42.setPosition(this.xCoord + 0.5, yPos + 0.5, this.zCoord + 0.5);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void setMobName(final int mobId) {
        this.mobId = mobId;
    }

    public void setMobCount(final int amount) {
        this.mobCount = amount;
    }

    public void setCooldown(final int cooldown) {
        this.cooldown = cooldown;
        this.count = cooldown;
    }

    public void writeToNBT(final NBTTagCompound compound) {
        super.writeToNBT(compound);
        final NBTTagCompound properties = new NBTTagCompound();
        properties.setInteger("MobId", this.mobId);
        properties.setInteger("Amount", this.mobCount);
        properties.setInteger("Cooldown", this.cooldown);
        properties.setInteger("Count", this.count);
        compound.setTag("tileEntityDungeonSpawnerRepeater", properties);
    }

    public void readFromNBT(final NBTTagCompound compound) {
        super.readFromNBT(compound);
        final NBTTagCompound properties = (NBTTagCompound)compound.getTag("tileEntityDungeonSpawnerRepeater");
        this.mobId = properties.getInteger("MobId");
        this.mobCount = properties.getInteger("Amount");
        this.cooldown = properties.getInteger("Cooldown");
        this.count = properties.getInteger("Count");
    }
}
