package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class CombatLoggingManager {
    static FileConfiguration config;

    public static void init(DFSmpPlugin plugin) {
        config = plugin.getConfig();
    }

    public static boolean playerInCombat(Player plr) {
        Long logTime = config.getInt("combatlogtime")*1000L;
        Long currentStamp = System.currentTimeMillis();
        Long plrLastStamp = config.getLong("combatlog."+plr.getUniqueId());
        return !(currentStamp > (plrLastStamp+logTime));
    }

    public static Long getPlayerCombatTimestamp(Player plr) {
        return config.getLong("combatlog."+plr.getUniqueId());
    }

    public static void playerRemoveCombatLog(Player plr) {
        config.set("combatlog."+plr.getUniqueId(), 0);
    }

    public static void playerUpdateCombatLog(Player plr) {
        Long currentStamp = System.currentTimeMillis();
        config.set("combatlog."+plr.getUniqueId(), currentStamp);
    }
}
