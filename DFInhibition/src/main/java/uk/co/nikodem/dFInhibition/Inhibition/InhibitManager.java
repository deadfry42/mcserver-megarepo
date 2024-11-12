package uk.co.nikodem.dFInhibition.Inhibition;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFInhibition.DFInhibition;

public class InhibitManager {
    private static FileConfiguration config;

    public InhibitManager(DFInhibition plugin) {
        config = plugin.getConfig();
    }

    public static void setKornelRespawned(Player plr) {
        config.set(plr.getUniqueId()+".ChatConfirm", false);
    }

    public static void setKornelConfirmed(Player plr) {
        config.set(plr.getUniqueId()+".ChatConfirm", true);
    }

    public static void userInteractError(Player plr) {
//        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4The SMP hasn't started yet!"));
    }

    public static void userCommandError(Player plr) {
        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Commands are currently disabled!"));
    }

    public static void userPvpError(Player plr) {
        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4PVP is currently disabled!"));
    }

    public static void userNetherError(Player plr) {
        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4The Nether is currently disabled!"));
    }

    public static void userEndError(Player plr) {
        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4The End is currently disabled!"));
    }

    public static void userJoinMessage(Player plr) {
        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3The SMP is currently in a Read-only state, as the SMP hasn't started yet."));
    }

    public static boolean isWorldLocked() {
        return config.getBoolean("locked");
    }

    public static boolean isPvpLocked() {
        if (isWorldLocked()) return true;
        return config.getBoolean("pvp");
    }

    public static boolean isNetherLocked() {
        return config.getBoolean("nether");
    }

    public static boolean isEndLocked() {
        return config.getBoolean("end");
    }
}
