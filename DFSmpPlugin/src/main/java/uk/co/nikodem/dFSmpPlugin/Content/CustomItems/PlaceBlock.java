package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlock implements Listener {
    @EventHandler
    public void plantWarpedWart(BlockPlaceEvent e) {
        if (CustomItemManager.IsItem(e.getItemInHand(), CustomItemManager.createWarpedWart())) {
            e.setCancelled(true);
        }
    }
}
