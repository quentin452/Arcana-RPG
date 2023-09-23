package com.gibby.dungeon.mobs;


final class EntityGhostWither$1 implements IEntitySelector {
    private static final String __OBFID = "CL_00001662";

    EntityGhostWither$1() {
    }

    public boolean func_82704_a(Entity par1Entity) {
        return par1Entity instanceof EntityLivingBase && ((EntityLivingBase)par1Entity).func_70668_bt() != EnumCreatureAttribute.UNDEAD;
    }
}
