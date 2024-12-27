package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.FullArmourSet;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.SetBonuses;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.ArrayList;
import java.util.List;

public class OnWear {
    public static DFSmpPlugin plugin;

    public static void OnClickArmour(InventoryClickEvent e) {
        Player plr = (Player) e.getView().getPlayer();
        ItemStack i = e.getCursor();
        if (i != null) updateItem(plr, i);
        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.runTask(plugin, () -> {
//            updateArmourSetBonus(plr, i);
            nuclearUpdateInventory(plr);
        });
    }

    public static void OnRightClickArmour(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        Player plr = e.getPlayer();
        ItemStack i = e.getItem();
        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.runTask(plugin, () -> {updateArmourSetBonus(plr, i);
        updateItem(plr, plr.getInventory().getItemInMainHand());});
    }

    public static void removeItemSlotSetBonus(PlayerInventory inv, EquipmentSlot slot) {
        ItemStack i = inv.getItem(slot);
        if (i == null) return;
        ItemMeta im = i.getItemMeta();
        if (im == null) return;
        inv.setItem(slot, SetBonuses.RemoveSetBonusText(i));
    }

    public static void addItemSlotSetBonus(PlayerInventory inv, EquipmentSlot slot) {
        ItemStack i = inv.getItem(slot);
        if (i == null) return;
        ItemMeta im = i.getItemMeta();
        if (im == null) return;
        inv.setItem(slot, SetBonuses.ApplySetBonusText(i));
    }

    public static void nuclearUpdateInventory(Player plr) {
        // just scan the inventory cuz im lazy
        for (var i : plr.getInventory().getContents()) {
            if (i != null) updateItem(plr, i);
        }
    }

    public static void updateItem(Player plr, ItemStack i) {
        FullArmourSet set = FullArmourSet.getArmourSetEquipped(plr);
        if (set == null) {
            i.setItemMeta(SetBonuses.RemoveSetBonusText(i).getItemMeta());
            return;
        }
        if (set.itemInSet(i)) {
            i.setItemMeta(SetBonuses.ApplySetBonusText(i).getItemMeta());
        } else {
            i.setItemMeta(SetBonuses.RemoveSetBonusText(i).getItemMeta());
        }
    }

    public static void updateArmourSetBonus(Player plr, ItemStack i) {
        PlayerInventory inv = plr.getInventory();
        if (FullArmourSet.hasArmourSetEquippedWithSetBonus(inv)) {
            addItemSlotSetBonus(inv, EquipmentSlot.HEAD);
            addItemSlotSetBonus(inv, EquipmentSlot.CHEST);
            addItemSlotSetBonus(inv, EquipmentSlot.LEGS);
            addItemSlotSetBonus(inv, EquipmentSlot.FEET);
        } else {
            removeItemSlotSetBonus(inv, EquipmentSlot.HEAD);
            removeItemSlotSetBonus(inv, EquipmentSlot.CHEST);
            removeItemSlotSetBonus(inv, EquipmentSlot.LEGS);
            removeItemSlotSetBonus(inv, EquipmentSlot.FEET);
            i.setItemMeta(SetBonuses.RemoveSetBonusText(i).getItemMeta());
        }
    }

    public void updateArmourSetBonusItemless(Player plr) {
        PlayerInventory inv = plr.getInventory();
        if (FullArmourSet.hasArmourSetEquippedWithSetBonus(inv)) {
            addItemSlotSetBonus(inv, EquipmentSlot.HEAD);
            addItemSlotSetBonus(inv, EquipmentSlot.CHEST);
            addItemSlotSetBonus(inv, EquipmentSlot.LEGS);
            addItemSlotSetBonus(inv, EquipmentSlot.FEET);
        } else {
            removeItemSlotSetBonus(inv, EquipmentSlot.HEAD);
            removeItemSlotSetBonus(inv, EquipmentSlot.CHEST);
            removeItemSlotSetBonus(inv, EquipmentSlot.LEGS);
            removeItemSlotSetBonus(inv, EquipmentSlot.FEET);
        }
    }
}
