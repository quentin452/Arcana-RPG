

package com.gibby.dungeon;

import packetPipelines.*;
import net.minecraft.world.biome.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.creativetab.*;
import net.minecraftforge.common.util.*;
import java.io.*;
import net.minecraftforge.common.config.*;
import com.gibby.dungeon.items.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import cpw.mods.fml.common.registry.*;
import com.gibby.dungeon.mobs.*;
import com.gibby.dungeon.gen.*;
import cpw.mods.fml.common.*;
import net.minecraft.entity.monster.*;
import cpw.mods.fml.common.event.*;
import net.minecraft.entity.*;
import net.minecraftforge.common.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import com.gibby.dungeon.blocks.*;
import cpw.mods.fml.relauncher.*;

@Mod(modid = "gibby_dungeons", version = "1.3")
public class Dungeons
{
    public static final String MODID = "gibby_dungeons";
    public static final String VERSION = "1.3";
    @SidedProxy(clientSide = "com.gibby.dungeon.ClientProxy", serverSide = "com.gibby.dungeon.commonProxy")
    public static CommonProxy proxy;
    @Mod.Instance("gibby_dungeons")
    public static Dungeons instance;
    public static final PacketPipeline packetPipeline;
    public static Item copper;
    public static Item amazonite;
    public static Item ruby;
    public static Item castIron;
    public static Item silver;
    public static Item bedrock;
    public static Item lithium;
    public static Item shimmerPearl;
    public static Item sunsetOrb;
    public static Item entityEnrager;
    public static Item amethyst;
    public static Item netherSteel;
    public static Item netherSteelShards;
    public static Item rawTrollMeat;
    public static Item cookedTrollMeat;
    public static Item corruptedSoul;
    public static Item iceRod;
    public static Item stormRod;
    public static Item waterRod;
    public static Item sandRod;
    public static Item netherHoe;
    public static Item metalCoin;
    public static Item magicCoin;
    public static Item voidCoin;
    public static Item corruptedMagicOrb;
    public static Item corruptedNetherSoul;
    public static Item cursedStone;
    public static Item magicPotion;
    public static Item magicPotion2;
    public static Item crystallium;
    public static Item dungeonPiece1;
    public static Item dungeonPiece2;
    public static Item dungeonPiece3;
    public static Item dungeonPiece4;
    public static Item dungeonPiece5;
    public static Item dungeonDimensionSpawner;
    public static Item entityDestroyer;
    public static Item whiskey;
    public static Item gingerAle;
    public static Item rootBeer;
    public static Item blackIronScraps;
    public static Item blackIron;
    public static Item arcaneGem;
    public static Item redKey;
    public static Item blueKey;
    public static Item blackKey;
    public static Item yellowKey;
    public static Item magirockCrystal;
    public static Item magirockChunk;
    public static Item magirockCharge;
    public static Item voidrockCrystal;
    public static Item voidrockChunk;
    public static Item magicalOrb;
    public static Item heavyIronSword;
    public static Item heavyDiamondSword;
    public static Item graniteSword;
    public static Item castIronSword;
    public static Item castIronStar;
    public static Item amazoniteSword;
    public static Item silverSword;
    public static Item silverHeavySword;
    public static Item rubyHeavySword;
    public static Item copperHeavySword;
    public static Item bedrockSword;
    public static Item heavyBedrockSword;
    public static Item whittler;
    public static Item trollAxe;
    public static Item lithiumSword;
    public static Item lithiumHeavySword;
    public static Item netherSkullSword;
    public static Item heavyNetherSteelSword;
    public static Item lythe;
    public static Item voidSword;
    public static Item elementalSword;
    public static Item corruptedSword;
    public static Item swordOfCorruption;
    public static Item flameSword;
    public static Item netherGhastSword;
    public static Item botSword;
    public static Item fireClub;
    public static Item harpBow;
    public static Item amethystLance;
    public static Item amethystRapier;
    public static Item mace;
    public static Item lavaKnightSword;
    public static Item steelSword;
    public static Item tornadoSword;
    public static Item vampiricSword;
    public static Item voidFiendSword;
    public static Item crystalHeavySword;
    public static Item crystalSword;
    public static Item bubbleSword;
    public static Item valesis;
    public static Item corruptedBow;
    public static Item disinigrationBow;
    public static Item torturedChainSword;
    public static Item dungeonEyeSword;
    public static Item frostySword;
    public static Item blackIronSword;
    public static Item sunAxe;
    public static Item magirockSword;
    public static Item exawdusSmasher;
    public static Item tomeOfMagic;
    public static Item forceWand;
    public static Item pulseWand;
    public static Item poisonWand;
    public static Item magicWand;
    public static Item magicGem;
    public static Item bloodWand;
    public static Item sodbuster;
    public static Item shimmerWand;
    public static Item metalWand;
    public static Item growthStaff;
    public static Item inflameStaff;
    public static Item gravityStaff;
    public static Item windStaff;
    public static Item speedStaff;
    public static Item voidWand;
    public static Item cursedWand;
    public static Item chaoticWand;
    public static Item hadrialWand;
    public static Item ionicWand;
    public static Item netherDrill;
    public static Item witherStaff;
    public static Item warlockStaff;
    public static Item earthTome;
    public static Item antigravityTome;
    public static Item energyTome;
    public static Item battleTome;
    public static Item crecentWand;
    public static Item quakeWand;
    public static Item orcWarWand;
    public static Item icefireWand;
    public static Item sapientWarWand;
    public static Item deathBringerWand;
    public static Item magirockWand;
    public static Item voidrimWand;
    public static Item voidrockWand;
    public static Item fusionWand;
    public static Item botAmulet;
    public static Item necroticAmulet;
    public static Item beefstew;
    public static Item copperhelmet;
    public static Item copperchestplate;
    public static Item copperleggings;
    public static Item copperboots;
    public static Item amazoniteHelmet;
    public static Item amazoniteChestplate;
    public static Item amazoniteLeggings;
    public static Item amazoniteBoots;
    public static Item rubyHelmet;
    public static Item rubyChestplate;
    public static Item rubyLeggings;
    public static Item rubyBoots;
    public static Item silverHelmet;
    public static Item silverChestplate;
    public static Item silverLeggings;
    public static Item silverBoots;
    public static Item bedrockHelmet;
    public static Item bedrockChestplate;
    public static Item bedrockLeggings;
    public static Item bedrockBoots;
    public static Item lithiumHelmet;
    public static Item lithiumChestplate;
    public static Item lithiumLeggings;
    public static Item lithiumBoots;
    public static Item amethystHelmet;
    public static Item amethystChestplate;
    public static Item amethystLeggings;
    public static Item amethystBoots;
    public static Item netherSkullHelmet;
    public static Item netherSkullChestplate;
    public static Item netherSkullLeggings;
    public static Item netherSkullBoots;
    public static Item netherSteelHelmet;
    public static Item netherSteelChestplate;
    public static Item netherSteelLeggings;
    public static Item netherSteelBoots;
    public static Item crystalliumHelmet;
    public static Item crystalliumChestplate;
    public static Item crystalliumLeggings;
    public static Item crystalliumBoots;
    public static Item blackIronHelmet;
    public static Item blackIronChestplate;
    public static Item blackIronLeggings;
    public static Item blackIronBoots;
    public static Item blindLightHelmet;
    public static Item blindLightChestplate;
    public static Item blindLightLeggings;
    public static Item blindLightBoots;
    public static Item coppersword;
    public static Item copperaxe;
    public static Item copperpickaxe;
    public static Item coppershovel;
    public static Item copperhoe;
    public static Item rubySword;
    public static Item rubyAxe;
    public static Item rubyPickaxe;
    public static Item rubyShovel;
    public static Item lithiumAxe;
    public static Item lithiumShovel;
    public static Item lithiumPickaxe;
    public static Item amethystSword;
    public static Item heavyAmethystSword;
    public static Item amethystAxe;
    public static Item amethystPickaxe;
    public static Item amethystShovel;
    public static Item netherSteelSword;
    public static Item netherSteelAxe;
    public static Item netherSteelPickaxe;
    public static Item netherSteelShovel;
    public static Block dungeonSpawner;
    public static Block dungeonSpawnerRepeater;
    public static Block copperore;
    public static Block rubyOre;
    public static Block amazoniteOre;
    public static Block silverOre;
    public static Block rubyBlock;
    public static Block copperBlock;
    public static Block bedrockOre;
    public static Block lithiumOre;
    public static Block bleachedStone;
    public static Block redBlock;
    public static Block blueBlock;
    public static Block silverBlock;
    public static Block lithiumBlock;
    public static Block amethystOre;
    public static Block amethystBlock;
    public static Block netherSteelOre;
    public static Block netherSteelBlock;
    public static Block voidBrick;
    public static Block blackBrick;
    public static Block amethystStone;
    public static Block portalAmethyst;
    public static Block amethystCrystalized;
    public static Block amethystCracks;
    public static Block crystalOre;
    public static Block portalSunset;
    public static Block crystalWeed;
    public static Block crystalStem;
    public static Block purpleEye;
    public static Block shimmerFlower;
    public static Block crystalLeaf;
    public static Block ghostRose;
    public static Block yellowTippedGrass;
    public static Block badgererSpawner;
    public static Block witherSpawner;
    public static Block purpleBrick;
    public static Block crystalliumBlock;
    public static Block frostSpikes;
    public static Block portalMontane;
    public static Block redKeyClosed;
    public static Block redKeyOpen;
    public static Block blueKeyClosed;
    public static Block blueKeyOpen;
    public static Block blackKeyClosed;
    public static Block blackKeyOpen;
    public static Block stoneDoor;
    public static Block doorOpener;
    public static Block undefeatableSpawner;
    public static Block yellowLock;
    public static Block deathBringerSpawner;
    public static Block iceSpiritSpawner;
    public static Block midnightPortalSpawner;
    public static Block crystalliumGrass;
    public static Block crystalliumDirt;
    public static Block caveMushrooms;
    public static Block crystalWood;
    public static Block crystalliumFern;
    public static Block crystalliumLeaves;
    public static Block magirockOre;
    public static Block portalCrystalPlains;
    public static Block crystalliumLamp;
    public static Block carvedCrystalliumBrick;
    public static Block exawdusSpawner;
    public static Block crystalliumStairs;
    public static Block magitable;
    public static Block magitableCharged;
    public static Block crystalDirt;
    public static Block crystalGrass;
    public static Block crystalLeaves;
    public static Block crystalBamboo;
    public static Block voidrockOre;
    public static Item cyellow;
    public static Item cgreen;
    public static Item cblue;
    public static Item cdarkblue;
    public static Item cgray;
    public static Item cpurple;
    public static Item invisible;
    public static Item cvoidrim;
    public static BiomeGenBase sunset;
    public static BiomeGenBase crystal;
    public static BiomeGenBase montane;
    public static BiomeGenBase crystalliumPlainsBiome;
    public static int sunsetBiomeId;
    public static int crystalBiomeId;
    public static int montaneBiomeId;
    public static int crystalliumPlainsBiomeId;
    public Item.ToolMaterial COPPER;
    public Item.ToolMaterial RUBY;
    public Item.ToolMaterial HEAVYIRON;
    public Item.ToolMaterial HEAVYDIAMOND;
    public Item.ToolMaterial CASTIRON;
    public Item.ToolMaterial HEAVYRUBY;
    public Item.ToolMaterial BEDROCK;
    public Item.ToolMaterial HEAVYBEDROCK;
    public Item.ToolMaterial WHITTLER;
    public Item.ToolMaterial LITHIUM;
    public Item.ToolMaterial HEAVYLITHIUM;
    public Item.ToolMaterial AXE;
    public Item.ToolMaterial HEAVYSILVER;
    public Item.ToolMaterial AMETHYST;
    public Item.ToolMaterial AMETHYSTLANCE;
    public Item.ToolMaterial AMETHYSTRAPIER;
    public Item.ToolMaterial HEAVYAMETHYST;
    public Item.ToolMaterial NETHERSTEEL;
    public Item.ToolMaterial HEAVYNETHERSTEEL;
    public Item.ToolMaterial ELEMENTALSWORD;
    public Item.ToolMaterial FIRE;
    public Item.ToolMaterial CRYSTAL;
    public Item.ToolMaterial HEAVYCRYSTAL;
    public Item.ToolMaterial TCHAIN;
    public Item.ToolMaterial MAGIROCK;
    public Item.ToolMaterial EXAWDUS;
    public ItemArmor.ArmorMaterial ACOPPER;
    public ItemArmor.ArmorMaterial ARUBY;
    public ItemArmor.ArmorMaterial AAMAZONITE;
    public ItemArmor.ArmorMaterial ASILVER;
    public ItemArmor.ArmorMaterial ABEDROCK;
    public ItemArmor.ArmorMaterial ALITHIUM;
    public ItemArmor.ArmorMaterial AAMETHYST;
    public ItemArmor.ArmorMaterial ANETHER;
    public ItemArmor.ArmorMaterial ANETHERSTEEL;
    public ItemArmor.ArmorMaterial ACRYSTALLIUM;
    public ItemArmor.ArmorMaterial ABLACKIRON;
    public static Enchantment magicProtection;
    public static Enchantment voidProtection;
    public static Enchantment voidBlade;
    public static Enchantment magicBlade;
    public static Enchantment rare;
    public static Enchantment legendary;
    public static Enchantment frostblade;
    public static Enchantment windblade;
    public static Enchantment quakeblade;
    public static Enchantment lifesteal;
    public static int magicProtectionId;
    public static int voidProtectionId;
    public static int voidBladeId;
    public static int magicBladeId;
    public static int rareId;
    public static int legendaryId;
    public static int frostbladeId;
    public static int windBladeId;
    public static int quakebladeId;
    public static int lifestealId;
    public static Potion shock;
    public static Potion magicBoost;
    public static Potion growth;
    public static Potion inflame;
    public static Potion storm;
    public static Potion antigravity;
    public static Potion shadowAura;
    public static Potion crystalliumBlessing;
    public static Potion imbalance;
    public static Potion sunspot;
    public static int shockId;
    public static int magicBoostId;
    public static int growthId;
    public static int inflameId;
    public static int stormId;
    public static int antigravityId;
    public static int shadowAuraId;
    public static int crystalliumBlessingId;
    public static int imbalanceId;
    public static int sunspotId;
    public static int MAGIC_WATCHER;
    public static final CreativeTabs Materials;
    public static final CreativeTabs Blocks;
    public static final CreativeTabs Weapons;
    public static final CreativeTabs Armor;
    public static final CreativeTabs Magic;
    public static final CreativeTabs Key;
    public static int magicBarXpoz;
    public static int magicBarYpoz;
    private int entitylistEnabled;
    public static int crystalDimensionId;
    public static int sunsetDimensionId;
    public static int montaneDungeonDimensionId;
    public static int crystalliumPlainsDimensionId;
    public static final String DATA_WATCHER = "Data Watcher";
    public static final String ENCHANTMENT = "Enchantment";
    public static final String POTION_EFFECT = "Potion Effect";
    public static final String BIOME = "Biome";
    public static final String DIMENSION = "Dimension";
    public static final String GUI = "Gui(bar)";
    public static final String MISC = "Misc";
    static int startEntityid;
    
    public Dungeons() {
        this.COPPER = EnumHelper.addToolMaterial("dungeons_copper", 2, 200, 5.5f, 2.0f, 20);
        this.RUBY = EnumHelper.addToolMaterial("dungeons_ruby", 4, 600, 7.0f, 1.0f, 17);
        this.HEAVYIRON = EnumHelper.addToolMaterial("dungeons_iron", 3, 1500, 7.0f, 4.0f, 12);
        this.HEAVYDIAMOND = EnumHelper.addToolMaterial("dungeons_diamond", 3, 4000, 8.0f, 9.0f, 10);
        this.CASTIRON = EnumHelper.addToolMaterial("dungeons_castiron", 3, 1000, 7.0f, 3.0f, 10);
        this.HEAVYRUBY = EnumHelper.addToolMaterial("dungeons_heavyruby", 4, 2400, 10.0f, 3.0f, 17);
        this.BEDROCK = EnumHelper.addToolMaterial("dungeons_bedrock", 5, 2000, 9.0f, 3.0f, 13);
        this.HEAVYBEDROCK = EnumHelper.addToolMaterial("dungeons_heavybedrock", 5, 7000, 9.0f, 5.0f, 13);
        this.WHITTLER = EnumHelper.addToolMaterial("dungeons_whittler", 3, 400, 9.0f, 4.0f, 13);
        this.LITHIUM = EnumHelper.addToolMaterial("dungeons_lithium", 5, 900, 13.0f, 5.0f, 18);
        this.HEAVYLITHIUM = EnumHelper.addToolMaterial("dungeons_heavylithium", 3, 2700, 12.0f, 6.0f, 18);
        this.AXE = EnumHelper.addToolMaterial("dungeons_axe", 3, 900, 7.0f, 4.0f, 12);
        this.HEAVYSILVER = EnumHelper.addToolMaterial("dungeons_heavysilver", 3, 600, 7.0f, 2.0f, 20);
        this.AMETHYST = EnumHelper.addToolMaterial("dungeons_amethyst", 6, 3000, 16.0f, 6.0f, 18);
        this.AMETHYSTLANCE = EnumHelper.addToolMaterial("dungeons_amethystlance", 6, 2000, 13.0f, 5.0f, 18);
        this.AMETHYSTRAPIER = EnumHelper.addToolMaterial("dungeons_amethystrapier", 6, 2000, 13.0f, 7.0f, 18);
        this.HEAVYAMETHYST = EnumHelper.addToolMaterial("dungeons_heavyamethyst", 5, 9000, 14.0f, 7.0f, 18);
        this.NETHERSTEEL = EnumHelper.addToolMaterial("dungeons_nethersteel", 6, 3000, 21.0f, 7.0f, 15);
        this.HEAVYNETHERSTEEL = EnumHelper.addToolMaterial("dungeons_heavynethersteel", 6, 9000, 15.0f, 10.0f, 15);
        this.ELEMENTALSWORD = EnumHelper.addToolMaterial("dungeons_elementalsword", 1, 1250, 100.0f, 2.0f, 25);
        this.FIRE = EnumHelper.addToolMaterial("dungeons_fire", 5, 600, 10.0f, 10.0f, 15);
        this.CRYSTAL = EnumHelper.addToolMaterial("dungeons_crystal", 6, 4000, 15.0f, 7.0f, 20);
        this.HEAVYCRYSTAL = EnumHelper.addToolMaterial("dungeons_heavycrystal", 6, 12000, 15.0f, 10.0f, 20);
        this.TCHAIN = EnumHelper.addToolMaterial("dungeons_tchain", 6, 2000, 15.0f, 9.0f, 15);
        this.MAGIROCK = EnumHelper.addToolMaterial("dungeons_magirock", 6, 3000, 15.0f, 0.0f, 25);
        this.EXAWDUS = EnumHelper.addToolMaterial("dungeons_exawdus", 6, 5000, 15.0f, 2.0f, 25);
        this.ACOPPER = EnumHelper.addArmorMaterial("dungeons_acopper", 20, new int[] { 3, 6, 4, 2 }, 20);
        this.ARUBY = EnumHelper.addArmorMaterial("dungeons_aruby", 36, new int[] { 3, 7, 5, 3 }, 17);
        this.AAMAZONITE = EnumHelper.addArmorMaterial("dungeons_aamazonite", 29, new int[] { 3, 6, 5, 2 }, 17);
        this.ASILVER = EnumHelper.addArmorMaterial("dungeons_asilver", 18, new int[] { 2, 4, 4, 2 }, 22);
        this.ABEDROCK = EnumHelper.addArmorMaterial("dungeons_abedrock", 72, new int[] { 4, 7, 6, 3 }, 13);
        this.ALITHIUM = EnumHelper.addArmorMaterial("dungeons_alithium", 58, new int[] { 4, 8, 6, 4 }, 18);
        this.AAMETHYST = EnumHelper.addArmorMaterial("dungeons_aamethyst", 72, new int[] { 4, 8, 7, 4 }, 18);
        this.ANETHER = EnumHelper.addArmorMaterial("dungeons_anether", 54, new int[] { 3, 6, 6, 3 }, 14);
        this.ANETHERSTEEL = EnumHelper.addArmorMaterial("dungeons_anethersteel", 76, new int[] { 4, 8, 7, 4 }, 14);
        this.ACRYSTALLIUM = EnumHelper.addArmorMaterial("dungeons_acrystallium", 86, new int[] { 5, 8, 7, 4 }, 18);
        this.ABLACKIRON = EnumHelper.addArmorMaterial("dungeons_ablackiron", 72, new int[] { 4, 8, 7, 4 }, 18);
    }
    
    @Mod.EventHandler
    public void preinit(final FMLPreInitializationEvent event) {
        final Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "Arcana_RPG.cfg"));
        config.load();
        config.addCustomCategoryComment("Misc", "The Entity Id's Disabled will wipe vanilla minecraft spawners for Arcana RPG.");
        config.addCustomCategoryComment("Misc", "If disabled, custom spawners will not be wiped.");
        config.addCustomCategoryComment("Misc", "If you have entitylist conflicts, disable Entity Ids(set to 0)");
        this.entitylistEnabled = config.get("Misc", "Entity Ids Enabled(1) or Disabled(0)", 1).getInt();
        Dungeons.magicBarXpoz = config.get("Gui(bar)", "Magic_Bar_X_pos", 200).getInt();
        Dungeons.magicBarYpoz = config.get("Gui(bar)", "Magic_Bar_Y_poz", 10).getInt();
        Dungeons.sunsetBiomeId = config.get("Biome", "Sunset_Biome_Id", 250).getInt();
        Dungeons.crystalBiomeId = config.get("Biome", "Crystal_Biome_Id", 251).getInt();
        Dungeons.montaneBiomeId = config.get("Biome", "Montane_Biome_Id", 252).getInt();
        Dungeons.crystalliumPlainsBiomeId = config.get("Biome", "Crystallim_Plains_Biome_Id", 253).getInt();
        Dungeons.sunsetDimensionId = config.get("Dimension", "Sunset_Dimension_Id", -15).getInt();
        Dungeons.crystalDimensionId = config.get("Dimension", "Crystal_Dimension_Id", -20).getInt();
        Dungeons.montaneDungeonDimensionId = config.get("Dimension", "Montane_Dungeon_Dimension_Id", -21).getInt();
        Dungeons.crystalliumPlainsDimensionId = config.get("Dimension", "Crystallium_Plains_Dimension_Id", -22).getInt();
        Dungeons.MAGIC_WATCHER = config.get("Data Watcher", "MagicWatcherId", 20).getInt();
        Dungeons.magicProtectionId = config.get("Enchantment", "Magic_Protection", 70).getInt();
        Dungeons.voidProtectionId = config.get("Enchantment", "Void_Protection", 71).getInt();
        Dungeons.voidBladeId = config.get("Enchantment", "Void_Blade", 72).getInt();
        Dungeons.magicBladeId = config.get("Enchantment", "Magic_Blade", 73).getInt();
        Dungeons.rareId = config.get("Enchantment", "rare", 74).getInt();
        Dungeons.legendaryId = config.get("Enchantment", "Legendary", 75).getInt();
        Dungeons.frostbladeId = config.get("Enchantment", "Frost_Blade", 76).getInt();
        Dungeons.windBladeId = config.get("Enchantment", "Wind_Blade", 77).getInt();
        Dungeons.quakebladeId = config.get("Enchantment", "Quake_Blade", 78).getInt();
        Dungeons.lifestealId = config.get("Enchantment", "Vampiric_Blade", 79).getInt();
        Dungeons.shockId = config.get("Potion Effect", "Shock", 50).getInt();
        Dungeons.magicBoostId = config.get("Potion Effect", "Magic_Boost", 51).getInt();
        Dungeons.growthId = config.get("Potion Effect", "Regrowth", 52).getInt();
        Dungeons.inflameId = config.get("Potion Effect", "Inflame", 53).getInt();
        Dungeons.stormId = config.get("Potion Effect", "Storm", 54).getInt();
        Dungeons.antigravityId = config.get("Potion Effect", "Antigravity", 55).getInt();
        Dungeons.shadowAuraId = config.get("Potion Effect", "Shadow_Aura", 56).getInt();
        Dungeons.crystalliumBlessingId = config.get("Potion Effect", "Crystallium_Blessing", 57).getInt();
        Dungeons.imbalanceId = config.get("Potion Effect", "Imbalance", 58).getInt();
        Dungeons.sunspotId = config.get("Potion Effect", "Sunspot", 59).getInt();
        config.save();
        DungeonPotions.PotionSetup();
        Dungeons.shock = new DungeonPotion(Dungeons.shockId, false, 3484199).setIconIndex(0, 1).setPotionName("potion.shock");
        Dungeons.magicBoost = new DungeonPotion(Dungeons.magicBoostId, false, 3484199).setIconIndex(5, 1).setPotionName("potion.magicBoost");
        Dungeons.growth = new DungeonPotion(Dungeons.growthId, false, 3484199).setIconIndex(7, 0).setPotionName("potion.growth");
        Dungeons.inflame = new DungeonPotion(Dungeons.inflameId, false, 3484199).setIconIndex(7, 1).setPotionName("potion.inflame");
        Dungeons.storm = new DungeonPotion(Dungeons.stormId, false, 3484199).setIconIndex(0, 0).setPotionName("potion.storm");
        Dungeons.antigravity = new DungeonPotion(Dungeons.antigravityId, false, 3484199).setIconIndex(2, 1).setPotionName("potion.antigravity");
        Dungeons.shadowAura = new DungeonPotion(Dungeons.shadowAuraId, false, 3484199).setIconIndex(5, 1).setPotionName("potion.shadowAura");
        Dungeons.crystalliumBlessing = new DungeonPotion(Dungeons.crystalliumBlessingId, false, 3484199).setIconIndex(7, 1).setPotionName("potion.crystalliumBlessing");
        Dungeons.imbalance = new DungeonPotion(Dungeons.imbalanceId, false, 3484199).setIconIndex(3, 1).setPotionName("potion.imbalance");
        Dungeons.sunspot = new DungeonPotion(Dungeons.sunspotId, false, 3484199).setIconIndex(7, 1).setPotionName("potion.sunspot");
        Dungeons.sunset = new BiomeSunset(Dungeons.sunsetBiomeId).setDisableRain().setTemperatureRainfall(-0.0f, 0.0f);
        Dungeons.crystal = new BiomeCrystal(Dungeons.crystalBiomeId).setDisableRain().setTemperatureRainfall(-0.0f, 0.0f);
        Dungeons.montane = new BiomeSunset(Dungeons.montaneBiomeId).setEnableSnow().setTemperatureRainfall(-0.5f, 0.4f);
        Dungeons.crystalliumPlainsBiome = new BiomeCrystalliumPlains(Dungeons.crystalliumPlainsBiomeId).setTemperatureRainfall(0.2f, 0.0f);
        Dungeons.magicProtection = new EnchantmentProtection2(Dungeons.magicProtectionId, 5, 0);
        Dungeons.voidProtection = new EnchantmentProtection2(Dungeons.voidProtectionId, 5, 1);
        Dungeons.voidBlade = new EnchantmentDamage2(Dungeons.voidBladeId, 5, 1);
        Dungeons.magicBlade = new EnchantmentDamage2(Dungeons.magicBladeId, 5, 0);
        Dungeons.rare = new EnchantmentDamage2(Dungeons.rareId, 0, 2);
        Dungeons.legendary = new EnchantmentDamage2(Dungeons.legendaryId, 0, 3);
        Dungeons.frostblade = new EnchantmentDamage2(Dungeons.frostbladeId, 5, 4);
        Dungeons.windblade = new EnchantmentDamage2(Dungeons.windBladeId, 5, 5);
        Dungeons.quakeblade = new EnchantmentDamage2(Dungeons.quakebladeId, 5, 6);
        Dungeons.lifesteal = new EnchantmentDamage2(Dungeons.lifestealId, 5, 7);
        Dungeons.packetPipeline.initialise();
        DimensionManager.registerProviderType(Dungeons.crystalDimensionId, (Class)WorldProviderCrystal.class, false);
        DimensionManager.registerDimension(Dungeons.crystalDimensionId, Dungeons.crystalDimensionId);
        DimensionManager.registerProviderType(Dungeons.sunsetDimensionId, (Class)WorldProviderSunset.class, false);
        DimensionManager.registerDimension(Dungeons.sunsetDimensionId, Dungeons.sunsetDimensionId);
        DimensionManager.registerProviderType(Dungeons.montaneDungeonDimensionId, (Class)WorldProviderMontane.class, false);
        DimensionManager.registerDimension(Dungeons.montaneDungeonDimensionId, Dungeons.montaneDungeonDimensionId);
        DimensionManager.registerProviderType(Dungeons.crystalliumPlainsDimensionId, (Class)WorldProviderCrystalliumPlains.class, false);
        DimensionManager.registerDimension(Dungeons.crystalliumPlainsDimensionId, Dungeons.crystalliumPlainsDimensionId);
        Enchantment.addToBookList(Dungeons.magicProtection);
        Enchantment.addToBookList(Dungeons.voidProtection);
        Enchantment.addToBookList(Dungeons.magicBlade);
        Enchantment.addToBookList(Dungeons.voidBlade);
        Dungeons.cblue = new Item().setTextureName("gibby_dungeons" + ":" + "blue");
        Dungeons.cyellow = new Item().setTextureName("gibby_dungeons" + ":" + "yellow");
        Dungeons.cgreen = new Item().setTextureName("gibby_dungeons" + ":" + "green");
        Dungeons.cpurple = new Item().setTextureName("gibby_dungeons" + ":" + "purple");
        Dungeons.cdarkblue = new Item().setTextureName("gibby_dungeons" + ":" + "darkblue");
        Dungeons.cgray = new Item().setTextureName("gibby_dungeons" + ":" + "grey");
        Dungeons.invisible = new Item().setTextureName("gibby_dungeons" + ":" + "invisible");
        Dungeons.cvoidrim = new Item().setTextureName("gibby_dungeons" + ":" + "voidrim");
        GameRegistry.registerItem(Dungeons.cblue, "dungeons_cblue");
        GameRegistry.registerItem(Dungeons.cyellow, "dungeons_cyellow");
        GameRegistry.registerItem(Dungeons.cgreen, "dungeons_cgreen");
        GameRegistry.registerItem(Dungeons.cpurple, "dungeons_cpurple");
        GameRegistry.registerItem(Dungeons.cdarkblue, "dungeons_cdarkblue");
        GameRegistry.registerItem(Dungeons.cgray, "dungeons_cgray");
        GameRegistry.registerItem(Dungeons.invisible, "dungeons_invisible");
        GameRegistry.registerItem(Dungeons.cvoidrim, "dungeons_cvoidrim");
        GameRegistry.registerItem(Dungeons.copper = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("copper").setTextureName("gibby_dungeons" + ":" + "copper"), "dungeons_copper");
        GameRegistry.registerItem(Dungeons.amazonite = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("amazonite").setTextureName("gibby_dungeons" + ":" + "amazonite"), "dungeons_amazonite");
        GameRegistry.registerItem(Dungeons.ruby = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("ruby").setTextureName("gibby_dungeons" + ":" + "ruby"), "dungeons_ruby");
        GameRegistry.registerItem(Dungeons.silver = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("silver").setTextureName("gibby_dungeons" + ":" + "silver"), "dungeons_silver");
        GameRegistry.registerItem(Dungeons.castIron = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("castiron").setTextureName("gibby_dungeons" + ":" + "castiron"), "dungeons_castiron");
        GameRegistry.registerItem(Dungeons.bedrock = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("bedrock").setTextureName("gibby_dungeons" + ":" + "bedrockchunk"), "dungeons_bedrock");
        GameRegistry.registerItem(Dungeons.lithium = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("lithium").setTextureName("gibby_dungeons" + ":" + "lithium"), "dungeons_lithium");
        GameRegistry.registerItem(Dungeons.beefstew = new ItemSoup(9).setUnlocalizedName("beefstew").setTextureName("gibby_dungeons" + ":" + "stew"), "dungeons_beefstew");
        GameRegistry.registerItem(Dungeons.entityEnrager = new ItemEntityEnrager().setCreativeTab(Dungeons.Materials).setUnlocalizedName("entityEnrager").setTextureName("gibby_dungeons" + ":" + "entityenrager"), "dungeons_entityEnrager");
        GameRegistry.registerItem(Dungeons.entityDestroyer = new ItemEntityDestroyer().setCreativeTab(Dungeons.Materials).setUnlocalizedName("entityDestroyer").setTextureName("gibby_dungeons" + ":" + "entitydestroyer"), "dungeons_entityDestroyer");
        GameRegistry.registerItem(Dungeons.amethyst = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("amethyst").setTextureName("gibby_dungeons" + ":" + "amethyst"), "dungeons_amethyst");
        GameRegistry.registerItem(Dungeons.netherSteel = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("netherSteel").setTextureName("gibby_dungeons" + ":" + "nethersteel"), "dungeons_netherSteel");
        GameRegistry.registerItem(Dungeons.netherSteelShards = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("netherSteelShards").setTextureName("gibby_dungeons" + ":" + "flakeynethersteel"), "dungeons_netherSteelShards");
        GameRegistry.registerItem(Dungeons.rawTrollMeat = new ItemFood(3, 1.0f, true).setCreativeTab(Dungeons.Materials).setUnlocalizedName("rawTrollMeat").setTextureName("gibby_dungeons" + ":" + "rawtrollmeat"), "dungeons_rawTrollMeat");
        GameRegistry.registerItem(Dungeons.cookedTrollMeat = new ItemFood(9, 4.0f, true).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0f).setCreativeTab(Dungeons.Materials).setUnlocalizedName("cookedTrollMeat").setTextureName("gibby_dungeons" + ":" + "trollmeat"), "dungeons_cookedTrollMeat");
        GameRegistry.registerItem(Dungeons.corruptedSoul = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("corruptedSoul").setTextureName("gibby_dungeons" + ":" + "corruptedsoul"), "dungeons_corruptedSoul");
        GameRegistry.registerItem(Dungeons.iceRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("iceRod").setTextureName("gibby_dungeons" + ":" + "icyrod").setFull3D(), "dungeons_iceRod");
        GameRegistry.registerItem(Dungeons.waterRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("waterRod").setTextureName("gibby_dungeons" + ":" + "waterrod"), "dungeons_waterRod");
        GameRegistry.registerItem(Dungeons.stormRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("stormRod").setTextureName("gibby_dungeons" + ":" + "stormrod"), "dungeons_stormRod");
        GameRegistry.registerItem(Dungeons.sandRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("sandRod").setTextureName("gibby_dungeons" + ":" + "sandyrod"), "dungeons_sandRod");
        GameRegistry.registerItem(Dungeons.netherHoe = new ItemNetherHoe(this.NETHERSTEEL).setCreativeTab(Dungeons.Materials).setUnlocalizedName("netherHoe").setTextureName("gibby_dungeons" + ":" + "netherhoe"), "dungeons_netherHoe");
        GameRegistry.registerItem(Dungeons.metalCoin = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("metalCoin").setTextureName("gibby_dungeons" + ":" + "metalcoin"), "dungeons_metalCoin");
        GameRegistry.registerItem(Dungeons.magicCoin = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magicCoin").setTextureName("gibby_dungeons" + ":" + "magiccoin"), "dungeons_magicCoin");
        GameRegistry.registerItem(Dungeons.voidCoin = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("voidCoin").setTextureName("gibby_dungeons" + ":" + "voidcoin"), "dungeons_voidCoin");
        GameRegistry.registerItem(Dungeons.sunsetOrb = new ItemSunsetOrb().setCreativeTab(Dungeons.Key).setMaxStackSize(1).setUnlocalizedName("sunsetOrb").setTextureName("gibby_dungeons" + ":" + "sunsetorb"), "dungeons_sunsetOrb");
        GameRegistry.registerItem(Dungeons.corruptedMagicOrb = new ItemCorruptedMagicOrb().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("corruptedMagicOrb").setTextureName("gibby_dungeons" + ":" + "corruptedmagicorb"), "dungeons_corruptedMagicOrb");
        GameRegistry.registerItem(Dungeons.corruptedNetherSoul = new ItemCorruptedNetherSoul().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("corruptedNetherSoul").setTextureName("gibby_dungeons" + ":" + "corruptednethersoul"), "dungeons_corruptedNetherSoul");
        GameRegistry.registerItem(Dungeons.cursedStone = new ItemCursedStone().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("cursedStone").setTextureName("gibby_dungeons" + ":" + "cursedstone"), "dungeons_cursedStone");
        GameRegistry.registerItem(Dungeons.magicPotion = new ItemMagicPotion().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magicPotion").setTextureName("gibby_dungeons" + ":" + "magicpotion"), "dungeons_magicPotion");
        GameRegistry.registerItem(Dungeons.magicPotion2 = new ItemMagicPotion().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magicPotion2").setTextureName("gibby_dungeons" + ":" + "magicpotion2"), "dungeons_magicPotion2");
        GameRegistry.registerItem(Dungeons.crystallium = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("crystallium").setTextureName("gibby_dungeons" + ":" + "crystallium"), "dungeons_crystallium");
        GameRegistry.registerItem(Dungeons.dungeonPiece1 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece1").setTextureName("gibby_dungeons" + ":" + "dungeonpiece1"), "dungeons_dungeonPiece1");
        GameRegistry.registerItem(Dungeons.dungeonPiece2 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece2").setTextureName("gibby_dungeons" + ":" + "dungeonpiece2"), "dungeons_dungeonPiece2");
        GameRegistry.registerItem(Dungeons.dungeonPiece3 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece3").setTextureName("gibby_dungeons" + ":" + "dungeonpiece3"), "dungeons_dungeonPiece3");
        GameRegistry.registerItem(Dungeons.dungeonPiece4 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece4").setTextureName("gibby_dungeons" + ":" + "dungeonpiece4"), "dungeons_dungeonPiece4");
        GameRegistry.registerItem(Dungeons.dungeonPiece5 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece5").setTextureName("gibby_dungeons" + ":" + "dungeonpiece5"), "dungeons_dungeonPiece5");
        GameRegistry.registerItem(Dungeons.dungeonDimensionSpawner = new ItemDungeonDimensionSpawner().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("dungeonDimensionSpawner").setTextureName("gibby_dungeons" + ":" + "cliffhanger"), "dungeonDimensionSpawner");
        GameRegistry.registerItem(Dungeons.whiskey = new ItemAle().setCreativeTab(Dungeons.Materials).setUnlocalizedName("whiskey").setTextureName("gibby_dungeons" + ":" + "whiskey"), "dungeons_whiskey");
        GameRegistry.registerItem(Dungeons.gingerAle = new ItemAle().setCreativeTab(Dungeons.Materials).setUnlocalizedName("gingerAle").setTextureName("gibby_dungeons" + ":" + "gingerale"), "dungeons_gingerAle");
        GameRegistry.registerItem(Dungeons.rootBeer = new ItemAle().setCreativeTab(Dungeons.Materials).setUnlocalizedName("rootBeer").setTextureName("gibby_dungeons" + ":" + "rootbeer"), "dungeons_rootBeer");
        GameRegistry.registerItem(Dungeons.blackIronScraps = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("blackIronScraps").setTextureName("gibby_dungeons" + ":" + "blackironscraps"), "dungeons_blackIronScraps");
        GameRegistry.registerItem(Dungeons.blackIron = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("blackIron").setTextureName("gibby_dungeons" + ":" + "blackiron"), "dungeons_blackIron");
        GameRegistry.registerItem(Dungeons.arcaneGem = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("arcaneGem").setTextureName("gibby_dungeons" + ":" + "arcanegem"), "dungeons_arcaneGem");
        GameRegistry.registerItem(Dungeons.redKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("redKey").setTextureName("gibby_dungeons" + ":" + "redkey"), "dungeons_redKey");
        GameRegistry.registerItem(Dungeons.blueKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("blueKey").setTextureName("gibby_dungeons" + ":" + "bluekey"), "dungeons_blueKey");
        GameRegistry.registerItem(Dungeons.blackKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("blackKey").setTextureName("gibby_dungeons" + ":" + "blackkey"), "dungeons_blackKey");
        GameRegistry.registerItem(Dungeons.yellowKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("yellowKey").setTextureName("gibby_dungeons" + ":" + "yellowkey"), "dungeons_yellowKey");
        GameRegistry.registerItem(Dungeons.magirockCrystal = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magirockCrystal").setTextureName("gibby_dungeons" + ":" + "magirockcrystal"), "dungeons_magirockCrystal");
        GameRegistry.registerItem(Dungeons.magirockChunk = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magirockChunk").setTextureName("gibby_dungeons" + ":" + "magirockchunk"), "dungeons_magirockChunk");
        GameRegistry.registerItem(Dungeons.magirockCharge = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magirockCharge").setTextureName("gibby_dungeons" + ":" + "magirockcharge"), "dungeons_magirockCharge");
        GameRegistry.registerItem(Dungeons.voidrockCrystal = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("voidrockCrystal").setTextureName("gibby_dungeons" + ":" + "voidrockcrystal"), "dungeons_voidrockCrystal");
        GameRegistry.registerItem(Dungeons.voidrockChunk = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("voidrockChunk").setTextureName("gibby_dungeons" + ":" + "voidrockchunk"), "dungeons_voidrockChunk");
        GameRegistry.registerItem(Dungeons.magicalOrb = new ItemMagicalOrb().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("magicalOrb").setTextureName("gibby_dungeons" + ":" + "magicalorb"), "dungeons_magicalOrb");
        Dungeons.copperhelmet = new ItemCopperArmor(this.ACOPPER, 0, 0).setUnlocalizedName("copperhelmet").setTextureName("gibby_dungeons" + ":" + "copperhelmet");
        Dungeons.copperchestplate = new ItemCopperArmor(this.ACOPPER, 1, 1).setUnlocalizedName("copperchestplate").setTextureName("gibby_dungeons" + ":" + "copperchestplate");
        Dungeons.copperleggings = new ItemCopperArmor(this.ACOPPER, 2, 2).setUnlocalizedName("copperleggings").setTextureName("gibby_dungeons" + ":" + "copperleggings");
        Dungeons.copperboots = new ItemCopperArmor(this.ACOPPER, 3, 3).setUnlocalizedName("copperboots").setTextureName("gibby_dungeons" + ":" + "copperboots");
        GameRegistry.registerItem(Dungeons.copperhelmet, "dungeons_copperhelmet");
        GameRegistry.registerItem(Dungeons.copperchestplate, "dungeons_copperchestplate");
        GameRegistry.registerItem(Dungeons.copperleggings, "dungeons_copperleggings");
        GameRegistry.registerItem(Dungeons.copperboots, "dungeons_copperboots");
        Dungeons.coppersword = new ItemCopperSword(this.COPPER).setUnlocalizedName("coppersword").setTextureName("gibby_dungeons" + ":" + "coppersword");
        Dungeons.copperaxe = new ItemCopperAxe(this.COPPER).setUnlocalizedName("copperaxe").setTextureName("gibby_dungeons" + ":" + "copperaxe");
        Dungeons.copperpickaxe = new ItemCopperPickaxe(this.COPPER).setUnlocalizedName("copperpickaxe").setTextureName("gibby_dungeons" + ":" + "copperpickaxe");
        Dungeons.coppershovel = new ItemCopperSpade(this.COPPER).setUnlocalizedName("coppershovel").setTextureName("gibby_dungeons" + ":" + "coppershovel");
        Dungeons.copperhoe = new ItemHoe(this.COPPER).setUnlocalizedName("copperhoe").setTextureName("gibby_dungeons" + ":" + "copperhoe");
        GameRegistry.registerItem(Dungeons.coppersword, "dungeons_coppersword");
        GameRegistry.registerItem(Dungeons.copperaxe, "dungeons_copperaxe");
        GameRegistry.registerItem(Dungeons.copperpickaxe, "dungeons_copperpickaxe");
        GameRegistry.registerItem(Dungeons.coppershovel, "dungeons_coppershovel");
        GameRegistry.registerItem(Dungeons.copperhoe, "dungeons_copperhoe");
        Dungeons.amazoniteHelmet = new ItemAmazoniteArmor(this.AAMAZONITE, 0, 0, 1, 0).setUnlocalizedName("amazonitehelmet").setTextureName("gibby_dungeons" + ":" + "amazonitehelmet");
        Dungeons.amazoniteChestplate = new ItemAmazoniteArmor(this.AAMAZONITE, 1, 1, 2, 0).setUnlocalizedName("amazonitechestplate").setTextureName("gibby_dungeons" + ":" + "amazonitechestplate");
        Dungeons.amazoniteLeggings = new ItemAmazoniteArmor(this.AAMAZONITE, 2, 2, 2, 0).setUnlocalizedName("amazoniteleggings").setTextureName("gibby_dungeons" + ":" + "amazoniteleggings");
        Dungeons.amazoniteBoots = new ItemAmazoniteArmor(this.AAMAZONITE, 3, 3, 0, 0).setUnlocalizedName("amazoniteboots").setTextureName("gibby_dungeons" + ":" + "amazoniteboots");
        GameRegistry.registerItem(Dungeons.amazoniteHelmet, "dungeons_amazonitehelmet");
        GameRegistry.registerItem(Dungeons.amazoniteChestplate, "dungeons_amazonitechestplate");
        GameRegistry.registerItem(Dungeons.amazoniteLeggings, "dungeons_amazoniteleggings");
        GameRegistry.registerItem(Dungeons.amazoniteBoots, "dungeons_amazoniteboots");
        Dungeons.rubyHelmet = new ItemRubyArmor(this.ARUBY, 0, 0, 1, 0).setUnlocalizedName("rubyhelmet").setTextureName("gibby_dungeons" + ":" + "rubyhelmet");
        Dungeons.rubyChestplate = new ItemRubyArmor(this.ARUBY, 1, 1, 3, 0).setUnlocalizedName("rubychestplate").setTextureName("gibby_dungeons" + ":" + "rubychestplate");
        Dungeons.rubyLeggings = new ItemRubyArmor(this.ARUBY, 2, 2, 2, 0).setUnlocalizedName("rubyleggings").setTextureName("gibby_dungeons" + ":" + "rubyleggings");
        Dungeons.rubyBoots = new ItemRubyArmor(this.ARUBY, 3, 3, 1, 0).setUnlocalizedName("rubyboots").setTextureName("gibby_dungeons" + ":" + "rubyboots");
        GameRegistry.registerItem(Dungeons.rubyHelmet, "dungeons_rubyhelmet");
        GameRegistry.registerItem(Dungeons.rubyChestplate, "dungeons_rubychestplate");
        GameRegistry.registerItem(Dungeons.rubyLeggings, "dungeons_rubyleggings");
        GameRegistry.registerItem(Dungeons.rubyBoots, "dungeons_rubyboots");
        Dungeons.rubySword = new ItemStandardMagicSword(this.RUBY, 2).setUnlocalizedName("rubysword").setTextureName("gibby_dungeons" + ":" + "rubysword");
        Dungeons.rubyAxe = new ItemCopperAxe(this.RUBY).setUnlocalizedName("rubyaxe").setTextureName("gibby_dungeons" + ":" + "rubyaxe");
        Dungeons.rubyPickaxe = new ItemCopperPickaxe(this.RUBY).setUnlocalizedName("rubypickaxe").setTextureName("gibby_dungeons" + ":" + "rubypickaxe");
        Dungeons.rubyShovel = new ItemCopperSpade(this.RUBY).setUnlocalizedName("rubyshovel").setTextureName("gibby_dungeons" + ":" + "rubyshovel");
        GameRegistry.registerItem(Dungeons.rubySword, "dungeons_rubysword");
        GameRegistry.registerItem(Dungeons.rubyAxe, "dungeons_rubyaxe");
        GameRegistry.registerItem(Dungeons.rubyPickaxe, "dungeons_rubypickaxe");
        GameRegistry.registerItem(Dungeons.rubyShovel, "dungeon_srubyshovel");
        Dungeons.silverHelmet = new ItemSilverArmor(this.ASILVER, 0, 0, 2, 0).setUnlocalizedName("silverhelmet").setTextureName("gibby_dungeons" + ":" + "silverhelmet");
        Dungeons.silverChestplate = new ItemSilverArmor(this.ASILVER, 1, 1, 4, 2).setUnlocalizedName("silverchestplate").setTextureName("gibby_dungeons" + ":" + "silverchestplate");
        Dungeons.silverLeggings = new ItemSilverArmor(this.ASILVER, 2, 2, 4, 1).setUnlocalizedName("silverleggings").setTextureName("gibby_dungeons" + ":" + "silverleggings");
        Dungeons.silverBoots = new ItemSilverArmor(this.ASILVER, 3, 3, 2, 0).setUnlocalizedName("silverboots").setTextureName("gibby_dungeons" + ":" + "silverboots");
        GameRegistry.registerItem(Dungeons.silverHelmet, "dungeons_silverhelmet");
        GameRegistry.registerItem(Dungeons.silverChestplate, "dungeons_silverchestplate");
        GameRegistry.registerItem(Dungeons.silverLeggings, "dungeons_silverleggings");
        GameRegistry.registerItem(Dungeons.silverBoots, "dungeons_silverboots");
        Dungeons.bedrockHelmet = new ItemBedrockArmor(this.ABEDROCK, 0, 0, 2, 1).setUnlocalizedName("bedrockhelmet").setTextureName("gibby_dungeons" + ":" + "bedrockhelmet");
        Dungeons.bedrockChestplate = new ItemBedrockArmor(this.ABEDROCK, 1, 1, 3, 3).setUnlocalizedName("bedrockchestplate").setTextureName("gibby_dungeons" + ":" + "bedrockchestplate");
        Dungeons.bedrockLeggings = new ItemBedrockArmor(this.ABEDROCK, 2, 2, 3, 2).setUnlocalizedName("bedrockleggings").setTextureName("gibby_dungeons" + ":" + "bedrockleggings");
        Dungeons.bedrockBoots = new ItemBedrockArmor(this.ABEDROCK, 3, 3, 1, 1).setUnlocalizedName("bedrockboots").setTextureName("gibby_dungeons" + ":" + "bedrockboots");
        GameRegistry.registerItem(Dungeons.bedrockHelmet, "dungeons_bedrockhelmet");
        GameRegistry.registerItem(Dungeons.bedrockChestplate, "dungeons_bedrockchestplate");
        GameRegistry.registerItem(Dungeons.bedrockLeggings, "dungeons_bedrockleggings");
        GameRegistry.registerItem(Dungeons.bedrockBoots, "dungeons_bedrockboots");
        Dungeons.lithiumHelmet = new ItemLithiumArmor(this.ALITHIUM, 0, 0, 2, 1).setUnlocalizedName("lithiumhelmet").setTextureName("gibby_dungeons" + ":" + "lithiumhelmet");
        Dungeons.lithiumChestplate = new ItemLithiumArmor(this.ALITHIUM, 1, 1, 4, 3).setUnlocalizedName("lithiumchestplate").setTextureName("gibby_dungeons" + ":" + "lithiumchestplate");
        Dungeons.lithiumLeggings = new ItemLithiumArmor(this.ALITHIUM, 2, 2, 3, 2).setUnlocalizedName("lithiumleggings").setTextureName("gibby_dungeons" + ":" + "lithiumleggings");
        Dungeons.lithiumBoots = new ItemLithiumArmor(this.ALITHIUM, 3, 3, 1, 1).setUnlocalizedName("lithiumboots").setTextureName("gibby_dungeons" + ":" + "lithiumboots");
        GameRegistry.registerItem(Dungeons.lithiumHelmet, "dungeons_lithiumhelmet");
        GameRegistry.registerItem(Dungeons.lithiumChestplate, "dungeons_lithiumchestplate");
        GameRegistry.registerItem(Dungeons.lithiumLeggings, "dungeons_lithiumleggings");
        GameRegistry.registerItem(Dungeons.lithiumBoots, "dungeons_lithiumboots");
        Dungeons.lithiumAxe = new ItemCopperAxe(this.LITHIUM).setUnlocalizedName("lithiumAxe").setTextureName("gibby_dungeons" + ":" + "lithiumaxe");
        Dungeons.lithiumPickaxe = new ItemCopperPickaxe(this.LITHIUM).setUnlocalizedName("lithiumPickaxe").setTextureName("gibby_dungeons" + ":" + "lithiumpick");
        Dungeons.lithiumShovel = new ItemCopperSpade(this.LITHIUM).setUnlocalizedName("lithiumShovel").setTextureName("gibby_dungeons" + ":" + "lithiumshovel");
        GameRegistry.registerItem(Dungeons.lithiumAxe, "dungeons_lithiumaxe");
        GameRegistry.registerItem(Dungeons.lithiumPickaxe, "dungeons_lithiumpickaxe");
        GameRegistry.registerItem(Dungeons.lithiumShovel, "dungeon_lithiumshovel");
        Dungeons.amethystAxe = new ItemCopperAxe(this.AMETHYST).setUnlocalizedName("amethystAxe").setTextureName("gibby_dungeons" + ":" + "amethystaxe");
        Dungeons.amethystPickaxe = new ItemCopperPickaxe(this.AMETHYST).setUnlocalizedName("amethystPickaxe").setTextureName("gibby_dungeons" + ":" + "amethystpick");
        Dungeons.amethystShovel = new ItemCopperSpade(this.AMETHYST).setUnlocalizedName("amethystShovel").setTextureName("gibby_dungeons" + ":" + "amethystshovel");
        GameRegistry.registerItem(Dungeons.amethystAxe, "dungeons_amethystAxe");
        GameRegistry.registerItem(Dungeons.amethystPickaxe, "dungeons_amethystPickaxe");
        GameRegistry.registerItem(Dungeons.amethystShovel, "dungeon_amethystShovel");
        Dungeons.netherSteelAxe = new ItemCopperAxe(this.NETHERSTEEL).setUnlocalizedName("netherSteelAxe").setTextureName("gibby_dungeons" + ":" + "nethersteelaxe");
        Dungeons.netherSteelPickaxe = new ItemCopperPickaxe(this.NETHERSTEEL).setUnlocalizedName("netherSteelPickaxe").setTextureName("gibby_dungeons" + ":" + "nethersteelpick");
        Dungeons.netherSteelShovel = new ItemCopperSpade(this.NETHERSTEEL).setUnlocalizedName("netherSteelShovel").setTextureName("gibby_dungeons" + ":" + "nethersteelshovel");
        GameRegistry.registerItem(Dungeons.netherSteelAxe, "dungeons_netherSteelAxe");
        GameRegistry.registerItem(Dungeons.netherSteelPickaxe, "dungeons_netherSteelPickaxe");
        GameRegistry.registerItem(Dungeons.netherSteelShovel, "dungeon_netherSteelShovel");
        Dungeons.amethystHelmet = new ItemAmethystArmor(this.AAMETHYST, 0, 0, 3, 2).setUnlocalizedName("amethystHelmet").setTextureName("gibby_dungeons" + ":" + "amethysthelmet");
        Dungeons.amethystChestplate = new ItemAmethystArmor(this.AAMETHYST, 1, 1, 5, 4).setUnlocalizedName("amethystChestplate").setTextureName("gibby_dungeons" + ":" + "amethystchest");
        Dungeons.amethystLeggings = new ItemAmethystArmor(this.AAMETHYST, 2, 2, 4, 3).setUnlocalizedName("amethystLeggings").setTextureName("gibby_dungeons" + ":" + "amethystlegs");
        Dungeons.amethystBoots = new ItemAmethystArmor(this.AAMETHYST, 3, 3, 2, 1).setUnlocalizedName("amethystBoots").setTextureName("gibby_dungeons" + ":" + "amethystboots");
        GameRegistry.registerItem(Dungeons.amethystHelmet, "dungeons_amethystHelmet");
        GameRegistry.registerItem(Dungeons.amethystChestplate, "dungeons_amethystChestplate");
        GameRegistry.registerItem(Dungeons.amethystLeggings, "dungeons_amethystLeggings");
        GameRegistry.registerItem(Dungeons.amethystBoots, "dungeons_amethystBoots");
        Dungeons.netherSkullHelmet = new ItemNetherSkullArmor(this.ANETHER, 0, 0, 2, 1).setUnlocalizedName("netherSkullHelmet").setTextureName("gibby_dungeons" + ":" + "netherskullhelmet");
        Dungeons.netherSkullChestplate = new ItemNetherSkullArmor(this.ANETHER, 1, 1, 4, 2).setUnlocalizedName("netherSkullChestplate").setTextureName("gibby_dungeons" + ":" + "netherskullchestplate");
        Dungeons.netherSkullLeggings = new ItemNetherSkullArmor(this.ANETHER, 2, 2, 3, 2).setUnlocalizedName("netherSkullLeggings").setTextureName("gibby_dungeons" + ":" + "netherskulllegs");
        Dungeons.netherSkullBoots = new ItemNetherSkullArmor(this.ANETHER, 3, 3, 2, 1).setUnlocalizedName("netherSkullBoots").setTextureName("gibby_dungeons" + ":" + "netherskullboots");
        GameRegistry.registerItem(Dungeons.netherSkullHelmet, "dungeons_netherSkullHelmet");
        GameRegistry.registerItem(Dungeons.netherSkullChestplate, "dungeons_netherSkullChestplate");
        GameRegistry.registerItem(Dungeons.netherSkullLeggings, "dungeons_netherSkullLeggings");
        GameRegistry.registerItem(Dungeons.netherSkullBoots, "dungeons_netherSkullBoots");
        Dungeons.netherSteelHelmet = new ItemNetherSteelArmor(this.ANETHERSTEEL, 0, 0, 3, 3).setUnlocalizedName("netherSteelHelmet").setTextureName("gibby_dungeons" + ":" + "nethersteelhelmet");
        Dungeons.netherSteelChestplate = new ItemNetherSteelArmor(this.ANETHERSTEEL, 1, 1, 5, 4).setUnlocalizedName("netherSteelChestplate").setTextureName("gibby_dungeons" + ":" + "nethersteelchestplate");
        Dungeons.netherSteelLeggings = new ItemNetherSteelArmor(this.ANETHERSTEEL, 2, 2, 5, 4).setUnlocalizedName("netherSteelLeggings").setTextureName("gibby_dungeons" + ":" + "nethersteellegs");
        Dungeons.netherSteelBoots = new ItemNetherSteelArmor(this.ANETHERSTEEL, 3, 3, 3, 2).setUnlocalizedName("netherSteelBoots").setTextureName("gibby_dungeons" + ":" + "nethersteelboots");
        GameRegistry.registerItem(Dungeons.netherSteelHelmet, "dungeons_netherSteelHelmet");
        GameRegistry.registerItem(Dungeons.netherSteelChestplate, "dungeons_netherSteelChestplate");
        GameRegistry.registerItem(Dungeons.netherSteelLeggings, "dungeons_netherSteelLeggings");
        GameRegistry.registerItem(Dungeons.netherSteelBoots, "dungeons_netherSteelBoots");
        Dungeons.crystalliumHelmet = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 0, 0, 3, 3).setUnlocalizedName("crystalliumHelmet").setTextureName("gibby_dungeons" + ":" + "crystalliumhelmet");
        Dungeons.crystalliumChestplate = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 1, 1, 6, 5).setUnlocalizedName("crystalliumChestplate").setTextureName("gibby_dungeons" + ":" + "crystalliumchestplate");
        Dungeons.crystalliumLeggings = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 2, 2, 6, 5).setUnlocalizedName("crystalliumLeggings").setTextureName("gibby_dungeons" + ":" + "crystalliumleggings");
        Dungeons.crystalliumBoots = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 3, 3, 3, 2).setUnlocalizedName("crystalliumBoots").setTextureName("gibby_dungeons" + ":" + "crystalliumboots");
        GameRegistry.registerItem(Dungeons.crystalliumHelmet, "dungeons_crystalliumHelmet");
        GameRegistry.registerItem(Dungeons.crystalliumChestplate, "dungeons_crystalliumChestplate");
        GameRegistry.registerItem(Dungeons.crystalliumLeggings, "dungeons_crystalliumLeggings");
        GameRegistry.registerItem(Dungeons.crystalliumBoots, "dungeons_crystalliumBoots");
        Dungeons.blackIronHelmet = new ItemBlackIronArmor(this.ABLACKIRON, 0, 0, 3, 3).setUnlocalizedName("blackIronHelmet").setTextureName("gibby_dungeons" + ":" + "blackironhelmet");
        Dungeons.blackIronChestplate = new ItemBlackIronArmor(this.ABLACKIRON, 1, 1, 5, 4).setUnlocalizedName("blackIronChestplate").setTextureName("gibby_dungeons" + ":" + "blackironchestplate");
        Dungeons.blackIronLeggings = new ItemBlackIronArmor(this.ABLACKIRON, 2, 2, 5, 4).setUnlocalizedName("blackIronLeggings").setTextureName("gibby_dungeons" + ":" + "blackironleggings");
        Dungeons.blackIronBoots = new ItemBlackIronArmor(this.ABLACKIRON, 3, 3, 3, 2).setUnlocalizedName("blackIronBoots").setTextureName("gibby_dungeons" + ":" + "blackironboots");
        GameRegistry.registerItem(Dungeons.blackIronHelmet, "dungeons_blackIronHelmet");
        GameRegistry.registerItem(Dungeons.blackIronChestplate, "dungeons_blackIronChestplate");
        GameRegistry.registerItem(Dungeons.blackIronLeggings, "dungeons_blackIronLeggings");
        GameRegistry.registerItem(Dungeons.blackIronBoots, "dungeons_blackIronBoots");
        Dungeons.blindLightHelmet = new ItemBlindLightArmor(this.ANETHERSTEEL, 0, 0, 3, 3).setUnlocalizedName("blindLightHelmet").setTextureName("gibby_dungeons" + ":" + "blindlighthelmet");
        Dungeons.blindLightChestplate = new ItemBlindLightArmor(this.ANETHERSTEEL, 1, 1, 6, 5).setUnlocalizedName("blindLightChestplate").setTextureName("gibby_dungeons" + ":" + "blindlightchestplate");
        Dungeons.blindLightLeggings = new ItemBlindLightArmor(this.ANETHERSTEEL, 2, 2, 6, 5).setUnlocalizedName("blindLightLeggings").setTextureName("gibby_dungeons" + ":" + "blindlightleggings");
        Dungeons.blindLightBoots = new ItemBlindLightArmor(this.ANETHERSTEEL, 3, 3, 3, 3).setUnlocalizedName("blindLightBoots").setTextureName("gibby_dungeons" + ":" + "blindlightboots");
        GameRegistry.registerItem(Dungeons.blindLightHelmet, "dungeons_blindLightHelmet");
        GameRegistry.registerItem(Dungeons.blindLightChestplate, "dungeons_blindLightChestplate");
        GameRegistry.registerItem(Dungeons.blindLightLeggings, "dungeons_blindLightLeggings");
        GameRegistry.registerItem(Dungeons.blindLightBoots, "dungeons_blindLightBoots");
        GameRegistry.registerItem(Dungeons.heavyIronSword = new ItemCopperSword(this.HEAVYIRON).setUnlocalizedName("ironsword").setTextureName("gibby_dungeons" + ":" + "ironheavysword"), "dungeons_ironsword");
        GameRegistry.registerItem(Dungeons.heavyDiamondSword = new ItemHeavyDiamondSword(this.HEAVYDIAMOND).setUnlocalizedName("diamondsword").setTextureName("gibby_dungeons" + ":" + "heavydiamondsword").setFull3D(), "dungeons_diamond");
        GameRegistry.registerItem(Dungeons.graniteSword = new ItemCopperSword(Item.ToolMaterial.EMERALD).setUnlocalizedName("granitesword").setTextureName("gibby_dungeons" + ":" + "granitesword"), "dungeons_granitesword");
        GameRegistry.registerItem(Dungeons.amazoniteSword = new ItemStandardMagicSword(Item.ToolMaterial.STONE, 1).setUnlocalizedName("amazoniteSword").setTextureName("gibby_dungeons" + ":" + "amazonitesword"), "dungeons_amazoniteSword");
        GameRegistry.registerItem(Dungeons.castIronStar = new ItemIronStar().setUnlocalizedName("castironstar").setTextureName("gibby_dungeons" + ":" + "castironstar"), "dungeons_castironstar");
        GameRegistry.registerItem(Dungeons.castIronSword = new ItemCastIronSword(this.CASTIRON).setUnlocalizedName("castironsword").setTextureName("gibby_dungeons" + ":" + "castironsword"), "dungeons_castironsword");
        GameRegistry.registerItem(Dungeons.silverSword = new ItemSilverSword(Item.ToolMaterial.STONE, 3).setUnlocalizedName("silversword").setTextureName("gibby_dungeons" + ":" + "silversword"), "dungeons_silverSword");
        GameRegistry.registerItem(Dungeons.silverHeavySword = new ItemSilverSword(this.HEAVYSILVER, 5).setUnlocalizedName("silverheavysword").setTextureName("gibby_dungeons" + ":" + "heavysilversword"), "dungeons_silverHeavySword");
        GameRegistry.registerItem(Dungeons.rubyHeavySword = new ItemStandardMagicSword(this.HEAVYRUBY, 3).setUnlocalizedName("rubyheavysword").setTextureName("gibby_dungeons" + ":" + "heavyrubysword"), "dungeons_rubyHeavySword");
        GameRegistry.registerItem(Dungeons.copperHeavySword = new ItemCopperSword(this.CASTIRON).setUnlocalizedName("copperheavysword").setTextureName("gibby_dungeons" + ":" + "copperheavysword"), "dungeons_copperHeavySword");
        GameRegistry.registerItem(Dungeons.bedrockSword = new ItemBedrockSword(this.BEDROCK, 3).setUnlocalizedName("bedrocksword").setTextureName("gibby_dungeons" + ":" + "bedrocksword"), "dungeons_bedrockSword");
        GameRegistry.registerItem(Dungeons.heavyBedrockSword = new ItemBedrockSword(this.HEAVYBEDROCK, 5).setUnlocalizedName("heavybedrocksword").setTextureName("gibby_dungeons" + ":" + "bedrockslasher"), "dungeons_heavyBedrockSword");
        GameRegistry.registerItem(Dungeons.trollAxe = new ItemSword(this.AXE).setUnlocalizedName("trollaxe").setCreativeTab(Dungeons.Weapons).setTextureName("gibby_dungeons" + ":" + "trollaxe"), "dungeons_trollaxe");
        GameRegistry.registerItem(Dungeons.whittler = new ItemSword(this.WHITTLER).setUnlocalizedName("whittler").setCreativeTab(Dungeons.Weapons).setTextureName("gibby_dungeons" + ":" + "whittler"), "dungeons_whittler");
        GameRegistry.registerItem(Dungeons.lithiumSword = new ItemStandardMagicSword(this.LITHIUM, 5).setUnlocalizedName("lithiumsword").setTextureName("gibby_dungeons" + ":" + "lithiumsword"), "dungeons_lithiumSword");
        GameRegistry.registerItem(Dungeons.lithiumHeavySword = new ItemStandardMagicSword(this.HEAVYLITHIUM, 6).setUnlocalizedName("lithiumheavysword").setTextureName("gibby_dungeons" + ":" + "heavylithiumsword"), "dungeons_lithiumHeavySword");
        GameRegistry.registerItem(Dungeons.amethystSword = new ItemStandardMagicSword(this.AMETHYST, 5).setUnlocalizedName("amethystSword").setTextureName("gibby_dungeons" + ":" + "amethystsword"), "dungeons_amethystSword");
        GameRegistry.registerItem(Dungeons.heavyAmethystSword = new ItemHeavyAmethystSword(this.HEAVYAMETHYST, 6).setUnlocalizedName("amethystHeavySword").setTextureName("gibby_dungeons" + ":" + "heavyamethystsword"), "dungeons_amethystHeavysword");
        GameRegistry.registerItem(Dungeons.netherSkullSword = new ItemNetherSkullSword(this.AMETHYST, 3).setUnlocalizedName("netherSkullSword").setTextureName("gibby_dungeons" + ":" + "witheringsword"), "dungeons_netherSkullSword");
        GameRegistry.registerItem(Dungeons.netherSteelSword = new ItemNetherSteelSword(this.NETHERSTEEL, 5).setUnlocalizedName("netherSteelSword").setTextureName("gibby_dungeons" + ":" + "nethersteelsword"), "dungeons_netherSteelSword");
        GameRegistry.registerItem(Dungeons.heavyNetherSteelSword = new ItemNetherSteelSword(this.HEAVYNETHERSTEEL, 6).setUnlocalizedName("heavyNetherSteelSword").setTextureName("gibby_dungeons" + ":" + "heavynethersteelsword"), "dungeons_heavyNetherSteelSword");
        GameRegistry.registerItem(Dungeons.lythe = new ItemLytheSword(this.AMETHYST, 8).setUnlocalizedName("lythe").setTextureName("gibby_dungeons" + ":" + "lythe"), "dungeons_lythe");
        GameRegistry.registerItem(Dungeons.voidSword = new ItemVoidSword(this.AMETHYST, 8).setUnlocalizedName("voidSword").setTextureName("gibby_dungeons" + ":" + "voidsword"), "dungeons_voidSword");
        GameRegistry.registerItem(Dungeons.elementalSword = new ItemTripleSword(this.ELEMENTALSWORD, 4, 4).setUnlocalizedName("elementalSword").setTextureName("gibby_dungeons" + ":" + "elementalsword"), "dungeons_elementalSword");
        GameRegistry.registerItem(Dungeons.corruptedSword = new ItemNetherSteelSword(this.NETHERSTEEL, 7).setUnlocalizedName("corruptedSword").setTextureName("gibby_dungeons" + ":" + "corruptedsteelsword"), "dungeons_corruptedSword");
        GameRegistry.registerItem(Dungeons.swordOfCorruption = new ItemSwordOfCorruption(this.ELEMENTALSWORD, 4, 6).setUnlocalizedName("swordOfCorruption").setTextureName("gibby_dungeons" + ":" + "bladeofcorruption"), "dungeons_swordOfCorruption");
        GameRegistry.registerItem(Dungeons.flameSword = new ItemFireSword(this.FIRE).setUnlocalizedName("flameSword").setTextureName("gibby_dungeons" + ":" + "flamesword"), "dungeons_flameSword");
        GameRegistry.registerItem(Dungeons.netherGhastSword = new ItemBlueFireSword(this.FIRE, 2).setUnlocalizedName("netherGhastSword").setTextureName("gibby_dungeons" + ":" + "netherghastsword"), "dungeons_netherGhastSword");
        GameRegistry.registerItem(Dungeons.botSword = new ItemBotSword().setUnlocalizedName("botSword").setTextureName("gibby_dungeons" + ":" + "botsword"), "dungeons_botSword");
        GameRegistry.registerItem(Dungeons.fireClub = new ItemFireClub().setUnlocalizedName("fireClub").setTextureName("gibby_dungeons" + ":" + "fireclub"), "dungeons_fireClub");
        GameRegistry.registerItem(Dungeons.harpBow = new ItemHarpBow().setUnlocalizedName("harpBow").setTextureName("gibby_dungeons" + ":" + "harpbow"), "dungeons_harpBow");
        GameRegistry.registerItem(Dungeons.amethystLance = new ItemAmethystLance(this.AMETHYSTLANCE, 4).setUnlocalizedName("amethystLance").setTextureName("gibby_dungeons" + ":" + "amethystlance"), "dungeons_amethystLance");
        GameRegistry.registerItem(Dungeons.amethystRapier = new ItemStandardMagicSword(this.AMETHYSTRAPIER, 3).setUnlocalizedName("amethystRapier").setTextureName("gibby_dungeons" + ":" + "amethystrapier"), "dungeons_amethystRapier");
        GameRegistry.registerItem(Dungeons.mace = new ItemSword(this.AXE).setUnlocalizedName("mace").setCreativeTab(Dungeons.Weapons).setTextureName("gibby_dungeons" + ":" + "mace"), "dungeons_mace");
        GameRegistry.registerItem(Dungeons.lavaKnightSword = new ItemStandardVoidSword(this.BEDROCK, 4).setUnlocalizedName("lavaKnightSword").setTextureName("gibby_dungeons" + ":" + "lavaknightsword"), "dungeons_lavaKnightSword");
        GameRegistry.registerItem(Dungeons.steelSword = new ItemSword(this.AMETHYSTRAPIER).setCreativeTab(Dungeons.Weapons).setUnlocalizedName("steelSword").setTextureName("gibby_dungeons" + ":" + "steelsword"), "dungeons_steelSword");
        GameRegistry.registerItem(Dungeons.tornadoSword = new ItemTornadoSword(Item.ToolMaterial.EMERALD).setCreativeTab(Dungeons.Weapons).setUnlocalizedName("tornadoSword").setTextureName("gibby_dungeons" + ":" + "tornadosword"), "dungeons_tornadoSword");
        GameRegistry.registerItem(Dungeons.vampiricSword = new ItemVampiricSword(this.AXE, 3).setUnlocalizedName("vampiricSword").setTextureName("gibby_dungeons" + ":" + "vampiricblade"), "dungeons_vampiricSword");
        GameRegistry.registerItem(Dungeons.voidFiendSword = new ItemStandardVoidSword(this.AXE, 2).setUnlocalizedName("voidFiendSword").setTextureName("gibby_dungeons" + ":" + "voidFiendSword"), "dungeons_voidFiendSword");
        GameRegistry.registerItem(Dungeons.crystalSword = new ItemTripleSword(this.CRYSTAL, 4, 1).setUnlocalizedName("crystalSword").setTextureName("gibby_dungeons" + ":" + "crystalsword"), "dungeons_crystalSword");
        GameRegistry.registerItem(Dungeons.crystalHeavySword = new ItemTripleSword(this.HEAVYCRYSTAL, 6, 3).setUnlocalizedName("crystalHeavySword").setTextureName("gibby_dungeons" + ":" + "crystalheavysword"), "dungeons_crystalHeavySword");
        GameRegistry.registerItem(Dungeons.bubbleSword = new ItemBubbleSword(this.HEAVYSILVER, 3).setUnlocalizedName("bubbleSword").setTextureName("gibby_dungeons" + ":" + "bubblesword"), "dungeons_bubbleSword");
        GameRegistry.registerItem(Dungeons.valesis = new ItemValesis(this.HEAVYCRYSTAL, 7, 4).setUnlocalizedName("valesis").setTextureName("gibby_dungeons" + ":" + "valesis"), "dungeons_valesis");
        GameRegistry.registerItem(Dungeons.corruptedBow = new ItemCorruptedBow().setUnlocalizedName("corruptedBow").setTextureName("gibby_dungeons" + ":" + "corruptedbow"), "dungeons_corruptedBow");
        GameRegistry.registerItem(Dungeons.disinigrationBow = new ItemDisinigrationBow().setUnlocalizedName("disinigrationBow").setTextureName("gibby_dungeons" + ":" + "disinigrationbow"), "dungeons_disinigrationBow");
        GameRegistry.registerItem(Dungeons.torturedChainSword = new ItemStandardVoidSword(this.TCHAIN, 4).setUnlocalizedName("torturedChainSword").setTextureName("gibby_dungeons" + ":" + "torturedchainsword"), "dungeons_torturedChainSword");
        GameRegistry.registerItem(Dungeons.dungeonEyeSword = new ItemStandardMagicSword(this.TCHAIN, 6).setUnlocalizedName("dungeonEyeSword").setTextureName("gibby_dungeons" + ":" + "dungeoneyesword"), "dungeons_dungeonEyeSword");
        GameRegistry.registerItem(Dungeons.frostySword = new ItemFrostySword(this.TCHAIN, 5).setUnlocalizedName("frostySword").setTextureName("gibby_dungeons" + ":" + "frostysword"), "dungeons_frostySword");
        GameRegistry.registerItem(Dungeons.blackIronSword = new ItemStandardVoidSword(this.TCHAIN, 4).setUnlocalizedName("blackIronSword").setTextureName("gibby_dungeons" + ":" + "blackironsword"), "dungeons_blackIronSword");
        GameRegistry.registerItem(Dungeons.sunAxe = new ItemSunAxe(this.HEAVYCRYSTAL, 4, 5).setUnlocalizedName("sunAxe").setTextureName("gibby_dungeons" + ":" + "sunaxe"), "dungeons_sunAxe");
        GameRegistry.registerItem(Dungeons.magirockSword = new ItemStandardMagicSword(this.MAGIROCK, 17).setUnlocalizedName("magirockSword").setTextureName("gibby_dungeons" + ":" + "magirocksword"), "dungeons_magirockSword");
        GameRegistry.registerItem(Dungeons.exawdusSmasher = new ItemExawdusSmasher(this.EXAWDUS, 15, 3).setUnlocalizedName("exawdusSmasher").setTextureName("gibby_dungeons" + ":" + "exawdusSmasher"), "dungeons_exawdusSmasher");
        GameRegistry.registerItem(Dungeons.tomeOfMagic = new ItemMagicTome().setUnlocalizedName("tomeOfMagic").setCreativeTab(Dungeons.Key).setTextureName("gibby_dungeons" + ":" + "tomeofmagic"), "dungeons_tomeOfMagic");
        GameRegistry.registerItem(Dungeons.forceWand = new ItemForceWand().setUnlocalizedName("forceWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "forcewand"), "dungeons_forcewand");
        GameRegistry.registerItem(Dungeons.pulseWand = new ItemPulseWand().setUnlocalizedName("pulsewand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "pulsewand"), "dungeons_pulsewand");
        GameRegistry.registerItem(Dungeons.poisonWand = new ItemPoisonWand().setUnlocalizedName("poisonwand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "poisonwand"), "dungeons_poisonwand");
        GameRegistry.registerItem(Dungeons.magicWand = new ItemMagicWand().setUnlocalizedName("magicwand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "magicwand"), "dungeons_magicwand");
        GameRegistry.registerItem(Dungeons.bloodWand = new ItemBloodWand().setUnlocalizedName("bloodwand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "bloodwand"), "dungeons_bloodwand");
        GameRegistry.registerItem(Dungeons.sodbuster = new ItemSodBuster().setUnlocalizedName("sodbuster").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "sodbuster"), "dungeons_sodbuster");
        GameRegistry.registerItem(Dungeons.shimmerWand = new ItemShimmerWand().setUnlocalizedName("shimmerwand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "shimmerwand"), "dungeons_shimmerwand");
        GameRegistry.registerItem(Dungeons.metalWand = new ItemMetalWand().setUnlocalizedName("metalwand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "metalwand"), "dungeons_metalwand");
        GameRegistry.registerItem(Dungeons.growthStaff = new ItemGrowthStaff().setUnlocalizedName("growthStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "growthstaff"), "dungeons_growthStaff");
        GameRegistry.registerItem(Dungeons.inflameStaff = new ItemInflameStaff().setUnlocalizedName("inflameStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "inflamestaff"), "dungeons_inflameStaff");
        GameRegistry.registerItem(Dungeons.gravityStaff = new ItemGravityStaff().setUnlocalizedName("gravityStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "gravitystaff"), "dungeons_gravityStaff");
        GameRegistry.registerItem(Dungeons.windStaff = new ItemWindStaff().setUnlocalizedName("windStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "windstaff"), "dungeons_windStaff");
        GameRegistry.registerItem(Dungeons.speedStaff = new ItemSpeedStaff().setUnlocalizedName("speedStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "speedstaff"), "dungeons_speedStaff");
        GameRegistry.registerItem(Dungeons.magicGem = new ItemMagicGem().setUnlocalizedName("magicgem").setCreativeTab(Dungeons.Materials).setTextureName("gibby_dungeons" + ":" + "magicgem"), "dungeons_magicgem");
        GameRegistry.registerItem(Dungeons.shimmerPearl = new ItemShimmerPearl().setUnlocalizedName("shimmerPearl").setTextureName("gibby_dungeons" + ":" + "shimmerpearl_1"), "dungeons_shimmerPearl");
        GameRegistry.registerItem(Dungeons.voidWand = new ItemVoidWand().setUnlocalizedName("voidWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "voidwand"), "dungeons_voidWand");
        GameRegistry.registerItem(Dungeons.cursedWand = new ItemCursedWand().setUnlocalizedName("cursedWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "cursestaff"), "dungeons_cursedWand");
        GameRegistry.registerItem(Dungeons.chaoticWand = new ItemChaoticWand().setUnlocalizedName("chaoticWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "chaoticwand"), "dungeons_chaoticWand");
        GameRegistry.registerItem(Dungeons.hadrialWand = new ItemHadrialWand().setUnlocalizedName("hadrialWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "hadrialwand"), "dungeons_hadrialWand");
        GameRegistry.registerItem(Dungeons.ionicWand = new ItemIonicWand().setUnlocalizedName("ionicWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "ionicwand"), "dungeons_ionicWand");
        GameRegistry.registerItem(Dungeons.netherDrill = new ItemNetherDrill().setUnlocalizedName("netherDrill").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "netherdrillwand"), "dungeons_netherDrill");
        GameRegistry.registerItem(Dungeons.witherStaff = new ItemWitherStarStaff().setUnlocalizedName("witherStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "netherstarstaff"), "dungeons_witherStaff");
        GameRegistry.registerItem(Dungeons.warlockStaff = new ItemWarlockWand().setUnlocalizedName("warlockStaff").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "warlockstaff"), "dungeons_warlockStaff");
        GameRegistry.registerItem(Dungeons.earthTome = new ItemEarthTome().setUnlocalizedName("earthTome").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "earthtome"), "dungeons_earthTome");
        GameRegistry.registerItem(Dungeons.antigravityTome = new ItemAntiGravityTome().setUnlocalizedName("antigravityTome").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "antigravitytome"), "dungeons_antigravityTome");
        GameRegistry.registerItem(Dungeons.energyTome = new ItemEnergyTome().setUnlocalizedName("energyTome").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "energytome"), "dungeons_energyTome");
        GameRegistry.registerItem(Dungeons.battleTome = new ItemBattleTome().setUnlocalizedName("battleTome").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "battletome"), "dungeons_battleTome");
        GameRegistry.registerItem(Dungeons.crecentWand = new ItemCrecentWand().setUnlocalizedName("crecentWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "crecentwand"), "dungeons_crecentWand");
        GameRegistry.registerItem(Dungeons.quakeWand = new ItemQuakeWand().setUnlocalizedName("quakeWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "quakewand"), "dungeons_quakeWand");
        GameRegistry.registerItem(Dungeons.orcWarWand = new ItemOrcWarWand().setUnlocalizedName("orcWarWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "orcwarwand"), "dungeons_orcWarWand");
        GameRegistry.registerItem(Dungeons.icefireWand = new ItemIcefireWand().setUnlocalizedName("icefireWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "icefirewand"), "dungeons_icefireWand");
        GameRegistry.registerItem(Dungeons.sapientWarWand = new ItemSapientWarWand().setUnlocalizedName("sapientWarWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "sapientwarwand"), "dungeons_sapientWarWand");
        GameRegistry.registerItem(Dungeons.deathBringerWand = new ItemDeathBringerWand().setUnlocalizedName("deathBringerWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "deathbringerwand"), "dungeons_deathBringerWand");
        GameRegistry.registerItem(Dungeons.magirockWand = new ItemMagirockWand().setUnlocalizedName("magirockWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "magirockwand"), "dungeons_magirockWand");
        GameRegistry.registerItem(Dungeons.voidrimWand = new ItemVoidrimWand().setUnlocalizedName("voidrimWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "voidrimwand"), "dungeons_voidrimWand");
        GameRegistry.registerItem(Dungeons.voidrockWand = new ItemVoidrockWand().setUnlocalizedName("voidrockWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "voidrockwand"), "dungeons_voidrockWand");
        GameRegistry.registerItem(Dungeons.fusionWand = new ItemFusionWand().setUnlocalizedName("fusionWand").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "fusionwand"), "dungeons_fusionWand");
        GameRegistry.registerItem(Dungeons.botAmulet = new ItemBotAmulet().setUnlocalizedName("botAmulet").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "botamulet"), "dungeons_botAmulet");
        GameRegistry.registerItem(Dungeons.necroticAmulet = new ItemNecroticAmulet().setUnlocalizedName("necroticAmulet").setCreativeTab(Dungeons.Magic).setTextureName("gibby_dungeons" + ":" + "necroticamulet"), "dungeons_necroticAmulet");
        GameRegistry.registerBlock(Dungeons.dungeonSpawner = new BlockDungeonSpawner(Material.rock).setBlockName("dungeonSpawner").setBlockTextureName("gibby_dungeons" + ":" + "dungeonspawner"), "dungeons_dungeonSpawner");
        GameRegistry.registerBlock(Dungeons.dungeonSpawnerRepeater = new BlockDungeonSpawnerRepeater(Material.rock).setBlockName("dungeonSpawnerRepeater").setBlockTextureName("gibby_dungeons" + ":" + "dungeonspawnerrepeater"), "dungeons_dungeonSpawnerRepeater");
        GameRegistry.registerBlock(Dungeons.copperore = new BlockCopper().setBlockName("copperore").setBlockTextureName("gibby_dungeons" + ":" + "copperore"), "dungeons_copperore");
        GameRegistry.registerBlock(Dungeons.amazoniteOre = new BlockAmazoniteOre().setBlockName("amazoniteOre").setBlockTextureName("gibby_dungeons" + ":" + "amazoniteore"), "dungeons_amazoniteOre");
        GameRegistry.registerBlock(Dungeons.rubyOre = new BlockRubyOre().setBlockName("rubyore").setBlockTextureName("gibby_dungeons" + ":" + "rubyore"), "dungeons_rubyOre");
        GameRegistry.registerBlock(Dungeons.silverOre = new BlockSilverOre().setBlockName("silverore").setBlockTextureName("gibby_dungeons" + ":" + "silverore"), "dungeons_silverOre");
        GameRegistry.registerBlock(Dungeons.rubyBlock = new BlockOre().setBlockName("rubyblock").setBlockTextureName("gibby_dungeons" + ":" + "rubyblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_rubyBlock");
        GameRegistry.registerBlock(Dungeons.copperBlock = new BlockOre().setBlockName("copperblock").setBlockTextureName("gibby_dungeons" + ":" + "copperblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_copperBlock");
        GameRegistry.registerBlock(Dungeons.bedrockOre = new BlockBedrockOre().setBlockName("bedrockore").setBlockTextureName("gibby_dungeons" + ":" + "bedrockore"), "dungeons_bedrockOre");
        GameRegistry.registerBlock(Dungeons.lithiumOre = new BlockLithiumOre().setBlockName("lithiumOre").setBlockTextureName("gibby_dungeons" + ":" + "lithiumore").setCreativeTab(Dungeons.Blocks), "dungeons_lithiumOre");
        GameRegistry.registerBlock(Dungeons.bleachedStone = new BlockOre().setBlockName("bleachedStone").setBlockTextureName("gibby_dungeons" + ":" + "bleachedcobblestone").setCreativeTab(Dungeons.Blocks).setHardness(7.0f).setResistance(10.0f), "dungeons_bleachedStone");
        GameRegistry.registerBlock(Dungeons.redBlock = new BlockOre().setBlockName("redBlock").setBlockTextureName("gibby_dungeons" + ":" + "redbot_lamp_on").setCreativeTab(Dungeons.Blocks).setHardness(4.0f).setResistance(7.0f).setLightLevel(10.0f), "dungeons_redBlock");
        GameRegistry.registerBlock(Dungeons.blueBlock = new BlockOre().setBlockName("blueBlock").setBlockTextureName("gibby_dungeons" + ":" + "bluebot_lamp_on").setHardness(4.0f).setCreativeTab(Dungeons.Blocks).setResistance(7.0f).setLightLevel(10.0f), "dungeons_blueBlock");
        GameRegistry.registerBlock(Dungeons.silverBlock = new BlockOre().setBlockName("silverBlock").setBlockTextureName("gibby_dungeons" + ":" + "silverblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_silverBlock");
        GameRegistry.registerBlock(Dungeons.lithiumBlock = new BlockOre().setBlockName("lithiumBlock").setBlockTextureName("gibby_dungeons" + ":" + "lithiumblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_lithiumBlock");
        GameRegistry.registerBlock(Dungeons.amethystOre = new BlockAmethystOre().setBlockName("amethystOre").setBlockTextureName("gibby_dungeons" + ":" + "amethystore").setCreativeTab(Dungeons.Blocks), "dungeons_amethystOre");
        GameRegistry.registerBlock(Dungeons.amethystBlock = new BlockOre().setBlockName("amethystBlock").setBlockTextureName("gibby_dungeons" + ":" + "amethystblock").setCreativeTab(Dungeons.Blocks), "dungeons_amethystBlock");
        GameRegistry.registerBlock(Dungeons.netherSteelOre = new BlockNetherSteelOre().setBlockName("netherSteelOre").setBlockTextureName("gibby_dungeons" + ":" + "nethersteelore").setCreativeTab(Dungeons.Blocks), "dungeons_netherSteelOre");
        GameRegistry.registerBlock(Dungeons.netherSteelBlock = new BlockOre().setBlockName("netherSteelBlock").setBlockTextureName("gibby_dungeons" + ":" + "nethersteelblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_netherSteelBlock");
        GameRegistry.registerBlock(Dungeons.voidBrick = new BlockOre().setBlockName("voidBrick").setBlockTextureName("gibby_dungeons" + ":" + "voidbrick").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_voidBrick");
        GameRegistry.registerBlock(Dungeons.blackBrick = new BlockOre().setBlockName("blackBrick").setBlockTextureName("gibby_dungeons" + ":" + "blackbrick").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_blackBrick");
        GameRegistry.registerBlock(Dungeons.amethystStone = new BlockAmethystStone().setBlockName("amethystStone").setBlockTextureName("gibby_dungeons" + ":" + "amethyststone").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_amethystStone");
        GameRegistry.registerBlock(Dungeons.amethystCrystalized = new BlockOre().setBlockName("amethystCrystalized").setBlockTextureName("gibby_dungeons" + ":" + "crystalizedamethyststone").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_amethystCrystalized");
        GameRegistry.registerBlock(Dungeons.amethystCracks = new BlockOre().setBlockName("amethystCracks").setBlockTextureName("gibby_dungeons" + ":" + "amethystcracks").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f).setLightLevel(10.0f), "dungeons_amethystCracks");
        GameRegistry.registerBlock(Dungeons.crystalOre = new BlockCrystalOre().setBlockName("crystalOre").setBlockTextureName("gibby_dungeons" + ":" + "crystalore").setCreativeTab(Dungeons.Blocks), "dungeons_crystalOre");
        GameRegistry.registerBlock(Dungeons.portalAmethyst = new BlockAmethystPortal().setBlockName("portalAmethyst").setCreativeTab(Dungeons.Blocks), "dungeons_portalAmethyst");
        GameRegistry.registerBlock(Dungeons.portalSunset = new BlockSunsetPortal().setBlockName("portalSunset").setCreativeTab(Dungeons.Blocks).setBlockTextureName("gibby_dungeons" + ":" + "sunsetportal2"), "dungeons_portalSunset");
        GameRegistry.registerBlock(Dungeons.portalMontane = new BlockMontanePortal().setBlockName("portalMontane").setCreativeTab(Dungeons.Blocks).setBlockTextureName("gibby_dungeons" + ":" + "portalmontane"), "dungeons_portalMontane");
        GameRegistry.registerBlock(Dungeons.portalCrystalPlains = new BlockCrystalPlainsPortal().setBlockName("portalCrystalPlains").setBlockTextureName("gibby_dungeons" + ":" + "portalcrystalliumplains").setCreativeTab(Dungeons.Blocks), "dungeons_portalCrystalPlains");
        GameRegistry.registerBlock(Dungeons.crystalWeed = new BlockCrystalFoliage().setBlockName("crystalWeed").setBlockTextureName("gibby_dungeons" + ":" + "crystalweeds").setCreativeTab(Dungeons.Blocks), "dungeons_crystalWeed");
        GameRegistry.registerBlock(Dungeons.crystalStem = new BlockCrystalFoliage().setBlockName("crystalStem").setBlockTextureName("gibby_dungeons" + ":" + "crystalstems").setCreativeTab(Dungeons.Blocks), "dungeons_crystalStem");
        GameRegistry.registerBlock(Dungeons.ghostRose = new BlockCrystalFoliage().setBlockName("ghostRose").setBlockTextureName("gibby_dungeons" + ":" + "ghostrose").setCreativeTab(Dungeons.Blocks), "dungeons_ghostRose");
        GameRegistry.registerBlock(Dungeons.yellowTippedGrass = new BlockCrystalFoliage().setBlockName("yellowTippedGrass").setBlockTextureName("gibby_dungeons" + ":" + "yellowtippedgrass").setCreativeTab(Dungeons.Blocks), "dungeons_yellowTippedGrass");
        GameRegistry.registerBlock(Dungeons.shimmerFlower = new BlockCrystalFoliage().setBlockName("shimmerFlower").setBlockTextureName("gibby_dungeons" + ":" + "shimmerflower").setCreativeTab(Dungeons.Blocks), "dungeons_shimmerFlower");
        GameRegistry.registerBlock(Dungeons.purpleEye = new BlockCrystalFoliage().setBlockName("purpleEye").setBlockTextureName("gibby_dungeons" + ":" + "purpleeye").setCreativeTab(Dungeons.Blocks), "dungeons_purpleEye");
        GameRegistry.registerBlock(Dungeons.crystalLeaf = new BlockCrystalFoliage().setBlockName("crystalLeaf").setBlockTextureName("gibby_dungeons" + ":" + "crystalleaf").setCreativeTab(Dungeons.Blocks), "dungeons_crystalLeaf");
        GameRegistry.registerBlock(Dungeons.badgererSpawner = new BlockBadgererSpawner().setBlockName("badgererSpawner").setBlockTextureName("gibby_dungeons" + ":" + "badgererspawner").setCreativeTab(Dungeons.Blocks), "dungeons_badgererSpawner");
        GameRegistry.registerBlock(Dungeons.witherSpawner = new BlockWitherSpawner().setBlockName("witherSpawner").setBlockTextureName("gibby_dungeons" + ":" + "witherspawner").setCreativeTab(Dungeons.Key), "dungeons_witherSpawner");
        GameRegistry.registerBlock(Dungeons.purpleBrick = new BlockOre().setBlockName("purpleBrick").setBlockTextureName("gibby_dungeons" + ":" + "purplebrick").setCreativeTab(Dungeons.Blocks).setHardness(15.0f).setResistance(30.0f), "dungeons_purpleBrick");
        GameRegistry.registerBlock(Dungeons.crystalliumBlock = new BlockOre().setBlockName("crystalliumBlock").setBlockTextureName("gibby_dungeons" + ":" + "crystalliumblock").setCreativeTab(Dungeons.Blocks).setHardness(15.0f).setResistance(30.0f), "dungeons_crystalliumBlock");
        GameRegistry.registerBlock(Dungeons.frostSpikes = new BlockFrostSpikes().setBlockName("frostSpikes").setBlockTextureName("gibby_dungeons" + ":" + "frostspikes").setCreativeTab(Dungeons.Blocks).setHardness(5.0f).setResistance(5.0f), "dungeons_frostSpikes");
        GameRegistry.registerBlock(Dungeons.redKeyClosed = new BlockRedKeyClosed().setBlockName("redKeyClosed").setBlockTextureName("gibby_dungeons" + ":" + "redkeyclosed").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_redKeyClosed");
        GameRegistry.registerBlock(Dungeons.blueKeyClosed = new BlueKeyClosed().setBlockName("blueKeyClosed").setBlockTextureName("gibby_dungeons" + ":" + "bluekeyclosed").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blueKeyClosed");
        GameRegistry.registerBlock(Dungeons.blackKeyClosed = new BlackKeyClosed().setBlockName("blackKeyClosed").setBlockTextureName("gibby_dungeons" + ":" + "blackkeyclosed").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blackKeyClosed");
        GameRegistry.registerBlock(Dungeons.blackKeyOpen = new BlockOre().setBlockName("blackKeyOpen").setBlockTextureName("gibby_dungeons" + ":" + "blackkeyopen").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blackKeyOpen");
        GameRegistry.registerBlock(Dungeons.blueKeyOpen = new BlockOre().setBlockName("blueKeyOpen").setBlockTextureName("gibby_dungeons" + ":" + "bluekeyopen").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blueKeyOpen");
        GameRegistry.registerBlock(Dungeons.redKeyOpen = new BlockRedKeyOpen().setBlockName("redKeyOpen").setBlockTextureName("gibby_dungeons" + ":" + "redkeyopen").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_redKeyOpen");
        GameRegistry.registerBlock(Dungeons.stoneDoor = new BlockOre().setBlockName("stoneDoor").setBlockTextureName("gibby_dungeons" + ":" + "stonedoor").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_stoneDoor");
        GameRegistry.registerBlock(Dungeons.doorOpener = new BlockDoorOpener().setBlockName("doorOpener").setBlockTextureName("gibby_dungeons" + ":" + "dooropener").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_doorOpener");
        GameRegistry.registerBlock(Dungeons.undefeatableSpawner = new BlockUndefeatableSpawner().setBlockName("undefeatableSpawner").setBlockTextureName("gibby_dungeons" + ":" + "undefeatablespawner").setCreativeTab(Dungeons.Key), "dungeons_undefeatableSpawner");
        GameRegistry.registerBlock(Dungeons.yellowLock = new BlockYellowLock().setBlockName("yellowLock").setBlockTextureName("gibby_dungeons" + ":" + "yellowlock").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_yellowLock");
        GameRegistry.registerBlock(Dungeons.deathBringerSpawner = new BlockDeathBringerSpawner().setBlockName("deathBringerSpawner").setBlockTextureName("gibby_dungeons" + ":" + "deathbringerspawner").setCreativeTab(Dungeons.Key), "dungeons_deathBringerSpawner");
        GameRegistry.registerBlock(Dungeons.iceSpiritSpawner = new BlockIceSpiritSpawner().setBlockName("iceSpiritSpawner").setBlockTextureName("gibby_dungeons" + ":" + "icespiritspawner").setCreativeTab(Dungeons.Key), "dungeons_iceSpiritSpawner");
        GameRegistry.registerBlock(Dungeons.midnightPortalSpawner = new BlockMidnightPortalSpawner().setBlockName("midnightPortalSpawner").setBlockTextureName("gibby_dungeons" + ":" + "midnightportalspawner").setCreativeTab(Dungeons.Key), "dungeons_midnightPortalSpawner");
        GameRegistry.registerBlock(Dungeons.crystalliumGrass = new BlockCrystalliumGrass().setBlockName("crystalliumGrass").setBlockTextureName("gibby_dungeons" + ":" + "crystalliumgrass").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumGrass");
        GameRegistry.registerBlock(Dungeons.crystalliumDirt = new BlockCrystalliumDirt().setBlockName("crystalliumDirt").setBlockTextureName("gibby_dungeons" + ":" + "crystalliumdirt").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumDirt");
        GameRegistry.registerBlock(Dungeons.caveMushrooms = new BlockCrystalFoliage().setBlockName("caveMushrooms").setBlockTextureName("gibby_dungeons" + ":" + "cavemushrooms").setCreativeTab(Dungeons.Blocks).setLightLevel(0.5f), "dungeons_caveMushrooms");
        GameRegistry.registerBlock(Dungeons.crystalWood = new BlockCrystalliumWood().setBlockName("crystalWood").setBlockTextureName("gibby_dungeons" + ":" + "crystalwood").setCreativeTab(Dungeons.Blocks), "dungeons_crystalWood");
        GameRegistry.registerBlock(Dungeons.crystalliumFern = new BlockCrystalliumFern().setBlockName("crystalliumFern").setBlockTextureName("gibby_dungeons" + ":" + "crystalliumfern").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumFern");
        GameRegistry.registerBlock(Dungeons.crystalliumLeaves = new BlockCrystalliumLeaves().setBlockName("crystalliumLeaves").setBlockTextureName("gibby_dungeons" + ":" + "crystalliumleaves").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumLeaves");
        GameRegistry.registerBlock(Dungeons.magirockOre = new BlockMagiRockOre().setBlockName("magirockOre").setBlockTextureName("gibby_dungeons" + ":" + "magirockore").setCreativeTab(Dungeons.Blocks), "dungeons_magirockOre");
        GameRegistry.registerBlock(Dungeons.carvedCrystalliumBrick = new BlockOre().setBlockName("carvedCrystalliumBrick").setBlockTextureName("gibby_dungeons" + ":" + "carvedcrystalliumbrick").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(10.0f), "dungeons_carvedCrystalliumBrick");
        GameRegistry.registerBlock(Dungeons.crystalliumLamp = new BlockCrystalliumLamp().setBlockName("crystalliumLamp").setBlockTextureName("gibby_dungeons" + ":" + "crystalliumlamp").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumLamp");
        GameRegistry.registerBlock(Dungeons.exawdusSpawner = new BlockExawdusSpawner().setBlockName("exawdusSpawner").setBlockTextureName("gibby_dungeons" + ":" + "exawdusspawner").setCreativeTab(Dungeons.Key), "dungeons_exawdusSpawner");
        GameRegistry.registerBlock(Dungeons.crystalliumStairs = new BlockCrystalliumStairs(Dungeons.purpleBrick, 0).setBlockName("crystalliumStairs").setBlockTextureName("gibby_dungeons" + ":" + "purplebrick").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumStairs");
        GameRegistry.registerBlock(Dungeons.magitable = new BlockMagiTable().setBlockName("magitable").setBlockTextureName("gibby_dungeons" + ":" + "magitable").setCreativeTab(Dungeons.Blocks), "dungeons_magitable");
        GameRegistry.registerBlock(Dungeons.magitableCharged = new BlockChargedMagiTable().setBlockName("magitableCharged").setBlockTextureName("gibby_dungeons" + ":" + "magitableon").setCreativeTab(Dungeons.Blocks), "dungeons_magitableCharged");
        GameRegistry.registerBlock(Dungeons.crystalGrass = new BlockCrystalliumGrass().setBlockName("crystalGrass").setBlockTextureName("gibby_dungeons" + ":" + "crystalgrass").setCreativeTab(Dungeons.Blocks), "dungeons_crystalGrass");
        GameRegistry.registerBlock(Dungeons.crystalDirt = new BlockCrystalliumDirt().setBlockName("crystalDirt").setBlockTextureName("gibby_dungeons" + ":" + "crystaldirt").setCreativeTab(Dungeons.Blocks), "dungeons_crystalDirt");
        GameRegistry.registerBlock(Dungeons.crystalLeaves = new BlockCrystalliumLeaves().setBlockName("crystalLeaves").setBlockTextureName("gibby_dungeons" + ":" + "crystalleaves").setCreativeTab(Dungeons.Blocks), "dungeons_crystalLeaves");
        GameRegistry.registerBlock(Dungeons.crystalBamboo = new BlockCrystalliumBamboo().setBlockName("crystalBamboo").setBlockTextureName("gibby_dungeons" + ":" + "crystalbamboo").setCreativeTab(Dungeons.Blocks), "dungeons_crystalBamboo");
        GameRegistry.registerBlock(Dungeons.voidrockOre = new BlockVoidRockOre().setBlockName("voidrockOre").setBlockTextureName("gibby_dungeons" + ":" + "voidrockore").setCreativeTab(Dungeons.Blocks), "dungeons_voidrockOre");
        EntityRegistry.registerModEntity((Class)EntityIronStar.class, "EntityIronStar", 100, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityProjectileBall.class, "EntityProjectileBall", 101, (Object)this, 40, 2, false);
        EntityRegistry.registerModEntity((Class)EntityExplosive.class, "EntityExplosive", 102, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySpit.class, "EntitySpit", 103, (Object)this, 20, 1, true);
        EntityRegistry.registerModEntity((Class)EntitySodbuster.class, "EntitySodbuster", 104, (Object)this, 20, 1, true);
        EntityRegistry.registerModEntity((Class)EntityShimmerPearl.class, "EntityShimmerPearl", 105, (Object)this, 60, 5, true);
        EntityRegistry.registerModEntity((Class)EntityWaterBall.class, "EntityWaterBall", 106, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySandBall.class, "EntitySandBall", 107, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBlizzardBall.class, "EntityBlizzardBall", 108, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTornadoBall.class, "EntityTornadoBall", 109, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBloodBall.class, "EntityBloodBall", 110, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityRedBall.class, "EntityRedBall", 111, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityGreenBall.class, "EntityGreenBall", 112, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBlueBall.class, "EntityBlueBall", 113, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityMiniFireBall.class, "EntityMiniFireBall", 114, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityNetherDriller.class, "EntityNetherDriller", 115, (Object)this, 50, 10, true);
        EntityRegistry.registerModEntity((Class)EntityNetherDrill.class, "EntityNetherDrill", 116, (Object)this, 50, 10, true);
        EntityRegistry.registerModEntity((Class)EntityVoidBomb.class, "EntityVoidBomb", 117, (Object)this, 50, 1, true);
        EntityRegistry.registerModEntity((Class)EntityVoidDisk.class, "EntityVoidDisk", 118, (Object)this, 50, 1, true);
        EntityRegistry.registerModEntity((Class)EntityRupture.class, "EntityRupture", 119, (Object)this, 30, 1, true);
        EntityRegistry.registerModEntity((Class)EntityAntigravity.class, "EntityAntigravity", 120, (Object)this, 50, 1, true);
        EntityRegistry.registerModEntity((Class)EntityEnergy.class, "EntityEnergy", 121, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityExplosionSnake.class, "EntityExplosionSnake", 121, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityBlackEnergy.class, "EntityBlackEnergy", 122, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityColdWind.class, "EntityBlackEnergy", 123, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityHealEffect.class, "EntityHealEffect", 124, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityQuake.class, "EntityQuake", 125, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityAmethystPortal.class, "EntityAmethystPortal", 126, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityDarkWave.class, "EntityDarkWave", 127, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySunsetPortal.class, "EntitySunsetPortal", 128, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityDarkExplosion.class, "EntityDarkExplosion", 129, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBeholderSpawner.class, "EntityBeholderSpawner", 130, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCursedStone.class, "EntityCursedStone", 131, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityWitherSpawner.class, "EntityWitherSpawner", 132, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCorruptedArrow.class, "EntityCorruptedArrow", 133, (Object)this, 120, 2, true);
        EntityRegistry.registerModEntity((Class)EntityRuneExplosion.class, "EntityRuneExplosion", 134, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityThrowback.class, "EntityThrowback", 135, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityDisinigrationArrow.class, "EntityDisinigrationArrow", 136, (Object)this, 120, 2, true);
        EntityRegistry.registerModEntity((Class)EntityIceShieldBall.class, "EntityIceShieldBall", 137, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityRedBouncer.class, "EntityRedBouncer", 138, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBlueBeam.class, "EntityBlueBeam", 139, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityIcefire.class, "EntityIcefire", 140, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityIceWanderer.class, "EntityIceWanderer", 141, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityIceSpiker.class, "EntityIceSpiker", 142, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySunProjectile.class, "EntitySunProjectile", 143, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityGroundShade.class, "EntityGroundShade", 144, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntitySapientDeath.class, "EntitySapientDeath", 145, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalBeam.class, "EntityCrystalBeam", 146, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityMontanePortal.class, "EntityMontanePortal", 147, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityMagirockBall.class, "EntityMagirockBall", 148, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityVoidrim.class, "EntityVoidrim", 149, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalToxic.class, "EntityCrystalToxic", 150, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityExawdusSpawner.class, "EntityExawdusSpawner", 151, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityEnchantEffect.class, "EntityEnchantEffect", 152, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityVoidrockBall.class, "EntityVoidrockBall", 153, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityFusionBall.class, "EntityFusionBall", 154, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalliumPlainsPortal.class, "EntityCrystalliumPlainsPortal", 155, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalMeteor.class, "EntityCrystalMeteor", 156, (Object)this, 60, 1, true);
        EntityRegistry.registerModEntity((Class)EntityGoblin.class, "EntityGoblin", 1, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySkeletonWarrior.class, "EntitySkeletonWarrior", 3, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityZombieWarlord.class, "EntityZombieWarlord", 4, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityEarthGolem.class, "EntityEarthGolem", 5, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityStoneGolem.class, "EntityStoneGolem", 6, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBigStoneGolem.class, "EntityBigStoneGolem", 7, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntitySpecter.class, "EntitySpecter", 8, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityBandit.class, "EntityBandit", 9, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityBanditBoss.class, "EntityBanditLeader", 10, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySkeletalMage.class, "EntitySkeletalMage", 11, (Object)this, 40, 3, true);
        EntityRegistry.registerModEntity((Class)EntityBlackKnight.class, "EntityBlackKnight", 12, (Object)this, 30, 3, true);
        EntityRegistry.registerModEntity((Class)EntityHannibal.class, "EntityHannibal", 13, (Object)this, 30, 3, true);
        EntityRegistry.registerModEntity((Class)EntityRemnant.class, "EntityRemnant", 14, (Object)this, 100, 3, true);
        EntityRegistry.registerModEntity((Class)EntityVoidLord.class, "EntityVoidLord", 15, (Object)this, 100, 3, true);
        EntityRegistry.registerModEntity((Class)EntityDarkKnight.class, "EntityDarkKnight", 16, (Object)this, 100, 3, true);
        EntityRegistry.registerModEntity((Class)EntityNecro.class, "EntityNecro", 17, (Object)this, 60, 3, true);
        EntityRegistry.registerModEntity((Class)EntityIceMage.class, "EntityIceMage", 18, (Object)this, 60, 3, true);
        EntityRegistry.registerModEntity((Class)EntityEarthMage.class, "EntityEarthMage", 19, (Object)this, 60, 3, true);
        EntityRegistry.registerModEntity((Class)EntityImp.class, "EntityImp", 20, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTroll.class, "EntityTroll", 21, (Object)this, 40, 3, true);
        EntityRegistry.registerModEntity((Class)EntityShimmerman.class, "EntityShimmerman", 22, (Object)this, 60, 3, true);
        EntityRegistry.registerModEntity((Class)EntityCyclops.class, "EntityCyclops", 23, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTyphoon.class, "EntityTyphoon", 24, (Object)this, 60, 4, true);
        EntityRegistry.registerModEntity((Class)EntitySandstorm.class, "EntitySandstorm", 25, (Object)this, 60, 4, true);
        EntityRegistry.registerModEntity((Class)EntityVoidFiend.class, "EntityVoidFiend", 26, (Object)this, 40, 4, true);
        EntityRegistry.registerModEntity((Class)EntityBlizzard.class, "EntityBlizzard", 27, (Object)this, 60, 4, true);
        EntityRegistry.registerModEntity((Class)EntityTornado.class, "EntityTornado", 28, (Object)this, 60, 4, true);
        EntityRegistry.registerModEntity((Class)EntityHermit.class, "EntityHermit", 29, (Object)this, 60, 3, true);
        EntityRegistry.registerModEntity((Class)EntitySpirit.class, "EntitySpirit", 30, (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityWarlock.class, "EntityWarlock", 31, (Object)this, 60, 3, true);
        EntityRegistry.registerModEntity((Class)EntitySkeletonKnight.class, "EntitySkeletonKnight", 32, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySapientWarrior.class, "EntitySapientWarrior", 33, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySapientMiner.class, "EntitySapientMiner", 34, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityNetherGhost.class, "EntityNetherGhost", 35, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityNetherSoul.class, "EntityNetherSoul", 36, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityNetherPigman.class, "EntityNetherPigman", 37, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityAmethystMonster.class, "EntityAmethystMonster", 38, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityVampire.class, "EntityVampire", 39, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityLavaTroll.class, "EntityLavaTroll", 40, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityLavaKnight.class, "EntityLavaKnight", 41, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityNetherBadgerer.class, "EntityNetherBadgerer", 42, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityBeholder.class, "EntityBeholder", 43, (Object)this, 300, 3, true);
        EntityRegistry.registerModEntity((Class)EntityFireclops.class, "EntityFireclops", 44, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityWitherSkeletonMinion.class, "EntityWitherSkeletonMinion", 45, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalBadgerer.class, "EntityCrystalBadgerer", 46, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityGhostWither.class, "EntityGhostWither", 47, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityFakeWither.class, "EntityFakeWither", 48, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityChainMummy.class, "EntityChainMummy", 57, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityEyeWarrior.class, "EntityEyeWarrior", 58, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityYeti.class, "EntityYeti", 59, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntitySnowGiant.class, "EntitySnowGiant", 60, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityDeathBringer.class, "EntityDeathBringer", 61, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityDungeonBeast.class, "EntityDungeonBeast", 62, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityDesertDragger.class, "EntityDesertDragger", 63, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityNetherWalker.class, "EntityNetherWalker", 66, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityIceShielder.class, "EntityIceShielder", 68, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityOrc.class, "EntityOrc", 69, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityOrcMage.class, "EntityOrcMage", 70, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityOrcDefender.class, "EntityOrcDefender", 71, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityRockTroll.class, "EntityRockTroll", 73, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityEarthRupturer.class, "EntityEarthRupturer", 74, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityIceSpirit.class, "EntityIceSpirit", 75, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityUndefeatableStrength.class, "EntityUndefeatableStrength", 76, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityUndefeatableRegen.class, "EntityUndefeatableRegen", 77, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntityUndefeatableResistance.class, "EntityUndefeatableResistance", 78, (Object)this, 50, 3, true);
        EntityRegistry.registerModEntity((Class)EntitySapientEliteKnight.class, "EntitySapientEliteKnight", 79, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySapientGeneral.class, "EntitySapientGeneral", 80, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityMidnightShade.class, "EntityMidnightShade", 83, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySapientMage.class, "EntitySapientMage", 84, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalTroll.class, "EntityCrystalTroll", 85, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCrystasis.class, "EntityCrystasis", 86, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCrystox.class, "EntityCrystox", 87, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityExawdus.class, "EntityExawdus", 88, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityCrystalliumGolem.class, "EntityCrystalliumGolem", 89, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityMoundTrader.class, "EntityMoundTrader", 49, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityAnchorTrader.class, "EntityAnchorTrader", 50, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityStoneBot.class, "EntityStoneBot", 51, (Object)this, 50, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTreeVillager.class, "EntityTreeVillager", 52, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityQuarryMaster.class, "EntityQuarryMaster", 53, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityOreDealer.class, "EntityOreDealer", 54, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityMinerVillager.class, "EntityMinerVillager", 55, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTalkingVillager.class, "EntityTalkingVillager", 56, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTavernMaster.class, "EntityTavernMaster", 64, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTavernClient.class, "EntityTavernClient", 65, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityFriendlyZombie.class, "EntityFriendlyZombie", 67, (Object)this, 60, 2, true);
        EntityRegistry.registerModEntity((Class)EntityMontaneVillager.class, "EntityMontaneVillager", 81, (Object)this, 30, 2, true);
        EntityRegistry.registerModEntity((Class)EntityMontaneTrader.class, "EntityMontaneTrader", 82, (Object)this, 30, 2, true);
        GameRegistry.registerWorldGenerator((IWorldGenerator)new DungeonsGenerator(), 30);
        Crafting.Recipes();
        CombatCrafting.Recipes();
        ToolCrafting.Recipes();
        ArmorCrafting.Recipes();
        MagicCrafting.Recipes();
        registerEntityEgg((Class<? extends Entity>)EntityGoblin.class, 1538054, 14482440);
        registerEntityEgg((Class<? extends Entity>)EntityImp.class, 7873536, 3679232);
        registerEntityEgg((Class<? extends Entity>)EntitySkeletonWarrior.class, 13224393, 6367746);
        registerEntityEgg((Class<? extends Entity>)EntityZombieWarlord.class, 218902, 9408399);
        registerEntityEgg((Class<? extends Entity>)EntityEarthGolem.class, 9523712, 6890752);
        registerEntityEgg((Class<? extends Entity>)EntityStoneGolem.class, 6381921, 11382189);
        registerEntityEgg((Class<? extends Entity>)EntityBigStoneGolem.class, 6381921, 11382189);
        registerEntityEgg((Class<? extends Entity>)EntityStoneBot.class, 5395026, 10395294);
        registerEntityEgg((Class<? extends Entity>)EntitySpecter.class, 14606046, 12763842);
        registerEntityEgg((Class<? extends Entity>)EntityBandit.class, 8728064, 6184542);
        registerEntityEgg((Class<? extends Entity>)EntityBanditBoss.class, 8728064, 6184542);
        registerEntityEgg((Class<? extends Entity>)EntitySkeletalMage.class, 7538690, 10262423);
        registerEntityEgg((Class<? extends Entity>)EntityTroll.class, 8728064, 7362892);
        registerEntityEgg((Class<? extends Entity>)EntityShimmerman.class, 16772608, 7536751);
        registerEntityEgg((Class<? extends Entity>)EntityCyclops.class, 11773707, 11760139);
        registerEntityEgg((Class<? extends Entity>)EntityTyphoon.class, 751795, 12877);
        registerEntityEgg((Class<? extends Entity>)EntitySandstorm.class, 14926162, 11767838);
        registerEntityEgg((Class<? extends Entity>)EntityBlizzard.class, 8510171, 1037270);
        registerEntityEgg((Class<? extends Entity>)EntityTornado.class, 5197390, 2500134);
        registerEntityEgg((Class<? extends Entity>)EntityVoidFiend.class, 0, 5065473);
        registerEntityEgg((Class<? extends Entity>)EntitySpirit.class, 13396230, 12715724);
        registerEntityEgg((Class<? extends Entity>)EntityHermit.class, 13396998, 12715724);
        registerEntityEgg((Class<? extends Entity>)EntityWarlock.class, 10378777, 10027779);
        registerEntityEgg((Class<? extends Entity>)EntityNecro.class, 0, 9729);
        registerEntityEgg((Class<? extends Entity>)EntityIceMage.class, 562831, 12687308);
        registerEntityEgg((Class<? extends Entity>)EntityEarthMage.class, 5382914, 749570);
        registerEntityEgg((Class<? extends Entity>)EntitySkeletonKnight.class, 9868950, 2171169);
        registerEntityEgg((Class<? extends Entity>)EntitySapientWarrior.class, 13619151, 14598270);
        registerEntityEgg((Class<? extends Entity>)EntitySapientMiner.class, 13619151, 14598270);
        registerEntityEgg((Class<? extends Entity>)EntityMoundTrader.class, 14598270, 9855439);
        registerEntityEgg((Class<? extends Entity>)EntityAnchorTrader.class, 14598270, 2359370);
        registerEntityEgg((Class<? extends Entity>)EntityBlackKnight.class, 9606292, 4868682);
        registerEntityEgg((Class<? extends Entity>)EntityHannibal.class, 16579836, 7782596);
        registerEntityEgg((Class<? extends Entity>)EntityRemnant.class, 0, 58879);
        registerEntityEgg((Class<? extends Entity>)EntityVoidLord.class, 0, 1769216);
        registerEntityEgg((Class<? extends Entity>)EntityDarkKnight.class, 197379, 7368816);
        registerEntityEgg((Class<? extends Entity>)EntityNetherGhost.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityNetherSoul.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityNetherPigman.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityVampire.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityLavaTroll.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityLavaKnight.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityNetherBadgerer.class, 6498825, 7538690);
        registerEntityEgg((Class<? extends Entity>)EntityBeholder.class, 6498825, 16711680);
        registerEntityEgg((Class<? extends Entity>)EntityFireclops.class, 6498825, 16711680);
        registerEntityEgg((Class<? extends Entity>)EntityCrystalBadgerer.class, 16711935, 4718722);
        registerEntityEgg((Class<? extends Entity>)EntityAmethystMonster.class, 16711935, 4718722);
        registerEntityEgg((Class<? extends Entity>)EntityGhostWither.class, 16711935, 1835295);
        registerEntityEgg((Class<? extends Entity>)EntityTreeVillager.class, 15122026, 3200019);
        registerEntityEgg((Class<? extends Entity>)EntityQuarryMaster.class, 15122026, 4013373);
        registerEntityEgg((Class<? extends Entity>)EntityMinerVillager.class, 15122026, 4013373);
        registerEntityEgg((Class<? extends Entity>)EntityTalkingVillager.class, 15122026, 6904085);
        registerEntityEgg((Class<? extends Entity>)EntityChainMummy.class, 3223857, 8388608);
        registerEntityEgg((Class<? extends Entity>)EntityEyeWarrior.class, 7012459, 13408512);
        registerEntityEgg((Class<? extends Entity>)EntityYeti.class, 16777164, 13421823);
        registerEntityEgg((Class<? extends Entity>)EntitySnowGiant.class, 16777215, 102);
        registerEntityEgg((Class<? extends Entity>)EntityDeathBringer.class, 0, 16777215);
        registerEntityEgg((Class<? extends Entity>)EntityDungeonBeast.class, 10066329, 8388608);
        registerEntityEgg((Class<? extends Entity>)EntityDesertDragger.class, 16777062, 16777164);
        registerEntityEgg((Class<? extends Entity>)EntityTavernMaster.class, 6697728, 16777113);
        registerEntityEgg((Class<? extends Entity>)EntityTavernClient.class, 6697728, 16777113);
        registerEntityEgg((Class<? extends Entity>)EntityNetherWalker.class, 8388608, 6776679);
        registerEntityEgg((Class<? extends Entity>)EntityIceShielder.class, 13434879, 6750207);
        registerEntityEgg((Class<? extends Entity>)EntityOrc.class, 6704128, 0);
        registerEntityEgg((Class<? extends Entity>)EntityOrcMage.class, 6704128, 0);
        registerEntityEgg((Class<? extends Entity>)EntityOrcDefender.class, 6704128, 0);
        registerEntityEgg((Class<? extends Entity>)EntityRockTroll.class, 6704128, 6697728);
        registerEntityEgg((Class<? extends Entity>)EntityEarthRupturer.class, 6704128, 13408512);
        registerEntityEgg((Class<? extends Entity>)EntityIceSpirit.class, 16777215, 13421823);
        registerEntityEgg((Class<? extends Entity>)EntityUndefeatableStrength.class, 8421504, 5046272);
        registerEntityEgg((Class<? extends Entity>)EntityUndefeatableRegen.class, 8421504, 6684723);
        registerEntityEgg((Class<? extends Entity>)EntityUndefeatableResistance.class, 8421504, 9380864);
        registerEntityEgg((Class<? extends Entity>)EntitySapientEliteKnight.class, 16777062, 0);
        registerEntityEgg((Class<? extends Entity>)EntitySapientGeneral.class, 16777113, 16776960);
        registerEntityEgg((Class<? extends Entity>)EntityMontaneVillager.class, 13411154, 8421504);
        registerEntityEgg((Class<? extends Entity>)EntityMontaneTrader.class, 13411154, 8421504);
        registerEntityEgg((Class<? extends Entity>)EntityMidnightShade.class, 0, 102);
        registerEntityEgg((Class<? extends Entity>)EntitySapientMage.class, 16777113, 6684774);
        registerEntityEgg((Class<? extends Entity>)EntityCrystalTroll.class, 16777113, 6684774);
        registerEntityEgg((Class<? extends Entity>)EntityCrystasis.class, 16777113, 6684774);
        registerEntityEgg((Class<? extends Entity>)EntityCrystox.class, 16777113, 6684774);
        registerEntityEgg((Class<? extends Entity>)EntityExawdus.class, 16777113, 6684774);
        registerEntityEgg((Class<? extends Entity>)EntityCrystalliumGolem.class, 16777113, 6684774);
        final BiomeGenBase[] spawn = BiomeGenBase.getBiomeGenArray();
        for (int i = 0; i < spawn.length - 1; ++i) {
            if (spawn[i] != null && spawn[i] != Dungeons.crystal && spawn[i] != Dungeons.sunset && spawn[i] != Dungeons.crystalliumPlainsBiome) {
                EntityRegistry.addSpawn((Class)EntityImp.class, 17, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntitySpirit.class, 15, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntitySkeletonWarrior.class, 17, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityBanditBoss.class, 7, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityTroll.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntitySkeletalMage.class, 5, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityCyclops.class, 30, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityVoidFiend.class, 70, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityEarthGolem.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntitySapientMiner.class, 40, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityWarlock.class, 15, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityNecro.class, 15, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntityEarthMage.class, 15, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
                EntityRegistry.addSpawn((Class)EntitySkeletonKnight.class, 30, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { spawn[i] });
            }
        }
        EntityRegistry.removeSpawn((Class)EntityImp.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntitySkeletalMage.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityBanditBoss.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityBanditBoss.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityTroll.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityTroll.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityGiantZombie.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityGiantZombie.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityCyclops.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityCyclops.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityVoidFiend.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityVoidFiend.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityEarthGolem.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityEarthGolem.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntitySkeletonWarrior.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntitySkeletonWarrior.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntitySpirit.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntitySapientMiner.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntitySapientMiner.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityWarlock.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityWarlock.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntitySkeletonKnight.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityNecro.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityNecro.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.removeSpawn((Class)EntityEarthMage.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
        EntityRegistry.removeSpawn((Class)EntityEarthMage.class, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityTyphoon.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.swampland });
        EntityRegistry.addSpawn((Class)EntityTyphoon.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.beach });
        EntityRegistry.addSpawn((Class)EntitySandstorm.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.desert });
        EntityRegistry.addSpawn((Class)EntitySandstorm.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.desertHills });
        EntityRegistry.addSpawn((Class)EntityDesertDragger.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.desert });
        EntityRegistry.addSpawn((Class)EntityDesertDragger.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.desertHills });
        EntityRegistry.addSpawn((Class)EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.iceMountains });
        EntityRegistry.addSpawn((Class)EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.icePlains });
        EntityRegistry.addSpawn((Class)EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.coldTaigaHills });
        EntityRegistry.addSpawn((Class)EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
        EntityRegistry.addSpawn((Class)EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.iceMountains });
        EntityRegistry.addSpawn((Class)EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.icePlains });
        EntityRegistry.addSpawn((Class)EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.coldTaigaHills });
        EntityRegistry.addSpawn((Class)EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
        EntityRegistry.addSpawn((Class)EntityTornado.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.plains });
        EntityRegistry.addSpawn((Class)EntityTornado.class, 20, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.savanna });
        EntityRegistry.addSpawn((Class)EntityHermit.class, 30, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.extremeHills });
        EntityRegistry.addSpawn((Class)EntityHermit.class, 30, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
        EntityRegistry.addSpawn((Class)EntityHermit.class, 30, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.extremeHillsPlus });
        EntityRegistry.addSpawn((Class)EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.forest });
        EntityRegistry.addSpawn((Class)EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.forestHills });
        EntityRegistry.addSpawn((Class)EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.birchForest });
        EntityRegistry.addSpawn((Class)EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
        EntityRegistry.addSpawn((Class)EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.roofedForest });
        EntityRegistry.addSpawn((Class)EntityNetherPigman.class, 80, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityNetherSoul.class, 35, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityNetherGhost.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityVampire.class, 40, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityLavaTroll.class, 20, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityLavaKnight.class, 40, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityNetherBadgerer.class, 5, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
        EntityRegistry.addSpawn((Class)EntityAmethystMonster.class, 240, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystal });
        EntityRegistry.addSpawn((Class)EntityCrystalBadgerer.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystal });
        EntityRegistry.addSpawn((Class)EntityHannibal.class, 60, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystal });
        EntityRegistry.addSpawn((Class)EntityCrystalliumGolem.class, 120, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystal });
        EntityRegistry.addSpawn((Class)EntityCrystasis.class, 120, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystalliumPlainsBiome });
        EntityRegistry.addSpawn((Class)EntityCrystalTroll.class, 40, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystalliumPlainsBiome });
        EntityRegistry.addSpawn((Class)EntityShimmerman.class, 20, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystalliumPlainsBiome });
        EntityRegistry.addSpawn((Class)EntityCrystox.class, 120, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] { Dungeons.crystalliumPlainsBiome });
        Dungeons.proxy.registerRenderInformation();
        Dungeons.proxy.registerItemRenderers();
        Dungeons.proxy.registerTileEntities();
        ChestSetup.addChestItems();
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        Dungeons.packetPipeline.postInitialise();
        if (this.entitylistEnabled == 1) {
            EntityList.addMapping((Class)EntityGoblin.class, "EntityGoblin", this.setMobId());
            EntityList.addMapping((Class)EntitySkeletonWarrior.class, "EntitySkeletonWarrior", this.setMobId());
            EntityList.addMapping((Class)EntityEarthGolem.class, "EntityEarthGolem", this.setMobId());
            EntityList.addMapping((Class)EntityStoneGolem.class, "EntityStoneGolem", this.setMobId());
            EntityList.addMapping((Class)EntityBandit.class, "EntityBandit", this.setMobId());
            EntityList.addMapping((Class)EntityBlackKnight.class, "EntityBlackKnight", this.setMobId());
            EntityList.addMapping((Class)EntityNecro.class, "EntityNecro", this.setMobId());
            EntityList.addMapping((Class)EntityTroll.class, "EntityTroll", this.setMobId());
            EntityList.addMapping((Class)EntityVoidFiend.class, "EntityVoidFiend", this.setMobId());
            EntityList.addMapping((Class)EntitySpirit.class, "EntitySpirit", this.setMobId());
            EntityList.addMapping((Class)EntitySkeletonKnight.class, "EntitySkeletonKnight", this.setMobId());
            EntityList.addMapping((Class)EntitySapientWarrior.class, "EntitySapientWarrior", this.setMobId());
            EntityList.addMapping((Class)EntityNetherSoul.class, "EntityNetherSoul", this.setMobId());
            EntityList.addMapping((Class)EntityAmethystMonster.class, "EntityAmethystMonster", this.setMobId());
            EntityList.addMapping((Class)EntityVampire.class, "EntityVampire", this.setMobId());
            EntityList.addMapping((Class)EntityLavaKnight.class, "EntityLavaKnight", this.setMobId());
        }
        MinecraftForge.EVENT_BUS.register((Object)new DungeonGuiIngame(Minecraft.getMinecraft()));
        MinecraftForge.EVENT_BUS.register((Object)new DungeonEventHandler());
    }
    
    public static int getUniqueEntityId() {
        do {
            ++Dungeons.startEntityid;
        } while (EntityList.getStringFromID(Dungeons.startEntityid) != null);
        return Dungeons.startEntityid;
    }
    
    public static void registerEntityEgg(final Class<? extends Entity> entity, final int primaryColor, final int secondaryColor) {
        final int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
    
    public static ItemStack setRare(final ItemStack stack) {
        final Random rand = new Random();
        int bookRand = 0;
        if (stack.getItem() == Items.enchanted_book) {
            bookRand = rand.nextInt(3) + 1;
        }
        if (stack.getItem() instanceof ItemArmor || bookRand == 1) {
            int random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Dungeons.voidProtection, rand.nextInt(2) + 3);
            }
            else if (random == 1) {
                stack.addEnchantment(Dungeons.magicProtection, rand.nextInt(2) + 3);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.protection, rand.nextInt(2) + 3);
            }
            random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Enchantment.thorns, rand.nextInt(3) + 1);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.unbreaking, rand.nextInt(3) + 1);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.featherFalling, rand.nextInt(3) + 1);
            }
        }
        else if (stack.getItem() instanceof ItemSword || bookRand == 2) {
            int random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Dungeons.voidBlade, rand.nextInt(3) + 2);
            }
            else if (random == 1) {
                stack.addEnchantment(Dungeons.magicBlade, rand.nextInt(3) + 2);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.sharpness, rand.nextInt(3) + 3);
            }
            random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Enchantment.fireAspect, rand.nextInt(2) + 1);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.looting, rand.nextInt(2) + 1);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.knockback, rand.nextInt(2) + 1);
            }
            random = rand.nextInt(6);
            if (random == 0) {
                stack.addEnchantment(Dungeons.frostblade, 1);
            }
            else if (random == 1) {
                stack.addEnchantment(Dungeons.lifesteal, 1);
            }
            else if (random == 2) {
                stack.addEnchantment(Dungeons.quakeblade, 1);
            }
            else if (random == 3) {
                stack.addEnchantment(Dungeons.windblade, 1);
            }
        }
        else if (stack.getItem() instanceof ItemTool || bookRand == 3) {
            int random = rand.nextInt(2);
            if (random == 0) {
                stack.addEnchantment(Enchantment.efficiency, rand.nextInt(2) + 2);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.unbreaking, rand.nextInt(2) + 2);
            }
            random = rand.nextInt(2);
            if (random == 0) {
                stack.addEnchantment(Enchantment.fortune, rand.nextInt(2) + 2);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.silkTouch, 1);
            }
        }
        stack.addEnchantment(Dungeons.rare, 1);
        return stack;
    }
    
    public static ItemStack setLegendary(final ItemStack stack) {
        final Random rand = new Random();
        if (stack.getItem() instanceof ItemArmor) {
            int random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Dungeons.voidProtection, rand.nextInt(3) + 4);
            }
            else if (random == 1) {
                stack.addEnchantment(Dungeons.magicProtection, rand.nextInt(3) + 4);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.protection, rand.nextInt(3) + 4);
            }
            random = rand.nextInt(2);
            if (random == 0) {
                stack.addEnchantment(Enchantment.thorns, rand.nextInt(3) + 3);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.featherFalling, rand.nextInt(3) + 3);
            }
            stack.addEnchantment(Enchantment.unbreaking, rand.nextInt(3) + 3);
        }
        else if (stack.getItem() instanceof ItemSword) {
            int random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Dungeons.voidBlade, rand.nextInt(4) + 4);
            }
            else if (random == 1) {
                stack.addEnchantment(Dungeons.magicBlade, rand.nextInt(4) + 4);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.sharpness, rand.nextInt(4) + 5);
            }
            random = rand.nextInt(3);
            if (random == 0) {
                stack.addEnchantment(Enchantment.fireAspect, rand.nextInt(2) + 3);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.looting, rand.nextInt(3) + 3);
            }
            else if (random == 2) {
                stack.addEnchantment(Enchantment.knockback, rand.nextInt(2) + 3);
            }
            random = rand.nextInt(4);
            if (random == 0) {
                stack.addEnchantment(Dungeons.frostblade, rand.nextInt(2) + 1);
            }
            else if (random == 1) {
                stack.addEnchantment(Dungeons.lifesteal, rand.nextInt(3) + 1);
            }
            else if (random == 2) {
                stack.addEnchantment(Dungeons.quakeblade, rand.nextInt(2) + 1);
            }
            stack.addEnchantment(Dungeons.windblade, rand.nextInt(3) + 1);
            stack.addEnchantment(Enchantment.unbreaking, rand.nextInt(2) + 2);
        }
        else if (stack.getItem() instanceof ItemTool) {
            final int random = rand.nextInt(2);
            stack.addEnchantment(Enchantment.efficiency, rand.nextInt(4) + 3);
            stack.addEnchantment(Enchantment.unbreaking, rand.nextInt(3) + 3);
            if (random == 0) {
                stack.addEnchantment(Enchantment.fortune, rand.nextInt(3) + 4);
            }
            else if (random == 1) {
                stack.addEnchantment(Enchantment.silkTouch, 1);
            }
        }
        stack.addEnchantment(Dungeons.legendary, 2);
        return stack;
    }
    
    public static double randGauss() {
        final Random rand = new Random();
        return rand.nextGaussian() - rand.nextGaussian();
    }
    
    public static float randFloat() {
        final Random rand = new Random();
        return rand.nextFloat() - rand.nextFloat();
    }
    
    public static int randRange(final int start, final int end) {
        final Random rand = new Random();
        final int randNum = rand.nextInt(Math.abs(start - end) + 1) + start;
        return randNum;
    }
    
    public static void spawner(final World world, final int x, final int y, final int z, final int mobId, final int mobCount) {
        world.setBlock(x, y, z, Dungeons.dungeonSpawner);
        final TileEntityDungeonSpawner spawner = (TileEntityDungeonSpawner)world.getTileEntity(x, y, z);
        if (spawner != null) {
            spawner.setMobName(mobId);
            spawner.setMobCount(mobCount);
        }
    }
    
    public static void spawnerRepeater(final World world, final int x, final int y, final int z, final int mobId, final int mobCount, final int cooldown) {
        world.setBlock(x, y, z, Dungeons.dungeonSpawnerRepeater);
        final TileEntityDungeonSpawnerRepeater spawner = (TileEntityDungeonSpawnerRepeater)world.getTileEntity(x, y, z);
        if (spawner != null) {
            spawner.setMobName(mobId);
            spawner.setMobCount(mobCount);
            spawner.setCooldown(cooldown);
        }
    }
    
    int setMobId() {
        int id;
        for (id = 130; EntityList.getClassFromID(id) != null; ++id) {}
        if (id > 255) {
            System.out.println("[ERROR] There are no more global entity id's for Arcana RPG");
        }
        return id;
    }
    
    static {
        packetPipeline = new PacketPipeline();
        Materials = new CreativeTabs(CreativeTabs.getNextID(), "Materials and Misc") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Dungeons.netherSteel;
            }
        };
        Blocks = new CreativeTabs(CreativeTabs.getNextID(), "Blocks") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Dungeons.amethystCracks);
            }
        };
        Weapons = new CreativeTabs(CreativeTabs.getNextID(), "Weapons") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Dungeons.heavyAmethystSword;
            }
        };
        Armor = new CreativeTabs(CreativeTabs.getNextID(), "Armor") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Dungeons.blindLightHelmet;
            }
        };
        Magic = new CreativeTabs(CreativeTabs.getNextID(), "Magic") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Dungeons.sapientWarWand;
            }
        };
        Key = new CreativeTabs(CreativeTabs.getNextID(), "KeyItems") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Dungeons.dungeonDimensionSpawner;
            }
        };
        Dungeons.startEntityid = 1580;
    }
}
