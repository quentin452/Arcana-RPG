

package com.gibby.dungeon;

import net.minecraft.item.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.init.*;

public class CombatCrafting
{
    public static void Recipes() {
        GameRegistry.addRecipe(new ItemStack(Dungeons.harpBow), new Object[] { " c ", "cbc", " c ", 'c', Dungeons.castIron, 'b', Items.bow });
        GameRegistry.addRecipe(new ItemStack(Dungeons.corruptedBow), new Object[] { "lcl", "cbc", "lcl", 'c', Dungeons.corruptedSoul, 'b', Items.bow, 'l', Dungeons.lithium });
        GameRegistry.addRecipe(new ItemStack(Dungeons.disinigrationBow), new Object[] { "cuc", "cbc", "ccc", 'c', Dungeons.crystallium, 'b', Items.bow, 'u', Dungeons.cursedWand });
        GameRegistry.addRecipe(new ItemStack(Dungeons.coppersword), new Object[] { "c", "c", "s", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubySword), new Object[] { "c", "c", "s", 'c', Dungeons.ruby, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.silverSword), new Object[] { "c", "c", "s", 'c', Dungeons.silver, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyDiamondSword), new Object[] { "c", "c", "s", 'c', Blocks.diamond_block, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyIronSword), new Object[] { "c", "c", "s", 'c', Blocks.iron_block, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyHeavySword), new Object[] { "c", "c", "s", 'c', Dungeons.rubyBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.castIronSword), new Object[] { "c", "c", "s", 'c', Dungeons.castIron, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.castIronStar, 8), new Object[] { " c ", "c c", " c ", 'c', Dungeons.castIron });
        GameRegistry.addRecipe(new ItemStack(Dungeons.amazoniteSword), new Object[] { "c", "c", "s", 'c', Dungeons.amazonite, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperHeavySword), new Object[] { "c", "c", "s", 'c', Dungeons.copperBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.silverHeavySword), new Object[] { "c", "c", "s", 'c', Dungeons.silverBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.bedrockSword), new Object[] { "ccc", " s ", 'c', Dungeons.bedrock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyBedrockSword), new Object[] { "ccc", " s ", 'c', Blocks.bedrock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumSword), new Object[] { "c", "c", "s", 'c', Dungeons.lithium, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumHeavySword), new Object[] { "c", "c", "s", 'c', Dungeons.lithiumBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystSword), new Object[] { "c", "c", "s", 'c', Dungeons.amethyst, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyAmethystSword), new Object[] { "c", "c", "s", 'c', Dungeons.amethystBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelSword), new Object[] { "c", "c", "s", 'c', Dungeons.netherSteel, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.heavyNetherSteelSword), new Object[] { "c", "c", "s", 'c', Dungeons.netherSteelBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.crystalSword), new Object[] { "c", "c", "s", 'c', Dungeons.crystallium, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.crystalHeavySword), new Object[] { "c", "c", "s", 'c', Dungeons.crystalliumBlock, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.bubbleSword), new Object[] { " cc", "ccc", "sc ", 'c', Dungeons.waterRod, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.tornadoSword), new Object[] { " cc", "ccc", "sc ", 'c', Dungeons.stormRod, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.elementalSword), new Object[] { " ai", "twa", "st ", 't', Dungeons.stormRod, 's', Items.stick, 'a', Dungeons.sandRod, 'i', Dungeons.iceRod, 'w', Dungeons.waterRod });
        GameRegistry.addRecipe(new ItemStack(Dungeons.swordOfCorruption), new Object[] { " c ", "csc", " c ", 'c', Dungeons.corruptedSoul, 's', Dungeons.elementalSword });
    }
}
