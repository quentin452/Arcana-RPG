

package com.gibby.dungeon.init.recipeinit;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CombatCrafting
{
    public static void Recipes() {
        GameRegistry.addRecipe(new ItemStack(Dungeons.harpBow), " c ", "cbc", " c ", 'c', Dungeons.castIron, 'b', Items.bow);
        GameRegistry.addRecipe(new ItemStack(Dungeons.corruptedBow), "lcl", "cbc", "lcl", 'c', Dungeons.corruptedSoul, 'b', Items.bow, 'l', Dungeons.lithium);
        GameRegistry.addRecipe(new ItemStack(Dungeons.disinigrationBow), "cuc", "cbc", "ccc", 'c', Dungeons.crystallium, 'b', Items.bow, 'u', Dungeons.cursedWand);
        GameRegistry.addRecipe(new ItemStack(Dungeons.coppersword), "c", "c", "s", 'c', Dungeons.copper, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubySword), "c", "c", "s", 'c', Dungeons.ruby, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.silverSword), "c", "c", "s", 'c', Dungeons.silver, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyDiamondSword), "c", "c", "s", 'c', Blocks.diamond_block, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyIronSword), "c", "c", "s", 'c', Blocks.iron_block, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyHeavySword), "c", "c", "s", 'c', Dungeons.rubyBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.castIronSword), "c", "c", "s", 'c', Dungeons.castIron, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.castIronStar, 8), " c ", "c c", " c ", 'c', Dungeons.castIron);
        GameRegistry.addRecipe(new ItemStack(Dungeons.amazoniteSword), "c", "c", "s", 'c', Dungeons.amazonite, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperHeavySword), "c", "c", "s", 'c', Dungeons.copperBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.silverHeavySword), "c", "c", "s", 'c', Dungeons.silverBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.bedrockSword), "ccc", " s ", 'c', Dungeons.bedrock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyBedrockSword), "ccc", " s ", 'c', Blocks.bedrock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumSword), "c", "c", "s", 'c', Dungeons.lithium, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumHeavySword), "c", "c", "s", 'c', Dungeons.lithiumBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystSword), "c", "c", "s", 'c', Dungeons.amethyst, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyAmethystSword), "c", "c", "s", 'c', Dungeons.amethystBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelSword), "c", "c", "s", 'c', Dungeons.netherSteel, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyNetherSteelSword), "c", "c", "s", 'c', Dungeons.netherSteelBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.crystalSword), "c", "c", "s", 'c', Dungeons.crystallium, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.crystalHeavySword), "c", "c", "s", 'c', Dungeons.crystalliumBlock, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.bubbleSword), " cc", "ccc", "sc ", 'c', Dungeons.waterRod, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.tornadoSword), " cc", "ccc", "sc ", 'c', Dungeons.stormRod, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.elementalSword), " ai", "twa", "st ", 't', Dungeons.stormRod, 's', Items.stick, 'a', Dungeons.sandRod, 'i', Dungeons.iceRod, 'w', Dungeons.waterRod);
        GameRegistry.addRecipe(new ItemStack(Dungeons.swordOfCorruption), " c ", "csc", " c ", 'c', Dungeons.corruptedSoul, 's', Dungeons.elementalSword);
    }
}
