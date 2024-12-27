package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.HungerChange;

public class OnHungerChange implements Listener {
    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent e) {
        HungerChange.onHungerDeplete(e);
    }
}
