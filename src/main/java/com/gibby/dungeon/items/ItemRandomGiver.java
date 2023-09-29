package com.gibby.dungeon.items;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.util.ItemEntry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemRandomGiver extends Item {
    public static ItemEntry[] Vampire = {
        new ItemEntry(Dungeons.voidCoin, 1, 1),
        new ItemEntry(Dungeons.lithium, 5, 10)
    };

    public static ItemEntry[] VoidDungeon = {
        new ItemEntry(Dungeons.cursedStone, 1, 1),
        new ItemEntry(Dungeons.bloodWand, 1, 1),
        new ItemEntry(Dungeons.voidCoin, 1, 1),
        new ItemEntry(Dungeons.warlockStaff, 1, 1),
        new ItemEntry(Dungeons.botSword, 1, 1),
        new ItemEntry(Dungeons.botAmulet, 1, 1),
        new ItemEntry(Dungeons.necroticAmulet, 1, 1),
        new ItemEntry(Dungeons.bubbleSword, 1, 1),
        new ItemEntry(Dungeons.castIronStar, 5, 10),
        new ItemEntry(Dungeons.magicCoin, 1, 1),
        new ItemEntry(Dungeons.metalCoin, 1, 1),
        new ItemEntry(Dungeons.bedrock, 1, 1),
        new ItemEntry(Dungeons.ruby, 2, 4),
        new ItemEntry(Dungeons.silver, 2, 4),
        new ItemEntry(Dungeons.voidFiendSword, 1, 1),
        new ItemEntry(Dungeons.trollAxe, 1, 1),
        new ItemEntry(Dungeons.steelSword, 1, 1),
        new ItemEntry(Dungeons.rootBeer, 2, 4),
        new ItemEntry(Items.rotten_flesh, 20, 24),
        new ItemEntry(Items.gunpowder, 10, 15),
        new ItemEntry(Items.coal, 10, 15),
        new ItemEntry(Items.bone, 10, 15),
        new ItemEntry(Items.iron_ingot, 10, 15),
        new ItemEntry(Items.gold_ingot, 5, 10),
        new ItemEntry(Items.redstone, 5, 10),
        new ItemEntry(Items.apple, 5, 10),
        new ItemEntry(Items.experience_bottle, 10, 15),
        new ItemEntry(Dungeons.amazonite, 6, 10),
        new ItemEntry(Items.potato, 10, 15)
    };

    public static ItemEntry[] NetherStructure = {
        new ItemEntry(Dungeons.voidCoin, 1, 1),
        new ItemEntry(Dungeons.lithium, 2, 4),
        new ItemEntry(Dungeons.netherSteel, 1, 1),
        new ItemEntry(Dungeons.lavaKnightSword, 1, 1),
        new ItemEntry(Dungeons.corruptedBow, 1, 1),
        new ItemEntry(Dungeons.chaoticWand, 1, 1),
        new ItemEntry(Dungeons.netherDrill, 1, 1),
        new ItemEntry(Dungeons.flameSword, 1, 1),
        new ItemEntry(Items.nether_wart, 6, 10),
        new ItemEntry(Items.rotten_flesh, 6, 10),
        new ItemEntry(Items.bone, 6, 10),
        new ItemEntry(Items.coal, 6, 10),
        new ItemEntry(Dungeons.rawTrollMeat, 2, 4),
        new ItemEntry(Dungeons.magicPotion, 2, 4),
        new ItemEntry(Dungeons.bedrock, 1, 2),
        new ItemEntry(Items.blaze_powder, 2, 4),
        new ItemEntry(Items.gunpowder, 2, 4),
        new ItemEntry(Dungeons.ruby, 2, 4),
        new ItemEntry(Dungeons.whiskey, 2, 4),
        new ItemEntry(Dungeons.magicCoin, 1, 1),
        new ItemEntry(Dungeons.metalCoin, 1, 2),
        new ItemEntry(Dungeons.ionicWand, 1, 1),
        new ItemEntry(Dungeons.necroticAmulet, 1, 1)
    };

    public static  ItemEntry[] MontaneDungeon = {
        new ItemEntry(Dungeons.orcWarWand, 0, 1),
        new ItemEntry(Dungeons.cookedTrollMeat, 1, 3),
        new ItemEntry(Dungeons.beefstew, 1, 3),
        new ItemEntry(Items.potato, 8, 16),
        new ItemEntry(Items.baked_potato, 8, 16),
        new ItemEntry(Items.cooked_beef, 8, 16),
        new ItemEntry(Items.beef, 8, 16),
        new ItemEntry(Dungeons.blackIron, 1, 3),
        new ItemEntry(Dungeons.blackIronSword, 1, 1),
        new ItemEntry(Items.golden_apple, 2, 8),
        new ItemEntry(Dungeons.crecentWand, 1, 1),
        new ItemEntry(Dungeons.sapientWarWand, 1, 1),
        new ItemEntry(Items.coal, 8, 16),
        new ItemEntry(Dungeons.amethyst, 4, 8),
        new ItemEntry(Dungeons.metalCoin, 4, 8),
        new ItemEntry(Dungeons.magicCoin, 1, 2),
        new ItemEntry(Dungeons.voidCoin, 1, 2),
        new ItemEntry(Dungeons.whiskey, 2, 4),
        new ItemEntry(Dungeons.rootBeer, 2, 4),
        new ItemEntry(Dungeons.gingerAle, 2, 4),
        new ItemEntry(Dungeons.castIronStar, 4, 16),
        new ItemEntry(Items.gunpowder, 4, 16),
        new ItemEntry(Items.arrow, 4, 16),
        new ItemEntry(Items.cookie, 4, 16),
        new ItemEntry(Items.wheat, 4, 16),
        new ItemEntry(Items.carrot, 4, 16),
        new ItemEntry(Items.gold_nugget, 4, 16),
        new ItemEntry(Dungeons.magicPotion, 1, 2)
    };

    public static  ItemEntry[] MontagneRiche = {
        new ItemEntry(Dungeons.orcWarWand, 0, 1),
        new ItemEntry(Dungeons.cookedTrollMeat, 1, 3),
        new ItemEntry(Dungeons.blackIron, 1, 3),
        new ItemEntry(Dungeons.blackIronSword, 1, 1),
        new ItemEntry(Dungeons.blackIronChestplate, 0, 1),
        new ItemEntry(Items.golden_apple, 4, 8),
        new ItemEntry(Items.diamond, 4, 8),
        new ItemEntry(Items.ender_pearl, 4, 16),
        new ItemEntry(Items.blaze_rod, 4, 16),
        new ItemEntry(Items.emerald, 4, 16),
        new ItemEntry(Dungeons.ruby, 4, 16),
        new ItemEntry(Dungeons.amethyst, 4, 8),
        new ItemEntry(Dungeons.crecentWand, 1, 1),
        new ItemEntry(Dungeons.sapientWarWand, 0, 1),
        new ItemEntry(Items.cookie, 4, 16),
        new ItemEntry(Items.cake, 1, 2),
        new ItemEntry(Items.wheat, 4, 16),
        new ItemEntry(Items.golden_carrot, 4, 16),
        new ItemEntry(Items.book, 4, 16),
        new ItemEntry(Dungeons.magicPotion, 1, 3),
        new ItemEntry(Dungeons.magicPotion2, 1, 1),
        new ItemEntry(Items.experience_bottle, 4, 8)
    };

    public static  ItemEntry[] Beholder = {
    new ItemEntry(Dungeons.hadrialWand, 1, 1),
    new ItemEntry(Dungeons.lithium, 5, 10),
    new ItemEntry(Dungeons.metalCoin, 15, 30),
    new ItemEntry(Dungeons.voidCoin, 5, 10),
    new ItemEntry(Items.nether_star, 1, 1),
    new ItemEntry(Items.nether_wart, 5, 10),
    new ItemEntry(Dungeons.netherSteelShards, 5, 10),
    new ItemEntry(Dungeons.corruptedSoul, 5, 1),
    new ItemEntry(Dungeons.metalCoin, 1, 1),
    new ItemEntry(Dungeons.copper, 2, 2),
    new ItemEntry(Dungeons.amazonite, 1, 1),
    new ItemEntry(Dungeons.castIron, 1, 1),
    new ItemEntry(Dungeons.cookedTrollMeat, 1, 1),
    new ItemEntry(Dungeons.magicCoin, 1, 1),
    new ItemEntry(Dungeons.bloodWand, 1, 1),
    new ItemEntry(Dungeons.whittler, 1, 1),
    new ItemEntry(Dungeons.botSword, 1, 1),
    new ItemEntry(Dungeons.tornadoSword, 1, 1),
    new ItemEntry(Dungeons.metalWand, 1, 1),
    new ItemEntry(Dungeons.tomeOfMagic, 1, 1),
    new ItemEntry(Dungeons.growthStaff, 1, 1),
    new ItemEntry(Dungeons.magicGem, 1, 1),
    new ItemEntry(Dungeons.magicWand, 1, 1),
    new ItemEntry(Dungeons.poisonWand, 1, 1),
      new ItemEntry(Dungeons.coppersword, 1, 1),
    new ItemEntry(Dungeons.amazoniteSword, 1, 1),
    new ItemEntry(Dungeons.rubySword, 1, 1),
    new ItemEntry(Dungeons.magicGem, 1, 1),
    new ItemEntry(Dungeons.cursedStone, 1, 1),
    new ItemEntry(Dungeons.botAmulet, 1, 1),
    new ItemEntry(Dungeons.regenTome, 1, 1)
    };

    public static 1temEntry[] DungeonChest = {
        new ItemEntry(Items.saddle, 1, 1),
        new ItemEntry(Items.iron_ingot, 1, 4),
        new ItemEntry(Items.bread, 1, 1),
        new ItemEntry(Items.wheat, 1, 4),
        new ItemEntry(Items.gunpowder, 1, 4),
        new ItemEntry(Items.string, 1, 4),
        new ItemEntry(Items.bucket, 1, 1),
        new ItemEntry(Items.golden_apple, 1, 1),
        new ItemEntry(Items.redstone, 1, 4),
        new ItemEntry(Items.record_13, 1, 1),
        new ItemEntry(Items.record_cat, 1, 1),
        new ItemEntry(Items.name_tag, 1, 1),
        new ItemEntry(Items.golden_horse_armor, 1, 1),
        new ItemEntry(Items.iron_horse_armor, 1, 1),
        new ItemEntry(Items.diamond_horse_armor, 1, 1),
        new ItemEntry(Dungeons.metalCoin, 1, 1),
        new ItemEntry(Dungeons.copper, 2, 4),
        new ItemEntry(Dungeons.amazonite, 1, 2),
        new ItemEntry(Dungeons.castIron, 1, 2),
        new ItemEntry(Dungeons.cookedTrollMeat, 1, 2),
        new ItemEntry(Dungeons.magicCoin, 1, 1),
        new ItemEntry(Dungeons.graniteSword, 1, 1),
        new ItemEntry(Dungeons.whittler, 1, 1),
        new ItemEntry(Dungeons.botSword, 1, 1),
        new ItemEntry(Dungeons.mace, 1, 1),
        new ItemEntry(Dungeons.forceWand, 1, 1),
        new ItemEntry(Dungeons.pulseWand, 1, 1),
        new ItemEntry(Dungeons.poisonWand, 1, 1),
        new ItemEntry(Dungeons.magicGem, 1, 1),
        new ItemEntry(Dungeons.magicWand, 1, 1),
        new ItemEntry(Dungeons.poisonWand, 1, 1),
        new ItemEntry(new ItemStack(Dungeons.battleTome, 1, 2).getItem(), 1, 1),
        new ItemEntry(new ItemStack(Dungeons.earthTome, 1, 4).getItem(), 1, 1),
        new ItemEntry(Dungeons.coppersword, 1, 1),
        new ItemEntry(Dungeons.amazoniteSword, 1, 1),
        new ItemEntry(Dungeons.rubySword, 1, 1),
        new ItemEntry(Dungeons.magicGem, 1, 1),
        new ItemEntry(Dungeons.cursedStone, 1, 1),
        new ItemEntry(Dungeons.necroticAmulet, 1, 1),
    };

    Random rand = new Random();
    private final ItemEntry[] lootList;
    public ItemRandomGiver(ItemEntry[] lootList) {
        this.lootList = lootList;
        this.maxStackSize =64;
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3) {
        ItemEntry[] lootList = null;

        if (Dungeons.randomItemGiverVampire != null) {
            lootList = Vampire;
        } else if (Dungeons.randomItemGiverVoidDungeon != null) {
            lootList = VoidDungeon;
        } else if (Dungeons.randomItemGiverMontaneDungeon != null) {
            lootList = MontaneDungeon;
        } else if (Dungeons.randomItemGiverMontagneRiche != null) {
            lootList = MontagneRiche;
        } else if (Dungeons.randomItemGiverNetherStructure != null) {
            lootList = NetherStructure;
        } else if (Dungeons.randomItemGiverBeholder != null) {
            lootList = Beholder;
        } else if (Dungeons.randomItemGiverdungeonChest != null) {
            lootList = DungeonChest;
        }

        if (lootList != null) {
            giveRandomLoot(par2World, par3);
        }

        return par1ItemStack;
    }

    private void giveRandomLoot(World world, EntityPlayer player) {
        if (lootList != null && lootList.length > 0) {
            int randomIndex = rand.nextInt(lootList.length);
            ItemEntry randomEntry = lootList[randomIndex];
            ItemStack loot = randomEntry.getLootEntry();
            if (!player.inventory.addItemStackToInventory(loot)) {
                world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, loot));
            }
        }
    }

}
