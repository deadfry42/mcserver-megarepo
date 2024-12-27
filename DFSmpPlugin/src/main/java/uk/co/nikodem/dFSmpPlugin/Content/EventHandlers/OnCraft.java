package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.FullArmourSet;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnCraft implements Listener {

    public final DFSmpPlugin plugin;

    public OnCraft(DFSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void beforeCraft(PrepareItemCraftEvent event) {
        ItemStack resultItem = event.getInventory().getResult();
        if (resultItem == null) {
            return;
        }

        if (CustomItemManager.isMarkedForUUID(resultItem)) {
            CustomItemManager.removeMarkedForUUID(resultItem);
            CustomItemManager.addUUIDToItem(resultItem);
        }
    }

    @EventHandler
    public void OnPrepareSmithing(PrepareSmithingEvent e) {
        for (FullArmourSet set : FullArmourSet.armourSets) {
            if (set.isCustom()) {
                if (set.itemInSet(e.getResult())) e.setResult(null);
            }
        }
    }

    @EventHandler
    public void OnCraft(CraftItemEvent e) {
        ItemStack item = e.getCurrentItem();
        Player plr = (Player) e.getWhoClicked();
        if (CustomItemManager.IsItem(item, CustomItems.createVeinAxe())
        || CustomItemManager.IsItem(item, CustomItems.createVeinPickaxe())) {
            if (!plugin.ca.FirstVeinTool.isGranted(plr)) {
                plugin.ca.FirstVeinTool.grant(plr);
            }
        }
        else if (CustomItemManager.IsItem(item, CustomItems.createBluebellsarStick())) {
            if (!plugin.ca.TrueBluebellsar.isGranted(plr)) {
                plugin.ca.TrueBluebellsar.grant(plr);
            }
        }
        else if (CustomItemManager.IsItem(item, CustomItems.createAutosmeltHelmet())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltChestplate())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltLeggings())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltBoots())

        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltSword())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltAxe())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltPickaxe())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltShovel())
        || CustomItemManager.IsItem(item, CustomItems.createAutosmeltHoe())) {
            if (!plugin.ca.FirstAutosmeltTool.isGranted(plr)) {
                plugin.ca.FirstAutosmeltTool.grant(plr);
            }
        }
    }

//    @EventHandler
//    public void OnObtain(InventoryClickEvent e) {
//        ItemStack item = e.get().getItemStack();
//        Player plr = (Player) e.getInventory().getHolder();
//
//        if (CustomItemManager.IsItem(item, CustomItems.createAutosmeltSword())
//                || CustomItemManager.IsItem(item, CustomItems.createAutosmeltAxe())
//                || CustomItemManager.IsItem(item, CustomItems.createAutosmeltPickaxe())
//                || CustomItemManager.IsItem(item, CustomItems.createAutosmeltShovel())
//                || CustomItemManager.IsItem(item, CustomItems.createAutosmeltHoe())) {
//            if (!plugin.ca.FirstAutosmeltTool.isGranted(plr)) {
//                plugin.ca.FirstAutosmeltTool.grant(plr);
//            }
//        }
//    }

//    @EventHandler
//    public void OnSmelt(FurnaceSmeltEvent e) {
//        ItemStack item = e.getResult();
//
//    }
}
