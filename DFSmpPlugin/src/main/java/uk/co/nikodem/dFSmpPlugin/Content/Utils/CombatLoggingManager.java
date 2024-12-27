package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Objects;

public class CombatLoggingManager {

    // TODO: Rewrite this to not use config files

    public static int getLogTime() {
        Integer logTime = (Integer) ConfigManager.trackingData.get("combatlogtime");
        return logTime == null ? 30 : logTime;
    }

    public static boolean playerInCombat(Player plr) {
        Long logTime = getLogTime()*1000L;
        Long currentStamp = System.currentTimeMillis();
        Long plrLastStamp = ConfigManager.trackingData.getLong("combatlog."+plr.getUniqueId()+".time");
        return !(currentStamp > (plrLastStamp+logTime));
    }

    public static Long getPlayerCombatTimestamp(Player plr) {
        return ConfigManager.trackingData.getLong("combatlog."+plr.getUniqueId()+".time");
    }

    @Nullable
    public static Player getPlayerLastTag(Player plr) {
        String uuid = getPlayerUUIDLastTag(plr);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (Objects.equals(player.getUniqueId().toString(), uuid)) return player;
        }
        return null;
    }

    public static String getPlayerUUIDLastTag(Player plr) {
        return ConfigManager.trackingData.getString("combatlog."+plr.getUniqueId()+".lastTag");
    }

    public static void playerRemoveCombatLog(Player plr) {
        ConfigManager.trackingData.set("combatlog."+plr.getUniqueId()+".time", 0);
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }

    public static void playerSetLastTag(Player plr, Player attacker) {
        ConfigManager.trackingData.set("combatlog."+plr.getUniqueId()+".lastTag", attacker.getUniqueId().toString());
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }

    public static void playerUpdateCombatLog(Player plr) {
        Long currentStamp = System.currentTimeMillis();
        ConfigManager.trackingData.set("combatlog."+plr.getUniqueId()+".time", currentStamp);
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }
}
