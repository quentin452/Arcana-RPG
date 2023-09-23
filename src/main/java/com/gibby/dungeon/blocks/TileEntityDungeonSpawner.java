

package com.gibby.dungeon.blocks;

import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import com.gibby.dungeon.*;
import com.gibby.dungeon.mobs.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;

public class TileEntityDungeonSpawner extends TileEntity
{
    public static final String publicName = "tileEntityDungeonSpawner";

    private int mobId;
    private int mobCount;
    private String name;

    public TileEntityDungeonSpawner() {
        this.mobCount = 1;
        this.name = "tileEntityDungeonSpawner";
    }

    public String getName() {
        return this.name;
    }

    public void updateEntity() {
        this.worldObj.spawnParticle("flame", this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5, 0.0, 0.0, 0.0);
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            final EntityPlayer player = this.worldObj.getClosestPlayer((double)this.xCoord, (double)this.yCoord, (double)this.zCoord, 14.0);
            if (player != null && !player.capabilities.isCreativeMode) {
                switch (this.mobId) {
                    case 1: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityGoblin entity = new EntityGoblin(this.worldObj);
                            entity.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity);
                            entity.onSpawnWithEgg((IEntityLivingData)null);
                            entity.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 14: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityAmethystMonster entity2 = new EntityAmethystMonster(this.worldObj);
                            entity2.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity2);
                            entity2.onSpawnWithEgg((IEntityLivingData)null);
                            entity2.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 5: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityBandit entity3 = new EntityBandit(this.worldObj);
                            entity3.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity3);
                            entity3.onSpawnWithEgg((IEntityLivingData)null);
                            entity3.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 6: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityBlackKnight entity4 = new EntityBlackKnight(this.worldObj);
                            entity4.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity4);
                            entity4.onSpawnWithEgg((IEntityLivingData)null);
                            entity4.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 3: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityEarthGolem entity5 = new EntityEarthGolem(this.worldObj);
                            entity5.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity5);
                            entity5.onSpawnWithEgg((IEntityLivingData)null);
                            entity5.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 16: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityLavaKnight entity6 = new EntityLavaKnight(this.worldObj);
                            entity6.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity6);
                            entity6.onSpawnWithEgg((IEntityLivingData)null);
                            entity6.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 7: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityNecro entity7 = new EntityNecro(this.worldObj);
                            entity7.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity7);
                            entity7.onSpawnWithEgg((IEntityLivingData)null);
                            entity7.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 13: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityNetherSoul entity8 = new EntityNetherSoul(this.worldObj);
                            entity8.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity8);
                            entity8.onSpawnWithEgg((IEntityLivingData)null);
                            entity8.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 12: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientWarrior entity9 = new EntitySapientWarrior(this.worldObj);
                            entity9.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity9);
                            entity9.onSpawnWithEgg((IEntityLivingData)null);
                            entity9.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 11: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySkeletonKnight entity10 = new EntitySkeletonKnight(this.worldObj);
                            entity10.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity10);
                            entity10.onSpawnWithEgg((IEntityLivingData)null);
                            entity10.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 2: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySkeletonWarrior entity11 = new EntitySkeletonWarrior(this.worldObj);
                            entity11.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity11);
                            entity11.onSpawnWithEgg((IEntityLivingData)null);
                            entity11.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 10: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySpirit entity12 = new EntitySpirit(this.worldObj);
                            entity12.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity12);
                            entity12.onSpawnWithEgg((IEntityLivingData)null);
                            entity12.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 4: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityStoneGolem entity13 = new EntityStoneGolem(this.worldObj);
                            entity13.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity13);
                            entity13.onSpawnWithEgg((IEntityLivingData)null);
                            entity13.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 8: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTroll entity14 = new EntityTroll(this.worldObj);
                            entity14.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity14);
                            entity14.onSpawnWithEgg((IEntityLivingData)null);
                            entity14.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 15: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVampire entity15 = new EntityVampire(this.worldObj);
                            entity15.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity15);
                            entity15.onSpawnWithEgg((IEntityLivingData)null);
                            entity15.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 9: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVoidFiend entity16 = new EntityVoidFiend(this.worldObj);
                            entity16.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity16);
                            entity16.onSpawnWithEgg((IEntityLivingData)null);
                            entity16.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 17: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySkeleton entity17 = new EntitySkeleton(this.worldObj);
                            entity17.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity17);
                            entity17.onSpawnWithEgg((IEntityLivingData)null);
                            entity17.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 18: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityZombie entity18 = new EntityZombie(this.worldObj);
                            entity18.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity18);
                            entity18.onSpawnWithEgg((IEntityLivingData)null);
                            entity18.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 19: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityZombieWarlord entity19 = new EntityZombieWarlord(this.worldObj);
                            entity19.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity19);
                            entity19.onSpawnWithEgg((IEntityLivingData)null);
                            entity19.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 20: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySpecter entity20 = new EntitySpecter(this.worldObj);
                            entity20.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity20);
                            entity20.onSpawnWithEgg((IEntityLivingData)null);
                            entity20.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 21: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityBigStoneGolem entity21 = new EntityBigStoneGolem(this.worldObj);
                            entity21.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity21);
                            entity21.onSpawnWithEgg((IEntityLivingData)null);
                            entity21.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 22: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityVoidLord entity22 = new EntityVoidLord(this.worldObj);
                            entity22.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity22);
                            entity22.onSpawnWithEgg((IEntityLivingData)null);
                            entity22.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 23: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDarkKnight entity23 = new EntityDarkKnight(this.worldObj);
                            entity23.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity23);
                            entity23.onSpawnWithEgg((IEntityLivingData)null);
                            entity23.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 24: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDesertDragger entity24 = new EntityDesertDragger(this.worldObj);
                            entity24.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity24);
                            entity24.onSpawnWithEgg((IEntityLivingData)null);
                            entity24.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 25: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTavernMaster entity25 = new EntityTavernMaster(this.worldObj);
                            entity25.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity25);
                            entity25.onSpawnWithEgg((IEntityLivingData)null);
                            entity25.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 26: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityTavernClient entity26 = new EntityTavernClient(this.worldObj);
                            entity26.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity26);
                            entity26.onSpawnWithEgg((IEntityLivingData)null);
                            entity26.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 27: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityNetherWalker entity27 = new EntityNetherWalker(this.worldObj);
                            entity27.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity27);
                            entity27.onSpawnWithEgg((IEntityLivingData)null);
                            entity27.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 28: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientEliteKnight entity28 = new EntitySapientEliteKnight(this.worldObj);
                            entity28.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity28);
                            entity28.onSpawnWithEgg((IEntityLivingData)null);
                            entity28.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 29: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientGeneral entity29 = new EntitySapientGeneral(this.worldObj);
                            entity29.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity29);
                            entity29.onSpawnWithEgg((IEntityLivingData)null);
                            entity29.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 30: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityYeti entity30 = new EntityYeti(this.worldObj);
                            entity30.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity30);
                            entity30.onSpawnWithEgg((IEntityLivingData)null);
                            entity30.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 31: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityChainMummy entity31 = new EntityChainMummy(this.worldObj);
                            entity31.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity31);
                            entity31.onSpawnWithEgg((IEntityLivingData)null);
                            entity31.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 32: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityEyeWarrior entity32 = new EntityEyeWarrior(this.worldObj);
                            entity32.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity32);
                            entity32.onSpawnWithEgg((IEntityLivingData)null);
                            entity32.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 33: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySnowGiant entity33 = new EntitySnowGiant(this.worldObj);
                            entity33.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity33);
                            entity33.onSpawnWithEgg((IEntityLivingData)null);
                            entity33.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 34: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDeathBringer entity34 = new EntityDeathBringer(this.worldObj);
                            entity34.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity34);
                            entity34.onSpawnWithEgg((IEntityLivingData)null);
                            entity34.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 35: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityDungeonBeast entity35 = new EntityDungeonBeast(this.worldObj);
                            entity35.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity35);
                            entity35.onSpawnWithEgg((IEntityLivingData)null);
                            entity35.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 36: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityIceShielder entity36 = new EntityIceShielder(this.worldObj);
                            entity36.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity36);
                            entity36.onSpawnWithEgg((IEntityLivingData)null);
                            entity36.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 37: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityOrc entity37 = new EntityOrc(this.worldObj);
                            entity37.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity37);
                            entity37.onSpawnWithEgg((IEntityLivingData)null);
                            entity37.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 38: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityOrcMage entity38 = new EntityOrcMage(this.worldObj);
                            entity38.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity38);
                            entity38.onSpawnWithEgg((IEntityLivingData)null);
                            entity38.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 39: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityOrcDefender entity39 = new EntityOrcDefender(this.worldObj);
                            entity39.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity39);
                            entity39.onSpawnWithEgg((IEntityLivingData)null);
                            entity39.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 40: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityRockTroll entity40 = new EntityRockTroll(this.worldObj);
                            entity40.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity40);
                            entity40.onSpawnWithEgg((IEntityLivingData)null);
                            entity40.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 41: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityEarthRupturer entity41 = new EntityEarthRupturer(this.worldObj);
                            entity41.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity41);
                            entity41.onSpawnWithEgg((IEntityLivingData)null);
                            entity41.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 42: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntitySapientMage entity42 = new EntitySapientMage(this.worldObj);
                            entity42.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity42);
                            entity42.onSpawnWithEgg((IEntityLivingData)null);
                            entity42.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                    case 43: {
                        for (int i = 0; i < this.mobCount; ++i) {
                            final EntityAnchorTrader entity43 = new EntityAnchorTrader(this.worldObj);
                            entity43.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                            this.worldObj.spawnEntityInWorld((Entity)entity43);
                            entity43.onSpawnWithEgg((IEntityLivingData)null);
                            entity43.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
                        }
                        break;
                    }
                }
                this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
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
        compound.setTag("tileEntityDungeonSpawner", (NBTBase)properties);
    }

    public void readFromNBT(final NBTTagCompound compound) {
        super.readFromNBT(compound);
        final NBTTagCompound properties = (NBTTagCompound)compound.getTag("tileEntityDungeonSpawner");
        this.mobId = properties.getInteger("MobId");
        this.mobCount = properties.getInteger("Amount");
    }
}
