package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.SetBonuses;

public class OnDropItem implements Listener {
    @EventHandler
    public void OnDropItem(PlayerDropItemEvent e) {
        ItemStack item = e.getItemDrop().getItemStack();
        SetBonuses.RemoveSetBonusText(item);
    }
}
