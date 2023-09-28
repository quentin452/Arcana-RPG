package com.gibby.dungeon.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;

public class ClientBossDisplay implements IBossDisplay {

    @Override
    public void setBossStatus(Entity boss, boolean status) {
        BossStatus.setBossStatus((IBossDisplayData) boss, status);
    }

}
