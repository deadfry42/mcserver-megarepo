package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;

public class ExecuteCommand implements Listener {
    @EventHandler
    public void OnCommand(PlayerCommandPreprocessEvent e) {
        if (CombatLoggingManager.playerInCombat(e.getPlayer())) {
            if (e.getMessage().startsWith("/tpa") || e.getMessage().startsWith("/tpd")) {
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You are currently in combat!"));
                e.setCancelled(true);
            }
        }
    }
}
