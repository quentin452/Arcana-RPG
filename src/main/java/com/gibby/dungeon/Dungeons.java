

package com.gibby.dungeon;

import com.gibby.dungeon.blocks.*;
import com.gibby.dungeon.config.ModConfig;
import com.gibby.dungeon.gen.*;
import com.gibby.dungeon.init.ChestSetup;
import com.gibby.dungeon.init.EggInit;
import com.gibby.dungeon.init.recipeinit.*;
import com.gibby.dungeon.items.*;
import com.gibby.dungeon.mobs.entityinstance.*;
import com.gibby.dungeon.proxy.CommonProxy;
import com.gibby.dungeon.proxy.packetPipelines.PacketPipeline;
import com.gibby.dungeon.util.DungeonPotion;
import com.gibby.dungeon.util.DungeonPotions;
import com.gibby.dungeon.util.FileInjector;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;
import java.util.Random;

@Mod(modid = Dungeons.MODID, version = "1.4.3",dependencies = "required-after:reccomplex;")
public class Dungeons
{
    public static final String MODID = "gibby_dungeons";
    @SidedProxy(clientSide = "com.gibby.dungeon.proxy.ClientProxy", serverSide = "com.gibby.dungeon.proxy.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Instance(Dungeons.MODID)
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
    public static Item midnightCoin;
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
    public static Item midnightBeef;
    public static Item midnightBeefRaw;
    public static Item incandescentDust;
    public static Item incandescentCharge;
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
    public static Block blueGlow;
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
    public static Block nightCounter;
    public static Block nightLight;
    public static Block crystalWeed;
    public static Block crystalStem;
    public static Block eruikPlant;
    public static Block darkOrchid;
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
    public static Block bloodThorns;
    public static Block blindlightLeaf;
    public static Block midnightLog;
    public static Block midnightLeaves;
    public static Block midnightMossStone;
    public static Block jadeLog;
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
    public static Block shadowRune2;
    public static Block shadowRune3;
    public static Block shadowBlock;
    public static Block blackIronOre;
    public static Block crystalDirt;
    public static Block blindlightOre;
    public static Block lightBlueGlow;
    public static Block crystalGrass;
    public static Block crystalLeaves;
    public static Block crystalBamboo;
    public static Block voidrockOre;
    public static Block darkBlueGlow;
    public static Block midnightPortal;
    public static Block fireflyLog;
    public static Block fireflyLeaves;
    public static Block midnightStone;
    public static Block midnightGrass;
    public static Block midnightDirt;
    public static Block runicOre;
    public static Block fireflyStone;
    public static Block jadeLeaves;
    public static Block greenGlow;
    public static Block runeAltar;
    public static Block jadePeaches;
    public static Block blueBrick;
    public static Block midnightFence;
    public static Block shadowAltar;
    public static Block glowingBrambles;
    public static Block midnightBush;
    public static Block midnightShortgrass;
    public static Block midnightScrub;
    public static Block midnightScrubLight;
    public static Block midnightStem;
    public static Block midnightTallgrass;
    public static Block flimFlower;
    public static Block midnightBramble;
    public static Block altarBricks;
    public static Block midnightCracks;
    public static Item cyellow;
    public static Item cgreen;
    public static Item cblue;
    public static Item cdarkblue;
    public static Item cgray;
    public static Item cpurple;
    public static Item invisible;
    public static Item cvoidrim;
    public static Item chamonix;
    public static Item darkSoul;
    public static Item titanicTome;
    public static Item blindlightStone;
    public static Item blindlightIngot;
    public static Item shadowOrb;
    public static Item runeShard;
    public static Item peach;
    public static Item runeStone;
    public static Item blindlightHoe;
    public static Item regenTome;
    public static Item shadowAxe;
    public static Item runeSpeedStaff;
    public static Item midnightChickenRaw;
    public static Item randomItemGiverVampire;
    public static Item randomItemGiverVoidDungeon;

    public static Item randomItemGiverNetherStructure;

    public static Item randomItemGiverMontaneDungeon;

    public static Item randomItemGiverMontagneRiche;

    public static Item randomItemGiverBeholder;
    public static Item randomItemGiverdungeonChest;

    public static BiomeGenBase sunset;
    public static BiomeGenBase crystal;
    public static BiomeGenBase montane;
    public static BiomeGenBase crystalliumPlainsBiome;
    public static BiomeGenBase midnightBiome;
    public static int sunsetBiomeId;
    public static int crystalBiomeId;
    public static int montaneBiomeId;
    public static int crystalliumPlainsBiomeId;
    public static int midnightBiomeId;
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
    public Item.ToolMaterial BLINDLIGHT;
    public Item.ToolMaterial SHADOW;
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
    public static int midnightDimensionId;
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
        this.BLINDLIGHT = EnumHelper.addToolMaterial("dungeons_blindlight", 7, 4000, 35.0f, 9.0f, 20);
        this.SHADOW = EnumHelper.addToolMaterial("dungeons_shadow", 6, 12000, 15.0f, 8.0f, 20);
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
    public void init(final FMLInitializationEvent event) {
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
        Dungeons.montane = new BiomeMontane(Dungeons.montaneBiomeId).setEnableSnow().setTemperatureRainfall(-0.5f, 0.4f);
        Dungeons.crystalliumPlainsBiome = new BiomeCrystalliumPlains(Dungeons.crystalliumPlainsBiomeId).setTemperatureRainfall(0.2f, 0.0f);
        Dungeons.midnightBiome = new BiomeMidnight(Dungeons.midnightBiomeId).setTemperatureRainfall(0.2f, 0.0f);
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

        EntityRegistry.addSpawn(EntityFireflySpawner.class, 80, 4, 4, EnumCreatureType.ambient, Dungeons.midnightBiome);
        EntityRegistry.addSpawn(EntityBat.class, 40, 4, 4, EnumCreatureType.ambient, Dungeons.midnightBiome);
        EntityRegistry.addSpawn(EntityMidnightCow.class, 40, 4, 4, EnumCreatureType.monster, Dungeons.midnightBiome);
        EntityRegistry.addSpawn(EntityMidnightChicken.class, 50, 4, 4, EnumCreatureType.monster, Dungeons.midnightBiome);
        EntityRegistry.addSpawn(EntityNightMite.class, 80, 4, 4, EnumCreatureType.monster, Dungeons.midnightBiome);
        EntityRegistry.addSpawn(EntityCaveWraith.class, 70, 4, 4, EnumCreatureType.monster, Dungeons.midnightBiome);
        EntityRegistry.addSpawn(EntityNothing.class, 250, 4, 4, EnumCreatureType.monster, Dungeons.midnightBiome);
        final BiomeGenBase[] spawn = BiomeGenBase.getBiomeGenArray();
        for (int i = 0; i < spawn.length - 1; ++i) {
            if (spawn[i] != null && spawn[i] != Dungeons.crystal && spawn[i] != Dungeons.sunset && spawn[i] != Dungeons.crystalliumPlainsBiome) {
                EntityRegistry.addSpawn(EntityImp.class, 17, 4, 4, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntitySpirit.class, 15, 4, 4, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntitySkeletonWarrior.class, 17, 4, 4, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityBanditBoss.class, 7, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityTroll.class, 20, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntitySkeletalMage.class, 5, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityCyclops.class, 30, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityVoidFiend.class, 70, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityEarthGolem.class, 20, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntitySapientMiner.class, 40, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityWarlock.class, 15, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityNecro.class, 15, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntityEarthMage.class, 15, 1, 1, EnumCreatureType.monster, spawn[i]);
                EntityRegistry.addSpawn(EntitySkeletonKnight.class, 30, 1, 1, EnumCreatureType.monster, spawn[i]);
            }
        }
        EntityRegistry.removeSpawn(EntityImp.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntitySkeletalMage.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityBanditBoss.class, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.removeSpawn(EntityBanditBoss.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityTroll.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntityTroll.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityGiantZombie.class, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.removeSpawn(EntityGiantZombie.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityCyclops.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntityCyclops.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityVoidFiend.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntityVoidFiend.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityEarthGolem.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntityEarthGolem.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntitySkeletonWarrior.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntitySkeletonWarrior.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntitySpirit.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntitySapientMiner.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntitySapientMiner.class, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.removeSpawn(EntityWarlock.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityWarlock.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntitySkeletonKnight.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityNecro.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityNecro.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.removeSpawn(EntityEarthMage.class, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.removeSpawn(EntityEarthMage.class, EnumCreatureType.monster, BiomeGenBase.hell );
        EntityRegistry.addSpawn(EntityTyphoon.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.swampland);
        EntityRegistry.addSpawn(EntityTyphoon.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach);
        EntityRegistry.addSpawn(EntitySandstorm.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert);
        EntityRegistry.addSpawn(EntitySandstorm.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.desertHills);
        EntityRegistry.addSpawn(EntityDesertDragger.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert);
        EntityRegistry.addSpawn(EntityDesertDragger.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.desertHills);
        EntityRegistry.addSpawn(EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.iceMountains);
        EntityRegistry.addSpawn(EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.icePlains);
        EntityRegistry.addSpawn(EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.coldTaigaHills);
        EntityRegistry.addSpawn(EntityBlizzard.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.coldTaiga);
        EntityRegistry.addSpawn(EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.iceMountains);
        EntityRegistry.addSpawn(EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.icePlains);
        EntityRegistry.addSpawn(EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.coldTaigaHills);
        EntityRegistry.addSpawn(EntityIceMage.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.coldTaiga);
        EntityRegistry.addSpawn(EntityTornado.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.plains);
        EntityRegistry.addSpawn(EntityTornado.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.savanna);
        EntityRegistry.addSpawn(EntityHermit.class, 30, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHills);
        EntityRegistry.addSpawn(EntityHermit.class, 30, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHillsEdge);
        EntityRegistry.addSpawn(EntityHermit.class, 30, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHillsPlus);
        EntityRegistry.addSpawn(EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, BiomeGenBase.forest);
        EntityRegistry.addSpawn(EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, BiomeGenBase.forestHills);
        EntityRegistry.addSpawn(EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, BiomeGenBase.birchForest);
        EntityRegistry.addSpawn(EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, BiomeGenBase.birchForestHills);
        EntityRegistry.addSpawn(EntityBandit.class, 60, 4, 4, EnumCreatureType.monster, BiomeGenBase.roofedForest);
        EntityRegistry.addSpawn(EntityNetherPigman.class, 80, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityNetherSoul.class, 35, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityNetherGhost.class, 60, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityVampire.class, 40, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityLavaTroll.class, 20, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityLavaKnight.class, 40, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityNetherBadgerer.class, 5, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(EntityAmethystMonster.class, 240, 4, 4, EnumCreatureType.monster, Dungeons.crystal);
        EntityRegistry.addSpawn(EntityCrystalBadgerer.class, 1, 4, 4, EnumCreatureType.monster, Dungeons.crystal);
        EntityRegistry.addSpawn(EntityHannibal.class, 60, 4, 4, EnumCreatureType.monster, Dungeons.crystal);
        EntityRegistry.addSpawn(EntityCrystalliumGolem.class, 120, 4, 4, EnumCreatureType.monster, Dungeons.crystal);
        EntityRegistry.addSpawn(EntityCrystasis.class, 120, 4, 4, EnumCreatureType.monster, Dungeons.crystalliumPlainsBiome);
        EntityRegistry.addSpawn(EntityCrystalTroll.class, 40, 4, 4, EnumCreatureType.monster, Dungeons.crystalliumPlainsBiome);
        EntityRegistry.addSpawn(EntityShimmerman.class, 20, 4, 4, EnumCreatureType.monster, Dungeons.crystalliumPlainsBiome);
        EntityRegistry.addSpawn(EntityCrystox.class, 120, 4, 4, EnumCreatureType.monster, Dungeons.crystalliumPlainsBiome);
        ChestSetup.addChestItems();
    }

    @Mod.EventHandler
    public void preinit(final FMLPreInitializationEvent event) {
        File configFile = new File(event.getModConfigurationDirectory(), "Arcana_RPG.cfg");
        ModConfig modConfig = new ModConfig(configFile, event);
        FileInjector.setModConfig(modConfig);
        modConfig.initializeConfig(event);
        Dungeons.packetPipeline.initialise();
        DimensionManager.registerProviderType(Dungeons.crystalDimensionId, WorldProviderCrystal.class, false);
        DimensionManager.registerDimension(Dungeons.crystalDimensionId, Dungeons.crystalDimensionId);
        DimensionManager.registerProviderType(Dungeons.sunsetDimensionId, WorldProviderSunset.class, false);
        DimensionManager.registerDimension(Dungeons.sunsetDimensionId, Dungeons.sunsetDimensionId);
        DimensionManager.registerProviderType(Dungeons.montaneDungeonDimensionId, WorldProviderMontane.class, false);
        DimensionManager.registerDimension(Dungeons.montaneDungeonDimensionId, Dungeons.montaneDungeonDimensionId);
        DimensionManager.registerProviderType(Dungeons.crystalliumPlainsDimensionId, WorldProviderCrystalliumPlains.class, false);
        DimensionManager.registerDimension(Dungeons.crystalliumPlainsDimensionId, Dungeons.crystalliumPlainsDimensionId);
        DimensionManager.registerProviderType(Dungeons.midnightDimensionId, WorldProviderMidnight.class, false);
        DimensionManager.registerDimension(Dungeons.midnightDimensionId, Dungeons.midnightDimensionId);
        Enchantment.addToBookList(Dungeons.magicProtection);
        Enchantment.addToBookList(Dungeons.voidProtection);
        Enchantment.addToBookList(Dungeons.magicBlade);
        Enchantment.addToBookList(Dungeons.voidBlade);
        Dungeons.cblue = new Item().setTextureName(Dungeons.MODID + ":" + "blue");
        Dungeons.cyellow = new Item().setTextureName(Dungeons.MODID + ":" + "yellow");
        Dungeons.cgreen = new Item().setTextureName(Dungeons.MODID + ":" + "green");
        Dungeons.cpurple = new Item().setTextureName(Dungeons.MODID + ":" + "purple");
        Dungeons.cdarkblue = new Item().setTextureName(Dungeons.MODID + ":" + "darkblue");
        Dungeons.cgray = new Item().setTextureName(Dungeons.MODID + ":" + "grey");
        Dungeons.invisible = new Item().setTextureName(Dungeons.MODID + ":" + "invisible");
        Dungeons.cvoidrim = new Item().setTextureName(Dungeons.MODID + ":" + "voidrim");
        GameRegistry.registerItem(Dungeons.cblue, "dungeons_cblue");
        GameRegistry.registerItem(Dungeons.cyellow, "dungeons_cyellow");
        GameRegistry.registerItem(Dungeons.cgreen, "dungeons_cgreen");
        GameRegistry.registerItem(Dungeons.cpurple, "dungeons_cpurple");
        GameRegistry.registerItem(Dungeons.cdarkblue, "dungeons_cdarkblue");
        GameRegistry.registerItem(Dungeons.cgray, "dungeons_cgray");
        GameRegistry.registerItem(Dungeons.invisible, "dungeons_invisible");
        GameRegistry.registerItem(Dungeons.cvoidrim, "dungeons_cvoidrim");
        GameRegistry.registerItem(Dungeons.copper = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("copper").setTextureName(Dungeons.MODID + ":" + "copper"), "dungeons_copper");
        GameRegistry.registerItem(Dungeons.amazonite = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("amazonite").setTextureName(Dungeons.MODID + ":" + "amazonite"), "dungeons_amazonite");
        GameRegistry.registerItem(Dungeons.ruby = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("ruby").setTextureName(Dungeons.MODID + ":" + "ruby"), "dungeons_ruby");
        GameRegistry.registerItem(Dungeons.silver = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("silver").setTextureName(Dungeons.MODID + ":" + "silver"), "dungeons_silver");
        GameRegistry.registerItem(Dungeons.castIron = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("castiron").setTextureName(Dungeons.MODID + ":" + "castiron"), "dungeons_castiron");
        GameRegistry.registerItem(Dungeons.bedrock = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("bedrock").setTextureName(Dungeons.MODID + ":" + "bedrockchunk"), "dungeons_bedrock");
        GameRegistry.registerItem(Dungeons.lithium = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("lithium").setTextureName(Dungeons.MODID + ":" + "lithium"), "dungeons_lithium");
        GameRegistry.registerItem(Dungeons.beefstew = new ItemSoup(9).setUnlocalizedName("beefstew").setTextureName(Dungeons.MODID + ":" + "stew"), "dungeons_beefstew");
        GameRegistry.registerItem(Dungeons.entityEnrager = new ItemEntityEnrager().setCreativeTab(Dungeons.Materials).setUnlocalizedName("entityEnrager").setTextureName(Dungeons.MODID + ":" + "entityenrager"), "dungeons_entityEnrager");
        GameRegistry.registerItem(Dungeons.entityDestroyer = new ItemEntityDestroyer().setCreativeTab(Dungeons.Materials).setUnlocalizedName("entityDestroyer").setTextureName(Dungeons.MODID + ":" + "entitydestroyer"), "dungeons_entityDestroyer");
        GameRegistry.registerItem(Dungeons.amethyst = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("amethyst").setTextureName(Dungeons.MODID + ":" + "amethyst"), "dungeons_amethyst");
        GameRegistry.registerItem(Dungeons.netherSteel = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("netherSteel").setTextureName(Dungeons.MODID + ":" + "nethersteel"), "dungeons_netherSteel");
        GameRegistry.registerItem(Dungeons.netherSteelShards = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("netherSteelShards").setTextureName(Dungeons.MODID + ":" + "flakeynethersteel"), "dungeons_netherSteelShards");
        GameRegistry.registerItem(Dungeons.rawTrollMeat = new ItemFood(3, 1.0f, true).setCreativeTab(Dungeons.Materials).setUnlocalizedName("rawTrollMeat").setTextureName(Dungeons.MODID + ":" + "rawtrollmeat"), "dungeons_rawTrollMeat");
        GameRegistry.registerItem(Dungeons.cookedTrollMeat = new ItemFood(9, 4.0f, true).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0f).setCreativeTab(Dungeons.Materials).setUnlocalizedName("cookedTrollMeat").setTextureName(Dungeons.MODID + ":" + "trollmeat"), "dungeons_cookedTrollMeat");
        GameRegistry.registerItem(Dungeons.corruptedSoul = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("corruptedSoul").setTextureName(Dungeons.MODID + ":" + "corruptedsoul"), "dungeons_corruptedSoul");
        GameRegistry.registerItem(Dungeons.iceRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("iceRod").setTextureName(Dungeons.MODID + ":" + "icyrod").setFull3D(), "dungeons_iceRod");
        GameRegistry.registerItem(Dungeons.waterRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("waterRod").setTextureName(Dungeons.MODID + ":" + "waterrod"), "dungeons_waterRod");
        GameRegistry.registerItem(Dungeons.stormRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("stormRod").setTextureName(Dungeons.MODID + ":" + "stormrod"), "dungeons_stormRod");
        GameRegistry.registerItem(Dungeons.sandRod = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("sandRod").setTextureName(Dungeons.MODID + ":" + "sandyrod"), "dungeons_sandRod");
        GameRegistry.registerItem(Dungeons.netherHoe = new ItemNetherHoe(this.NETHERSTEEL).setCreativeTab(Dungeons.Materials).setUnlocalizedName("netherHoe").setTextureName(Dungeons.MODID + ":" + "netherhoe"), "dungeons_netherHoe");
        GameRegistry.registerItem(Dungeons.metalCoin = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("metalCoin").setTextureName(Dungeons.MODID + ":" + "metalcoin"), "dungeons_metalCoin");
        GameRegistry.registerItem(Dungeons.magicCoin = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magicCoin").setTextureName(Dungeons.MODID + ":" + "magiccoin"), "dungeons_magicCoin");
        GameRegistry.registerItem(Dungeons.voidCoin = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("voidCoin").setTextureName(Dungeons.MODID + ":" + "voidcoin"), "dungeons_voidCoin");
        GameRegistry.registerItem(Dungeons.sunsetOrb = new ItemSunsetOrb().setCreativeTab(Dungeons.Key).setMaxStackSize(1).setUnlocalizedName("sunsetOrb").setTextureName(Dungeons.MODID + ":" + "sunsetorb"), "dungeons_sunsetOrb");
        GameRegistry.registerItem(Dungeons.corruptedMagicOrb = new ItemCorruptedMagicOrb().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("corruptedMagicOrb").setTextureName(Dungeons.MODID + ":" + "corruptedmagicorb"), "dungeons_corruptedMagicOrb");
        GameRegistry.registerItem(Dungeons.corruptedNetherSoul = new ItemCorruptedNetherSoul().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("corruptedNetherSoul").setTextureName(Dungeons.MODID + ":" + "corruptednethersoul"), "dungeons_corruptedNetherSoul");
        GameRegistry.registerItem(Dungeons.cursedStone = new ItemCursedStone().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("cursedStone").setTextureName(Dungeons.MODID + ":" + "cursedstone"), "dungeons_cursedStone");
        GameRegistry.registerItem(Dungeons.magicPotion = new ItemMagicPotion().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magicPotion").setTextureName(Dungeons.MODID + ":" + "magicpotion"), "dungeons_magicPotion");
        GameRegistry.registerItem(Dungeons.magicPotion2 = new ItemMagicPotion().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magicPotion2").setTextureName(Dungeons.MODID + ":" + "magicpotion2"), "dungeons_magicPotion2");
        GameRegistry.registerItem(Dungeons.crystallium = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("crystallium").setTextureName(Dungeons.MODID + ":" + "crystallium"), "dungeons_crystallium");
        GameRegistry.registerItem(Dungeons.dungeonPiece1 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece1").setTextureName(Dungeons.MODID + ":" + "dungeonpiece1"), "dungeons_dungeonPiece1");
        GameRegistry.registerItem(Dungeons.dungeonPiece2 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece2").setTextureName(Dungeons.MODID + ":" + "dungeonpiece2"), "dungeons_dungeonPiece2");
        GameRegistry.registerItem(Dungeons.dungeonPiece3 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece3").setTextureName(Dungeons.MODID + ":" + "dungeonpiece3"), "dungeons_dungeonPiece3");
        GameRegistry.registerItem(Dungeons.dungeonPiece4 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece4").setTextureName(Dungeons.MODID + ":" + "dungeonpiece4"), "dungeons_dungeonPiece4");
        GameRegistry.registerItem(Dungeons.dungeonPiece5 = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("dungeonPiece5").setTextureName(Dungeons.MODID + ":" + "dungeonpiece5"), "dungeons_dungeonPiece5");
        GameRegistry.registerItem(Dungeons.dungeonDimensionSpawner = new ItemDungeonDimensionSpawner().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("dungeonDimensionSpawner").setTextureName(Dungeons.MODID + ":" + "cliffhanger"), "dungeonDimensionSpawner");
        GameRegistry.registerItem(Dungeons.whiskey = new ItemAle().setCreativeTab(Dungeons.Materials).setUnlocalizedName("whiskey").setTextureName(Dungeons.MODID + ":" + "whiskey"), "dungeons_whiskey");
        GameRegistry.registerItem(Dungeons.gingerAle = new ItemAle().setCreativeTab(Dungeons.Materials).setUnlocalizedName("gingerAle").setTextureName(Dungeons.MODID + ":" + "gingerale"), "dungeons_gingerAle");
        GameRegistry.registerItem(Dungeons.rootBeer = new ItemAle().setCreativeTab(Dungeons.Materials).setUnlocalizedName("rootBeer").setTextureName(Dungeons.MODID + ":" + "rootbeer"), "dungeons_rootBeer");
        GameRegistry.registerItem(Dungeons.blackIronScraps = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("blackIronScraps").setTextureName(Dungeons.MODID + ":" + "blackironscraps"), "dungeons_blackIronScraps");
        GameRegistry.registerItem(Dungeons.blackIron = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("blackIron").setTextureName(Dungeons.MODID + ":" + "blackiron"), "dungeons_blackIron");
        GameRegistry.registerItem(Dungeons.arcaneGem = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("arcaneGem").setTextureName(Dungeons.MODID + ":" + "arcanegem"), "dungeons_arcaneGem");
        GameRegistry.registerItem(Dungeons.redKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("redKey").setTextureName(Dungeons.MODID + ":" + "redkey"), "dungeons_redKey");
        GameRegistry.registerItem(Dungeons.blueKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("blueKey").setTextureName(Dungeons.MODID + ":" + "bluekey"), "dungeons_blueKey");
        GameRegistry.registerItem(Dungeons.blackKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("blackKey").setTextureName(Dungeons.MODID + ":" + "blackkey"), "dungeons_blackKey");
        GameRegistry.registerItem(Dungeons.yellowKey = new Item().setCreativeTab(Dungeons.Key).setUnlocalizedName("yellowKey").setTextureName(Dungeons.MODID + ":" + "yellowkey"), "dungeons_yellowKey");
        GameRegistry.registerItem(Dungeons.magirockCrystal = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magirockCrystal").setTextureName(Dungeons.MODID + ":" + "magirockcrystal"), "dungeons_magirockCrystal");
        GameRegistry.registerItem(Dungeons.magirockChunk = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magirockChunk").setTextureName(Dungeons.MODID + ":" + "magirockchunk"), "dungeons_magirockChunk");
        GameRegistry.registerItem(Dungeons.magirockCharge = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("magirockCharge").setTextureName(Dungeons.MODID + ":" + "magirockcharge"), "dungeons_magirockCharge");
        GameRegistry.registerItem(Dungeons.voidrockCrystal = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("voidrockCrystal").setTextureName(Dungeons.MODID + ":" + "voidrockcrystal"), "dungeons_voidrockCrystal");
        GameRegistry.registerItem(Dungeons.voidrockChunk = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("voidrockChunk").setTextureName(Dungeons.MODID + ":" + "voidrockchunk"), "dungeons_voidrockChunk");
        GameRegistry.registerItem(Dungeons.magicalOrb = new ItemMagicalOrb().setMaxStackSize(1).setCreativeTab(Dungeons.Key).setUnlocalizedName("magicalOrb").setTextureName(Dungeons.MODID + ":" + "magicalorb"), "dungeons_magicalOrb");
        Dungeons.copperhelmet = new ItemCopperArmor(this.ACOPPER, 0, 0).setUnlocalizedName("copperhelmet").setTextureName(Dungeons.MODID + ":" + "copperhelmet");
        Dungeons.copperchestplate = new ItemCopperArmor(this.ACOPPER, 1, 1).setUnlocalizedName("copperchestplate").setTextureName(Dungeons.MODID + ":" + "copperchestplate");
        Dungeons.copperleggings = new ItemCopperArmor(this.ACOPPER, 2, 2).setUnlocalizedName("copperleggings").setTextureName(Dungeons.MODID + ":" + "copperleggings");
        Dungeons.copperboots = new ItemCopperArmor(this.ACOPPER, 3, 3).setUnlocalizedName("copperboots").setTextureName(Dungeons.MODID + ":" + "copperboots");
        GameRegistry.registerItem(Dungeons.copperhelmet, "dungeons_copperhelmet");
        GameRegistry.registerItem(Dungeons.copperchestplate, "dungeons_copperchestplate");
        GameRegistry.registerItem(Dungeons.copperleggings, "dungeons_copperleggings");
        GameRegistry.registerItem(Dungeons.copperboots, "dungeons_copperboots");
        Dungeons.coppersword = new ItemCopperSword(this.COPPER).setUnlocalizedName("coppersword").setTextureName(Dungeons.MODID + ":" + "coppersword");
        Dungeons.copperaxe = new ItemCopperAxe(this.COPPER).setUnlocalizedName("copperaxe").setTextureName(Dungeons.MODID + ":" + "copperaxe");
        Dungeons.copperpickaxe = new ItemCopperPickaxe(this.COPPER).setUnlocalizedName("copperpickaxe").setTextureName(Dungeons.MODID + ":" + "copperpickaxe");
        Dungeons.coppershovel = new ItemCopperSpade(this.COPPER).setUnlocalizedName("coppershovel").setTextureName(Dungeons.MODID + ":" + "coppershovel");
        Dungeons.copperhoe = new ItemHoe(this.COPPER).setUnlocalizedName("copperhoe").setTextureName(Dungeons.MODID + ":" + "copperhoe");
        GameRegistry.registerItem(Dungeons.coppersword, "dungeons_coppersword");
        GameRegistry.registerItem(Dungeons.copperaxe, "dungeons_copperaxe");
        GameRegistry.registerItem(Dungeons.copperpickaxe, "dungeons_copperpickaxe");
        GameRegistry.registerItem(Dungeons.coppershovel, "dungeons_coppershovel");
        GameRegistry.registerItem(Dungeons.copperhoe, "dungeons_copperhoe");
        Dungeons.amazoniteHelmet = new ItemAmazoniteArmor(this.AAMAZONITE, 0, 0, 1, 0).setUnlocalizedName("amazonitehelmet").setTextureName(Dungeons.MODID + ":" + "amazonitehelmet");
        Dungeons.amazoniteChestplate = new ItemAmazoniteArmor(this.AAMAZONITE, 1, 1, 2, 0).setUnlocalizedName("amazonitechestplate").setTextureName(Dungeons.MODID + ":" + "amazonitechestplate");
        Dungeons.amazoniteLeggings = new ItemAmazoniteArmor(this.AAMAZONITE, 2, 2, 2, 0).setUnlocalizedName("amazoniteleggings").setTextureName(Dungeons.MODID + ":" + "amazoniteleggings");
        Dungeons.amazoniteBoots = new ItemAmazoniteArmor(this.AAMAZONITE, 3, 3, 0, 0).setUnlocalizedName("amazoniteboots").setTextureName(Dungeons.MODID + ":" + "amazoniteboots");
        GameRegistry.registerItem(Dungeons.amazoniteHelmet, "dungeons_amazonitehelmet");
        GameRegistry.registerItem(Dungeons.amazoniteChestplate, "dungeons_amazonitechestplate");
        GameRegistry.registerItem(Dungeons.amazoniteLeggings, "dungeons_amazoniteleggings");
        GameRegistry.registerItem(Dungeons.amazoniteBoots, "dungeons_amazoniteboots");
        Dungeons.rubyHelmet = new ItemRubyArmor(this.ARUBY, 0, 0, 1, 0).setUnlocalizedName("rubyhelmet").setTextureName(Dungeons.MODID + ":" + "rubyhelmet");
        Dungeons.rubyChestplate = new ItemRubyArmor(this.ARUBY, 1, 1, 3, 0).setUnlocalizedName("rubychestplate").setTextureName(Dungeons.MODID + ":" + "rubychestplate");
        Dungeons.rubyLeggings = new ItemRubyArmor(this.ARUBY, 2, 2, 2, 0).setUnlocalizedName("rubyleggings").setTextureName(Dungeons.MODID + ":" + "rubyleggings");
        Dungeons.rubyBoots = new ItemRubyArmor(this.ARUBY, 3, 3, 1, 0).setUnlocalizedName("rubyboots").setTextureName(Dungeons.MODID + ":" + "rubyboots");
        GameRegistry.registerItem(Dungeons.rubyHelmet, "dungeons_rubyhelmet");
        GameRegistry.registerItem(Dungeons.rubyChestplate, "dungeons_rubychestplate");
        GameRegistry.registerItem(Dungeons.rubyLeggings, "dungeons_rubyleggings");
        GameRegistry.registerItem(Dungeons.rubyBoots, "dungeons_rubyboots");
        Dungeons.rubySword = new ItemStandardMagicSword(this.RUBY, 2).setUnlocalizedName("rubysword").setTextureName(Dungeons.MODID + ":" + "rubysword");
        Dungeons.rubyAxe = new ItemCopperAxe(this.RUBY).setUnlocalizedName("rubyaxe").setTextureName(Dungeons.MODID + ":" + "rubyaxe");
        Dungeons.rubyPickaxe = new ItemCopperPickaxe(this.RUBY).setUnlocalizedName("rubypickaxe").setTextureName(Dungeons.MODID + ":" + "rubypickaxe");
        Dungeons.rubyShovel = new ItemCopperSpade(this.RUBY).setUnlocalizedName("rubyshovel").setTextureName(Dungeons.MODID + ":" + "rubyshovel");
        GameRegistry.registerItem(Dungeons.rubySword, "dungeons_rubysword");
        GameRegistry.registerItem(Dungeons.rubyAxe, "dungeons_rubyaxe");
        GameRegistry.registerItem(Dungeons.rubyPickaxe, "dungeons_rubypickaxe");
        GameRegistry.registerItem(Dungeons.rubyShovel, "dungeon_srubyshovel");
        Dungeons.silverHelmet = new ItemSilverArmor(this.ASILVER, 0, 0, 2, 0).setUnlocalizedName("silverhelmet").setTextureName(Dungeons.MODID + ":" + "silverhelmet");
        Dungeons.silverChestplate = new ItemSilverArmor(this.ASILVER, 1, 1, 4, 2).setUnlocalizedName("silverchestplate").setTextureName(Dungeons.MODID + ":" + "silverchestplate");
        Dungeons.silverLeggings = new ItemSilverArmor(this.ASILVER, 2, 2, 4, 1).setUnlocalizedName("silverleggings").setTextureName(Dungeons.MODID + ":" + "silverleggings");
        Dungeons.silverBoots = new ItemSilverArmor(this.ASILVER, 3, 3, 2, 0).setUnlocalizedName("silverboots").setTextureName(Dungeons.MODID + ":" + "silverboots");
        GameRegistry.registerItem(Dungeons.silverHelmet, "dungeons_silverhelmet");
        GameRegistry.registerItem(Dungeons.silverChestplate, "dungeons_silverchestplate");
        GameRegistry.registerItem(Dungeons.silverLeggings, "dungeons_silverleggings");
        GameRegistry.registerItem(Dungeons.silverBoots, "dungeons_silverboots");
        Dungeons.bedrockHelmet = new ItemBedrockArmor(this.ABEDROCK, 0, 0, 2, 1).setUnlocalizedName("bedrockhelmet").setTextureName(Dungeons.MODID + ":" + "bedrockhelmet");
        Dungeons.bedrockChestplate = new ItemBedrockArmor(this.ABEDROCK, 1, 1, 3, 3).setUnlocalizedName("bedrockchestplate").setTextureName(Dungeons.MODID + ":" + "bedrockchestplate");
        Dungeons.bedrockLeggings = new ItemBedrockArmor(this.ABEDROCK, 2, 2, 3, 2).setUnlocalizedName("bedrockleggings").setTextureName(Dungeons.MODID + ":" + "bedrockleggings");
        Dungeons.bedrockBoots = new ItemBedrockArmor(this.ABEDROCK, 3, 3, 1, 1).setUnlocalizedName("bedrockboots").setTextureName(Dungeons.MODID + ":" + "bedrockboots");
        GameRegistry.registerItem(Dungeons.bedrockHelmet, "dungeons_bedrockhelmet");
        GameRegistry.registerItem(Dungeons.bedrockChestplate, "dungeons_bedrockchestplate");
        GameRegistry.registerItem(Dungeons.bedrockLeggings, "dungeons_bedrockleggings");
        GameRegistry.registerItem(Dungeons.bedrockBoots, "dungeons_bedrockboots");
        Dungeons.lithiumHelmet = new ItemLithiumArmor(this.ALITHIUM, 0, 0, 2, 1).setUnlocalizedName("lithiumhelmet").setTextureName(Dungeons.MODID + ":" + "lithiumhelmet");
        Dungeons.lithiumChestplate = new ItemLithiumArmor(this.ALITHIUM, 1, 1, 4, 3).setUnlocalizedName("lithiumchestplate").setTextureName(Dungeons.MODID + ":" + "lithiumchestplate");
        Dungeons.lithiumLeggings = new ItemLithiumArmor(this.ALITHIUM, 2, 2, 3, 2).setUnlocalizedName("lithiumleggings").setTextureName(Dungeons.MODID + ":" + "lithiumleggings");
        Dungeons.lithiumBoots = new ItemLithiumArmor(this.ALITHIUM, 3, 3, 1, 1).setUnlocalizedName("lithiumboots").setTextureName(Dungeons.MODID + ":" + "lithiumboots");
        GameRegistry.registerItem(Dungeons.lithiumHelmet, "dungeons_lithiumhelmet");
        GameRegistry.registerItem(Dungeons.lithiumChestplate, "dungeons_lithiumchestplate");
        GameRegistry.registerItem(Dungeons.lithiumLeggings, "dungeons_lithiumleggings");
        GameRegistry.registerItem(Dungeons.lithiumBoots, "dungeons_lithiumboots");
        Dungeons.lithiumAxe = new ItemCopperAxe(this.LITHIUM).setUnlocalizedName("lithiumAxe").setTextureName(Dungeons.MODID + ":" + "lithiumaxe");
        Dungeons.lithiumPickaxe = new ItemCopperPickaxe(this.LITHIUM).setUnlocalizedName("lithiumPickaxe").setTextureName(Dungeons.MODID + ":" + "lithiumpick");
        Dungeons.lithiumShovel = new ItemCopperSpade(this.LITHIUM).setUnlocalizedName("lithiumShovel").setTextureName(Dungeons.MODID + ":" + "lithiumshovel");
        GameRegistry.registerItem(Dungeons.lithiumAxe, "dungeons_lithiumaxe");
        GameRegistry.registerItem(Dungeons.lithiumPickaxe, "dungeons_lithiumpickaxe");
        GameRegistry.registerItem(Dungeons.lithiumShovel, "dungeon_lithiumshovel");
        Dungeons.amethystAxe = new ItemCopperAxe(this.AMETHYST).setUnlocalizedName("amethystAxe").setTextureName(Dungeons.MODID + ":" + "amethystaxe");
        Dungeons.amethystPickaxe = new ItemCopperPickaxe(this.AMETHYST).setUnlocalizedName("amethystPickaxe").setTextureName(Dungeons.MODID + ":" + "amethystpick");
        Dungeons.amethystShovel = new ItemCopperSpade(this.AMETHYST).setUnlocalizedName("amethystShovel").setTextureName(Dungeons.MODID + ":" + "amethystshovel");
        GameRegistry.registerItem(Dungeons.amethystAxe, "dungeons_amethystAxe");
        GameRegistry.registerItem(Dungeons.amethystPickaxe, "dungeons_amethystPickaxe");
        GameRegistry.registerItem(Dungeons.amethystShovel, "dungeon_amethystShovel");
        Dungeons.netherSteelAxe = new ItemCopperAxe(this.NETHERSTEEL).setUnlocalizedName("netherSteelAxe").setTextureName(Dungeons.MODID + ":" + "nethersteelaxe");
        Dungeons.netherSteelPickaxe = new ItemCopperPickaxe(this.NETHERSTEEL).setUnlocalizedName("netherSteelPickaxe").setTextureName(Dungeons.MODID + ":" + "nethersteelpick");
        Dungeons.netherSteelShovel = new ItemCopperSpade(this.NETHERSTEEL).setUnlocalizedName("netherSteelShovel").setTextureName(Dungeons.MODID + ":" + "nethersteelshovel");
        GameRegistry.registerItem(Dungeons.netherSteelAxe, "dungeons_netherSteelAxe");
        GameRegistry.registerItem(Dungeons.netherSteelPickaxe, "dungeons_netherSteelPickaxe");
        GameRegistry.registerItem(Dungeons.netherSteelShovel, "dungeon_netherSteelShovel");
        Dungeons.amethystHelmet = new ItemAmethystArmor(this.AAMETHYST, 0, 0, 3, 2).setUnlocalizedName("amethystHelmet").setTextureName(Dungeons.MODID + ":" + "amethysthelmet");
        Dungeons.amethystChestplate = new ItemAmethystArmor(this.AAMETHYST, 1, 1, 5, 4).setUnlocalizedName("amethystChestplate").setTextureName(Dungeons.MODID + ":" + "amethystchest");
        Dungeons.amethystLeggings = new ItemAmethystArmor(this.AAMETHYST, 2, 2, 4, 3).setUnlocalizedName("amethystLeggings").setTextureName(Dungeons.MODID + ":" + "amethystlegs");
        Dungeons.amethystBoots = new ItemAmethystArmor(this.AAMETHYST, 3, 3, 2, 1).setUnlocalizedName("amethystBoots").setTextureName(Dungeons.MODID + ":" + "amethystboots");
        GameRegistry.registerItem(Dungeons.amethystHelmet, "dungeons_amethystHelmet");
        GameRegistry.registerItem(Dungeons.amethystChestplate, "dungeons_amethystChestplate");
        GameRegistry.registerItem(Dungeons.amethystLeggings, "dungeons_amethystLeggings");
        GameRegistry.registerItem(Dungeons.amethystBoots, "dungeons_amethystBoots");
        Dungeons.netherSkullHelmet = new ItemNetherSkullArmor(this.ANETHER, 0, 0, 2, 1).setUnlocalizedName("netherSkullHelmet").setTextureName(Dungeons.MODID + ":" + "netherskullhelmet");
        Dungeons.netherSkullChestplate = new ItemNetherSkullArmor(this.ANETHER, 1, 1, 4, 2).setUnlocalizedName("netherSkullChestplate").setTextureName(Dungeons.MODID + ":" + "netherskullchestplate");
        Dungeons.netherSkullLeggings = new ItemNetherSkullArmor(this.ANETHER, 2, 2, 3, 2).setUnlocalizedName("netherSkullLeggings").setTextureName(Dungeons.MODID + ":" + "netherskulllegs");
        Dungeons.netherSkullBoots = new ItemNetherSkullArmor(this.ANETHER, 3, 3, 2, 1).setUnlocalizedName("netherSkullBoots").setTextureName(Dungeons.MODID + ":" + "netherskullboots");
        GameRegistry.registerItem(Dungeons.netherSkullHelmet, "dungeons_netherSkullHelmet");
        GameRegistry.registerItem(Dungeons.netherSkullChestplate, "dungeons_netherSkullChestplate");
        GameRegistry.registerItem(Dungeons.netherSkullLeggings, "dungeons_netherSkullLeggings");
        GameRegistry.registerItem(Dungeons.netherSkullBoots, "dungeons_netherSkullBoots");
        Dungeons.netherSteelHelmet = new ItemNetherSteelArmor(this.ANETHERSTEEL, 0, 0, 3, 3).setUnlocalizedName("netherSteelHelmet").setTextureName(Dungeons.MODID + ":" + "nethersteelhelmet");
        Dungeons.netherSteelChestplate = new ItemNetherSteelArmor(this.ANETHERSTEEL, 1, 1, 5, 4).setUnlocalizedName("netherSteelChestplate").setTextureName(Dungeons.MODID + ":" + "nethersteelchestplate");
        Dungeons.netherSteelLeggings = new ItemNetherSteelArmor(this.ANETHERSTEEL, 2, 2, 5, 4).setUnlocalizedName("netherSteelLeggings").setTextureName(Dungeons.MODID + ":" + "nethersteellegs");
        Dungeons.netherSteelBoots = new ItemNetherSteelArmor(this.ANETHERSTEEL, 3, 3, 3, 2).setUnlocalizedName("netherSteelBoots").setTextureName(Dungeons.MODID + ":" + "nethersteelboots");
        GameRegistry.registerItem(Dungeons.netherSteelHelmet, "dungeons_netherSteelHelmet");
        GameRegistry.registerItem(Dungeons.netherSteelChestplate, "dungeons_netherSteelChestplate");
        GameRegistry.registerItem(Dungeons.netherSteelLeggings, "dungeons_netherSteelLeggings");
        GameRegistry.registerItem(Dungeons.netherSteelBoots, "dungeons_netherSteelBoots");
        Dungeons.crystalliumHelmet = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 0, 0, 3, 3).setUnlocalizedName("crystalliumHelmet").setTextureName(Dungeons.MODID + ":" + "crystalliumhelmet");
        Dungeons.crystalliumChestplate = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 1, 1, 6, 5).setUnlocalizedName("crystalliumChestplate").setTextureName(Dungeons.MODID + ":" + "crystalliumchestplate");
        Dungeons.crystalliumLeggings = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 2, 2, 6, 5).setUnlocalizedName("crystalliumLeggings").setTextureName(Dungeons.MODID + ":" + "crystalliumleggings");
        Dungeons.crystalliumBoots = new ItemCrystalliumArmor(this.ACRYSTALLIUM, 3, 3, 3, 2).setUnlocalizedName("crystalliumBoots").setTextureName(Dungeons.MODID + ":" + "crystalliumboots");
        GameRegistry.registerItem(Dungeons.crystalliumHelmet, "dungeons_crystalliumHelmet");
        GameRegistry.registerItem(Dungeons.crystalliumChestplate, "dungeons_crystalliumChestplate");
        GameRegistry.registerItem(Dungeons.crystalliumLeggings, "dungeons_crystalliumLeggings");
        GameRegistry.registerItem(Dungeons.crystalliumBoots, "dungeons_crystalliumBoots");
        Dungeons.blackIronHelmet = new ItemBlackIronArmor(this.ABLACKIRON, 0, 0, 3, 3).setUnlocalizedName("blackIronHelmet").setTextureName(Dungeons.MODID + ":" + "blackironhelmet");
        Dungeons.blackIronChestplate = new ItemBlackIronArmor(this.ABLACKIRON, 1, 1, 5, 4).setUnlocalizedName("blackIronChestplate").setTextureName(Dungeons.MODID + ":" + "blackironchestplate");
        Dungeons.blackIronLeggings = new ItemBlackIronArmor(this.ABLACKIRON, 2, 2, 5, 4).setUnlocalizedName("blackIronLeggings").setTextureName(Dungeons.MODID + ":" + "blackironleggings");
        Dungeons.blackIronBoots = new ItemBlackIronArmor(this.ABLACKIRON, 3, 3, 3, 2).setUnlocalizedName("blackIronBoots").setTextureName(Dungeons.MODID + ":" + "blackironboots");
        GameRegistry.registerItem(Dungeons.blackIronHelmet, "dungeons_blackIronHelmet");
        GameRegistry.registerItem(Dungeons.blackIronChestplate, "dungeons_blackIronChestplate");
        GameRegistry.registerItem(Dungeons.blackIronLeggings, "dungeons_blackIronLeggings");
        GameRegistry.registerItem(Dungeons.blackIronBoots, "dungeons_blackIronBoots");
        Dungeons.blindLightHelmet = new ItemBlindLightArmor(this.ANETHERSTEEL, 0, 0, 3, 3).setUnlocalizedName("blindLightHelmet").setTextureName(Dungeons.MODID + ":" + "blindlighthelmet");
        Dungeons.blindLightChestplate = new ItemBlindLightArmor(this.ANETHERSTEEL, 1, 1, 6, 5).setUnlocalizedName("blindLightChestplate").setTextureName(Dungeons.MODID + ":" + "blindlightchestplate");
        Dungeons.blindLightLeggings = new ItemBlindLightArmor(this.ANETHERSTEEL, 2, 2, 6, 5).setUnlocalizedName("blindLightLeggings").setTextureName(Dungeons.MODID + ":" + "blindlightleggings");
        Dungeons.blindLightBoots = new ItemBlindLightArmor(this.ANETHERSTEEL, 3, 3, 3, 3).setUnlocalizedName("blindLightBoots").setTextureName(Dungeons.MODID + ":" + "blindlightboots");
        GameRegistry.registerItem(Dungeons.blindLightHelmet, "dungeons_blindLightHelmet");
        GameRegistry.registerItem(Dungeons.blindLightChestplate, "dungeons_blindLightChestplate");
        GameRegistry.registerItem(Dungeons.blindLightLeggings, "dungeons_blindLightLeggings");
        GameRegistry.registerItem(Dungeons.blindLightBoots, "dungeons_blindLightBoots");
        GameRegistry.registerItem(Dungeons.heavyIronSword = new ItemCopperSword(this.HEAVYIRON).setUnlocalizedName("ironsword").setTextureName(Dungeons.MODID + ":" + "ironheavysword"), "dungeons_ironsword");
        GameRegistry.registerItem(Dungeons.heavyDiamondSword = new ItemHeavyDiamondSword(this.HEAVYDIAMOND).setUnlocalizedName("diamondsword").setTextureName(Dungeons.MODID + ":" + "heavydiamondsword").setFull3D(), "dungeons_diamond");
        GameRegistry.registerItem(Dungeons.graniteSword = new ItemCopperSword(Item.ToolMaterial.EMERALD).setUnlocalizedName("granitesword").setTextureName(Dungeons.MODID + ":" + "granitesword"), "dungeons_granitesword");
        GameRegistry.registerItem(Dungeons.amazoniteSword = new ItemStandardMagicSword(Item.ToolMaterial.STONE, 1).setUnlocalizedName("amazoniteSword").setTextureName(Dungeons.MODID + ":" + "amazonitesword"), "dungeons_amazoniteSword");
        GameRegistry.registerItem(Dungeons.castIronStar = new ItemIronStar().setUnlocalizedName("castironstar").setTextureName(Dungeons.MODID + ":" + "castironstar"), "dungeons_castironstar");
        GameRegistry.registerItem(Dungeons.castIronSword = new ItemCastIronSword(this.CASTIRON).setUnlocalizedName("castironsword").setTextureName(Dungeons.MODID + ":" + "castironsword"), "dungeons_castironsword");
        GameRegistry.registerItem(Dungeons.silverSword = new ItemSilverSword(Item.ToolMaterial.STONE, 3).setUnlocalizedName("silversword").setTextureName(Dungeons.MODID + ":" + "silversword"), "dungeons_silverSword");
        GameRegistry.registerItem(Dungeons.silverHeavySword = new ItemSilverSword(this.HEAVYSILVER, 5).setUnlocalizedName("silverheavysword").setTextureName(Dungeons.MODID + ":" + "heavysilversword"), "dungeons_silverHeavySword");
        GameRegistry.registerItem(Dungeons.rubyHeavySword = new ItemStandardMagicSword(this.HEAVYRUBY, 3).setUnlocalizedName("rubyheavysword").setTextureName(Dungeons.MODID + ":" + "heavyrubysword"), "dungeons_rubyHeavySword");
        GameRegistry.registerItem(Dungeons.copperHeavySword = new ItemCopperSword(this.CASTIRON).setUnlocalizedName("copperheavysword").setTextureName(Dungeons.MODID + ":" + "copperheavysword"), "dungeons_copperHeavySword");
        GameRegistry.registerItem(Dungeons.bedrockSword = new ItemBedrockSword(this.BEDROCK, 3).setUnlocalizedName("bedrocksword").setTextureName(Dungeons.MODID + ":" + "bedrocksword"), "dungeons_bedrockSword");
        GameRegistry.registerItem(Dungeons.heavyBedrockSword = new ItemBedrockSword(this.HEAVYBEDROCK, 5).setUnlocalizedName("heavybedrocksword").setTextureName(Dungeons.MODID + ":" + "bedrockslasher"), "dungeons_heavyBedrockSword");
        GameRegistry.registerItem(Dungeons.trollAxe = new ItemSword(this.AXE).setUnlocalizedName("trollaxe").setCreativeTab(Dungeons.Weapons).setTextureName(Dungeons.MODID + ":" + "trollaxe"), "dungeons_trollaxe");
        GameRegistry.registerItem(Dungeons.whittler = new ItemSword(this.WHITTLER).setUnlocalizedName("whittler").setCreativeTab(Dungeons.Weapons).setTextureName(Dungeons.MODID + ":" + "whittler"), "dungeons_whittler");
        GameRegistry.registerItem(Dungeons.lithiumSword = new ItemStandardMagicSword(this.LITHIUM, 5).setUnlocalizedName("lithiumsword").setTextureName(Dungeons.MODID + ":" + "lithiumsword"), "dungeons_lithiumSword");
        GameRegistry.registerItem(Dungeons.lithiumHeavySword = new ItemStandardMagicSword(this.HEAVYLITHIUM, 6).setUnlocalizedName("lithiumheavysword").setTextureName(Dungeons.MODID + ":" + "heavylithiumsword"), "dungeons_lithiumHeavySword");
        GameRegistry.registerItem(Dungeons.amethystSword = new ItemStandardMagicSword(this.AMETHYST, 5).setUnlocalizedName("amethystSword").setTextureName(Dungeons.MODID + ":" + "amethystsword"), "dungeons_amethystSword");
        GameRegistry.registerItem(Dungeons.heavyAmethystSword = new ItemHeavyAmethystSword(this.HEAVYAMETHYST, 6).setUnlocalizedName("amethystHeavySword").setTextureName(Dungeons.MODID + ":" + "heavyamethystsword"), "dungeons_amethystHeavysword");
        GameRegistry.registerItem(Dungeons.netherSkullSword = new ItemNetherSkullSword(this.AMETHYST, 3).setUnlocalizedName("netherSkullSword").setTextureName(Dungeons.MODID + ":" + "witheringsword"), "dungeons_netherSkullSword");
        GameRegistry.registerItem(Dungeons.netherSteelSword = new ItemNetherSteelSword(this.NETHERSTEEL, 5).setUnlocalizedName("netherSteelSword").setTextureName(Dungeons.MODID + ":" + "nethersteelsword"), "dungeons_netherSteelSword");
        GameRegistry.registerItem(Dungeons.heavyNetherSteelSword = new ItemNetherSteelSword(this.HEAVYNETHERSTEEL, 6).setUnlocalizedName("heavyNetherSteelSword").setTextureName(Dungeons.MODID + ":" + "heavynethersteelsword"), "dungeons_heavyNetherSteelSword");
        GameRegistry.registerItem(Dungeons.lythe = new ItemLytheSword(this.AMETHYST, 8).setUnlocalizedName("lythe").setTextureName(Dungeons.MODID + ":" + "lythe"), "dungeons_lythe");
        GameRegistry.registerItem(Dungeons.voidSword = new ItemVoidSword(this.AMETHYST, 8).setUnlocalizedName("voidSword").setTextureName(Dungeons.MODID + ":" + "voidsword"), "dungeons_voidSword");
        GameRegistry.registerItem(Dungeons.elementalSword = new ItemTripleSword(this.ELEMENTALSWORD, 4, 4).setUnlocalizedName("elementalSword").setTextureName(Dungeons.MODID + ":" + "elementalsword"), "dungeons_elementalSword");
        GameRegistry.registerItem(Dungeons.corruptedSword = new ItemNetherSteelSword(this.NETHERSTEEL, 7).setUnlocalizedName("corruptedSword").setTextureName(Dungeons.MODID + ":" + "corruptedsteelsword"), "dungeons_corruptedSword");
        GameRegistry.registerItem(Dungeons.swordOfCorruption = new ItemSwordOfCorruption(this.ELEMENTALSWORD, 4, 6).setUnlocalizedName("swordOfCorruption").setTextureName(Dungeons.MODID + ":" + "bladeofcorruption"), "dungeons_swordOfCorruption");
        GameRegistry.registerItem(Dungeons.flameSword = new ItemFireSword(this.FIRE).setUnlocalizedName("flameSword").setTextureName(Dungeons.MODID + ":" + "flamesword"), "dungeons_flameSword");
        GameRegistry.registerItem(Dungeons.netherGhastSword = new ItemBlueFireSword(this.FIRE, 2).setUnlocalizedName("netherGhastSword").setTextureName(Dungeons.MODID + ":" + "netherghastsword"), "dungeons_netherGhastSword");
        GameRegistry.registerItem(Dungeons.botSword = new ItemBotSword().setUnlocalizedName("botSword").setTextureName(Dungeons.MODID + ":" + "botsword"), "dungeons_botSword");
        GameRegistry.registerItem(Dungeons.fireClub = new ItemFireClub().setUnlocalizedName("fireClub").setTextureName(Dungeons.MODID + ":" + "fireclub"), "dungeons_fireClub");
        GameRegistry.registerItem(Dungeons.harpBow = new ItemHarpBow().setUnlocalizedName("harpBow").setTextureName(Dungeons.MODID + ":" + "harpbow"), "dungeons_harpBow");
        GameRegistry.registerItem(Dungeons.amethystLance = new ItemAmethystLance(this.AMETHYSTLANCE, 4).setUnlocalizedName("amethystLance").setTextureName(Dungeons.MODID + ":" + "amethystlance"), "dungeons_amethystLance");
        GameRegistry.registerItem(Dungeons.amethystRapier = new ItemStandardMagicSword(this.AMETHYSTRAPIER, 3).setUnlocalizedName("amethystRapier").setTextureName(Dungeons.MODID + ":" + "amethystrapier"), "dungeons_amethystRapier");
        GameRegistry.registerItem(Dungeons.mace = new ItemSword(this.AXE).setUnlocalizedName("mace").setCreativeTab(Dungeons.Weapons).setTextureName(Dungeons.MODID + ":" + "mace"), "dungeons_mace");
        GameRegistry.registerItem(Dungeons.lavaKnightSword = new ItemStandardVoidSword(this.BEDROCK, 4).setUnlocalizedName("lavaKnightSword").setTextureName(Dungeons.MODID + ":" + "lavaknightsword"), "dungeons_lavaKnightSword");
        GameRegistry.registerItem(Dungeons.steelSword = new ItemSword(this.AMETHYSTRAPIER).setCreativeTab(Dungeons.Weapons).setUnlocalizedName("steelSword").setTextureName(Dungeons.MODID + ":" + "steelsword"), "dungeons_steelSword");
        GameRegistry.registerItem(Dungeons.tornadoSword = new ItemTornadoSword(Item.ToolMaterial.EMERALD).setCreativeTab(Dungeons.Weapons).setUnlocalizedName("tornadoSword").setTextureName(Dungeons.MODID + ":" + "tornadosword"), "dungeons_tornadoSword");
        GameRegistry.registerItem(Dungeons.vampiricSword = new ItemVampiricSword(this.AXE, 3).setUnlocalizedName("vampiricSword").setTextureName(Dungeons.MODID + ":" + "vampiricblade"), "dungeons_vampiricSword");
        GameRegistry.registerItem(Dungeons.voidFiendSword = new ItemStandardVoidSword(this.AXE, 2).setUnlocalizedName("voidFiendSword").setTextureName(Dungeons.MODID + ":" + "voidFiendSword"), "dungeons_voidFiendSword");
        GameRegistry.registerItem(Dungeons.crystalSword = new ItemTripleSword(this.CRYSTAL, 4, 1).setUnlocalizedName("crystalSword").setTextureName(Dungeons.MODID + ":" + "crystalsword"), "dungeons_crystalSword");
        GameRegistry.registerItem(Dungeons.crystalHeavySword = new ItemTripleSword(this.HEAVYCRYSTAL, 6, 3).setUnlocalizedName("crystalHeavySword").setTextureName(Dungeons.MODID + ":" + "crystalheavysword"), "dungeons_crystalHeavySword");
        GameRegistry.registerItem(Dungeons.bubbleSword = new ItemBubbleSword(this.HEAVYSILVER, 3).setUnlocalizedName("bubbleSword").setTextureName(Dungeons.MODID + ":" + "bubblesword"), "dungeons_bubbleSword");
        GameRegistry.registerItem(Dungeons.valesis = new ItemValesis(this.HEAVYCRYSTAL, 7, 4).setUnlocalizedName("valesis").setTextureName(Dungeons.MODID + ":" + "valesis"), "dungeons_valesis");
        GameRegistry.registerItem(Dungeons.corruptedBow = new ItemCorruptedBow().setUnlocalizedName("corruptedBow").setTextureName(Dungeons.MODID + ":" + "corruptedbow"), "dungeons_corruptedBow");
        GameRegistry.registerItem(Dungeons.disinigrationBow = new ItemDisinigrationBow().setUnlocalizedName("disinigrationBow").setTextureName(Dungeons.MODID + ":" + "disinigrationbow"), "dungeons_disinigrationBow");
        GameRegistry.registerItem(Dungeons.torturedChainSword = new ItemStandardVoidSword(this.TCHAIN, 4).setUnlocalizedName("torturedChainSword").setTextureName(Dungeons.MODID + ":" + "torturedchainsword"), "dungeons_torturedChainSword");
        GameRegistry.registerItem(Dungeons.dungeonEyeSword = new ItemStandardMagicSword(this.TCHAIN, 6).setUnlocalizedName("dungeonEyeSword").setTextureName(Dungeons.MODID + ":" + "dungeoneyesword"), "dungeons_dungeonEyeSword");
        GameRegistry.registerItem(Dungeons.frostySword = new ItemFrostySword(this.TCHAIN, 5).setUnlocalizedName("frostySword").setTextureName(Dungeons.MODID + ":" + "frostysword"), "dungeons_frostySword");
        GameRegistry.registerItem(Dungeons.blackIronSword = new ItemStandardVoidSword(this.TCHAIN, 4).setUnlocalizedName("blackIronSword").setTextureName(Dungeons.MODID + ":" + "blackironsword"), "dungeons_blackIronSword");
        GameRegistry.registerItem(Dungeons.sunAxe = new ItemSunAxe(this.HEAVYCRYSTAL, 4, 5).setUnlocalizedName("sunAxe").setTextureName(Dungeons.MODID + ":" + "sunaxe"), "dungeons_sunAxe");
        GameRegistry.registerItem(Dungeons.magirockSword = new ItemStandardMagicSword(this.MAGIROCK, 17).setUnlocalizedName("magirockSword").setTextureName(Dungeons.MODID + ":" + "magirocksword"), "dungeons_magirockSword");
        GameRegistry.registerItem(Dungeons.exawdusSmasher = new ItemExawdusSmasher(this.EXAWDUS, 15, 3).setUnlocalizedName("exawdusSmasher").setTextureName(Dungeons.MODID + ":" + "exawdusSmasher"), "dungeons_exawdusSmasher");
        GameRegistry.registerItem(Dungeons.tomeOfMagic = new ItemMagicTome().setUnlocalizedName("tomeOfMagic").setCreativeTab(Dungeons.Key).setTextureName(Dungeons.MODID + ":" + "tomeofmagic"), "dungeons_tomeOfMagic");
        GameRegistry.registerItem(Dungeons.forceWand = new ItemForceWand().setUnlocalizedName("forceWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "forcewand"), "dungeons_forcewand");
        GameRegistry.registerItem(Dungeons.pulseWand = new ItemPulseWand().setUnlocalizedName("pulsewand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "pulsewand"), "dungeons_pulsewand");
        GameRegistry.registerItem(Dungeons.poisonWand = new ItemPoisonWand().setUnlocalizedName("poisonwand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "poisonwand"), "dungeons_poisonwand");
        GameRegistry.registerItem(Dungeons.magicWand = new ItemMagicWand().setUnlocalizedName("magicwand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "magicwand"), "dungeons_magicwand");
        GameRegistry.registerItem(Dungeons.bloodWand = new ItemBloodWand().setUnlocalizedName("bloodwand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "bloodwand"), "dungeons_bloodwand");
        GameRegistry.registerItem(Dungeons.sodbuster = new ItemSodBuster().setUnlocalizedName("sodbuster").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "sodbuster"), "dungeons_sodbuster");
        GameRegistry.registerItem(Dungeons.shimmerWand = new ItemShimmerWand().setUnlocalizedName("shimmerwand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "shimmerwand"), "dungeons_shimmerwand");
        GameRegistry.registerItem(Dungeons.metalWand = new ItemMetalWand().setUnlocalizedName("metalwand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "metalwand"), "dungeons_metalwand");
        GameRegistry.registerItem(Dungeons.growthStaff = new ItemGrowthStaff().setUnlocalizedName("growthStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "growthstaff"), "dungeons_growthStaff");
        GameRegistry.registerItem(Dungeons.inflameStaff = new ItemInflameStaff().setUnlocalizedName("inflameStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "inflamestaff"), "dungeons_inflameStaff");
        GameRegistry.registerItem(Dungeons.gravityStaff = new ItemGravityStaff().setUnlocalizedName("gravityStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "gravitystaff"), "dungeons_gravityStaff");
        GameRegistry.registerItem(Dungeons.windStaff = new ItemWindStaff().setUnlocalizedName("windStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "windstaff"), "dungeons_windStaff");
        GameRegistry.registerItem(Dungeons.speedStaff = new ItemSpeedStaff().setUnlocalizedName("speedStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "speedstaff"), "dungeons_speedStaff");
        GameRegistry.registerItem(Dungeons.magicGem = new ItemMagicGem().setUnlocalizedName("magicgem").setCreativeTab(Dungeons.Materials).setTextureName(Dungeons.MODID + ":" + "magicgem"), "dungeons_magicgem");
        GameRegistry.registerItem(Dungeons.shimmerPearl = new ItemShimmerPearl().setUnlocalizedName("shimmerPearl").setTextureName(Dungeons.MODID + ":" + "shimmerpearl_1"), "dungeons_shimmerPearl");
        GameRegistry.registerItem(Dungeons.voidWand = new ItemVoidWand().setUnlocalizedName("voidWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "voidwand"), "dungeons_voidWand");
        GameRegistry.registerItem(Dungeons.cursedWand = new ItemCursedWand().setUnlocalizedName("cursedWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "cursestaff"), "dungeons_cursedWand");
        GameRegistry.registerItem(Dungeons.chaoticWand = new ItemChaoticWand().setUnlocalizedName("chaoticWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "chaoticwand"), "dungeons_chaoticWand");
        GameRegistry.registerItem(Dungeons.hadrialWand = new ItemHadrialWand().setUnlocalizedName("hadrialWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "hadrialwand"), "dungeons_hadrialWand");
        GameRegistry.registerItem(Dungeons.ionicWand = new ItemIonicWand().setUnlocalizedName("ionicWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "ionicwand"), "dungeons_ionicWand");
        GameRegistry.registerItem(Dungeons.netherDrill = new ItemNetherDrill().setUnlocalizedName("netherDrill").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "netherdrillwand"), "dungeons_netherDrill");
        GameRegistry.registerItem(Dungeons.witherStaff = new ItemWitherStarStaff().setUnlocalizedName("witherStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "netherstarstaff"), "dungeons_witherStaff");
        GameRegistry.registerItem(Dungeons.warlockStaff = new ItemWarlockWand().setUnlocalizedName("warlockStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "warlockstaff"), "dungeons_warlockStaff");
        GameRegistry.registerItem(Dungeons.earthTome = new ItemEarthTome().setUnlocalizedName("earthTome").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "earthtome"), "dungeons_earthTome");
        GameRegistry.registerItem(Dungeons.antigravityTome = new ItemAntiGravityTome().setUnlocalizedName("antigravityTome").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "antigravitytome"), "dungeons_antigravityTome");
        GameRegistry.registerItem(Dungeons.energyTome = new ItemEnergyTome().setUnlocalizedName("energyTome").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "energytome"), "dungeons_energyTome");
        GameRegistry.registerItem(Dungeons.battleTome = new ItemBattleTome().setUnlocalizedName("battleTome").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "battletome"), "dungeons_battleTome");
        GameRegistry.registerItem(Dungeons.crecentWand = new ItemCrecentWand().setUnlocalizedName("crecentWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "crecentwand"), "dungeons_crecentWand");
        GameRegistry.registerItem(Dungeons.quakeWand = new ItemQuakeWand().setUnlocalizedName("quakeWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "quakewand"), "dungeons_quakeWand");
        GameRegistry.registerItem(Dungeons.orcWarWand = new ItemOrcWarWand().setUnlocalizedName("orcWarWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "orcwarwand"), "dungeons_orcWarWand");
        GameRegistry.registerItem(Dungeons.icefireWand = new ItemIcefireWand().setUnlocalizedName("icefireWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "icefirewand"), "dungeons_icefireWand");
        GameRegistry.registerItem(Dungeons.sapientWarWand = new ItemSapientWarWand().setUnlocalizedName("sapientWarWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "sapientwarwand"), "dungeons_sapientWarWand");
        GameRegistry.registerItem(Dungeons.deathBringerWand = new ItemDeathBringerWand().setUnlocalizedName("deathBringerWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "deathbringerwand"), "dungeons_deathBringerWand");
        GameRegistry.registerItem(Dungeons.magirockWand = new ItemMagirockWand().setUnlocalizedName("magirockWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "magirockwand"), "dungeons_magirockWand");
        GameRegistry.registerItem(Dungeons.voidrimWand = new ItemVoidrimWand().setUnlocalizedName("voidrimWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "voidrimwand"), "dungeons_voidrimWand");
        GameRegistry.registerItem(Dungeons.voidrockWand = new ItemVoidrockWand().setUnlocalizedName("voidrockWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "voidrockwand"), "dungeons_voidrockWand");
        GameRegistry.registerItem(Dungeons.fusionWand = new ItemFusionWand().setUnlocalizedName("fusionWand").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "fusionwand"), "dungeons_fusionWand");
        GameRegistry.registerItem(Dungeons.botAmulet = new ItemBotAmulet().setUnlocalizedName("botAmulet").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "botamulet"), "dungeons_botAmulet");
        GameRegistry.registerItem(Dungeons.necroticAmulet = new ItemNecroticAmulet().setUnlocalizedName("necroticAmulet").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "necroticamulet"), "dungeons_necroticAmulet");
        Dungeons.blindlightHoe = new ItemBlindlightHoe(this.BLINDLIGHT).setUnlocalizedName("blindlightHoe").setTextureName(Dungeons.MODID + ":" + "blindlighthoe");
        GameRegistry.registerItem(Dungeons.midnightBeef = new ItemFood(9, 4.0f, false).setPotionEffect(Potion.regeneration.id, 2, 1, 1.0f).setCreativeTab(Dungeons.Materials).setUnlocalizedName("midnightBeef").setTextureName(Dungeons.MODID + ":" + "midnightbeef"), "dungeons_midnightBeef");
        GameRegistry.registerItem(Dungeons.midnightBeefRaw = new ItemFood(3, 1.0f, false).setCreativeTab(Dungeons.Materials).setUnlocalizedName("midnightBeefRaw").setTextureName(Dungeons.MODID + ":" + "midnightbeefraw"), "dungeons_midnightBeefRaw");
        GameRegistry.registerItem(Dungeons.midnightCoin = new ItemMidnightCoin().setCreativeTab(Dungeons.Materials).setUnlocalizedName("midnightCoin").setTextureName(Dungeons.MODID + ":" + "midnightcoin"), "dungeons_midnightCoin");
        GameRegistry.registerItem(Dungeons.incandescentDust = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("incandescentDust").setTextureName(Dungeons.MODID + ":" + "incandescentdust"), "dungeons_incandescentDust");
        GameRegistry.registerItem(Dungeons.chamonix = new ItemChamonixSword(Item.ToolMaterial.EMERALD, 2), "dungeons_chamonix");
        GameRegistry.registerItem(Dungeons.incandescentCharge = new ItemIncandescentCharge().setCreativeTab(Dungeons.Materials).setUnlocalizedName("incandescentCharge").setTextureName(Dungeons.MODID + ":" + "incandescentCharge"), "dungeons_incandescentCharge");
        GameRegistry.registerItem(Dungeons.darkSoul = new ItemDarkSoul().setCreativeTab(Dungeons.Materials).setUnlocalizedName("darkSoul").setTextureName(Dungeons.MODID + ":" + "darksoul"), "dungeons_darkSoul");
        GameRegistry.registerItem(Dungeons.blindlightStone = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("blindlightStone").setTextureName(Dungeons.MODID + ":" + "blindlightshard"), "dungeons_blindlightStone");
        GameRegistry.registerItem(Dungeons.blindlightIngot = new Item().setCreativeTab(Dungeons.Materials).setUnlocalizedName("blindlightIngot").setTextureName(Dungeons.MODID + ":" + "blindlightingot"), "dungeons_blindlightIngot");
        GameRegistry.registerItem(Dungeons.shadowOrb = new ItemShadowOrb().setCreativeTab(Dungeons.Key).setUnlocalizedName("shadowOrb").setTextureName(Dungeons.MODID + ":" + "shadoworb"), "dungeons_shadowOrb");
        GameRegistry.registerItem(Dungeons.runeShard = new ItemRuneShard().setCreativeTab(Dungeons.Materials).setUnlocalizedName("runeShard").setTextureName(Dungeons.MODID + ":" + "runicshard"), "dungeons_runeShard");
        GameRegistry.registerItem(Dungeons.peach = new ItemFood(4, 1.0f, false).setPotionEffect(Potion.regeneration.id, 2, 1, 1.0f).setCreativeTab(Dungeons.Materials).setUnlocalizedName("peach").setTextureName(Dungeons.MODID + ":" + "peach"), "dungeons_peach");
        GameRegistry.registerItem(Dungeons.runeStone = new ItemRuneStone().setCreativeTab(Dungeons.Materials).setUnlocalizedName("runeStone").setTextureName(Dungeons.MODID + ":" + "runestone"), "dungeons_runeStone");
        GameRegistry.registerItem(Dungeons.runeSpeedStaff = new ItemRuneSpeedStaff().setUnlocalizedName("runeSpeedStaff").setCreativeTab(Dungeons.Magic).setTextureName(Dungeons.MODID + ":" + "runespeedstaff"), "dungeons_runeSpeedStaff");
        GameRegistry.registerItem(Dungeons.regenTome = new ItemMagicRegenTome().setCreativeTab(Dungeons.Magic).setUnlocalizedName("regenTome").setTextureName(Dungeons.MODID + ":" + "regentome"), "dungeons_regenTome");
        GameRegistry.registerItem(Dungeons.shadowAxe = new ItemShadowAxe(this.SHADOW, 7, 10).setUnlocalizedName("shadowAxe").setTextureName(Dungeons.MODID + ":" + "nightaxe"), "dungeons_shadowAxe");
        GameRegistry.registerItem(Dungeons.titanicTome = new ItemTitanicTome().setCreativeTab(Dungeons.Magic).setUnlocalizedName("titanicTome").setTextureName(Dungeons.MODID + ":" + "titanictome"), "dungeons_titanicTome");
        GameRegistry.registerItem(Dungeons.midnightChickenRaw = new ItemFood(3, 1.0f, false).setCreativeTab(Dungeons.Materials).setUnlocalizedName("midnightChickenRaw").setTextureName(Dungeons.MODID + ":" + "midnightchickenraw"), "dungeons_midnightChickenRaw");
        GameRegistry.registerItem(Dungeons.randomItemGiverVampire = new ItemRandomGiver(ItemRandomGiver.Vampire).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverVampire").setTextureName(Dungeons.MODID + ":" + "randomItemGiverVampire"), "dungeons_randomItemGiverVampire");
        GameRegistry.registerItem(Dungeons.randomItemGiverVoidDungeon = new ItemRandomGiver(ItemRandomGiver.VoidDungeon).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverVoidDungeon").setTextureName(Dungeons.MODID + ":" + "randomItemGiverVoidDungeon"), "dungeons_randomItemGiverVoidDungeon");
        GameRegistry.registerItem(Dungeons.randomItemGiverNetherStructure = new ItemRandomGiver(ItemRandomGiver.NetherStructure).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverNetherStructure").setTextureName(Dungeons.MODID + ":" + "randomItemGiverNetherStructure"), "dungeons_randomItemGiverNetherStructure");
        GameRegistry.registerItem(Dungeons.randomItemGiverMontaneDungeon = new ItemRandomGiver(ItemRandomGiver.MontaneDungeon).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverMontaneDungeon").setTextureName(Dungeons.MODID + ":" + "randomItemGiverMontaneDungeon"), "dungeons_randomItemGiverMontaneDungeon");
        GameRegistry.registerItem(Dungeons.randomItemGiverMontagneRiche = new ItemRandomGiver(ItemRandomGiver.MontagneRiche).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverMontagneRiche").setTextureName(Dungeons.MODID + ":" + "randomItemGiverMontagneRiche"), "dungeons_randomItemGiverMontagneRiche");
        GameRegistry.registerItem(Dungeons.randomItemGiverBeholder = new ItemRandomGiver(ItemRandomGiver.Beholder).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverBeholder").setTextureName(Dungeons.MODID + ":" + "randomItemGiverBeholder"), "dungeons_randomItemGiverBeholder");
        GameRegistry.registerItem(Dungeons.randomItemGiverdungeonChest = new ItemRandomGiver(ItemRandomGiver.DungeonChest).setCreativeTab(Dungeons.Magic).setUnlocalizedName("randomItemGiverdungeonChest").setTextureName(Dungeons.MODID + ":" + "randomItemGiverdungeonChest"), "dungeons_randomItemGiverdungeonChest");
        GameRegistry.registerBlock(Dungeons.midnightMossStone = new BlockOre().setBlockName("midnightMossStone").setBlockTextureName("gibby_dungeons" + ":" + "midnightmossstone").setCreativeTab(Dungeons.Blocks).setLightLevel(1.0f).setLightOpacity(200), "dungeons_midnightMossStone");
        GameRegistry.registerBlock(Dungeons.midnightBush = new BlockMidnightFoliage().setBlockName("midnightBush").setBlockTextureName(Dungeons.MODID + ":" + "midnightBush").setCreativeTab(Dungeons.Blocks), "dungeons_midnightBush");
        GameRegistry.registerBlock(Dungeons.midnightShortgrass = new BlockMidnightFoliage().setBlockName("midnightShortgrass").setBlockTextureName(Dungeons.MODID + ":" + "midnightShortgrass").setCreativeTab(Dungeons.Blocks), "dungeons_midnightShortgrass");
        GameRegistry.registerBlock(Dungeons.midnightScrub = new BlockMidnightScrub().setBlockName("midnightScrub").setBlockTextureName(Dungeons.MODID + ":" + "midnightScrub").setCreativeTab(Dungeons.Blocks), "dungeons_midnightScrub");
        GameRegistry.registerBlock(Dungeons.midnightScrubLight = new BlockMidnightScrubLight().setBlockName("midnightScrubLight").setBlockTextureName(Dungeons.MODID + ":" + "midnightScrubLight").setLightLevel(0.5f), "dungeons_midnightScrubLight");
        GameRegistry.registerBlock(Dungeons.midnightStem = new BlockMidnightFoliage().setBlockName("midnightStem").setBlockTextureName(Dungeons.MODID + ":" + "midnightStem").setCreativeTab(Dungeons.Blocks), "dungeons_midnightStem");
        GameRegistry.registerBlock(Dungeons.blueGlow = new BlockOre().setBlockName("blueGlow").setBlockTextureName(Dungeons.MODID + ":" + "blueglow").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setLightOpacity(200).setHardness(20.0f), "dungeons_blueGlow");
        GameRegistry.registerBlock(Dungeons.nightCounter = new BlockOre().setBlockName("nightCounter").setBlockTextureName(Dungeons.MODID + ":" + "nightcounter").setCreativeTab(Dungeons.Blocks).setHardness(20.0f), "dungeons_nightCounter");
        GameRegistry.registerBlock(Dungeons.midnightFence = new BlockMidnightFence("nightcounter", Material.rock).setBlockName("midnightFence").setBlockTextureName(Dungeons.MODID + ":" + "nightcounter").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setHardness(20.0f).setResistance(10.0f), "dungeons_midnightFence");
        GameRegistry.registerBlock(Dungeons.shadowAltar = new BlockShadowAltar().setBlockName("shadowAltar").setBlockTextureName(Dungeons.MODID + ":" + "shadowaltar").setCreativeTab(Dungeons.Key).setLightLevel(0.2f).setHardness(20.0f).setResistance(10.0f), "dungeons_shadowAltar");
        GameRegistry.registerBlock(Dungeons.lightBlueGlow = new BlockOre().setBlockName("lightBlueGlow").setBlockTextureName(Dungeons.MODID + ":" + "lightblueglow").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setLightOpacity(200).setHardness(20.0f), "dungeons_lightBlueGlow");
        GameRegistry.registerBlock(Dungeons.midnightPortal = new BlockMidnightPortal().setBlockName("portalMidnight").setBlockTextureName(Dungeons.MODID + ":" + "portalmidnight").setCreativeTab(Dungeons.Blocks), "dungeons_portalMidnight");
        GameRegistry.registerBlock(Dungeons.darkBlueGlow = new BlockOre().setBlockName("darkBlueGlow").setBlockTextureName(Dungeons.MODID + ":" + "darkblueglow").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setLightOpacity(200).setHardness(30.0f), "dungeons_darkBlueGlow");
        GameRegistry.registerBlock(Dungeons.blueBrick = new BlockOre().setBlockName("blueBrick").setBlockTextureName(Dungeons.MODID + ":" + "bluebrick").setCreativeTab(Dungeons.Blocks).setHardness(20.0f), "dungeons_blueBrick");
        GameRegistry.registerBlock(Dungeons.greenGlow = new BlockGreenGlow().setBlockName("greenGlow").setBlockTextureName(Dungeons.MODID + ":" + "greenglow").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setLightOpacity(200).setHardness(20.0f), "dungeons_greenGlow");
        GameRegistry.registerBlock(Dungeons.nightLight = new BlockOre().setBlockName("nightLight").setBlockTextureName(Dungeons.MODID + ":" + "nightlight").setCreativeTab(Dungeons.Blocks).setLightLevel(0.7f).setLightOpacity(200).setHardness(20.0f), "dungeons_nightLight");
        GameRegistry.registerBlock(Dungeons.dungeonSpawner = new BlockDungeonSpawner(Material.rock).setBlockName("dungeonSpawner").setBlockTextureName(Dungeons.MODID + ":" + "dungeonspawner"), "dungeons_dungeonSpawner");
        GameRegistry.registerBlock(Dungeons.dungeonSpawnerRepeater = new BlockDungeonSpawnerRepeater(Material.rock).setBlockName("dungeonSpawnerRepeater").setBlockTextureName(Dungeons.MODID + ":" + "dungeonspawnerrepeater"), "dungeons_dungeonSpawnerRepeater");
        GameRegistry.registerBlock(Dungeons.copperore = new BlockCopper().setBlockName("copperore").setBlockTextureName(Dungeons.MODID + ":" + "copperore"), "dungeons_copperore");
        GameRegistry.registerBlock(Dungeons.amazoniteOre = new BlockAmazoniteOre().setBlockName("amazoniteOre").setBlockTextureName(Dungeons.MODID + ":" + "amazoniteore"), "dungeons_amazoniteOre");
        GameRegistry.registerBlock(Dungeons.rubyOre = new BlockRubyOre().setBlockName("rubyore").setBlockTextureName(Dungeons.MODID + ":" + "rubyore"), "dungeons_rubyOre");
        GameRegistry.registerBlock(Dungeons.silverOre = new BlockSilverOre().setBlockName("silverore").setBlockTextureName(Dungeons.MODID + ":" + "silverore"), "dungeons_silverOre");
        GameRegistry.registerBlock(Dungeons.rubyBlock = new BlockOre().setBlockName("rubyblock").setBlockTextureName(Dungeons.MODID + ":" + "rubyblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_rubyBlock");
        GameRegistry.registerBlock(Dungeons.copperBlock = new BlockOre().setBlockName("copperblock").setBlockTextureName(Dungeons.MODID + ":" + "copperblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_copperBlock");
        GameRegistry.registerBlock(Dungeons.bedrockOre = new BlockBedrockOre().setBlockName("bedrockore").setBlockTextureName(Dungeons.MODID + ":" + "bedrockore"), "dungeons_bedrockOre");
        GameRegistry.registerBlock(Dungeons.lithiumOre = new BlockLithiumOre().setBlockName("lithiumOre").setBlockTextureName(Dungeons.MODID + ":" + "lithiumore").setCreativeTab(Dungeons.Blocks), "dungeons_lithiumOre");
        GameRegistry.registerBlock(Dungeons.bleachedStone = new BlockOre().setBlockName("bleachedStone").setBlockTextureName(Dungeons.MODID + ":" + "bleachedcobblestone").setCreativeTab(Dungeons.Blocks).setHardness(7.0f).setResistance(10.0f), "dungeons_bleachedStone");
        GameRegistry.registerBlock(Dungeons.redBlock = new BlockRedLamp(true).setBlockName("redBlock").setBlockTextureName(Dungeons.MODID + ":" + "redbot_lamp_on").setCreativeTab(Dungeons.Blocks).setHardness(4.0f).setResistance(7.0f), "dungeons_redBlock");
        GameRegistry.registerBlock(Dungeons.blueBlock = new BlockBlueLamp(true).setBlockName("blueBlock").setBlockTextureName(Dungeons.MODID + ":" + "bluebot_lamp_on").setHardness(4.0f).setCreativeTab(Dungeons.Blocks).setResistance(7.0f), "dungeons_blueBlock");
        GameRegistry.registerBlock(Dungeons.silverBlock = new BlockOre().setBlockName("silverBlock").setBlockTextureName(Dungeons.MODID + ":" + "silverblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_silverBlock");
        GameRegistry.registerBlock(Dungeons.lithiumBlock = new BlockOre().setBlockName("lithiumBlock").setBlockTextureName(Dungeons.MODID + ":" + "lithiumblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_lithiumBlock");
        GameRegistry.registerBlock(Dungeons.amethystOre = new BlockAmethystOre().setBlockName("amethystOre").setBlockTextureName(Dungeons.MODID + ":" + "amethystore").setCreativeTab(Dungeons.Blocks), "dungeons_amethystOre");
        GameRegistry.registerBlock(Dungeons.amethystBlock = new BlockOre().setBlockName("amethystBlock").setBlockTextureName(Dungeons.MODID + ":" + "amethystblock").setCreativeTab(Dungeons.Blocks), "dungeons_amethystBlock");
        GameRegistry.registerBlock(Dungeons.netherSteelOre = new BlockNetherSteelOre().setBlockName("netherSteelOre").setBlockTextureName(Dungeons.MODID + ":" + "nethersteelore").setCreativeTab(Dungeons.Blocks), "dungeons_netherSteelOre");
        GameRegistry.registerBlock(Dungeons.netherSteelBlock = new BlockOre().setBlockName("netherSteelBlock").setBlockTextureName(Dungeons.MODID + ":" + "nethersteelblock").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_netherSteelBlock");
        GameRegistry.registerBlock(Dungeons.voidBrick = new BlockOre().setBlockName("voidBrick").setBlockTextureName(Dungeons.MODID + ":" + "voidbrick").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_voidBrick");
        GameRegistry.registerBlock(Dungeons.blackBrick = new BlockOre().setBlockName("blackBrick").setBlockTextureName(Dungeons.MODID + ":" + "blackbrick").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_blackBrick");
        GameRegistry.registerBlock(Dungeons.amethystStone = new BlockAmethystStone().setBlockName("amethystStone").setBlockTextureName(Dungeons.MODID + ":" + "amethyststone").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_amethystStone");
        GameRegistry.registerBlock(Dungeons.amethystCrystalized = new BlockOre().setBlockName("amethystCrystalized").setBlockTextureName(Dungeons.MODID + ":" + "crystalizedamethyststone").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_amethystCrystalized");
        GameRegistry.registerBlock(Dungeons.amethystCracks = new BlockOre().setBlockName("amethystCracks").setBlockTextureName(Dungeons.MODID + ":" + "amethystcracks").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(20.0f), "dungeons_amethystCracks");
        GameRegistry.registerBlock(Dungeons.crystalOre = new BlockCrystalOre().setBlockName("crystalOre").setBlockTextureName(Dungeons.MODID + ":" + "crystalore").setCreativeTab(Dungeons.Blocks), "dungeons_crystalOre");
        GameRegistry.registerBlock(Dungeons.portalAmethyst = new BlockAmethystPortal().setBlockName("portalAmethyst").setCreativeTab(Dungeons.Blocks), "dungeons_portalAmethyst");
        GameRegistry.registerBlock(Dungeons.portalSunset = new BlockSunsetPortal().setBlockName("portalSunset").setCreativeTab(Dungeons.Blocks).setBlockTextureName(Dungeons.MODID + ":" + "sunsetportal2"), "dungeons_portalSunset");
        GameRegistry.registerBlock(Dungeons.portalMontane = new BlockMontanePortal().setBlockName("portalMontane").setCreativeTab(Dungeons.Blocks).setBlockTextureName(Dungeons.MODID + ":" + "portalmontane"), "dungeons_portalMontane");
        GameRegistry.registerBlock(Dungeons.portalCrystalPlains = new BlockCrystalPlainsPortal().setBlockName("portalCrystalPlains").setBlockTextureName(Dungeons.MODID + ":" + "portalcrystalliumplains").setCreativeTab(Dungeons.Blocks), "dungeons_portalCrystalPlains");
        GameRegistry.registerBlock(Dungeons.crystalWeed = new BlockCrystalFoliage().setBlockName("crystalWeed").setBlockTextureName(Dungeons.MODID + ":" + "crystalweeds").setCreativeTab(Dungeons.Blocks), "dungeons_crystalWeed");
        GameRegistry.registerBlock(Dungeons.crystalStem = new BlockCrystalFoliage().setBlockName("crystalStem").setBlockTextureName(Dungeons.MODID + ":" + "crystalstems").setCreativeTab(Dungeons.Blocks), "dungeons_crystalStem");
        GameRegistry.registerBlock(Dungeons.ghostRose = new BlockCrystalFoliage().setBlockName("ghostRose").setBlockTextureName(Dungeons.MODID + ":" + "ghostrose").setCreativeTab(Dungeons.Blocks), "dungeons_ghostRose");
        GameRegistry.registerBlock(Dungeons.yellowTippedGrass = new BlockCrystalFoliage().setBlockName("yellowTippedGrass").setBlockTextureName(Dungeons.MODID + ":" + "yellowtippedgrass").setCreativeTab(Dungeons.Blocks), "dungeons_yellowTippedGrass");
        GameRegistry.registerBlock(Dungeons.shimmerFlower = new BlockCrystalFoliage().setBlockName("shimmerFlower").setBlockTextureName(Dungeons.MODID + ":" + "shimmerflower").setCreativeTab(Dungeons.Blocks), "dungeons_shimmerFlower");
        GameRegistry.registerBlock(Dungeons.purpleEye = new BlockCrystalFoliage().setBlockName("purpleEye").setBlockTextureName(Dungeons.MODID + ":" + "purpleeye").setCreativeTab(Dungeons.Blocks), "dungeons_purpleEye");
        GameRegistry.registerBlock(Dungeons.crystalLeaf = new BlockCrystalFoliage().setBlockName("crystalLeaf").setBlockTextureName(Dungeons.MODID + ":" + "crystalleaf").setCreativeTab(Dungeons.Blocks), "dungeons_crystalLeaf");
        GameRegistry.registerBlock(Dungeons.badgererSpawner = new BlockBadgererSpawner().setBlockName("badgererSpawner").setBlockTextureName(Dungeons.MODID + ":" + "badgererspawner").setCreativeTab(Dungeons.Blocks), "dungeons_badgererSpawner");
        GameRegistry.registerBlock(Dungeons.witherSpawner = new BlockWitherSpawner().setBlockName("witherSpawner").setBlockTextureName(Dungeons.MODID + ":" + "witherspawner").setCreativeTab(Dungeons.Key), "dungeons_witherSpawner");
        GameRegistry.registerBlock(Dungeons.purpleBrick = new BlockOre().setBlockName("purpleBrick").setBlockTextureName(Dungeons.MODID + ":" + "purplebrick").setCreativeTab(Dungeons.Blocks).setHardness(15.0f).setResistance(30.0f), "dungeons_purpleBrick");
        GameRegistry.registerBlock(Dungeons.crystalliumBlock = new BlockOre().setBlockName("crystalliumBlock").setBlockTextureName(Dungeons.MODID + ":" + "crystalliumblock").setCreativeTab(Dungeons.Blocks).setHardness(15.0f).setResistance(30.0f), "dungeons_crystalliumBlock");
        GameRegistry.registerBlock(Dungeons.frostSpikes = new BlockFrostSpikes().setBlockName("frostSpikes").setBlockTextureName(Dungeons.MODID + ":" + "frostspikes").setCreativeTab(Dungeons.Blocks).setHardness(5.0f).setResistance(5.0f), "dungeons_frostSpikes");
        GameRegistry.registerBlock(Dungeons.redKeyClosed = new BlockRedKeyClosed().setBlockName("redKeyClosed").setBlockTextureName(Dungeons.MODID + ":" + "redkeyclosed").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_redKeyClosed");
        GameRegistry.registerBlock(Dungeons.blueKeyClosed = new BlueKeyClosed().setBlockName("blueKeyClosed").setBlockTextureName(Dungeons.MODID + ":" + "bluekeyclosed").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blueKeyClosed");
        GameRegistry.registerBlock(Dungeons.blackKeyClosed = new BlackKeyClosed().setBlockName("blackKeyClosed").setBlockTextureName(Dungeons.MODID + ":" + "blackkeyclosed").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blackKeyClosed");
        GameRegistry.registerBlock(Dungeons.blackKeyOpen = new BlockOre().setBlockName("blackKeyOpen").setBlockTextureName(Dungeons.MODID + ":" + "blackkeyopen").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blackKeyOpen");
        GameRegistry.registerBlock(Dungeons.blueKeyOpen = new BlockOre().setBlockName("blueKeyOpen").setBlockTextureName(Dungeons.MODID + ":" + "bluekeyopen").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_blueKeyOpen");
        GameRegistry.registerBlock(Dungeons.redKeyOpen = new BlockRedKeyOpen().setBlockName("redKeyOpen").setBlockTextureName(Dungeons.MODID + ":" + "redkeyopen").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_redKeyOpen");
        GameRegistry.registerBlock(Dungeons.stoneDoor = new BlockOre().setBlockName("stoneDoor").setBlockTextureName(Dungeons.MODID + ":" + "stonedoor").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_stoneDoor");
        GameRegistry.registerBlock(Dungeons.doorOpener = new BlockDoorOpener().setBlockName("doorOpener").setBlockTextureName(Dungeons.MODID + ":" + "dooropener").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_doorOpener");
        GameRegistry.registerBlock(Dungeons.undefeatableSpawner = new BlockUndefeatableSpawner().setBlockName("undefeatableSpawner").setBlockTextureName(Dungeons.MODID + ":" + "undefeatablespawner").setCreativeTab(Dungeons.Key), "dungeons_undefeatableSpawner");
        GameRegistry.registerBlock(Dungeons.yellowLock = new BlockYellowLock().setBlockName("yellowLock").setBlockTextureName(Dungeons.MODID + ":" + "yellowlock").setCreativeTab(Dungeons.Blocks).setHardness(10000.0f).setResistance(20000.0f), "dungeons_yellowLock");
        GameRegistry.registerBlock(Dungeons.deathBringerSpawner = new BlockDeathBringerSpawner().setBlockName("deathBringerSpawner").setBlockTextureName(Dungeons.MODID + ":" + "deathbringerspawner").setCreativeTab(Dungeons.Key), "dungeons_deathBringerSpawner");
        GameRegistry.registerBlock(Dungeons.iceSpiritSpawner = new BlockIceSpiritSpawner().setBlockName("iceSpiritSpawner").setBlockTextureName(Dungeons.MODID + ":" + "icespiritspawner").setCreativeTab(Dungeons.Key), "dungeons_iceSpiritSpawner");
        GameRegistry.registerBlock(Dungeons.midnightPortalSpawner = new BlockMidnightPortalSpawner().setBlockName("midnightPortalSpawner").setBlockTextureName(Dungeons.MODID + ":" + "midnightportalspawner").setCreativeTab(Dungeons.Key), "dungeons_midnightPortalSpawner");
        GameRegistry.registerBlock(Dungeons.crystalliumGrass = new BlockCrystalliumGrass().setBlockName("crystalliumGrass").setBlockTextureName(Dungeons.MODID + ":" + "crystalliumgrass").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumGrass");
        GameRegistry.registerBlock(Dungeons.crystalliumDirt = new BlockCrystalliumDirt().setBlockName("crystalliumDirt").setBlockTextureName(Dungeons.MODID + ":" + "crystalliumdirt").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumDirt");
        GameRegistry.registerBlock(Dungeons.caveMushrooms = new BlockCrystalFoliage().setBlockName("caveMushrooms").setBlockTextureName(Dungeons.MODID + ":" + "cavemushrooms").setCreativeTab(Dungeons.Blocks).setLightLevel(0.5f), "dungeons_caveMushrooms");
        GameRegistry.registerBlock(Dungeons.crystalWood = new BlockCrystalliumWood().setBlockName("crystalWood").setBlockTextureName(Dungeons.MODID + ":" + "crystalwood").setCreativeTab(Dungeons.Blocks), "dungeons_crystalWood");
        GameRegistry.registerBlock(Dungeons.crystalliumFern = new BlockCrystalliumFern().setBlockName("crystalliumFern").setBlockTextureName(Dungeons.MODID + ":" + "crystalliumfern").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumFern");
        GameRegistry.registerBlock(Dungeons.crystalliumLeaves = new BlockCrystalliumLeaves().setBlockName("crystalliumLeaves").setBlockTextureName(Dungeons.MODID + ":" + "crystalliumleaves").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumLeaves");
        GameRegistry.registerBlock(Dungeons.magirockOre = new BlockMagiRockOre().setBlockName("magirockOre").setBlockTextureName(Dungeons.MODID + ":" + "magirockore").setCreativeTab(Dungeons.Blocks), "dungeons_magirockOre");
        GameRegistry.registerBlock(Dungeons.carvedCrystalliumBrick = new BlockOre().setBlockName("carvedCrystalliumBrick").setBlockTextureName(Dungeons.MODID + ":" + "carvedcrystalliumbrick").setCreativeTab(Dungeons.Blocks).setHardness(10.0f).setResistance(10.0f), "dungeons_carvedCrystalliumBrick");
        GameRegistry.registerBlock(Dungeons.crystalliumLamp = new BlockCrystalliumLamp(true).setBlockName("crystalliumLamp").setBlockTextureName(Dungeons.MODID + ":" + "crystalliumlamp").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumLamp");
        GameRegistry.registerBlock(Dungeons.exawdusSpawner = new BlockExawdusSpawner().setBlockName("exawdusSpawner").setBlockTextureName(Dungeons.MODID + ":" + "exawdusspawner").setCreativeTab(Dungeons.Key), "dungeons_exawdusSpawner");
        GameRegistry.registerBlock(Dungeons.crystalliumStairs = new BlockCrystalliumStairs(Dungeons.purpleBrick, 0).setBlockName("crystalliumStairs").setBlockTextureName(Dungeons.MODID + ":" + "purplebrick").setCreativeTab(Dungeons.Blocks), "dungeons_crystalliumStairs");
        GameRegistry.registerBlock(Dungeons.magitable = new BlockMagiTable().setBlockName("magitable").setBlockTextureName(Dungeons.MODID + ":" + "magitable").setCreativeTab(Dungeons.Blocks), "dungeons_magitable");
        GameRegistry.registerBlock(Dungeons.magitableCharged = new BlockChargedMagiTable().setBlockName("magitableCharged").setBlockTextureName(Dungeons.MODID + ":" + "magitableon").setCreativeTab(Dungeons.Blocks), "dungeons_magitableCharged");
        GameRegistry.registerBlock(Dungeons.crystalGrass = new BlockCrystalliumGrass().setBlockName("crystalGrass").setBlockTextureName(Dungeons.MODID + ":" + "crystalgrass").setCreativeTab(Dungeons.Blocks), "dungeons_crystalGrass");
        GameRegistry.registerBlock(Dungeons.crystalDirt = new BlockCrystalliumDirt().setBlockName("crystalDirt").setBlockTextureName(Dungeons.MODID + ":" + "crystaldirt").setCreativeTab(Dungeons.Blocks), "dungeons_crystalDirt");
        GameRegistry.registerBlock(Dungeons.crystalLeaves = new BlockCrystalliumLeaves().setBlockName("crystalLeaves").setBlockTextureName(Dungeons.MODID + ":" + "crystalleaves").setCreativeTab(Dungeons.Blocks), "dungeons_crystalLeaves");
        GameRegistry.registerBlock(Dungeons.crystalBamboo = new BlockCrystalliumBamboo().setBlockName("crystalBamboo").setBlockTextureName(Dungeons.MODID + ":" + "crystalbamboo").setCreativeTab(Dungeons.Blocks), "dungeons_crystalBamboo");
        GameRegistry.registerBlock(Dungeons.voidrockOre = new BlockVoidRockOre().setBlockName("voidrockOre").setBlockTextureName(Dungeons.MODID + ":" + "voidrockore").setCreativeTab(Dungeons.Blocks), "dungeons_voidrockOre");
        GameRegistry.registerBlock(Dungeons.midnightStone = new BlockOre().setBlockName("midnightStone").setBlockTextureName(Dungeons.MODID + ":" + "midnightstone").setCreativeTab(Dungeons.Blocks).setHardness(20.0f).setResistance(20.0f), "dungeons_midnightStone");
        GameRegistry.registerBlock(Dungeons.midnightGrass = new BlockMidnightGrass().setBlockName("midnightGrass").setBlockTextureName(Dungeons.MODID + ":" + "midnightgrass").setCreativeTab(Dungeons.Blocks), "dungeons_midnightGrass");
        GameRegistry.registerBlock(Dungeons.midnightDirt = new BlockMidnightDirt().setBlockName("midnightDirt").setBlockTextureName(Dungeons.MODID + ":" + "midnightdirt").setCreativeTab(Dungeons.Blocks), "dungeons_midnightDirt");
        GameRegistry.registerBlock(Dungeons.midnightLog = new BlockMidnightWood().setBlockName("midnightLog").setBlockTextureName(Dungeons.MODID + ":" + "midnightLog").setCreativeTab(Dungeons.Blocks), "dungeons_midnightLog");
        GameRegistry.registerBlock(Dungeons.jadeLeaves = new BlockMidnightLeaves().setBlockName("jadeLeaves").setBlockTextureName(Dungeons.MODID + ":" + "jadeLeaves").setCreativeTab(Dungeons.Blocks), "dungeons_jadeLeaves");
        GameRegistry.registerBlock(Dungeons.fireflyLeaves = new BlockMidnightLeaves().setBlockName("fireflyLeaves").setBlockTextureName(Dungeons.MODID + ":" + "fireflyLeaves").setCreativeTab(Dungeons.Blocks), "dungeons_fireflyLeaves");
        GameRegistry.registerBlock(Dungeons.midnightLeaves = new BlockMidnightLeaves().setBlockName("midnightLeaves").setBlockTextureName(Dungeons.MODID + ":" + "midnightLeaves").setCreativeTab(Dungeons.Blocks), "dungeons_midnightLeaves");
        GameRegistry.registerBlock(Dungeons.jadeLog = new BlockJadeWood().setBlockName("jadeLog").setBlockTextureName(Dungeons.MODID + ":" + "jadeLog").setCreativeTab(Dungeons.Blocks), "dungeons_jadeLog");
        GameRegistry.registerBlock(Dungeons.fireflyLog = new BlockFireflyWood().setBlockName("fireflyLog").setBlockTextureName(Dungeons.MODID + ":" + "fireflyLog").setCreativeTab(Dungeons.Blocks), "dungeons_fireflyLog");
        GameRegistry.registerBlock(Dungeons.blindlightOre = new BlockBlindlightOre().setBlockName("blindlightOre").setBlockTextureName(Dungeons.MODID + ":" + "blindlightore").setCreativeTab(Dungeons.Blocks).setLightLevel(1.0f).setLightOpacity(200).setHardness(20.0f), "dungeons_blindlightOre");
        GameRegistry.registerBlock(Dungeons.runicOre = new BlockRunicOre().setBlockName("runicOre").setBlockTextureName(Dungeons.MODID + ":" + "runicore").setCreativeTab(Dungeons.Blocks).setLightLevel(0.6f).setLightOpacity(200).setHardness(20.0f), "dungeons_runicOre");
        GameRegistry.registerBlock(Dungeons.fireflyStone = new BlockFireflyStone().setBlockName("fireflyStone").setBlockTextureName(Dungeons.MODID + ":" + "fireflystone").setCreativeTab(Dungeons.Blocks).setLightLevel(0.7f), "dungeons_fireflyStone");
        GameRegistry.registerBlock(Dungeons.shadowRune2 = new BlockOre().setBlockName("shadowRune2").setBlockTextureName(Dungeons.MODID + ":" + "shadowrune2").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setLightOpacity(200).setHardness(3000.0f).setResistance(3000.0f), "dungeons_shadowRune2");
        GameRegistry.registerBlock(Dungeons.shadowRune3 = new BlockOre().setBlockName("shadowRune3").setBlockTextureName(Dungeons.MODID + ":" + "shadowrune3").setCreativeTab(Dungeons.Blocks).setLightLevel(0.2f).setLightOpacity(200).setHardness(3000.0f).setResistance(3000.0f), "dungeons_shadowRune3");
        GameRegistry.registerBlock(Dungeons.blackIronOre = new BlockNetherSteelOre().setBlockName("blackIronOre").setBlockTextureName(Dungeons.MODID + ":" + "blackironore").setCreativeTab(Dungeons.Blocks), "dungeons_blackIronOre");
        GameRegistry.registerBlock(Dungeons.jadePeaches = new BlockJadePeaches().setBlockName("jadePeaches").setBlockTextureName(Dungeons.MODID + ":" + "jadePeaches").setCreativeTab(Dungeons.Blocks), "dungeons_jadePeaches");
        GameRegistry.registerBlock(Dungeons.shadowBlock = new BlockShadowBlock(Material.rock).setBlockName("shadowBlock").setBlockTextureName(Dungeons.MODID + ":" + "shadowblock").setLightLevel(0.5f).setLightOpacity(200).setHardness(20000.0f).setResistance(10000.0f), "dungeons_shadowBlock");
        GameRegistry.registerBlock(Dungeons.runeAltar = new BlockRuneAltar().setBlockName("runeAltar").setBlockTextureName(Dungeons.MODID + ":" + "runealtar").setCreativeTab(Dungeons.Blocks).setLightLevel(0.5f).setLightOpacity(200).setHardness(20.0f), "dungeons_runeAltar");
        GameRegistry.registerBlock(Dungeons.glowingBrambles = new BlockMidnightSpikes().setBlockName("glowingBrambles").setBlockTextureName(Dungeons.MODID + ":" + "glowingbrambles").setCreativeTab(Dungeons.Blocks).setLightLevel(0.9f).setLightOpacity(200).setHardness(20.0f), "dungeons_glowingBrambles");
        GameRegistry.registerBlock(Dungeons.midnightTallgrass = new BlockEruikPlant().setBlockName("midnightTallgrass").setBlockTextureName(Dungeons.MODID + ":" + "midnightTallgrass").setCreativeTab(Dungeons.Blocks), "dungeons_midnightTallgrass");
        GameRegistry.registerBlock(Dungeons.bloodThorns = new BlockMidnightSpikes().setBlockName("bloodThorns").setBlockTextureName(Dungeons.MODID + ":" + "bloodThorns").setCreativeTab(Dungeons.Blocks), "dungeons_bloodThorns");
        GameRegistry.registerBlock(Dungeons.blindlightLeaf = new BlockMidnightFoliage().setBlockName("blindlightLeaf").setBlockTextureName(Dungeons.MODID + ":" + "blindlightleaf").setCreativeTab(Dungeons.Blocks), "dungeons_blindlightLeaf");
        GameRegistry.registerBlock(Dungeons.eruikPlant = new BlockEruikPlant().setBlockName("eruikPlant").setBlockTextureName(Dungeons.MODID + ":" + "eruikPlant").setCreativeTab(Dungeons.Blocks).setLightLevel(0.3f), "dungeons_eruikPlant");
        GameRegistry.registerBlock(Dungeons.darkOrchid = new BlockMidnightFoliage().setBlockName("darkOrchid").setBlockTextureName(Dungeons.MODID + ":" + "darkOrchid").setCreativeTab(Dungeons.Blocks), "dungeons_darkOrchid");
        GameRegistry.registerBlock(Dungeons.flimFlower = new BlockMidnightFoliage().setBlockName("flimFlower").setBlockTextureName(Dungeons.MODID + ":" + "flimFlower").setCreativeTab(Dungeons.Blocks), "dungeons_flimFlower");
        GameRegistry.registerBlock(Dungeons.midnightBramble = new BlockMidnightSpikes().setBlockName("midnightBramble").setBlockTextureName(Dungeons.MODID + ":" + "midnightbramble").setCreativeTab(Dungeons.Blocks), "dungeons_midnightBramble");
        GameRegistry.registerBlock(Dungeons.altarBricks = new BlockOre().setBlockName("altarBricks").setBlockTextureName(Dungeons.MODID + ":" + "templebricks").setCreativeTab(Dungeons.Blocks), "dungeons_altarBricks");
        GameRegistry.registerBlock(Dungeons.midnightCracks = new BlockOre().setBlockName("midnightCracks").setBlockTextureName(Dungeons.MODID + ":" + "midnightcracks").setCreativeTab(Dungeons.Blocks).setLightLevel(0.5f).setLightOpacity(200).setHardness(20.0f), "dungeons_midnightCracks");
        EntityRegistry.registerModEntity(EntityDarkExplosion.EntityRuneAltar.class, "EntityRuneAltar", 172, this, 60, 10, true);
        EntityRegistry.registerModEntity(EntityPoundEffect.class, "EntityPoundEffect", 173,this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityPoundEffect2.class, "EntityPoundEffect2", 174,this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityPowerupEffect.class, "EntityPowerupEffect", 175,this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityPoundEffect3.class, "EntityPoundEffect3", 176, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityPaladinHeal.class, "EntityPaladinHeal", 177, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityTreeGolem.class, "EntityTreeGolem", 178, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityPaladin.class, "EntityPaladin", 179, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityTitanSpawner.class, "EntityTitanSpawner", 180,this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityIronStar.class, "EntityIronStar", 100, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityProjectileBall.class, "EntityProjectileBall", 101, this, 40, 2, false);
        EntityRegistry.registerModEntity(EntityExplosive.class, "EntityExplosive", 102, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntitySpit.class, "EntitySpit", 103, this, 20, 1, true);
        EntityRegistry.registerModEntity(EntitySodbuster.class, "EntitySodbuster", 104, this, 20, 1, true);
        EntityRegistry.registerModEntity(EntityShimmerPearl.class, "EntityShimmerPearl", 105, this, 60, 5, true);
        EntityRegistry.registerModEntity(EntityWaterBall.class, "EntityWaterBall", 106, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntitySandBall.class, "EntitySandBall", 107, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityBlizzardBall.class, "EntityBlizzardBall", 108, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityTornadoBall.class, "EntityTornadoBall", 109, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityBloodBall.class, "EntityBloodBall", 110, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityRedBall.class, "EntityRedBall", 111, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityGreenBall.class, "EntityGreenBall", 112, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityBlueBall.class, "EntityBlueBall", 113, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMiniFireBall.class, "EntityMiniFireBall", 114, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityNetherDriller.class, "EntityNetherDriller", 115, this, 50, 10, true);
        EntityRegistry.registerModEntity(EntityNetherDrill.class, "EntityNetherDrill", 116, this, 50, 10, true);
        EntityRegistry.registerModEntity(EntityVoidBomb.class, "EntityVoidBomb", 117, this, 50, 1, true);
        EntityRegistry.registerModEntity(EntityVoidDisk.class, "EntityVoidDisk", 118, this, 50, 1, true);
        EntityRegistry.registerModEntity(EntityRupture.class, "EntityRupture", 119, this, 30, 1, true);
        EntityRegistry.registerModEntity(EntityAntigravity.class, "EntityAntigravity", 120, this, 50, 1, true);
        EntityRegistry.registerModEntity(EntityEnergy.class, "EntityEnergy", 121, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityExplosionSnake.class, "EntityExplosionSnake", 121, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityBlackEnergy.class, "EntityBlackEnergy", 122, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityColdWind.class, "EntityBlackEnergy", 123, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityHealEffect.class, "EntityHealEffect", 124, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityQuake.class, "EntityQuake", 125, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityAmethystPortal.class, "EntityAmethystPortal", 126, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityDarkWave.class, "EntityDarkWave", 127, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntitySunsetPortal.class, "EntitySunsetPortal", 128, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityDarkExplosion.class, "EntityDarkExplosion", 129, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityBeholderSpawner.class, "EntityBeholderSpawner", 130, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityCursedStone.class, "EntityCursedStone", 131, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityWitherSpawner.class, "EntityWitherSpawner", 132, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityCorruptedArrow.class, "EntityCorruptedArrow", 133, this, 120, 2, true);
        EntityRegistry.registerModEntity(EntityRuneExplosion.class, "EntityRuneExplosion", 134, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityThrowback.class, "EntityThrowback", 135, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityDisinigrationArrow.class, "EntityDisinigrationArrow", 136, this, 120, 2, true);
        EntityRegistry.registerModEntity(EntityIceShieldBall.class, "EntityIceShieldBall", 137, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityRedBouncer.class, "EntityRedBouncer", 138, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityBlueBeam.class, "EntityBlueBeam", 139, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityIcefire.class, "EntityIcefire", 140, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityIceWanderer.class, "EntityIceWanderer", 141, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityIceSpiker.class, "EntityIceSpiker", 142, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntitySunProjectile.class, "EntitySunProjectile", 143, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityGroundShade.class, "EntityGroundShade", 144, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntitySapientDeath.class, "EntitySapientDeath", 145, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityCrystalBeam.class, "EntityCrystalBeam", 146, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityMontanePortal.class, "EntityMontanePortal", 147, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityMagirockBall.class, "EntityMagirockBall", 148, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityVoidrim.class, "EntityVoidrim", 149, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityCrystalToxic.class, "EntityCrystalToxic", 150, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityExawdusSpawner.class, "EntityExawdusSpawner", 151, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityEnchantEffect.class, "EntityEnchantEffect", 152, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityVoidrockBall.class, "EntityVoidrockBall", 153, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityFusionBall.class, "EntityFusionBall", 154, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityCrystalliumPlainsPortal.class, "EntityCrystalliumPlainsPortal", 155, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityCrystalMeteor.class, "EntityCrystalMeteor", 156, this, 60, 1, true);
        EntityRegistry.registerModEntity(EntityGoblin.class, "EntityGoblin", 1, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntitySkeletonWarrior.class, "EntitySkeletonWarrior", 3, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityZombieWarlord.class, "EntityZombieWarlord", 4, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityEarthGolem.class, "EntityEarthGolem", 5, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityStoneGolem.class, "EntityStoneGolem", 6, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityBigStoneGolem.class, "EntityBigStoneGolem", 7, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntitySpecter.class, "EntitySpecter", 8, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityBandit.class, "EntityBandit", 9, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityBanditBoss.class, "EntityBanditLeader", 10, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntitySkeletalMage.class, "EntitySkeletalMage", 11, this, 40, 3, true);
        EntityRegistry.registerModEntity(EntityBlackKnight.class, "EntityBlackKnight", 12, this, 30, 3, true);
        EntityRegistry.registerModEntity(EntityHannibal.class, "EntityHannibal", 13, this, 30, 3, true);
        EntityRegistry.registerModEntity(EntityRemnant.class, "EntityRemnant", 14, this, 100, 3, true);
        EntityRegistry.registerModEntity(EntityVoidLord.class, "EntityVoidLord", 15, this, 100, 3, true);
        EntityRegistry.registerModEntity(EntityDarkKnight.class, "EntityDarkKnight", 16, this, 100, 3, true);
        EntityRegistry.registerModEntity(EntityNecro.class, "EntityNecro", 17, this, 60, 3, true);
        EntityRegistry.registerModEntity(EntityIceMage.class, "EntityIceMage", 18, this, 60, 3, true);
        EntityRegistry.registerModEntity(EntityEarthMage.class, "EntityEarthMage", 19, this, 60, 3, true);
        EntityRegistry.registerModEntity(EntityImp.class, "EntityImp", 20, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityTroll.class, "EntityTroll", 21, this, 40, 3, true);
        EntityRegistry.registerModEntity(EntityShimmerman.class, "EntityShimmerman", 22, this, 60, 3, true);
        EntityRegistry.registerModEntity(EntityCyclops.class, "EntityCyclops", 23, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityTyphoon.class, "EntityTyphoon", 24, this, 60, 4, true);
        EntityRegistry.registerModEntity(EntitySandstorm.class, "EntitySandstorm", 25, this, 60, 4, true);
        EntityRegistry.registerModEntity(EntityVoidFiend.class, "EntityVoidFiend", 26, this, 40, 4, true);
        EntityRegistry.registerModEntity(EntityBlizzard.class, "EntityBlizzard", 27, this, 60, 4, true);
        EntityRegistry.registerModEntity(EntityTornado.class, "EntityTornado", 28, this, 60, 4, true);
        EntityRegistry.registerModEntity(EntityHermit.class, "EntityHermit", 29, this, 60, 3, true);
        EntityRegistry.registerModEntity(EntitySpirit.class, "EntitySpirit", 30, this, 40, 2, true);
        EntityRegistry.registerModEntity(EntityWarlock.class, "EntityWarlock", 31, this, 60, 3, true);
        EntityRegistry.registerModEntity(EntitySkeletonKnight.class, "EntitySkeletonKnight", 32, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntitySapientWarrior.class, "EntitySapientWarrior", 33, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntitySapientMiner.class, "EntitySapientMiner", 34, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityNetherGhost.class, "EntityNetherGhost", 35, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityNetherSoul.class, "EntityNetherSoul", 36, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityNetherPigman.class, "EntityNetherPigman", 37, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityAmethystMonster.class, "EntityAmethystMonster", 38, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityVampire.class, "EntityVampire", 39, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityLavaTroll.class, "EntityLavaTroll", 40, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityLavaKnight.class, "EntityLavaKnight", 41, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityNetherBadgerer.class, "EntityNetherBadgerer", 42, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityBeholder.class, "EntityBeholder", 43, this, 300, 3, true);
        EntityRegistry.registerModEntity(EntityFireclops.class, "EntityFireclops", 44, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityWitherSkeletonMinion.class, "EntityWitherSkeletonMinion", 45, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityCrystalBadgerer.class, "EntityCrystalBadgerer", 46, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityGhostWither.class, "EntityGhostWither", 47, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityFakeWither.class, "EntityFakeWither", 48, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityChainMummy.class, "EntityChainMummy", 57, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityEyeWarrior.class, "EntityEyeWarrior", 58, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityYeti.class, "EntityYeti", 59, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntitySnowGiant.class, "EntitySnowGiant", 60, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityDeathBringer.class, "EntityDeathBringer", 61, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityDungeonBeast.class, "EntityDungeonBeast", 62, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityDesertDragger.class, "EntityDesertDragger", 63, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityNetherWalker.class, "EntityNetherWalker", 66, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityIceShielder.class, "EntityIceShielder", 68, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityOrc.class, "EntityOrc", 69, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityOrcMage.class, "EntityOrcMage", 70, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityOrcDefender.class, "EntityOrcDefender", 71, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityRockTroll.class, "EntityRockTroll", 73, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityEarthRupturer.class, "EntityEarthRupturer", 74, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityIceSpirit.class, "EntityIceSpirit", 75, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityUndefeatableStrength.class, "EntityUndefeatableStrength", 76, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityUndefeatableRegen.class, "EntityUndefeatableRegen", 77, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntityUndefeatableResistance.class, "EntityUndefeatableResistance", 78, this, 50, 3, true);
        EntityRegistry.registerModEntity(EntitySapientEliteKnight.class, "EntitySapientEliteKnight", 79, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntitySapientGeneral.class, "EntitySapientGeneral", 80, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightShade.class, "EntityMidnightShade", 83, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntitySapientMage.class, "EntitySapientMage", 84, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityCrystalTroll.class, "EntityCrystalTroll", 85, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityCrystasis.class, "EntityCrystasis", 86, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityCrystox.class, "EntityCrystox", 87, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityExawdus.class, "EntityExawdus", 88, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityCrystalliumGolem.class, "EntityCrystalliumGolem", 89, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMoundTrader.class, "EntityMoundTrader", 49, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityAnchorTrader.class, "EntityAnchorTrader", 50, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityStoneBot.class, "EntityStoneBot", 51, this, 50, 2, true);
        EntityRegistry.registerModEntity(EntityTreeVillager.class, "EntityTreeVillager", 52, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityQuarryMaster.class, "EntityQuarryMaster", 53, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityOreDealer.class, "EntityOreDealer", 54, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMinerVillager.class, "EntityMinerVillager", 55, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityTalkingVillager.class, "EntityTalkingVillager", 56, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityTavernMaster.class, "EntityTavernMaster", 64, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityTavernClient.class, "EntityTavernClient", 65, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityFriendlyZombie.class, "EntityFriendlyZombie", 67, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMontaneVillager.class, "EntityMontaneVillager", 81, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMontaneTrader.class, "EntityMontaneTrader", 82, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightChicken.class, "EntityMidnightChicken", 157, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightCow.class, "EntityMidnightCow", 158, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityNightMite.class, "EntityNightMite", 159, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityCaveWraith.class, "EntityCaveWraith", 160, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityFirefly.class, "EntityFirefly", 161, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityFireflySpawner.class, "EntityFireflySpawner", 162, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightTrader.class, "EntityMidnightTrader", 163, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightProjectile.class, "EntityMidnightProjectile", 164, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightMeteor.class, "EntityMidnightMeteor", 165, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightSizzler.class, "EntityMidnightSizzler", 166, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightSplitter.class, "EntityMidnightSplitter", 167, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityNothing.class, "EntityNothing", 168, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityRagedSizzler.class, "EntityMidnightSizzler", 169, this, 60, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightTitan.class, "EntityMidnightTitan", 170, this, 30, 2, true);
        EntityRegistry.registerModEntity(EntityMidnightMagician.class, "EntityMidnightMagician", 171, this, 30, 2, true);
        GameRegistry.registerWorldGenerator(new DungeonsGenerator(), 30);
        Crafting.Recipes();
        CombatCrafting.Recipes();
        ToolCrafting.Recipes();
        ArmorCrafting.Recipes();
        MagicCrafting.Recipes();
        EggInit.preInit(event);
        Dungeons.proxy.registerRenderInformation();
        Dungeons.proxy.registerItemRenderers();
        Dungeons.proxy.registerTileEntities();
    }

    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
    ModConfig.postInitializeConfig();
    }

    public static int getUniqueEntityId() {
        do {
            ++Dungeons.startEntityid;
        } while (EntityList.getStringFromID(Dungeons.startEntityid) != null);
        return Dungeons.startEntityid;
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
        return rand.nextInt(Math.abs(start - end) + 1) + start;
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
