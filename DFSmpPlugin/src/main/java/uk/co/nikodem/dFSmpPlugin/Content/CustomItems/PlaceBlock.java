package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlock {
    public static void plantWarpedWart(BlockPlaceEvent e) {
        if (CustomItemManager.IsItem(e.getItemInHand(), CustomItems.createWarpedWart())) {
            e.setCancelled(true);
        }
    }
}
