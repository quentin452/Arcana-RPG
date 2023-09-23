

package com.gibby.dungeon.gen;

import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class TeleporterMontane extends Teleporter
{
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache;
    private final List destinationCoordinateKeys;
    
    public TeleporterMontane(final WorldServer par1WorldServer) {
        super(par1WorldServer);
        this.destinationCoordinateCache = new LongHashMap();
        this.destinationCoordinateKeys = new ArrayList();
        this.worldServerInstance = par1WorldServer;
        this.random = new Random(par1WorldServer.getSeed());
    }
    
    public void placeInPortal(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8) {
        if (this.worldServerInstance.provider.dimensionId == Dungeons.montaneDungeonDimensionId || this.worldServerInstance.provider.dimensionId == 0) {
            if (!this.placeInExistingPortal(par1Entity, par2, par4, par6, par8)) {
                this.makePortal(par1Entity);
                this.placeInExistingPortal(par1Entity, par2, par4, par6, par8);
            }
        }
        else {
            final int i = MathHelper.floor_double(par1Entity.posX);
            final int j = MathHelper.floor_double(par1Entity.posY) - 1;
            final int k = MathHelper.floor_double(par1Entity.posZ);
            final byte b0 = 1;
            final byte b2 = 0;
            for (int l = -2; l <= 2; ++l) {
                for (int i2 = -2; i2 <= 2; ++i2) {
                    for (int j2 = -1; j2 < 3; ++j2) {
                        final int k2 = i + i2 * b0 + l * b2;
                        final int l2 = j + j2;
                        final int i3 = k + i2 * b2 - l * b0;
                        final boolean flag = j2 < 0;
                        this.worldServerInstance.setBlock(k2, l2, i3, flag ? Dungeons.stoneDoor : Blocks.air);
                    }
                }
            }
            par1Entity.setLocationAndAngles((double)i, (double)j, (double)k, par1Entity.rotationYaw, 0.0f);
            final double motionX = 0.0;
            par1Entity.motionZ = motionX;
            par1Entity.motionY = motionX;
            par1Entity.motionX = motionX;
        }
    }
    
    public boolean placeInExistingPortal(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8) {
        final short short1 = 128;
        double d3 = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = MathHelper.floor_double(par1Entity.posX);
        final int i2 = MathHelper.floor_double(par1Entity.posZ);
        final long j2 = ChunkCoordIntPair.chunkXZ2Int(l, i2);
        boolean flag = true;
        if (this.destinationCoordinateCache.containsItem(j2)) {
            final PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(j2);
            d3 = 0.0;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else {
            for (int k2 = l - short1; k2 <= l + short1; ++k2) {
                final double d4 = k2 + 0.5 - par1Entity.posX;
                for (int l2 = i2 - short1; l2 <= i2 + short1; ++l2) {
                    final double d5 = l2 + 0.5 - par1Entity.posZ;
                    for (int i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3) {
                        if (this.worldServerInstance.getBlock(k2, i3, l2) == Dungeons.portalMontane) {
                            while (this.worldServerInstance.getBlock(k2, i3 - 1, l2) == Dungeons.portalMontane) {
                                --i3;
                            }
                            final double d6 = i3 + 0.5 - par1Entity.posY;
                            final double d7 = d4 * d4 + d6 * d6 + d5 * d5;
                            if (d3 < 0.0 || d7 < d3) {
                                d3 = d7;
                                i = k2;
                                j = i3;
                                k = l2;
                            }
                        }
                    }
                }
            }
        }
        if (d3 >= 0.0) {
            if (flag) {
                this.destinationCoordinateCache.add(j2, (Object)new PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(j2);
            }
            double d8 = i + 0.5;
            final double d9 = j + 0.5;
            double d6 = k + 0.5;
            int j3 = -1;
            if (this.worldServerInstance.getBlock(i - 1, j, k) == Dungeons.portalMontane) {
                j3 = 2;
            }
            if (this.worldServerInstance.getBlock(i + 1, j, k) == Dungeons.portalMontane) {
                j3 = 0;
            }
            if (this.worldServerInstance.getBlock(i, j, k - 1) == Dungeons.portalMontane) {
                j3 = 3;
            }
            if (this.worldServerInstance.getBlock(i, j, k + 1) == Dungeons.portalMontane) {
                j3 = 1;
            }
            final int k3 = par1Entity.getTeleportDirection();
            if (j3 > -1) {
                int l3 = Direction.rotateLeft[j3];
                int i4 = Direction.offsetX[j3];
                int j4 = Direction.offsetZ[j3];
                int k4 = Direction.offsetX[l3];
                int l4 = Direction.offsetZ[l3];
                boolean flag2 = !this.worldServerInstance.isAirBlock(i + i4 + k4, j, k + j4 + l4) || !this.worldServerInstance.isAirBlock(i + i4 + k4, j + 1, k + j4 + l4);
                boolean flag3 = !this.worldServerInstance.isAirBlock(i + i4, j, k + j4) || !this.worldServerInstance.isAirBlock(i + i4, j + 1, k + j4);
                if (flag2 && flag3) {
                    j3 = Direction.rotateOpposite[j3];
                    l3 = Direction.rotateOpposite[l3];
                    i4 = Direction.offsetX[j3];
                    j4 = Direction.offsetZ[j3];
                    k4 = Direction.offsetX[l3];
                    l4 = Direction.offsetZ[l3];
                    final int k2 = i - k4;
                    d8 -= k4;
                    final int i5 = k - l4;
                    d6 -= l4;
                    flag2 = (!this.worldServerInstance.isAirBlock(k2 + i4 + k4, j, i5 + j4 + l4) || !this.worldServerInstance.isAirBlock(k2 + i4 + k4, j + 1, i5 + j4 + l4));
                    flag3 = (!this.worldServerInstance.isAirBlock(k2 + i4, j, i5 + j4) || !this.worldServerInstance.isAirBlock(k2 + i4, j + 1, i5 + j4));
                }
                float f1 = 0.5f;
                float f2 = 0.5f;
                if (!flag2 && flag3) {
                    f1 = 1.0f;
                }
                else if (flag2 && !flag3) {
                    f1 = 0.0f;
                }
                else if (flag2 && flag3) {
                    f2 = 0.0f;
                }
                d8 += k4 * f1 + f2 * i4;
                d6 += l4 * f1 + f2 * j4;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                if (j3 == k3) {
                    f3 = 1.0f;
                    f4 = 1.0f;
                }
                else if (j3 == Direction.rotateOpposite[k3]) {
                    f3 = -1.0f;
                    f4 = -1.0f;
                }
                else if (j3 == Direction.rotateRight[k3]) {
                    f5 = 1.0f;
                    f6 = -1.0f;
                }
                else {
                    f5 = -1.0f;
                    f6 = 1.0f;
                }
                final double d10 = par1Entity.motionX;
                final double d11 = par1Entity.motionZ;
                par1Entity.motionX = d10 * f3 + d11 * f6;
                par1Entity.motionZ = d10 * f5 + d11 * f4;
                par1Entity.rotationYaw = par8 - k3 * 90 + j3 * 90;
            }
            else {
                final double motionX = 0.0;
                par1Entity.motionZ = motionX;
                par1Entity.motionY = motionX;
                par1Entity.motionX = motionX;
            }
            par1Entity.setLocationAndAngles(d8, d9, d6, par1Entity.rotationYaw, par1Entity.rotationPitch);
            return true;
        }
        return false;
    }
    
    public boolean makePortal(final Entity par1Entity) {
        final byte b0 = 16;
        final double d0 = -1.0;
        par1Entity.posY = 55.0;
        final int i = MathHelper.floor_double(par1Entity.posX);
        final int j = MathHelper.floor_double(par1Entity.posY);
        final int k = MathHelper.floor_double(par1Entity.posZ);
        final int l = i;
        final int i2 = j;
        final int j2 = k;
        final int k2 = 0;
        final int l2 = this.random.nextInt(4);
        if (this.worldServerInstance.provider.dimensionId == Dungeons.montaneDungeonDimensionId) {
            final int x = i - 50;
            final int y = j - 21;
            final int z = k - 45;
            System.out.println("generating at " + x + " " + y + " " + z);
            new WorldGenMontaneDungeon_1().generate((World)this.worldServerInstance, this.random, x, y, z);
            new WorldGenMontaneDungeon_2().generate((World)this.worldServerInstance, this.random, x + 73, y, z);
            new WorldGenMontaneDungeon_3().generate((World)this.worldServerInstance, this.random, x + 113, y, z);
            new WorldGenMontaneDungeon_4().generate((World)this.worldServerInstance, this.random, x + 154, y - 3, z - 59);
            new WorldGenMontaneDungeon_5().generate((World)this.worldServerInstance, this.random, x + 205, y - 3, z - 59);
            new WorldGenMontaneDungeon_6().generate((World)this.worldServerInstance, this.random, x + 271, y - 9, z - 59);
            new WorldGenMontaneDungeon_7().generate((World)this.worldServerInstance, this.random, x + 289, y - 9, z - 59);
            new WorldGenMontaneDungeon_8().generate((World)this.worldServerInstance, this.random, x + 299, y - 9, z - 59);
            new WorldGenMontaneDungeon_9().generate((World)this.worldServerInstance, this.random, x + 305, y - 9, z - 59);
            new WorldGenMontaneDungeon_10().generate((World)this.worldServerInstance, this.random, x + 310, y - 9, z - 59);
            new WorldGenMontaneDungeon_11().generate((World)this.worldServerInstance, this.random, x + 314, y - 9, z - 59);
            new WorldGenMontaneDungeon_12().generate((World)this.worldServerInstance, this.random, x + 317, y - 9, z - 59);
            new WorldGenMontaneDungeon_13().generate((World)this.worldServerInstance, this.random, x + 320, y - 9, z - 59);
            new WorldGenMontaneDungeon_14().generate((World)this.worldServerInstance, this.random, x + 323, y - 9, z - 59);
            new WorldGenMontaneDungeon_15().generate((World)this.worldServerInstance, this.random, x + 326, y - 9, z - 59);
            new WorldGenMontaneDungeon_16().generate((World)this.worldServerInstance, this.random, x + 329, y - 9, z - 59);
            new WorldGenMontaneDungeon_17().generate((World)this.worldServerInstance, this.random, x + 332, y - 9, z - 59);
            new WorldGenMontaneDungeon_18().generate((World)this.worldServerInstance, this.random, x + 335, y - 9, z - 59);
            new WorldGenMontaneDungeon_19().generate((World)this.worldServerInstance, this.random, x + 338, y - 9, z - 59);
            new WorldGenMontaneDungeon_20().generate((World)this.worldServerInstance, this.random, x + 341, y - 9, z - 59);
            new WorldGenMontaneDungeon_21().generate((World)this.worldServerInstance, this.random, x + 344, y - 9, z - 59);
            new WorldGenMontaneDungeon_22().generate((World)this.worldServerInstance, this.random, x + 347, y - 9, z - 59);
            new WorldGenMontaneDungeon_23().generate((World)this.worldServerInstance, this.random, x + 350, y - 9, z - 59);
            new WorldGenMontaneDungeon_24().generate((World)this.worldServerInstance, this.random, x + 353, y - 9, z - 59);
            new WorldGenMontaneDungeon_25().generate((World)this.worldServerInstance, this.random, x + 356, y - 9, z - 59);
        }
        for (int x = 0; x < 7; ++x) {
            for (int z2 = 0; z2 < 7; ++z2) {
                this.worldServerInstance.setBlock(i + x - 30, j + 15, k + z2 - 20, Dungeons.stoneDoor);
            }
        }
        for (int x = 1; x < 6; ++x) {
            for (int z2 = 1; z2 < 6; ++z2) {
                this.worldServerInstance.setBlock(i + x - 30, j + 16, k + z2 - 20, Dungeons.stoneDoor);
            }
        }
        for (int x = 2; x < 5; ++x) {
            for (int z2 = 2; z2 < 5; ++z2) {
                this.worldServerInstance.setBlock(i + x - 30, j + 16, k + z2 - 20, Dungeons.portalMontane);
            }
        }
        return true;
    }
    
    public void removeStalePortalLocations(final long par1) {
        if (par1 % 100L == 0L) {
            final Iterator iterator = this.destinationCoordinateKeys.iterator();
            final long j = par1 - 600L;
            while (iterator.hasNext()) {
                final Long olong = iterator.next();
                final PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey((long)olong);
                if (portalposition == null || portalposition.lastUpdateTime < j) {
                    iterator.remove();
                    this.destinationCoordinateCache.remove((long)olong);
                }
            }
        }
    }
    
    public class PortalPosition extends ChunkCoordinates
    {
        public long lastUpdateTime;
        
        public PortalPosition(final int par2, final int par3, final int par4, final long par5) {
            super(par2, par3, par4);
            this.lastUpdateTime = par5;
        }
    }
}
