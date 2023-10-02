package com.gibby.dungeon.config;

import com.gibby.dungeon.Dungeons;
import com.gibby.dungeon.gui.DungeonGuiIngame;
import com.gibby.dungeon.mobs.entityinstance.*;
import com.gibby.dungeon.util.DungeonEventHandler;
import com.gibby.dungeon.util.FileInjector;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ModConfig {
    private static int entitylistEnabled;
    private Configuration config;

    public static boolean loggingdisabler = true;

    public ModConfig(File configFile, FMLPreInitializationEvent event) {
        config = new Configuration(configFile);
    }

    public void initializeConfig(FMLPreInitializationEvent event) {
        config = new Configuration(new File(event.getModConfigurationDirectory(), "Arcana_RPG.cfg"));
        config.load();
        FileInjector.preinit(event);
        config.addCustomCategoryComment("Misc", "The Entity Id's Disabled will wipe vanilla minecraft spawners for Arcana RPG.");
        config.addCustomCategoryComment("Misc", "If disabled, custom spawners will not be wiped.");
        config.addCustomCategoryComment("Misc", "If you have entitylist conflicts, disable Entity Ids(set to 0)");
        entitylistEnabled = config.get("Misc", "Entity Ids Enabled(1) or Disabled(0)", 1).getInt();
        Dungeons.magicBarXpoz = config.get("Gui(bar)", "Magic_Bar_X_pos", 200).getInt();
        Dungeons.magicBarYpoz = config.get("Gui(bar)", "Magic_Bar_Y_poz", 10).getInt();
        Dungeons.sunsetBiomeId = config.get("Biome", "Sunset_Biome_Id", 250).getInt();
        Dungeons.crystalBiomeId = config.get("Biome", "Crystal_Biome_Id", 251).getInt();
        Dungeons.montaneBiomeId = config.get("Biome", "Montane_Biome_Id", 252).getInt();
        Dungeons.crystalliumPlainsBiomeId = config.get("Biome", "Crystallim_Plains_Biome_Id", 253).getInt();
        Dungeons.midnightBiomeId = config.get("Biome", "Midnight_Biome_Id", 254).getInt();
        Dungeons.sunsetDimensionId = config.get("Dimension", "Sunset_Dimension_Id(YOU SHOULDN'T CHANGE BIOMES IDS BECAUSE DUNGEON GENERATION WILL NOT WORK)", -15).getInt();
        Dungeons.crystalDimensionId = config.get("Dimension", "Crystal_Dimension_Id(YOU SHOULDN'T CHANGE BIOMES IDS BECAUSE DUNGEON GENERATION WILL NOT WORK)", -20).getInt();
        Dungeons.montaneDungeonDimensionId = config.get("Dimension", "Montane_Dungeon_Dimension_Id(YOU SHOULDN'T CHANGE BIOMES IDS BECAUSE DUNGEON GENERATION WILL NOT WORK)", -21).getInt();
        Dungeons.crystalliumPlainsDimensionId = config.get("Dimension", "Crystallium_Plains_Dimension_Id(YOU SHOULDN'T CHANGE BIOMES IDS BECAUSE DUNGEON GENERATION WILL NOT WORK)", -22).getInt();
        Dungeons.midnightDimensionId = config.get("Dimension", "Midnight_Dimension_Id(YOU SHOULDN'T CHANGE BIOMES IDS BECAUSE DUNGEON GENERATION WILL NOT WORK)", -23).getInt();
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
        loggingdisabler = config.get("Other", "Disable Some Loggings from the mod", 60).getBoolean();
        config.save();
    }
    public static void postInitializeConfig() {
        Dungeons.packetPipeline.postInitialise();
        if (entitylistEnabled == 1) {
            EntityList.addMapping(EntityGoblin.class, "EntityGoblin", setMobId());
            EntityList.addMapping(EntitySkeletonWarrior.class, "EntitySkeletonWarrior", setMobId());
            EntityList.addMapping(EntityEarthGolem.class, "EntityEarthGolem", setMobId());
            EntityList.addMapping(EntityStoneGolem.class, "EntityStoneGolem", setMobId());
            EntityList.addMapping(EntityBandit.class, "EntityBandit", setMobId());
            EntityList.addMapping(EntityBlackKnight.class, "EntityBlackKnight", setMobId());
            EntityList.addMapping(EntityNecro.class, "EntityNecro", setMobId());
            EntityList.addMapping(EntityTroll.class, "EntityTroll", setMobId());
            EntityList.addMapping(EntityVoidFiend.class, "EntityVoidFiend", setMobId());
            EntityList.addMapping(EntitySpirit.class, "EntitySpirit", setMobId());
            EntityList.addMapping(EntitySkeletonKnight.class, "EntitySkeletonKnight", setMobId());
            EntityList.addMapping(EntitySapientWarrior.class, "EntitySapientWarrior", setMobId());
            EntityList.addMapping(EntityNetherSoul.class, "EntityNetherSoul", setMobId());
            EntityList.addMapping(EntityAmethystMonster.class, "EntityAmethystMonster", setMobId());
            EntityList.addMapping(EntityVampire.class, "EntityVampire", setMobId());
            EntityList.addMapping(EntityLavaKnight.class, "EntityLavaKnight", setMobId());
        }
        if(FMLCommonHandler.instance().getSide()== Side.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new DungeonGuiIngame(Minecraft.getMinecraft()));
        }
        MinecraftForge.EVENT_BUS.register(new DungeonEventHandler());

    }
    static int setMobId() {
        int id;
        for (id = 130; EntityList.getClassFromID(id) != null; ++id) {}
        if (id > 255) {
            System.out.println("[ERROR] There are no more global entity id's for Arcana RPG");
        }
        return id;
    }

    public Configuration getConfig() {
        return config;
    }

    public boolean isARCANA_RPG_archruinsEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_archruinsV1.2", true).getBoolean();
    }
    public boolean isARCANA_RPG_LargeCastle3Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_LargeCastle3V1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_SmallCastleEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_SmallCastleV1.2.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_squareruinsEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_squareruinsV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenBleachedDungeonEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenBleachedDungeonV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenDesertTemple2Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenDesertTemple2V1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenJungleTempleEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenJungleTempleV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenKnightDungeonEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenKnightDungeonV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenMoundVillageEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenMoundVillageV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenNetherRuinsEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenNetherRuinsV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenNetherTowerEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenNetherTowerV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenObeliskEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenObeliskV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenStoneGolemDungeonEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenStoneGolemDungeonV1.2.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenTallNetherRuinsEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenTallNetherRuinsV1.2.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenTavernEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenTavernV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenVampireCastleEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenVampireCastleV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenVoidDungeonEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenVoidDungeonV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenWarlordDungeonEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenWarlordDungeonV1.1.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenAmethystRuinsEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenAmethystRuinsV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenGhostWitherTowerEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenGhostWitherTowerV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalHouseEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalHouseV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalliumVillageEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalliumVillageV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalBamboo1Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalBamboo1V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalBamboo2Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalBamboo2V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalBamboo3Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalBamboo3V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalBamboo4Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalBamboo4V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCaveMushrooms1Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCaveMushrooms1V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCaveMushrooms2Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCaveMushrooms2V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCaveMushrooms3Enabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCaveMushrooms3V1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalliumTempleEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalliumTempleV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalliumShrineEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalliumShrineV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenCrystalliumCoocoonEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenCrystalliumCoocoonV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenMidnightVillageEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenMidnightVillageV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_WorldGenRuneAltarEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_WorldGenRuneAltarV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_SunsetSpawnStructureEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_SunsetSpawnStructureV1.0.rcst", true).getBoolean();
    }
    public boolean isARCANA_RPG_MontaneSpawnStructureEnabled() {
        return config.get("Dungeon generation", "Enable ARCANA_RPG_MontaneSpawnStructureV1.0.rcst", true).getBoolean();
    }
}
