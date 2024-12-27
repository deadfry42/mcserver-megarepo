package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.BreakBlock;

public class OnBreakBlock implements Listener {
    @EventHandler
    public void OnBreakBlock(BlockBreakEvent e) {
        BreakBlock.onBlockBreak(e);
    }
}
