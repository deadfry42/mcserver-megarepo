package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerChange implements Listener {
    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent e) {
        Player plr = (Player) e.getEntity();
        if (SetBonuses.hasLeatherSet(plr.getInventory())) {
            if (e.getItem() == null) e.setCancelled(true);
        }
    }
}
