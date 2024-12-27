package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final DFSmpPlugin plugin;

    private static File accessoryDataFile;
    public static FileConfiguration accessoryData;

    private static File otherDataFile;
    public static FileConfiguration otherData;

    private static File trackingDataFile;
    public static FileConfiguration trackingData;

    public ConfigManager(DFSmpPlugin plugin) {
        this.plugin = plugin;

        initialiseAccessoryData();
        initialiseTrackingData();
        initialiseOtherData();
    }

    public enum DataFiles {
        ACCESSORY,
        TRACKING,
        OTHER
    }

    public static void saveData(DataFiles data) {
        try {
            if (data == DataFiles.ACCESSORY) {
                accessoryData.save(accessoryDataFile);
            } else if (data == DataFiles.TRACKING) {
                trackingData.save(trackingDataFile);
            } else if (data == DataFiles.OTHER) {
                otherData.save(otherDataFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialiseAccessoryData() {
        accessoryDataFile = new File(plugin.getDataFolder(), "accessory.yml");
        if (!accessoryDataFile.exists()) {
            accessoryDataFile.getParentFile().mkdirs();
            plugin.saveResource("accessory.yml", false);
        }

        accessoryData = new YamlConfiguration();
        try {
            accessoryData.load(accessoryDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void initialiseTrackingData() {
        trackingDataFile = new File(plugin.getDataFolder(), "tracking.yml");
        if (!trackingDataFile.exists()) {
            trackingDataFile.getParentFile().mkdirs();
            plugin.saveResource("tracking.yml", false);
        }

        trackingData = new YamlConfiguration();
        try {
            trackingData.load(trackingDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void initialiseOtherData() {
        otherDataFile = new File(plugin.getDataFolder(), "other.yml");
        if (!otherDataFile.exists()) {
            otherDataFile.getParentFile().mkdirs();
            plugin.saveResource("other.yml", false);
        }

        otherData = new YamlConfiguration();
        try {
            otherData.load(otherDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
