

package com.gibby.dungeon.init.recipeinit;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Crafting
{
    public static void Recipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.beefstew, 2), Items.bowl, Items.bowl, Items.water_bucket, Items.beef, Items.carrot, Items.potato);
        GameRegistry.addSmelting(Dungeons.copperore, new ItemStack(Dungeons.copper), 1.0f);
        GameRegistry.addSmelting(Dungeons.amazoniteOre, new ItemStack(Dungeons.amazonite), 1.0f);
        GameRegistry.addSmelting(Dungeons.rubyOre, new ItemStack(Dungeons.ruby), 1.0f);
        GameRegistry.addSmelting(Dungeons.silverOre, new ItemStack(Dungeons.silver), 1.0f);
        GameRegistry.addSmelting(Dungeons.lithiumOre, new ItemStack(Dungeons.lithium), 1.0f);
        GameRegistry.addSmelting(Dungeons.bedrockOre, new ItemStack(Dungeons.bedrock), 1.0f);
        GameRegistry.addSmelting(Dungeons.amethystOre, new ItemStack(Dungeons.amethystBlock), 1.0f);
        GameRegistry.addSmelting(Dungeons.netherSteelOre, new ItemStack(Dungeons.netherSteelShards), 1.0f);
        GameRegistry.addSmelting(Dungeons.netherSteelShards, new ItemStack(Dungeons.netherSteel), 1.0f);
        GameRegistry.addSmelting(Dungeons.crystalOre, new ItemStack(Dungeons.crystallium), 1.0f);
        GameRegistry.addSmelting(Dungeons.blackIronScraps, new ItemStack(Dungeons.blackIron), 1.0f);
        GameRegistry.addSmelting(Dungeons.rawTrollMeat, new ItemStack(Dungeons.cookedTrollMeat), 1.0f);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.castIron, 2), Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.coal, Items.coal);
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyBlock), "ccc", "ccc", "ccc", 'c', Dungeons.ruby);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.ruby, 9, 0), Dungeons.rubyBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperBlock), "ccc", "ccc", "ccc", 'c', Dungeons.copper);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.copper, 9, 0), Dungeons.copperBlock);
        GameRegistry.addRecipe(new ItemStack(Blocks.bedrock), "ccc", "ccc", "ccc", 'c', Dungeons.bedrock);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.bedrock, 9, 0), Blocks.bedrock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.silverBlock), "ccc", "ccc", "ccc", 'c', Dungeons.silver);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.silver, 9, 0), Dungeons.silverBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumBlock), "ccc", "ccc", "ccc", 'c', Dungeons.lithium);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.lithium, 9, 0), Dungeons.lithiumBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelBlock), "ccc", "ccc", "ccc", 'c', Dungeons.netherSteel);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.netherSteel, 9, 0), Dungeons.netherSteelBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystBlock), "ccc", "ccc", "ccc", 'c', Dungeons.amethyst);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.amethyst, 9, 0), Dungeons.amethystBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.corruptedMagicOrb), " c ", "cnc", " c ", 'c', Dungeons.corruptedSoul, 'n', Dungeons.amethystBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.corruptedNetherSoul), "gng", "ncn", "gng", 'c', Dungeons.corruptedSoul, 'n', Dungeons.netherSteel, 'g', Items.ghast_tear);
        GameRegistry.addRecipe(new ItemStack(Dungeons.sunsetOrb), " c ", "cnc", " c ", 'c', Blocks.stonebrick, 'n', Dungeons.copperBlock);
        GameRegistry.addRecipe(new ItemStack(Dungeons.crystalliumBlock), "ccc", "ccc", "ccc", 'c', Dungeons.crystallium);
        GameRegistry.addRecipe(new ItemStack(Dungeons.magirockChunk), "ccc", "ccc", "ccc", 'c', Dungeons.magirockCrystal);
        GameRegistry.addRecipe(new ItemStack(Dungeons.voidrockChunk), "ccc", "ccc", "ccc", 'c', Dungeons.voidrockCrystal);
        GameRegistry.addRecipe(new ItemStack(Dungeons.magirockCharge), "mmc", "mgc", "mcc", 'c', Dungeons.voidrockChunk, 'm', Dungeons.magirockChunk, 'g', Dungeons.magicGem);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.crystallium, 9, 0), Dungeons.crystalliumBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.dungeonDimensionSpawner, 1, 0), Dungeons.dungeonPiece1, Dungeons.dungeonPiece2, Dungeons.dungeonPiece3, Dungeons.dungeonPiece4, Dungeons.dungeonPiece5);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.magicalOrb, 1, 0), Dungeons.corruptedMagicOrb);
        GameRegistry.addShapelessRecipe(new ItemStack(Dungeons.corruptedMagicOrb, 1, 0), Dungeons.magicalOrb);
    }
}
