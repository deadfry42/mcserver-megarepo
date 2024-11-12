// REVISIT LATER MAYBE

//package uk.co.nikodem.dFSmpPlugin.Content.Events;
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.Material;
//import org.bukkit.entity.Item;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.inventory.*;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.Inventory;
//import org.bukkit.inventory.InventoryHolder;
//import org.bukkit.inventory.InventoryView;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;
//import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;
//
//import javax.annotation.Nullable;
//import javax.swing.*;
//import java.lang.reflect.Constructor;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class SmithingTable implements Listener {
//    private final DFSmpPlugin plugin;
//    private final int size = 9*6;
//    private final String id = "dfsmp-est";
//    private final String title = ChatColor.translateAlternateColorCodes('&', "&3Enchanted Smithing table");
//
//    private final Material[] allowedWeapons = new Material[] {
//            Material.WOODEN_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLDEN_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD, Material.TRIDENT,
//    };
//
//    public SmithingTable(DFSmpPlugin plugin) {
//        this.plugin = plugin;
//    }
//
//    @EventHandler
//    public void OnMenuClick(InventoryClickEvent e) {
//        Player plr = (Player) e.getWhoClicked();
//        ItemStack item = e.getCursor();
//        plr.sendMessage("Item "+e.getAction().toString()+" @ Slot "+e.getSlot());
//        if (!e.isLeftClick()) return;
//        if (e.getView().getOriginalTitle().equals(id)) { // the original title is the id
//            // is enchanted smithing table
//            if (e.getSlot() == InventoryLocation(5, 1)) {
//                if (e.getAction() == InventoryAction.PLACE_ALL) {
//                    if (checkIfItemIsCompatible(item)) {
//                        weaponPlaced(e.getView());
//                        return;
//                    } else {
//                        e.setCancelled(true);
//                        return;
//                    }
//                } else if (e.getAction() == InventoryAction.PICKUP_ALL) {
//                    weaponRemoved(e.getView());
//                    e.setCancelled(false);
//                    return;
//                }
//            } else if (e.getSlot() == InventoryLocation(4, 3)) {
////                Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL, "dfsmp-estrn");
////
////                InventoryView v = plr.openInventory(inv);
////                v.setTitle("Rename item");
//                new AnvilGUI.Builder()
//                        .onClose(stateSnapshot -> {
//                            stateSnapshot.getPlayer().sendMessage("aaa");
//                        })
//                        .onClick((slot, stateSnapshot) -> {
//                            if (slot != AnvilGUI.Slot.OUTPUT) {
//                                return Collections.emptyList();
//                            }
//
//                            if (stateSnapshot.getText().equalsIgnoreCase("you")) {
//                                stateSnapshot.getPlayer().sendMessage("AAAA");
//                                return Arrays.asList(AnvilGUI.ResponseAction.close());
//                            } else {
//                                return Arrays.asList(AnvilGUI.ResponseAction.replaceInputText("Try again"));
//                            }
//                        })
//                        .preventClose()
//                        .text("Rename item")
//                        .title("Rename item")
//                        .plugin(plugin)
//                        .open(plr);
//            } else if (e.getSlot() == InventoryLocation(6, 3)) {
//                Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL, "dfsmp-estsd");
//
//                InventoryView v = plr.openInventory(inv);
//                v.setTitle("Set description");
//            } else {
//                if (e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
//                    if (checkIfItemIsCompatible(item)) {
//                        weaponPlaced(e.getView());
//                        return;
//                    } else {
//                        e.setCancelled(true);
//                        return;
//                    }
//                }
//                if (e.getClickedInventory() == plr.getInventory()) return;
//            }
//            e.setCancelled(true);
//        }
//    }
//
//    private void weaponPlaced(InventoryView menu) {
//        ItemStack renameItem = new ItemStack(Material.OAK_SIGN);
//        ItemMeta rimeta = renameItem.getItemMeta();
//        rimeta.setDisplayName("Rename weapon");
//        renameItem.setItemMeta(rimeta);
//        menu.setItem(InventoryLocation(4, 3), renameItem);
//
//        ItemStack nameDescription = new ItemStack(Material.OAK_SIGN);
//        ItemMeta ndmeta = nameDescription.getItemMeta();
//        ndmeta.setDisplayName("Set the description");
//        nameDescription.setItemMeta(ndmeta);
//        menu.setItem(InventoryLocation(6, 3), nameDescription);
//    }
//
//    private void weaponRemoved(InventoryView menu) {
//        menu.setItem(InventoryLocation(4, 3), createInventoryBlank());
//        menu.setItem(InventoryLocation(6, 3), createInventoryBlank());
//    }
//
//    private boolean checkIfItemIsCompatible(@Nullable ItemStack item) {
//        if (item == null) return false;
//        for (Material weapon : allowedWeapons) {
//            if (item.getType() == weapon) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @EventHandler
//    public void OnInventoryClose(InventoryCloseEvent e) {
//        if (e.getView().getOriginalTitle().equals(id)) {
//            ItemStack item = e.getView().getItem(InventoryLocation(5, 1));
//            if (item == null) return;
//            Player plr = (Player) e.getPlayer();
//            plr.getInventory().addItem(item);
//        }
//    }
//
//    @EventHandler
//    public void OpenSmithingTable(PlayerInteractEvent e) {
//        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
//        if (e.getClickedBlock() == null) return;
//        if (e.getClickedBlock().getType().equals(Material.SMITHING_TABLE)) {
//            e.setCancelled(true);
//            Player plr = e.getPlayer();
//            Inventory menu = Bukkit.createInventory(null, size, id);
//            blankOutMenu(menu);
//            setItemAtLocation(menu, createBlankItem(), InventoryLocation(5, 1));
//            plr.openInventory(menu).setTitle(title);
//        }
//    }
//
//    private ItemStack createBlankItem() {
//        return new ItemStack(Material.AIR);
//    }
//
//    private ItemStack createInventoryBlank() {
//        ItemStack freeSlot = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
//        ItemMeta freeSlotMeta = freeSlot.getItemMeta();
//        assert freeSlotMeta != null;
//        freeSlotMeta.setDisplayName(ChatColor.DARK_GRAY+"");
//        freeSlotMeta.setCustomModelData(8008);
//        freeSlot.setItemMeta(freeSlotMeta);
//        return freeSlot;
//    }
//
//    private void blankOutMenu(Inventory menu) {
//        ItemStack freeSlot = createInventoryBlank();
//        for (int i = 0; i < size; i++) {
//            setItemAtLocation(menu, freeSlot, i);
//        }
//    }
//
//    private void setItemAtLocation(Inventory menu, ItemStack item, int location) {
//        menu.setItem(location, item);
//    }
//
//    private int InventoryLocation(int x, int y) {
//        int pos = ((y*9)+x)-1;
//        if (pos < 0) pos = 0;
//        else if (pos > size) pos = size;
//        return pos;
//    }
//}
