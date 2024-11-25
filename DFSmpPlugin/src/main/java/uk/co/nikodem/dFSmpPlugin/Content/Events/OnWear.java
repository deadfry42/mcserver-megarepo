package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.SetBonuses;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnWear implements Listener {
    public final DFSmpPlugin plugin;

    public OnWear(DFSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player plr = (Player) e.getView().getPlayer();
        ItemStack i = e.getCursor();
        updateItem(plr, i);
        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.runTask(plugin, () -> {updateArmourSetBonus(plr, i);});
    }

    @EventHandler
    public void OnRightClickArmour(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        updateArmourSetBonus(e.getPlayer(), e.getItem());
    }


    public void removeItemSlotSetBonus(PlayerInventory inv, EquipmentSlot slot) {
        ItemStack i = inv.getItem(slot);
        if (i == null) return;
        ItemMeta im = i.getItemMeta();
        if (im == null) return;
        inv.setItem(slot, SetBonuses.RemoveSetBonusText(i));
    }

    public void addItemSlotSetBonus(PlayerInventory inv, EquipmentSlot slot) {
        ItemStack i = inv.getItem(slot);
        if (i == null) return;
        ItemMeta im = i.getItemMeta();
        if (im == null) return;
        inv.setItem(slot, SetBonuses.ApplySetBonusText(i));
    }

    public void updateItem(Player plr, ItemStack i) {
        PlayerInventory inv = plr.getInventory();
        if (SetBonuses.hasSetBonus(inv)) {
            i.setItemMeta(SetBonuses.ApplySetBonusText(i).getItemMeta());
        } else {
            i.setItemMeta(SetBonuses.RemoveSetBonusText(i).getItemMeta());
        }
    }

    public void updateArmourSetBonus(Player plr, ItemStack i) {
        PlayerInventory inv = plr.getInventory();
        if (SetBonuses.hasSetBonus(inv)) {
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
        if (SetBonuses.hasSetBonus(inv)) {
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
