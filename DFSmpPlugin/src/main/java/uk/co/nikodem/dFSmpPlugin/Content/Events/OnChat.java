package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AntiSpamManager;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OnChat implements Listener {
    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e) {
        Player plr = e.getPlayer();

        long timestamp = AntiSpamManager.getPlayerCooldownTimestamp(plr, "silence");
        long threshold = timestamp + TimeUnit.MINUTES.toMillis(3);

        long timeleft = TimeUnit.MILLISECONDS.toMinutes(threshold - new Date().getTime()) + 1;

        if (new Date().getTime() <= threshold) {
            e.setCancelled(true);
            plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You are silenced for another "+(timeleft)+" "+(timeleft == 1 ? "minute!" : "minutes!")));
        }
    }
}
