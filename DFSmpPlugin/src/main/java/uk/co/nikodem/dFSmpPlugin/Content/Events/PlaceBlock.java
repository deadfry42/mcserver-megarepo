package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CustomItemManager;

public class PlaceBlock implements Listener {
    @EventHandler
    public void plantWarpedWart(BlockPlaceEvent e) {
        if (CustomItemManager.IsItem(e.getItemInHand(), CustomItemManager.createWarpedWart())) {
            e.setCancelled(true);
        }
    }
}
