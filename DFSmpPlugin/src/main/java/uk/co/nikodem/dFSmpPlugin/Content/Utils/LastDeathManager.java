package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import javax.annotation.Nullable;

public class LastDeathManager {
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

    public static Boolean playerGetLastDeathPvp(Player plr) {
        try {
            return ConfigManager.trackingData.getBoolean("lastdeath."+plr.getUniqueId()+".pvp");
        } catch (Error e) {
            return false;
        }
    }

    public static Long playerGetLastDeathTime(Player plr) {
        try {
            return ConfigManager.trackingData.getLong("lastdeath."+plr.getUniqueId()+".time");
        } catch (Error e) {
            return 0L;
        }
    }

    public static boolean playerGetUsedBack(Player plr) {
        try {
            return ConfigManager.trackingData.getBoolean("lastdeath."+plr.getUniqueId()+".used");
        } catch (Error e) {
            return false;
        }
    }

    @Nullable
    public static Location playerGetLastDeathLocation(Player plr) {
        try {
            return ConfigManager.trackingData.getLocation("lastdeath."+plr.getUniqueId()+".loc");
        } catch (Error e) {
            return null;
        }
    }

    public static void playerSetUsedBack(Player plr) {
        ConfigManager.trackingData.set("lastdeath."+plr.getUniqueId()+".used", true);
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }

    public static void playerSetLastDeath(PlayerDeathEvent e) {
        Player plr = e.getEntity();
        boolean pvp = false;
        if (e.getDamageSource().getCausingEntity() instanceof Player) {
            pvp = true;
        }
        playerSetLastDeath(plr, pvp);
    }

    public static void playerSetLastDeath(Player plr, Boolean pvp) {
        Long currentStamp = System.currentTimeMillis();
        ConfigManager.trackingData.set("lastdeath."+plr.getUniqueId()+".loc", plr.getLocation());
        ConfigManager.trackingData.set("lastdeath."+plr.getUniqueId()+".time", currentStamp);
        ConfigManager.trackingData.set("lastdeath."+plr.getUniqueId()+".pvp", pvp);
        ConfigManager.trackingData.set("lastdeath."+plr.getUniqueId()+".used", false);
        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);
    }
}
