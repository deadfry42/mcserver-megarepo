package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;

import javax.annotation.Nullable;

public class AccessoryManager {

    public enum Slot {
        ONE,
        TWO,
        THREE,
    }

    public static String convertToString(Slot slot) {
        if (slot == Slot.ONE) {
            return "one";
        } else if (slot == Slot.TWO) {
            return "two";
        } else if (slot == Slot.THREE) {
            return "three";
        } else {
            return "undefined";
        }
    }

    public static boolean playerHasAccessoryEquipped(AccessoryData data, Player plr) {
        if (playerGetAccessoryId(Slot.ONE, plr) == data.getId()) {
            return true;
        } else if (playerGetAccessoryId(Slot.TWO, plr) == data.getId()) {
            return true;
        } else if (playerGetAccessoryId(Slot.THREE, plr) == data.getId()) {
            return true;
        }

        return false;
    }

    public static boolean playerHasAccessoryEquipped(int id, Player plr) {
        if (playerGetAccessoryId(Slot.ONE, plr) == id) {
            return true;
        } else if (playerGetAccessoryId(Slot.TWO, plr) == id) {
            return true;
        } else if (playerGetAccessoryId(Slot.THREE, plr) == id) {
            return true;
        }

        return false;
    }

    @Nullable
    public static AccessoryData getAccessoryDataFromSlot(Slot slot, Player plr) {
        int id = playerGetAccessoryId(slot, plr);
        for (AccessoryData data : AccessoryData.accessories) {
            if (data.getId() == id) {
                return data;
            }
        }
        return null;
    }

    @Nullable
    public static AccessoryData getAccessoryDataFromItem(ItemStack i, Player plr) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return null;

        var id = im.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "isaccessory"), PersistentDataType.INTEGER);

        if (id == null) return null;

        for (AccessoryData data : AccessoryData.accessories) {
            if (data.getId() == id) {
                return data;
            }
        }
        return null;
    }

    @Nullable
    public static ItemStack getAccessoryItemFromSlot(Slot slot, Player plr) {
        AccessoryData data = getAccessoryDataFromSlot(slot, plr);
        String name = playerGetAccessoryName(slot, plr);
        String uuid = playerGetAccessoryUUID(slot, plr);
        boolean renamed = playerGetAccessoryRenamed(slot, plr);
        if (data == null) {
            return null;
        }
        ItemStack i = data.getAccessoryItem();
        ItemMeta im = i.getItemMeta();
        if (im == null) {
            return null;
        }
        if (renamed) im.setDisplayName(name);
        else im.setDisplayName(ChatColor.RESET + name);
        i.setItemMeta(im);
        CustomItemManager.addUUIDToItem(i, uuid);
        if (CustomItemManager.isMarkedForUUID(i)) {
            CustomItemManager.removeMarkedForUUID(i);
        }
        return i;
    }

    public static boolean isSlotTaken(Slot slot, Player plr) {
        if (slot == Slot.ONE && playerGetAccessoryId(slot, plr) != 0) {
            return true;
        } else if (slot == Slot.TWO && playerGetAccessoryId(slot, plr) != 0) {
            return true;
        } else if (slot == Slot.THREE && playerGetAccessoryId(slot, plr) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Slot getNextAvailableSlot(Player plr) {
        if (playerGetAccessoryId(Slot.ONE, plr) == 0) {
            return Slot.ONE;
        } else if (playerGetAccessoryId(Slot.TWO, plr) == 0) {
            return Slot.TWO;
        } else if (playerGetAccessoryId(Slot.THREE, plr) == 0) {
            return Slot.THREE;
        } else {
            return null;
        }
    }

    public static int playerGetAccessoryId(Slot slot, Player plr) {
        try {
            return ConfigManager.accessoryData.getInt(plr.getUniqueId()+".slots."+convertToString(slot)+".id");
        } catch (Error e) {
            return 0;
        }
    }

    public static boolean playerGetAccessoryRenamed(Slot slot, Player plr) {
        try {
            return ConfigManager.accessoryData.getBoolean(plr.getUniqueId()+".slots."+convertToString(slot)+".renamed");
        } catch (Error e) {
            return false;
        }
    }

    public static String playerGetAccessoryName(Slot slot, Player plr) {
        try {
            return ConfigManager.accessoryData.getString(plr.getUniqueId()+".slots."+convertToString(slot)+".name");
        } catch (Error e) {
            return "";
        }
    }

    public static String playerGetAccessoryUUID(Slot slot, Player plr) {
        try {
            return ConfigManager.accessoryData.getString(plr.getUniqueId()+".slots."+convertToString(slot)+".uuid");
        } catch (Error e) {
            return "";
        }
    }

    public static void removeAccessoryInSlot(Slot slot, Player plr) {
        ConfigManager.accessoryData.set(plr.getUniqueId()+".slots."+convertToString(slot), null);
        ConfigManager.saveData(ConfigManager.DataFiles.ACCESSORY);
    }

    public static boolean setAccessoryInSlot(Slot slot, ItemStack i, Player plr) {
        var id = CustomItemManager.getAccessoryId(i);
        if (id == null) {
            return false;
        }

        AccessoryData data = getAccessoryDataFromItem(i, plr);
        if (data == null) {
            return false;
        }

        ItemMeta im = i.getItemMeta();
        if (im == null) {
            return false;
        }

        boolean renamed = false;

        String name = im.getDisplayName();
        if (!name.equals(data.getName())) renamed = true;

        String uuid = CustomItemManager.getItemUUID(i);

        return setAccessoryInSlot(slot, id, name, uuid, renamed, plr);
    }

    public static boolean hasConflictingAccessoryEquipped(AccessoryData data, Player plr) {
        return hasConflictingAccessoryEquipped(data.getId(), plr);
    }

    public static boolean hasConflictingAccessoryEquipped(int id, Player plr) {
        AccessoryData slot1 = getAccessoryDataFromSlot(Slot.ONE, plr);
        if (slot1 != null) {
            if (slot1.getConflicts().contains(id)) return true;
        }
        AccessoryData slot2 = getAccessoryDataFromSlot(Slot.TWO, plr);
        if (slot2 != null) {
            if (slot2.getConflicts().contains(id)) return true;
        }
        AccessoryData slot3 = getAccessoryDataFromSlot(Slot.THREE, plr);
        if (slot3 != null) {
            if (slot3.getConflicts().contains(id)) return true;
        }
        return false;
    }

    public static boolean setAccessoryInSlot(Slot slot, int id, String name, String uuid, boolean renamed, Player plr) {
        try {
            if (hasConflictingAccessoryEquipped(id, plr)) return false;
            ConfigManager.accessoryData.set(plr.getUniqueId()+".slots."+convertToString(slot)+".id", id);
            ConfigManager.accessoryData.set(plr.getUniqueId()+".slots."+convertToString(slot)+".name", name);
            ConfigManager.accessoryData.set(plr.getUniqueId()+".slots."+convertToString(slot)+".renamed", renamed);
            ConfigManager.accessoryData.set(plr.getUniqueId()+".slots."+convertToString(slot)+".uuid", uuid);
            ConfigManager.saveData(ConfigManager.DataFiles.ACCESSORY);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public static void dropAccessorySlot(Slot slot, Player plr) {
        if (isSlotTaken(slot, plr)) {
            ItemStack i = getAccessoryItemFromSlot(slot, plr);
            if (i != null) {
                AccessoryManager.removeAccessoryInSlot(slot, plr);
                plr.getWorld().dropItem(plr.getLocation(), i);
            }
        }
    }

    public static void dropAccessories(Player plr) {
        dropAccessorySlot(Slot.ONE, plr);
        dropAccessorySlot(Slot.TWO, plr);
        dropAccessorySlot(Slot.THREE, plr);
    }

    @Nullable
    public static ItemStack removeAccessorySlot(Slot slot, Player plr) {
        if (isSlotTaken(slot, plr)) {
            ItemStack i = getAccessoryItemFromSlot(slot, plr);
            if (i != null) {
                AccessoryManager.removeAccessoryInSlot(slot, plr);
                return i;
            } else {
                return null;
            }
        }
        return null;
    }

    public static ItemStack[] removeAllAccessories(Player plr) {
        ItemStack[] res = new ItemStack[3];

        res[0] = removeAccessorySlot(Slot.ONE, plr);
        res[1] = removeAccessorySlot(Slot.TWO, plr);
        res[2] = removeAccessorySlot(Slot.THREE, plr);

        return res;
    }
}
