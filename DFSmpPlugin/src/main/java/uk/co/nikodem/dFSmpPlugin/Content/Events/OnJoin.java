package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnJoin implements Listener {
    public final DFSmpPlugin plugin;

    public OnJoin(DFSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        plugin.vr.discoverRecipes(e.getPlayer());
        plugin.cir.discoverRecipes(e.getPlayer());
    }
}
