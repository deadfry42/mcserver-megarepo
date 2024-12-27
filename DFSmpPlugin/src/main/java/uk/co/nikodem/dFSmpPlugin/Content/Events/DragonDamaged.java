package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;

public class DragonDamaged implements Listener {
    @EventHandler
    public void DragonDamaged(EntityDamageEvent e) {
        if (e.getEntity() instanceof EnderDragon) {
            if (e.getDamageSource().getCausingEntity() == null) {
                e.setCancelled(true);
            }
        } else if (e.getEntity() instanceof Player plr) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.luckyHorseshoe, plr)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
