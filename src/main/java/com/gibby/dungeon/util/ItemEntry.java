package com.gibby.dungeon.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemEntry {
    private final Item item;
    private final int minAmount;
    private final int maxAmount;

    public ItemEntry(Item item, int minAmount, int maxAmount) {
        this.item = item;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public ItemStack getLootEntry() {
        int amount = minAmount + (new Random()).nextInt(maxAmount - minAmount+1);
        return new ItemStack(item, amount);
    }
}
