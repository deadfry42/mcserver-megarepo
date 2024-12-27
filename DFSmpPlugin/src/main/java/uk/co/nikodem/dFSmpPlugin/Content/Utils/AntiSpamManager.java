package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.entity.Player;

public class AntiSpamManager {

    // TODO: Rewrite this to not use config files

    public static boolean playerInCooldown(Player plr, String key, int totalLength) {
        try {
            Long logTime = totalLength*1000L;
            Long currentStamp = System.currentTimeMillis();
            Long plrLastStamp = ConfigManager.trackingData.getLong(key+"."+plr.getUniqueId());
            return !(currentStamp > (plrLastStamp+logTime));
        } catch (Error e) {
            return true;
        }
    }

    public static Long getPlayerCooldownTimestamp(Player plr, String key) {
        try {
            return ConfigManager.trackingData.getLong(key+"."+plr.getUniqueId());
        } catch (Error e) {
            return 0L;
        }
    }

    public static void playerRemoveCooldown(Player plr, String key) {
        ConfigManager.trackingData.set(key+"."+plr.getUniqueId(), 0);
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }

    public static void playerUpdateCooldownLog(Player plr, String key) {
        Long currentStamp = System.currentTimeMillis();
        ConfigManager.trackingData.set(key+"."+plr.getUniqueId(), currentStamp);
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }
}