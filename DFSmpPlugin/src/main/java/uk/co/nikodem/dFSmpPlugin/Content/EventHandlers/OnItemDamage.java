package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

import java.util.List;

public class OnItemDamage implements Listener {
    @EventHandler
    public void OnItemDamage(PlayerItemDamageEvent e) {
        ItemStack i = e.getItem();
        boolean isItem = false;
        boolean isSword = false;
        if (CustomItemManager.IsItem(i, CustomItems.createWildBow())) {
            isItem = true;
            isSword = false;
        } else if (CustomItemManager.IsItem(i, CustomItems.createWildBowSword())) {
            isItem = true;
            isSword = true;
        }
        if (isItem) {
            Damageable dm = (Damageable) i.getItemMeta();
            if (dm == null) return;
            if (dm.getDamage() >= (i.getType().getMaxDurability()-1)) {
                // broken
                if (isSword) {
                    var bowDurability = dm.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "bowdurability"), PersistentDataType.INTEGER);
                    if (bowDurability == null || bowDurability > 0) {
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
                        dm.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "sworddurability"), PersistentDataType.INTEGER, -1);
                        if (dm.hasLore()) {
                            List<String> lores = dm.getLore();
                            lores.add(ChatColor.translateAlternateColorCodes('&', "&4Sword destroyed"));
                            dm.setLore(lores);
                        }
                        i.setItemMeta(dm);
                        e.setCancelled(true);
                        CustomItems.convertToWildBow(i, false);
                    }
                } else {
                    var swordDurability = dm.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "sworddurability"), PersistentDataType.INTEGER);
                    if (swordDurability == null || swordDurability > 0) {
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
                        dm.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "bowdurability"), PersistentDataType.INTEGER, -1);
                        if (dm.hasLore()) {
                            List<String> lores = dm.getLore();
                            lores.add(ChatColor.translateAlternateColorCodes('&', "&4Bow destroyed"));
                            dm.setLore(lores);
                        }
                        i.setItemMeta(dm);
                        e.setCancelled(true);
                        CustomItems.convertToWildBowSword(i, false);
                    }
                }
            }
        }
    }
}
