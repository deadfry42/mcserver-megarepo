package uk.co.nikodem.dFSmpPlugin.Content.Accessories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccessoryGUI {

    public static DFSmpPlugin plugin;

    public static int size = 9*3;
    public static int rows = 3;

    public static int InventoryLocation(int x, int y) {
        int pos = ((y*9)+x)-1;
        if (pos < 0) pos = 0;
        else if (pos >= (9*rows)) pos = (9*rows)-1;
        return pos;
    }

    public static ItemStack createInventoryBlank() {
        ItemStack freeSlot = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta freeSlotMeta = freeSlot.getItemMeta();
        assert freeSlotMeta != null;
        freeSlotMeta.setDisplayName(ChatColor.DARK_GRAY+"");
        freeSlotMeta.setCustomModelData(8008);
        freeSlot.setItemMeta(freeSlotMeta);
        return freeSlot;
    }

    public static Inventory createInventory(String id) {
        Inventory inv = Bukkit.createInventory(null, size, id);

        ItemStack blank = createInventoryBlank();

        for (int i = 0; i < size; i++) {
            inv.setItem(i, blank);
        }

        return inv;
    }

    public static void PostViewInventory(InventoryView view) {
        String id = view.getOriginalTitle();
        if (id.equals("accessory")) {
            view.setTitle("Accessories");
            Player plr = (Player) view.getPlayer();

            ItemStack guide = new ItemStack(Material.MAP);
            ItemMeta im = guide.getItemMeta();
            assert im != null;
            im.setDisplayName("Help");
            List<String> lores = new ArrayList<>();
            lores.add("These are your 3 accessory slots.");
            lores.add("You can put whatever combination of accessories you like in these slots.");
            lores.add("Accessories give you certain abilities.");
            lores.add("Click on an accessory in your inventory to equip it");
            lores.add("Click on an accessory in the menu to unequip it.");
            im.setLore(lores);
            guide.setItemMeta(im);
            view.setItem(InventoryLocation(9, 2), guide);

            view.setItem(InventoryLocation(3, 1), null);
            view.setItem(InventoryLocation(5, 1), null);
            view.setItem(InventoryLocation(7, 1), null);

            boolean one = AccessoryManager.isSlotTaken(AccessoryManager.Slot.ONE, plr);
            boolean two = AccessoryManager.isSlotTaken(AccessoryManager.Slot.TWO, plr);
            boolean three = AccessoryManager.isSlotTaken(AccessoryManager.Slot.THREE, plr);

            if (one) {
                view.setItem(InventoryLocation(3, 1), AccessoryManager.getAccessoryItemFromSlot(AccessoryManager.Slot.ONE, plr));
            }

            if (two) {
                view.setItem(InventoryLocation(5, 1), AccessoryManager.getAccessoryItemFromSlot(AccessoryManager.Slot.TWO, plr));
            }

            if (three) {
                view.setItem(InventoryLocation(7, 1), AccessoryManager.getAccessoryItemFromSlot(AccessoryManager.Slot.THREE, plr));
            }
        }
    }

    public static void SetSlotSanitised(InventoryView view, AccessoryManager.Slot slot, ItemStack item) {
        ItemStack sanitised = new ItemStack(item.getType());
        sanitised.setItemMeta(item.getItemMeta());

        sanitised.setAmount(1);
        view.setItem(
                SlotToLocation(slot),
                sanitised
        );
    }

    public static void ClickInventory(InventoryClickEvent e) {
        Player plr = (Player) e.getWhoClicked();
        InventoryView view = e.getView();
        String id = view.getOriginalTitle();
        if (id.equals("accessory")) {
            e.setCancelled(true);
            int slot = e.getSlot();
            if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
                // bottom inv (player inv)
                Inventory bottomInv = e.getClickedInventory();
                ItemStack item = bottomInv.getItem(slot);
                if (item != null) {
//                    playClickSound(plr);
                    var accessoryId = CustomItemManager.getAccessoryId(item);
                    if (accessoryId != null) {
                        AccessoryManager.Slot availableSlot = AccessoryManager.getNextAvailableSlot(plr);
                        if (availableSlot == null) {
                            playWarningSound(plr);
                        } else {
                            if (AccessoryManager.playerHasAccessoryEquipped(accessoryId, plr)) {
                                playWarningSound(plr);
                            } else {
                                boolean res = AccessoryManager.setAccessoryInSlot(availableSlot, item, plr);
                                if (res) {
                                    if (!plugin.ca.EquipAccessory.isGranted(plr)) plugin.ca.EquipAccessory.grant(plr);
                                    SetSlotSanitised(view, availableSlot, item);
                                    item.setAmount(item.getAmount() - 1);
                                    playSucceedSound(plr);
                                } else {
                                    playWarningSound(plr);
                                }
                            }
                        }
                    } else {
                        playWarningSound(plr);
                    }
                }
            } else {
                // top inv (accessory)
                AccessoryManager.Slot chosenSlot = null;
                if (slot == InventoryLocation(3, 1)) {
                    chosenSlot = AccessoryManager.Slot.ONE;
                } else if (slot == InventoryLocation(5, 1)) {
                    chosenSlot = AccessoryManager.Slot.TWO;
                } else if (slot == InventoryLocation(7, 1)) {
                    chosenSlot = AccessoryManager.Slot.THREE;
                }

                if (chosenSlot != null) {
//                    playClickSound(plr);
                    if (AccessoryManager.isSlotTaken(chosenSlot, plr)) {
                        // slot has something in it
                        if (getEmptyInventorySlots(plr) > 0) {
                            // has enough room for a new item to be added
                            ItemStack accessory = AccessoryManager.getAccessoryItemFromSlot(chosenSlot, plr);
                            AccessoryManager.removeAccessoryInSlot(chosenSlot, plr);

                            view.setItem(slot, null);
                            plr.getInventory().addItem(accessory);
                            playSucceedSound(plr);
                        } else {
                            playWarningSound(plr);
                        }
                    } else {
                        playWarningSound(plr);
                    }
                } else {
                    playWarningSound(plr);
                }
            }
        }
    }

    public static int getEmptyInventorySlots(Player plr) {
        int emptySlots = 0;
        for (var item : plr.getInventory().getContents()) {
            if (item == null) emptySlots++;
        }
        return emptySlots;
    }

    public static int SlotToLocation(AccessoryManager.Slot slot) {
        if (slot == AccessoryManager.Slot.ONE) {
            return InventoryLocation(3, 1);
        } else if (slot == AccessoryManager.Slot.TWO) {
            return InventoryLocation(5, 1);
        } else if (slot == AccessoryManager.Slot.THREE) {
            return InventoryLocation(7, 1);
        } else {
            return 0;
        }
    }

    public static void playClickSound(Player plr) {
        plr.playSound(
                plr,
                Sound.UI_BUTTON_CLICK,
                1F,
                1F
        );
    }

    public static void playSucceedSound(Player plr) {
        plr.playSound(
                plr,
                Sound.ITEM_ARMOR_EQUIP_LEATHER,
                1F,
                1F
        );
    }

    public static void playWarningSound(Player plr) {
        plr.playSound(
                plr,
                Sound.BLOCK_NOTE_BLOCK_BASS,
                1F,
                1F
        );
    }

    public static void OpenAccessoriesGUI(Player plr) {
        PostViewInventory(Objects.requireNonNull(plr.openInventory(createInventory("accessory"))));
    }
}
