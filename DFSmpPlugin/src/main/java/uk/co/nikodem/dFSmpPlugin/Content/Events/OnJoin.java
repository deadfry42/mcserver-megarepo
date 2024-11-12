package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import uk.co.nikodem.dFSmpPlugin.Content.Utils.RecipeCreator;

public class OnJoin implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        RecipeCreator.discoverRecipes(e.getPlayer());
    }
}
