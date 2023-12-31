

package com.gibby.dungeon.util;

import net.minecraft.potion.Potion;

import java.lang.reflect.Field;

public class DungeonPotions
{
    public static void PotionSetup() {
        Potion[] potionTypes;
        for (final Field f : Potion.class.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.getName().equals("potionTypes")) {
                    final Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & 0xFFFFFFEF);
                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            }
            catch (Exception e) {
                System.err.println("Severe error, please report this to the mod author:");
            }
        }
    }
}
