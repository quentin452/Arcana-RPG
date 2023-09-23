

package com.gibby.dungeon;

import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class DungeonsExtendedPlayer implements IExtendedEntityProperties
{
    public static final String EXT_PROP_NAME = "ExtendedPlayer";
    private final EntityPlayer player;
    private int currentMagic;
    private int maxMagic;
    
    public DungeonsExtendedPlayer(final EntityPlayer player) {
        this.player = player;
        this.currentMagic = 0;
        this.maxMagic = 20;
        this.player.getDataWatcher().addObject(Dungeons.MAGIC_WATCHER, (Object)0);
    }
    
    public static final void register(final EntityPlayer player) {
        player.registerExtendedProperties("ExtendedPlayer", (IExtendedEntityProperties)new DungeonsExtendedPlayer(player));
    }
    
    public static final DungeonsExtendedPlayer get(final EntityPlayer player) {
        return (DungeonsExtendedPlayer)player.getExtendedProperties("ExtendedPlayer");
    }
    
    public void saveNBTData(final NBTTagCompound compound) {
        final NBTTagCompound properties = new NBTTagCompound();
        properties.setInteger("CurrentMana", this.player.getDataWatcher().getWatchableObjectInt(Dungeons.MAGIC_WATCHER));
        properties.setInteger("MaxMana", this.maxMagic);
        compound.setTag("ExtendedPlayer", (NBTBase)properties);
    }
    
    public void loadNBTData(final NBTTagCompound compound) {
        final NBTTagCompound properties = (NBTTagCompound)compound.getTag("ExtendedPlayer");
        this.player.getDataWatcher().updateObject(Dungeons.MAGIC_WATCHER, (Object)properties.getInteger("CurrentMana"));
        this.maxMagic = properties.getInteger("MaxMana");
        System.out.println("[TUT PROPS] Mana from NBT: " + this.currentMagic + "/" + this.maxMagic);
    }
    
    public void init(final Entity entity, final World world) {
    }
    
    public boolean consumeMagic(final int amount) {
        int mana = this.player.getDataWatcher().getWatchableObjectInt(Dungeons.MAGIC_WATCHER);
        final boolean sufficient = amount <= mana;
        mana -= ((amount < mana) ? amount : mana);
        this.player.getDataWatcher().updateObject(Dungeons.MAGIC_WATCHER, (Object)mana);
        return sufficient;
    }
    
    public void addMagic(final int amount) {
        int mana = this.player.getDataWatcher().getWatchableObjectInt(Dungeons.MAGIC_WATCHER);
        mana += ((amount + mana <= this.maxMagic) ? amount : (this.maxMagic - mana));
        this.player.getDataWatcher().updateObject(Dungeons.MAGIC_WATCHER, (Object)mana);
    }
    
    public int magicAmount() {
        return this.player.getDataWatcher().getWatchableObjectInt(Dungeons.MAGIC_WATCHER);
    }
    
    public void boostMagic(final int boost) {
        this.maxMagic = 20 + boost;
    }
    
    public int maxMagic() {
        return this.maxMagic;
    }
}
