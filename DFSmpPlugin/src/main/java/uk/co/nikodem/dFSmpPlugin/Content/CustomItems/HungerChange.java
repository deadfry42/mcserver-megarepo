package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerChange {
    public static void onHungerDeplete(FoodLevelChangeEvent e) {
        // yes, technically this means the hunger effect doesn't deplete hunger
        // i guess thats one more reason to use leather armour
        Player plr = (Player) e.getEntity();
        if (FullArmourSet.Leather.playerHasEquipped(plr)) {
            if (e.getItem() == null) e.setCancelled(true);
        }
    }
}
