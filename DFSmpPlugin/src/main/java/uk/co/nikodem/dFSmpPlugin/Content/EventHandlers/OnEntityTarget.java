package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;

public class OnEntityTarget implements Listener {
    @EventHandler
    public void OnEntityTarget(EntityTargetEvent e) {
        Entity target = e.getTarget();

        if (target instanceof Player plr) {
            if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.phantomRepellant, plr)) {
                if (e.getEntity().getType() == EntityType.PHANTOM) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
