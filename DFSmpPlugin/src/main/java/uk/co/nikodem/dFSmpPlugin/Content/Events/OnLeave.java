package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.BasicModeManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnLeave implements Listener {
    FileConfiguration config;

    public OnLeave(DFSmpPlugin plugin) {
        config = plugin.getConfig();
    }

    @EventHandler
    public void OnPlayerLeave(PlayerQuitEvent e) {
        if (BasicModeManager.isBasicMode()) return;
        Player plr = e.getPlayer();
        if (CombatLoggingManager.playerInCombat(plr)) {
            plr.setHealth(0);
            CombatLoggingManager.playerRemoveCombatLog(plr);
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&4"+plr.getDisplayName()+" has combat logged! They have subsequently died."));
        }
    }
}
