

package com.gibby.dungeon.gen;

import net.minecraft.entity.*;
import com.gibby.dungeon.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class TeleporterCrystal extends Teleporter
{
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache;
    private final List destinationCoordinateKeys;

    public TeleporterCrystal(final WorldServer par1WorldServer) {
        super(par1WorldServer);
        this.destinationCoordinateCache = new LongHashMap();
        this.destinationCoordinateKeys = new ArrayList();
        this.worldServerInstance = par1WorldServer;
        this.random = new Random(par1WorldServer.getSeed());
    }

    public void placeInPortal(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8) {
        if (this.worldServerInstance.provider.dimensionId == Dungeons.crystalDimensionId || this.worldServerInstance.provider.dimensionId == 0) {
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
                        this.worldServerInstance.setBlock(k2, l2, i3, flag ? Dungeons.amethystStone : Blocks.air);
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
                        if (this.worldServerInstance.getBlock(k2, i3, l2) == Dungeons.portalAmethyst) {
                            while (this.worldServerInstance.getBlock(k2, i3 - 1, l2) == Dungeons.portalAmethyst) {
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
                this.destinationCoordinateCache.add(j2, new PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(j2);
            }
            double d8 = i + 0.5;
            final double d9 = j + 0.5;
            double d6 = k + 0.5;
            int j3 = -1;
            if (this.worldServerInstance.getBlock(i - 1, j, k) == Dungeons.portalAmethyst) {
                j3 = 2;
            }
            if (this.worldServerInstance.getBlock(i + 1, j, k) == Dungeons.portalAmethyst) {
                j3 = 0;
            }
            if (this.worldServerInstance.getBlock(i, j, k - 1) == Dungeons.portalAmethyst) {
                j3 = 3;
            }
            if (this.worldServerInstance.getBlock(i, j, k + 1) == Dungeons.portalAmethyst) {
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
        double d0 = -1.0;
        final int i = MathHelper.floor_double(par1Entity.posX);
        final int j = MathHelper.floor_double(par1Entity.posY);
        final int k = MathHelper.floor_double(par1Entity.posZ);
        int l = i;
        int i2 = j;
        int j2 = k;
        int k2 = 0;
        final int l2 = this.random.nextInt(4);
        for (int i3 = i - b0; i3 <= i + b0; ++i3) {
            final double d2 = i3 + 0.5 - par1Entity.posX;
            for (int j3 = k - b0; j3 <= k + b0; ++j3) {
                final double d3 = j3 + 0.5 - par1Entity.posZ;
            Label_0433:
                for (int k3 = this.worldServerInstance.getActualHeight() - 1; k3 >= 0; --k3) {
                    if (this.worldServerInstance.isAirBlock(i3, k3, j3)) {
                        while (k3 > 0 && this.worldServerInstance.isAirBlock(i3, k3 - 1, j3)) {
                            --k3;
                        }
                        for (int i4 = l2; i4 < l2 + 4; ++i4) {
                            int l3 = i4 % 2;
                            int k4 = 1 - l3;
                            if (i4 % 4 >= 2) {
                                l3 = -l3;
                                k4 = -k4;
                            }
                            for (int j4 = 0; j4 < 3; ++j4) {
                                for (int i5 = 0; i5 < 4; ++i5) {
                                    for (int l4 = -1; l4 < 4; ++l4) {
                                        final int k5 = i3 + (i5 - 1) * l3 + j4 * k4;
                                        final int j5 = k3 + l4;
                                        final int l5 = j3 + (i5 - 1) * k4 - j4 * l3;
                                        if (l4 < 0 && !this.worldServerInstance.getBlock(k5, j5, l5).getMaterial().isSolid()) {
                                            continue Label_0433;
                                        }
                                        if (l4 >= 0 && !this.worldServerInstance.isAirBlock(k5, j5, l5)) {
                                            continue Label_0433;
                                        }
                                    }
                                }
                            }
                            final double d4 = k3 + 0.5 - par1Entity.posY;
                            final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                            if (d0 < 0.0 || d5 < d0) {
                                d0 = d5;
                                l = i3;
                                i2 = k3;
                                j2 = j3;
                                k2 = i4 % 4;
                            }
                        }
                    }
                }
            }
        }
        if (d0 < 0.0) {
            for (int i3 = i - b0; i3 <= i + b0; ++i3) {
                final double d2 = i3 + 0.5 - par1Entity.posX;
                for (int j3 = k - b0; j3 <= k + b0; ++j3) {
                    final double d3 = j3 + 0.5 - par1Entity.posZ;
                Label_0786:
                    for (int k3 = this.worldServerInstance.getActualHeight() - 1; k3 >= 0; --k3) {
                        if (this.worldServerInstance.isAirBlock(i3, k3, j3)) {
                            while (k3 > 0 && this.worldServerInstance.isAirBlock(i3, k3 - 1, j3)) {
                                --k3;
                            }
                            for (int i4 = l2; i4 < l2 + 2; ++i4) {
                                final int l3 = i4 % 2;
                                final int k4 = 1 - l3;
                                for (int j4 = 0; j4 < 4; ++j4) {
                                    for (int i5 = -1; i5 < 4; ++i5) {
                                        final int l4 = i3 + (j4 - 1) * l3;
                                        final int k5 = k3 + i5;
                                        final int j5 = j3 + (j4 - 1) * k4;
                                        if (i5 < 0 && !this.worldServerInstance.getBlock(l4, k5, j5).getMaterial().isSolid()) {
                                            continue Label_0786;
                                        }
                                        if (i5 >= 0 && !this.worldServerInstance.isAirBlock(l4, k5, j5)) {
                                            continue Label_0786;
                                        }
                                    }
                                }
                                final double d4 = k3 + 0.5 - par1Entity.posY;
                                final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                                if (d0 < 0.0 || d5 < d0) {
                                    d0 = d5;
                                    l = i3;
                                    i2 = k3;
                                    j2 = j3;
                                    k2 = i4 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int i6 = l;
        int j6 = i2;
        int j3 = j2;
        int k6 = k2 % 2;
        int l6 = 1 - k6;
        if (k2 % 4 >= 2) {
            k6 = -k6;
            l6 = -l6;
        }
        if (d0 < 0.0) {
            if (i2 < 70) {
                i2 = 70;
            }
            if (i2 > this.worldServerInstance.getActualHeight() - 10) {
                i2 = this.worldServerInstance.getActualHeight() - 10;
            }
            j6 = i2;
            for (int k3 = -1; k3 <= 1; ++k3) {
                for (int i4 = 1; i4 < 3; ++i4) {
                    for (int l3 = -1; l3 < 3; ++l3) {
                        final int k4 = i6 + (i4 - 1) * k6 + k3 * l6;
                        final int j4 = j6 + l3;
                        final int i5 = j3 + (i4 - 1) * l6 - k3 * k6;
                        final boolean flag = l3 < 0;
                        this.worldServerInstance.setBlock(k4, j4, i5, flag ? Dungeons.amethystStone : Blocks.air);
                    }
                }
            }
        }
        for (int k3 = 0; k3 < 4; ++k3) {
            for (int i4 = 0; i4 < 4; ++i4) {
                for (int l3 = -1; l3 < 4; ++l3) {
                    final int k4 = i6 + (i4 - 1) * k6;
                    final int j4 = j6 + l3;
                    final int i5 = j3 + (i4 - 1) * l6;
                    final boolean flag = i4 == 0 || i4 == 3 || l3 == -1 || l3 == 3;
                    this.worldServerInstance.setBlock(k4, j4, i5, flag ? Dungeons.amethystStone : Dungeons.portalAmethyst, 0, 2);
                }
            }
            for (int i4 = 0; i4 < 4; ++i4) {
                for (int l3 = -1; l3 < 4; ++l3) {
                    final int k4 = i6 + (i4 - 1) * k6;
                    final int j4 = j6 + l3;
                    final int i5 = j3 + (i4 - 1) * l6;
                    this.worldServerInstance.notifyBlocksOfNeighborChange(k4, j4, i5, this.worldServerInstance.getBlock(k4, j4, i5));
                }
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
