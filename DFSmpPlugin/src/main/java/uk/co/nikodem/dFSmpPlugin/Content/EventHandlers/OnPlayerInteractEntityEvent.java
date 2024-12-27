package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.ItemUse;

public class OnPlayerInteractEntityEvent implements Listener {
    @EventHandler
    public void OnPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
        ItemUse.OnEntityBucketUse(e);
    }
}
