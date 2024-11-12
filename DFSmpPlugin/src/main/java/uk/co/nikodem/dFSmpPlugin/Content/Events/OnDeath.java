package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.BasicModeManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnDeath implements Listener {
    FileConfiguration config;

    public OnDeath(DFSmpPlugin plugin) {
        config = plugin.getConfig();
    }

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent e) {
        if (BasicModeManager.basicMode) return;
        Player plr = e.getEntity();
        if (CombatLoggingManager.playerInCombat(plr)) {
            CombatLoggingManager.playerRemoveCombatLog(plr);
            plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2You are no longer in combat!"));
        }
    }
}
