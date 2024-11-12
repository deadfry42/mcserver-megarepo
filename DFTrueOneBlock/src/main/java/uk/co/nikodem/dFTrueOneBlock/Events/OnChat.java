package uk.co.nikodem.dFTrueOneBlock.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import uk.co.nikodem.dFTrueOneBlock.DFTrueOneBlock;

import java.util.List;

import static uk.co.nikodem.dFTrueOneBlock.Menus.GuiHelper.playClickSound;

public class OnChat implements Listener {
    private final DFTrueOneBlock plugin;

    public OnChat(DFTrueOneBlock plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerInputWorldName(AsyncPlayerChatEvent e) {
        Player plr = e.getPlayer();
        if (plr.hasMetadata("customNameChatType")) {
            e.setCancelled(true);
            plr.sendMessage("> "+e.getMessage());
            if (e.getMessage().length() > 30) {
                plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4That name is too long!"));
                return;
            }
            List<MetadataValue> values = plr.getMetadata("customNameChatType");
            String worldNumber = (!values.isEmpty()) ? values.get(0).asString() : null;
            List<MetadataValue> values2 = plr.getMetadata("uiStartCode");
            String uiStartCode = (!values2.isEmpty()) ? values2.get(0).asString() : null;
            plr.removeMetadata("customNameChatType", plugin);
            plr.removeMetadata("uiStartCode", plugin);
            plr.setMetadata("customNameChatResponse", new FixedMetadataValue(plugin, e.getMessage()));
            BukkitRunnable runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    playClickSound(plr);
                    plugin.mm.OpenMenu(plr, uiStartCode+worldNumber);
                }
            };
            runnable.runTask(plugin);
        }
    }
}
