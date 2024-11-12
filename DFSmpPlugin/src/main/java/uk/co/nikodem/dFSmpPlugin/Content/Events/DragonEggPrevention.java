package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.BasicModeManager;

public class DragonEggPrevention implements Listener {
    @EventHandler
    public void InventoryMovePrevention(InventoryClickEvent event) {
        if (BasicModeManager.basicMode) return;
        Inventory clicked = event.getClickedInventory();
        if (event.getClick().isShiftClick()) {
            if (clicked == event.getWhoClicked().getInventory()) {
                // The item is being shift clicked from the bottom to the top
                ItemStack clickedOn = event.getCurrentItem();

                if (clickedOn != null && (clickedOn.getType() == Material.DRAGON_EGG)) {
                    event.setCancelled(true);
                }
            }
        } else {
            if (clicked != event.getWhoClicked().getInventory()) { // Note: !=
                // The cursor item is going into the top inventory
                ItemStack onCursor = event.getCursor();

                if (onCursor != null && (onCursor.getType() == Material.DRAGON_EGG)){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void InventoryDragPrevention(InventoryDragEvent event) {
        if (BasicModeManager.basicMode) return;
        ItemStack dragged = event.getOldCursor(); // This is the item that is being dragged

        if (dragged.getType() == Material.DRAGON_EGG) {
            int inventorySize = event.getInventory().getSize(); // The size of the inventory, for reference

            for (int i : event.getRawSlots()) {
                if (i < inventorySize) {
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void InventoryDragPrevention(InventoryMoveItemEvent event) {
        if (BasicModeManager.basicMode) return;
        if (event.getItem().getType() == Material.DRAGON_EGG) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void HopperPickupPrevention(InventoryPickupItemEvent event) {
        if (BasicModeManager.basicMode) return;
        if (event.getInventory().getType() == InventoryType.HOPPER) {
            if (event.getItem().getItemStack().getType() == Material.DRAGON_EGG) event.setCancelled(true);
        }
    }

    @EventHandler
    public void ItemFramePrevention(PlayerInteractEntityEvent event) {
        if (BasicModeManager.basicMode) return;
        if (event.getRightClicked() instanceof ItemFrame) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.DRAGON_EGG) {
                event.setCancelled(true);
            }
        }
    }
}
