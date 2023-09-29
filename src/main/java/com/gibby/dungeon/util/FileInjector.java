package com.gibby.dungeon.util;

import com.gibby.dungeon.config.ModConfig;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

public class FileInjector {
    private static ModConfig modConfig;

    public static void setModConfig(ModConfig config) {
        modConfig = config;
    }
    public static void preinit(final FMLPreInitializationEvent event) {
        // Get the current Minecraft instance directory
        File minecraftDir = event.getModConfigurationDirectory().getParentFile();

        boolean enableARCANA_RPG_archruins = modConfig.isARCANA_RPG_archruinsEnabled();
        boolean enableARCANA_RPG_LargeCastle3 = modConfig.isARCANA_RPG_LargeCastle3Enabled();
        boolean enableARCANA_RPG_SmallCastle = modConfig.isARCANA_RPG_SmallCastleEnabled();
        boolean enableARCANA_RPG_squareruins = modConfig.isARCANA_RPG_squareruinsEnabled();
        boolean enableARCANA_RPG_WorldGenBleachedDungeon = modConfig.isARCANA_RPG_WorldGenBleachedDungeonEnabled();
        boolean enableARCANA_RPG_WorldGenDesertTemple2 = modConfig.isARCANA_RPG_WorldGenDesertTemple2Enabled();
        boolean enableARCANA_RPG_WorldGenJungleTemple = modConfig.isARCANA_RPG_WorldGenJungleTempleEnabled();
        boolean enableARCANA_RPG_WorldGenKnightDungeon = modConfig.isARCANA_RPG_WorldGenKnightDungeonEnabled();
        boolean enableARCANA_RPG_WorldGenMoundVillage = modConfig.isARCANA_RPG_WorldGenMoundVillageEnabled();
        boolean enableARCANA_RPG_WorldGenNetherRuins = modConfig.isARCANA_RPG_WorldGenNetherRuinsEnabled();
        boolean enableARCANA_RPG_WorldGenNetherTower = modConfig.isARCANA_RPG_WorldGenNetherTowerEnabled();
        boolean enableARCANA_RPG_WorldGenObelisk = modConfig.isARCANA_RPG_WorldGenObeliskEnabled();
        boolean enableARCANA_RPG_WorldGenStoneGolemDungeon = modConfig.isARCANA_RPG_WorldGenStoneGolemDungeonEnabled();
        boolean enableARCANA_RPG_WorldGenTallNetherRuins = modConfig.isARCANA_RPG_WorldGenTallNetherRuinsEnabled();
        boolean enableARCANA_RPG_WorldGenTavern = modConfig.isARCANA_RPG_WorldGenTavernEnabled();
        boolean enableARCANA_RPG_WorldGenVampireCastle = modConfig.isARCANA_RPG_WorldGenVampireCastleEnabled();
        boolean enableARCANA_RPG_WorldGenVoidDungeon = modConfig.isARCANA_RPG_WorldGenVoidDungeonEnabled();
        boolean enableARCANA_RPG_WorldGenWarlordDungeon = modConfig.isARCANA_RPG_WorldGenWarlordDungeonEnabled();
        boolean enableARCANA_RPG_WorldGenAmethystRuins = modConfig.isARCANA_RPG_WorldGenAmethystRuinsEnabled();
        boolean enableARCANA_RPG_WorldGenGhostWitherTower = modConfig.isARCANA_RPG_WorldGenGhostWitherTowerEnabled();
        boolean enableARCANA_RPG_WorldGenCrystalHouse = modConfig.isARCANA_RPG_WorldGenCrystalHouseEnabled();
        boolean enableARCANA_RPG_WorldGenCrystalliumVillage = modConfig.isARCANA_RPG_WorldGenCrystalliumVillageEnabled();
        boolean enableARCANA_RPG_WorldGenCrystalBamboo4 = modConfig.isARCANA_RPG_WorldGenCrystalBamboo4Enabled();
        boolean enableARCANA_RPG_WorldGenCrystalBamboo3 = modConfig.isARCANA_RPG_WorldGenCrystalBamboo3Enabled();
        boolean enableARCANA_RPG_WorldGenCrystalBamboo2 = modConfig.isARCANA_RPG_WorldGenCrystalBamboo2Enabled();
        boolean enableARCANA_RPG_WorldGenCrystalBamboo1 = modConfig.isARCANA_RPG_WorldGenCrystalBamboo1Enabled();
        boolean enableARCANA_RPG_WorldGenCaveMushrooms1 = modConfig.isARCANA_RPG_WorldGenCaveMushrooms1Enabled();
        boolean enableARCANA_RPG_WorldGenCaveMushrooms2 = modConfig.isARCANA_RPG_WorldGenCaveMushrooms2Enabled();
        boolean enableARCANA_RPG_WorldGenCaveMushrooms3 = modConfig.isARCANA_RPG_WorldGenCaveMushrooms3Enabled();
        boolean enableARCANA_RPG_WorldGenCrystalliumTemple = modConfig.isARCANA_RPG_WorldGenCrystalliumTempleEnabled();
        boolean enableARCANA_RPG_WorldGenCrystalliumShrine = modConfig.isARCANA_RPG_WorldGenCrystalliumShrineEnabled();
        boolean enableARCANA_RPG_WorldGenCrystalliumCoocoon = modConfig.isARCANA_RPG_WorldGenCrystalliumCoocoonEnabled();

        // Path to the destination directory within the Minecraft instance folder
        String destinationDirectoryPath = new File(minecraftDir, "structures/active").getAbsolutePath();

        // List of source file names
        String[] sourceFiles = {
            "ARCANA_RPG_archruinsV1.2.rcst",
            "ARCANA_RPG_LargeCastle3V1.1.rcst",
            "ARCANA_RPG_SmallCastleV1.2.1.rcst",
            "ARCANA_RPG_squareruinsV1.1.rcst",
            "ARCANA_RPG_WorldGenBleachedDungeonV1.1.rcst",
            "ARCANA_RPG_WorldGenDesertTemple2V1.1.rcst",
            "ARCANA_RPG_WorldGenJungleTempleV1.1.rcst",
            "ARCANA_RPG_WorldGenKnightDungeonV1.1.rcst",
            "ARCANA_RPG_WorldGenMoundVillageV1.0.rcst",
            "ARCANA_RPG_WorldGenNetherRuinsV1.1.rcst",
            "ARCANA_RPG_WorldGenNetherTowerV1.1.rcst",
            "ARCANA_RPG_WorldGenObeliskV1.1.rcst",
            "ARCANA_RPG_WorldGenStoneGolemDungeonV1.2.1.rcst",
            "ARCANA_RPG_WorldGenTallNetherRuinsV1.1.rcst",
            "ARCANA_RPG_WorldGenTavernV1.0.rcst",
            "ARCANA_RPG_WorldGenVampireCastleV1.1.rcst",
            "ARCANA_RPG_WorldGenVoidDungeonV1.0.rcst",
            "ARCANA_RPG_WorldGenWarlordDungeonV1.1.rcst",
            "ARCANA_RPG_WorldGenAmethystRuinsV1.0.rcst",
            "ARCANA_RPG_WorldGenGhostWitherTowerV1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalHouseV1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalliumVillageV1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalBamboo4V1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalBamboo3V1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalBamboo2V1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalBamboo1V1.0.rcst",
            "ARCANA_RPG_WorldGenCaveMushrooms1V1.0.rcst",
            "ARCANA_RPG_WorldGenCaveMushrooms2V1.0.rcst",
            "ARCANA_RPG_WorldGenCaveMushrooms3V1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalliumTempleV1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalliumShrineV1.0.rcst",
            "ARCANA_RPG_WorldGenCrystalliumCoocoonV1.0.rcst"

        };

        try {
            // Get all the files in the destination directory
            File destinationDirectory = new File(destinationDirectoryPath);
            File[] filesInDestination = destinationDirectory.listFiles();

            // Delete the files that are not in the list of allowed files.
            if (filesInDestination != null) {
                for (File file : filesInDestination) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (!isValidFileName(fileName, sourceFiles)) {
                            if (file.delete()) {
                                System.out.println("File deleted: " + fileName + " (not in the allowed list)");
                            } else {
                                System.err.println("Failed to delete file: " + fileName);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < sourceFiles.length; i++) {
                String sourceFileName = sourceFiles[i];
                boolean isEnabled = false;

                // Determine if the current .rcst file should be enabled based on the configuration
                if (i == 0) isEnabled = enableARCANA_RPG_archruins;
                else if (i == 1) isEnabled = enableARCANA_RPG_LargeCastle3;
                else if (i == 2) isEnabled = enableARCANA_RPG_SmallCastle;
                else if (i == 3) isEnabled = enableARCANA_RPG_squareruins;
                else if (i == 4) isEnabled = enableARCANA_RPG_WorldGenBleachedDungeon;
                else if (i == 5) isEnabled = enableARCANA_RPG_WorldGenDesertTemple2;
                else if (i == 6) isEnabled = enableARCANA_RPG_WorldGenJungleTemple;
                else if (i == 7) isEnabled = enableARCANA_RPG_WorldGenKnightDungeon;
                else if (i == 8) isEnabled = enableARCANA_RPG_WorldGenMoundVillage;
                else if (i == 9) isEnabled = enableARCANA_RPG_WorldGenNetherRuins;
                else if (i == 10) isEnabled = enableARCANA_RPG_WorldGenNetherTower;
                else if (i == 11) isEnabled = enableARCANA_RPG_WorldGenObelisk;
                else if (i == 12) isEnabled = enableARCANA_RPG_WorldGenStoneGolemDungeon;
                else if (i == 13) isEnabled = enableARCANA_RPG_WorldGenTallNetherRuins;
                else if (i == 14) isEnabled = enableARCANA_RPG_WorldGenTavern;
                else if (i == 15) isEnabled = enableARCANA_RPG_WorldGenVampireCastle;
                else if (i == 16) isEnabled = enableARCANA_RPG_WorldGenVoidDungeon;
                else if (i == 17) isEnabled = enableARCANA_RPG_WorldGenWarlordDungeon;
                else if (i == 18) isEnabled = enableARCANA_RPG_WorldGenAmethystRuins;
                else if (i == 19) isEnabled = enableARCANA_RPG_WorldGenGhostWitherTower;
                else if (i == 20) isEnabled = enableARCANA_RPG_WorldGenCrystalHouse;
                else if (i == 21) isEnabled = enableARCANA_RPG_WorldGenCrystalliumVillage;
                else if (i == 22) isEnabled = enableARCANA_RPG_WorldGenCrystalBamboo4;
                else if (i == 23) isEnabled = enableARCANA_RPG_WorldGenCrystalBamboo3;
                else if (i == 24) isEnabled = enableARCANA_RPG_WorldGenCrystalBamboo2;
                else if (i == 25) isEnabled = enableARCANA_RPG_WorldGenCrystalBamboo1;
                else if (i == 26) isEnabled = enableARCANA_RPG_WorldGenCaveMushrooms1;
                else if (i == 27) isEnabled = enableARCANA_RPG_WorldGenCaveMushrooms2;
                else if (i == 28) isEnabled = enableARCANA_RPG_WorldGenCaveMushrooms3;
                else if (i == 29) isEnabled = enableARCANA_RPG_WorldGenCrystalliumTemple;
                else if (i == 30) isEnabled = enableARCANA_RPG_WorldGenCrystalliumShrine;
                else if (i == 31) isEnabled = enableARCANA_RPG_WorldGenCrystalliumCoocoon;


                if (isEnabled) {
                    // Get an InputStream from the resource within the JAR
                    InputStream inputStream = FileInjector.class.getClassLoader().getResourceAsStream("assets/gibby_dungeons/structures/active/" + sourceFileName);

                    if (inputStream != null) {
                        // Copy the file from the InputStream to the destination directory
                        java.nio.file.Files.copy(inputStream, new File(destinationDirectoryPath, sourceFileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copy successful: " + sourceFileName);
                    } else {
                        System.err.println("Source file not found in JAR resources: " + sourceFileName);
                    }
                } else {
                    // If the config is disabled, check if the file exists and delete it if it does
                    File existingFile = new File(destinationDirectoryPath, sourceFileName);
                    if (existingFile.exists() && existingFile.isFile()) {
                        if (existingFile.delete()) {
                            System.out.println("File deleted: " + sourceFileName + " (disabled in config)");
                        } else {
                            System.err.println("Failed to delete file: " + sourceFileName);
                        }
                    } else {
                        System.out.println("Skipped copying: " + sourceFileName + " (disabled in config)");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static boolean isValidFileName(String fileName, String[] allowedFiles) {
        for (String allowedFile : allowedFiles) {
            if (fileName.equals(allowedFile)) {
                return true;
            }
        }
        return false;
    }
}
