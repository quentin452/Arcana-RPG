

package com.gibby.dungeon;

import net.minecraft.item.*;
import net.minecraft.init.*;
import cpw.mods.fml.common.registry.*;

public class ToolCrafting
{
    public static void Recipes() {
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperaxe), new Object[] { "cc", "sc", "s ", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperaxe), new Object[] { "cc", "cs", " s", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperpickaxe), new Object[] { "ccc", " s ", " s ", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.coppershovel), new Object[] { "c", "s", "s", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperhoe), new Object[] { "cc", "s ", "s ", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.copperhoe), new Object[] { "cc", " s", " s", 'c', Dungeons.copper, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyAxe), new Object[] { "cc", "sc", "s ", 'c', Dungeons.ruby, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyAxe), new Object[] { "cc", "cs", " s", 'c', Dungeons.ruby, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyPickaxe), new Object[] { "ccc", " s ", " s ", 'c', Dungeons.ruby, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.rubyShovel), new Object[] { "c", "s", "s", 'c', Dungeons.ruby, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystAxe), new Object[] { "cc", "sc", "s ", 'c', Dungeons.amethyst, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystAxe), new Object[] { "cc", "cs", " s", 'c', Dungeons.amethyst, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystPickaxe), new Object[] { "ccc", " s ", " s ", 'c', Dungeons.amethyst, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.amethystShovel), new Object[] { "c", "s", "s", 'c', Dungeons.amethyst, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumAxe), new Object[] { "cc", "sc", "s ", 'c', Dungeons.lithium, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumAxe), new Object[] { "cc", "cs", " s", 'c', Dungeons.lithium, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumPickaxe), new Object[] { "ccc", " s ", " s ", 'c', Dungeons.lithium, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.lithiumShovel), new Object[] { "c", "s", "s", 'c', Dungeons.lithium, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelAxe), new Object[] { "cc", "sc", "s ", 'c', Dungeons.netherSteel, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelAxe), new Object[] { "cc", "cs", " s", 'c', Dungeons.netherSteel, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelPickaxe), new Object[] { "ccc", " s ", " s ", 'c', Dungeons.netherSteel, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherSteelShovel), new Object[] { "c", "s", "s", 'c', Dungeons.netherSteel, 's', Items.stick });
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherHoe), new Object[] { "nc", "s ", "s ", 'c', Dungeons.netherSteel, 's', Items.stick, 'n', Dungeons.corruptedSoul });
    }
}
