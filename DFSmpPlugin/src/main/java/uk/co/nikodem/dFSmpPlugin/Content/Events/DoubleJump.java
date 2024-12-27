package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.DoubleJumpUtils;

public class DoubleJump implements Listener {

//    @EventHandler
//    public void onPlayerFly(PlayerToggleFlightEvent e) {
//        Player plr = e.getPlayer();
//        if (plr.getGameMode() == GameMode.CREATIVE
//        || plr.getGameMode() == GameMode.SPECTATOR) return;
//
//        if (DoubleJumpUtils.hasPlayerDoubleJumped(plr)) {
//            e.setCancelled(true);
//            return;
//        };
//        e.setCancelled(true);
//        plr.setAllowFlight(false);
//        plr.setFlying(false);
//        plr.setVelocity(new Vector(plr.getVelocity().getX()*2, 0.75, plr.getVelocity().getZ()*2));
//        plr.playSound(plr.getLocation(), Sound.ENTITY_BREEZE_WIND_BURST, 1F, 1F);
//        plr.getWorld().spawnParticle(Particle.ITEM_SNOWBALL, plr.getLocation(), 25);
//        plr.setFallDistance(0);
//        DoubleJumpUtils.setPlayerDoubleJumped(plr);
//    }
//
//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent e) {
//        Player plr = e.getPlayer();
//        if (plr.getGameMode() == GameMode.CREATIVE
//        || plr.getGameMode() == GameMode.SPECTATOR) return;
//        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.cloudInABottle, plr)) {
//            if (plr.getLocation().add(plr.getVelocity()).getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
//                if (DoubleJumpUtils.hasPlayerDoubleJumped(plr)) {
//                    plr.setAllowFlight(false);
//                } else {
//                    plr.setAllowFlight(true);
//                }
//            } else {
//                plr.setAllowFlight(false);
//                DoubleJumpUtils.setPlayerLanded(plr);
//            }
//        }
//    }
}
