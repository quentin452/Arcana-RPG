package com.gibby.dungeon.init;

import com.gibby.dungeon.mobs.entityinstance.*;
import com.gibby.dungeon.items.SpawnEggsHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class EggInit {
    public static SpawnEggsHandler EntityGoblinEgg;
    public static SpawnEggsHandler EntityImpEgg;
    public static SpawnEggsHandler EntitySkeletonWarriorEgg;
    public static SpawnEggsHandler EntityZombieWarlordEgg;
    public static SpawnEggsHandler EntityEarthGolemEgg;
    public static SpawnEggsHandler EntityStoneGolemEgg;
    public static SpawnEggsHandler EntityBigStoneGolemEgg;
    public static SpawnEggsHandler EntityStoneBotEgg;
    public static SpawnEggsHandler EntitySpecterEgg;
    public static SpawnEggsHandler EntityBanditEgg;
    public static SpawnEggsHandler EntityBanditBossEgg;
    public static SpawnEggsHandler EntitySkeletalMageEgg;
    public static SpawnEggsHandler EntityTrollEgg;
    public static SpawnEggsHandler EntityShimmermanEgg;
    public static SpawnEggsHandler EntityCyclopsEgg;
    public static SpawnEggsHandler EntityTyphoonEgg;
    public static SpawnEggsHandler EntitySandstormEgg;
    public static SpawnEggsHandler EntityBlizzardEgg;
    public static SpawnEggsHandler EntityTornadoEgg;
    public static SpawnEggsHandler EntityVoidFiendEgg;
    public static SpawnEggsHandler EntitySpiritEgg;
    public static SpawnEggsHandler EntityHermitEgg;
    public static SpawnEggsHandler EntityWarlockEgg;
    public static SpawnEggsHandler EntityNecroEgg;
    public static SpawnEggsHandler EntityIceMageEgg;
    public static SpawnEggsHandler EntityEarthMageEgg;
    public static SpawnEggsHandler EntitySkeletonKnightEgg;
    public static SpawnEggsHandler EntitySapientWarriorEgg;
    public static SpawnEggsHandler EntitySapientMinerEgg;
    public static SpawnEggsHandler EntityMoundTraderEgg;
    public static SpawnEggsHandler EntityAnchorTraderEgg;
    public static SpawnEggsHandler EntityBlackKnightEgg;
    public static SpawnEggsHandler EntityHannibalEgg;
    public static SpawnEggsHandler EntityRemnantEgg;
    public static SpawnEggsHandler EntityVoidLordEgg;
    public static SpawnEggsHandler EntityDarkKnightEgg;
    public static SpawnEggsHandler EntityNetherGhostEgg;
    public static SpawnEggsHandler EntityNetherSoulEgg;
    public static SpawnEggsHandler EntityNetherPigmanEgg;
    public static SpawnEggsHandler EntityVampireEgg;
    public static SpawnEggsHandler EntityLavaTrollEgg;
    public static SpawnEggsHandler EntityLavaKnightEgg;
    public static SpawnEggsHandler EntityNetherBadgererEgg;
    public static SpawnEggsHandler EntityBeholderEgg;
    public static SpawnEggsHandler EntityFireclopsEgg;
    public static SpawnEggsHandler EntityCrystalBadgererEgg;
    public static SpawnEggsHandler EntityAmethystMonsterEgg;
    public static SpawnEggsHandler EntityGhostWitherEgg;
    public static SpawnEggsHandler EntityTreeVillagerEgg;
    public static SpawnEggsHandler EntityQuarryMasterEgg;
    public static SpawnEggsHandler EntityMinerVillagerEgg;
    public static SpawnEggsHandler EntityTalkingVillagerEgg;
    public static SpawnEggsHandler EntityChainMummyEgg;
    public static SpawnEggsHandler EntityEyeWarriorEgg;
    public static SpawnEggsHandler EntityYetiEgg;
    public static SpawnEggsHandler EntitySnowGiantEgg;
    public static SpawnEggsHandler EntityDeathBringerEgg;
    public static SpawnEggsHandler EntityDungeonBeastEgg;
    public static SpawnEggsHandler EntityDesertDraggerEgg;
    public static SpawnEggsHandler EntityTavernMasterEgg;
    public static SpawnEggsHandler EntityTavernClientEgg;
    public static SpawnEggsHandler EntityNetherWalkerEgg;
    public static SpawnEggsHandler EntityIceShielderEgg;
    public static SpawnEggsHandler EntityOrcEgg;
    public static SpawnEggsHandler EntityOrcMageEgg;
    public static SpawnEggsHandler EntityOrcDefenderEgg;
    public static SpawnEggsHandler EntityRockTrollEgg;
    public static SpawnEggsHandler EntityEarthRupturerEgg;
    public static SpawnEggsHandler EntityIceSpiritEgg;
    public static SpawnEggsHandler EntityUndefeatableStrengthEgg;
    public static SpawnEggsHandler EntityUndefeatableRegenEgg;
    public static SpawnEggsHandler EntityUndefeatableResistanceEgg;
    public static SpawnEggsHandler EntitySapientEliteKnightEgg;
    public static SpawnEggsHandler EntitySapientGeneralEgg;
    public static SpawnEggsHandler EntityMontaneVillagerEgg;
    public static SpawnEggsHandler EntityMontaneTraderEgg;
    public static SpawnEggsHandler EntityMidnightShadeEgg;
    public static SpawnEggsHandler EntitySapientMageEgg;
    public static SpawnEggsHandler EntityCrystalTrollEgg;
    public static SpawnEggsHandler EntityCrystasisEgg;
    public static SpawnEggsHandler EntityCrystoxEgg;
    public static SpawnEggsHandler EntityExawdusEgg;
    public static SpawnEggsHandler EntityCrystalliumGolemEgg;

    public static SpawnEggsHandler EntityMidnightChickenEgg;
    public static SpawnEggsHandler EntityMidnightCowEgg;
    public static SpawnEggsHandler EntityNightMiteEgg;
    public static SpawnEggsHandler EntityMidnightTraderEgg;
    public static SpawnEggsHandler EntityCaveWraithEgg;
    public static SpawnEggsHandler EntityFireflyEgg;
    public static SpawnEggsHandler EntityMidnightTitanEgg;
    public static SpawnEggsHandler EntityMidnightMagicianEgg;
    public static SpawnEggsHandler EntityTreeGolemEgg;
    public static SpawnEggsHandler EntityPaladinEgg;
    public static SpawnEggsHandler EntityNothingEgg;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        SpawnEggsHandler EntityGoblinEggInit = new SpawnEggsHandler(EntityGoblin.class);
        EntityGoblinEggInit.setUnlocalizedName("entity_goblin_egg");
        EntityGoblinEgg = EntityGoblinEggInit;
        GameRegistry.registerItem(EntityGoblinEgg, "Goblin Egg");

        SpawnEggsHandler EntityImpEggInit = new SpawnEggsHandler(EntityImp.class);
        EntityImpEggInit.setUnlocalizedName("entity_imp_egg");
        EntityImpEgg = EntityImpEggInit;
        GameRegistry.registerItem(EntityImpEgg, "Imp Egg");

        SpawnEggsHandler EntitySkeletonWarriorEggInit = new SpawnEggsHandler(EntitySkeletonWarrior.class);
        EntitySkeletonWarriorEggInit.setUnlocalizedName("entity_skeleton_warrior_egg");
        EntitySkeletonWarriorEgg = EntitySkeletonWarriorEggInit;
        GameRegistry.registerItem(EntitySkeletonWarriorEgg, "Skeleton Warrior Egg");

        SpawnEggsHandler EntityZombieWarlordEggInit = new SpawnEggsHandler(EntityZombieWarlord.class);
        EntityZombieWarlordEggInit.setUnlocalizedName("entity_zombie_warlord_egg");
        EntityZombieWarlordEgg =EntityZombieWarlordEggInit;
        GameRegistry.registerItem(EntityZombieWarlordEgg, "Zombie Warlord Egg");

        SpawnEggsHandler EntityEarthGolemEggInit = new SpawnEggsHandler(EntityEarthGolem.class);
        EntityEarthGolemEggInit.setUnlocalizedName("entity_earth_golem_egg");
        EntityEarthGolemEgg =EntityEarthGolemEggInit;
        GameRegistry.registerItem(EntityEarthGolemEgg, "Terra Cotta Egg");

        SpawnEggsHandler EntityStoneGolemEggInit = new SpawnEggsHandler(EntityStoneGolem.class);
        EntityStoneGolemEggInit.setUnlocalizedName("entity_stone_golem_egg");
        EntityStoneGolemEgg =EntityStoneGolemEggInit;
        GameRegistry.registerItem(EntityStoneGolemEgg, "Stone Golem Egg");

        SpawnEggsHandler EntityBigStoneGolemEggInit = new SpawnEggsHandler(EntityBigStoneGolem.class);
        EntityBigStoneGolemEggInit.setUnlocalizedName("entity_big_stone_golem_egg");
        EntityBigStoneGolemEgg =EntityBigStoneGolemEggInit;
        GameRegistry.registerItem(EntityBigStoneGolemEgg, "Big Stone Golem Egg");

        SpawnEggsHandler EntityStoneBotEggInit = new SpawnEggsHandler(EntityStoneBot.class);
        EntityStoneBotEggInit.setUnlocalizedName("entity_stone_bot_egg");
        EntityStoneBotEgg =EntityStoneBotEggInit;
        GameRegistry.registerItem(EntityStoneBotEgg, "Stone Bot Egg");

        SpawnEggsHandler EntitySpecterEggInit = new SpawnEggsHandler(EntitySpecter.class);
        EntitySpecterEggInit.setUnlocalizedName("entity_specter_egg");
        EntitySpecterEgg =EntitySpecterEggInit;
        GameRegistry.registerItem(EntitySpecterEgg, "Specter Egg");

        SpawnEggsHandler EntityBanditEggInit = new SpawnEggsHandler(EntityBandit.class);
        EntityBanditEggInit.setUnlocalizedName("entity_bandit_egg");
        EntityBanditEgg =EntityBanditEggInit;
        GameRegistry.registerItem(EntityBanditEgg, "Bandit Egg");

        SpawnEggsHandler EntityBanditBossEggInit = new SpawnEggsHandler(EntityBanditBoss.class);
        EntityBanditBossEggInit.setUnlocalizedName("entity_bandit_boss_egg");
        EntityBanditBossEgg =EntityBanditBossEggInit;
        GameRegistry.registerItem(EntityBanditBossEgg, "Bandit Boss Egg");

        SpawnEggsHandler EntitySkeletalMageEggInit = new SpawnEggsHandler(EntitySkeletalMage.class);
        EntitySkeletalMageEggInit.setUnlocalizedName("entity_skeletal_mage_egg");
        EntitySkeletalMageEgg =EntitySkeletalMageEggInit;
        GameRegistry.registerItem(EntitySkeletalMageEgg, "Skeletal Mage Egg");

        SpawnEggsHandler EntityTrollEggInit = new SpawnEggsHandler(EntityTroll.class);
        EntityTrollEggInit.setUnlocalizedName("entity_troll_egg");
        EntityTrollEgg =EntityTrollEggInit;
        GameRegistry.registerItem(EntityTrollEgg, "Troll Egg");

        SpawnEggsHandler EntityShimmermanEggInit = new SpawnEggsHandler(EntityShimmerman.class);
        EntityShimmermanEggInit.setUnlocalizedName("entity_shimmerman_egg");
        EntityShimmermanEgg =EntityShimmermanEggInit;
        GameRegistry.registerItem(EntityShimmermanEgg, "Shimmerman Egg");

        SpawnEggsHandler EntityCyclopsEggInit = new SpawnEggsHandler(EntityCyclops.class);
        EntityCyclopsEggInit.setUnlocalizedName("entity_cyclops_egg");
        EntityCyclopsEgg =EntityCyclopsEggInit;
        GameRegistry.registerItem(EntityCyclopsEgg, "Cyclops Egg");

        SpawnEggsHandler EntityTyphoonEggInit = new SpawnEggsHandler(EntityTyphoon.class);
        EntityTyphoonEggInit.setUnlocalizedName("entity_typhoon_egg");
        EntityTyphoonEgg =EntityTyphoonEggInit;
        GameRegistry.registerItem(EntityTyphoonEgg, "Typhoon Egg");

        SpawnEggsHandler EntitySandstormEggInit = new SpawnEggsHandler(EntitySandstorm.class);
        EntitySandstormEggInit.setUnlocalizedName("entity_sandstorm_egg");
        EntitySandstormEgg =EntitySandstormEggInit;
        GameRegistry.registerItem(EntitySandstormEgg, "Sandstorm Egg");

        SpawnEggsHandler EntityBlizzardEggInit = new SpawnEggsHandler(EntityBlizzard.class);
        EntityBlizzardEggInit.setUnlocalizedName("entity_blizzard_egg");
        EntityBlizzardEgg =EntityBlizzardEggInit;
        GameRegistry.registerItem(EntityBlizzardEgg, "Blizzard Egg");

        SpawnEggsHandler EntityTornadoEggInit = new SpawnEggsHandler(EntityTornado.class);
        EntityTornadoEggInit.setUnlocalizedName("entity_tornado_egg");
        EntityTornadoEgg =EntityTornadoEggInit;
        GameRegistry.registerItem(EntityTornadoEgg, "Tornado Egg");

        SpawnEggsHandler EntityVoidFiendEggInit = new SpawnEggsHandler(EntityVoidFiend.class);
        EntityVoidFiendEggInit.setUnlocalizedName("entity_void_fiend_egg");
        EntityVoidFiendEgg =EntityVoidFiendEggInit;
        GameRegistry.registerItem(EntityVoidFiendEgg, "Void Friend Egg");

        SpawnEggsHandler EntitySpiritEggInit = new SpawnEggsHandler(EntitySpirit.class);
        EntitySpiritEggInit.setUnlocalizedName("entity_spirit_egg");
        EntitySpiritEgg =EntitySpiritEggInit;
        GameRegistry.registerItem(EntitySpiritEgg, "Spirit Egg");

        SpawnEggsHandler EntityHermitEggInit = new SpawnEggsHandler(EntityHermit.class);
        EntityHermitEggInit.setUnlocalizedName("entity_hermit_egg");
        EntityHermitEgg =EntityHermitEggInit;
        GameRegistry.registerItem(EntityHermitEgg, "Hermit Egg");

        SpawnEggsHandler EntityWarlockEggInit = new SpawnEggsHandler(EntityWarlock.class);
        EntityWarlockEggInit.setUnlocalizedName("entity_warlock_egg");
        EntityWarlockEgg =EntityWarlockEggInit;
        GameRegistry.registerItem(EntityWarlockEgg, "Warlock Egg");

        SpawnEggsHandler EntityNecroEggInit = new SpawnEggsHandler(EntityNecro.class);
        EntityNecroEggInit.setUnlocalizedName("entity_necro_egg");
        EntityNecroEgg =EntityNecroEggInit;
        GameRegistry.registerItem(EntityNecroEgg, "Necro Egg");

        SpawnEggsHandler EntityIceMageEggInit = new SpawnEggsHandler(EntityIceMage.class);
        EntityIceMageEggInit.setUnlocalizedName("entity_ice_mage_egg");
        EntityIceMageEgg =EntityIceMageEggInit;
        GameRegistry.registerItem(EntityIceMageEgg, "Ice Mage Egg");

        SpawnEggsHandler EntityEarthMageEggInit = new SpawnEggsHandler(EntityEarthMage.class);
        EntityEarthMageEggInit.setUnlocalizedName("entity_earth_mage_egg");
        EntityEarthMageEgg =EntityEarthMageEggInit;
        GameRegistry.registerItem(EntityEarthMageEgg, "Earth Mage Egg");

        SpawnEggsHandler EntitySkeletonKnightEggInit = new SpawnEggsHandler(EntitySkeletonKnight.class);
        EntitySkeletonKnightEggInit.setUnlocalizedName("entity_skeleton_knight_egg");
        EntitySkeletonKnightEgg =EntitySkeletonKnightEggInit;
        GameRegistry.registerItem(EntitySkeletonKnightEgg, "Skeleton Knight Egg");

        SpawnEggsHandler EntitySapientWarriorEggInit = new SpawnEggsHandler(EntitySapientWarrior.class);
        EntitySapientWarriorEggInit.setUnlocalizedName("entity_sapient_warrior_egg");
        EntitySapientWarriorEgg =EntitySapientWarriorEggInit;
        GameRegistry.registerItem(EntitySapientWarriorEgg, "Sapient Warrior Egg");

        SpawnEggsHandler EntitySapientMinerEggInit = new SpawnEggsHandler(EntitySapientMiner.class);
        EntitySapientMinerEggInit.setUnlocalizedName("entity_sapient_miner_egg");
        EntitySapientMinerEgg =EntitySapientMinerEggInit;
        GameRegistry.registerItem(EntitySapientMinerEgg, "Sapient Miner Egg");

        SpawnEggsHandler EntityMoundTraderEggInit = new SpawnEggsHandler(EntityMoundTrader.class);
        EntityMoundTraderEggInit.setUnlocalizedName("entity_mount_trader_egg");
        EntityMoundTraderEgg =EntityMoundTraderEggInit;
        GameRegistry.registerItem(EntityMoundTraderEgg, "Mount Trader Egg");

        SpawnEggsHandler EntityAnchorTraderEggInit = new SpawnEggsHandler(EntityAnchorTrader.class);
        EntityAnchorTraderEggInit.setUnlocalizedName("entity_anchor_trader_egg");
        EntityAnchorTraderEgg =EntityAnchorTraderEggInit;
        GameRegistry.registerItem(EntityAnchorTraderEgg, "Anchor Trader Egg");

        SpawnEggsHandler EntityBlackKnightEggInit = new SpawnEggsHandler(EntityBlackKnight.class);
        EntityBlackKnightEggInit.setUnlocalizedName("entity_black_knight_egg");
        EntityBlackKnightEgg =EntityBlackKnightEggInit;
        GameRegistry.registerItem(EntityBlackKnightEgg, "Black Knight Egg");

        SpawnEggsHandler EntityHannibalEggInit = new SpawnEggsHandler(EntityHannibal.class);
        EntityHannibalEggInit.setUnlocalizedName("entity_hannibal_egg");
        EntityHannibalEgg =EntityHannibalEggInit;
        GameRegistry.registerItem(EntityHannibalEgg, "Hannibal Egg");

        SpawnEggsHandler EntityRemnantEggInit = new SpawnEggsHandler(EntityRemnant.class);
        EntityRemnantEggInit.setUnlocalizedName("entity_remnant_egg");
        EntityRemnantEgg =EntityRemnantEggInit;
        GameRegistry.registerItem(EntityRemnantEgg, "Remnant Egg");

        SpawnEggsHandler EntityVoidLordEggInit = new SpawnEggsHandler(EntityVoidLord.class);
        EntityVoidLordEggInit.setUnlocalizedName("entity_void_lord_egg");
        EntityVoidLordEgg =EntityVoidLordEggInit;
        GameRegistry.registerItem(EntityVoidLordEgg, "Void Lord Egg");

        SpawnEggsHandler EntityDarkKnightEggInit = new SpawnEggsHandler(EntityDarkKnight.class);
        EntityDarkKnightEggInit.setUnlocalizedName("entity_dark_knight_egg");
        EntityDarkKnightEgg =EntityDarkKnightEggInit;
        GameRegistry.registerItem(EntityDarkKnightEgg, "Dark Knight Egg");

        SpawnEggsHandler EntityNetherGhostEggInit = new SpawnEggsHandler(EntityNetherGhost.class);
        EntityNetherGhostEggInit.setUnlocalizedName("entity_nether_ghost_egg");
        EntityNetherGhostEgg =EntityNetherGhostEggInit;
        GameRegistry.registerItem(EntityNetherGhostEgg, "Nether Ghost Egg");

        SpawnEggsHandler EntityNetherSoulEggInit = new SpawnEggsHandler(EntityNetherSoul.class);
        EntityNetherSoulEggInit.setUnlocalizedName("entity_nether_soul_egg");
        EntityNetherSoulEgg =EntityNetherSoulEggInit;
        GameRegistry.registerItem(EntityNetherSoulEgg, "Nether Soul Egg");

        SpawnEggsHandler EntityNetherPigmanEggInit = new SpawnEggsHandler(EntityNetherPigman.class);
        EntityNetherPigmanEggInit.setUnlocalizedName("entity_nether_pigman_egg");
        EntityNetherPigmanEgg =EntityNetherPigmanEggInit;
        GameRegistry.registerItem(EntityNetherPigmanEgg, "Nether Pigman Egg");

        SpawnEggsHandler EntityVampireEggInit = new SpawnEggsHandler(EntityVampire.class);
        EntityVampireEggInit.setUnlocalizedName("entity_vampire_egg");
        EntityVampireEgg =EntityVampireEggInit;
        GameRegistry.registerItem(EntityVampireEgg, "Vampire Egg");

        SpawnEggsHandler EntityLavaTrollEggInit = new SpawnEggsHandler(EntityLavaTroll.class);
        EntityLavaTrollEggInit.setUnlocalizedName("entity_lava_troll_egg");
        EntityLavaTrollEgg =EntityLavaTrollEggInit;
        GameRegistry.registerItem(EntityLavaTrollEgg, "Lava Troll Egg");

        SpawnEggsHandler EntityLavaKnightEggInit = new SpawnEggsHandler(EntityLavaKnight.class);
        EntityLavaKnightEggInit.setUnlocalizedName("entity_lava_knight_egg");
        EntityLavaKnightEgg =EntityLavaKnightEggInit;
        GameRegistry.registerItem(EntityLavaKnightEgg, "Lava Knight Egg");

        SpawnEggsHandler EntityNetherBadgererEggInit = new SpawnEggsHandler(EntityNetherBadgerer.class);
        EntityNetherBadgererEggInit.setUnlocalizedName("entity_nether_badgerer_egg");
        EntityNetherBadgererEgg =EntityNetherBadgererEggInit;
        GameRegistry.registerItem(EntityNetherBadgererEgg, "Nether Badgerer Egg");

        SpawnEggsHandler EntityBeholderEggInit = new SpawnEggsHandler(EntityBeholder.class);
        EntityBeholderEggInit.setUnlocalizedName("entity_beholder_egg");
        EntityBeholderEgg =EntityBeholderEggInit;
        GameRegistry.registerItem(EntityBeholderEgg, "Beholder Egg");

        SpawnEggsHandler EntityFireclopsEggInit = new SpawnEggsHandler(EntityFireclops.class);
        EntityFireclopsEggInit.setUnlocalizedName("entity_fireclops_egg");
        EntityFireclopsEgg =EntityFireclopsEggInit;
        GameRegistry.registerItem(EntityFireclopsEgg, "Fireclops Egg");

        SpawnEggsHandler EntityCrystalBadgererEggInit = new SpawnEggsHandler(EntityCrystalBadgerer.class);
        EntityCrystalBadgererEggInit.setUnlocalizedName("entity_crystal_badgerer_egg");
        EntityCrystalBadgererEgg =EntityCrystalBadgererEggInit;
        GameRegistry.registerItem(EntityCrystalBadgererEgg, "Crystal Badgerer Egg");

        SpawnEggsHandler EntityAmethystMonsterEggInit = new SpawnEggsHandler(EntityAmethystMonster.class);
        EntityAmethystMonsterEggInit.setUnlocalizedName("entity_amethyst_monster_egg");
        EntityAmethystMonsterEgg =EntityAmethystMonsterEggInit;
        GameRegistry.registerItem(EntityAmethystMonsterEgg, "Amethyst Monster Egg");

        SpawnEggsHandler EntityGhostWitherEggInit = new SpawnEggsHandler(EntityGhostWither.class);
        EntityGhostWitherEggInit.setUnlocalizedName("entity_ghost_wither_egg");
        EntityGhostWitherEgg =EntityGhostWitherEggInit;
        GameRegistry.registerItem(EntityGhostWitherEgg, "Ghost Wither Egg");

        SpawnEggsHandler EntityTreeVillagerEggInit = new SpawnEggsHandler(EntityTreeVillager.class);
        EntityTreeVillagerEggInit.setUnlocalizedName("entity_tree_villager_egg");
        EntityTreeVillagerEgg =EntityTreeVillagerEggInit;
        GameRegistry.registerItem(EntityTreeVillagerEgg, "Tree Villager Egg");

        SpawnEggsHandler EntityQuarryMasterEggInit = new SpawnEggsHandler(EntityQuarryMaster.class);
        EntityQuarryMasterEggInit.setUnlocalizedName("entity_quarry_master_egg");
        EntityQuarryMasterEgg =EntityQuarryMasterEggInit;
        GameRegistry.registerItem(EntityQuarryMasterEgg, "Quarry Master Egg");

        SpawnEggsHandler EntityMinerVillagerEggInit = new SpawnEggsHandler(EntityMinerVillager.class);
        EntityMinerVillagerEggInit.setUnlocalizedName("entity_miner_villager_egg");
        EntityMinerVillagerEgg =EntityMinerVillagerEggInit;
        GameRegistry.registerItem(EntityMinerVillagerEgg, "Miner Villager Egg");

        SpawnEggsHandler EntityTalkingVillagerEggInit = new SpawnEggsHandler(EntityTalkingVillager.class);
        EntityTalkingVillagerEggInit.setUnlocalizedName("entity_talking_villager_egg");
        EntityTalkingVillagerEgg =EntityTalkingVillagerEggInit;
        GameRegistry.registerItem(EntityTalkingVillagerEgg, "Talking Villager Egg");

        SpawnEggsHandler EntityChainMummyEggInit = new SpawnEggsHandler(EntityChainMummy.class);
        EntityChainMummyEggInit.setUnlocalizedName("entity_chain_mummy_egg");
        EntityChainMummyEgg =EntityChainMummyEggInit;
        GameRegistry.registerItem(EntityChainMummyEgg, "Chain Mummy Egg");

        SpawnEggsHandler EntityEyeWarriorEggInit = new SpawnEggsHandler(EntityEyeWarrior.class);
        EntityEyeWarriorEggInit.setUnlocalizedName("entity_eye_warrior_egg");
        EntityEyeWarriorEgg =EntityEyeWarriorEggInit;
        GameRegistry.registerItem(EntityEyeWarriorEgg, "Eye Warrior Egg");

        SpawnEggsHandler EntityYetiEggInit = new SpawnEggsHandler(EntityYeti.class);
        EntityYetiEggInit.setUnlocalizedName("entity_yeti_egg");
        EntityYetiEgg =EntityYetiEggInit;
        GameRegistry.registerItem(EntityYetiEgg, "Yeti Egg");

        SpawnEggsHandler EntitySnowGiantEggInit = new SpawnEggsHandler(EntitySnowGiant.class);
        EntitySnowGiantEggInit.setUnlocalizedName("entity_snow_giant_egg");
        EntitySnowGiantEgg =EntitySnowGiantEggInit;
        GameRegistry.registerItem(EntitySnowGiantEgg, "Snow Giant Egg");

        SpawnEggsHandler EntityDeathBringerEggInit = new SpawnEggsHandler(EntityDeathBringer.class);
        EntityDeathBringerEggInit.setUnlocalizedName("entity_death_bringer_egg");
        EntityDeathBringerEgg =EntityDeathBringerEggInit;
        GameRegistry.registerItem(EntityDeathBringerEgg, "Death Bringer Egg");

        SpawnEggsHandler EntityDungeonBeastEggInit = new SpawnEggsHandler(EntityDungeonBeast.class);
        EntityDungeonBeastEggInit.setUnlocalizedName("entity_dungeon_beast_egg");
        EntityDungeonBeastEgg =EntityDungeonBeastEggInit;
        GameRegistry.registerItem(EntityDungeonBeastEgg, "Dungeon Beast Egg");

        SpawnEggsHandler EntityDesertDraggerEggInit = new SpawnEggsHandler(EntityDesertDragger.class);
        EntityDesertDraggerEggInit.setUnlocalizedName("entity_desert_dragger_egg");
        EntityDesertDraggerEgg =EntityDesertDraggerEggInit;
        GameRegistry.registerItem(EntityDesertDraggerEgg, "Desert Dragger Egg");

        SpawnEggsHandler EntityTavernMasterEggInit = new SpawnEggsHandler(EntityTavernMaster.class);
        EntityTavernMasterEggInit.setUnlocalizedName("entity_tavern_master_egg");
        EntityTavernMasterEgg =EntityTavernMasterEggInit;
        GameRegistry.registerItem(EntityTavernMasterEgg, "Tavern Master Egg");

        SpawnEggsHandler EntityTavernClientEggInit = new SpawnEggsHandler(EntityTavernClient.class);
        EntityTavernClientEggInit.setUnlocalizedName("entity_tavern_client_egg");
        EntityTavernClientEgg =EntityTavernClientEggInit;
        GameRegistry.registerItem(EntityTavernClientEgg, "Tavern Client Egg");

        SpawnEggsHandler EntityNetherWalkerEggInit = new SpawnEggsHandler(EntityNetherWalker.class);
        EntityNetherWalkerEggInit.setUnlocalizedName("entity_nether_walker_egg");
        EntityNetherWalkerEgg =EntityNetherWalkerEggInit;
        GameRegistry.registerItem(EntityNetherWalkerEgg, "Nether Walker Egg");

        SpawnEggsHandler EntityIceShielderEggInit = new SpawnEggsHandler(EntityIceShielder.class);
        EntityIceShielderEggInit.setUnlocalizedName("entity_ice_shielder_egg");
        EntityIceShielderEgg =EntityIceShielderEggInit;
        GameRegistry.registerItem(EntityIceShielderEgg, "Ice Shielder Egg");

        SpawnEggsHandler EntityOrcEggInit = new SpawnEggsHandler(EntityOrc.class);
        EntityOrcEggInit.setUnlocalizedName("entity_orc_egg");
        EntityOrcEgg =EntityOrcEggInit;
        GameRegistry.registerItem(EntityOrcEgg, "Orc Egg");

        SpawnEggsHandler EntityOrcMageEggInit = new SpawnEggsHandler(EntityOrcMage.class);
        EntityOrcMageEggInit.setUnlocalizedName("entity_orc_mage_egg");
        EntityOrcMageEgg =EntityOrcMageEggInit;
        GameRegistry.registerItem(EntityOrcMageEgg, "Orc Mage Egg");

        SpawnEggsHandler EntityOrcDefenderEggInit = new SpawnEggsHandler(EntityOrcDefender.class);
        EntityOrcDefenderEggInit.setUnlocalizedName("entity_orc_defender_egg");
        EntityOrcDefenderEgg =EntityOrcDefenderEggInit;
        GameRegistry.registerItem(EntityOrcDefenderEgg, "Orc Defender Egg");

        SpawnEggsHandler EntityRockTrollEggInit = new SpawnEggsHandler(EntityRockTroll.class);
        EntityRockTrollEggInit.setUnlocalizedName("entity_rock_troll_egg");
        EntityRockTrollEgg =EntityRockTrollEggInit;
        GameRegistry.registerItem(EntityRockTrollEgg, "Rock Troll Egg");

        SpawnEggsHandler EntityEarthRupturerEggInit = new SpawnEggsHandler(EntityEarthRupturer.class);
        EntityEarthRupturerEggInit.setUnlocalizedName("entity_earth_rupturer_egg");
        EntityEarthRupturerEgg =EntityEarthRupturerEggInit;
        GameRegistry.registerItem(EntityEarthRupturerEgg, "Earth Rupturer Egg");

        SpawnEggsHandler EntityIceSpiritEggInit = new SpawnEggsHandler(EntityIceSpirit.class);
        EntityIceSpiritEggInit.setUnlocalizedName("entity_ice_spirit_egg");
        EntityIceSpiritEgg =EntityIceSpiritEggInit;
        GameRegistry.registerItem(EntityIceSpiritEgg, "Ice Spirit Egg");

        SpawnEggsHandler EntityUndefeatableStrengthEggInit = new SpawnEggsHandler(EntityUndefeatableStrength.class);
        EntityUndefeatableStrengthEggInit.setUnlocalizedName("entity_undefeatable_strenght_egg");
        EntityUndefeatableStrengthEgg =EntityUndefeatableStrengthEggInit;
        GameRegistry.registerItem(EntityUndefeatableStrengthEgg, "Undefeatable Strenght Egg");

        SpawnEggsHandler EntityUndefeatableResistanceEggInit = new SpawnEggsHandler(EntityUndefeatableResistance.class);
        EntityUndefeatableResistanceEggInit.setUnlocalizedName("entity_undefeatable_resistance_egg");
        EntityUndefeatableResistanceEgg =EntityUndefeatableResistanceEggInit;
        GameRegistry.registerItem(EntityUndefeatableResistanceEgg, "Undefeatable Resistance Egg");

        SpawnEggsHandler EntityUndefeatableRegenEggInit = new SpawnEggsHandler(EntityUndefeatableRegen.class);
        EntityUndefeatableRegenEggInit.setUnlocalizedName("entity_undefeatable_regen_egg");
        EntityUndefeatableRegenEgg =EntityUndefeatableRegenEggInit;
        GameRegistry.registerItem(EntityUndefeatableRegenEgg, "Undefeatable Regen Egg");

        SpawnEggsHandler EntitySapientEliteKnightEggInit = new SpawnEggsHandler(EntitySapientEliteKnight.class);
        EntitySapientEliteKnightEggInit.setUnlocalizedName("entity_sapient_elite_knight_egg");
        EntitySapientEliteKnightEgg =EntitySapientEliteKnightEggInit;
        GameRegistry.registerItem(EntitySapientEliteKnightEgg, "Sapient Elite Knight Egg");

        SpawnEggsHandler EntitySapientGeneralEggInit = new SpawnEggsHandler(EntitySapientGeneral.class);
        EntitySapientGeneralEggInit.setUnlocalizedName("entity_sapient_general_egg");
        EntitySapientGeneralEgg =EntitySapientGeneralEggInit;
        GameRegistry.registerItem(EntitySapientGeneralEgg, "Sapient General Egg");

        SpawnEggsHandler EntityMontaneVillagerEggInit = new SpawnEggsHandler(EntityMontaneVillager.class);
        EntityMontaneVillagerEggInit.setUnlocalizedName("entity_montane_villager_egg");
        EntityMontaneVillagerEgg = EntityMontaneVillagerEggInit;
        GameRegistry.registerItem(EntityMontaneVillagerEgg, "Montane Villager Egg");

        SpawnEggsHandler EntityMontaneTraderEggInit = new SpawnEggsHandler(EntityMontaneTrader.class);
        EntityMontaneTraderEggInit.setUnlocalizedName("entity_montane_trader_egg");
        EntityMontaneTraderEgg = EntityMontaneTraderEggInit;
        GameRegistry.registerItem(EntityMontaneTraderEgg, "Montane Trader Egg");

        SpawnEggsHandler EntityMidnightShadeEggInit = new SpawnEggsHandler(EntityMidnightShade.class);
        EntityMidnightShadeEggInit.setUnlocalizedName("entity_midnight_shade_egg");
        EntityMidnightShadeEgg = EntityMidnightShadeEggInit;
        GameRegistry.registerItem(EntityMidnightShadeEgg, "Midnight Shade Egg");

        SpawnEggsHandler EntitySapientMageEggInit = new SpawnEggsHandler(EntitySapientMage.class);
        EntitySapientMageEggInit.setUnlocalizedName("entity_sapient_mage_egg");
        EntitySapientMageEgg = EntitySapientMageEggInit;
        GameRegistry.registerItem(EntitySapientMageEgg, "Sapient Mage Egg");

        SpawnEggsHandler EntityCrystalTrollEggInit = new SpawnEggsHandler(EntityCrystalTroll.class);
        EntityCrystalTrollEggInit.setUnlocalizedName("entity_crystal_troll_egg");
        EntityCrystalTrollEgg = EntityCrystalTrollEggInit;
        GameRegistry.registerItem(EntityCrystalTrollEgg, "Crystal Troll Egg");

        SpawnEggsHandler EntityCrystasisEggInit = new SpawnEggsHandler(EntityCrystasis.class);
        EntityCrystasisEggInit.setUnlocalizedName("entity_crystasis_egg");
        EntityCrystasisEgg = EntityCrystasisEggInit;
        GameRegistry.registerItem(EntityCrystasisEgg, "Crystasis Egg");

        SpawnEggsHandler EntityCrystoxEggInit = new SpawnEggsHandler(EntityCrystox.class);
        EntityCrystoxEggInit.setUnlocalizedName("entity_crystox_egg");
        EntityCrystoxEgg = EntityCrystoxEggInit;
        GameRegistry.registerItem(EntityCrystoxEgg, "Crystox Egg");

        SpawnEggsHandler EntityExawdusEggInit = new SpawnEggsHandler(EntityExawdus.class);
        EntityExawdusEggInit.setUnlocalizedName("entity_exawdus_egg");
        EntityExawdusEgg = EntityExawdusEggInit;
        GameRegistry.registerItem(EntityExawdusEgg, "Exawdus Egg");

        SpawnEggsHandler EntityCrystalliumGolemEggInit = new SpawnEggsHandler(EntityCrystalliumGolem.class);
        EntityCrystalliumGolemEggInit.setUnlocalizedName("entity_crystallium_golem_egg");
        EntityCrystalliumGolemEgg = EntityCrystalliumGolemEggInit;
        GameRegistry.registerItem(EntityCrystalliumGolemEgg, "Crystallium Golem Egg");

        SpawnEggsHandler EntityMidnightChickenEggInit = new SpawnEggsHandler(EntityMidnightChicken.class);
        EntityMidnightChickenEggInit.setUnlocalizedName("entity_midnight_chicken_egg");
        EntityMidnightChickenEgg = EntityMidnightChickenEggInit;
        GameRegistry.registerItem(EntityMidnightChickenEgg, "Midnight Chicken Egg");

        SpawnEggsHandler EntityMidnightCowEggInit = new SpawnEggsHandler(EntityMidnightCow.class);
        EntityMidnightCowEggInit.setUnlocalizedName("entity_midnight_cow_egg");
        EntityMidnightCowEgg = EntityMidnightCowEggInit;
        GameRegistry.registerItem(EntityMidnightCowEgg, "Midnight Cow Egg");

        SpawnEggsHandler EntityNightMiteEggInit = new SpawnEggsHandler(EntityNightMite.class);
        EntityNightMiteEggInit.setUnlocalizedName("entity_night_mite_egg");
        EntityNightMiteEgg = EntityNightMiteEggInit;
        GameRegistry.registerItem(EntityNightMiteEgg, "Night Mite Egg");

        SpawnEggsHandler EntityMidnightTraderEggInit = new SpawnEggsHandler(EntityMidnightTrader.class);
        EntityMidnightTraderEggInit.setUnlocalizedName("entity_midnight_trader_egg");
        EntityMidnightTraderEgg = EntityMidnightTraderEggInit;
        GameRegistry.registerItem(EntityMidnightTraderEgg, "Midnight Trader Egg");

        SpawnEggsHandler EntityCaveWraithEggInit = new SpawnEggsHandler(EntityCaveWraith.class);
        EntityCaveWraithEggInit.setUnlocalizedName("entity_cave_wraith_egg");
        EntityCaveWraithEgg = EntityCaveWraithEggInit;
        GameRegistry.registerItem(EntityCaveWraithEgg, "Cave Wraith Egg");

        SpawnEggsHandler EntityFireflyEggInit = new SpawnEggsHandler(EntityFirefly.class);
        EntityFireflyEggInit.setUnlocalizedName("entity_firefly_egg");
        EntityFireflyEgg = EntityFireflyEggInit;
        GameRegistry.registerItem(EntityFireflyEgg, "Firefly Egg");

        SpawnEggsHandler EntityMidnightTitanEggInit = new SpawnEggsHandler(EntityMidnightTitan.class);
        EntityMidnightTitanEggInit.setUnlocalizedName("entity_midnight_titan_egg");
        EntityMidnightTitanEgg = EntityMidnightTitanEggInit;
        GameRegistry.registerItem(EntityMidnightTitanEgg, "Midnight Titan Egg");

        SpawnEggsHandler EntityMidnightMagicianEggInit = new SpawnEggsHandler(EntityMidnightMagician.class);
        EntityMidnightMagicianEggInit.setUnlocalizedName("entity_midnight_magician_egg");
        EntityMidnightMagicianEgg = EntityMidnightMagicianEggInit;
        GameRegistry.registerItem(EntityMidnightMagicianEgg, "Midnight Magician Egg");

        SpawnEggsHandler EntityTreeGolemEggInit = new SpawnEggsHandler(EntityTreeGolem.class);
        EntityTreeGolemEggInit.setUnlocalizedName("entity_tree_golem_egg");
        EntityTreeGolemEgg = EntityTreeGolemEggInit;
        GameRegistry.registerItem(EntityTreeGolemEgg, "Dark Ent Egg");

        SpawnEggsHandler EntityPaladinEggInit = new SpawnEggsHandler(EntityPaladin.class);
        EntityPaladinEggInit.setUnlocalizedName("entity_paladin_egg");
        EntityPaladinEgg = EntityPaladinEggInit;
        GameRegistry.registerItem(EntityPaladinEgg, "Paladin Egg");
        SpawnEggsHandler EntityNothingEggInit = new SpawnEggsHandler(EntityNothing.class);
        EntityNothingEggInit.setUnlocalizedName("entity_nothing_egg");
        EntityNothingEgg = EntityNothingEggInit;
        GameRegistry.registerItem(EntityNothingEgg, "Nothing Egg");
    }
}
