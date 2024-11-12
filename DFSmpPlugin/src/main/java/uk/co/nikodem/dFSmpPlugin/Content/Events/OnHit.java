package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.BasicModeManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnHit implements Listener {
    FileConfiguration config;

    public OnHit(DFSmpPlugin plugin) {
        config = plugin.getConfig();
    }

    @EventHandler
    public void OnPlayerHit(EntityDamageByEntityEvent e) {
        if (BasicModeManager.basicMode) return;
        if (e.isCancelled()) return;
        if (e.getEntity() instanceof Player victim) {
            if (e.getDamager() instanceof Player attacker) {
                if (!CombatLoggingManager.playerInCombat(victim)) {
                    victim.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou are now in combat for "+config.get("combatlogtime")+" seconds! Logging off will result in death."));
                }
                if (!CombatLoggingManager.playerInCombat(attacker)) {
                    attacker.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou are now in combat for "+config.get("combatlogtime")+" seconds! Logging off will result in death."));
                }

                CombatLoggingManager.playerUpdateCombatLog(victim);
                CombatLoggingManager.playerUpdateCombatLog(attacker);
            }
        }
    }
}
