

package com.gibby.dungeon.init.recipeinit;

import com.gibby.dungeon.Dungeons;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagicCrafting
{
    public static void Recipes() {
        GameRegistry.addRecipe(new ItemStack(Dungeons.pulseWand), "c", "m", "s", 'c', Blocks.snow, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.poisonWand), "c", "m", "s", 'c', Items.fermented_spider_eye, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.magicWand), "m", "m", "s", 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.shimmerWand), " c ", "cmc", " s ", 'c', Dungeons.shimmerPearl, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.metalWand), " c ", "cmc", " s ", 'c', Dungeons.copper, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.growthStaff), " c ", "cmc", " s ", 'c', Blocks.vine, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.inflameStaff), " c ", "cmc", " s ", 'c', Items.blaze_powder, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.windStaff), " c ", "cmc", " s ", 'c', Dungeons.lithium, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.speedStaff), " c ", "cmc", " s ", 'c', Dungeons.silver, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.crecentWand), " c ", "cmc", " s ", 'c', Blocks.tnt, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.chaoticWand), " c ", "cmc", " s ", 'c', Dungeons.corruptedSoul, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.ionicWand), " c ", "bmb", " s ", 'c', Dungeons.lithium, 'b', Dungeons.bedrock, 's', Items.stick, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.witherStaff), "t", "t", "s", 's', Items.blaze_rod, 't', Items.nether_star);
        ItemStack stack = new ItemStack(Dungeons.earthTome);
        stack.setItemDamage(stack.getMaxDamage() - 1);
        GameRegistry.addRecipe(stack, "m", "c", "g", 'c', Items.book, 'g', Item.getItemFromBlock(Blocks.gold_block), 'm', Dungeons.magicGem);
        stack = new ItemStack(Dungeons.antigravityTome);
        stack.setItemDamage(stack.getMaxDamage() - 1);
        GameRegistry.addRecipe(stack, "m", "c", "g", 'c', Items.book, 'g', Dungeons.gravityStaff, 'm', Dungeons.magicGem);
        stack = new ItemStack(Dungeons.energyTome);
        stack.setItemDamage(stack.getMaxDamage() - 1);
        GameRegistry.addRecipe(stack, "m", "c", "g", 'c', Items.book, 'g', Dungeons.silverBlock, 'm', Dungeons.magicGem);
        stack = new ItemStack(Dungeons.battleTome);
        stack.setItemDamage(stack.getMaxDamage() - 1);
        GameRegistry.addRecipe(stack, "m", "c", "g", 'c', Items.book, 'g', Dungeons.rubyHeavySword, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.gravityStaff), "g", "m", "c", 'c', Items.stick, 'g', Dungeons.silverBlock, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.netherDrill), " c ", "csc", " c ", 'c', Dungeons.corruptedSoul, 's', Dungeons.sodbuster);
        stack = new ItemStack(Dungeons.tomeOfMagic);
        stack.setItemDamage(stack.getMaxDamage() - 1);
        GameRegistry.addRecipe(stack, "m", "b", 'b', Items.book, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.botAmulet), " m ", "csc", " c ", 'c', Dungeons.copper, 's', Dungeons.botSword, 'm', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.orcWarWand), "m", "s", "s", 's', Dungeons.blackIron, 'm', Dungeons.arcaneGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.magirockWand), " m ", "mgm", " s ", 's', Items.stick, 'm', Dungeons.magirockChunk, 'g', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.voidrockWand), " m ", "mgm", " s ", 's', Items.stick, 'm', Dungeons.voidrockChunk, 'g', Dungeons.magicGem);
        GameRegistry.addRecipe(new ItemStack(Dungeons.cvoidrim), "mmm", "m m", "mmm", 'm', Dungeons.voidrockChunk);
        GameRegistry.addRecipe(new ItemStack(Dungeons.voidrimWand), "m", "s", 'm', Dungeons.cvoidrim, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Dungeons.fusionWand), "v", "s", 's', Items.stick, 'v', Dungeons.fusionWand);
        GameRegistry.addRecipe(new ItemStack(Dungeons.regenTome), " m ", "mgm", " s ", 's', Items.book, 'm', Dungeons.ruby, 'g', Dungeons.magicGem);
    }
}
