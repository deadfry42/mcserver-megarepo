package uk.co.nikodem.dFSmpPlugin.Content.EventHandlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.ItemUse;
import uk.co.nikodem.dFSmpPlugin.Content.Events.OnWear;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;

public class OnPlayerInteract implements Listener {
    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent e) {
        OnWear.OnRightClickArmour(e);
        ItemUse.OnLeftClick(e);
        ItemUse.OnRightClick(e);

        // flower boots

        Player plr = e.getPlayer();
        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.flowerBoots, plr)) {
            if (e.getAction() == Action.PHYSICAL) {
                if (e.getClickedBlock().getType() == Material.FARMLAND) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
