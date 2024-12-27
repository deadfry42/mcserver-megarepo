package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.PlaceBlock;

public class OnPlaceBlock implements Listener {
    @EventHandler
    public void OnPlaceBlock(BlockPlaceEvent e) {
        PlaceBlock.plantWarpedWart(e);
    }
}
