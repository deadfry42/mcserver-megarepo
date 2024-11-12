package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class AntiSpamManager {
    static FileConfiguration config;

    public static void init(DFSmpPlugin plugin) {
        config = plugin.getConfig();
    }

    public static boolean playerInCooldown(Player plr, String key, int totalLength) {
        try {
            Long logTime = totalLength*1000L;
            Long currentStamp = System.currentTimeMillis();
            Long plrLastStamp = config.getLong(key+"."+plr.getUniqueId());
            return !(currentStamp > (plrLastStamp+logTime));
        } catch (Error e) {
            return true;
        }
    }

    public static Long getPlayerCooldownTimestamp(Player plr, String key) {
        try {
            return config.getLong(key+"."+plr.getUniqueId());
        } catch (Error e) {
            return 0L;
        }
    }

    public static void playerRemoveCooldown(Player plr, String key) {
        config.set(key+"."+plr.getUniqueId(), 0);
    }

    public static void playerUpdateCooldownLog(Player plr, String key) {
        Long currentStamp = System.currentTimeMillis();
        config.set(key+"."+plr.getUniqueId(), currentStamp);
    }
}