package com.gibby.dungeon.util;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

public class FileInjector {
    public static void preinit(final FMLPreInitializationEvent event) {
        // Get the current Minecraft instance directory
        File minecraftDir = event.getModConfigurationDirectory().getParentFile();

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
            "ARCANA_RPG_WorldGenWarlordDungeonV1.1.rcst"
        };

        try {
            for (String sourceFileName : sourceFiles) {
                // Get an InputStream from the resource within the JAR
                InputStream inputStream = FileInjector.class.getClassLoader().getResourceAsStream("assets/gibby_dungeons/structures/active/" + sourceFileName);

                if (inputStream != null) {
                    // Copy the file from the InputStream to the destination directory
                    java.nio.file.Files.copy(inputStream, new File(destinationDirectoryPath, sourceFileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copy successful: " + sourceFileName);
                } else {
                    System.err.println("Source file not found in JAR resources: " + sourceFileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while copying files.");
        }
    }
}
