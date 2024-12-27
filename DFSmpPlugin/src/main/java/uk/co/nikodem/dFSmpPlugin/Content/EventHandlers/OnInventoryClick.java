package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.InventoryView;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryGUI;
import uk.co.nikodem.dFSmpPlugin.Content.Events.OnWear;

public class OnInventoryClick implements Listener {
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        OnWear.OnClickArmour(e);

        AccessoryGUI.ClickInventory(e);

//        InventoryView v = e.getView();
//        String id = v.getOriginalTitle();
//
//        if (id.startsWith("accessory")) {
//            e.setCancelled(true);
//        }
    }
}
